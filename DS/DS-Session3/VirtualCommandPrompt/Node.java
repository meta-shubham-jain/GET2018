import java.util.*;
import java.util.List;
import java.util.ArrayList;

/**
 * This class implements node with its properties
 * 
 * @author Shubham Jain
 *
 */
public class Node {
    List<Node> listOfSubDirectory = new ArrayList<>();           //List of Sub-Directory
    private String name;
    private Node parentNode;
    private Date dateOfCreation;

    Node(String name, Node parentNode) {
        this.name = name;
        this.parentNode = parentNode;
        this.dateOfCreation = new Date();
    }

    /**
     * It will return the parent node
     * 
     * @return Node
     */
    Node getParentNode() {
        return parentNode;
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
     * It will set the parent node
     * 
     * @param parentNode
     */
    void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    /**
     * It will add the sub directory in list
     * 
     * @param subDirecotry
     */
    void addSubDirectory(Node subDirecotry) {
        listOfSubDirectory.add(subDirecotry);
    }
}