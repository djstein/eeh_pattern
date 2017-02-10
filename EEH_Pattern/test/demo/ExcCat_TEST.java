package test.demo;

import java.util.Hashtable;

import com.ibm.mq.exc.ExceptionHandler;
import com.ibm.mq.exc.ExceptionHandler.CatalogedException;
import com.ibm.mq.exc.ExceptionHandler.ExcCatInfo;
import com.ibm.mq.exc.ExceptionHandler.ExcInfo;

public class ExcCat_TEST{

	public static final String name = "ExcCat.TEST";
	public static final String version = "1.0.0";
	public static final int expiry = 604800;
	public static final String descr = "Internal Exception Catalog for EEH.";

	/**
	 * 
	 * 
	 * @param strTODO	Description of the exception
	 * 
	 * @return CatalogedException for named exception <B>EMPTY_STACK_EXCEPTION</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excEMPTY_STACK_EXCEPTION(
											String strTODO) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("TODO",strTODO);

		return new CatalogedException(ExceptionHandler.PRI_INFO,
						"EMPTY_STACK_EXCEPTION",hashParm,name,version);
	}

	/**
	 * Installation path cannot be determined!
	 * 
	 * @param strKey	The key looked for in the environment variable.
	 * 
	 * @return CatalogedException for named exception <B>INSTALL_PATH_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excINSTALL_PATH_UNDEF(
											String strKey) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Key",strKey);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"INSTALL_PATH_UNDEF",hashParm,name,version);
	}

	/**
	 * Host could not be deternimed!
	 * 
	 * 
	 * @return CatalogedException for named exception <B>HOST_UNKNOWN</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excHOST_UNKNOWN() throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"HOST_UNKNOWN",hashParm,name,version);
	}

	/**
	 * File not found Error!
	 * 
	 * @param strFile	Filename and path of the file that could not be located.
	 * 
	 * @return CatalogedException for named exception <B>FILE_NOT_FOUND</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excFILE_NOT_FOUND(
											String strFile) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("File",strFile);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"FILE_NOT_FOUND",hashParm,name,version);
	}

	/**
	 * I/O Exception generated at runtime; please refer to the exception dump!
	 * 
	 * 
	 * @return CatalogedException for named exception <B>IO</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excIO() throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"IO",hashParm,name,version);
	}

	/**
	 * Class could not be found!
	 * 
	 * @param strClass	Class name that could not be located.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_UNDEF(
											String strClass) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CLASS_UNDEF",hashParm,name,version);
	}

	/**
	 * Class could not be found!
	 * 
	 * @param strClass	Class name that could not be located.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_INSTANTIATION_ERROR</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_INSTANTIATION_ERROR(
											String strClass) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CLASS_INSTANTIATION_ERROR",hashParm,name,version);
	}

	/**
	 * Class attibute looked up by reflection could not be found!
	 * 
	 * @param strClass	Class name.
	 * @param strAttribute	Attribute name that could not be located.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_ATTRIBUTE_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_ATTRIBUTE_UNDEF(
											String strClass,
											String strAttribute) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);
		hashParm.put("Attribute",strAttribute);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CLASS_ATTRIBUTE_UNDEF",hashParm,name,version);
	}

	/**
	 * Class method looked up by reflection could not be found!
	 * 
	 * @param strClass	Class name.
	 * @param strMethod	Method name that could not be located.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_METHOD_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_METHOD_UNDEF(
											String strClass,
											String strMethod) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);
		hashParm.put("Method",strMethod);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CLASS_METHOD_UNDEF",hashParm,name,version);
	}

	/**
	 * Class attibute looked up by reflection could not be invoked!
	 * 
	 * @param strClass	Class name.
	 * @param strAttribute	Attribute name that could not be invoked.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_ATTRIBUTE_INVOKE_ERROR</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_ATTRIBUTE_INVOKE_ERROR(
											String strClass,
											String strAttribute) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);
		hashParm.put("Attribute",strAttribute);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CLASS_ATTRIBUTE_INVOKE_ERROR",hashParm,name,version);
	}

	/**
	 * Class method looked up by reflection could not be invoked!
	 * 
	 * @param strClass	Class name.
	 * @param strMethod	Method name that could not be invoked.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_METHOD_INVOKE_ERROR</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_METHOD_INVOKE_ERROR(
											String strClass,
											String strMethod) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);
		hashParm.put("Method",strMethod);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CLASS_METHOD_INVOKE_ERROR",hashParm,name,version);
	}

	/**
	 * The thread has been interrupted!
	 * 
	 * @param strMessage	Interruption message.
	 * 
	 * @return CatalogedException for named exception <B>INERRUPTED</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excINERRUPTED(
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_WARN,
						"INERRUPTED",hashParm,name,version);
	}

	/**
	 * File or Directory is inaccessible in the path!
	 * 
	 * @param strPath	Path specified for File or Directory.
	 * 
	 * @return CatalogedException for named exception <B>FILE_SECURITY</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excFILE_SECURITY(
											String strPath) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Path",strPath);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"FILE_SECURITY",hashParm,name,version);
	}

	/**
	 * Class accessed violates security restrictions!
	 * 
	 * @param strClass	The class that is being accessed.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_INACCESSIBLE</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_INACCESSIBLE(
											String strClass) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CLASS_INACCESSIBLE",hashParm,name,version);
	}

	/**
	 * Class attribute accessed using reflections violates security restrictions!
	 * 
	 * @param strClass	Class Name.
	 * @param strAttribute	Attribute name that could not be accessed.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_ATTRIBUTE_INACCESSIBLE</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_ATTRIBUTE_INACCESSIBLE(
											String strClass,
											String strAttribute) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);
		hashParm.put("Attribute",strAttribute);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CLASS_ATTRIBUTE_INACCESSIBLE",hashParm,name,version);
	}

	/**
	 * Class method accessed using reflections violates security restrictions!
	 * 
	 * @param strClass	Class Name.
	 * @param strMethod	Method name that could not be accessed.
	 * 
	 * @return CatalogedException for named exception <B>CLASS_METHOD_INACCESSIBLE</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCLASS_METHOD_INACCESSIBLE(
											String strClass,
											String strMethod) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);
		hashParm.put("Method",strMethod);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CLASS_METHOD_INACCESSIBLE",hashParm,name,version);
	}

	/**
	 * Default Class Constructor accessed violates security restrictions!
	 * 
	 * @param strClass	The class that is being attempted for instantiation.
	 * 
	 * @return CatalogedException for named exception <B>DEF_CONSTR_INACCESSIBLE</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excDEF_CONSTR_INACCESSIBLE(
											String strClass) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Class",strClass);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"DEF_CONSTR_INACCESSIBLE",hashParm,name,version);
	}

	/**
	 * Cipher Alogorithm provided is not supported by the provider!
	 * 
	 * @param strAlgorithm	Cipher Algorithm.
	 * @param strMessage	Exception Message.
	 * 
	 * @return CatalogedException for named exception <B>CIPHER_ALG_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCIPHER_ALG_UNDEF(
											String strAlgorithm,
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Algorithm",strAlgorithm);
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CIPHER_ALG_UNDEF",hashParm,name,version);
	}

	/**
	 * Padding with the Cipher Alogorithm provided is not supported by the provider!
	 * 
	 * @param strAlgorithm	Cipher Algorithm.
	 * @param strMessage	Exception Message.
	 * 
	 * @return CatalogedException for named exception <B>CIPHER_PAD_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCIPHER_PAD_UNDEF(
											String strAlgorithm,
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Algorithm",strAlgorithm);
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CIPHER_PAD_UNDEF",hashParm,name,version);
	}

	/**
	 * The Cipher Key provided for encryption or decryption is invalid!
	 * 
	 * @param strMode	Cipher Mode = ENCRYPT_MODE or DECRYPT_MODE.
	 * @param strMessage	Exception Message.
	 * 
	 * @return CatalogedException for named exception <B>CIPHER_KEY_INVALID</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCIPHER_KEY_INVALID(
											String strMode,
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Mode",strMode);
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CIPHER_KEY_INVALID",hashParm,name,version);
	}

	/**
	 * The Cipher Block Size is invalid!
	 * 
	 * @param strMessage	Exception Message.
	 * 
	 * @return CatalogedException for named exception <B>CIPHER_BLOCK_SIZE</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCIPHER_BLOCK_SIZE(
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CIPHER_BLOCK_SIZE",hashParm,name,version);
	}

	/**
	 * The Cipher Padding is invalid!
	 * 
	 * @param strMessage	Exception Message.
	 * 
	 * @return CatalogedException for named exception <B>CIPHER_BAD_PAD</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCIPHER_BAD_PAD(
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"CIPHER_BAD_PAD",hashParm,name,version);
	}

	/**
	 * XML Validation Error!
	 * 
	 * @param strSystemId	System identifier of the xml file.
	 * @param strMessage	Reason for the XML violation to occur.
	 * @param strColumnNo	Column number where the exception occerred.
	 * @param strLineNo	Line number where the exception occurred.
	 * @param strPublicId	External public Identifier if one exits.
	 * 
	 * @return CatalogedException for named exception <B>XML_VALIDATION</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excXML_VALIDATION(
											String strSystemId,
											String strMessage,
											String strColumnNo,
											String strLineNo,
											String strPublicId) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("SystemId",strSystemId);
		hashParm.put("Message",strMessage);
		hashParm.put("ColumnNo",strColumnNo);
		hashParm.put("LineNo",strLineNo);
		hashParm.put("PublicId",strPublicId);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"XML_VALIDATION",hashParm,name,version);
	}

	/**
	 * XMLNS Validation Error! Valid XML Namespace is 'urn:com.ibm.mq.exc'.
	 * 
	 * @param strInvalidXMLNS	Invalid XML Namespace.
	 * 
	 * @return CatalogedException for named exception <B>XMLNS_VALIDATION</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excXMLNS_VALIDATION(
											String strInvalidXMLNS) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("InvalidXMLNS",strInvalidXMLNS);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"XMLNS_VALIDATION",hashParm,name,version);
	}

	/**
	 * Exception Catalog has not been defined!
	 * 
	 * 
	 * @return CatalogedException for named exception <B>CATALOG_NULL</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCATALOG_NULL() throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CATALOG_NULL",hashParm,name,version);
	}

	/**
	 * Exception Catalog is being redefined!
	 * 
	 * @param strExcCat	Exception Catalog.
	 * @param strExcCatVer	Exception Catalog Version.
	 * 
	 * @return CatalogedException for named exception <B>CATALOG_REDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCATALOG_REDEF(
											String strExcCat,
											String strExcCatVer) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("ExcCat",strExcCat);
		hashParm.put("ExcCatVer",strExcCatVer);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CATALOG_REDEF",hashParm,name,version);
	}

	/**
	 * Exception Catalog is not defined!
	 * 
	 * @param strCallStack	Call Stack of the original Exception.
	 * @param strExcCat	Exception Catalog.
	 * @param strExcCatVer	Exception Catalog Version.
	 * 
	 * @return CatalogedException for named exception <B>CATALOG_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCATALOG_UNDEF(
											String strCallStack,
											String strExcCat,
											String strExcCatVer) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("CallStack",strCallStack);
		hashParm.put("ExcCat",strExcCat);
		hashParm.put("ExcCatVer",strExcCatVer);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CATALOG_UNDEF",hashParm,name,version);
	}

	/**
	 * Application Identifier is being redefined!
	 * 
	 * @param strAppId_New	New Application Identifier conflict.
	 * @param strAppId	Application Identifier defined.
	 * 
	 * @return CatalogedException for named exception <B>APPID_REDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excAPPID_REDEF(
											String strAppId_New,
											String strAppId) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("AppId_New",strAppId_New);
		hashParm.put("AppId",strAppId);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"APPID_REDEF",hashParm,name,version);
	}

	/**
	 * Exception is not defined in the catalog!
	 * 
	 * @param strCallStack	Call Stack of the original Exception.
	 * @param strExc	Exception not found in the catalog.
	 * @param strExcCat	Exception Catalog.
	 * @param strExcCatVer	Exception Catalog Version.
	 * 
	 * @return CatalogedException for named exception <B>EXCEPTION_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excEXCEPTION_UNDEF(
											String strCallStack,
											String strExc,
											String strExcCat,
											String strExcCatVer) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("CallStack",strCallStack);
		hashParm.put("Exc",strExc);
		hashParm.put("ExcCat",strExcCat);
		hashParm.put("ExcCatVer",strExcCatVer);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"EXCEPTION_UNDEF",hashParm,name,version);
	}

	/**
	 * Exception parameter is not valid for the Exception in the catalog!
	 * 
	 * @param strCallStack	Call Stack of the original Exception.
	 * @param strParms	Exception parameter not valid for the Exception.
	 * @param strInvalidParms	Exception parameter not valid for the Exception.
	 * @param strExc	Exception found in the catalog.
	 * @param strExcCat	Exception Catalog.
	 * @param strExcCatVer	Exception Catalog Version.
	 * 
	 * @return CatalogedException for named exception <B>PARM_INVALID</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excPARM_INVALID(
											String strCallStack,
											String strParms,
											String strInvalidParms,
											String strExc,
											String strExcCat,
											String strExcCatVer) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("CallStack",strCallStack);
		hashParm.put("Parms",strParms);
		hashParm.put("InvalidParms",strInvalidParms);
		hashParm.put("Exc",strExc);
		hashParm.put("ExcCat",strExcCat);
		hashParm.put("ExcCatVer",strExcCatVer);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"PARM_INVALID",hashParm,name,version);
	}

	/**
	 * Queue Manager connection redefinition; one has already been defined!
	 * 
	 * @param strQMgr	Queue Manager being redefined.
	 * 
	 * @return CatalogedException for named exception <B>QMGR_CONN_REDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excQMGR_CONN_REDEF(
											String strQMgr) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("QMgr",strQMgr);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"QMGR_CONN_REDEF",hashParm,name,version);
	}

	/**
	 * Re-Queue queue name has not been defined!
	 * 
	 * 
	 * @return CatalogedException for named exception <B>REQUEUE_NOT_SET</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excREQUEUE_NOT_SET() throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"REQUEUE_NOT_SET",hashParm,name,version);
	}

	/**
	 * Queue name has not been defined!
	 * 
	 * 
	 * @return CatalogedException for named exception <B>QUEUE_NOT_SET</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excQUEUE_NOT_SET() throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"QUEUE_NOT_SET",hashParm,name,version);
	}

	/**
	 * Exception Dump redefinition; one has already been defined!
	 * 
	 * @param strDumpType	The type of exception dump already set.
	 * 
	 * @return CatalogedException for named exception <B>DUMP_REDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excDUMP_REDEF(
											String strDumpType) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("DumpType",strDumpType);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"DUMP_REDEF",hashParm,name,version);
	}

	/**
	 * Exception Dump type is not supported! Supported types are binary, string, xml, java:Exception, java:DumpRenderer.
	 * 
	 * @param strDumpType	The type of exception dump provided.
	 * 
	 * @return CatalogedException for named exception <B>DUMP_UNSUPPORTED</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excDUMP_UNSUPPORTED(
											String strDumpType) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("DumpType",strDumpType);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"DUMP_UNSUPPORTED",hashParm,name,version);
	}

	/**
	 * Data format type redefinition; one has already been defined!
	 * 
	 * @param strDataType	The type of data format already set.
	 * 
	 * @return CatalogedException for named exception <B>DATA_REDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excDATA_REDEF(
											String strDataType) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("DataType",strDataType);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"DATA_REDEF",hashParm,name,version);
	}

	/**
	 * Exception Data format type is not supported! Supported types are binary, string, xml, java:MQMessage, java:JMSMessage, java:DataRenderer.
	 * 
	 * @param strDataType	The type of Data format provided.
	 * 
	 * @return CatalogedException for named exception <B>DATA_UNSUPPORTED</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excDATA_UNSUPPORTED(
											String strDataType) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("DataType",strDataType);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"DATA_UNSUPPORTED",hashParm,name,version);
	}

	/**
	 * URL provided was not formatted properly.
	 * 
	 * @param strURL	Universal Resource Locator.
	 * 
	 * @return CatalogedException for named exception <B>MALFORMED_URL</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excMALFORMED_URL(
											String strURL) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("URL",strURL);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"MALFORMED_URL",hashParm,name,version);
	}

	/**
	 * Mandatory parameter is not specified.
	 * 
	 * @param strSource	Reference to the source File, Object, etc. where the parameter is checked.
	 * @param strParm	Mandatory parameter.
	 * 
	 * @return CatalogedException for named exception <B>MANDATORY_PARM_MISSING</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excMANDATORY_PARM_MISSING(
											String strSource,
											String strParm) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Source",strSource);
		hashParm.put("Parm",strParm);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"MANDATORY_PARM_MISSING",hashParm,name,version);
	}

	/**
	 * Error parsing the parameter to the specified class.
	 * 
	 * @param strSource	Reference to the source File, Object, etc. where the parameter is checked.
	 * @param strClass	Class or primitive the parameter value was to be parsed.
	 * @param strParm	Parameter.
	 * @param strValue	Parameter value that could not be parsed.
	 * 
	 * @return CatalogedException for named exception <B>PARM_PARSING_ERROR</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excPARM_PARSING_ERROR(
											String strSource,
											String strClass,
											String strParm,
											String strValue) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Source",strSource);
		hashParm.put("Class",strClass);
		hashParm.put("Parm",strParm);
		hashParm.put("Value",strValue);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"PARM_PARSING_ERROR",hashParm,name,version);
	}

	/**
	 * Execution Environment redefinition; one has already been defined!
	 * 
	 * @param strEnvironment	The runtime environment already defined, e.g. DEV, TEST, QA, PROD.
	 * 
	 * @return CatalogedException for named exception <B>ENV_REDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excENV_REDEF(
											String strEnvironment) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Environment",strEnvironment);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"ENV_REDEF",hashParm,name,version);
	}

	/**
	 * Exception Catalog is being used by the Exceptions stored in the database!
	 * 
	 * @param strExcCat	Exception Catalog.
	 * @param strExcCatVer	Exception Catalog Version.
	 * 
	 * @return CatalogedException for named exception <B>CATALOG_IN_USE</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excCATALOG_IN_USE(
											String strExcCat,
											String strExcCatVer) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("ExcCat",strExcCat);
		hashParm.put("ExcCatVer",strExcCatVer);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"CATALOG_IN_USE",hashParm,name,version);
	}

	/**
	 * Exception definition in the catalog is being used by the Exceptions stored in the database!
	 * 
	 * @param strExcCat	Exception Catalog.
	 * @param strExcCatVer	Exception Catalog Version.
	 * @param strExcCode	Exception Code.
	 * 
	 * @return CatalogedException for named exception <B>EXCEPTION_IN_USE</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excEXCEPTION_IN_USE(
											String strExcCat,
											String strExcCatVer,
											String strExcCode) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("ExcCat",strExcCat);
		hashParm.put("ExcCatVer",strExcCatVer);
		hashParm.put("ExcCode",strExcCode);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"EXCEPTION_IN_USE",hashParm,name,version);
	}

	/**
	 * This is a Generic NULL pointer Java Exception.
	 * 
	 * @param strCause	Cause for Exception object generation.
	 * @param strMessage	Message generated by the Exception Object.
	 * 
	 * @return CatalogedException for named exception <B>NULL_POINTER_EXCEPTION</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excNULL_POINTER_EXCEPTION(
											String strCause,
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Cause",strCause);
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"NULL_POINTER_EXCEPTION",hashParm,name,version);
	}

	/**
	 * This is a Generic Java Exception class error.
	 * 
	 * @param strCause	Cause for Exception object generation.
	 * @param strMessage	Message generated by the Exception Object.
	 * 
	 * @return CatalogedException for named exception <B>JAVA_EXCEPTION</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excJAVA_EXCEPTION(
											String strCause,
											String strMessage) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Cause",strCause);
		hashParm.put("Message",strMessage);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"JAVA_EXCEPTION",hashParm,name,version);
	}

	/**
	 * Exception parameter is not valid for the Exception in the catalog ExcCat.ExcH ! This is an internal ExceptionHandler fatal error and is caught to avoid infinite recursive exception invokations.
	 * 
	 * @param strCallStack	Call Stack of the original Exception.
	 * @param strParms	Exception parameter not valid for the Exception.
	 * @param strInvalidParms	Exception parameter not valid for the Exception.
	 * @param strExc	Exception found in the catalog.
	 * @param strExcCat	Exception Catalog.
	 * @param strExcCatVer	Exception Catalog Version.
	 * 
	 * @return CatalogedException for named exception <B>PARM_INVALID_INTERNAL</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excPARM_INVALID_INTERNAL(
											String strCallStack,
											String strParms,
											String strInvalidParms,
											String strExc,
											String strExcCat,
											String strExcCatVer) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("CallStack",strCallStack);
		hashParm.put("Parms",strParms);
		hashParm.put("InvalidParms",strInvalidParms);
		hashParm.put("Exc",strExc);
		hashParm.put("ExcCat",strExcCat);
		hashParm.put("ExcCatVer",strExcCatVer);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"PARM_INVALID_INTERNAL",hashParm,name,version);
	}

	/**
	 * An Unknown exception has occurred in the system. Please send the stack trace to arunava@us.ibm.com with the Subject as PMR:ExceptionHandler and your contact details.
	 * 
	 * @param strCallStack	XML format of the call stack when the Exception was generated.
	 * 
	 * @return CatalogedException for named exception <B>UNKNOWN</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excUNKNOWN(
											String strCallStack) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("CallStack",strCallStack);

		return new CatalogedException(ExceptionHandler.PRI_FATAL,
						"UNKNOWN",hashParm,name,version);
	}

	/**
	 * WebSphere MQ error!
	 * 
	 * @param strReason	Reason code returned form WMQ.
	 * 
	 * @return CatalogedException for named exception <B>WMQ</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excWMQ(
											String strReason) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Reason",strReason);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"WMQ",hashParm,name,version);
	}

	/**
	 * Java Messaging Service error!
	 * 
	 * @param strErrorCode	Error code returned form JMS vendor.
	 * 
	 * @return CatalogedException for named exception <B>JMS</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excJMS(
											String strErrorCode) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("ErrorCode",strErrorCode);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"JMS",hashParm,name,version);
	}

	/**
	 * ExceptionList object captured! This is a generic Exception caught inside the Message Flow and not intended to be used for User Exceptions that should be catagorized and analyzed.
	 * 
	 * @param strType	Source object type.
	 * @param strFunction	C++ source function name.
	 * @param strCatalog	NLS message catalog name.
	 * @param strText	Additional text.
	 * @param strLabel	Source object label.
	 * @param strLine	C++ source file line number.
	 * @param strName	Source object name.
	 * @param strExceptionType	The type of Exception that was generated. It is of the following types - RecoverableException, ParserException, ConversionException, DatabaseException, UserException, SecurityException, CastException, MessageException, SqlException, SocketException, SocketTimeoutException.
	 * @param strNumber	NLS message number.
	 * @param strFile	C++ source file name.
	 * @param strSeverity	1 = information, 2 = warning, 3 = error.
	 * 
	 * @return CatalogedException for named exception <B>WMB</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excWMB(
											String strType,
											String strFunction,
											String strCatalog,
											String strText,
											String strLabel,
											String strLine,
											String strName,
											String strExceptionType,
											String strNumber,
											String strFile,
											String strSeverity) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Type",strType);
		hashParm.put("Function",strFunction);
		hashParm.put("Catalog",strCatalog);
		hashParm.put("Text",strText);
		hashParm.put("Label",strLabel);
		hashParm.put("Line",strLine);
		hashParm.put("Name",strName);
		hashParm.put("ExceptionType",strExceptionType);
		hashParm.put("Number",strNumber);
		hashParm.put("File",strFile);
		hashParm.put("Severity",strSeverity);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"WMB",hashParm,name,version);
	}

	/**
	 * Message Broker Config Manager Proxy API Logged error!
	 * 
	 * @param strServiceInfo	The Service Information returned from the error in the CMP API.
	 * 
	 * @return CatalogedException for named exception <B>WMB_CMP_LOGGED</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excWMB_CMP_LOGGED(
											String strServiceInfo) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("ServiceInfo",strServiceInfo);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"WMB_CMP_LOGGED",hashParm,name,version);
	}

	/**
	 * Message Broker Config Manager Proxy API error initializing the Property object!
	 * 
	 * 
	 * @return CatalogedException for named exception <B>WMB_CMP_PROP_INIT_ERROR</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excWMB_CMP_PROP_INIT_ERROR() throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"WMB_CMP_PROP_INIT_ERROR",hashParm,name,version);
	}

	/**
	 * Message Broker Configurable Service is not defined!
	 * 
	 * @param strConfigService	The Configuration Service name looked up.
	 * @param strConfigServiceType	The type of the Configuration Service name looked up.
	 * 
	 * @return CatalogedException for named exception <B>WMB_CONFIG_SERVICE_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excWMB_CONFIG_SERVICE_UNDEF(
											String strConfigService,
											String strConfigServiceType) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("ConfigService",strConfigService);
		hashParm.put("ConfigServiceType",strConfigServiceType);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"WMB_CONFIG_SERVICE_UNDEF",hashParm,name,version);
	}

	/**
	 * Message Broker Configurable Service property is not defined in the Configurable Service!
	 * 
	 * @param strConfigServiceProp	The Configuration Service property.
	 * @param strConfigService	The Configuration Service name looked up.
	 * @param strConfigServiceType	The type of the Configuration Service name looked up.
	 * 
	 * @return CatalogedException for named exception <B>WMB_CONFIG_SERVICE_PROP_UNDEF</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excWMB_CONFIG_SERVICE_PROP_UNDEF(
											String strConfigServiceProp,
											String strConfigService,
											String strConfigServiceType) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("ConfigServiceProp",strConfigServiceProp);
		hashParm.put("ConfigService",strConfigService);
		hashParm.put("ConfigServiceType",strConfigServiceType);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"WMB_CONFIG_SERVICE_PROP_UNDEF",hashParm,name,version);
	}

	/**
	 * Database SQL error!
	 * 
	 * @param strSQLCODE	SQLCODE for the vender specific database error.
	 * @param strSQLMSG	Message for the database error.
	 * @param strSQLSTATE	SQLSTATE for the database error.
	 * 
	 * @return CatalogedException for named exception <B>SQL</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excSQL(
											String strSQLCODE,
											String strSQLMSG,
											String strSQLSTATE) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("SQLCODE",strSQLCODE);
		hashParm.put("SQLMSG",strSQLMSG);
		hashParm.put("SQLSTATE",strSQLSTATE);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"SQL",hashParm,name,version);
	}

	/**
	 * Eclipse Framework generated Core Exception.
	 * 
	 * @param strStatusCode	Status Code.
	 * @param strStatusSeverity	Status Severity.
	 * @param strStatusMessage	Status Message.
	 * @param strExceptionClass	Low-level Exception Class name.
	 * @param strExceptionCause	Low-level Exception Cause.
	 * @param strExceptionMessage	Low-level Exception Message.
	 * @param strPluginId	Unique Identifier for the Eclipse Plugin that caused the Exception condition.
	 * 
	 * @return CatalogedException for named exception <B>ECLIPSE_CORE_EXCEPTION</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excECLIPSE_CORE_EXCEPTION(
											String strStatusCode,
											String strStatusSeverity,
											String strStatusMessage,
											String strExceptionClass,
											String strExceptionCause,
											String strExceptionMessage,
											String strPluginId) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("StatusCode",strStatusCode);
		hashParm.put("StatusSeverity",strStatusSeverity);
		hashParm.put("StatusMessage",strStatusMessage);
		hashParm.put("ExceptionClass",strExceptionClass);
		hashParm.put("ExceptionCause",strExceptionCause);
		hashParm.put("ExceptionMessage",strExceptionMessage);
		hashParm.put("PluginId",strPluginId);

		return new CatalogedException(ExceptionHandler.PRI_ERR,
						"ECLIPSE_CORE_EXCEPTION",hashParm,name,version);
	}

	/**
	 * Eclipse Plugin has been updated.
	 * 
	 * @param strPlugin	Eclipse Plugin Id.
	 * @param strVersion	Eclipse Plugin Version.
	 * 
	 * @return CatalogedException for named exception <B>ECLIPSE_PLUGIN_UPDATED</B>
	 * 
	 * @exception CatalogedException of the following flavours:<BR>
	 *                - EXC_CAT.CATALOG_UNDEF<BR>
	 *                - EXC_CAT.EXCEPTION_UNDEF<BR>
	 *                - EXC_CAT.PARM_INVALID<BR>
	 *                - EXC_CAT.PARM_INVALID_INTERNAL<BR>
	 */
	public static CatalogedException excECLIPSE_PLUGIN_UPDATED(
											String strPlugin,
											String strVersion) throws CatalogedException {

		Hashtable<String,String> hashParm = new Hashtable<String,String>();
		hashParm.put("Plugin",strPlugin);
		hashParm.put("Version",strVersion);

		return new CatalogedException(ExceptionHandler.PRI_INFO,
						"ECLIPSE_PLUGIN_UPDATED",hashParm,name,version);
	}

