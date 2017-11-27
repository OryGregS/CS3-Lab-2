/**
 * 
 */
package edu.wmich.cs3310.GregSmith.Assignment2;

/**
 * @author Greg Smith
 *
 *Checks Strings for balanced parentheses using queues
 *
 *~ this class uses 2 queues to emulate a stack ~
 */
public class QueueCheckBalancedParentheses {

	/**
	 * holds the String to be checked
	 */
	String text;
	
	/**
	 * first queue object
	 */
	CharQueue cq1 = new CharQueue();
	
	/**
	 * second queue object
	 */
	CharQueue cq2 = new CharQueue();
	
	/**
	 * holds each character of the string
	 */
	private char[] ch;

	/**
	 * passes the String to be checked into the class
	 * turns the String to be check into the character array
	 * 
	 * @param input - String to be checked
	 */
	QueueCheckBalancedParentheses(String input) {
		
		text = input;
		ch = text.toCharArray();
		
		
	}

	/**
	 * checks the parentheses and totals the number of unbalanced parentheses if there are any
	 * 
	 * @return - number of unbalanced parentheses
	 * 
	 */
	int CheckBalancedParentheses() {

		int unbalNum = 0;

		for (int i = 0; i < ch.length; i++) {

			switch (ch[i]) {

			case '(':

				qPush(ch[i]);
				break;

			case ')':
				
				if (cq1.isEmpty() && cq2.isEmpty()) {
					
					unbalNum++;
					break;
					
				}

				if (qPop() != '(') {
					
					unbalNum++;
					break;
					
				}
			}
		}
		
		while (qCheckSize() != 0) {
			
			qPop();
			unbalNum++;
			
		}

		return unbalNum;

	}
	
	/**
	 * Simulates a stack's push by inserting all of the data into the first queue
	 * 
	 * @param c - data to be added to the queue
	 * 
	 */
	void qPush(char c) {
		
		cq1.enqueue(c);
		
	}
	
	/**
	 * Simulates a stack's pop by adding all but the last value of the first queue into the second queue
	 * Then switches the name of the first and second queues to be used again (since all of the values are now in the other queue)
	 * 
	 * @return - last value in the first queue
	 * 
	 */
	char qPop() {
		
		while (cq1.getQSize() > 1) {
			
			cq2.enqueue(cq1.dequeue());
			
		}
		
		char ch = cq1.dequeue();
		
		CharQueue temp1 = cq2;
		CharQueue temp2 = cq1;
		
		cq2 = temp2;
		cq1 = temp1;
		
		
		return ch;
	}
	
	/**
	 * adds and returns the size of the first and second queue
	 * 
	 * @return - the sum of the size of queue1 and queue2
	 */
	int qCheckSize() {
		
		return cq1.getQSize() + cq2.getQSize();
		
	}
	
	/**
	 * returns the sum of queue1 and queue2's enqueue time
	 * @return - the sum of queue1 and queue2's enqueue time
	 */
	long getETime() {
		return (cq1.getETime() + cq2.getETime());
	}
	
	/**
	 * returns the sum of queue1 and queue2's dequeue time
	 * @return - the sum of queue1 and queue2's dequeue time
	 */
	long getDTime() {
		return (cq1.getDTime() + cq2.getDTime());
	}
}
