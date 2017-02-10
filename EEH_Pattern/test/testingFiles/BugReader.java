package testingFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import testingFiles.BugList;

/**
 * Processes the given XML file and creates collections of
 * {@link Bug}s.
 * If there is any problems when processing a questions XML file,
 * a {@link BugIOException} is thrown.
 * 
 * @author Dr. Sarah Heckman (heckman@csc.ncsu.edu)
 */
public class BugReader {
	/** Name of the XML file to process */
	private String fileName;
	/** Collection of Questions */
	private BugList list;
	
	/**
	 * Creates a BugReader for the given filename and
	 * starts processing the bug file.  If there is a problem
	 * processing the file, a {@link BugIOException} is thrown.
	 * @param fileName name of file to process
	 * @throws BugIOException thrown when problem processing file
	 */
	public BugReader(String fileName) throws BugIOException {
		this.fileName = fileName;
		
		processFile();
		
		checkItems();
	}
	
	/**
	 * Returns a list of {@link Bug}s.
	 * @return a list of {@link Bug}s.
	 */
	public List<Bug> getBugs() {
		return list.getBug();
	}
	
	/**
	 * Processes the bug file using the JAXB unmarshaller.  If
	 * there is a problem processing the file, a {@link BugIOException}
	 * is thrown
	 * @throws BugIOException thrown when problem processing file
	 */
	@SuppressWarnings("unchecked")
	private void processFile() throws BugIOException {
        JAXBElement<BugList> element = null;
		try {
			String packageName = this.getClass().getPackage().getName();
			JAXBContext jc = JAXBContext.newInstance( packageName );
		    Unmarshaller u = jc.createUnmarshaller();
			element = (JAXBElement<BugList>)u.unmarshal(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {
			throw new BugIOException(e.getMessage());
		} catch (JAXBException e) {
			throw new BugIOException(e.getMessage());
		} catch (Exception e) {
			throw new BugIOException(e.getMessage());
		}
        this.list = element.getValue();
	}
	
	/**
	 * Checks that the bugs are all valid.
	 * 
	 * @throws BugIOException if any question is invalid
	 */
	private void checkItems() throws BugIOException {
		List<Bug> bugs = getBugs();
		
		if (bugs == null) throw new BugIOException();
		
		for (int i = 0; i < bugs.size(); i++) {
			Bug b = bugs.get(i);
			if (b.getId() < 0) throw new BugIOException();
			if (b.getState() == null) throw new BugIOException();
			if (b.getSummary() == null) throw new BugIOException();
			if (b.getReporter() == null) throw new BugIOException();
			if (b.getVotes() <= 0) throw new BugIOException();
			if (b.getState().equals("Closed") && b.getResolution() == null) throw new BugIOException();
			if (b.getState().equals("Reopen") && b.getOwner() == null) throw new BugIOException();
			if (b.getState().equals("Reopen") && !b.isConfirmed()) throw new BugIOException();
			if (b.getState().equals("Resolved") && (b.getResolution() == null || !b.getResolution().equals("Fixed"))) throw new BugIOException(); 
			if (b.getState().equals("Assigned") && b.getOwner() == null) throw new BugIOException();
			if (b.getState().equals("New") && (!b.isConfirmed() && b.getVotes() < 3)) throw new BugIOException();
		}
	}
	
}
