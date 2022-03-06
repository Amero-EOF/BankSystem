/**
* File Name: Bank.java
* Author: Amero Defranco
* Assignment: Lab 9
* Date: April 18, 2019
* Purpose: This class holds all the bank accounts, and methods to update and add them.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * This class holds all the bank accounts, and methods to update and add them.
 * @author Amero Defranco
 * @version 3.0
 * @since 1.8.0_201
 */

public class Bank {
	
	/** This ArrayList holds all of the bank accounts created by the bank **/
	protected static ArrayList<BankAccount> bankAccounts;
	/** The formatter deals with all output to files **/
	private Formatter output;
	/** The scanner deals with all the input from files **/
	private Scanner input;
	/**
	 * default constructor for the bank account that sets the bankAccounts size to 1000.
	 */
	public Bank() {
		bankAccounts = new ArrayList<BankAccount>(1000);
	}
	/**
	 * default constructor for the bank account that sets the bankAccounts size to a specified value.
	 * @param amount, the maximum amount of bank accounts.
	 */
	public Bank(int amount) {
		bankAccounts = new ArrayList<BankAccount>(amount);
	}
	/**
	 * Adds the new savings account to the UI list and the bankAccounts array.
	 * @param accNum The account number.
	 * @param fName Clients first name.
	 * @param lName Clients last name.
	 * @param phoneNum Clients phone number.
	 * @param email Clients email.
	 * @param openBal Opening balance.
	 * @param interest Interest on the account.
	 * @param minBal Minimum balance of the account.
	 * @return This method returns a boolean to check whether adding the account was successful for not.
	 */
	public static boolean addAccount(long accNum, String fName, String lName, BigInteger phoneNum, String email, double openBal, double interest, double minBal) {
		
		// Checks if the account number is a duplicate *Separate from the check in the SavingsAccount Class*.
		for (BankAccount i:bankAccounts) {
			if (accNum == i.accountNumber) {
				InvalidInputDialog.errorMessage("Account number is a duplicate");
				return false;
			}
		}
		
		try {
			// Attempt to make a new account, if an error occurs, return to the account creation frame with the proper error message.
			SavingsAccount newSavingsAccount = new SavingsAccount(accNum, fName, lName, phoneNum , email, openBal, interest, minBal);
			
			
			// Add the account to the array list of bank accounts.
			bankAccounts.add(newSavingsAccount);
			
			// Add the account to the list of accounts on the application.
			MainFrame.addNewAccountFrame(newSavingsAccount);
			
			return true;
			
		} catch (Exception e) {
			return false;
		}
		
		
		
	}
	/**
	 * Adds the new savings account to the UI list and the bankAccounts array.
	 * @param accNum The account number.
	 * @param fName Clients first name.
	 * @param lName Clients last name.
	 * @param phoneNum Clients phone number.
	 * @param email Clients email.
	 * @param openBal Opening balance.
	 * @param accFee Account Fee.
	 * @return This method returns a boolean to check whether adding the account was successful for not.
	 */
	public static boolean addAccount(long accNum, String fName, String lName, BigInteger phoneNum, String email, double openBal, double accFee) {
		
		// Checks if the account number is a duplicate *Separate from the check in the SavingsAccount Class*.
		for (BankAccount i:bankAccounts) {
			if (accNum == i.accountNumber) {
				InvalidInputDialog.errorMessage("Account number is a duplicate");
				return false;
			}
		}
		
		try {
			// Attempt to make a new account, if an error occurs, return to the account creation frame with the proper error message.
			ChequingAccount newChequingAccount = new ChequingAccount(accNum, fName, lName, phoneNum, email, openBal, accFee);
			
			// Add the account to the array list of bank accounts.
			bankAccounts.add(newChequingAccount);
			
			// Add the account to the list of accounts on the application.
			MainFrame.addNewAccountFrame(newChequingAccount);
			
			return true;
			
		} catch (Exception e) {
			
			return false;
		}
		
	}
	/**
	 * Checks if a proper value is given to withdraw, and withdraws the specified amount if successful,
	 * to the selected bank account.
	 * @param amount The amount to withdraw.
	 * @param accountNumber The account number to withdraw from.
	 * @return Returns a boolean, true if withdrawal was a success, false if it was not.
	 */
	public boolean withdraw(double amount, long accountNumber) {
		
		// Iterate through all the accounts.
		for (BankAccount i: bankAccounts) {
			
			// Checks if it has the correct account.
			if (i.accountNumber == accountNumber) {
				
				if (i.minBal > i.balance - amount) { // Checks if the amount after withdrawal is less than minimum balance.
					
					InvalidInputDialog.errorMessage("Amount after withdrawal is less than minimum balance");
					return false;
					
				} else if (i.balance > amount) { // Subtract the amount.
					
					i.balance -= amount;
					return true;
					
				} else { // Checks if the amount is greater than the balance.
					
					InvalidInputDialog.errorMessage("Amount is greater than balance");
					return false;
				}
			}
		}
		// Something went wrong, return false as withdrawal was not successful.
		return false;
	}
	/**
	 * Deposits the amount given, to the selected bank account.
	 * @param amount The amount to deposit.
	 * @param accountNumber The account number to deposit to.
	 * @return Returns a boolean, true if deposit was a success, false if it was not.
	 */
	public boolean deposit(double amount, long accountNumber) {
		
		// Iterate through all the accounts.
		for (BankAccount i: bankAccounts) {
			
			// Checks if it has the correct account.
			if (i.accountNumber == accountNumber) {
				i.balance += amount; // Add the amount being deposited to the amount
				return true;
				
			}
		}
		// Something went wrong, return false as deposit was not successful.
		return false;
	}
	
