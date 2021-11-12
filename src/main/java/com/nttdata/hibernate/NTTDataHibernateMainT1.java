package com.nttdata.hibernate;

import java.util.Date;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.NTTDataCustomer;
import com.nttdata.services.NTTDataCustomerManagementServiceI;
import com.nttdata.services.NTTDataCustomerManagementServiceImpl;

/**
 * Hibernate - Taller 1
 * 
 * Clase principal
 * 
 * @author fprietoa
 *
 */
public class NTTDataHibernateMainT1 {

	/**
	 * Método principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Apertura de sesión.
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicialización de servicios.
		final NTTDataCustomerManagementServiceI customerService = new NTTDataCustomerManagementServiceImpl(session);

		// Generación de clientes.
		final NTTDataCustomer customer1 = new NTTDataCustomer();
		customer1.setName("Maria");
		customer1.setLastName1("Perez");
		customer1.setLastName2("Gomez");
		customer1.setDni("29546235F");
		customerService.insertNewCustomer(customer1);

		final NTTDataCustomer customer2 = new NTTDataCustomer();
		customer2.setName("Pablo");
		customer2.setLastName1("Alvarez");
		customer2.setLastName2("Diaz");
		customer2.setDni("24285735F");
		customerService.insertNewCustomer(customer2);

		// Cambio de nombre y actualización.
		customer1.setName("Pepe");
		customerService.updateCustomer(customer1);

		// Buscar por nombre y apellidos.
		System.out.println(customerService.searchByNameAndSurnames("Pepe", "Perez", "Gomez").get(0).getCustomerId());

		// Buscar todos los clientes.
		System.out.println(customerService.searchAll());

		// Cerrar la sesión.
		session.close();

	}
}
