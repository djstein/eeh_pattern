package com.ibm.mq.exc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * patternutil
 * 
 * Utility to interface with parsing and rewriting a Java class
 * with standardized EEH exceptions.
 * 
 * @author NCSU Senior Design Team - Spring 2016
 *
 */
public class patternutil {
	
	/** Set to run functions which catalog and replace all exceptions found in Java class */
	static boolean catalogAll = false;
	/** Set to run functions which ONLY catalog all exceptions found in Java class */
	private static boolean catalogOnly = false;
	/** Set to run functions which allow manual editing and accepting of exception edits */
	static boolean manual = false;
	/** Acronym used when creating the Java classes specific XML catalog, used in <appid> */
	static String appId = "";
	/** The Java class to parse for exceptions and edit with EEH Standardized exceptions */
	private static String className = "";
	/** Directory which to standardize all class files within the directory  */
	static String path = "";
	/** XML catalog of standard exceptions to be appended too and read from */
	static File workCatalog = null;	
	/** Array of all files found in the directory passed by directory flag */
	private static ArrayList<File> files = new ArrayList<File>();
	/** Path to the master catalog */
	private static String masterCatalog = "samp/exccat/ExcCat.EEH_Master.xml";
	/** Edits were created to the XML documents */
	static boolean editsMade = false;

	/**
	 * Used only for testing purposes.  Resets all initial variables to their 
	 * initial state
	 */
	public static void testReset() {
		catalogAll = false;
		catalogOnly = false;
		manual = false;
		appId = "";
		className = "";
		path = "";
		workCatalog = null;
		files = new ArrayList<>();
		editsMade = false;
	}
	
	public static void main(String[] args) {
		/*
		 * If no arguments provided
		 * Display the syntax values
		 */
		if (args.length == 0)
			syntax(true, "No arguments");
		
		/*
		 * Loop through all arguments
		 * They can be placed in any order
		 * Each value found, change flags for runtime
		 */
		for (int nArgs = 0;nArgs<args.length;nArgs++) {
			
			/*
			 * If about flag is set
			 * Display the about information
			 */
			if (args[nArgs].compareTo("-about")==0){
				about();
			}
			
			/*
			 * If flag is set
			 * Allows user to manually select / edit
			 * Changes
			 */
			if (args[nArgs].compareTo("-manual")==0){
				manual = true;
			}
			
			/*
			 * If help flag is set
			 * Display the help information
			 */
			if (args[nArgs].compareTo("-help")==0) {
				help();
			}
			
			/*
			 * If appid flag is set
			 * Set it's data to appid 
			 */
			if (args[nArgs].compareTo("-appid")==0){
				if (appId!="" || ++nArgs > args.length)
					syntax(true, "No App ID specified");
				appId = args[nArgs];
			}

			/*
			 * If classname is set
			 * Set it's data to className
			 */
			if (args[nArgs].compareTo("-classname")==0){
				if (className!="" || ++nArgs > args.length)
					syntax(true, "No classname");
				className = args[nArgs];
				
				/*
				 * See if file specified by className exists
				 * Exits with code 1
				 */
				if (!new File(className).exists()) {
					System.out.println("Java class '"+className+"' not found!");
					System.exit(1);
				}
			}
			
			/*
			 * If directory is set
			 * Set it's data to directory
			 */
			if (args[nArgs].compareTo("-path")==0){
				if (path!="" || ++nArgs > args.length)
					syntax(true, "No file path");
				path = args[nArgs];
				
				if( !path.endsWith("/") ){
					path += "/";
				}
				/*
				 * See if file specified by className exists
				 * Exits with code 1
				 */
				File directory = new File(path);
				if (directory.exists()) {
					findFiles(directory, files);
				} else {
					syntax(true, "Incorrect path");
				}
			}
			
			/*
			 * If catalogonly is set
			 * Change catalogAll to true
			 */
			if (args[nArgs].compareTo("-catalogonly")==0) {
				catalogOnly = true;
			}
			
			/*
			 * If catalogall is set
			 * Change catalogAll to true
			 */
			if (args[nArgs].compareTo("-catalogall")==0) {
				catalogAll = true;
			}
		}
		
		/*
		 * If catalogAll and catalogOnly are both
		 * set then exit 
		 */
		if( catalogAll && catalogOnly ){
			syntax(true, "CatalogAll and CatalogOnly set");
		}
		
		/*
		 * If AppId is not set
		 * Or className and path
		 * Exit and display syntax errors
		 */
		if(appId.isEmpty() || ( className.isEmpty() && path.isEmpty() ) ){
			syntax(true, "Incorrect App ID");
		}
		
		/*
		 * See if Java class's specific XML catalog exists
		 */
		appCatalogCheck();
		
		/*
		 * Array of file names populated from:
		 * 	- All files found from path
		 * 	- One file passed by className
		 */
		ArrayList<String> editFiles = new ArrayList<String>();
		if(!className.isEmpty()){
			editFiles.add(className);
		} else if (!files.isEmpty()) {
			for(File file : files)
				editFiles.add(file.toString());
		}
		
		/*
		 * Begin the cataloging of and editing of exceptions within the Java class specified
		 */
		if (catalogAll || catalogOnly){
			for ( String strFile : editFiles ) {
				System.out.println("Working on file:"
					+ "\n '"+strFile+"'");
				ASTScanner.initialize(strFile);
			}
			ASTScanner.rewrite();
		}
		/* If any edits were made to the app specific catalogs
		 * Recreate the associated Java class
		 */
		if(editsMade){
			System.out.println("Edits were made ExcCat." + appId + ".xml. Recreating..");
			classgenJava();
		}
		
		System.out.println("\n\nCompleted..");
		System.exit(0);
	}
	
