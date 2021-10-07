package com.csetutorials.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/lfu-cache/discuss/1489539/Java-solution-using-LRU-as-base-implementation-with-Explanation
 */
public class LFUEvictionPolicy<Key> implements EvictionPolicy<Key> {
	
	private Map<Key, Integer> nodesFrequencies;
	private Map<Integer, EvictionPolicy<Key>> lruCacheMap;
	private int capacity;
	private int minFrequency;

	public LFUEvictionPolicy() {
		this.lruCacheMap = new HashMap<>();
		this.nodesFrequencies = new HashMap<>();
		this.minFrequency = 1;
	}

	@Override
	public void access(Key key) {
		this.capacity++;
		if (this.nodesFrequencies.containsKey(key)) {
			int oldFrequency = this.nodesFrequencies.get(key);
			EvictionPolicy<Key> lruPolicy = this.lruCacheMap.get(oldFrequency);
			lruPolicy.remove(key);
			int updatedFrequency = oldFrequency + 1;
			if (lruPolicy.size() == 0 && oldFrequency == this.minFrequency) {
				this.minFrequency = updatedFrequency;
			}
			lruPolicy = getOrCreatePolicy(updatedFrequency);
			lruPolicy.access(key);
			this.nodesFrequencies.put(key, updatedFrequency);
		} else {
			System.out.println("LFU : Cache block " + key + " inserted.");
			// Adding key to the first frequency queue
			EvictionPolicy<Key> lruPolicy = getOrCreatePolicy(1);
			lruPolicy.access(key);
			this.nodesFrequencies.put(key, 1);
		}
	}

	@Override
	public Key evict() {
		this.capacity--;
		if (this.lruCacheMap.containsKey(this.minFrequency)) {
			EvictionPolicy<Key> lruPolicy = this.lruCacheMap.get(this.minFrequency);
			Key key = lruPolicy.evict();
			this.nodesFrequencies.remove(key);
			System.out.println("LFU : Cache block " + key + " removed");
			if (lruPolicy.size() == 0) {
				this.minFrequency++;
			}
			return key;
		}
		return null;
	}

	@Override
	public void remove(Key key) {
		this.capacity--;
		if (this.nodesFrequencies.containsKey(key)) {
			int frequency = this.nodesFrequencies.get(key);
			EvictionPolicy<Key> lruPolicy = this.lruCacheMap.get(frequency);
			lruPolicy.remove(key);
			if (lruPolicy.size() == 0 && this.minFrequency == frequency) {
				this.minFrequency++;
			}
			System.out.println("LFU : Cache block " + key + " removed");
		}
	}

	@Override
	public int size() {
		return this.capacity;
	}

	private EvictionPolicy<Key> getOrCreatePolicy(int frequency) {
		EvictionPolicy<Key> lru = this.lruCacheMap.get(frequency);
		if (lru == null) {
			lru = new LRUEvictionPolicy<>();
			this.lruCacheMap.put(frequency, lru);
		}
		return lru;
	}

}
