package com.caoruifeng.thread.simple;

public class WorkThread implements Runnable
{
	Object lock = new Object();
	Runnable runner = null;
	ThreadPool pool = null;

	public WorkThread(ThreadPool pool)
	{
		this.pool = pool;
	}

	public void start(Runnable r)
	{
		runner = r;
		synchronized (lock)
		{
			lock.notify();
		}
	}

	public void run()
	{
		while (true)
		{
			if (runner != null)
			{
				runner.run();
				runner = null; //及时回收资源
			}
			if (pool.putWorkThread(this))
			{
				System.out.println(Thread.currentThread().getName() + " 被回收!");
				synchronized (lock)
				{
					try
					{
						lock.wait();
					}
					catch (InterruptedException ie)
					{
						System.out.println("停止线程时出现异常");
					}
				}
			}
			else
			{
				System.out.println(Thread.currentThread().getName() + " 被丢弃!");
				break;
			}
		}
	}
}
