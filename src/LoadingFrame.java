/**
* File Name: LoadingFrame.java
* Author: Amero Defranco, 040935555
* Course: CST8132 - 310
* Assignment: Lab 9
* Date: April 18, 2019
* Professor: Angela Giddings
* Purpose: This class creates the loading frame that runs before the main application.
* Class List: AccountsInfoJPanel.java, AccountsListJPanel.java, Assign2.java, Bank.java, BankAccount.java, ChequingAccount.java, ChequingFrame.java, InvalidInputDialog.java, MainFrame.java, Menu.java, Person.java, SavingsAccount.java, SavingsFrame.java, TextFileFilter.java
*/

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 * This class creates the loading frame that runs before the main application.
 * @author Amero Defranco, 040935555
 * @version 3.0
 * @since 1.8.0_201
 */

@SuppressWarnings("serial")
public class LoadingFrame extends JFrame {
	/** Loading bar for display **/
	private JProgressBar loadingBar;
	/** Holding panel for all the elements **/
	private JPanel holdingPanel;
	/** Background picture in the src/Assets folder **/
	private JLabel backgroundPicture;
	/** Image after being converted/buffered **/
	private BufferedImage loadingFrameBackground;
	/** Image file location **/
	private File loadingFrameBackgroundFile;
	
	
	/**
	 * Parameterless constructor, displays all of the components of the loading frame.
	 */
	public LoadingFrame() {
		
		// Sets the properties of the loading frame the size, close operation, resizability, and location.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setResizable(false);
		setLocationRelativeTo(null);
		
		// Instantiate the holding panel with a layout, for components.
		holdingPanel = new JPanel();
		holdingPanel.setLayout(new BorderLayout());
		
		// Instantiate the progress bar, add it's minimum and maximum value, and allow string painting.
		loadingBar = new JProgressBar(0, 100);
		loadingBar.setStringPainted(true);
		loadingBar.setValue(0);
		
		holdingPanel.add(loadingBar, BorderLayout.SOUTH);
		
		// Get the file location.
		loadingFrameBackgroundFile = new File("src/Assets/BankLoadingImage.png");
		
		try {
			// Buffer the image for use, and add it to the holding panel.
			loadingFrameBackground = ImageIO.read(loadingFrameBackgroundFile);
			backgroundPicture = new JLabel(new ImageIcon(loadingFrameBackground));
			holdingPanel.add(backgroundPicture, BorderLayout.CENTER);
		} catch (IOException e) {
			InvalidInputDialog.errorMessage("Image " + loadingFrameBackgroundFile.getPath() +" failed to load \n Continuing...");
		}

		holdingPanel.setVisible(true);
		
		add(holdingPanel);
		setVisible(true);
		
		// Iterate through 1000 milliseconds of time.
		for (int i = 0; i <= 1000; i++) {
			
			try {
				Thread.sleep(1);
				// add 0.01 each time to the percentage of the loading bar.
				loadingBar.setValue(i/10);
			} catch (Exception e) {
				
				InvalidInputDialog.errorMessage("Something went wrong with the loading bar \n Continuing...");
				break;
			}
		}
		// Hide the loading frame.
		setVisible(false);

	}
	
}
