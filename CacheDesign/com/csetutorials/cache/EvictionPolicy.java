package com.csetutorials.cache;

public interface EvictionPolicy<Key> {

	void access(Key key);

	Key evict();

	void remove(Key key);

	int size();

}