	/**
	 * Setup function for static Exception Catalog loading.
	 * @return ExcCatInfo - Exception Catalog object that may be statically loaded.
	 */
	public static ExcCatInfo getExcCatInfo() {
		ExcCatInfo excCatInfo = new ExcCatInfo();
		excCatInfo.strCatalog = name;
		excCatInfo.strVersion = version;
		excCatInfo.nExpiry = expiry;
		excCatInfo.strDescr = descr;

		ExcInfo ei = null;

		// EXC_EMPTY_STACK_EXCEPTION
		ei = new ExcInfo();
		ei.strExc = "EMPTY_STACK_EXCEPTION";
		ei.nPriority = 1;
		ei.nCode = 90001;
		ei.strDescr = "";
		ei.addParameter("TODO","Description of the exception");
		excCatInfo.addException(ei);

		// EXC_INSTALL_PATH_UNDEF
		ei = new ExcInfo();
		ei.strExc = "INSTALL_PATH_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 91001;
		ei.strDescr = "Installation path cannot be determined!";
		ei.addParameter("Key","The key looked for in the environment variable.");
		excCatInfo.addException(ei);

		// EXC_HOST_UNKNOWN
		ei = new ExcInfo();
		ei.strExc = "HOST_UNKNOWN";
		ei.nPriority = 3;
		ei.nCode = 91002;
		ei.strDescr = "Host could not be deternimed!";
		excCatInfo.addException(ei);

		// EXC_FILE_NOT_FOUND
		ei = new ExcInfo();
		ei.strExc = "FILE_NOT_FOUND";
		ei.nPriority = 3;
		ei.nCode = 91003;
		ei.strDescr = "File not found Error!";
		ei.addParameter("File","Filename and path of the file that could not be located.");
		excCatInfo.addException(ei);

		// EXC_IO
		ei = new ExcInfo();
		ei.strExc = "IO";
		ei.nPriority = 3;
		ei.nCode = 91004;
		ei.strDescr = "I/O Exception generated at runtime; please refer to the exception dump!";
		excCatInfo.addException(ei);

		// EXC_CLASS_UNDEF
		ei = new ExcInfo();
		ei.strExc = "CLASS_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 91005;
		ei.strDescr = "Class could not be found!";
		ei.addParameter("Class","Class name that could not be located.");
		excCatInfo.addException(ei);

		// EXC_CLASS_INSTANTIATION_ERROR
		ei = new ExcInfo();
		ei.strExc = "CLASS_INSTANTIATION_ERROR";
		ei.nPriority = 3;
		ei.nCode = 91006;
		ei.strDescr = "Class could not be found!";
		ei.addParameter("Class","Class name that could not be located.");
		excCatInfo.addException(ei);

		// EXC_CLASS_ATTRIBUTE_UNDEF
		ei = new ExcInfo();
		ei.strExc = "CLASS_ATTRIBUTE_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 91007;
		ei.strDescr = "Class attibute looked up by reflection could not be found!";
		ei.addParameter("Class","Class name.");
		ei.addParameter("Attribute","Attribute name that could not be located.");
		excCatInfo.addException(ei);

		// EXC_CLASS_METHOD_UNDEF
		ei = new ExcInfo();
		ei.strExc = "CLASS_METHOD_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 91008;
		ei.strDescr = "Class method looked up by reflection could not be found!";
		ei.addParameter("Class","Class name.");
		ei.addParameter("Method","Method name that could not be located.");
		excCatInfo.addException(ei);

		// EXC_CLASS_ATTRIBUTE_INVOKE_ERROR
		ei = new ExcInfo();
		ei.strExc = "CLASS_ATTRIBUTE_INVOKE_ERROR";
		ei.nPriority = 3;
		ei.nCode = 91009;
		ei.strDescr = "Class attibute looked up by reflection could not be invoked!";
		ei.addParameter("Class","Class name.");
		ei.addParameter("Attribute","Attribute name that could not be invoked.");
		excCatInfo.addException(ei);

		// EXC_CLASS_METHOD_INVOKE_ERROR
		ei = new ExcInfo();
		ei.strExc = "CLASS_METHOD_INVOKE_ERROR";
		ei.nPriority = 3;
		ei.nCode = 91010;
		ei.strDescr = "Class method looked up by reflection could not be invoked!";
		ei.addParameter("Class","Class name.");
		ei.addParameter("Method","Method name that could not be invoked.");
		excCatInfo.addException(ei);

		// EXC_INERRUPTED
		ei = new ExcInfo();
		ei.strExc = "INERRUPTED";
		ei.nPriority = 2;
		ei.nCode = 91011;
		ei.strDescr = "The thread has been interrupted!";
		ei.addParameter("Message","Interruption message.");
		excCatInfo.addException(ei);

		// EXC_FILE_SECURITY
		ei = new ExcInfo();
		ei.strExc = "FILE_SECURITY";
		ei.nPriority = 4;
		ei.nCode = 93001;
		ei.strDescr = "File or Directory is inaccessible in the path!";
		ei.addParameter("Path","Path specified for File or Directory.");
		excCatInfo.addException(ei);

		// EXC_CLASS_INACCESSIBLE
		ei = new ExcInfo();
		ei.strExc = "CLASS_INACCESSIBLE";
		ei.nPriority = 4;
		ei.nCode = 93002;
		ei.strDescr = "Class accessed violates security restrictions!";
		ei.addParameter("Class","The class that is being accessed.");
		excCatInfo.addException(ei);

		// EXC_CLASS_ATTRIBUTE_INACCESSIBLE
		ei = new ExcInfo();
		ei.strExc = "CLASS_ATTRIBUTE_INACCESSIBLE";
		ei.nPriority = 4;
		ei.nCode = 93003;
		ei.strDescr = "Class attribute accessed using reflections violates security restrictions!";
		ei.addParameter("Class","Class Name.");
		ei.addParameter("Attribute","Attribute name that could not be accessed.");
		excCatInfo.addException(ei);

		// EXC_CLASS_METHOD_INACCESSIBLE
		ei = new ExcInfo();
		ei.strExc = "CLASS_METHOD_INACCESSIBLE";
		ei.nPriority = 4;
		ei.nCode = 93004;
		ei.strDescr = "Class method accessed using reflections violates security restrictions!";
		ei.addParameter("Class","Class Name.");
		ei.addParameter("Method","Method name that could not be accessed.");
		excCatInfo.addException(ei);

		// EXC_DEF_CONSTR_INACCESSIBLE
		ei = new ExcInfo();
		ei.strExc = "DEF_CONSTR_INACCESSIBLE";
		ei.nPriority = 4;
		ei.nCode = 93005;
		ei.strDescr = "Default Class Constructor accessed violates security restrictions!";
		ei.addParameter("Class","The class that is being attempted for instantiation.");
		excCatInfo.addException(ei);

		// EXC_CIPHER_ALG_UNDEF
		ei = new ExcInfo();
		ei.strExc = "CIPHER_ALG_UNDEF";
		ei.nPriority = 4;
		ei.nCode = 93006;
		ei.strDescr = "Cipher Alogorithm provided is not supported by the provider!";
		ei.addParameter("Algorithm","Cipher Algorithm.");
		ei.addParameter("Message","Exception Message.");
		excCatInfo.addException(ei);

		// EXC_CIPHER_PAD_UNDEF
		ei = new ExcInfo();
		ei.strExc = "CIPHER_PAD_UNDEF";
		ei.nPriority = 4;
		ei.nCode = 93007;
		ei.strDescr = "Padding with the Cipher Alogorithm provided is not supported by the provider!";
		ei.addParameter("Algorithm","Cipher Algorithm.");
		ei.addParameter("Message","Exception Message.");
		excCatInfo.addException(ei);

		// EXC_CIPHER_KEY_INVALID
		ei = new ExcInfo();
		ei.strExc = "CIPHER_KEY_INVALID";
		ei.nPriority = 4;
		ei.nCode = 93008;
		ei.strDescr = "The Cipher Key provided for encryption or decryption is invalid!";
		ei.addParameter("Mode","Cipher Mode = ENCRYPT_MODE or DECRYPT_MODE.");
		ei.addParameter("Message","Exception Message.");
		excCatInfo.addException(ei);

		// EXC_CIPHER_BLOCK_SIZE
		ei = new ExcInfo();
		ei.strExc = "CIPHER_BLOCK_SIZE";
		ei.nPriority = 4;
		ei.nCode = 93009;
		ei.strDescr = "The Cipher Block Size is invalid!";
		ei.addParameter("Message","Exception Message.");
		excCatInfo.addException(ei);

		// EXC_CIPHER_BAD_PAD
		ei = new ExcInfo();
		ei.strExc = "CIPHER_BAD_PAD";
		ei.nPriority = 4;
		ei.nCode = 93010;
		ei.strDescr = "The Cipher Padding is invalid!";
		ei.addParameter("Message","Exception Message.");
		excCatInfo.addException(ei);

		// EXC_XML_VALIDATION
		ei = new ExcInfo();
		ei.strExc = "XML_VALIDATION";
		ei.nPriority = 3;
		ei.nCode = 94001;
		ei.strDescr = "XML Validation Error!";
		ei.addParameter("SystemId","System identifier of the xml file.");
		ei.addParameter("Message","Reason for the XML violation to occur.");
		ei.addParameter("ColumnNo","Column number where the exception occerred.");
		ei.addParameter("LineNo","Line number where the exception occurred.");
		ei.addParameter("PublicId","External public Identifier if one exits.");
		excCatInfo.addException(ei);

		// EXC_XMLNS_VALIDATION
		ei = new ExcInfo();
		ei.strExc = "XMLNS_VALIDATION";
		ei.nPriority = 3;
		ei.nCode = 94002;
		ei.strDescr = "XMLNS Validation Error! Valid XML Namespace is 'urn:com.ibm.mq.exc'.";
		ei.addParameter("InvalidXMLNS","Invalid XML Namespace.");
		excCatInfo.addException(ei);

		// EXC_CATALOG_NULL
		ei = new ExcInfo();
		ei.strExc = "CATALOG_NULL";
		ei.nPriority = 3;
		ei.nCode = 94003;
		ei.strDescr = "Exception Catalog has not been defined!";
		excCatInfo.addException(ei);

		// EXC_CATALOG_REDEF
		ei = new ExcInfo();
		ei.strExc = "CATALOG_REDEF";
		ei.nPriority = 3;
		ei.nCode = 94004;
		ei.strDescr = "Exception Catalog is being redefined!";
		ei.addParameter("ExcCat","Exception Catalog.");
		ei.addParameter("ExcCatVer","Exception Catalog Version.");
		excCatInfo.addException(ei);

		// EXC_CATALOG_UNDEF
		ei = new ExcInfo();
		ei.strExc = "CATALOG_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 94005;
		ei.strDescr = "Exception Catalog is not defined!";
		ei.addParameter("CallStack","Call Stack of the original Exception.");
		ei.addParameter("ExcCat","Exception Catalog.");
		ei.addParameter("ExcCatVer","Exception Catalog Version.");
		excCatInfo.addException(ei);

		// EXC_APPID_REDEF
		ei = new ExcInfo();
		ei.strExc = "APPID_REDEF";
		ei.nPriority = 3;
		ei.nCode = 94006;
		ei.strDescr = "Application Identifier is being redefined!";
		ei.addParameter("AppId_New","New Application Identifier conflict.");
		ei.addParameter("AppId","Application Identifier defined.");
		excCatInfo.addException(ei);

		// EXC_EXCEPTION_UNDEF
		ei = new ExcInfo();
		ei.strExc = "EXCEPTION_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 94007;
		ei.strDescr = "Exception is not defined in the catalog!";
		ei.addParameter("CallStack","Call Stack of the original Exception.");
		ei.addParameter("Exc","Exception not found in the catalog.");
		ei.addParameter("ExcCat","Exception Catalog.");
		ei.addParameter("ExcCatVer","Exception Catalog Version.");
		excCatInfo.addException(ei);

		// EXC_PARM_INVALID
		ei = new ExcInfo();
		ei.strExc = "PARM_INVALID";
		ei.nPriority = 3;
		ei.nCode = 94008;
		ei.strDescr = "Exception parameter is not valid for the Exception in the catalog!";
		ei.addParameter("CallStack","Call Stack of the original Exception.");
		ei.addParameter("Parms","Exception parameter not valid for the Exception.");
		ei.addParameter("InvalidParms","Exception parameter not valid for the Exception.");
		ei.addParameter("Exc","Exception found in the catalog.");
		ei.addParameter("ExcCat","Exception Catalog.");
		ei.addParameter("ExcCatVer","Exception Catalog Version.");
		excCatInfo.addException(ei);

		// EXC_QMGR_CONN_REDEF
		ei = new ExcInfo();
		ei.strExc = "QMGR_CONN_REDEF";
		ei.nPriority = 3;
		ei.nCode = 94009;
		ei.strDescr = "Queue Manager connection redefinition; one has already been defined!";
		ei.addParameter("QMgr","Queue Manager being redefined.");
		excCatInfo.addException(ei);

		// EXC_REQUEUE_NOT_SET
		ei = new ExcInfo();
		ei.strExc = "REQUEUE_NOT_SET";
		ei.nPriority = 3;
		ei.nCode = 94010;
		ei.strDescr = "Re-Queue queue name has not been defined!";
		excCatInfo.addException(ei);

		// EXC_QUEUE_NOT_SET
		ei = new ExcInfo();
		ei.strExc = "QUEUE_NOT_SET";
		ei.nPriority = 3;
		ei.nCode = 94011;
		ei.strDescr = "Queue name has not been defined!";
		excCatInfo.addException(ei);

		// EXC_DUMP_REDEF
		ei = new ExcInfo();
		ei.strExc = "DUMP_REDEF";
		ei.nPriority = 3;
		ei.nCode = 94012;
		ei.strDescr = "Exception Dump redefinition; one has already been defined!";
		ei.addParameter("DumpType","The type of exception dump already set.");
		excCatInfo.addException(ei);

		// EXC_DUMP_UNSUPPORTED
		ei = new ExcInfo();
		ei.strExc = "DUMP_UNSUPPORTED";
		ei.nPriority = 3;
		ei.nCode = 94013;
		ei.strDescr = "Exception Dump type is not supported! Supported types are binary, string, xml, java:Exception, java:DumpRenderer.";
		ei.addParameter("DumpType","The type of exception dump provided.");
		excCatInfo.addException(ei);

		// EXC_DATA_REDEF
		ei = new ExcInfo();
		ei.strExc = "DATA_REDEF";
		ei.nPriority = 3;
		ei.nCode = 94014;
		ei.strDescr = "Data format type redefinition; one has already been defined!";
		ei.addParameter("DataType","The type of data format already set.");
		excCatInfo.addException(ei);

		// EXC_DATA_UNSUPPORTED
		ei = new ExcInfo();
		ei.strExc = "DATA_UNSUPPORTED";
		ei.nPriority = 3;
		ei.nCode = 94015;
		ei.strDescr = "Exception Data format type is not supported! Supported types are binary, string, xml, java:MQMessage, java:JMSMessage, java:DataRenderer.";
		ei.addParameter("DataType","The type of Data format provided.");
		excCatInfo.addException(ei);

		// EXC_MALFORMED_URL
		ei = new ExcInfo();
		ei.strExc = "MALFORMED_URL";
		ei.nPriority = 3;
		ei.nCode = 94016;
		ei.strDescr = "URL provided was not formatted properly.";
		ei.addParameter("URL","Universal Resource Locator.");
		excCatInfo.addException(ei);

		// EXC_MANDATORY_PARM_MISSING
		ei = new ExcInfo();
		ei.strExc = "MANDATORY_PARM_MISSING";
		ei.nPriority = 3;
		ei.nCode = 94017;
		ei.strDescr = "Mandatory parameter is not specified.";
		ei.addParameter("Source","Reference to the source File, Object, etc. where the parameter is checked.");
		ei.addParameter("Parm","Mandatory parameter.");
		excCatInfo.addException(ei);

		// EXC_PARM_PARSING_ERROR
		ei = new ExcInfo();
		ei.strExc = "PARM_PARSING_ERROR";
		ei.nPriority = 3;
		ei.nCode = 94018;
		ei.strDescr = "Error parsing the parameter to the specified class.";
		ei.addParameter("Source","Reference to the source File, Object, etc. where the parameter is checked.");
		ei.addParameter("Class","Class or primitive the parameter value was to be parsed.");
		ei.addParameter("Parm","Parameter.");
		ei.addParameter("Value","Parameter value that could not be parsed.");
		excCatInfo.addException(ei);

		// EXC_ENV_REDEF
		ei = new ExcInfo();
		ei.strExc = "ENV_REDEF";
		ei.nPriority = 3;
		ei.nCode = 94019;
		ei.strDescr = "Execution Environment redefinition; one has already been defined!";
		ei.addParameter("Environment","The runtime environment already defined, e.g. DEV, TEST, QA, PROD.");
		excCatInfo.addException(ei);

		// EXC_CATALOG_IN_USE
		ei = new ExcInfo();
		ei.strExc = "CATALOG_IN_USE";
		ei.nPriority = 3;
		ei.nCode = 94020;
		ei.strDescr = "Exception Catalog is being used by the Exceptions stored in the database!";
		ei.addParameter("ExcCat","Exception Catalog.");
		ei.addParameter("ExcCatVer","Exception Catalog Version.");
		excCatInfo.addException(ei);

		// EXC_EXCEPTION_IN_USE
		ei = new ExcInfo();
		ei.strExc = "EXCEPTION_IN_USE";
		ei.nPriority = 3;
		ei.nCode = 94021;
		ei.strDescr = "Exception definition in the catalog is being used by the Exceptions stored in the database!";
		ei.addParameter("ExcCat","Exception Catalog.");
		ei.addParameter("ExcCatVer","Exception Catalog Version.");
		ei.addParameter("ExcCode","Exception Code.");
		excCatInfo.addException(ei);

		// EXC_NULL_POINTER_EXCEPTION
		ei = new ExcInfo();
		ei.strExc = "NULL_POINTER_EXCEPTION";
		ei.nPriority = 3;
		ei.nCode = 94996;
		ei.strDescr = "This is a Generic NULL pointer Java Exception.";
		ei.addParameter("Cause","Cause for Exception object generation.");
		ei.addParameter("Message","Message generated by the Exception Object.");
		excCatInfo.addException(ei);

		// EXC_JAVA_EXCEPTION
		ei = new ExcInfo();
		ei.strExc = "JAVA_EXCEPTION";
		ei.nPriority = 3;
		ei.nCode = 94997;
		ei.strDescr = "This is a Generic Java Exception class error.";
		ei.addParameter("Cause","Cause for Exception object generation.");
		ei.addParameter("Message","Message generated by the Exception Object.");
		excCatInfo.addException(ei);

		// EXC_PARM_INVALID_INTERNAL
		ei = new ExcInfo();
		ei.strExc = "PARM_INVALID_INTERNAL";
		ei.nPriority = 4;
		ei.nCode = 94998;
		ei.strDescr = "Exception parameter is not valid for the Exception in the catalog ExcCat.ExcH ! This is an internal ExceptionHandler fatal error and is caught to avoid infinite recursive exception invokations.";
		ei.addParameter("CallStack","Call Stack of the original Exception.");
		ei.addParameter("Parms","Exception parameter not valid for the Exception.");
		ei.addParameter("InvalidParms","Exception parameter not valid for the Exception.");
		ei.addParameter("Exc","Exception found in the catalog.");
		ei.addParameter("ExcCat","Exception Catalog.");
		ei.addParameter("ExcCatVer","Exception Catalog Version.");
		excCatInfo.addException(ei);

		// EXC_UNKNOWN
		ei = new ExcInfo();
		ei.strExc = "UNKNOWN";
		ei.nPriority = 4;
		ei.nCode = 94999;
		ei.strDescr = "An Unknown exception has occurred in the system. Please send the stack trace to arunava@us.ibm.com with the Subject as PMR:ExceptionHandler and your contact details.";
		ei.addParameter("CallStack","XML format of the call stack when the Exception was generated.");
		excCatInfo.addException(ei);

		// EXC_WMQ
		ei = new ExcInfo();
		ei.strExc = "WMQ";
		ei.nPriority = 3;
		ei.nCode = 95001;
		ei.strDescr = "WebSphere MQ error!";
		ei.addParameter("Reason","Reason code returned form WMQ.");
		excCatInfo.addException(ei);

		// EXC_JMS
		ei = new ExcInfo();
		ei.strExc = "JMS";
		ei.nPriority = 3;
		ei.nCode = 95002;
		ei.strDescr = "Java Messaging Service error!";
		ei.addParameter("ErrorCode","Error code returned form JMS vendor.");
		excCatInfo.addException(ei);

		// EXC_WMB
		ei = new ExcInfo();
		ei.strExc = "WMB";
		ei.nPriority = 3;
		ei.nCode = 95003;
		ei.strDescr = "ExceptionList object captured! This is a generic Exception caught inside the Message Flow and not intended to be used for User Exceptions that should be catagorized and analyzed.";
		ei.addParameter("Type","Source object type.");
		ei.addParameter("Function","C++ source function name.");
		ei.addParameter("Catalog","NLS message catalog name.");
		ei.addParameter("Text","Additional text.");
		ei.addParameter("Label","Source object label.");
		ei.addParameter("Line","C++ source file line number.");
		ei.addParameter("Name","Source object name.");
		ei.addParameter("ExceptionType","The type of Exception that was generated. It is of the following types - RecoverableException, ParserException, ConversionException, DatabaseException, UserException, SecurityException, CastException, MessageException, SqlException, SocketException, SocketTimeoutException.");
		ei.addParameter("Number","NLS message number.");
		ei.addParameter("File","C++ source file name.");
		ei.addParameter("Severity","1 = information, 2 = warning, 3 = error.");
		excCatInfo.addException(ei);

		// EXC_WMB_CMP_LOGGED
		ei = new ExcInfo();
		ei.strExc = "WMB_CMP_LOGGED";
		ei.nPriority = 3;
		ei.nCode = 95004;
		ei.strDescr = "Message Broker Config Manager Proxy API Logged error!";
		ei.addParameter("ServiceInfo","The Service Information returned from the error in the CMP API.");
		excCatInfo.addException(ei);

		// EXC_WMB_CMP_PROP_INIT_ERROR
		ei = new ExcInfo();
		ei.strExc = "WMB_CMP_PROP_INIT_ERROR";
		ei.nPriority = 3;
		ei.nCode = 95005;
		ei.strDescr = "Message Broker Config Manager Proxy API error initializing the Property object!";
		excCatInfo.addException(ei);

		// EXC_WMB_CONFIG_SERVICE_UNDEF
		ei = new ExcInfo();
		ei.strExc = "WMB_CONFIG_SERVICE_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 95006;
		ei.strDescr = "Message Broker Configurable Service is not defined!";
		ei.addParameter("ConfigService","The Configuration Service name looked up.");
		ei.addParameter("ConfigServiceType","The type of the Configuration Service name looked up.");
		excCatInfo.addException(ei);

		// EXC_WMB_CONFIG_SERVICE_PROP_UNDEF
		ei = new ExcInfo();
		ei.strExc = "WMB_CONFIG_SERVICE_PROP_UNDEF";
		ei.nPriority = 3;
		ei.nCode = 95007;
		ei.strDescr = "Message Broker Configurable Service property is not defined in the Configurable Service!";
		ei.addParameter("ConfigServiceProp","The Configuration Service property.");
		ei.addParameter("ConfigService","The Configuration Service name looked up.");
		ei.addParameter("ConfigServiceType","The type of the Configuration Service name looked up.");
		excCatInfo.addException(ei);

		// EXC_SQL
		ei = new ExcInfo();
		ei.strExc = "SQL";
		ei.nPriority = 3;
		ei.nCode = 96001;
		ei.strDescr = "Database SQL error!";
		ei.addParameter("SQLCODE","SQLCODE for the vender specific database error.");
		ei.addParameter("SQLMSG","Message for the database error.");
		ei.addParameter("SQLSTATE","SQLSTATE for the database error.");
		excCatInfo.addException(ei);

		// EXC_ECLIPSE_CORE_EXCEPTION
		ei = new ExcInfo();
		ei.strExc = "ECLIPSE_CORE_EXCEPTION";
		ei.nPriority = 3;
		ei.nCode = 97001;
		ei.strDescr = "Eclipse Framework generated Core Exception.";
		ei.addParameter("StatusCode","Status Code.");
		ei.addParameter("StatusSeverity","Status Severity.");
		ei.addParameter("StatusMessage","Status Message.");
		ei.addParameter("ExceptionClass","Low-level Exception Class name.");
		ei.addParameter("ExceptionCause","Low-level Exception Cause.");
		ei.addParameter("ExceptionMessage","Low-level Exception Message.");
		ei.addParameter("PluginId","Unique Identifier for the Eclipse Plugin that caused the Exception condition.");
		excCatInfo.addException(ei);

		// EXC_ECLIPSE_PLUGIN_UPDATED
		ei = new ExcInfo();
		ei.strExc = "ECLIPSE_PLUGIN_UPDATED";
		ei.nPriority = 1;
		ei.nCode = 97002;
		ei.strDescr = "Eclipse Plugin has been updated.";
		ei.addParameter("Plugin","Eclipse Plugin Id.");
		ei.addParameter("Version","Eclipse Plugin Version.");
		excCatInfo.addException(ei);

		return excCatInfo;
	}

}
