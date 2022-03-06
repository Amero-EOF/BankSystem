/**
* File Name: AccountsListJPanel.java
* Author: Amero Defranco
* Assignment: Lab 9
* Date: April 18, 2019
* Purpose: This is the Account list JPanel which is displayed on the left side, it holds all of the current bank accounts.
* Class List: AccountsInfoJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
* Account list which is displayed on the left side.
* @author Amero Defranco, 040935555
* @version 3.0
* @since 1.8.0_201
*/

@SuppressWarnings("serial")
public class AccountsListJPanel extends JPanel {
	
	/** This is the scroll pane that holds all the accounts for selection. **/
	private JScrollPane accountScrollPane;
	/** This is the list of accounts that is added to the scroll pane. **/
	private JList<String> accountJList;
	/** This holds all of the account numbers and types as a string to be put in the accountJList. **/
	private DefaultListModel<String> accountStringList;
	
	/**
	 * A parameterless constructor for the instantiation of all the class members as well as an action listener for a button.
	 */
	public AccountsListJPanel() {
		
		// Get new dimensions based on the preferred width and height. Then changed the width to the specified size.
		Dimension dimensions = getPreferredSize();
		dimensions.width = 300;
		
		// A titled border for the added esthetic effect, using a 1 pixel thick black border, and larger font.
		TitledBorder tB = new TitledBorder(new LineBorder(Color.BLACK, 1), "Accounts");
		tB.setTitleFont(new Font("Dialog", Font.BOLD,16));
		
		// Set the JPanels properties, changing the size, border, layout, and font.
		setLayout(new BorderLayout());
		setPreferredSize(dimensions);
		setBorder(tB);
		setFont(new Font("Dialog", Font.BOLD,16));
		
		// Instantiate a new string list to put each new account in.
		accountStringList = new DefaultListModel<String>();
		
		// Create the new JList which will be added to the scroll pane.
		// Using single selection prevents ( Alt + Left Click ), and ( Shift + Left Click ).
		// set the model to the accountStringList to display each account with their designated account number
		// and account type. Set the font to a bigger one, and set the cell height for more space for each account.
		accountJList = new JList<String>();
		
		accountJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		accountJList.setModel(accountStringList);
		accountJList.setFont(new Font("Dialog", Font.PLAIN,16));
		accountJList.setFixedCellHeight(30);
		
		// Instantiate the scroll pane with the JList as a parameter, and set the scroll bar to always on.
		accountScrollPane = new JScrollPane(accountJList);
		
		accountScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		add(accountScrollPane, BorderLayout.CENTER);
		
		
		// Add a list selection listener to listen for events caused by the user selecting one of the accounts
		accountJList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				// checks if the value is adjusting to avoid multiple events being listened to.
				if (!e.getValueIsAdjusting()) {
					
					
					try {
						// Replace all non-numbers to get the account number at the end of the String
						String accountNumber = accountStringList.get(accountJList.getSelectedIndex()).replaceAll("\\D", "");
						MainFrame.accountPassThrough(accountNumber);
					
					} catch(Exception error) { } 
					// No need to report this error, it occurs when importing a new file and there's a selection
					
				}
			}
			
		});
		
	}
	
	/**
	 * A parameterless method for adding accounts to the list when importing a file.
	 */
	public void addAccounts() {
		
		// Clear the selection, and remove all the current accounts in the list.
		accountJList.clearSelection();
		accountStringList.removeAllElements();
		
		// Iterate through the freshly made bank accounts.
		for (BankAccount i:Bank.bankAccounts) {
			
			// Check each account for it's type and account number, and add it to the list of accounts.
			if (i.accountType == "C" ) {
				accountStringList.addElement("Chequing Account #" + i.accountNumber);
			} else {		
				accountStringList.addElement("Savings Account #" + i.accountNumber);
			}
		}
		
		// Set the users selection to the first element.
		accountJList.setSelectedIndex(0);
		
	}
	/**
	 * This method receives a bank account to add to the list of bank accounts being displayed.
	 * @param bankAccount This parameter hold a newly created bank account for display.
	 */
	public void addAccounts(BankAccount bankAccount) {
		
		// Check the account type, and add the account to the end of the list of accounts.
		if (bankAccount.accountType == "C" ) {
			accountStringList.addElement("Chequing Account #" + bankAccount.accountNumber);
		} else {		
			accountStringList.addElement("Savings Account #" + bankAccount.accountNumber);
		}
		
	}
	
}
