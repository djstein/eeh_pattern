package unitTests;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.security.Permission;

import org.junit.*;

import com.ibm.mq.exc.patternutil;

/**
 * Tests to validate patternutil displays correct information or execute correct
 * methods when given command line arguments
 * 
 * @author NCSU Senior Design Team - Spring 2016
 *
 */
public class PatternUtilUnitTests {

	protected static class ExitException extends SecurityException {
		public final int status;

		public ExitException(int status) {
			super("There is no escape!");
			this.status = status;
		}
	}

	private static class NoExitSecurityManager extends SecurityManager {
		@Override
		public void checkPermission(Permission perm) {
			// allow anything.
		}

		@Override
		public void checkPermission(Permission perm, Object context) {
			// allow anything.
		}

		@Override
		public void checkExit(int status) {
			super.checkExit(status);
			throw new ExitException(status);
		}
	}
	
	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private PrintStream ps = new PrintStream(baos);
	private PrintStream old = System.out;
	// private final ByteArrayOutputStream errorStream = new
	// ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setSecurityManager(new NoExitSecurityManager());
		System.setOut(ps);
	}

	@After
	public void tearDown() throws Exception {
		System.setSecurityManager(null); // or save and restore original
		//super.tearDown();
	}
	
	/**
	 * patterntuil is given "about" flag
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAbout() throws Exception {
		setUp();
		String[] args = { "-about"};

		try {
			patternutil.main(args);
		} catch (ExitException e) { // Program was intended to exit
			// Reset the variables that would be reset
			// in a system.exit
			patternutil.testReset();
		}

		String expectedTestOutput = "Exception Handler Utility\n" + 
				"-------------------------\n" + 
				"~ version 0.0.1\n" + 
				"~ author: NCSU Senior Design\n" + 
				"          Spring 2016\n" + 
				"          IBM Corporation.\n" + 
				"\n" + 
				"";

		System.out.flush();
		System.setOut(old);
		assertEquals(expectedTestOutput, baos.toString());
	}
	
	@Test
	public void testNoAppId() throws Exception {
		setUp();
		String[] args = {"-path", "test/demo/"};

		try {
			patternutil.main(args);
		} catch (ExitException e) { // Program was intended to exit
			// Reset the variables that would be reset
				// in a system.exit
			patternutil.testReset();
		}

		String expectedTestOutput = "Syntax Error:\n" + 
				"\n" + 
				"Message: Incorrect App ID\n" + 
				"com.ibm.mq.exc.patternutil\n" + 
				"	Required: -path <directory of Java files to standardize, places app specific catalog here>\n" + 
				"		 OR  -classname ('.java') <if only working on one file>\n" + 
				"	Required: -appid <app name acronym> \n" + 
				"	Required:[-catalogall] or [-catalogonly]\n" + 
				"	[-manual] [-about] [-help]\n" + 
				"\n" + 
				"";

		System.out.flush();
		System.setOut(old);
		assertEquals(expectedTestOutput, baos.toString());
	}
	
	/**
	 * patterntuil is given no params
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNoParams() throws Exception {
		setUp();
		String[] args = {};

		try {
			patternutil.main(args);
		} catch (ExitException e) { // Program was intended to exit
			// Reset the variables that would be reset
			// in a system.exit
			patternutil.testReset();
		}

		String expectedTestOutput = "Syntax Error:\n" + 
				"\n" + 
				"Message: No arguments\n" + 
				"com.ibm.mq.exc.patternutil\n" + 
				"	Required: -path <directory of Java files to standardize, places app specific catalog here>\n" + 
				"		 OR  -classname ('.java') <if only working on one file>\n" + 
				"	Required: -appid <app name acronym> \n" + 
				"	Required:[-catalogall] or [-catalogonly]\n" + 
				"	[-manual] [-about] [-help]\n" + 
				"\n" + 
				"";

		System.out.flush();
		System.setOut(old);
		assertEquals(expectedTestOutput, baos.toString());
	}


	/**
	 * patterntuil is given "-help" flag
	 * 
	 * @throws Exception
	 */
	@Test
	public void testHelpFlag() throws Exception {
		setUp();
		String[] args = { "-help", "-appid", "TEST"};

		try {
			patternutil.main(args);
		} catch (ExitException e) { // Program was intended to exit
			// Reset the variables that would be reset
			// in a system.exit
			patternutil.testReset();
		}

		String expectedTestOutput = "Help:\n" + 
				"\n" + 
				"Message: \n" + 
				"com.ibm.mq.exc.patternutil\n" + 
				"	Required: -path <directory of Java files to standardize, places app specific catalog here>\n" + 
				"		 OR  -classname ('.java') <if only working on one file>\n" + 
				"	Required: -appid <app name acronym> \n" + 
				"	Required:[-catalogall] or [-catalogonly]\n" + 
				"	[-manual] [-about] [-help]\n" + 
				"\n" + 
				"\n" + 
				"	-about\n" + 
				"		Version and related information.\n" + 
				"	-appid\n" + 
				"		Name for <App> value, max 10 char, all uppercase.\n" + 
				"	-catalogall\n" + 
				"		Catalog and replace all exceptions found inside a Java class.\n" + 
				"	-catalogonly\n" + 
				"		Finds all exceptions inside of the Java class, places them into the app specific database only.\n" + 
				"	-classname\n" + 
				"		Used when only a single file is to be worked on.\n" + 
				"	-manual\n" + 
				"		Flag to prompt if changes should be made to added exception.\n" + 
				"	-path\n" + 
				"		Get all Java files to edit, place app specific catalog and associated Java class there.\n" + 
				"\n" + 
				"";

		System.out.flush();
		System.setOut(old);
		assertEquals(expectedTestOutput, baos.toString());
	}
	
	/**
	 * Tests to ensure the catalogs will be created should the
	 * files not already exist.
	 * @throws Exception
	 */
	@Test
	public void testNoExistingCatalog() throws Exception {
		
		// Delete the existing catalogs
		File file = new File("test/demo/ExcCat.TEST.xml");
		file.delete();
		file = new File("test/demo/ExcCat_TEST.java");
		file.delete();
		
		setUp();
		String[] args = {"-path", "test/demo/", "-appid", "TEST", "-catalogall"};

		try {
			patternutil.main(args);
		} catch (ExitException e) { // Program was intended to exit
			// Reset the variables that would be reset
			// in a system.exit
			patternutil.testReset();
		}

		String expectedTestOutput = 
				"Java class generated for app specific catalog successfully:\n" + 
				" 'test/demo/ExcCat.TEST.xml'\n" + 
				"Working on file:\n" + 
				" 'test/demo/test.java'\n" + 
				"Edits were made ExcCat.TEST.xml. Recreating..\n" + 
				"Starting excutil for generating Java class from '/home/zioep/workspace/EEH_Pattern/test/demo/ExcCat.TEST.xml'...\n" + 
				"Successfully generated Java code at '/home/zioep/workspace/EEH_Pattern/test/demo/ExcCat_TEST.java'.\n" + 
				"\n" + 
				"\n" + 
				"Completed..\n" + 
				"";

		System.out.flush();
		System.setOut(old);
		assertTrue(baos.toString().contains("App specfic catalog created successfully:\n"));
		assertTrue(baos.toString().contains(expectedTestOutput));
	}
}
