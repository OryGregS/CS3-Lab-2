/**
 * 
 */
package edu.wmich.cs3310.GregSmith.Assignment2;

/**
 * 
 * @author Greg Smith
 *
 *Custom Queue that implements a linked list
 *
 */
public class CharQueue {

	/**
	 * 
	 * instantiates a CharList object to use for the queue
	 * 
	 */
	private CharList cl = new CharList();
	
	
	/**
	 * holds the total time for enqueue and dequeue
	 */
	private long eTime, dTime;
	
	/**
	 * resets the enqueue and dequeue time
	 */
	public CharQueue() {
		eTime = dTime = 0;
	}

	/**
	 * adds a character to a node at the back of the list
	 * 
	 * @param c - data to be added
	 * 
	 */
	void enqueue(char c) {
		
		long startTime = setTime();
		
		cl.insertLast(c);
		
		long endTime = setTime();
		
		eTime += endTime - startTime;
		
	}

	/**
	 * deletes the first node from the list
	 * 
	 * @return - the data from the first node of the list
	 * 
	 */
	char dequeue() {
		
		long startTime = setTime();
		
		Character c = cl.delete();
		
		long endTime = setTime();
		
		dTime += endTime - startTime;
		
		return c;
		
	}

	/**
	 * checks if the list is empty
	 * 
	 * @return - true OR false
	 * 
	 */
	boolean isEmpty() {

		return cl.isEmpty();

	}
	
	/**
	 * returns the size of the list
	 * 
	 * @return - the size of the list
	 */
	int getQSize() {
		return cl.size();
	}
	
	/**
	 * returns the current time in nanoseconds
	 * @return - the current time in nanoseconds
	 */
	private long setTime() {
		return System.nanoTime();
	}
	
	/**
	 * returns the total enqueue time
	 * @return - the total enqueue time
	 */
	long getETime() {
		return eTime;
	}
	
	/**
	 * returns the total dequeue time
	 * @return - the total dequeue time
	 */
	long getDTime() {
		return dTime;
	}

	
}
