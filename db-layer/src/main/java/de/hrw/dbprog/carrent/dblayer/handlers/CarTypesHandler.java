package de.hrw.dbprog.carrent.dblayer.handlers;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.hrw.dbprog.carrent.dblayer.model.car.CarModel;
import de.hrw.dbprog.carrent.dblayer.model.car.CarType;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Component
@Transactional
public class CarTypesHandler {

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
	 * Find car type id.
	 *
	 * @param label the label
	 * @return the int
	 */
	public int findCarTypeID(String label) {
		
		TypedQuery<CarType> query = entityManager.createNamedQuery(CarType.QUERY_FINDBYLABEL, CarType.class);
		query.setParameter("label", label);
		
		for (CarType carType : query.getResultList()) {
			if (carType.getLabel().equals(label)) {
				return carType.getCarTypeID();
			}
		}
		
		return -1;
    }
}
