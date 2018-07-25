import java.util.Scanner;

/*
 * It contains main method which performs String operation 
 * @author Shubham Jain
 */
public class StringMenu {
	static String get() {
		String input;
		Scanner sc = new Scanner(System.in);
		input = sc.nextLine();
		return input;
	}

	public static void main(String[] args) {
		StringOperations operation = new StringOperations();
		Scanner sc = new Scanner(System.in);
		int option;
		String string1;
		String string2;

		while (true) {
			System.out.println("Enter option no to perform :");
			System.out.println("1.Comparision of Strings\n2.Reverse\n3.Case Conversion\n4.Longest word\n5.Exit.");
			option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter First String");
				string1 = get();
				System.out.println("Enter Second String");
				string2 = get();
				if (operation.isEqual(string1, string2) == 1) {
					System.out.println("Both are Equal");
				} else {
					System.out.println("Both are not Equal");
				}
				break;

			case 2:
				System.out.println("Enter the String");
				string1 = get();
				System.out.println("Reverse string = "	+ operation.reverse(string1));
				break;

			case 3:
				System.out.println("Enter the String");
				string1 = get();
				System.out.println("Case Conversion = "	+ operation.changeCase(string1));
				break;

			case 4:
				System.out.println("Enter the String");
				string1 = get();
				System.out.println("Longest Word  = " + operation.largestWord(string1));
				break;

			case 5:
				System.exit(1);

			default:
				System.out.println("Wrong Choice");
			}
		}
	}
}
