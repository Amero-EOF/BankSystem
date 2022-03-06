/**
* File Name: Person.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This class holds all the information for the Person.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/


import java.math.BigInteger;

/**
 * This class holds all the information for the Person.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 */

public class Person {
	/** This holds the first name of the account holder**/
	private String firstName;
	/** This holds the last name of the account holder**/
	private String lastName;
	/** This holds the email of the account holder**/
	private String emailAddress;
	/** This holds the phone number of the account holder**/
	private BigInteger phoneNumber;

	/**
	 * Parameterized constructor for creating a new client/person.
	 * @param lName Last name.
	 * @param fName First name.
	 * @param phoneNum Phone number.
	 * @param email Email Address.
	 */
	public Person(String lName, String fName, BigInteger phoneNum, String email) {
		lastName = lName;
		firstName = fName;
		emailAddress = email;
		phoneNumber = new BigInteger(phoneNum.toByteArray());
	}
	/**
	 * This method is a getter for the persons first name.
	 * @return String, the persons first name.
	 */
	// first name getter
	public String getFirstName() {
		return firstName;
	}
	/**
	 * This method is a getter for the persons last name.
	 * @return String, the persons last name.
	 */
	// last name getter
	public String getLastName() {
		return lastName;
	}
	/**
	 * This method is a getter for the persons email address.
	 * @return String, the persons email address.
	 */
	// email getter
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * This method is a getter for the persons phone number.
	 * @return String, the persons phone number.
	 */
	// email getter
	public String getPhoneNumber() {
		 	
		return phoneNumber.toString();
	}
}