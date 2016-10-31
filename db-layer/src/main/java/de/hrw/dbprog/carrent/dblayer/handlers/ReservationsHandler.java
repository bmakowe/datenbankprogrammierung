package de.hrw.dbprog.carrent.dblayer.handlers;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.hrw.dbprog.carrent.dblayer.model.car.CarModel;
import de.hrw.dbprog.carrent.dblayer.model.customer.Customer;
import de.hrw.dbprog.carrent.dblayer.model.reservation.Reservation;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Component
@Transactional
public class ReservationsHandler {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Make reservation.
	 *
	 * @param customer
	 *            the customer
	 * @param selectedCarModel
	 *            the selected car model
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 */
	public void makeReservation(Customer customer, CarModel selectedCarModel, Date startDate, Date endDate) {

		Reservation reservation = new Reservation();

		reservation.setCustomer(customer);
		reservation.setCarModel(selectedCarModel);
		reservation.setStartDate(startDate);
		reservation.setEndDate(endDate);

		entityManager.persist(reservation);
	}

	/**
	 * Find reservations by car model.
	 *
	 * @param carModel
	 *            the car model
	 * @return the list
	 */
	public List<Reservation> findReservationsByCarModel(CarModel carModel) {

		TypedQuery<Reservation> query = entityManager.createNamedQuery(Reservation.QUERY_FIND_RESERVATIONS_BY_CARMODEL,
				Reservation.class);
		query.setParameter("carModel", carModel);

		return query.getResultList();
	}

	/**
	 * Count reservations by car models in period of time.
	 *
	 * @param carModel
	 *            the car model
	 * @param startDate
	 *            the start date
	 * @param endDate
	 *            the end date
	 * @return the int
	 */
	public int countReservationsByCarModelsInPeriodOfTime(CarModel carModel, Date startDate, Date endDate) {

		List<Reservation> reservationsWithCarModel = findReservationsByCarModel(carModel);

		List<Reservation> reservationsInPeriodOfTime = new LinkedList<Reservation>();

		for (Reservation reservation : reservationsWithCarModel) {

			// Possible reservation |------------------|
			//                          6. ...---------|
			//                    5.|--------...
			//                    4.|------------------|
			//          2.|-----------------| 3.|---------------|
			// 1.|------------------------------------------------------------|

			// Case 1
			if (reservation.getStartDate().before(startDate) && reservation.getEndDate().after(endDate)) {
				reservationsInPeriodOfTime.add(reservation);

			// Case 2
			} else if (reservation.getStartDate().before(startDate) && reservation.getEndDate().after(startDate)
					&& reservation.getEndDate().before(endDate)) {
				reservationsInPeriodOfTime.add(reservation);

			// Case 3
			} else if (reservation.getStartDate().after(startDate) && reservation.getStartDate().before(endDate)) {
				reservationsInPeriodOfTime.add(reservation);

			// Case 4
			} else if (reservation.getStartDate().getTime() == startDate.getTime()
					&& reservation.getEndDate().getTime() == endDate.getTime()) {
				reservationsInPeriodOfTime.add(reservation);

			// Case 5
			} else if (reservation.getStartDate().getTime() == startDate.getTime()) {
				reservationsInPeriodOfTime.add(reservation);

			// Case 6
			} else if (reservation.getEndDate().getTime() == endDate.getTime()) {
				reservationsInPeriodOfTime.add(reservation);
			}
		}

		return reservationsInPeriodOfTime.size();
	}
}
