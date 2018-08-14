/**
 * This class will stores name and program alloted to student
 * 
 * @author Shubham Jain
 *
 */
public class AllotedProgram {
    private String studentName;
    private String allotedProgram;

    public AllotedProgram(String studentName, String allotedProgram) {
        this.studentName = studentName;
        this.allotedProgram = allotedProgram;
    }

    /**
     * It returns the program alloted to student
     * 
     * @return String
     */
    public String getAllotedProgram() {
        return allotedProgram;
    }

    /**
     * It returns the name of student
     * 
     * @return
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * It sets the program alloted to student
     * 
     * @param allotedProgram
     */
    public void setAllotedProgram(String allotedProgram) {
        this.allotedProgram = allotedProgram;
    }

    /**
     * It sets the name of student
     * 
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}