	/**
	 * Determine if an XML catalog exists for the Java class specified.
	 * Sets workCatalog to specified file or created file.
	 */
	static void appCatalogCheck() {
		/*
		 * If the path has been specified:
		 *  Place at <path>/ExcCat.<AppId>.xml
		 * Else:
		 * 	Place ExcCat.<AppId>.xml as same folder as className
		 */
		String dbName = "";
		if(path!=""){
			dbName = path + "ExcCat." + appId + ".xml";
		} else {
			dbName = "ExcCat." + appId + ".xml";
		}
				
		/*
		 * If ExcCat.<appid>.xml does not exisit,
		 * copy ExcCat.EEH_Master.xml and rename it to above
		 */
		if (!new File(dbName).exists()) {
			workCatalog = new File(dbName);
			createAppCatalog();
			System.out.println("App specfic catalog created successfully:"
					+ "\n '"+dbName+"'.");
		} else {
			System.out.println("App specific catalog already exisits at:"
					+ "\n '"+dbName+"'.");
			workCatalog = FileUtils.getFile(dbName);
		}
		try{
			classgenJava();
			System.out.println("Java class generated for app specific catalog successfully:"
					+ "\n '"+dbName+"'");
		} catch (Exception e) {
			System.out.println("Classgen failed!");
			System.exit(1);
		}
	}
	
