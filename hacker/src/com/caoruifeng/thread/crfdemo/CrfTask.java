package com.caoruifeng.thread.crfdemo;

public class CrfTask implements Runnable {

	private  int tasknum;
	

	public CrfTask(int tasknum) {
		super();
		this.tasknum = tasknum;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("正在执行 第"+tasknum+"任务");
		try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+tasknum+"执行完毕");
	}

}
