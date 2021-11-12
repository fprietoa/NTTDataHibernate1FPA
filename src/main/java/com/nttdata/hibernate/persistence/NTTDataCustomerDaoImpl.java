package com.nttdata.hibernate.persistence;

import java.util.List;

import org.hibernate.Session;

/**
 * Hibernate - Taller 1
 * 
 * DAO de tabla NTTDATA_TH1_CUSTOMER
 * 
 * @author fprietoa
 *
 */
public class NTTDataCustomerDaoImpl<T> implements NTTDataCustomerDaoI<T> {

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Método constructor.
	 * 
	 * @param session
	 */
	@SuppressWarnings("unchecked")
	public NTTDataCustomerDaoImpl(Session session) {
		this.session = session;
	}

	@Override
	public void insert(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.save(paramT);
		session.flush();

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void update(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.saveOrUpdate(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public void delete(final T paramT) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Insercción.
		session.delete(paramT);

		// Commit.
		session.getTransaction().commit();
	}

	@Override
	public T searchById(final Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda por PK.
		T result = (T) session.get(NTTDataCustomer.class, id);

		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Búsqueda de todos los registros.
		List<T> list = session.createQuery("FROM " + NTTDataCustomer.class.getName()).list();

		return list;

	}

	public List<T> searchByNameAndSurnames(final String nombre, final String apellido1, final String apellido2) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Localiza jugadores en función del nombre.
		final List<T> customerList = session.createQuery("FROM " + NTTDataCustomer.class.getName() + " WHERE " + "NAME LIKE " + "'" + nombre + "'"
		        + " AND LASTNAME1 LIKE " + "'" + apellido1 + "'" + " AND LASTNAME2 LIKE " + "'" + apellido2 + "'").list();

		return customerList;

	}

}
