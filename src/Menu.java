/**
* File Name: Menu.java
* Author: Amero Defranco
* Assignment: Lab 9
* Date: April 18, 2019
* Purpose: This class runs all of the menus including import and export.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.awt.BorderLayout;
import java.awt.Font;

import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This class runs all of the menus including import and export.
 * @author Amero Defranco
 * @version 3.0
 * @since 1.8.0_201
 */
@SuppressWarnings("serial")
public class Menu extends JMenuBar {
	/** The file menu **/
	private JMenu file;
	/** The new account menu within the file menu **/
	private JMenu newAccount;
	
	/** This button updates all the accounts **/
	private JButton updateAccounts;
	
	/** Export file menu item **/
	private JMenuItem exportFile;
	/** Import file menu item **/
	private JMenuItem importFile;
	/** Chequing Account menu item **/
	private JMenuItem chequingAccount;
	/** Savings Account menu item**/
	private JMenuItem savingsAccount;
	
	@SuppressWarnings("unused")
	/** Savings frame for creating a new account**/
	private SavingsFrame saveFrame;
	@SuppressWarnings("unused")
	/** Chequing frame for creating a new account**/
	private ChequingFrame chequeFrame;
	
	/** New font for components **/
	private Font font;
	
	/**
	 * Parameterless constructor, that adds all the elements to the menu and adds their respective action listener.
	 */
	public Menu() {
		
		setLayout(new BorderLayout());
		
		// Use a larger font, as the default font is too small.
		font = new Font("Dialog", Font.PLAIN,16);
		
		updateAccounts = new JButton("Monthly Update");
		
		// Add the account number label with the new font.
		file = new JMenu("File");
		file.setFont(font);
		
		// Add the account number label with the new font.
		importFile = new JMenuItem("Import...");
		importFile.setFont(font);
		
		// Add the account number label with the new font.
		exportFile = new JMenuItem("Export...");
		exportFile.setFont(font);
		
		// Add the account number label with the new font.
		newAccount = new JMenu("New");
		newAccount.setFont(font);
		
		// Add the account number label with the new font.
		chequingAccount = new JMenuItem("Chequing Account");
		chequingAccount.setFont(font);
		
		// Add the account number label with the new font.
		savingsAccount = new JMenuItem("Savings Account");
		
		
		savingsAccount.setFont(font);
		
		// Add the chequing and savings account menu items to the new account menu.
		newAccount.add(chequingAccount);
		newAccount.add(savingsAccount);
		
		// Add the import and export menu items to the file menu, and the new account menu to the file menu.
		file.add(importFile);
		file.add(exportFile);
		file.add(newAccount);
		
		// Add file and the update accounts to the menu bar.
		add(file, BorderLayout.WEST);
		add(updateAccounts, BorderLayout.EAST);
		
		// Add all of the action listeners for each menu, and the update accounts button.
		importFile.addActionListener(e -> openFile());
		exportFile.addActionListener(e -> saveFile());
		chequingAccount.addActionListener(e -> addNewAccount("Chequing"));
		savingsAccount.addActionListener(e -> addNewAccount("Savings"));
		updateAccounts.addActionListener(e -> updateAccounts());
		
		
		
	}
	/**
	 * This method opens a file for import and adds the bank accounts within the file to the bank class.
	 */
	public void openFile() {
		// Instantiate the place holder for the file chooser.
		final JFileChooser fileImport = new JFileChooser();
		JFrame framePlaceHolder = new JFrame();
		
		// Use the custom text file filter, and remove all file filter capability.
		fileImport.setFileFilter(new TextFileFilter());
		fileImport.setAcceptAllFileFilterUsed(false);
		fileImport.setDialogTitle("Import bank accounts");
		
		int returnVal = fileImport.showOpenDialog(framePlaceHolder);
		
		// If the file has been chosen continue, and send it to mainframe.
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			MainFrame.recordChecks(fileImport.getSelectedFile().getAbsolutePath());
		}
		
	}
	/**
	 * This method saves a file for export and adds the bank accounts to the designated file.
	 */
	public void saveFile() {
		
		// Instantiate the place holder for the file chooser.
		JFrame framePlaceHolder = new JFrame();
		final JFileChooser fileExport = new JFileChooser();
		
		// Use the custom text file filter, and remove all file filter capability.
		fileExport.setFileFilter(new TextFileFilter());
		fileExport.setAcceptAllFileFilterUsed(false);
		fileExport.setDialogTitle("Save bank accounts");
		
		int returnVal = fileExport.showSaveDialog(framePlaceHolder);
		
		// If the file has been chosen continue, and send it to mainframe.
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File newFile = fileExport.getSelectedFile();
			MainFrame.saveRecords(newFile);
		}
	}
	/**
	 * This method opens the frames that handle the creation of each respective bank account. 
	 * @param type is a String that is used to choose between chequing account, and savings account
	 */
	public void addNewAccount(String type) {
		
		// Open whichever bank account is chosen's frame.
		if (type.matches("Chequing")) {
			chequeFrame = new ChequingFrame();
			
		} else {
			saveFrame = new SavingsFrame();
			
		}
		
	}
	/**
	 * This method updates all the bank accounts.
	 */
	public void updateAccounts() {
		MainFrame.monthlyUpdate();
	}
	
}
