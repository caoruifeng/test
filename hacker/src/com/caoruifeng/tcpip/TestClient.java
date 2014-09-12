package com.caoruifeng.tcpip;

import java.io.IOException;
import java.net.UnknownHostException;

public class TestClient {
	
	public static void main(String[] args) {
		args=new String[]{"127.0.0.1","hello no body","8080"};
		try {
			TCPEchoClient.main(args);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
