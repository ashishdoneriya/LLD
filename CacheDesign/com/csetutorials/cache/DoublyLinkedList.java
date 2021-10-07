package com.csetutorials.cache;

public class DoublyLinkedList<E> {

	private DoublyLinkedListNode<E> head;

	private DoublyLinkedListNode<E> tail;

	public DoublyLinkedList() {
		this.head = new DoublyLinkedListNode<>(null);
		this.tail = new DoublyLinkedListNode<>(null);
		this.head.next = this.tail;
		this.tail.prev = this.head;
	}

	/**
	 * Adds the element to the tail of the queue
	 * @param element
	 */
	public DoublyLinkedListNode<E> add(E element) {
		DoublyLinkedListNode<E> node = new DoublyLinkedListNode<>(element);
		node.prev = tail.prev;
		node.next = tail;
		tail.prev.next = node;
		tail.prev = node;
		return node;
	}

	/**
	 * Removes the particular element
	 * @param node
	 */
	public void remove(DoublyLinkedListNode<E> node) {
		DoublyLinkedListNode<E> prev = node.prev;
		DoublyLinkedListNode<E> next = node.next;
		prev.next = next;
		next.prev = prev;
	}

	/**
	 * Removes the element from the head of the queue
	 * @return
	 */
	public DoublyLinkedListNode<E> remove() {
		if (this.head.next == this.tail) {
			return null;
		}
		DoublyLinkedListNode<E> element = this.head.next;
		this.head.next = element.next;
		element.next.prev = this.head;
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
