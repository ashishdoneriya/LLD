package com.csetutorials.cache;

import java.util.HashMap;
import java.util.Map;

import com.csetutorials.cache.DoublyLinkedList.DoublyLinkedListNode;

public class LRUEvictionPolicy<Key> implements EvictionPolicy<Key> {

	private final DoublyLinkedList<Key> queue;

	private final Map<Key, DoublyLinkedListNode<Key>> map;

	public LRUEvictionPolicy() {
		this.queue = new DoublyLinkedList<>();
		this.map = new HashMap<>();
	}

	@Override
	public void access(Key key) {
		if (this.map.containsKey(key)) {
			DoublyLinkedListNode<Key> node = this.map.get(key);
			queue.remove(node);
			node = queue.add(key);
			this.map.put(key, node);
		} else {
			DoublyLinkedListNode<Key> node = queue.add(key);
			this.map.put(key, node);
		//	System.out.println("LRU : Cache block " + key + " inserted.");
		}
	}

	@Override
	public Key evict() {
		if (this.map.isEmpty()) {
			return null;
		}
		DoublyLinkedListNode<Key>  node = this.queue.remove();
		this.map.remove(node.getElement());
//		System.out.println("LRU : Cache block " + node.getElement() + " removed.");
		return node.getElement();
	}

	@Override
	public void remove(Key key) {
		if (this.map.containsKey(key)) {
			DoublyLinkedListNode<Key> node = this.map.get(key);
			this.map.remove(key);
			queue.remove(node);
		}
	}

	@Override
	public int size() {
		return this.map.size();
	}
	
}
