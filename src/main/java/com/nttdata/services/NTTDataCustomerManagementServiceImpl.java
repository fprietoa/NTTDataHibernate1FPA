package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataCustomer;
import com.nttdata.hibernate.persistence.NTTDataCustomerDaoI;
import com.nttdata.hibernate.persistence.NTTDataCustomerDaoImpl;

/**
 * Hibernate - Taller 1
 * 
 * Implementación del servicio de gestión de clientes.
 * 
 * @author fprietoa
 *
 */
public class NTTDataCustomerManagementServiceImpl implements NTTDataCustomerManagementServiceI {

	/** DAO: EVERIS_HEX_PLAYER */
	private NTTDataCustomerDaoI customerDao;

	/**
	 * Método constructor.
	 */
	public NTTDataCustomerManagementServiceImpl(final Session session) {
		this.customerDao = new NTTDataCustomerDaoImpl(session);
	}

	@Override
	public void insertNewCustomer(final NTTDataCustomer newCustomer) {

		// Verificación de nulidad e inexistencia.
		if (newCustomer != null && newCustomer.getCustomerId() == null) {

			// Insercción del nuevo jugador.
			customerDao.insert(newCustomer);
		}

	}

	@Override
	public void updateCustomer(final NTTDataCustomer updatedCustomer) {

		// Verificación de nulidad y existencia.
		if (updatedCustomer != null && updatedCustomer.getCustomerId() != null) {

			// Actualización del jugador.
			customerDao.update(updatedCustomer);
		}

	}

	@Override
	public void deleteCustomer(final NTTDataCustomer deletedCustomer) {

		// Verificación de nulidad y existencia.
		if (deletedCustomer != null && deletedCustomer.getCustomerId() != null) {

			// Eliminación del jugador.
			customerDao.delete(deletedCustomer);
		}

	}

	@Override
	public NTTDataCustomer searchById(final Long customerId) {

		// Resultado.
		NTTDataCustomer customer = null;

		// Verificación de nulidad.
		if (customerId != null) {

			// Obtención del jugador por ID.
			customer = (NTTDataCustomer) customerDao.searchById(customerId);
		}

		return customer;
	}

	@Override
	public List<NTTDataCustomer> searchAll() {

		// Resultado.
		List<NTTDataCustomer> customersList = new ArrayList<NTTDataCustomer>();

		// Obtención de jugadores.
		customersList = customerDao.searchAll();

		return customersList;
	}

	@Override
	public List<NTTDataCustomer> searchByNameAndSurnames(String nombre, String apellido1, String apellido2) {

		// Resultado
		List<NTTDataCustomer> customerList = new ArrayList<NTTDataCustomer>();
		// Obetncion de los cliente
		customerList = customerDao.searchByNameAndSurnames(nombre, apellido1, apellido2);
		return customerList;
	}

}
