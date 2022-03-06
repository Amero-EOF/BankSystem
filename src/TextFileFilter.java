/**
* File Name: TextFileFilter.java
* Author: Amero Defranco
* Assignment: Lab 9
* Date: April 18, 2019
* Purpose: This class is solely meant to filter files to get text documents only.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, LoadingFrame.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java
*/

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * This class is solely meant to filter files to get text documents, and directories only.
 * @author Amero Defranco
 * @version 3.0
 * @since 1.8.0_201
 */

public class TextFileFilter extends FileFilter {

	/**
	 * Takes a file and checks whether it is text document, or a directory.
	 * @return returns true if it's a text document or a directory, false if it's a different file format.
	 */
	@Override
	public boolean accept(File f) {
		if (f.isDirectory()) {
			return true;
		}
		
		String extension = null;
		String fileFullName = f.getName();
		
		// Get the index of the beginning of the file format '.', also using the last index incase of duplicate file formats.
		int beginningOfFileFormat = fileFullName.lastIndexOf('.');
		// Get's the string starting at the first letter of the file format.
		extension = fileFullName.substring(beginningOfFileFormat + 1).toUpperCase();
		
		if (extension != null ) {
			if (extension.equals("TXT")) {
				return true;
			}	
		}
		return false;
	}
	
	/**
	 * Gets the description of the file filter to be displayed in the file chooser.
	 * @return returns the description of file filter.
	 */
	@Override
	public String getDescription() {
		return "Text Documents (*.txt)";
	}

}
