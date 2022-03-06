/**
* File Name: SavingsFrame.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This class creates the savings account in the UI.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, TextFileFilter.java
*/

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.math.BigInteger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This class creates the savings account in the UI.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 */

@SuppressWarnings("serial")
public class SavingsFrame extends JFrame {
	
	/** The account number label for display **/
	private JLabel accountNumberLabel;
	/** The first name label for display **/
	private JLabel fNameLabel;
	/** The last name label for display **/
	private JLabel lNameLabel;
	/** The phone number label for display **/
	private JLabel phoneNumLabel;
	/** The email address label for display **/
	private JLabel emailLabel;
	/** The opening balance label for display **/
	private JLabel openBalLabel;
	/** The interest label for display **/
	private JLabel interestLabel;
	/** The minimum balance label for display **/
	private JLabel minBalLabel;
	
	/** The account number text field for input **/
	private JTextField accountNumberTextField;
	/** The first name label text field for input **/
	private JTextField fNameTextField;
	/** The last name text field for input **/
	private JTextField lNameTextField;
	/** The phone number text field for input **/
	private JTextField phoneNumTextField;
	/** The email address text field for input **/
	private JTextField emailTextField;
	/** The opening balance text field for input **/
	private JTextField openBalTextField;
	/** The interest text field for input **/
	private JTextField interestTextField;
	/** The minimum balance text field for input **/
	private JTextField minBalTextField;
	
	/** The create button for creating an account **/
	private JButton create;
	
	/** The constraint for frame **/
	private GridBagConstraints constraint;
	/** The font for the labels, text fields, and buttons **/
	private Font font;
	
	/**
	 * Parameterless constructor to set up all of the labels, text fields, and buttons.
	 */
	
	public SavingsFrame() {
		super("New Savings Account");
		
		// Instantiate the constraints, and the font.
		constraint = new GridBagConstraints();
		font = new Font("Dialog", Font.PLAIN,16);
		
		// Set up all the parameters for the frame.
		setSize(400, 400);
		setVisible(true);
		setLayout(new GridBagLayout());
		setResizable(false);
		setLocationRelativeTo(null);
		
		// Set the anchor point and the constraints for the layout.
		constraint.anchor = GridBagConstraints.LINE_END;
		constraint.insets = new Insets(3,0,3,0);
		
		
		// --- Labels --- //
		
		// Add the account number label with the new font.
		accountNumberLabel = new JLabel("Account Number ");
		accountNumberLabel.setFont(font);
		
		constraint.gridy++;
		add(accountNumberLabel, constraint);
		
		// Add the first name label with the new font.
		fNameLabel = new JLabel("First Name ");
		fNameLabel.setFont(font);
		
		constraint.gridy++;
		add(fNameLabel, constraint);
		
		// Add the last name label with the new font.
		lNameLabel = new JLabel("Last Name ");
		lNameLabel.setFont(font);
		
		constraint.gridy++;
		add(lNameLabel, constraint);
		
		// Add the phone number label with the new font.
		phoneNumLabel = new JLabel("Phone Number ");
		phoneNumLabel.setFont(font);
		
		constraint.gridy++;
		add(phoneNumLabel, constraint);
		
		// Add the email address label with the new font.
		emailLabel = new JLabel("Email Address ");
		emailLabel.setFont(font);
		
		constraint.gridy++;
		add(emailLabel, constraint);
		
		// Add the opening balance label with the new font.
		openBalLabel = new JLabel("Opening Balance ");
		openBalLabel.setFont(font);
		
		constraint.gridy++;
		add(openBalLabel, constraint);
		
		// Add the interest label with the new font.
		interestLabel = new JLabel("Interest Rate ");
		interestLabel.setFont(font);
		
		constraint.gridy++;
		add(interestLabel, constraint);
		
		// Add the minimum balance with the new font.
		minBalLabel = new JLabel("Minimum Balance ");
		minBalLabel.setFont(font);
		
		constraint.gridy++;
		add(minBalLabel, constraint);
		
		// --- Text fields --- //
		
		// Reset the constraints and set the anchor to the start of the line.
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.gridx = 1;
		constraint.gridy = 0;
		
		
		// --- Text fields --- //
		
		// Add the account number text field with the new font.
		accountNumberTextField = new JTextField(15);
		accountNumberTextField.setFont(font);
		
		add(accountNumberTextField, constraint);
		
		// Add the first name text field with the new font.
		fNameTextField = new JTextField(15);
		fNameTextField.setFont(font);
		
		constraint.gridy++;
		add(fNameTextField, constraint);
		
		// Add the last name text field with the new font.
		lNameTextField = new JTextField(15);
		lNameTextField.setFont(font);
		
		constraint.gridy++;
		add(lNameTextField, constraint);
		
		// Add the phone number text field with the new font.
		phoneNumTextField = new JTextField(15);
		phoneNumTextField.setFont(font);
		
		constraint.gridy++;
		add(phoneNumTextField, constraint);
		
		// Add the email address text field with the new font.
		emailTextField = new JTextField(15);
		emailTextField.setFont(font);
		
		constraint.gridy++;
		add(emailTextField, constraint);
		
		// Add the opening balance text field with the new font.
		openBalTextField = new JTextField(15);
		openBalTextField.setFont(font);
		
		constraint.gridy++;
		add(openBalTextField, constraint);
		
		// Add the interest text field with the new font.
		interestTextField = new JTextField(15);
		interestTextField.setFont(font);
		
		constraint.gridy++;
		add(interestTextField, constraint);
		
		// Add the minimum balance text field with the new font.
		minBalTextField = new JTextField(15);
		minBalTextField.setFont(font);
		
		constraint.gridy++;
		add(minBalTextField, constraint);
		
		// Add create button and fill it to be larger than the default size.
		create = new JButton("Create Account");
		constraint.gridy++;
		constraint.fill = 1;
		
		add(create, constraint);
		
		// Add a listener for the create button to create the account.
		create.addActionListener(e -> CreateAccount());
		
	}
	
