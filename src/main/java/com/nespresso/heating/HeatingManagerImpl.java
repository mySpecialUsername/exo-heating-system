package com.nespresso.heating;

public class HeatingManagerImpl {
	
	public void manageHeating(double t, double threshold, boolean active) {
		if (active)
			if (t < threshold) {
				switchState("on");
			} else {
				switchState("off");
			}
	}

	public void switchState(String s){
		Tools.writeToFile("heater.home", s);
	}
	
}
