/**
 * 
 */
package edu.wmich.cs3310.GregSmith.Assignment2;

/**
 * @author Greg Smith
 *
 *Checks strings for balanced parentheses using a stack
 */
public class StackCheckBalancedParentheses {

	/**
	 * holds the String to be checked
	 */
	String text;

	/**
	 * instantiates a new CharStack object to be used
	 */
	CharStack chs = new CharStack();
	
	/**
	 * holds the characters from the String to be checked
	 */
	private char[] ch;

	/**
	 * Passes the String to be checked into the class
	 * Turns the String to be checked into an array of characters
	 * 
	 * @param input - string to be checked
	 */
	StackCheckBalancedParentheses(String input) {
		
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

				chs.push(ch[i]);
				break;

			case ')':
				
				if (chs.isEmpty()) {
					
					unbalNum++;
					break;
					
				}

				if (chs.pop() != '(') {
					
					unbalNum++;
					break;
					
				}
			}
		}
		
		while (chs.isEmpty() == false) {
			
			chs.pop();
			unbalNum++;
			
		}

		return unbalNum;

	}
	
	/**
	 * returns the total push time
	 * @return - the total push time
	 */
	long getPuTime() {
		return chs.getPuTime();
	}
	
	/**
	 * returns the total pop time
	 * @return - the total pop time
	 */
	long getPopTime() {
		return chs.getPopTime();
	}
}