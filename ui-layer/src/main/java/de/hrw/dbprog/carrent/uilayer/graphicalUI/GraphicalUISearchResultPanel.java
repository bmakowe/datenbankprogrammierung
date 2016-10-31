package de.hrw.dbprog.carrent.uilayer.graphicalUI;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import de.hrw.dbprog.carrent.servicelayer.control.DataController;

/**
 * GraphicalUISearchResultPanel.
 *
 * @author Björn Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@SuppressWarnings("serial")
public class GraphicalUISearchResultPanel extends JPanel {
	
	/** The data controller. */
	@SuppressWarnings("unused")
	private DataController dataController;
	
	/** The data table. */
	private JTable dataTable = null;

	/**
	 * Instantiates a new graphical ui search result panel.
	 *
	 * @param dataController the data controller
	 */
	public GraphicalUISearchResultPanel(DataController dataController) {
		this.setLayout(new BorderLayout());
		this.dataController = dataController;

		dataTable = new JTable(dataController);
		dataTable.setAutoCreateColumnsFromModel(true);
		dataTable.setVisible(true);
		this.add(new JScrollPane(dataTable), BorderLayout.NORTH);
	}

	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public JTable getTable() {
		return dataTable;
	}
}
