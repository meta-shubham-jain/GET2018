import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import queue.QueueUsingLinkedList;

/**
 * This class will read the excel file of students and programs and allot the
 * program to students and store in a new excel file
 * 
 * @author Shubham Jain
 *
 */
public class CounsellingProgram {
    ArrayList<Program> programList = new ArrayList<Program>();
    ArrayList<AllotedProgram> allotedList = new ArrayList<AllotedProgram>();
    QueueUsingLinkedList<Student> queueOfStudents = new QueueUsingLinkedList<Student>();

    /**
     * It will read program excel file and store in program list
     * 
     * @param fileName
     * @throws IOException
     */
    public void addProgram(String fileName) throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Program program = new Program();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Check the cell type and format accordingly
                    switch (cell.getCellTypeEnum()) {
                    case NUMERIC:
                        program.setCapacity((int) cell.getNumericCellValue());
                        break;
                    case STRING:
                        program.setName(cell.getStringCellValue());
                        break;
                    }
                }
                programList.add(program);
            }
            file.close();
        } catch (Exception ex) {
            throw new IOException("File Not Found while adding Programs");
        }
    }

    /**
     * It will read students excel file and store student in queue
     * 
     * @param fileName
     */
    public void addStudent(String fileName) throws IOException {
        try {
            FileInputStream file = new FileInputStream(new File(fileName));

            // Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                // For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Student student = new Student();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    // Check the cell type and format accordingly
                    int columnIndex = cell.getColumnIndex();
                    switch (columnIndex) {
                    case 0:
                        student.setName(cell.getStringCellValue());
                        break;
                    default:
                        student.setlistOfPrograms((cell.getStringCellValue()));
                        break;
                    }
                }
                queueOfStudents.enQueue(student);
            }
            file.close();
        } catch (Exception ex) {
            throw new IOException("File Not Found while adding Students");
        }
    }

    /**
     * It will allot program to the student according to their rank and program
     * capacity
     * 
     * @throws IOException
     */
    public void allotProgram() throws IOException {
        boolean isAlloted = false;
        while (!queueOfStudents.isEmpty()) {
            Student student = queueOfStudents.deQueue();
            isAlloted = false;
            for (int i = 0; i < student.listOfPrograms.size(); i++) {
                for (int j = 0; j < programList.size(); j++) {
                    if ((student.listOfPrograms.get(i).equals(
                            programList.get(j).getName()) && programList.get(j)
                            .getCapacity() > 0)) {
                        allotedList.add(new AllotedProgram(student.getName(),
                                student.listOfPrograms.get(i)));
                        programList.get(j).setCapacity(
                                programList.get(j).getCapacity() - 1);
                        isAlloted = true;
                        break;
                    }
                }
                if (isAlloted) {
                    break;
                }
            }
        }
        writeBook();
    }

    /**
     * It will create and write student name and alloted program in excel sheet
     * 
     * @throws IOException
     */
    private void writeBook() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("List of Allocated Program");
        int rowCount = 0;
        for (AllotedProgram allotedProgram : allotedList) {
            Row row = sheet.createRow(rowCount);
            Cell cell = row.createCell(0);
            cell.setCellValue(allotedProgram.getStudentName());

            cell = row.createCell(1);
            cell.setCellValue(allotedProgram.getAllotedProgram());
            rowCount++;
        }
        FileOutputStream outputStream = new FileOutputStream(new File(
                "AllotedPrograms.xlsx"));
        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
        workbook.close();
    }
}