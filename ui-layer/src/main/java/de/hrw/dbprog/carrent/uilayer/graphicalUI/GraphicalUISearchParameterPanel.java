package de.hrw.dbprog.carrent.uilayer.graphicalUI;

import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import de.hrw.dbprog.carrent.servicelayer.control.DataController;

/**
 * GraphicalUISearchParameterPanel.
 *
 * @author Björn Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@SuppressWarnings("serial")
public class GraphicalUISearchParameterPanel extends JPanel implements ActionListener {

	/** The data controller. */
	private final DataController dataController;

	/** The combo label. */
	private final JComboBox<?> comboLabel;

	/** The combo manufacturer. */
	private final JComboBox<?> comboManufacturer;

	/** The combo car type. */
	private final JComboBox<?> comboCarType;

	/** The combo seat capacity. */
	private final JComboBox<?> comboSeatCapacity;

	/** The combo fuel. */
	private final JComboBox<?> comboFuel;

	/** The search button. */
	private final JButton searchButton;

	/** The reserve button. */
	private final JButton reserveButton;

	/**
	 * Instantiates a new graphical ui search parameter panel.
	 *
	 * @param dataController
	 *            the data controller
	 */
	public GraphicalUISearchParameterPanel(DataController dataController) {

		this.dataController = dataController;

		this.setLayout(new GridLayout(6, 2));

		this.add(new Label(dataController.getColumnIdentifier().elementAt(1).toString()));
		this.comboLabel = new JComboBox<Object>(dataController.getColumnValues(1));
		this.comboLabel.setSelectedItem("");
		this.add(comboLabel);

		this.add(new Label(dataController.getColumnIdentifier().elementAt(2).toString()));
		this.comboManufacturer = new JComboBox<Object>(dataController.getColumnValues(2));
		this.comboManufacturer.setSelectedItem("");
		this.add(comboManufacturer);

		this.add(new Label(dataController.getColumnIdentifier().elementAt(3).toString()));
		this.comboCarType = new JComboBox<Object>(dataController.getColumnValues(3));
		this.comboCarType.setSelectedItem("");
		this.add(comboCarType);

		this.add(new Label(dataController.getColumnIdentifier().elementAt(4).toString()));
		this.comboSeatCapacity = new JComboBox<Object>(dataController.getColumnValues(4));
		this.comboSeatCapacity.setSelectedItem("");
		this.add(comboSeatCapacity);

		this.add(new Label(dataController.getColumnIdentifier().elementAt(6).toString()));
		this.comboFuel = new JComboBox<Object>(dataController.getColumnValues(6));
		this.comboFuel.setSelectedItem("");
		this.add(comboFuel);

		this.searchButton = new JButton("Suche ausführen");
		this.searchButton.addActionListener(this);
		this.add(searchButton);

		this.reserveButton = new JButton("Reservieren");
		reserveButton.addActionListener(this);
		this.add(reserveButton);

		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent actionEvent) {

		Object actionEventSource = actionEvent.getSource();

		if (actionEventSource == searchButton) {
			filterData();
		}

		if (actionEventSource == reserveButton) {
			reserve();
		}
	}

	private void reserve() {
		JTable table = GraphicalUI.getInstance().getTable();

		if (table.getSelectedRow() > -1) {
			new GraphicalUIReserve(dataController, dataController.getCars().get(table.getSelectedRow()));

		} else {
			String message = "Bitte Fahrzeug aus Tabelle wählen, um zu reservieren!";
			JOptionPane.showMessageDialog(new JFrame(), message, "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void filterData() {

		String label;
		String manufacturer;
		int carType;
		int seatCapacity;
		String fuel;

		label = this.comboLabel.getSelectedItem().toString();
		manufacturer = this.comboManufacturer.getSelectedItem().toString();
		fuel = this.comboFuel.getSelectedItem().toString();

		if (!this.comboCarType.getSelectedItem().toString().isEmpty()) {
			carType = dataController.getCarTypeID(this.comboCarType.getSelectedItem().toString());
		} else {
			carType = -1;
		}

		if (!this.comboSeatCapacity.getSelectedItem().toString().isEmpty()) {
			seatCapacity = Integer.parseInt(this.comboSeatCapacity.getSelectedItem().toString());
		} else {
			seatCapacity = -1;
		}

		dataController.showFilteredData(label, manufacturer, carType, seatCapacity, fuel);
	}
}
