package testingFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * <p>Library for creating a bug XML file for use in the 
 * BugTracker application.  If there is an error creating
 * the file, a {@link BugIOException} is thrown.</p>
 * 
 * <p>To use BugWriter, first create the object with the file
 * name that you want to write to.  Then add all of the questions
 * that you want to the {@link BugList} via the addBug() 
 * method.  When you are done adding bugs,
 * call the marshal() method.  Calling the marshal() method again will
 * delete the file and rewrite with the data in the {@link BugList}.
 * 
 * @author Dr. Sarah Heckman (heckman@csc.ncsu.edu)
 */
public class BugWriter {
	
	/** Name of file to create and write to */
	private String fileName;
	/** List of questions to write to file */
	private BugList list;
	/** ObjectFactory for creating objects that can be written to the file */
	private ObjectFactory of;
	
	/**
	 * Creates a {@link BugList} and {@link ObjectFactory} for writing
	 * questions to the given file.  
	 * @param fileName to write bugs to in XML
	 */
	public BugWriter(String fileName) {
		this.fileName = fileName;
		
		of = new ObjectFactory();
		list = of.createBugList();
	}
	
	/**
	 * Adds a {@link Bug} to the {@link BugList}
	 * @param b question to add to the list
	 */
	public void addItem(Bug b) {
		list.getBug().add(b);
	}
	
	/**
	 * Creates the XML file and writes the bugs in the {@link BugList} 
	 * to the file.
	 * @throws BugIOException if the file cannot be created or written to
	 */
	public void marshal() throws BugIOException {
		try {
			JAXBElement<BugList> l = of.createBugs(list);
			String packageName = this.getClass().getPackage().getName();
			JAXBContext jc = JAXBContext.newInstance(packageName);
			Marshaller m = jc.createMarshaller();
			
			PrintStream out = new PrintStream(new File(fileName));
			m.marshal(l, out);
		} catch (JAXBException jbe) {
			throw new BugIOException(jbe.getMessage());
		} catch (FileNotFoundException e) {
			throw new BugIOException(e.getMessage());
		}
	}
}