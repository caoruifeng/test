package com.caoruifeng.thread.crfdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CrfTest {


	public static void main(String[] args) {
//		ThreadPoolExecutor pool = new ThreadPoolExecutor(5, 10, 200,
//				TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		//ExecutorService pool = Executors.newCachedThreadPool();
//		ExecutorService pool = Executors.newFixedThreadPool(10);
		ExecutorService pool = Executors.newSingleThreadExecutor();
//		CompletionService<List<String>> completionService = new ExecutorCompletionService<List<String>>(executor); 
//		completionService.submit(new Callable<List<String>>() {  
//		    @Override  
//		    public List<String> call() throws Exception {  
//		        List<String> data = new ArrayList<String>();  
//		        
//		        return data;  
//		    }  
//		}); 
		for (int i = 0; i < 20; i++) {
			CrfTask myTask = new CrfTask(i);
			pool.execute(myTask);
//			System.out.println("线程池中线程数目：" + executor.getPoolSize()
//					+ "，队列中等待执行的任务数目：" + executor.getQueue().size()
//					+ "，已执行玩别的任务数目：" + executor.getCompletedTaskCount());
	
		}
		//executor.shutdown();
		pool.shutdown();
	}
}
