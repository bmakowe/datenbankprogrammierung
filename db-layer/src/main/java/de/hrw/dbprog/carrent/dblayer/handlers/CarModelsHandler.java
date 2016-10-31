package de.hrw.dbprog.carrent.dblayer.handlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.hrw.dbprog.carrent.dblayer.model.car.CarModel;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Component
@Transactional
public class CarModelsHandler {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	public List<CarModel> findAll() {

		TypedQuery<CarModel> query = entityManager.createNamedQuery(CarModel.QUERY_FINDALL, CarModel.class);

		return query.getResultList();
	}

	/**
	 * Find with filter.
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
	 * @return the list
	 */
	public List<CarModel> findWithFilter(String label, String manufacturer, int carType, int seatCapacity,
			String fuel) {

		Session session = entityManager.unwrap(Session.class);

		if (!label.isEmpty()) {
			Filter labelFilter = session.enableFilter("filterByLabel");
			labelFilter.setParameter("label", label);
		}

		if (!manufacturer.isEmpty()) {
			Filter manufacturerFilter = session.enableFilter("filterByManufacturer");
			manufacturerFilter.setParameter("manufacturer", manufacturer);
		}

		if (carType != -1) {
			Filter carTypeFilter = session.enableFilter("filterByCarType");
			carTypeFilter.setParameter("carType", carType);
		}

		if (seatCapacity != -1) {
			Filter seatsFilter = session.enableFilter("filterBySeats");
			seatsFilter.setParameter("seats", seatCapacity);
		}

		if (!fuel.isEmpty()) {
			Filter fuelFilter = session.enableFilter("filterByFuel");
			fuelFilter.setParameter("fuel", fuel);
		}

		TypedQuery<CarModel> query = entityManager.createNamedQuery(CarModel.QUERY_FINDALL, CarModel.class);

		return query.getResultList();
	}

	/**
	 * Find car model by id.
	 *
	 * @param id the id
	 * @return the car model
	 */
	public CarModel findCarModel(int id) {
		try {
			return entityManager.find(CarModel.class, id);
		} finally {
			entityManager.close();
		}
	}
}