	/**
	 * This method applies the monthly update for all of the bank accounts.
	 */
	
	public void monthlyUpdate() {
		
		// Runs the monthly account method for all the accounts.
		for (BankAccount i:bankAccounts) {
			i.monthlyAccountUpdate();
		}
	}
	
	/**
	 * This method opens input for the specified file, and returns an error if it isn't found.
	 * @param fileName The file name to grab input from.
	 */
	
	public void openInputFile(String fileName) {
		
		try {
			// Grabs the imported file's name, and attempts to scan it.
			input = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			// If the file is not found display an error
			InvalidInputDialog.errorMessage("Error could not find the file with path" + fileName);
		}
	}
	
	/**
	 * This method reads records from the input file and creates accounts for the respective records.
	 * based on account type
	 */
	
	public void readRecords() {
		
		// Reads through each word separated by whitespace in the file.
		while(input.hasNext()) {
			try {
				// Checks whether or not the account is a chequing account or a savings account
				switch(input.next().toUpperCase()) {
					
					case "C":
						// Add the account to the array, as well as instantiate it.
						bankAccounts.add(bankAccounts.size(), new ChequingAccount(Long.parseLong(input.next()), input.next(), input.next(), new BigInteger(input.next()), input.next(), Double.parseDouble(input.next()), Double.parseDouble(input.next())));
						break;
					case "S":
						// Add the account to the array, as well as instantiate it.
						bankAccounts.add(bankAccounts.size(), new SavingsAccount(Long.parseLong(input.next()), input.next(), input.next(), new BigInteger(input.next()) , input.next(), Double.parseDouble(input.next()), Double.parseDouble(input.next()), Double.parseDouble(input.next())));
						break;
					default:
						throw new Exception();
				}
			} catch (Exception e) {
				// Handles any corrupt, incorrect format, or duplicate files.
				InvalidInputDialog.errorMessage("The file you selected is corrupt or is not in the correct format or is a duplicate. \n Adding any valid accounts if any.");
				return;
			}
		}
		return;
	}
	
	/**
	 * This closes the input for the selected file.
	 */
	
	public void closeInputFile() {
		// Closes the file input stream.
		input.close();
	}
	
	/**
	 * This method opens output for the specified file, and enters new entries.
	 * @param exportFile This is the file to export to.
	 */
	
	public void openOutputFile(File exportFile) {
		
		try {
			// Get the formatter to output into the file.
			output = new Formatter(exportFile.getAbsolutePath());
			
			// Counter for adding until reaches the size of the bank accounts array.
			int counter = 1;
			
			// Iterate through all the accounts.
			for (BankAccount i:bankAccounts) {
				switch(i.accountType) {
					case "C":
						
						// If the file is the last index, do not use \n.
						if (counter == bankAccounts.size()) {
							output.format("C " + i.accountNumber + " " + i.accHolder.getFirstName() + " " + i.accHolder.getLastName() + " " + i.accHolder.getPhoneNumber() + " " + i.accHolder.getEmailAddress() + " " + i.balance + " " + i.interestOrFee);
						} else {
							output.format("C " + i.accountNumber + " " + i.accHolder.getFirstName() + " " + i.accHolder.getLastName() + " " + i.accHolder.getPhoneNumber() + " " + i.accHolder.getEmailAddress() + " " + i.balance + " " + i.interestOrFee + "\n");
						}
						break;
					case "S":
						// If the file is the last index, do not use \n.
						if (counter == bankAccounts.size()) {
							output.format("S " + i.accountNumber + " " + i.accHolder.getFirstName() + " " + i.accHolder.getLastName() + " " + i.accHolder.getPhoneNumber() + " " + i.accHolder.getEmailAddress() + " " + i.balance + " " + i.interestOrFee + " " + i.minBal);
						} else {
							output.format("S " + i.accountNumber + " " + i.accHolder.getFirstName() + " " + i.accHolder.getLastName() + " " + i.accHolder.getPhoneNumber() + " " + i.accHolder.getEmailAddress() + " " + i.balance + " " + i.interestOrFee + " " + i.minBal + "\n");
						}
						break;
				}
				counter++;
			}
		} catch (FileNotFoundException e) {
			// Could not find the specified file, displays an error.
			InvalidInputDialog.errorMessage("Error could not find the file with path" + exportFile.getAbsolutePath());
		}
		
	}
	
	/**
	 * This method closes output for the specified file.
	 */
	
	public void closeOutputFile() {
		// Closes the file output stream.
		output.close();
	}
}