package com.nespresso.heating;

import java.io.IOException;
import java.net.MalformedURLException;

public class Probe {

	public static double fetchTemperature() 
	throws NumberFormatException, MalformedURLException, IOException {
		return Double.parseDouble(Tools.stringFromURL("http://probe.home:9990/temp", 4));
	}

}
