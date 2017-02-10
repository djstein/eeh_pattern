package com.ibm.mq.exc;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.dom4j.DocumentException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CatchClause;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TryStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.rewrite.ASTRewrite;
import org.eclipse.jdt.core.dom.rewrite.ListRewrite;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Document;
import org.eclipse.text.edits.MalformedTreeException;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.text.edits.UndoEdit;
import org.xml.sax.SAXException;

public class ASTScanner {
	/** Instantiate document to parse through and edit */
	static Document document = null;

	/** Instantiate parser */
	static ASTParser parser = null;

	/** Instantiate astRoot */
	static CompilationUnit astRoot = null;

	/** AST created by root that can be edited and applied to a document */
	static AST astSrc = null;

	/** File to place updates to, name of read in file */
	public static String strEditFile = "";

	/** Initialize the class for parsing and editing */
	public static void initialize(String fileName) {
	    /* Read the class file into a char array */
	        String unit = null;
	        try {
	            unit = readFileToString(fileName);
	        } catch (IOException e){
	            /* File not found */
	            e.printStackTrace();
	        } // Try Catch
	        /* Create a new document in memory from the file read as chars */
	        document = new Document(unit);
	        /* Initialize the parser */
	        parser = ASTParser.newParser(AST.JLS8);
	        /* Set the source of the parser to the document */
	        parser.setSource(document.get().toCharArray());
	        /* Set the AST root to the compilation unit created by the parser's source */
	        astRoot = (CompilationUnit) parser.createAST(null);
	        /* Initialize an AST that can be edited in memory from ast_root */
	        astSrc = astRoot.getAST();
	        
	        /* Change the class name file inputed to a different value when saved */
	        strEditFile = fileName.replace(patternutil.path, patternutil.path + "patterngen/");
//	        strEditFile = fileName.replace(".java", "_PATTERN.java");
	}

