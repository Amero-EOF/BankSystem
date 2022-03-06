/**
* File Name: BankAccount.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This class creates the general bank account which is extended by the chequing and savings account classes.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

/**
 * This class creates the general bank account which is extended by the chequing and savings account classes.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 */
public abstract class BankAccount {
	/** Holds an account number that is positive and can have a maximum of 8 digits **/
	protected long accountNumber;
	/** Holds the account owners information **/
	protected Person accHolder;
	/** Holds the minimum balance **/
	protected double minBal;
	/** Holds the interest or fee for chequing and savings account **/
	protected double interestOrFee;
	/** Holds the balance of the account **/
	protected double balance;
	/** Holds account type of the account being C for chequing or S for savings **/
	protected String accountType;
	
	/**
	 * @return String, returns the account information
	 */
	
	public String toString() {
		// returns all the account information values, as well as using decimal format.
		return 	accountType + " " + accountNumber + " " + accHolder.getFirstName() + " " +  accHolder.getLastName() + " "
				+ accHolder.getPhoneNumber() + " " + accHolder.getEmailAddress() + " " + balance;
		
	}

	/**
	 * 
	 * Sets the balance to the new updated balance
	 * @param newBal, takes the updated balance
	 */
	public void updateBalance(double newBal) {
		// updates balance with new balance
		balance = newBal;
	}
	/**
	 * This is an abstract class that is used in ChequingAccount and SavingsAccount to update the balance with either fees or interest.
	 */
	public abstract void monthlyAccountUpdate();
		
}