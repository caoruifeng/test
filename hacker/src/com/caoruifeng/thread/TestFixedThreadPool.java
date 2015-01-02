package com.caoruifeng.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {
	public static void main(String[] args) {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(10);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        
        for (int i = 0; i < 10; i++) {
        	// 将线程放入池中进行执行
       	 pool.execute(new MyThread());
       	// int threadSize = queue.size();  
		}
        // 关闭线程池
        pool.shutdown();
    }
}
