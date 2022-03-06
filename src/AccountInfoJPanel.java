/**
* File Name: AccountInfoJPanel.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This is the Account info JPanel which is displayed on the right side, it has buttons for withdraw and deposit.
* Class List: AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java,TextFileFilter.java
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.SoftBevelBorder;

/**
* Account info JPanel which is displayed on the right side.
* @author Amero Defranco, 040935555
* @version 3.0
* @since 1.8.0_201
* 
*/

@SuppressWarnings("serial")
public class AccountInfoJPanel extends JPanel {
	
	/** Placeholder text for the account number value. **/
	private JLabel accountNumberPlaceholderLabel;
	/** Placeholder text for the first name value. **/
	private JLabel fNamePlaceholderLabel;
	/** Placeholder text for the last name value. **/
	private JLabel lNamePlaceholderLabel;
	/** Placeholder text for the phone number value. **/
	private JLabel phonePlaceholderLabel;
	/** Placeholder text for the email value. **/
	private JLabel emailPlaceholderLabel;
	/** Placeholder text for the balance value. **/
	private JLabel balPlaceholderLabel;
	/** Placeholder text for the fee or the interest values dependent on the account type. **/
	private JLabel interestOrFeePlaceholderLabel;
	/** Placeholder text for the minimum balance value. **/
	private JLabel minBalPlaceholderLabel;
	
	/** A Label for the account number. **/
	private JLabel accountNumberLabel;
	/** A Label for the first name. **/
	private JLabel fNameLabel;
	/** A Label for the last name. **/
	private JLabel lNameLabel;
	/** A Label for the phone number. **/
	private JLabel phoneNumLabel;
	/** A Label for the email. **/
	private JLabel emailLabel;
	/** A Label for the balance. **/
	private JLabel balLabel;
	/** A Label for the interest or fee dependent on the account type. **/
	private JLabel interestOrFeeLabel;
	/** A Label for the minimum balance. **/
	private JLabel minBalLabel;
	
	/** The withdraw button, that opens the withdraw menu. **/
	private JButton withdrawButton;
	/** The deposit button, that opens the deposit menu. **/
	private JButton depositButton;
	
	/** Decimal formatting for values that have money. **/
	private DecimalFormat dF = new DecimalFormat("$###,###.##");
	/** The constraints for the grid bag layout **/
	private GridBagConstraints constraint;
	
