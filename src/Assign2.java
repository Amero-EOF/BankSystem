/**
* File Name: Assign2.java
* Author: Amero Defranco
* Assignment: Lab 9
* Date: April 18, 2019
* Purpose: This class holds the main, which runs the loading frame, and the main frame for the program.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * This class holds the main frame and the loading screen for the bank application.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 */

public class Assign2 {
	
	/**
	 * Main method that instantiates the Bank class, and has commands for the user to run.
	 * @param args accepts an array of strings for the main method 
	 */
	public static void main(String[] args) {
		
		// Try to set the look and feel of the bank account system, if it fails it's not a problem
		// it's only used for esthetic purposes.
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
		
		}
		
		// Creates a new thread to be able to pause the thread for the loading bar, in the loading frame.
		Thread neThred = new Thread(new Runnable() {

			@Override
			public void run() {
				
				@SuppressWarnings("unused")
				LoadingFrame lF = new LoadingFrame();
			}
			
		});
		
		neThred.start();
		// Wait until the loading screen is done and no longer visible.
		while (neThred.getState() != Thread.State.TERMINATED) {
			
		}
		
		// Starts the thread for the main frame for the bank application.
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				

				// Start the bank application.
				@SuppressWarnings("unused")
				MainFrame mF = new MainFrame();
				
			}
		});
	}
}