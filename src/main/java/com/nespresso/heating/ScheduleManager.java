package com.nespresso.heating;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

/**
 * The system obtains temperature data from a remote source,
 * compares it with a given threshold and controls a remote heating
 * unit by switching it on and off. It does so only within a time
 * period configured on a remote service (or other source)
 * 
 * This is purpose-built crap
 *
 */
public class ScheduleManager {
	
	public static void manage(HeatingManagerImpl hM, String threshold) throws Exception {
		double dThreshold = Double.parseDouble(threshold);

		double t = fetchTemperature();
		
		int currentTime = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

		boolean active = (currentTime > fetchStartHour() && currentTime < fetchEndHour());

		hM.manageHeating(t, dThreshold, active);
	}

	private static double fetchTemperature() 
	throws NumberFormatException, MalformedURLException, IOException {
		return Double.parseDouble(stringFromURL("http://timer.home:9990/temp", 4));
	}

	private static int fetchStartHour() 
	throws NumberFormatException, MalformedURLException, IOException {
		return Integer.parseInt(stringFromURL("http://timer.home:9990/start", 2));
	}

	private static int fetchEndHour() 
	throws NumberFormatException, MalformedURLException, IOException {
		return Integer.parseInt(stringFromURL("http://timer.home:9990/end", 2));
	}

	private static String stringFromURL(String urlString, int byteSize) 
	throws MalformedURLException,IOException {
		URL url = new URL(urlString);
		InputStream is = url.openStream();
		byte[] tempBuffer = new byte[byteSize];
		is.read(tempBuffer);
		String t = new String(tempBuffer);
		is.close();
		return t;
	}

}
