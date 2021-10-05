package com.csetutorials.cache;

public class DoublyLinkedList<E> {

	private DoublyLinkedListNode<E> head;

	private DoublyLinkedListNode<E> tail;

	/**
	 * Adds the element to the tail of the queue
	 * @param element
	 */
	public DoublyLinkedListNode<E> add(E element) {
		DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
		}
		return node;
	}

	/**
	 * Removes the particular element
	 * @param node
	 */
	public void remove(DoublyLinkedListNode<E> node) {
		DoublyLinkedListNode<E> prev = node.prev;
		DoublyLinkedListNode<E> next = node.next;
		if (prev == null && next == null) {
			this.head = null;
			this.tail = null;
		} else if (prev == null) {
			this.head = next;
		} else if (next == null) {
			this.tail = prev;
		} else {
			prev.next = next;
			next.prev = prev;
		}
	}

	/**
	 * Removes the element from the head of the queue
	 * @return
	 */
	public DoublyLinkedListNode<E> remove() {
		if (this.head == null) {
			return null;
		}
		DoublyLinkedListNode<E> element = this.head;
		this.head = this.head.next;
		if (this.head == null) {
			this.tail = null;
		}
		return element;
	}


	public static class DoublyLinkedListNode<E> {

		private DoublyLinkedListNode<E> prev;
	
		private DoublyLinkedListNode<E> next;
	
		private E element;

		public DoublyLinkedListNode(E element) {
			this.element = element;
		}
	
		public DoublyLinkedListNode(DoublyLinkedListNode<E> prev, DoublyLinkedListNode<E> next, E element) {
			this.element = element;
		}
	
		public E getElement() {
			return element;
		}
		
	}
	
	
}
