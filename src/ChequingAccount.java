/**
* File Name: ChequingAccount.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This class creates the chequing account which controls the fees of the bank account. It also handles bank account creation.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.math.BigInteger;

/**
 * This class creates the chequing account which controls the fees of the bank account. It also handles bank account creation.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 */

public class ChequingAccount extends BankAccount {
	
	/** This holds the fee for the chequing account **/
	private double fee;
	
	/**
	 * This is an parameterized constructor for creating an account via records
	 * 
	 * @param accNum Account number.
	 * @param fName First name.
	 * @param lName Last name.
	 * @param phoneNum Phone number.
	 * @param email Email address.
	 * @param openBal Opening balance.
	 * @param accFee Account fee.
	 * @throws Exception This is used to stop the account creation process, and have the user fix the problem.
	 */
	public ChequingAccount(long accNum, String fName, String lName, BigInteger phoneNum, String email, double openBal, double accFee) throws Exception {
		
		// Check if the bank account is a duplicate *For importing a file*.
		for (BankAccount i:Bank.bankAccounts) {
			if (i.accountNumber == accNum) {

				throw new Exception();
			}
		}
		// Check if the account number is a negative.
		if (accNum < 0) {
			InvalidInputDialog.errorMessage("The given Account number is a negative value");
			throw new Exception();
		}
		// Check if the account number is greater than 8 digits long.
		if (accNum > 99999999) {
			InvalidInputDialog.errorMessage("The given Account number is too large, 8 digits only");
			throw new Exception();
		}
		super.accountNumber = accNum;
		super.accountType = "C";
		
		// Check if the opening balance is a positive number.
		if (openBal < 0) {
			InvalidInputDialog.errorMessage("The balance is a negative value");
			throw new Exception();
		}
		super.balance = openBal;
		
		// Create the account holder.
		super.accHolder = new Person(fName,lName, phoneNum,email);
		
		// Check if the fee is positive or not.
		if (fee < 0) {
			InvalidInputDialog.errorMessage("The fee is not a positive value");
			throw new Exception();
		}
		
		fee = accFee;
		super.interestOrFee = fee;
		
	}
	
	/**
	 * @return String, returns the full account info of the chequing account.
	 */
	public String toString() {
		
		return super.toString() + " " + fee;
	}
	
	/**
	 * Applies the monthly fee for the chequing account.
	 */
	public void monthlyAccountUpdate() {
		// updates the monthly balance and calls the BankAccount's updateBalance method.
		if (fee > super.balance) {
			InvalidInputDialog.errorMessage(super.accountNumber + " has insufficient funds for the fee");
		} else {

			super.updateBalance(super.balance - fee);
		}
		
	}
}