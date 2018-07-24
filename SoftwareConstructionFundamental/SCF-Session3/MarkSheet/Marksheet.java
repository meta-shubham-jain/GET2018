import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It performs different operations on student marksheet
 * 
 * @author Shubham Jain
 */
public class Marksheet {

	/**
	 * It computes average of Grades
	 * 
	 * @return average of Grades
	 */
	double averageOfGrades(double gradesOfStudents[]) {
			if (checkEnteredGrades(gradesOfStudents)) {
				throw new AssertionError("Grades should be >= 0 and <= 100");
			}
			double averageGrades = 0;
			for (int i = 0; i < gradesOfStudents.length; i++) {
				averageGrades = averageGrades + gradesOfStudents[i];
			}
			averageGrades = (double) Math.round((averageGrades / gradesOfStudents.length) * 100) / 100;
			return averageGrades;
		}

	/**
	 * It computes maximum grade among all students
	 * 
	 * @return maxGrade which is maximum grade
	 */
	double maximumGrade(double gradesOfStudents[]) {
			if (checkEnteredGrades(gradesOfStudents)) {
				throw new AssertionError("Grades should be >= 0 and <= 100");
			}
			double maxGrade = gradesOfStudents[0];
			for (int i = 1; i < gradesOfStudents.length; i++) {
				if (maxGrade < gradesOfStudents[i]) {
					maxGrade = gradesOfStudents[i];
				}
			}
			return maxGrade;
	}

	/**
	 * It computes minimum grade among all students
	 * 
	 * @return minGrade which is minimum grade
	 */
	double minimumGrade(double gradesOfStudents[]) {
			if (checkEnteredGrades(gradesOfStudents)) {
				throw new AssertionError("Grades should be >= 0 and <= 100");
			}
			double minGrade = gradesOfStudents[0];
			for (int i = 1; i < gradesOfStudents.length; i++) {
				if (minGrade > gradesOfStudents[i]) {
					minGrade = gradesOfStudents[i];
				}
			}
			return minGrade;
	}

	/**
	 * It computes number of students which is passed
	 * 
	 * @return number of students passed
	 */
	double percentOfPassedStudents(double gradesOfStudents[]) {
			if (checkEnteredGrades(gradesOfStudents)) {
				throw new AssertionError("Grades should be >= 0 and <= 100");
			}
			double percenatgeOfStudentsPassed = 0;
			for (int i = 0; i < gradesOfStudents.length; i++) {
				if (gradesOfStudents[i] >= 40) {
					percenatgeOfStudentsPassed++;
				}
			}
			percenatgeOfStudentsPassed = (double) Math
					.round((percenatgeOfStudentsPassed / gradesOfStudents.length * 100) * 100) / 100;
			return percenatgeOfStudentsPassed;
	}

	/**
	 * It checks whether the input grade is in between 0 and 100
	 * 
	 * @return true if input is in between 0 and 100 otherwise false
	 */
	boolean checkEnteredGrades(double gradesOfStudents[]) {
		for (int i = 0; i < gradesOfStudents.length; i++) {
			if (gradesOfStudents[i] < 0 || gradesOfStudents[i] > 100) {
				return true;
			}
		}
		return false;
	}
}
