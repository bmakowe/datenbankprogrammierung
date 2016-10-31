package de.hrw.dbprog.carrent.uilayer.graphicalUI;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import de.hrw.dbprog.carrent.dblayer.model.car.CarModel;
import de.hrw.dbprog.carrent.servicelayer.control.DataController;

/**
 * The Class GraphicalUIReserve.
 */
@SuppressWarnings("serial")
public class GraphicalUIReserve extends JFrame implements ActionListener {

	/** The save button. */
	private JButton saveButton;

	/** The data controller. */
	private DataController dataController;

	/** The text field end. */
	private JTextField textFieldEnd;

	/** The text field start. */
	private JTextField textFieldStart;

	/** The selected car model. */
	private CarModel selectedCarModel;

	/**
	 * Instantiates a new graphical ui reserve.
	 *
	 * @param dataController
	 *            the data controller
	 * @param selectedCarModel
	 *            the selected car model
	 */
	public GraphicalUIReserve(DataController dataController, CarModel selectedCarModel) {

		this.dataController = dataController;
		this.selectedCarModel = selectedCarModel;

		JPanel contentPanel = new JPanel();

		contentPanel.setLayout(new GridLayout(4, 2));

		contentPanel.add(new Label("Beginn"));
		this.textFieldStart = new JTextField();
		contentPanel.add(textFieldStart);

		contentPanel.add(new Label("Ende"));
		this.textFieldEnd = new JTextField();
		contentPanel.add(textFieldEnd);

		this.saveButton = new JButton("Speichern");
		saveButton.addActionListener(this);
		contentPanel.add(saveButton);

		this.setVisible(true);

		this.setContentPane(contentPanel);
		this.setTitle("Reservierung");
		this.setSize(400, 400);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
	}

	public void actionPerformed(ActionEvent actionEvent) {

		Object actionEventSource = actionEvent.getSource();

		if (actionEventSource == saveButton) {
			java.sql.Date startDate = parseReservationDate(textFieldStart.getText());
			java.sql.Date endDate = parseReservationDate(textFieldEnd.getText());

			if (dataController.checkValidReservation(selectedCarModel, startDate, endDate) == 0) {
				this.dataController.makeReservation(dataController.getSelectedCustomer(), selectedCarModel, startDate,
						endDate);

				this.dispose();

			} else if (dataController.checkValidReservation(selectedCarModel, startDate, endDate) == -1) {
				JOptionPane.showMessageDialog(new JFrame(),
						"Bitte gültigen Reservierungszeitraum angeben!\nDer Reservierungszeitraum muss mindestens ein Tag betragen.",
						"Reservierungszeitraum", JOptionPane.INFORMATION_MESSAGE);

			} else if (dataController.checkValidReservation(selectedCarModel, startDate, endDate) == 1) {
				JOptionPane.showMessageDialog(new JFrame(), "Kein Fahrzeug verfügbar im angegebenen Zeitraum!",
						"Fahrzeug", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private java.sql.Date parseReservationDate(String textField) {

		java.util.Date tmpDate = null;
		java.sql.Date parsedDate = new Date(0);

		try {
			tmpDate = new SimpleDateFormat("dd-MM-yyyy").parse(textField);
			parsedDate.setTime(tmpDate.getTime());
			
		} catch (ParseException parseException) {
			parseException.printStackTrace();
		}

		return parsedDate;
	}
}
