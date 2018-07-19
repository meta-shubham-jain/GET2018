import java.util.Scanner;

/**
 * It performs String Operations
 * 
 * @author Shubham Jain
 *
 */
public class StringOperations {

	/**
	 * It compares two Strings whether they are equal or not
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
	 * @param input
	 * @return
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
	 * @param input
	 * @return convert which contains reverse string
	 */
	String changeCase(String input) {
		String convert = "";
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 97 && input.charAt(i) <= 122) {
				convert = convert + (char) (input.charAt(i) - 32);
			} else if (input.charAt(i) >= 65 && input.charAt(i) <= 90) {
				convert = convert + (char) (input.charAt(i) + 32);
			} else {
				convert = convert + (char) input.charAt(i);
			}
		}
		return convert;
	}

	/**
	 * It finds the largest last word in the string
	 * @param string1
	 * @return word which is largest last word
	 */
	String largestWord(String string1) {
		String word;
		int startLength = 0;
		int endLength = 0; 
		int maximumLength = 0;
		int length;
		int wordStart = 0;
		int wordEnd = 0;
		int start = 0;
		for (int i = start; i < string1.length(); i++) {
			if ((int) string1.charAt(i) == 32|| ((i == string1.length() - 1) && (int) string1.charAt(string1.length() - 1) != 32)) {
				endLength = i;
				if ((i == string1.length() - 1)) {
					endLength++;
				}
				length = endLength - startLength;
				if (length >= maximumLength) {
					maximumLength = length;
					wordStart = startLength;
					wordEnd = endLength;
				}
				while ((int) string1.charAt(i) == 32) {
					i++;
				}
				startLength = i;
			}
		}
		word = string1.substring(wordStart, wordEnd);
		return word;
	}
}
