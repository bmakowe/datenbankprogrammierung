package de.hrw.dbprog.carrent.servicelayer.control;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import de.hrw.dbprog.carrent.dblayer.configuration.DatabaseConfiguration;
import de.hrw.dbprog.carrent.dblayer.handlers.CarModelsHandler;
import de.hrw.dbprog.carrent.dblayer.handlers.CarTypesHandler;
import de.hrw.dbprog.carrent.dblayer.handlers.CarsHandler;
import de.hrw.dbprog.carrent.dblayer.handlers.CustomersHandler;
import de.hrw.dbprog.carrent.dblayer.handlers.ReservationsHandler;
import de.hrw.dbprog.carrent.dblayer.model.car.CarModel;
import de.hrw.dbprog.carrent.dblayer.model.customer.Customer;

/**
 * The Class DataController.
 */
@SuppressWarnings({ "serial" })
public class DataController extends DefaultTableModel {

	/** The context. */
	private AnnotationConfigApplicationContext context;

	/** The car models handler. */
	private CarModelsHandler carModelsHandler;

	/** The reservations handler. */
	private ReservationsHandler reservationsHandler;

	/** The reservations handler. */
	private CustomersHandler customersHandler;

	/** The car types handler. */
	private CarTypesHandler carTypesHandler;

	/** The Constant ROW. */
	private static final int ROW = 0;

	/** The car models. */
	private List<CarModel> carModels;

	/** The column identifier. */
	@SuppressWarnings("rawtypes")
	private Vector columnIdentifier;

	/** The is customer valid. */
	private boolean isCustomerValid;

	/** The valid customer. */
	private Customer validCustomer;

	/** The cars handler. */
	private CarsHandler carsHandler;

	/**
	 * Instantiates a new data controller.
	 */
	public DataController() {

		openConnection();

		showUnfilteredData();
	}

	/**
	 * Open connection.
	 */
	private void openConnection() {

		this.context = new AnnotationConfigApplicationContext(DatabaseConfiguration.class);
		this.context.scan("de.hrw.dbprog.carrent.dblayer");

		this.carModelsHandler = this.context.getBean(CarModelsHandler.class);
		this.reservationsHandler = this.context.getBean(ReservationsHandler.class);
		this.customersHandler = this.context.getBean(CustomersHandler.class);
		this.carTypesHandler = this.context.getBean(CarTypesHandler.class);
		this.carsHandler = this.context.getBean(CarsHandler.class);
	}

	/**
	 * Show all callable data.
	 */
	public void showUnfilteredData() {
		clearDataTable();

		loadCarModels();

		loadTableData();
	}

	/**
	 * Show all callable data.
	 *
	 * @param label
	 *            the label
	 * @param manufacturer
	 *            the manufacturer
	 * @param carType
	 *            the car type
	 * @param seatCapacity
	 *            the seat capacity
	 * @param fuel
	 *            the fuel
	 */
	public void showFilteredData(String label, String manufacturer, int carType, int seatCapacity, String fuel) {
		clearDataTable();

		loadCarModels(label, manufacturer, carType, seatCapacity, fuel);

		loadTableData();
	}

	/**
	 * Clear data table.
	 */
	/*
	 * Clear the data
	 */
	private void clearDataTable() {
		int rowCount = this.getRowCount();

		for (int counter = rowCount; counter > 0; --counter) {
			this.removeRow(0);
		}
	}

	/**
	 * Gets the column values.
	 *
	 * @param columnNumber
	 *            the column number
	 * @return the column values
	 */
	public Object[] getColumnValues(int columnNumber) {
		HashMap<Object, Object> columnVector = new HashMap<Object, Object>();

		int lines = getRowCount();

		for (int line = 0; line < lines; line++) {
			columnVector.put(getValueAt(line, columnNumber), getValueAt(line, columnNumber));
		}

		columnVector.put("", "");

		return columnVector.values().toArray();
	}

	/**
	 * Inits the column identifier.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initColumnIdentifier() {
		int columnCount = initColumnCount();

		this.columnIdentifier = new Vector(columnCount);

		columnIdentifier.add("ID");
		columnIdentifier.add("Bezeichnung");
		columnIdentifier.add("Hersteller");
		columnIdentifier.add("Autoart");
		columnIdentifier.add("Sitzplätze");
		columnIdentifier.add("kw");
		columnIdentifier.add("Treibstoff");
		columnIdentifier.add("PreisTag");
		columnIdentifier.add("PreisKM");
		columnIdentifier.add("Achsen");
		columnIdentifier.add("Ladevolumen");
		columnIdentifier.add("Zuladung");
		columnIdentifier.add("Führerschein");

		this.setColumnIdentifiers(columnIdentifier);
	}

	/**
	 * Inits the column count.
	 *
	 * @return the int
	 */
	private int initColumnCount() {

		return 13;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.AbstractTableModel#getColumnClass(int)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Class getColumnClass(int columnIndex) {

		return getValueAt(ROW, columnIndex).getClass();
	}

	/**
	 * Load car models.
	 */
	private void loadCarModels() {

		carModels = carModelsHandler.findAll();

		initColumnIdentifier();
	}

