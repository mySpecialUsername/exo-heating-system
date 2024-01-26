package com.nespresso.heating;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Calendar;

public class Timer {
    
    public static boolean isActive() 
    throws NumberFormatException, MalformedURLException, IOException {
        return (currentHour() > startHour() && currentHour() < endHour());
    }


    private static int startHour() 
    throws NumberFormatException, MalformedURLException, IOException {
        return fetchStartHour();
    }

    private static int endHour()
    throws NumberFormatException, MalformedURLException, IOException {
        return fetchEndHour();
    }

    private static int currentHour() {
		int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        return currentHour;
    }


    private static int fetchStartHour() 
	throws NumberFormatException, MalformedURLException, IOException {
		return Integer.parseInt(Tools.stringFromURL("http://timer.home:9990/start", 2));
	}

	private static int fetchEndHour() 
	throws NumberFormatException, MalformedURLException, IOException {
		return Integer.parseInt(Tools.stringFromURL("http://timer.home:9990/end", 2));
	}

}
