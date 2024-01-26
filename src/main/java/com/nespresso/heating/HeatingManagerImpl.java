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
		if (t < threshold && active) {
			try {
				Socket socket = new Socket("heater.home", 9999);
				OutputStream os = socket.getOutputStream();
				os.write("on".getBytes());
				os.flush();
				os.close();
				socket.close();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (t > threshold && active) {
			try {
				Socket socket = new Socket("heater.home", 9999);
				OutputStream os = socket.getOutputStream();
				os.write("off".getBytes());
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

}
