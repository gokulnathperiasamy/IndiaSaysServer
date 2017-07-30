package com.kpgn.indiasaysserver.utility;

import java.util.Date;

public abstract class TimeUtil {
	
	public static long getCurrentTimeInLong() {
		return new Date().getTime();
	}

}
