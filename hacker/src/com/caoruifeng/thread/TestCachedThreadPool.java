package com.caoruifeng.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCachedThreadPool implements Runnable {
	
	   public void run() {   
	          synchronized(this) {   
	            try{  
	                System.out.println(Thread.currentThread().getName());  
	                Thread.sleep(3000);  
	            }catch (InterruptedException e){  
	                e.printStackTrace();  
	            }  
	          }   
	     }  
	   
	   
	 public static void main(String[] args) {
         
		// BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>(); 
		
		// ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 6, 1, TimeUnit.DAYS, queue); 
		// 创建一个可重用固定线程数的线程池
		 ExecutorService pool = Executors.newCachedThreadPool();
		 
         for (int i = 0; i < 10; i++) {
        	 pool.execute(new Thread(new TestCachedThreadPool(),"TestThread".concat(""+i)));
        	// int threadSize = queue.size();  
            // System.out.println("线程队列大小为-->"+threadSize);  
		}
         
         // 将线程放入池中进行执行
//         pool.execute(t1);
//         pool.execute(t2);
//         pool.execute(t3);
//         pool.execute(t4);
//         pool.execute(t5);
         // 关闭线程池
         pool.shutdown();
     }
}
