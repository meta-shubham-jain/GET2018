import java.util.Scanner;

/**
 * It performs different operations on student marksheet
 * 
 * @author Shubham Jain
 *
 */
public class Marksheet {
	double gradesOfStudents[];
	int noOfStudents;

	public Marksheet(int noOfStudents) {
		this.noOfStudents = noOfStudents;
		gradesOfStudents = new double[noOfStudents];
	}

	/**
	 * It takes grade as input from user
	 */
	void initializeGrades() {
		Scanner inputGrades = new Scanner(System.in);
		for (int i = 0; i < noOfStudents; i++) {
			System.out.println("Enter the grade for Student " + (i + 1)
					+ " between 0 to 100");
			gradesOfStudents[i] = inputGrades.nextDouble();
		}
	}

	/**
	 * It computes average of Grades
	 * 
	 * @return average of Grades
	 */
	double averageOfGrades() {
		double averageGrades = 0;
		for (int i = 0; i < noOfStudents; i++) {
			averageGrades = averageGrades + gradesOfStudents[i];
		}
		return (double) averageGrades / noOfStudents;
	}

	/**
	 * It computes maximum grade among all students
	 * 
	 * @return maxGrade which is maximum grade
	 */
	double maximumGrade() {
		double maxGrade = gradesOfStudents[0];
		for (int i = 1; i < noOfStudents; i++) {
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
	double minimumGrade() {
		double minGrade = gradesOfStudents[0];
		for (int i = 1; i < noOfStudents; i++) {
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
	double percentOfPassedStudents() {
		int noOfPassedStudents = 0;
		for (int i = 0; i < noOfStudents; i++) {
			if (gradesOfStudents[i] >= 40) {
				noOfPassedStudents++;
			}
		}
		return (double) noOfPassedStudents / noOfStudents * 100;
	}

	/**
	 * It checks whether the input grade is in between 0 and 100
	 * 
	 * @return true if input is in between 0 and 100 otherwise false
	 */
	boolean checkEnteredGrades() {
		for (int i = 0; i < noOfStudents; i++) {
			if (gradesOfStudents[i] > 100 || gradesOfStudents[i] < 0) {
				return true;
			}
		}
		return false;
	}
}
