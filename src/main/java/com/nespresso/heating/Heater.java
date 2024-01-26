package com.nespresso.heating;

public class Heater {
	
	public void manageHeating(double threshold) throws Exception{
		double t = Probe.fetchTemperature();
		boolean active = Timer.isActive();
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