	/**
	 * Load car models.
	 *
	 * @param label
	 *            the label
	 * @param manufacturer
	 *            the manufacturer
	 * @param carType
	 *            the car type
	 * @param seatCapacity
	 *            the seat capacity
	 * @param fuel
	 *            the fuel
	 */
	private void loadCarModels(String label, String manufacturer, int carType, int seatCapacity, String fuel) {

		carModels = carModelsHandler.findWithFilter(label, manufacturer, carType, seatCapacity, fuel);

		initColumnIdentifier();
	}

	/**
	 * Load table data.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void loadTableData() {

		Vector row;

		for (CarModel carModel : carModels) {
			row = new Vector();

			row.add(carModel.getCarModelID());
			row.add(carModel.getLabel());
			row.add(carModel.getManufacturer());
			row.add(carModel.getCartype().getLabel());
			row.add(carModel.getSeats());
			row.add(carModel.getKw());
			row.add(carModel.getFuel());
			row.add(carModel.getPricePerDay());
			row.add(carModel.getPricePerKM());
			row.add(carModel.getAxes());
			row.add(carModel.getCargoVolume());
			row.add(carModel.getCargoLoad());
			row.add(carModel.getLicense());

			this.addRow(row);
		}
	}

	/**
	 * Delivers the Column identifiers.
	 *
	 * @return column names
	 */
	@SuppressWarnings("rawtypes")
	public Vector getColumnIdentifier() {

		return columnIdentifier;
	}

	/**
	 * Gets the cars.
	 *
	 * @return the cars
	 */
	public List<CarModel> getCars() {

		return carModels;
	}

	/**
	 * Check valid customer.
	 *
	 * @param customerID
	 *            the customer id
	 * @return true, if successful
	 */
	public boolean checkValidCustomer(int customerID) {

		if (this.customersHandler.checkValidCustomerID(customerID)) {

			validCustomer = this.customersHandler.findCustomerByID(customerID);

			isCustomerValid = true;
		}

		return isCustomerValid;
	}

	/**
	 * Check valid reservation.
	 *
	 * @param selectedCarModel the selected car model
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return -1 if period of time is not at least one day
	 * 1 if no free car is available
	 * 0 if period of time is at least one day and at least one free car is available
	 */
	public int checkValidReservation(CarModel selectedCarModel, java.sql.Date startDate, java.sql.Date endDate) {

		if (!periodIsAtLeastOneDay(startDate, endDate)) {
			return -1;
			
		} else if (!freeCarIsAvailable(selectedCarModel, startDate, endDate)) {
			return 1;
			
		} else {
			return 0;
		}
	}

	/**
	 * Check if free car is available.
	 *
	 * @param selectedCarModel the selected car model
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return true, if at least one free car is available
	 */
	private boolean freeCarIsAvailable(CarModel selectedCarModel, Date startDate, Date endDate) {

		int availableCarsInTotal = getNumberOfCarsOfCarModel(selectedCarModel);
		int carsAlreadyReserved = getReservationsOfACarModelInPeriodOfTime(selectedCarModel, startDate, endDate);

		if ((availableCarsInTotal - carsAlreadyReserved) > 0) {
			return true;
		} else {
			return false;
		}
	}


	/**
	 * Gets the reservations of a car model in period of time.
	 *
	 * @param selectedCarModel the selected car model
	 * @param startDate the start date
	 * @param endDate the end date
	 * @return the reservations of a car model in period of time
	 */
	private int getReservationsOfACarModelInPeriodOfTime(CarModel selectedCarModel, Date startDate, Date endDate) {

		return this.reservationsHandler.countReservationsByCarModelsInPeriodOfTime(selectedCarModel, startDate,
				endDate);
	}


	/**
	 * Gets the number of cars of car model.
	 *
	 * @param selectedCarModel the selected car model
	 * @return the number of cars of car model
	 */
	private int getNumberOfCarsOfCarModel(CarModel selectedCarModel) {

		return carsHandler.countCarsByCarModels(selectedCarModel);
	}


	/**
	 * Check if period of time is at least one day.
	 *
	 * @param earlierDate the earlier date
	 * @param laterDate the later date
	 * @return true, if period is at least one day
	 */
	private boolean periodIsAtLeastOneDay(java.sql.Date earlierDate, java.sql.Date laterDate) {

		if (earlierDate == null || laterDate == null) {
			return false;
		}

		long SECOND_MILLIS = 1000;
		long MINUTE_MILLIS = SECOND_MILLIS * 60;
		long HOUR_MILLIS = MINUTE_MILLIS * 60;
		long DAY_MILLIS = HOUR_MILLIS * 24;

		int differenceInDays = (int) ((laterDate.getTime() / DAY_MILLIS) - (earlierDate.getTime() / DAY_MILLIS));

		if (differenceInDays > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Make reservation.
	 *
	 * @param selectedCustomer
	 *            the customer id
	 * @param selectedCarModel
	 *            the selected car model
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 */
	public void makeReservation(Customer selectedCustomer, CarModel selectedCarModel, java.sql.Date startDate,
			java.sql.Date endDate) {

		this.reservationsHandler.makeReservation(selectedCustomer, selectedCarModel, startDate, endDate);
	}

	/**
	 * Gets the selected customer.
	 *
	 * @return the selected customer
	 */
	public Customer getSelectedCustomer() {

		return validCustomer;
	}

	/**
	 * Gets the car type id.
	 *
	 * @param carTypeLabel
	 *            the car type label
	 * @return the car type id
	 */
	public int getCarTypeID(String carTypeLabel) {

		return this.carTypesHandler.findCarTypeID(carTypeLabel);
	}
}