	/**
	 * This method grabs all of the values from the user, and creates the account.
	 */
	public void CreateAccount() {
		
		// Check if the account number's type is correct.
		try {
			Long.parseLong(accountNumberTextField.getText());
		} catch(Exception e) {
			InvalidInputDialog.errorMessage("Account Number is not a valid long");
			return;
		}
		
		// Check if the phone number's type is correct.
		try {
			new BigInteger(phoneNumTextField.getText());
			if (phoneNumTextField.getText().contains("-")) {
				InvalidInputDialog.errorMessage("Phone Number is a negative value");
				return;
			}
		} catch(Exception e) {
			InvalidInputDialog.errorMessage("Phone Number is not a valid integer");
			return;
		}
		
		// Check if the email is correct by calling the MainFrame's emailCheck method.
		try { 
			boolean check = !MainFrame.emailCheck(emailTextField.getText());
			if (check) {
				throw(new Exception(""));
			}
		} catch(Exception e) {
			InvalidInputDialog.errorMessage("Enter a valid email"); 
			return;
		}
		
		// Check if the open balance's type is correct.
		try {
			Double.parseDouble(openBalTextField.getText());
		} catch(Exception e) {
			InvalidInputDialog.errorMessage("The opening balance is not a valid number");
			return;
		}
		
		// Check if the interest's type is correct.
		try {
			Double.parseDouble(interestTextField.getText());
		} catch(Exception e) {
			InvalidInputDialog.errorMessage("The interest is not a valid number");
			return;
		}
		
		// Check if the minimum balance's type is correct.
		try {
			Double.parseDouble(minBalTextField.getText());
		} catch(Exception e) {
			InvalidInputDialog.errorMessage("The minimum balance is not a valid number");
			return;
		}
		
		// Try to add a new account.
		boolean success	= Bank.addAccount(Long.parseLong(accountNumberTextField.getText()),
										  fNameTextField.getText(),lNameTextField.getText(),
										  new BigInteger(phoneNumTextField.getText()),
										  emailTextField.getText(),
										  Double.parseDouble(openBalTextField.getText()),
										  Double.parseDouble(interestTextField.getText()),
										  Double.parseDouble(minBalTextField.getText())
										  );
		
		// If the creation of the new account was not a success return back and get the user to change their input.
		if (!success) {
			return;
		}
		
		// Hide the frame if creation of the account was a success.
		setVisible(false);
		
	}
}
