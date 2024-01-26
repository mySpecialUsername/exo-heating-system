package com.nespresso.heating;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

// those tools could be in separate classes too but I don't want to have too many files
public class Tools {
	
    public static String stringFromURL(String urlString, int byteSize) 
	throws MalformedURLException,IOException {
		URL url = new URL(urlString);
		InputStream is = url.openStream();
		byte[] tempBuffer = new byte[byteSize];
		is.read(tempBuffer);
		String t = new String(tempBuffer);
		is.close();
		return t;
	}

	public static void writeToFile(String fileName, String content){	
		try {
			Socket socket = new Socket(fileName, 9999);
			OutputStream os = socket.getOutputStream();
			os.write(content.getBytes());
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
