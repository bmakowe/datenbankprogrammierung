package de.hrw.dbprog.carrent.dblayer.handlers;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import de.hrw.dbprog.carrent.dblayer.model.customer.Customer;

/**
 * Carrent db-layer.
 *
 * @author Bjoern Antonio Makowe <bm-132189@hs-weingarten.de>
 */
@Component
@Transactional
public class CustomersHandler {

	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Check valid customer id.
	 *
	 * @param customerID the customer id
	 * @return true, if successful
	 */
	public boolean checkValidCustomerID(int customerID) {

		Customer foundCustomer = entityManager.find(Customer.class, customerID);

		if (foundCustomer != null && foundCustomer.getCustomerID() == customerID) {
			return true;

		} else {
			return false;
		}
	}

	/**
	 * Find customer.
	 *
	 * @param customerToFind the customer to find
	 * @return the customer
	 */
	public Customer findCustomer(Customer customerToFind) {

		return entityManager.find(Customer.class, customerToFind);
	}
	
	/**
	 * Find customer by id.
	 *
	 * @param customerID the customer id
	 * @return the customer
	 */
	public Customer findCustomerByID (int customerID) {
		
		return entityManager.find(Customer.class, customerID);
	}
}
