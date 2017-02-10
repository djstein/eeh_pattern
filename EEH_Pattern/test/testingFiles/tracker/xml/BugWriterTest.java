package testingFiles.tracker.xml;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import testingFiles.Bug;
import testingFiles.BugIOException;
import testingFiles.BugWriter;
import testingFiles.NoteList;

/**
 * Tests for the {@link BugWriter} class of the BugTrackerXML library.
 * 
 * We are testing that correct XML is generated when giving the Writer a {@link Bug}
 * object
 * 
 * @author Dr. Sarah Heckman (heckman@csc.ncsu.edu)
 */
public class BugWriterTest {
	
	/** Path for test files */
	private static final String PATH = "test_files/";
	/** Contains files that will be created by the tests */
	private String [] actFileNames = { "act_bug_empty.xml", "act_bug_unconfirmed.xml", "act_bug_new.xml", "act_bug_assigned.xml", "act_bug_resolved.xml", "act_bug_reopen.xml", "act_bug_closed.xml", "act_bug_all.xml" };
	/** Contains expected results for the files */
	private String [] expFileNames = { "exp_bug_empty.xml", "exp_bug_unconfirmed.xml", "exp_bug_new.xml", "exp_bug_assigned.xml", "exp_bug_resolved.xml", "exp_bug_reopen.xml", "exp_bug_closed.xml", "exp_bug_all.xml" };
	
	/**
	 * Sets up the project for each test case by deleting any of the
	 * test files that were generated from earlier runs of the 
	 * testing program.  Not deleting these files would cause
	 * test failures
	 */
	@Before
	public void setUp() {
		for (int i = 0; i < actFileNames.length; i++) {
			File f = new File(actFileNames[i]);
			if (f.exists() && !f.delete()) { 
				throw new IllegalStateException();
			}
		}
	}
	
	/**
	 * Compares the contents of the two files.  Returns true if the contents 
	 * are exactly the same. Returns false if the contents are not
	 * the same or if there are any errors while processing.
	 * 
	 * @param expectedFile the file with expected results
	 * @param actualFile the file with actual results
	 * @param true if the files are exactly the same and false otherwise
	 */
	private boolean compareFiles(String expectedFile, String actualFile) {
		try {
			Scanner expectedIn = new Scanner(new File (expectedFile));
			StringBuffer expected = new StringBuffer();
			while (expectedIn.hasNextLine()) {
				expected.append(expectedIn.nextLine());
			}
			expectedIn.close();
			
			Scanner actualIn = new Scanner(new File (expectedFile));
			StringBuffer actual = new StringBuffer();
			while (actualIn.hasNextLine()) {
				actual.append(actualIn.nextLine());
			}
			actualIn.close();
			
			return expected.toString().equals(actual.toString());
		} catch (FileNotFoundException e) {
			return false;
		}
	}

