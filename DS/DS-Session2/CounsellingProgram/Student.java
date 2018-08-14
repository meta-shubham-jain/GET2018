import java.util.ArrayList;

/**
 * This class contains name of Student and Array List for list Of programs
 * 
 * @author Shubham Jain
 *
 */
public class Student {
    private String name;
    ArrayList<String> listOfPrograms = new ArrayList<>();

    /**
     * It returns name of Student
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * It set name of Student
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * It returns list of programs
     * 
     * @return
     */
    public ArrayList<String> getlistOfPrograms() {
        return listOfPrograms;
    }

    /**
     * It adds program in the list
     * 
     * @param program
     */
    public void setlistOfPrograms(String program) {
        listOfPrograms.add(program);
    }
}