package testingFiles.tracker.xml;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import testingFiles.Bug;
import testingFiles.BugIOException;
import testingFiles.BugReader;

/**
 * Test class for the {@link BugReader} class. 
 * 
 * @author Dr. Sarah Heckman (heckman@csc.ncsu.edu)
 */
public class BugReaderTest {

	/** Min number in name of invalid bug files */
	private static final int MIN_FILE_NUMBER = 2;
	/** Max number in name of invalid bug file */
	private static final int MAX_FILE_NUMBER = 12;
	/** Number of bugs in valid file */
	private static final Object NUM_BUGS = 6;
	
	/**
	 * Tests that a valid file is read correctly by the BugReader
	 */
	@Test
	public void testValidQuestionFile() {
		BugReader reader = null;
		try {
			//Create the QuestionReader
			reader = new BugReader("test_files/bug1.xml");
			
			//Get the lists of Questions
			List<Bug> bugs = reader.getBugs();
			
			//Check that the lengths of the collections are correct
			assertEquals("BugReaderTest.testValidQuestionFile() - incorrect number of bugs - expected 6", NUM_BUGS, bugs.size());
			
			//Check that the information in one of the elements is correct
			Bug b1 = bugs.get(0);
			assertEquals("BugReaderTest.testValidQuestionFile() - incorrect id", 1, b1.getId());
			assertEquals("BugReaderTest.testValidQuestionFile() - incorrect state", "Unconfirmed", b1.getState());
			assertEquals("BugReaderTest.testValidQuestionFile() - incorrect summary", "Bug description", b1.getSummary());
			assertEquals("BugReaderTest.testValidQuestionFile() - incorrect reporter", "reporter", b1.getReporter());
			assertEquals("BugReaderTest.testValidQuestionFile() - incorrect number of votes", 1, b1.getVotes());
			assertEquals("BugReaderTest.testValidQuestionFile() - bug is not confirmed", false, b1.isConfirmed());
			assertNull("BugReaderTest.testValidQuestionFile() - owner is not null", b1.getOwner());
			assertNull("BugReaderTest.testValidQuestionFile() - resolution is not null", b1.getResolution());
			assertEquals("BugReaderTest.testValidQuestionFile() - incorrect number of notes", 1, b1.getNoteList().getNote().size());
	
		} catch (BugIOException e) {
			fail("BugReaderTest.testValidQuestionFile() - an exception is thrown for a valid file");
		}
	}
	
	/**
	 * Tests that an invalid file throws the proper exception.  This test is
	 * done in a loop, which means that earlier failures may mask later failures.
	 */
	@Test
	public void testInValidBugFiles() {
		for (int i = MIN_FILE_NUMBER; i <= MAX_FILE_NUMBER; i++) {
			BugReader reader = null;
			String fileName = "test_files/bug" + i + ".xml";
			try {
				//Create the QuestionReader
				new BugReader(fileName);
				fail("BugReaderTest.testInValidBugFiles() - " + fileName + " did not lead to a failure");			
			} catch (BugIOException e) {
				assertNull("BugReaderTest.testInValidBugFiles() - " + fileName + " did not lead to a failure", reader);	
			}
		}
	}

}
