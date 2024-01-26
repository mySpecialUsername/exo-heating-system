package com.nespresso.heating;


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
	
	public static void manage(Heater h, String threshold) throws Exception {
		double dThreshold = Double.parseDouble(threshold);
		h.manageHeating( dThreshold);
	}

}