	/**
	 * Tests that a {@link BugWriter} with an empty list should sill generate valid XML.
	 */
	@Test
	public void testMarshalEmptyList() {
		String expectedFile = PATH + expFileNames[0];
		String actualFile = PATH + actFileNames[0];
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalEmptyList() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalEmptyList() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalEmptyList() - unexpected exception"); 
		}
	}
	
	/**
	 * Tests that a {@link BugWriter} with a {@link Bug} in the unconfirmed state generates valid
	 * XML.
	 */
	@Test
	public void testMarshalUnconfirmedBug() {
		String expectedFile = PATH + expFileNames[1];
		String actualFile = PATH + actFileNames[1];
		
		Bug b = new Bug();
		b.setId(1);
		b.setState("Unconfirmed");
		b.setSummary("Bug description");
		b.setReporter("reporter");
		b.setOwner(null);
		b.setVotes(1);
		b.setConfirmed(false);
		b.setResolution(null);
		b.setNoteList(new NoteList());
		List<String> notes = b.getNoteList().getNote();
		notes.add("Note 1");		
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.addItem(b);
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalUnconfirmedBug() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalUnconfirmedBug() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalUnconfirmedBug() - unexpected exception"); 
		}
	}
	
	/**
	 * Tests that a {@link BugWriter} with a {@link Bug} in the new state generates valid
	 * XML.
	 */
	@Test
	public void testMarshalNewBug() {
		String expectedFile = PATH + expFileNames[2];
		String actualFile = PATH + actFileNames[2];
		
		Bug b = new Bug();
		b.setId(2);
		b.setState("New");
		b.setSummary("Bug description");
		b.setReporter("reporter");
		b.setOwner(null);
		b.setVotes(1);
		b.setConfirmed(true);
		b.setResolution(null);
		b.setNoteList(new NoteList());
		List<String> notes = b.getNoteList().getNote();
		notes.add("Note 1");
		notes.add("Note 2");
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.addItem(b);
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalNewBug() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalNewBug() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalNewBug() - unexpected exception"); 
		}
	}
	
	/**
	 * Tests that a {@link BugWriter} with a {@link Bug} in the assigned state generates valid
	 * XML.
	 */
	@Test
	public void testMarshalAssignedBug() {
		String expectedFile = PATH + expFileNames[3];
		String actualFile = PATH + actFileNames[3];
		
		Bug b = new Bug();
		b.setId(3);
		b.setState("Assigned");
		b.setSummary("Bug description");
		b.setReporter("reporter");
		b.setOwner("owner");
		b.setVotes(1);
		b.setConfirmed(true);
		b.setResolution(null);
		b.setNoteList(new NoteList());
		List<String> notes = b.getNoteList().getNote();
		notes.add("Note 1");
		notes.add("Note 2");
		notes.add("Note 3");
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.addItem(b);
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalAssignedBug() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalAssignedBug() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalAssignedBug() - unexpected exception"); 
		}
	}
	
	/**
	 * Tests that a {@link BugWriter} with a {@link Bug} in the resolved state generates valid
	 * XML.
	 */
	@Test
	public void testMarshalResolvedBug() {
		String expectedFile = PATH + expFileNames[4];
		String actualFile = PATH + actFileNames[4];
		
		Bug b = new Bug();
		b.setId(4);
		b.setState("Resolved");
		b.setSummary("Bug description");
		b.setReporter("reporter");
		b.setOwner("owner");
		b.setVotes(1);
		b.setConfirmed(true);
		b.setResolution("Fixed");
		b.setNoteList(new NoteList());
		List<String> notes = b.getNoteList().getNote();
		notes.add("Note 1");
		notes.add("Note 2");
		notes.add("Note 3");
		notes.add("Note 4");
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.addItem(b);
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalResolvedBug() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalResolvedBug() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalResolvedBug() - unexpected exception"); 
		}
	}
	
	/**
	 * Tests that a {@link BugWriter} with a {@link Bug} in the reopen state generates valid
	 * XML.
	 */
	@Test
	public void testMarshalReopenBug() {
		String expectedFile = PATH + expFileNames[5];
		String actualFile = PATH + actFileNames[5];
		
		Bug b = new Bug();
		b.setId(5);
		b.setState("Reopen");
		b.setSummary("Bug description");
		b.setReporter("reporter");
		b.setOwner("owner");
		b.setVotes(1);
		b.setConfirmed(true);
		b.setResolution(null);
		b.setNoteList(new NoteList());
		List<String> notes = b.getNoteList().getNote();
		notes.add("Note 1");
		notes.add("Note 2");
		notes.add("Note 3");
		notes.add("Note 4");
		notes.add("Note 5");
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.addItem(b);
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalReopenBug() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalReopenBug() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalReopenBug() - unexpected exception"); 
		}
	}
	
	/**
	 * Tests that a {@link BugWriter} with a {@link Bug} in the closed state generates valid
	 * XML.
	 */
	@Test
	public void testMarshalClosedBug() {
		String expectedFile = PATH + expFileNames[6];
		String actualFile = PATH + actFileNames[6];
		
		Bug b = new Bug();
		b.setId(6);
		b.setState("Closed");
		b.setSummary("Bug description");
		b.setReporter("reporter");
		b.setOwner("owner");
		b.setVotes(1);
		b.setConfirmed(true);
		b.setResolution("WorksForMe");
		b.setNoteList(new NoteList());
		List<String> notes = b.getNoteList().getNote();
		notes.add("Note 1");
		notes.add("Note 2");
		notes.add("Note 3");
		notes.add("Note 4");		
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.addItem(b);
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalClosedBug() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalClosedBug() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalClosedBug() - unexpected exception"); 
		}
	}
	
	/**
	 * Tests multiple {@link Bug}s are written by the {@link BugWriter}.
	 */
	@Test
	public void testMarshalAllBugs() {
		String expectedFile = PATH + expFileNames[7];
		String actualFile = PATH + actFileNames[7];
		
		Bug b1 = new Bug();
		b1.setId(1);
		b1.setState("Unconfirmed");
		b1.setSummary("Bug description");
		b1.setReporter("reporter");
		b1.setOwner(null);
		b1.setVotes(1);
		b1.setConfirmed(false);
		b1.setResolution(null);
		b1.setNoteList(new NoteList());
		List<String> notes1 = b1.getNoteList().getNote();
		notes1.add("Note 1");	
		
		Bug b2 = new Bug();
		b2.setId(2);
		b2.setState("New");
		b2.setSummary("Bug description");
		b2.setReporter("reporter");
		b2.setOwner(null);
		b2.setVotes(1);
		b2.setConfirmed(true);
		b2.setResolution(null);
		b2.setNoteList(new NoteList());
		List<String> notes2 = b2.getNoteList().getNote();
		notes2.add("Note 1");
		notes2.add("Note 2");
		
		Bug b3 = new Bug();
		b3.setId(3);
		b3.setState("Assigned");
		b3.setSummary("Bug description");
		b3.setReporter("reporter");
		b3.setOwner("owner");
		b3.setVotes(1);
		b3.setConfirmed(true);
		b3.setResolution(null);
		b3.setNoteList(new NoteList());
		List<String> notes3 = b3.getNoteList().getNote();
		notes3.add("Note 1");
		notes3.add("Note 2");
		notes3.add("Note 3");
		
		Bug b4 = new Bug();
		b4.setId(4);
		b4.setState("Resolved");
		b4.setSummary("Bug description");
		b4.setReporter("reporter");
		b4.setOwner("owner");
		b4.setVotes(1);
		b4.setConfirmed(true);
		b4.setResolution("Fixed");
		b4.setNoteList(new NoteList());
		List<String> notes4 = b4.getNoteList().getNote();
		notes4.add("Note 1");
		notes4.add("Note 2");
		notes4.add("Note 3");
		notes4.add("Note 4");
		
		Bug b5 = new Bug();
		b5.setId(5);
		b5.setState("Reopen");
		b5.setSummary("Bug description");
		b5.setReporter("reporter");
		b5.setOwner("owner");
		b5.setVotes(1);
		b5.setConfirmed(true);
		b5.setResolution(null);
		b5.setNoteList(new NoteList());
		List<String> notes5 = b5.getNoteList().getNote();
		notes5.add("Note 1");
		notes5.add("Note 2");
		notes5.add("Note 3");
		notes5.add("Note 4");
		notes5.add("Note 5");
		
		Bug b6 = new Bug();
		b6.setId(6);
		b6.setState("Closed");
		b6.setSummary("Bug description");
		b6.setReporter("reporter");
		b6.setOwner("owner");
		b6.setVotes(1);
		b6.setConfirmed(true);
		b6.setResolution("WorksForMe");
		b6.setNoteList(new NoteList());
		List<String> notes6 = b6.getNoteList().getNote();
		notes6.add("Note 1");
		notes6.add("Note 2");
		notes6.add("Note 3");
		notes6.add("Note 4");
		
		BugWriter writer = new BugWriter(actualFile);
		try {
			writer.addItem(b1);
			writer.addItem(b2);
			writer.addItem(b3);
			writer.addItem(b4);
			writer.addItem(b5);
			writer.addItem(b6);
			writer.marshal();
			assertTrue("BugWriterTest.testMarshalAllBugs() - file doesn't exist, can't continue test", new File(actualFile).exists());
			assertTrue("BugWriterTest.testMarshalAllBugs() - actual file doesn't match expected", compareFiles(expectedFile, actualFile));
		} catch (BugIOException e) {
			fail("BugWriterTest.testMarshalAllBugs() - unexpected exception"); 
		}
	}

}
