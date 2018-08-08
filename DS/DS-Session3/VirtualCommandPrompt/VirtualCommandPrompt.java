import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * It will create virtual command prompt
 * @author Shubham Jain
 *
 */
public class VirtualCommandPrompt {
    static Node rootDirectory = new Node("R:\\", null);   //Node for rootDirectory
    static Node currentDirectory;                         //Node for currentDirectory  
    static List<String> display  = new ArrayList<>();     //List for path to display

    /**
     * It will create directory in current directory
     * @param nameOfDirectory
     */
    public static void createDirectory(String nameOfDirectory) {
        for (int i = 0; i < currentDirectory.listOfSubDirectory.size(); i++) {
            if (nameOfDirectory.equals(currentDirectory.listOfSubDirectory.get(
                    i).getName())) {
                System.out.println("Directory with same name already exists.");
                return;
            }
        }
        Node subDirectry = new Node(nameOfDirectory, currentDirectory);
        currentDirectory.addSubDirectory(subDirectry);
    }

    /**
     * It will change the directory
     * @param nameOfDirectory
     */
    public static void changeDirectory(String nameOfDirectory) {
        for (int i = 0; i < currentDirectory.listOfSubDirectory.size(); i++) {
            if (nameOfDirectory.equals(currentDirectory.listOfSubDirectory.get(
                    i).getName())) {
                if (!(currentDirectory == rootDirectory)) {
                    display.add("\\");
                }
                currentDirectory = currentDirectory.listOfSubDirectory.get(i);
                display.add(currentDirectory.getName());
                return;
            }
        }
        System.out.println("Directory with the given name doesn't exists ");
    }

    /**
     * It will move to parent directory
     */
    public static void moveToParentDirectory() {
        if (!(rootDirectory.equals(currentDirectory))) {
            currentDirectory = currentDirectory.getParentNode();
            display.remove(display.size() - 1);
            if (currentDirectory != rootDirectory) {
                display.remove(display.size() - 1);
            }
            return;
        }
    }

    /**
     * It will display list of sub directory
     */
    public static void displayListOfSubDirectories() {
        int countSubFolder = 0;
        for (int i = 0; i < currentDirectory.listOfSubDirectory.size(); i++) {
            System.out.println(currentDirectory.listOfSubDirectory.get(i)
                    .getDate()
                    + "\t"
                    + currentDirectory.listOfSubDirectory.get(i).getName());
            countSubFolder++;
        }
        System.out.println("\t" + countSubFolder + "Folders<s>");
    }

    /**
     * It will find folder in present directory and in all sub directories and display the path
     * @param nameOfFolder
     * @param currentDirectory
     * @param path
     */
    public static void findFolder(String nameOfFolder, Node currentDirectory,
            String path) {
        if (!(currentDirectory == null)) {
            if (currentDirectory.getName().contains(nameOfFolder)
                    && currentDirectory != VirtualCommandPrompt.currentDirectory) {
                path = path + "\\" + currentDirectory.getName();
                System.out.println(path);
            } else {
                if(currentDirectory != rootDirectory) {
                path = path + "\\" + currentDirectory.getName();
                }
                }
            for (int i = 0; i < currentDirectory.listOfSubDirectory.size(); i++) {
                findFolder(nameOfFolder,
                        currentDirectory.listOfSubDirectory.get(i), path);
            }
        }
    }

    /**
     * It will display the whole tree of all directories and its sub directories
     * @param root
     * @param level
     */
    public static void displayTree(Node root, int level) {
        if (!(root == null)) {
            for (int j = 1; j < level; j++) {
                System.out.print("\t");
            }
            if (!(root == rootDirectory)) {
                System.out.println("|_____" + root.getName());
            }
            for (int i = 0; i < root.listOfSubDirectory.size(); i++) {
                displayTree(root.listOfSubDirectory.get(i), level + 1);
            }
        }
    }

    /**
     * It will display prompt after every command execution
     */
    public static void promptDisplay() {
        for (int i = 0; i < display.size(); i++) {
            System.out.print(display.get(i));
        }
        System.out.print(">");
    }

    /**
     * It will check whether command is valid or not
     * @param num
     * @param size
     * @return
     */
    public static boolean isValid(int num, int size) {
        if (num != size) {
            return false;
        }
        return true;
    }

    /**
     * Main program for console
     * @param args
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        display.add("R:\\");
        currentDirectory = rootDirectory;
        while (true) {
            promptDisplay();
            String command = sc.nextLine();
            if ("".equals(command)) {
                continue;
            }
            String split[] = command.split(" ");
            split[0].toLowerCase();
            switch (split[0]) {
            case "cd":
                if (!(isValid(2, split.length))) {
                    System.out.println("Invalid Command");
                    break;
                }
                changeDirectory(split[1]);
                break;
            case "mkdir":
                if (split.length == 1) {
                    System.out.println("Invalid Command");
                    break;
                }
                for (int i = 1; i < split.length; i++) {
                    createDirectory(split[i]);
                }
                break;
            case "bk":
                if (!(isValid(1, split.length))) {
                    System.out.println("Invalid Command");
                    break;
                }
                moveToParentDirectory();
                break;
            case "ls":
                if (!(isValid(1, split.length))) {
                    System.out.println("Invalid Command");
                    break;
                }
                displayListOfSubDirectories();
                break;
            case "find":
                if (!(isValid(2, split.length))) {
                    System.out.println("Invalid Command");
                    break;
                }
                findFolder(split[1], currentDirectory, "");
                break;
            case "tree":
                if (!(isValid(1, split.length))) {
                    System.out.println("Invalid Command");
                    break;
                }
                displayTree(rootDirectory, 0);
                break;
            case "exit":
                if (!(isValid(1, split.length))) {
                    System.out.println("Invalid Command");
                    break;
                }
                System.exit(0);
            default:
                System.out.println("Invalid Command");
            }
        }
    }
}