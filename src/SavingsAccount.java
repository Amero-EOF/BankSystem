/**
* File Name: Person.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This class creates the savings account which controls the interest and minimum balance of the bank account. It also handles bank account creation.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsFrame.java, TextFileFilter.java
*/

import java.math.BigInteger;

/**
 * This class creates the savings account which controls the interest and minimum balance of the bank account. It also handles bank account creation.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 */

public class SavingsAccount extends BankAccount {
	
	/** This holds the interest rate for the savings account **/
	private double interestRate;
	/** This holds the minimum balance for the savings account **/
	private double minimumBalance;
	
	/**
	 * This is an parameterized constructor for creating an account via records
	 * 
	 * @param accNum Account number.
	 * @param fName First name.
	 * @param lName Last name.
	 * @param phoneNum Phone number.
	 * @param email Email address.
	 * @param openBal Opening balance.
	 * @param interest Interest.
	 * @param minBal Minimum Balance.
	 * @throws Exception This is used to stop the account creation process, and have the user fix the problem.
	 */
	public SavingsAccount(long accNum, String fName, String lName, BigInteger phoneNum , String email, double openBal, double interest, double minBal) throws Exception {
		
		// Check if the bank account is a duplicate *For importing a file*.
		for (BankAccount i:Bank.bankAccounts) {
			if (i.accountNumber == accNum) {

				throw new Exception();
			}
		}
		
		// Check if the account number is a negative.
		if (accNum < 0) {
			InvalidInputDialog.errorMessage("The given Account number is a negative");
			throw new Exception();
		}
		
		// Check if the account number is greater than 8 digits long.
		if (accNum > 99999999) {
			InvalidInputDialog.errorMessage("The given Account number is too large, 8 digits only");
			throw new Exception();
		}
		
		// Check if the opening balance is less than the minimum balance.
		if (minBal > openBal) {
			InvalidInputDialog.errorMessage("Opening Balance is less than the minimum");
			throw new Exception();
		}
		
		// Check if the minimum balance is a negative.
		if (minBal < 0) {
			InvalidInputDialog.errorMessage("Minimum Balance is not a positive number");
			throw new Exception();
		}
		
		// Checks if the interest is between 0 and 1.
		if (interest <= 0 || interest >= 1) {
			InvalidInputDialog.errorMessage("Interest is not a positive number or \n is greater than 1");
			throw new Exception();
		}
		
		// Add all the information to the bank account.
		super.accountNumber = accNum;
		super.accountType = "S";
		super.balance = openBal;
		super.accHolder = new Person(fName, lName ,phoneNum ,email );

		interestRate = interest;
		super.interestOrFee = interest;
		minimumBalance = minBal;
		super.minBal = minimumBalance;
	}
	
	/**
	 * @return String, returns the full account info of the savings account.
	 */
	public String toString() {
		// Gets and returns the account information for printing.
		String accountInfo = super.toString();

		return accountInfo + " " + interestRate + " " + minimumBalance;
	}
	
	
	/**
	 * Applies the monthly interest rate for the savings account.
	 */
	public void monthlyAccountUpdate() {
		// updates the monthly balance and calls the BankAccount's updateBalance method. It also checks if the balance is greater than the minimum balance
		if (super.balance > minimumBalance) {
			super.updateBalance(super.balance * (1 + interestRate));
		} else {
			InvalidInputDialog.errorMessage(super.accountNumber + " has insufficient funds for interest");
		}
	}
}