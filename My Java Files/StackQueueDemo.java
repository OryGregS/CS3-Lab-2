/**
 * 
 */
package edu.wmich.cs3310.GregSmith.Assignment2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author Greg Smith
 *
 *Main driver for the program
 */
public class StackQueueDemo {

	/**
	 * holds the user-inputted string
	 */
	private String text = null;
	
	/**
	 * holds the choice of the user. 
	 * 1. Manually enter a string to check
	 * 2. Check strings from a file
	 */
	private int choice;
	
	/**
	 * holds the choice of what data structure the user would like to use
	 * 1. Use and print results from a stack
	 * 2. Use and print results from a queue
	 * 3. Use and print results from a stack and a queue
	 */
	private int sqChoice;
	
	/**
	 * ~*~*~*~* ONLY USED TO EASILY STORE THE STRINGS FROM THE FILE SINCE MY CUSTOM LIST IS FOR CHARACTERS, NOT FOR STRINGS *~*~*~*~
	 * 
	 * holds the list of strings that are read from a file that are then turned into a character array and processed through my custom CharList
	 */
	private List<String> fileStrings = new ArrayList<String>();
	
	/**
	 * holds the data for measuring how long balancing the strings takes
	 */
	private long qTime, sTime;
	
	/**
	 * instantiates a DecimalFormat object to use for the time
	 */
	private NumberFormat formatter = new DecimalFormat("#.000");
	
	private long puTime, popTime, eTime, dTime;

	/**
	 * ~ FOR MANUALLY ENTERED STRINGS ~
	 * 
	 * checks the stack for unbalanced parentheses and prints the results
	 */
	void checkStack() { 

		long startTime = getTime();
		
		StackCheckBalancedParentheses scbp = new StackCheckBalancedParentheses(text);
		int unbalNum = scbp.CheckBalancedParentheses();
		
		long endTime = getTime();

		System.out.println("----------------------------------------------------------\n");
		System.out.println("Stack Results:\n\n");

		if (unbalNum == 0) {

			System.out.println(scbp.text + " is balanced.");

		} else {

			System.out.println(scbp.text + " is not balanced. " + unbalNum + " unbalanced parentheses found.");
		}

		sTime = endTime - startTime;
		puTime = scbp.getPuTime();
		popTime = scbp.getPopTime();
		
		System.out.println();
		System.out.println("Time spent on push: " + formatter.format(puTime / 1000000d) + " ms.");
		System.out.println("Time spent on pop: " + formatter.format(popTime / 1000000d) + " ms.");
		System.out.println("Stack Balancing Time: " + formatter.format(sTime / 1000000d) + " ms.");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println();
		
	}

	/**
	 * ~ FOR STRINGS READ FROM A FILE ~
	 * 
	 * reads and prints the results of each String in the list using a stack
	 * 
	 * @param strings - list of Strings to check
	 */
	void checkStack(List<String> strings) { 

		System.out.println("----------------------------------------------------------\n");
		System.out.println("Stack Results:\n\n");

		StackCheckBalancedParentheses scbp;
		int unbalNum;

		long endTime = 0;
		long startTime = getTime();
		
		for (int i = 0; i < strings.size(); i++) {

			scbp = new StackCheckBalancedParentheses(strings.get(i));
			unbalNum = scbp.CheckBalancedParentheses();

			endTime = getTime();
			puTime += scbp.getPuTime();
			popTime += scbp.getPopTime();
			
			if (unbalNum == 0) {

				System.out.println(scbp.text + " is balanced.");

			} else {

				System.out.println(scbp.text + " is not balanced. " + unbalNum + " unbalanced parentheses found.");
			}

			System.out.println();
		}
		
		sTime = endTime - startTime;
		
		System.out.println();
		System.out.println("Time spent on push: " + formatter.format(puTime / 1000000d) + " ms.");
		System.out.println("Time spent on pop: " + formatter.format(popTime / 1000000d) + " ms.");
		System.out.println("Total Stack Balancing Time: " + formatter.format(sTime / 1000000d) + " ms.");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println();
		
		
	}

	/**
	 * ~ FOR MANUALLY ENTERED STRINGS ~
	 * 
	 * checks the queue for unbalanced parentheses and prints the results
	 */
	void checkQueue() {
		
		long startTime = getTime();
		
		QueueCheckBalancedParentheses qcbp = new QueueCheckBalancedParentheses(text);
		int unbalNum = qcbp.CheckBalancedParentheses();

		long endTime = getTime();
		
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Queue Results:\n\n");

		if (unbalNum == 0) {

			System.out.println(qcbp.text + " is balanced");

		} else {

			System.out.println(qcbp.text + " is not balanced. " + unbalNum + " unbalanced parentheses found.");

		}

		qTime = endTime - startTime;
		eTime = qcbp.getETime();
		dTime = qcbp.getDTime();
		
		System.out.println();
		System.out.println("Time spent on enqueue: " + formatter.format(eTime / 1000000d) + " ms.");
		System.out.println("Time spent on dequeue: " + formatter.format(dTime / 1000000d) + " ms.");
		System.out.println("Queue Balancing Time: " + formatter.format(qTime / 1000000d) + " ms.");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println();

	}

