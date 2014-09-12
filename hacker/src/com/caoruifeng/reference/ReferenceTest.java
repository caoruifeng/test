package com.caoruifeng.reference;
import java.lang.ref.WeakReference;


public class ReferenceTest {
	
	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	/*垃圾回收
	 * 垃圾回收用来清理不会再使用的对象，从而降低内存泄露和数据损坏的可能性。垃圾回收主要有两种类型：追踪和引用计数。
	 * 引用计数会记录给定对象的引用个数，并在引用个数为零时收集该对象。由于一次仅能有一个对象被回收，引用计数无法回收循环引用的对象。
	 * 一组相互引用的对象若没有被其它对象直接引用，并且不可访问，则会永久存活下来。一个应用程序如果持续地产生这种不可访问的对象群组，
	 * 就会发生内存泄漏。在对象群组内部使用弱引用（即不会在引用计数中被计数的引用）有时能避免出现引用环，
	 * 因此弱引用可用于解决循环引用的问题。如Apple的Cocoa框架就推荐使用这种方法，具体为，在父对子引用时使用强引用，
	 * 子对父引用时使用弱引用，从而避免了循环引用。
	 * 程序对一些对象只进行弱引用，通过此法可以指明哪些对象是不重要的，因此弱引用也用于尽量减少内存中不必要的对象存在的数量。
	 */
	
	public static void main(String[] args) throws InterruptedException {
		 
        WeakReference r = new WeakReference(new String("I'm here"));
        WeakReference sr = new WeakReference("I'm here");
        System.out.println("before gc: r=" + r.get() + ", static=" + sr.get());
        System.gc();
        Thread.sleep(100);

        //只有r.get()变为null
        System.out.println("after gc: r=" + r.get() + ", static=" + sr.get());

}
}
