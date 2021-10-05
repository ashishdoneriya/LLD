package com.csetutorials.cache;

public interface Storage<Key, Value> {
	
	void put(Key key, Value value) throws StorageFullException;

	Value get(Key key) throws NotFoundException;

	void remove(Key key);

	void print();

}
