/**
 * 
 */
package edu.wmich.cs3310.GregSmith.Assignment2;

/**
 * @author Greg Smith
 *
 *Custom stack that implements CharList
 */
public class CharStack {

	/**
	 * instantiates a CharList object to be used
	 */
	private CharList cl = new CharList();
	
	
	/**
	 * holds the time for push and pop
	 */
	private long puTime, popTime;
	
	/**
	 * resets the time for push and pop
	 */
	public CharStack() {
		puTime = popTime = 0;
	}

	/**
	 * inserts data into a new node
	 * 
	 * @param c
	 * 
	 */
	void push(char c) {
		
		long startTime = setTime();
		
		cl.insert(c);
		
		long endTime = setTime();
		
		puTime += endTime - startTime;
		
	}

	/**
	 * deletes the value and returns it
	 * 
	 * @return - the character the node is holding
	 * 
	 */
	char pop() { 
		
		long startTime = setTime();
		
		Character c = cl.delete(); 
		
		long endTime = setTime();
		
		popTime += endTime - startTime;
		
		return c;
		
	}
	
	/**
	 * checks if the stack is empty
	 * 
	 * @return true OR false
	 * 
	 */
	boolean isEmpty() {
		
		return cl.isEmpty();
		
	}
	
	/**
	 * returns the current time in nanoseconds
	 * @return - the current time in nanoseconds
	 */
	private long setTime() {
		return System.nanoTime();
	}
	
	/**
	 * returns the total push time
	 * @return - the total push time
	 */
	long getPuTime() {
		return puTime;
	}
	
	/**
	 * returns the total pop time
	 * @return - the total pop time
	 */
	long getPopTime() {
		return popTime;
	}

}
