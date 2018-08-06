import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class CounsellingProgramTest {
    CounsellingProgram program;

    @Before
    public void init() {
        program = new CounsellingProgram();
    }

    @Test
    public void testCounsellingProgram() {
        try {
            program.addProgram("Program.xlsx");
            program.addStudent("Student.xlsx");
            program.allotProgram();
        } catch (Exception ex) {
            assertEquals("File Not Found while adding Programs",
                    ex.getMessage());
        }
    }

    @Test
    public void programFileNotExistTest() {
        try {
            program.addProgram("CounsellingProgram.xlsx");
        } catch (Exception ex) {
            assertEquals("File Not Found while adding Programs",
                    ex.getMessage());
        }
    }

    @Test
    public void studentFileNotExistTest() {
        try {
            program.addStudent("StudentList.xlsx");
        } catch (Exception ex) {
            assertEquals("File Not Found while adding Students",
                    ex.getMessage());
        }
    }
}