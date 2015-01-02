package com.caoruifeng.thread.demo;

import java.util.Stack;

public class ThreadPool
{
	static int MAX_THREAD = 1000;
	static int MIN_THREAD = 14;
	static int id = 1; //线程 ID 号,主要用于监视线程的工作情况
	static private ThreadPool pool = new ThreadPool();

	static public ThreadPool getThreadPool()
	{
		return pool;
	}

	Stack<WorkThread> stack = new Stack<WorkThread>();

	private ThreadPool()
	{
	}

	synchronized public boolean putWorkThread(WorkThread wt)
	{
		if (stack.size() >MIN_THREAD)
		{
			stack.push(wt);
			return true;
		}
		else
		{
			return false;
		}
	}

	synchronized public WorkThread getWorkThread()
	{
		WorkThread wt = null;
		if (stack.isEmpty())
		{
			wt = new WorkThread(this);
			new Thread(wt, "线程ID:" + id).start();
			id++;
		}
		else
		{
			wt = stack.pop();
		}
		return wt;
	}
}