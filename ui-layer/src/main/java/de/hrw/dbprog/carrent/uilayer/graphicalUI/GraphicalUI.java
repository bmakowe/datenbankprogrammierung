package de.hrw.dbprog.carrent.uilayer.graphicalUI;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import de.hrw.dbprog.carrent.servicelayer.control.DataController;

/**
 * GraphicalUI.
 *
 * @author Björn Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@SuppressWarnings("serial")
public class GraphicalUI extends JFrame {

	/** The search result panel. */
	private static GraphicalUISearchResultPanel searchResultPanel;
	
	/** The search parameter panel. */
	private static GraphicalUISearchParameterPanel searchParameterPanel;

	/**
	 * Instantiates a new graphical ui.
	 *
	 * @param dataController the data controller
	 */
	public GraphicalUI(DataController dataController) {
		
		searchResultPanel = new GraphicalUISearchResultPanel(dataController);
		searchParameterPanel = new GraphicalUISearchParameterPanel(dataController);

		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

		mainPanel.add(searchResultPanel);

		mainPanel.add(searchParameterPanel);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
		this.setTitle("Autoverleih");
		this.setSize(1000, 650);
		this.setResizable(true);
		this.setVisible(true);
	}

	/**
	 * Gets the single instance of GraphicalUI.
	 *
	 * @return single instance of GraphicalUI
	 */
	public static GraphicalUISearchResultPanel getInstance() {
		
		return searchResultPanel;
	}
}
