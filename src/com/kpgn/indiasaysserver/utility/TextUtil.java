package com.kpgn.indiasaysserver.utility;

public abstract class TextUtil {
	
	public static final String STRING_DELIMITER = "|";

	public static boolean isNotEmpty(String string) {
		if (string != null && string.length() > 0) {
			return true;
		}
		return false;
	}
	
	public static String trimStringLength(String string, int maxLength) {
		if (string != null && string.length() > maxLength) {
			return string.substring(0, maxLength - 1);
		}
		return string;
	}
	
	public static String removeSpaces(String string) {
		if (string != null && string.length() > 0) {
			return string.replaceAll(" ", "");
		}
		return string;
	}

	public static int getRandomInt(double min, double max) {
		return (int) Math.floor(Math.random() * (max - min + 1) + min);
	}
}