	/**
	 * A parameterless constructor for the instantiation of all the class members as well as action listeners for buttons.
	 */
	public AccountInfoJPanel() {
		
		// Set the JPanels properties.
		setVisible(true);
		setLayout(new GridBagLayout());
		// Using a compound border, the effect of two separate borders are merged together into one.
		setBorder(new CompoundBorder(
					BorderFactory.createEmptyBorder(10, 10, 10, 10),
				  	new SoftBevelBorder(SoftBevelBorder.LOWERED, new Color(100,100,100), new Color(75,75,75))
				  	));
		
		// Use a larger font, as the default font is too small.
		Font font = new Font("Dialog", Font.PLAIN, 16);
		
		// Instantiate the constraints for the layout, as well as the Labels anchor point.
		constraint = new GridBagConstraints();
		constraint.anchor = GridBagConstraints.LINE_END;
		
		// Add the account number label with the new font.
		accountNumberLabel = new JLabel("Account Number: ");
		accountNumberLabel.setFont(font);
		
		constraint.gridy++;
		add(accountNumberLabel, constraint);
		
		// Add the first name label with the new font.
		fNameLabel = new JLabel("First Name: ");
		fNameLabel.setFont(font);
		
		constraint.gridy++;
		add(fNameLabel, constraint);
		
		// Add the last name label with the new font.
		lNameLabel = new JLabel("Last Name: ");
		lNameLabel.setFont(font);
		
		constraint.gridy++;
		add(lNameLabel, constraint);
		
		// Add the phone number label with the new font.
		phoneNumLabel = new JLabel("Phone Number: ");
		phoneNumLabel.setFont(font);
		
		constraint.gridy++;
		add(phoneNumLabel, constraint);
		
		// Add the email label with the new font.
		emailLabel = new JLabel("Email Address: ");
		emailLabel.setFont(font);
		
		constraint.gridy++;
		add(emailLabel, constraint);
		
		// Add the balance label with the new font.
		balLabel = new JLabel("Balance: ");
		balLabel.setFont(font);
		
		constraint.gridy++;
		add(balLabel, constraint);
		
		// Add the interest or fee label with the new font.
		interestOrFeeLabel = new JLabel("");
		interestOrFeeLabel.setFont(font);
		
		constraint.gridy++;
		add(interestOrFeeLabel, constraint);
		
		// Add the minimum balance label with the new font, sets the visibility to false.
		minBalLabel = new JLabel("Minimum Balance: ");
		minBalLabel.setFont(font);
		minBalLabel.setVisible(false);
		
		constraint.gridy++;
		add(minBalLabel, constraint);
		
		// Spacing is given for esthetics, using insets, adds the withdraw button with the new font.
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setFont(font);
		
		constraint.insets = new Insets(20,10,20,10);
		constraint.gridy++;
		add(withdrawButton, constraint);
		
		// Reset the values for the constraints, and sets the x to shift 1 cell over. Also sets the anchor point to the start of the line.
		constraint.anchor = GridBagConstraints.LINE_START;
		constraint.insets = new Insets(0,0,0,0);
		constraint.gridx = 1;
		constraint.gridy = 0;
		
		// Add the account number place holder label for future use with the new font.
		accountNumberPlaceholderLabel = new JLabel();
		accountNumberPlaceholderLabel.setFont(font);
		
		add(accountNumberPlaceholderLabel, constraint);
		
		// Add the first name place holder label for future use with the new font.
		fNamePlaceholderLabel = new JLabel();
		fNamePlaceholderLabel.setFont(font);
		
		constraint.gridy++;
		add(fNamePlaceholderLabel, constraint);
		
		// Add the last name place holder label for future use with the new font.
		lNamePlaceholderLabel = new JLabel();
		lNamePlaceholderLabel.setFont(font);
		
		constraint.gridy++;
		add(lNamePlaceholderLabel, constraint);
		
		// Add the phone number place holder label for future use with the new font.
		phonePlaceholderLabel = new JLabel();
		phonePlaceholderLabel.setFont(font);
		
		constraint.gridy++;
		add(phonePlaceholderLabel, constraint);
		
		// Add the email place holder label for future use with the new font.
		emailPlaceholderLabel = new JLabel();
		emailPlaceholderLabel.setFont(font);
		
		constraint.gridy++;
		add(emailPlaceholderLabel, constraint);
		
		// Add the balance place holder label for future use with the new font.
		balPlaceholderLabel = new JLabel();
		balPlaceholderLabel.setFont(font);
		
		constraint.gridy++;
		add(balPlaceholderLabel, constraint);
		
		// Add the interest place holder label for future use with the new font.
		interestOrFeePlaceholderLabel = new JLabel();
		interestOrFeePlaceholderLabel.setFont(font);
		
		constraint.gridy++;
		add(interestOrFeePlaceholderLabel, constraint);
		
		// Add the minimum balance place holder label for future use with the new font, and sets visibility to false.
		minBalPlaceholderLabel = new JLabel();
		minBalPlaceholderLabel.setFont(font);
		minBalPlaceholderLabel.setVisible(false);
		
		constraint.gridy++;
		add(minBalPlaceholderLabel, constraint);
		
		// Spacing is given for esthetics, using insets, adds the withdraw button with the new font.
		depositButton = new JButton("Deposit");
		depositButton.setFont(font);
		
		constraint.insets = new Insets(20,10,20,10);
		constraint.gridy++;
		add(depositButton, constraint);
		
		// The action listeners for each button, upon an event, it calls each designated function.
		depositButton.addActionListener(e -> deposit());
		withdrawButton.addActionListener(e -> withdraw());
		
		
	}
	/**
	 * This method adds all the account info to the specified place holder labels.
	 * @param accInfo This parameter is supposed to be given all account information for display.
	 */
	public void accInfo(String accInfo) {
		
		// set the minimum balance placeholder, and labels visibility to false incase it's a Chequing account.
		minBalPlaceholderLabel.setVisible(false);
		minBalLabel.setVisible(false);
		
		if (accInfo.startsWith("S")) {
			
			// Set all the values for the current account that is selected to it's
			// designated place holder. As well we use the Strings split function to convert
			// the data into an array, as well as use decimal format for number formatting.
			
			
			String[] info = accInfo.split(" ");
			accountNumberPlaceholderLabel.setText(info[1]);
			fNamePlaceholderLabel.setText(info[2]);
			lNamePlaceholderLabel.setText(info[3]);
			
			/* 
			 * Credit goes to https://howtodoinjava.com/java/string/format-phone-number/
			 * Edited to exclude the brackets around the area code.
			 * This line of code uses regex with three groups.
			 * group 1 and 2 uses \d{amount} with an extra \ because \ is an escape character in java.
			 * group 3 uses \d+ which mean any amount of numbers within that group.
			 * last but not least the seconds string defines the format between each group.
			 */
			
			String phoneNumber = info[4].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
			
			phonePlaceholderLabel.setText(phoneNumber);
			emailPlaceholderLabel.setText(info[5]);
			balPlaceholderLabel.setText(dF.format(Double.parseDouble(info[6])));
			interestOrFeePlaceholderLabel.setText(info[7]);
			minBalPlaceholderLabel.setText(dF.format(Double.parseDouble(info[8])));
			
			interestOrFeeLabel.setText("Interest: ");
			minBalPlaceholderLabel.setVisible(true);
			minBalLabel.setVisible(true);
			
		} else {
			
			// Set all the values for the current account that is selected to it's
			// designated place holder. As well we use the Strings split function to convert
			// the data into an array, as well as use decimal format for number formatting.
			
			String[] info = accInfo.split(" ");
			accountNumberPlaceholderLabel.setText(info[1]);
			fNamePlaceholderLabel.setText(info[2]);
			lNamePlaceholderLabel.setText(info[3]);
			
			/* 
			 * Credit goes to https://howtodoinjava.com/java/string/format-phone-number/
			 * Edited to exclude the brackets around the area code.
			 * This line of code uses regex with three groups.
			 * group 1 and 2 uses \d{amount} with an extra \ because \ is an escape character in java.
			 * group 3 uses \d+ which mean any amount of numbers within that group.
			 * last but not least the seconds string defines the format between each group.
			 */
			
			String phoneNumber = info[4].replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
			
			phonePlaceholderLabel.setText(phoneNumber);
			emailPlaceholderLabel.setText(info[5]);
			balPlaceholderLabel.setText(dF.format(Double.parseDouble(info[6]))); // Decimal Format
			interestOrFeePlaceholderLabel.setText(dF.format(Double.parseDouble(info[7])));
			
			interestOrFeeLabel.setText("Fee: ");
			
			
		}
		
	}
	/**
	 * Deposit method that creates a new window and accepts input from the user to deposit into
	 * the selected account.
	 */
	public void deposit() {
		
		// Create the deposit frame with a grid bag layout and set the size, visibility, and resizability.
		JFrame depositFrame = new JFrame("Deposit");
		depositFrame.setVisible(true);
		depositFrame.setSize(300, 200);
		depositFrame.setResizable(false);
		depositFrame.setLayout(new GridBagLayout());
		
		
		// Instantiate the grid bag constraints for location use.
		constraint = new GridBagConstraints();
		
		// Instantiate the confirm button and set its location, and text then add it to the frame.
		JLabel amount = new JLabel("Amount ");
		constraint.gridx = 0;
		constraint.gridy = 0;
		depositFrame.add(amount, constraint);
		
		// Instantiate the confirm button and set its location, and add it to the frame.
		JTextField amountInput = new JTextField(10);
		constraint.gridx++;
		constraint.gridy = 0;
		depositFrame.add(amountInput, constraint);
		
		// Instantiate the confirm button and set its location, text, insets for vertical spacing, then add it to the frame.
		JButton confirm = new JButton("Confirm");
		
		// Adds a listener for the confirm button.
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					// Check if the value is a negative
					if (Double.parseDouble(amountInput.getText()) < 0) {
						InvalidInputDialog.errorMessage("Value entered is a negative value");
						amountInput.selectAll();
						amountInput.requestFocus();
						return;
					}
					// Calls the Mainframe balanceUpdate method to and returns true or false whether the withdraw was successful or not.
					boolean success = MainFrame.balanceUpdate(Double.parseDouble(amountInput.getText()), Long.parseLong(accountNumberPlaceholderLabel.getText()));
					
					if (!success) {
						// If the deposit was not a success select all of the input, and set the users focus.
						amountInput.selectAll();
						amountInput.requestFocus();
						return;
					} else {
						// Remove the dollar sign from the balance in the placeholder.
						String removeSign = balPlaceholderLabel.getText().replaceAll("\\$", "");
						
						// Remove all the commas from the balance in the placeholder. Then add the deposit value to the balance, and set the text.
						balPlaceholderLabel.setText("" + dF.format(Double.parseDouble(removeSign.replaceAll(",", "")) + Double.parseDouble(amountInput.getText())));
						
						// Hide the deposit frame.
						depositFrame.setVisible(false);
					}
					
				} catch (Exception exception) {
					
					// If the deposit causes an error select all of the input, and set the users focus. Display an error.
					amountInput.selectAll();
					amountInput.requestFocus();
					InvalidInputDialog.errorMessage("Enter a valid amount");
				}
				
			}
			
		});
		
	}
	/**
	 * Withdraw method that creates a new window and accepts input from the user to withdraw into
	 * the selected account.
	 */
	public void withdraw() {
		
		// Create the withdraw frame with a grid bag layout and set the size, visibility, and resizability.
		JFrame withdrawFrame = new JFrame("Withdraw");
		withdrawFrame.setVisible(true);
		withdrawFrame.setSize(300, 200);
		withdrawFrame.setResizable(false);
		withdrawFrame.setLayout(new GridBagLayout());
		
		// Instantiate the grid bag constraints for location use.
		constraint = new GridBagConstraints();
		
		// Instantiate the confirm button and set its location, and text then add it to the frame.
		JLabel amount = new JLabel("Amount ");
		constraint.gridx = 0;
		constraint.gridy = 0;
		withdrawFrame.add(amount, constraint);
		
		// Instantiate the confirm button and set its location, and add it to the frame.
		JTextField amountInput = new JTextField(10);
		constraint.gridx++;
		constraint.gridy = 0;
		withdrawFrame.add(amountInput, constraint);
		
		// Instantiate the confirm button and set its location, text, insets for vertical spacing, then add it to the frame.
		JButton confirm = new JButton("Confirm");
		constraint.gridy++;
		constraint.fill = GridBagConstraints.HORIZONTAL;
		constraint.insets = new Insets(5,0,5,0);
		withdrawFrame.add(confirm, constraint);
		
		// Adds a listener for the confirm button.
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					// Check if the value is a negative
					if (Double.parseDouble(amountInput.getText()) < 0) {
						InvalidInputDialog.errorMessage("Value entered is a negative value");
						amountInput.selectAll();
						amountInput.requestFocus();
						return;
					}
					
					// Calls the Mainframe balanceUpdate method to and returns true or false whether the withdraw was successful or not.
					boolean success = MainFrame.balanceUpdate(-Double.parseDouble(amountInput.getText()), Long.parseLong(accountNumberPlaceholderLabel.getText()));
					
					if (!success) {
						
						// If the withdraw was not a success select all of the input, and set the users focus.
						amountInput.selectAll();
						amountInput.requestFocus();
						return;
						
					} else {
						
						// Remove the dollar sign from the balance in the placeholder.
						String removeSign = balPlaceholderLabel.getText().replaceAll("\\$", "");
						
						// Remove all the commas from the balance in the placeholder. Then subtract the withdraw value from the balance, and set the text.
						balPlaceholderLabel.setText("" + dF.format(Double.parseDouble(removeSign.replaceAll(",", "")) - Double.parseDouble(amountInput.getText())));
						
						// Hide the withdraw frame.
						withdrawFrame.setVisible(false);
					}
				} catch (Exception exception) {
					
					// If the deposit causes an error select all of the input, and set the users focus. Display an error.
					amountInput.selectAll();
					amountInput.requestFocus();
					InvalidInputDialog.errorMessage("Enter a valid amount");
				}	
			}		
		});
	}
	
	/**
	 * This method changes the balance labels text to the new balance.
	 */
	public void updateBalance() {
		
		// Iterate through the bank accounts.
		for (BankAccount i: Bank.bankAccounts) {
			
			// check if the account number is equal to the currently displayed account's number.
			if (i.accountNumber == Long.parseLong(accountNumberPlaceholderLabel.getText())) {
				
				// set the text for the balance to the new updated balance with decimal format.
				balPlaceholderLabel.setText(dF.format(i.balance));
			}
		}
	}
}