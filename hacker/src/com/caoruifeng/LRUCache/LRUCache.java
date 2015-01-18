package com.caoruifeng.LRUCache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
	private static final float hashTableLoadFactor = 0.75f;
	private LinkedHashMap<K, V> map;
	private int cacheSize;

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		int hashTableCapacity = (int) Math
				.ceil(cacheSize / hashTableLoadFactor) + 1;
		map = new LinkedHashMap<K, V>(hashTableCapacity, hashTableLoadFactor,
				true) {
			// (an anonymous inner class)
			private static final long serialVersionUID = 1;

			@Override
			protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
				return size() > LRUCache.this.cacheSize;
			}
		};
	}

	/**
	 * @param key
	 * @return
	 */
	public synchronized V get(K key) {
		return map.get(key);
	}

	/**
	 * @param key
	 * @param value
	 */
	public synchronized void put(K key, V value) {
		map.put(key, value);
	}

	/**
	 * 
	 */
	public synchronized void clear() {
		map.clear();
	}

	/**
	 * @return
	 */
	public synchronized int usedEntries() {
		return map.size();
	}

	/**
	 * @return
	 */
	public synchronized Collection<Map.Entry<K, V>> getAll() {
		return new ArrayList<Map.Entry<K, V>>(map.entrySet());
	}

	public static void main(String[] args) {
		LRUCache<String, String> c = new LRUCache<String, String>(3);
		c.put("1", "one"); // 1
		c.put("2", "two"); // 2 1
		c.put("3", "three"); // 3 2 1
		c.put("4", "four"); // 4 3 2
		if (c.get("2") == null)
			throw new Error(); // 2 4 3
		c.put("5", "five"); // 5 2 4
		c.put("4", "second four"); // 4 5 2
		// Verify cache content.
		if (c.usedEntries() != 3)
			throw new Error();
		if (!c.get("4").equals("second four"))
			throw new Error();
		if (!c.get("5").equals("five"))
			throw new Error();
		if (!c.get("3").equals("two"))
			throw new Error();
		// List cache content.
		for (Map.Entry<String, String> e : c.getAll())
			System.out.println(e.getKey() + " : " + e.getValue());
	}
}
