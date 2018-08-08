import java.util.Scanner;

/**
 * It performs String Operations
 * 
 * @author Shubham Jain
 */
public class StringOperations {

	/**
	 * It compares two Strings whether they are equal or not
	 * 
	 * @param input1
	 * @param input2
	 * @return 1 if strings are equal else 0
	 */
	short isEqual(String input1, String input2) {
		if (input1.length() == input2.length()) {
			for (int i = 0; i < input1.length(); i++) {
				if (!(input1.charAt(i) == input2.charAt(i))) {
					return 0;
				}
			}
			return 1;
		}
		return 0;
	}

	/**
	 * It reverse the String
	 * 
	 * @param input
	 * @return string reverse of input string
	 */
	String reverse(String input) {
		String reverse = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			reverse = reverse + input.charAt(i);
		}
		return reverse;
	}

	/**
	 * It Convert lower case in upper case and vice-versa
	 * 
	 * @param input
	 * @return convert which contains reverse string
	 */
	String changeCase(String input) {
		String convertedString = "";
		for (int i = 0; i < input.length(); i++) {
			if ((input.charAt(i)) >= 97 && (input.charAt(i) <= 122)) {
				convertedString = convertedString + (char) (input.charAt(i) - 32);
			} else if ((input.charAt(i) >= 65) && (input.charAt(i) <= 90)) {
				convertedString = convertedString + (char) (input.charAt(i) + 32);
			} else {
				convertedString = convertedString + (char) input.charAt(i);
			}
		}
		return convertedString;
	}

	/**
	 * It finds the largest last word in the string
	 * 
	 * @param string1
	 * @return word which is largest last word
	 */
	String largestWord(String string) {
		String word = "";
		int countWord = 0;
		int index = 0;
		int length = 0;
		int endIndex = 0;
		int maxLength = 0;
		string = string + " ";
		length = string.length();
		for (index = 0; index < length; index++) {
			if (string.charAt(index) != ' ') {
				countWord += 1;
			} else {
				if (countWord >= maxLength) {
					maxLength = countWord;
					endIndex = index;
				}
				countWord = 0;
			}
		}
		for (int i = endIndex - maxLength; i < endIndex; i++) {
			word = word + string.charAt(i);
		}
		return word;
	}

}