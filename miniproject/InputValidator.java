package org.cdac.miniproject;

public class InputValidator {

	public static boolean nameValidator(String name) {
		int temp = 0;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (Character.isLetter(ch) || ch == ' ' || ch == '.') {
				temp = 1;
			} else {
				temp = 0;
				break;
			}
		}
		if (temp == 1) {
			return true;
		}
		return false;
	}

	public static boolean PhoneValidator(String num) {
		int flag = 0;
		for (int i = 0; i < num.length(); i++) {
			char ch = num.charAt(i);
			if (Character.isDigit(ch) && num.length() == 10 && ch != '.') {
				flag = 1;
			} else {
				flag = 0;
				break;
			}
		}
		if (flag == 1) {
			return true;
		}
		return false;
	}
}
