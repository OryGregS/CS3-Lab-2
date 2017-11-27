/**
 * 
 */
package edu.wmich.cs3310.GregSmith.Assignment2;

/**
 * @author Greg Smith
 * 
 *Custom List for characters
 *
 */
public class CharList {

	/**
	 * head holds the first node in the list
	 */
	private CharNode head = new CharNode();
	
	/**
	 * tail holds the last node in the list
	 */
	private CharNode tail = new CharNode();
	
	/**
	 * size holds the size of the list
	 */
	private int size;

	/**
	 * Constructor for CharList that clears the list
	 */
	public CharList() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
		
	}

	/**
	 * ~ FOR STACK ~
	 * inserts a new node at the end of a list with char data.
	 * 
	 * @param data - the character to be added to the list
	 * 
	 */
	void insert(char data) {

		if (!isEmpty()) {

			CharNode prev = new CharNode();
			prev = tail;
			tail = new CharNode(null, data);
			prev.setNext(tail);

		}

		else {

			tail = new CharNode(null, data);
			head = tail;

		}

		size++;

	}
	
	/**
	 * ~ FOR QUEUE ~
	 * inserts a new node at the end of the list with char data
	 * 
	 * @param data - the character to be added to the list
	 * 
	 */
	void insertLast(char data) {
		
		CharNode n = new CharNode(data);
		
        if (isEmpty()) {
        	
            n.next = head;
            head = n;
            tail = n;
            
        } else {
        	
            tail.next = n;
            tail = n;
            tail.next = null;
            
        }
        
        size++;
	}
	
	/**
	 * deletes the first node in the list
	 * 
	 * @return - data in the first node
	 * 
	 */
	Character delete() {
		
		if (size() == 0) {
			
			return null;
			
		} else {
		
		CharNode temp = head;
		head = head.next;
		size--;
		return temp.getData();
		
		}
		
	}


	/**
	 * returns true if the list is empty
	 * @return true OR false
	 */
	boolean isEmpty() {
		
		return head == null;
		
	}
	
	/**
	 * returns the size of the list
	 * @return - list size
	 */
	int size() {
		
		return this.size;
		
	}
}
