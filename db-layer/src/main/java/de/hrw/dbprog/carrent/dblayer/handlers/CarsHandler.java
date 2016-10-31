package de.hrw.dbprog.carrent.dblayer.handlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.hrw.dbprog.carrent.dblayer.model.car.Car;
import de.hrw.dbprog.carrent.dblayer.model.car.CarModel;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Component
@Transactional
public class CarsHandler {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Find cars by car model.
	 *
	 * @param carModel the car model
	 * @return the list
	 */
	public List<Car> findCarsByCarModel(CarModel carModel) {

		TypedQuery<Car> query = entityManager.createNamedQuery(Car.QUERY_FINDBYCARMODEL, Car.class);
		query.setParameter("carModel", carModel);

		return query.getResultList();
	}
	
	/**
	 * Count cars by car models.
	 *
	 * @param carModel the car model
	 * @return the int
	 */
	public int countCarsByCarModels(CarModel carModel) {

		return findCarsByCarModel(carModel).size();
	}
}