	/**
	 * ~ FOR STRINGS READ FROM A FILE ~
	 * 
	 * reads and prints the results of each String in the list using a queue
	 * 
	 * @param strings - list of Strings to check
	 */
	void checkQueue(List<String> strings) {

		System.out.println("----------------------------------------------------------\n");
		System.out.println("Queue Results:\n\n");

		QueueCheckBalancedParentheses qcbp;
		int unbalNum;
		
		long endTime = 0;
		long startTime = getTime();
		
		for (int i = 0; i < strings.size(); i++) {

			qcbp = new QueueCheckBalancedParentheses(strings.get(i));
			unbalNum = qcbp.CheckBalancedParentheses();
			
			endTime = getTime();
			eTime += qcbp.getETime();
			dTime += qcbp.getDTime();

			if (unbalNum == 0) {

				System.out.println(qcbp.text + " is balanced.");

			} else {

				System.out.println(qcbp.text + " is not balanced. " + unbalNum + " unbalanced parentheses found.");

			}

			System.out.println();

		}

		qTime = endTime - startTime;
		
		System.out.println();
		System.out.println("Time spent on enqueue: " + formatter.format(eTime / 1000000d) + " ms.");
		System.out.println("Time spent on dequeue: " + formatter.format(dTime / 1000000d) + " ms.");
		System.out.println("Total Queue Balancing Time: " + formatter.format(qTime / 1000000d) + " ms");
		System.out.println();
		System.out.println("----------------------------------------------------------");
		System.out.println();
		
		
		

	}

	/**
	 * asks the user if they want to manually enter a string to check, or if they want to read strings from a file to check
	 */
	void choices() {

		String input;
		boolean valid = false;

		do {

			input = JOptionPane.showInputDialog("Please Select an Option:\n"
												+ "\n1. Manually enter a string to balance"
												+ "\n2. Balance strings from file");

			if (input.equals("1") || input.equals("2")) {

				choice = Integer.parseInt(input);
				valid = true;

			} else {

				JOptionPane.showMessageDialog(null, "Invalid entry. Please enter \"1\" or \"2\"!");

			}

		} while (valid == false);

	}

	/**
	 * asks the user what data structure they want to use
	 * 1. Use and print results using a stack
	 * 2. Use and print results using a queue
	 * 3. Use and print results using a stack and a queue
	 */
	void stackOrQueue() {

		String input;
		boolean valid = false;

		do {

			input = JOptionPane.showInputDialog("How would you like to balance the Strings?\n"
												+ "Please select an option:"
												+ "\n1. With a Stack"
												+ "\n2. With a Queue"
												+ "\n3. With Both");

			if (input.equals("1") || input.equals("2") || input.equals("3")) {

				sqChoice = Integer.parseInt(input);
				valid = true;

			} else {

				JOptionPane.showMessageDialog(null, "Invalid entry. Please enter \"1\", \"2\", or \"3\"!");

			}

		} while (valid == false);

	}

	/**
	 * main driver for the program. switches the various choices the user made and makes method calls accordingly
	 * asks user if they want to continue
	 * 
	 * @throws IOException
	 */
	void run() throws IOException {

		JOptionPane.showMessageDialog(null,
				"This program checks a String to see if parentheses are balanced or unbalanced!");

		boolean cont = false;
		boolean valid = false;
		
		do {
			
			choices();

			switch (choice) {

			case 1:

				text = getInput();
				stackOrQueue();

				switch (sqChoice) {

				case 1:
					checkStack();
					break;

				case 2:
					checkQueue();
					break;

				case 3:
					checkStack();
					checkQueue();
					break;

				}

				break;

			case 2:

				readFromFile();
				stackOrQueue();

				switch (sqChoice) {

				case 1:
					checkStack(fileStrings);
					break;

				case 2:
					checkQueue(fileStrings);
					break;

				case 3:
					checkStack(fileStrings);
					checkQueue(fileStrings);
					break;

				}

				break;

			}

			
			String input;

			do {

				input = JOptionPane.showInputDialog("Would you like to test more strings?\n"
													+ "\nEnter \"Yes\" to continue"
													+ "\nEnter \"No\" to exit");

				if (input.equalsIgnoreCase("yes")) {

					valid = true;
					cont = true;

				}

				else if (input.equalsIgnoreCase("no")) {

					valid = true;
					cont = false;

				}

				else {
					
					valid = false;
					JOptionPane.showMessageDialog(null, "Invalid input. Please enter \"Yes\" or \"No\"");

				}

			} while (valid == false);

			fileStrings = new ArrayList<String>();
			sTime = qTime = 0;
			
		} while (cont);

	}

	/**
	 * asks user for the file name / file path and reads strings from the file
	 * Only works for .txt files
	 * 
	 * ignores blank lines and lines with only spaces, deletes quotation marks in the string, trims the string,
	 * then adds the string to the list
	 * 
	 * @throws IOException
	 */
	void readFromFile() throws IOException {

		boolean invalid = false;
		Scanner sc = null;

		do {

			String filename = JOptionPane.showInputDialog("Please enter the path for the file you would like to read");

			try {

				sc = new Scanner(new FileReader(filename));
				invalid = false;

			} catch (FileNotFoundException e) {

				invalid = true;
				JOptionPane.showMessageDialog(null, "File not found. Please enter a correct file path.");

			}

		} while (invalid);

		while (sc.hasNext()) {

			String st = sc.nextLine();

			if (st != null && !st.equals(" ")) {

				st = st.replaceAll("“", "");
				st = st.replaceAll("”", "");
				st = st.replaceAll("\"", "");
				st = st.trim();
				fileStrings.add(st);

			}

		}
		
		sc.close();
		
	}
	
	/**
	 * asks the user to manually enter the String they want to check
	 * @return - the string they want to balance
	 */
	String getInput() {
		
		return JOptionPane.showInputDialog("Please enter a String to check if the parentheses are balanced.");
		
	}
	
	/**
	 * returns the time in nanoseconds
	 * @return - time in nanoseconds
	 */
	long getTime() {
		return System.nanoTime();
	}

}
