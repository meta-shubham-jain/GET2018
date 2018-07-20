/**
 * This will calculate addition subtraction, multiplication, division and
 * compare for greater than less than and equal to of two numbers.
 * 
 * @author Shubham jain
 *
 */

public class HexCalc {

	/**
	 * This method validates strings for hexadecimal.
	 * 
	 * @param input
	 *            is hexadecimal number
	 * @return boolean value
	 */
	boolean isValid(String input) {
		input = input.toUpperCase();
		for (int i = 0; i < input.length(); i++) {
			if (!(input.charAt(i) >= 48 && input.charAt(i) <= 57)
					&& !(input.charAt(i) >= 65 && input.charAt(i) <= 70)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method performs addition.
	 * 
	 * @param input1
	 *            is hexadecimal number
	 * @param input2
	 *            is hexadecimal number
	 * @return result contains addition of both numbers
	 */
	String addition(String input1, String input2) {
		int num1 = hex2Decimal(input1);
		int num2 = hex2Decimal(input2);
		int num = num1 + num2;
		String result = decimal2Hex(num);
		return result;
	}

	/**
	 * This method performs subtraction.
	 * 
	 * @param input1
	 *            is hexadecimal number
	 * @param input2
	 *            is hexadecimal number
	 * @return result contains subtraction of both numbers
	 */
	String subtraction(String input1, String input2) {
		int num1 = hex2Decimal(input1);
		int num2 = hex2Decimal(input2);
		int num;
		if (num1 > num2) {
			num = num1 - num2;
		} else {
			num = num2 - num1;
		}
		String result = decimal2Hex(num);
		return result;
	}

	/**
	 * This method performs multiplication.
	 * 
	 * @param input1
	 *            is hexadecimal number
	 * @param input2
	 *            is hexadecimal number
	 * @return result contains multiplication of both numbers
	 */
	String multiplication(String input1, String input2) {
		int num1 = hex2Decimal(input1);
		int num2 = hex2Decimal(input2);
		int num = num1 * num2;
		String result = decimal2Hex(num);
		return result;
	}

	/**
	 * This method performs division.
	 * 
	 * @param input1
	 *            is hexadecimal number
	 * @param input2
	 *            is hexadecimal number
	 * @return result contains division of both numbers
	 */
	String division(String input1, String input2) {
		int num1 = hex2Decimal(input1);
		int num2 = hex2Decimal(input2);
		int num = num1 / num2;
		String result = decimal2Hex(num);
		return result;
	}

	/**
	 * This method converts hexadecimal number into decimal number.
	 * 
	 * @param input
	 *            is hexadecimal number
	 * @return value contains decimal representation of hexadecimal number
	 */
	int hex2Decimal(String input) {
		char character;
		int intValue;
		String digits = "0123456789ABCDEF";
		input = input.toUpperCase();
		int value = 0;
		for (int i = 0; i < input.length(); i++) {
			character = input.charAt(i);
			intValue = digits.indexOf(character);
			value = 16 * value + intValue;
		}
		return value;
	}

	/**
	 * This methods converts decimal number into hexadecimal number
	 * 
	 * @param number
	 *            contains decimal number
	 * @return hex contains hexadecimal representation of decimal number
	 */
	String decimal2Hex(int number) {
		int base = 16;
		String digits = "0123456789ABCDEF";
		String hex = "";
		while (number > 0) {
			int digit = number % base;
			hex = digits.charAt(digit) + hex;
			number = number / base;
		}
		return hex;
	}

	/**
	 * This method compares if first number is greater than second number
	 * 
	 * @param input1
	 *            is hexadecimal number
	 * @param input2
	 *            is hexadecimal number
	 * @return true if first number is greater than second number else false
	 */
	boolean comparisionForGreater(String input1, String input2) {
		if (input1.length() > input2.length()) {
			return true;
		} else if (input1.length() < input2.length()) {
			return false;
		}
		for (int i = 0; i < input1.length(); i++) {
			if (input1.charAt(i) > input2.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method compares if first number is smaller than second number
	 * 
	 * @param input1
	 *            is hexadecimal number
	 * @param input2
	 *            is hexadecimal number
	 * @return true if first number is smaller than second number else false
	 */

	boolean comparisionForSmaller(String input1, String input2) {
		if (input1.length() < input2.length()) {
			return true;
		} else if (input1.length() > input2.length()) {
			return false;
		}
		for (int i = 0; i < input1.length(); i++) {
			if (input1.charAt(i) < input2.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method compares if first number is equal to second number.
	 * 
	 * @param input1
	 *            is hexadecimal number
	 * @param input2
	 *            is hexadecimal number
	 * @return true if first number is equal to second number else false
	 */

	boolean comparisionForEqual(String input1, String input2) {
		if (input1.length() == input2.length()) {
			for (int i = 0; i < input1.length(); i++) {
				if (input1.charAt(i) > input2.charAt(i)	&& input1.charAt(i) < input2.charAt(i)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}
}