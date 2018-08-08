import java.util.Scanner;

/**
 * It calculates different parameters on students mark sheets
 * 
 * @author Shubham Jain
 */
public class GradeMenu {
	public static void main(String args[]) {
		int noOfStudents;
		int choiceOfOperation;

		while (true) {
			System.out.println("Enter the no of Students whose grades you want to upload");
			Scanner inputNumber = new Scanner(System.in);
			noOfStudents = inputNumber.nextInt();
			try {
				if (noOfStudents <= 0) {
					System.out.println("No of Students can't be Zero or negative");
					throw new ArithmeticException();
				}
				Marksheet marksheetOfStudents = new Marksheet(noOfStudents);
				marksheetOfStudents.initializeGrades();
				if (marksheetOfStudents.checkEnteredGrades()) {
					System.out.println("Entered grades should only be from 0 to 100");
					throw new ArithmeticException();
				}

				System.out.println("Enter the operation you want to perform\n1. Average of Grades\n2.Maximum of Grades\n"
								+ "3.Minimum of Grades\n4.Percent of Students Passed\n5.Exit");
				choiceOfOperation = inputNumber.nextInt();
				switch (choiceOfOperation) {
				case 1:
					double averageGrade = marksheetOfStudents.averageOfGrades();
					System.out.println("Average of Grades:- " + averageGrade);
					break;

				case 2:
					double maxgrade = marksheetOfStudents.maximumGrade();
					System.out.println("Maximum of Grades:- " + maxgrade);
					break;

				case 3:
					double minGrade = marksheetOfStudents.minimumGrade();
					System.out.println("Minimum of Grades:- " + minGrade);
					break;

				case 4:
					double percentPassedStudents = marksheetOfStudents.percentOfPassedStudents();
					System.out.println("Percentage of Passed Students:- " + percentPassedStudents);
					break;

				case 5:
					System.exit(1);

				default:
					System.out.println("Wrong Input");
				}
			} catch (ArithmeticException ex) {
				System.out.println("Wrong Input:");

			}
		}
	}

}
