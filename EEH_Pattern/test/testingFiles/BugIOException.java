package testingFiles;

/**
 * Exception class that is thrown whenever there is a problem with
 * processing or creating an XML file.
 * 
 * @author Dr. Sarah Heckman (heckman@csc.ncsu.edu)
 */
public class BugIOException extends Exception {
	
	/** Used for serialization */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a QuestionException with a pre set message
	 */
	public BugIOException() {
		this("BugIOException - error processing bug list");
	}
	
	/**
	 * Creates a QuestionException with a provided message
	 * @param message message to include in the exception information
	 */
	public BugIOException(String message) {
		super(message);
	}

}