package com.caoruifeng.thread;

public class MyThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName() + "正在执行。。。");
		super.run();
	}
}
