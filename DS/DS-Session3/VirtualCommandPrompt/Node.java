import java.util.*;
import java.util.List;
import java.util.ArrayList;

/**
 * This class implements Folder with its properties
 * 
 * @author Shubham Jain
 *
 */
public class Folder {
	List<Folder> listOfSubDirectory = new ArrayList<>(); // List of Sub-Directory
	private String name;
	private Folder parentFolder;
	private Date dateOfCreation;

	Folder(String name, Folder parentFolder) {
		this.name = name;
		this.parentFolder = parentFolder;
		this.dateOfCreation = new Date();
	}

	/**
	 * It will return the parent Folder
	 * 
	 * @return Folder
	 */
	Folder getParentFolder() {
		return parentFolder;
	}

	/**
	 * It will returns name of directory
	 * 
	 * @return String
	 */
	String getName() {
		return name;
	}

	/**
	 * It will return the list of subDirectories
	 * 
	 * @return List
	 */
	List getListOfSubDirectory() {
		return listOfSubDirectory;
	}

	/**
	 * It will return the date of creation of a directory
	 * 
	 * @return Date
	 */
	Date getDate() {
		return dateOfCreation;
	}

	/**
	 * It will set the name of folder
	 * 
	 * @param name
	 */
	void setName(String name) {
		this.name = "";
		this.name = name;
	}

	/**
	 * It will set the parent Folder
	 * 
	 * @param parentFolder
	 */
	void setParentFolder(Folder parentFolder) {
		this.parentFolder = parentFolder;
	}

	/**
	 * It will add the sub directory in list
	 * 
	 * @param subDirecotry
	 */
	void addSubDirectory(Folder subDirecotry) {
		listOfSubDirectory.add(subDirecotry);
	}
}