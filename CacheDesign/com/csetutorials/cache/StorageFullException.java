package com.csetutorials.cache;

public class StorageFullException extends RuntimeException{
	
	public StorageFullException() {
		super("Storage is full");
	}

}
