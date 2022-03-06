/**
* File Name: InvalidInputDialog.java
* Author: Amero Defranco
* Assignment: Lab 9
* Date: April 18, 2019
* Purpose: This class creates a frame that displays error.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class creates a frame that displays error.
 * @author Amero Defranco
 * @version 3.0
 * @since 1.8.0_201
 */
public class InvalidInputDialog {
	
	/** Frame for error to be displayed **/
	private static JFrame errorFrame;
	
	/**
	 * Creates and displays a frame with an error message.
	 * @param message this parameter takes in the error message to be displayed.
	 */

	public static void errorMessage(String message) {
		
		// Instantiates the error frame, sets the font, and puts it in the middle.
		errorFrame = new JFrame();
		errorFrame.setFont(new Font("Dialog", Font.BOLD,16));
		errorFrame.setLocationRelativeTo(null);

		JOptionPane.showMessageDialog(errorFrame, message, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
