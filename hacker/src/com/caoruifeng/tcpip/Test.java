package com.caoruifeng.tcpip;

import java.io.IOException;

public class Test {
	
	public static void main(String[] args) {
		args=new String[]{"8080"};
		try {
			TCPEchoServer.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
