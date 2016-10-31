package de.hrw.dbprog.carrent.uilayer.graphicalUI;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.hrw.dbprog.carrent.servicelayer.control.DataController;

/**
 * The Class Login.
 */
public class Login extends JFrame implements ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The login button. */
	private JButton loginButton;
	
	/** The data controller. */
	private DataController dataController;
	
	/** The text field customer id. */
	private JTextField textFieldCustomerID;

	/**
	 * Instantiates a new login.
	 *
	 * @param dataController the data controller
	 */
	public Login(DataController dataController) {
		this.dataController = dataController;

		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(2, 2));

		contentPanel.add(new Label("Kundennummer"));
		this.textFieldCustomerID = new JTextField();
		contentPanel.add(textFieldCustomerID);

		this.loginButton = new JButton("Login");
		loginButton.addActionListener(this);
		contentPanel.add(loginButton);

		this.setVisible(true);

		this.setContentPane(contentPanel);
		this.setTitle("Login");
		this.setSize(400, 200);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
	}

	public void actionPerformed(ActionEvent actionEvent) {
		
		Object actionEventSource = actionEvent.getSource();

		if (actionEventSource == loginButton) {
			if (dataController.checkValidCustomer(Integer.parseInt(this.textFieldCustomerID.getText()))) {
				new GraphicalUI(dataController);
				
				this.dispose();

			} else {
				JOptionPane.showMessageDialog(this, "Login nicht erfolgreich.\nKunde ist nicht registriert.", "Loginfehler",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
