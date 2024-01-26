package com.nespresso.heating;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class HeatingManagerImpl {
	
	public void manageHeating(String t, String threshold, boolean active){
		double dT = Double.parseDouble(t);
		double dThreshold = Double.parseDouble(threshold);
		manageHeating(dT, dThreshold, active);
	}

	public void manageHeating(double t, double threshold, boolean active) {
		if (active)
			if (t < threshold) {
				switchState("on");
			} else {
				switchState("off");
			}
	}

	public void switchState(String s){
		try {
			Socket socket = new Socket("heater.home", 9999);
			OutputStream os = socket.getOutputStream();
			os.write(s.getBytes());
			os.flush();
			os.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
