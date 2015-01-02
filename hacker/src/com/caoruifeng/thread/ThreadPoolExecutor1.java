package com.caoruifeng.thread;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class ThreadPoolExecutor1 {

	public static void main(String[] args) throws InterruptedException {
//		int time = 10;
//		Queue<Integer> queue = new LinkedList<Integer>();
//		Queue<Integer> pQueue = new PriorityQueue<Integer>();
//		for (int i = time; i >= 0; i--)
//			queue.add(i);
//		
//		
//		
//		
//		System.out.println(queue);
//		System.out.println("----------1");
//		System.out.println(pQueue);
//		while (!queue.isEmpty()) {
//			pQueue.add(queue.remove());
//		}
//		System.out.println("----------2");
//		System.out.println(pQueue);
//		while (!pQueue.isEmpty()) {
//			System.out.println(pQueue.remove());
//		}
		
		int time = 10;
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> pQueue = new PriorityQueue<Integer>();
		for (int i = time; i >= 0; i--)
		queue.add(i);
		while(!queue.isEmpty()) {
		pQueue.add(queue.remove()); 
		}

		System.out.println(pQueue);
		pQueue.remove();
		System.out.println(pQueue);
	}
}
