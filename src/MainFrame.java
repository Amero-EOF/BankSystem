/**
* File Name: MainFrame.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This class runs all of the elements in the bank applications.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.awt.BorderLayout;

import java.io.File;

import javax.swing.JFrame;

/**
 * This class runs all of the elements in the bank application.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 * 
 */

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	/** This is Bank for account creation, and account storage. **/
	private static Bank bank;
	/** Menu class that holds the import UI's and account creation menu buttons. **/
	private Menu menu;
	/** Account list panel that holds a list of all the bank accounts in UI form. **/
	private static AccountsListJPanel accountsListPanel;
	/** Account info panel holds all the selected accounts information for display. **/
	private static AccountInfoJPanel accountsInfoPanel;
	
	/**
	 * Parameterless constructor that instantiates all of the panels, and displays them. It also instantiates the Bank.
	 */
	public MainFrame() {
		
		super("Bank");
		
		// Creates the new layout for the Frame.
		BorderLayout bL = new BorderLayout();
		bL.setVgap(5);
		
		// Sets all the properties for the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800,800);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(bL);
		
		// Instantiates the menu, and bank.
		bank = new Bank();
		menu = new Menu();
		
		// Instantiates the accountsListPanel and the accountsInfoPanel, sets accountsInfoPanel visibility to false
		// for later use.
		accountsListPanel = new AccountsListJPanel();
		accountsInfoPanel = new AccountInfoJPanel();
		accountsInfoPanel.setVisible(false);
		
		// Adds the elements to the Frame
		setJMenuBar(menu);
		add(accountsListPanel, BorderLayout.WEST);
		add(accountsInfoPanel, BorderLayout.CENTER);	
		
		setVisible(true);
		
	}
	
	/**
	 * This method is use to pass the selected account to the account info panel.
	 * @param accNumber This value is used to find the specified account.
	 */
	public static void accountPassThrough(String accNumber) {
		
		for (BankAccount i :Bank.bankAccounts) {
			// Looks for the selected account with the account number.
			if (accNumber.matches( String.valueOf(i.accountNumber) ) ) {
				
				accountsInfoPanel.accInfo(i.toString());
				accountsInfoPanel.setVisible(true);
			}
		}
		
	}
	
	/**
	 * This method calls for reading of the records, and new accounts to the accounts list panel.
	 * @param fileName The name of the file being imported.
	 */
	public static void recordChecks(String fileName) {
		
		bank.openInputFile(fileName);
		bank.readRecords();
		bank.closeInputFile();
		
		accountsListPanel.addAccounts();
		
	}
	
	/**
	 * This method adds a single account after creation to the accounts list panel.
	 * @param bA The bank account that needs to be added.
	 */
	public static void addNewAccountFrame(BankAccount bA) {
		
		accountsListPanel.addAccounts(bA);
	}
	
	/**
	 * This method exports or saves the records to a file.
	 * @param exportFile The file that's being exported.
	 */
	public static void saveRecords(File exportFile) {
		
		bank.openOutputFile(exportFile);
		bank.closeOutputFile();
	}
	/**
	 * This methods purpose is to test the legitimacy of an email using regex.
	 * @param email The email address that needs to be tested.
	 * @return returns a boolean true if it's real, false if it is fake.
	 */
	public static boolean emailCheck(String email) {
		
		if (email.matches( "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
				"[a-zA-Z0-9_+&*-]+)*@" + 
				"(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
				"A-Z]{2,7}$")) {
				
			/*
			 * The block of code above checks whether the given email looks 
			 * to be a legitimate email it allows special characters as well
			 * as numbers and letters seperated by an @ symbol, it also correctly
			 * does not allow certain special characters in the domain as real emails
			 * work. 
			 * Credit: https://www.journaldev.com/638/java-email-validation-regex
			 */
			return true;
		}
		return false;
	}
	/**
	 * This method is used for withdrawing or depositing.
	 * @param amount The amount is the value the user wants to withdraw or deposit.
	 * @param accountNumber The account number the user wants to withdraw or deposit from.
	 * @return This returns a boolean that determines whether the transaction succeeded or not.
	 */
	public static boolean balanceUpdate(double amount, long accountNumber) {
		if (amount < 0) {
			// Withdraws from the account if successful.
			boolean success = bank.withdraw(-amount, accountNumber);
			return success;
		} else if (amount == 0) {
			InvalidInputDialog.errorMessage("Value entered was 0");
			return false;
		} else {
			// Deposits to the account if successful.
			boolean success = bank.deposit(amount, accountNumber);
			return success;
		}
		
		
	}
	/**
	 * Calls the monthly update method from the Bank class, and then updates the account displayed
	 * on the account info panel.
	 */
	public static void monthlyUpdate() {
		bank.monthlyUpdate();
		accountsInfoPanel.updateBalance();
	}
}
