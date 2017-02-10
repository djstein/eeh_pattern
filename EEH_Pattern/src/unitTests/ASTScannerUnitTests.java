package unitTests;

import java.util.ArrayList;

import org.junit.Test;

import com.ibm.mq.exc.ASTScanner;

import junit.framework.TestCase;

public class ASTScannerUnitTests extends TestCase {
	
	/**
	 * BugReader.java does not contain any try blocks with throw statements inside it.
	 * It does however contain throw statements that exist outside of catch blocks.  We do not yet
	 * have our scanner searching for these.
	 * @throws Exception
	 */
	@Test
	public void testParseNoExceptionsFound() throws Exception {
		ArrayList<String> exceptionsFound;
		
		// initialize the file
		ASTScanner.initialize("src/testingFiles/BugReader.java");
//		assertEquals(0, exceptionsFound.size());
	}
	
	
}