	/**
	 * Provide functionality of creating the app's XML catalog
	 * ExcCat.EEH_Master.xml will be copied and
	 * renamed to the correct app specific catalog.
	 * Format: ExcCat.<appid>.xml
	 */
	private static void createAppCatalog() {
		/*
		 * Try to find ExcCat.EEH_Master.xml and copy it into dbFile
		 * If the database is being created for the first time,
		 * also run excutil to create the coupled Java class
		 * ExcCat_<appid>.java
		 */
		try {
			FileUtils.copyFile(FileUtils.getFile(masterCatalog), workCatalog);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		/* change name: from ExcCat.EEH_Master to ExcCat.TEST
		 * change appid: form EEH_Master to TEST
		 */
		try {
			XMLExcWriter.updateCatalogParams(workCatalog.getAbsolutePath(), appId);
		} catch (Exception e) {
			System.out.printf("updateCatalogParams failed: %s\n", e.getMessage());
		}
	}

	/**
	 * Run the excutil classgenJava
	 */
	static void classgenJava(){
		// After generation, use a string array to pass into excutil.main()
		String strClassGen = "Java";
		String strXML = workCatalog.getAbsolutePath();
		// strClassDir: Remove file name from absolute path gotten by strXML to get directory to place generated Java class
		String strClassDir = strXML.substring(0,strXML.lastIndexOf(File.separator));
		String strPackage = path;
		strPackage = strPackage.replace("/", ".");
		strPackage = strPackage.substring(0, strPackage.length()-1);
		excutil.classgenJava(strClassGen, strXML, strClassDir, strPackage);
	}

	/**
	 * Display the syntax to run the program
	 * @param boolExit: if set, a syntax error has occurred, exit status 1
	 */
	static void syntax(boolean boolExit, String message) {
		if (boolExit)
			System.out.println("Syntax Error:\n");
			System.out.printf("Message: %s\n", message);
		System.out.println("com.ibm.mq.exc.patternutil\n"
				+"\tRequired: -path <directory of Java files to standardize, places app specific catalog here>\n"
				+"\t\t OR  -classname ('.java') <if only working on one file>\n"
				+"\tRequired: -appid <app name acronym> \n"
				+"\tRequired:[-catalogall] or [-catalogonly]\n"
				+"\t[-manual] [-about] [-help]\n");
		if (boolExit)
			System.exit(1);
	}
	
	/**
	 * Display the about information
	 */
	public static void about() {
		System.out.println("Exception Handler Utility\n"
				+"-------------------------\n"
				+"~ version 0.0.1\n"
				+"~ author: NCSU Senior Design\n"
				+"          Spring 2016\n"
				+"          IBM Corporation.\n");
		System.exit(0);

	}
	
	/**
	 * Display the help information, also displays the syntax info
	 * Then exits safely with code 0
	 */
	static void help() {
		System.out.println("Help:\n");
		syntax(false, "");
		System.out.println("\n"
				+"\t-about\n" +
					"\t\tVersion and related information.\n"
				+"\t-appid\n" +
					"\t\tName for <App> value, max 10 char, all uppercase.\n"
				+"\t-catalogall\n" +
					"\t\tCatalog and replace all exceptions found inside a Java class.\n"
				+"\t-catalogonly\n" +
					"\t\tFinds all exceptions inside of the Java class, places them into the app specific database only.\n"
				+"\t-classname\n" +
					"\t\tUsed when only a single file is to be worked on.\n"
				+"\t-manual\n" +
					"\t\tFlag to prompt if changes should be made to added exception.\n"
				+"\t-path\n" +
					"\t\tGet all Java files to edit, place app specific catalog and associated Java class there.\n");
		System.exit(0);
	}
	
	/**
	 * Get all files within directories
	 * @param strDirectory
	 * @param files
	 */
	public static void findFiles(File directory, ArrayList<File> files){
		File[] fList = directory.listFiles();
		for (File file : fList){
			/*
			 * Ensure found file is Java
			 */
			if (file.isFile() && FilenameUtils.getExtension(file.toString()).equals("java")){
				/*
				 * Ensure found file has not been edited by patternutil already, to do so
				 * 	do not open pattergen folder.
				 * Ensure found file is not ExcCat_<AppId>.java
				 */
				if(!file.getName().contains("_PATTERN") && !file.getName().contains("ExcCat_")){
					files.add(file);
				}
			} else if (file.isDirectory() && (!file.toString().contains("patterngen"))) {
				File nextDirectory = new File(file.getAbsolutePath());
				findFiles(nextDirectory, files);
			}
		}
	}
}
