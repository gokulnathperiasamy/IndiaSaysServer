package com.kpgn.indiasaysserver.application;

public abstract class TextUtil {

	public static boolean isNotEmpty(String string) {
		if (string != null && string.length() > 0) {
			return true;
		}
		return false;
	}

	public static double getRandomDouble(double min, double max) {
		return Math.floor(Math.random() * (max - min + 1) + min);
	}
}
