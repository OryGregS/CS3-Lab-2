/**
 * 
 */
package edu.wmich.cs3310.GregSmith.Assignment2;

/**
 * @author Greg Smith
 *
 *Custom node class for CharList
 *
 */
public class CharNode {

	/**
	 * holds the char data for each node
	 */
	private char myData;
	
	/**
	 * holds the value for the next node
	 */
	public CharNode next;

	/**
	 * default constructor
	 */
	public CharNode() {

	}
	
	/**
	 * Constructor to pass data in the node
	 * 
	 * @param data - char data to be stored in the node
	 * 
	 */
	public CharNode(char data) {
		
		myData = data;
		
	}

	/**
	 * constructor to set the next node and pass data
	 * 
	 * @param next - sets the next node in the list
	 * @param data - char data to be stored in the node
	 * 
	 */
	public CharNode(CharNode next, char data) {

		this.next = next;
		this.myData = data;

	}

	/**
	 * sets the next node in the list
	 * 
	 * @param next - next node in the list
	 * 
	 */
	void setNext(CharNode next) {

		this.next = next;

	}

	/**
	 * returns the char data at the current node
	 * 
	 * @return - char data
	 * 
	 */
	char getData() {
		
		return this.myData;
		
	}
	
	/**
	 * gets the next node and returns it
	 * 
	 * @return - next node
	 */
	CharNode getNext() {
		
		return this.next;
		
	}
	
}