	public static void rewrite() {
	        // Initialize Rewriter
	        final ASTRewrite rewriter = ASTRewrite.create(astSrc);

	        // Get the type declarations for the complication unit
	        final TypeDeclaration typeDecl = (TypeDeclaration) astRoot.types().get(0);

	        /* Visit each TryCatch inside of the document */
	        astRoot.accept(new ASTVisitor() {	        	
	            public boolean visit(TryStatement tryBlock){
	                /* Get each catch block inside of the try block */
	                List<CatchClause> catchBlocks = tryBlock.catchClauses();
	                /* Loop through each catch block */
	                for(CatchClause catchClause : catchBlocks){
	                    /* Get the body (includes the statements) of the catch clause */
	                    Block catchBody = catchClause.getBody();
	                    /* Create a list of all the rewrites that need to be made to the AST from this catch block */
	                    ListRewrite listRewrite = rewriter.getListRewrite(catchBody, Block.STATEMENTS_PROPERTY);

	                    /* What will be replaced into the non standard throw new exception */
	                    Statement placeHolder = null;

	                    try {
	                        /* Found exception */
	                        SingleVariableDeclaration foundException = catchClause.getException();
	                        /* Split string value of the exception, ie. "Exception e" */
	                        String[] strExcSplit = getExceptionSplit(foundException.toString());
	                        /* Get the class name of the exception, ie. "Exception" */
	                        String className = strExcSplit[0];
	                        /* Get the exception name, ie. "e" */
	                        String exceptionName = strExcSplit[1];

	                        /* Check to see if the found exception is inside of the database 
	                         * If it does not exist, add it to the app specific database ExcCat.<AppId>.xml
	                         */
	                        if(!XMLExcWriter.exceptionExist(className, false)){
	                            /* Create the default parameters to be added to the database */
	                            ArrayList<Parameter> paramList = new ArrayList<Parameter>();

	                            Parameter paramCatalog = new Parameter("TODO", "Description of the exception");
	                            /* Add those paramaters to the list for an exception */
	                            paramList.add(paramCatalog);
	                            /* Add the exceptions class name and the string paramaters to the app specific databse */
	                            XMLExcWriter.write(className, paramList, false);
	                            /* Clear the paramList of catalog values, so JavaMap values can be added */
	                            paramList.clear();

	                            /* The two default parameters for exceptions added to JavaMap
	                             * TODO: This portion of code should be replaced with the functionality
	                             * to find all actual parameter on an exception object
	                             */
	                            Parameter paramJavaMap = new Parameter("Cause", "getPath", "method");
	                            paramList.add(paramJavaMap);
	                            paramJavaMap = new Parameter("Message", "getMessge", "method");
	                            paramList.add(paramJavaMap);

	                            /* Add the exception classes default methods as paramaters to the JavaMap_Master */
	                            if(!XMLExcWriter.exceptionExist(className, true)){
		                            XMLExcWriter.write(className, paramList, true);
	                            }
	                            
	                            /* Set edits made to true, will remake the database before exiting */
	                            patternutil.editsMade = true;

	                        } // If Statement
	                        /* If the user had inputed catalogAll flag:
	                         *  begin the editing process
	                         */
	                        if ( patternutil.catalogAll ) {
	                            /* Find the parameters for the exception */
	                            List<String> exceptionParams = XMLExcWriter.getParams(className);
	                            /* The string representation of the placeHolder statement */
	                            String placeHolderString = "throw ExcCat_" + patternutil.appId + ".exc" + className + "(";
	                            for(int i = 0; i < exceptionParams.size(); i++ ){
	                                placeHolderString += exceptionName + "." + exceptionParams.get(i) + "()";
	                                /* If another exception param add a comma */
	                                if (exceptionParams.size() > i+1 ){
	                                    placeHolderString += ", ";
	                                } // If Statement
	                            } // For
	                            placeHolderString += ");";
	                            if(patternutil.manual){
		                            /* See if the user would like to edit the string */
		                            placeHolderString = editPlaceHolder(placeHolderString);	
	                            }
	                            /* Add that string to the statement placeholder */
	                            placeHolder = (Statement) rewriter.createStringPlaceholder(placeHolderString, ASTNode.EMPTY_STATEMENT);

	                            /* Insert the change into the top of the list rewrite array */
	                            listRewrite.insertFirst(placeHolder, null);
	                            
	                            /* Create a TODO comment to place above the edit */
	                            placeHolder = (Statement) rewriter.createStringPlaceholder("//TODO: Add correct Parameters", ASTNode.EMPTY_STATEMENT);
	                            /* Insert the TODO comment to the top of the list rewrite array */
	                            listRewrite.insertFirst(placeHolder, null);
	                        } // If Statement
	                    }  catch (IOException | DocumentException | ParserConfigurationException | SAXException e) {
							e.printStackTrace();
	                    } // Try Catch                
	                } // For Loop
	                return false;
	            }
	        });
	    
	    /* After all exceptions have been added to rewriter
	     * If catalogAll had been flagged apply the edits
	     * to the working class file
	     */
	    if ( patternutil.catalogAll ){
	        /* Apply the edits made to the AST rewriter */
	        TextEdit edits = rewriter.rewriteAST(document, null);
	        /* Original file placed here if break */
	        UndoEdit undo = null;
	        try {
	            /* Apply the AST Rewriter edits to the document */
	            undo = edits.apply(document);
	        } catch(MalformedTreeException | BadLocationException e ) {
				e.printStackTrace();
			} // Try Catch

	        File file = new File(strEditFile);
	        try {
				FileUtils.write(file, document.get());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Try Catch
	        
//	        compilePatternFile(file);
	    } // If Statement
	}

	/*
	 * Check if the file created by ASTScanner can compile
	 */
	private static void compilePatternFile(File file) {
		/* Create a compiler */
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        /* Create a fileManager */
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        /* Add the file created to the list of files to compile */
        //TODO this function could be done against all files created in patterngen folder
        List<File> sourceFileList = new ArrayList <File> ();
//        sourceFileList.add(new File(patternutil.path + "ExcCat_TEST.java"));
        sourceFileList.add(file);
        /* Create compilation units for each file to send to the compiler */
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(sourceFileList);
        /* Create a task from the compilatoin unit */
        CompilationTask task = compiler.getTask (null,fileManager, null, null, null, compilationUnits);
        /* Run the compilation unit */
        boolean result = task.call();
        if(result){
        	System.out.println("File compiled correctly: " + "\n '"+file+"'.");
        } else {
        	System.out.println("File could not compile: " + "\n '"+file+"'.");
        }		
	}

	public static String editPlaceHolder(String placeHolderString) throws IOException {
		System.out.println("The standardized exception to be added is: ");
		System.out.println(placeHolderString);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Commands available: ");
		System.out.println("1. accept: accept this change, add it to the catch block");
		System.out.println("2. edit: edit this change by hand before replacing");
		System.out.print("Enter command: ");
		String input = br.readLine();
		if(input.equals("accept") || input.equals("1")){
			System.out.printf("Placing %s into the CatchBlock\n", placeHolderString);
		} else if (input.equals("edit") || input.equals("2")){
			input = br.readLine();
		}
		return placeHolderString;
	}

	public static String readFileToString(String strFilePath) throws IOException {
		File file = new File(strFilePath);
		return  FileUtils.readFileToString(file);    
	}

	/**
	 * Convert the string to upper case and place underscores
	 * @param catchBlock
	 * @return
	 */
	public static String[] getExceptionSplit(String catchBlock) {
		//We split the string because we get the exception class and name
		String[] strExcSplit = catchBlock.split("\\s+");
		
		//If standard exception, return as JAVA_EXCEPTION
		if(strExcSplit[0].equalsIgnoreCase("Exception")) {
			strExcSplit[0] = "JAVA_EXCEPTION";
		} else {
			//Put an underscore in front of each upper case
			strExcSplit[0] = strExcSplit[0].replaceAll("(.)([A-Z])", "$1_$2");

			//Turn the whole string to upper case
			strExcSplit[0] = strExcSplit[0].toUpperCase();
		}
		//Return the string split by whitespace
		return strExcSplit;
	}
}