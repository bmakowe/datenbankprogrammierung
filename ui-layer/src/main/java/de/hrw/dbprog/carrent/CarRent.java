package de.hrw.dbprog.carrent;

import de.hrw.dbprog.carrent.servicelayer.control.DataController;
import de.hrw.dbprog.carrent.uilayer.graphicalUI.Login;

/**
 * CarRent.
 *
 * @author Björn Antonio Makowe <bm-132189@hs-weingarten.de>
 */
public class CarRent {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		DataController dataController = new DataController();

		new Login(dataController);
	}
}
