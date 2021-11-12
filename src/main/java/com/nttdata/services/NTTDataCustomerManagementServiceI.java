package com.nttdata.services;

import java.util.List;

import com.nttdata.hibernate.persistence.NTTDataCustomer;

/**
 * Hibernate - Taller 1
 * 
 * Interface del servicio de gestión de clientes.
 * 
 * @author fprietoa
 *
 */
public interface NTTDataCustomerManagementServiceI {

	/**
	 * Inserta un nuevo cliente.
	 * 
	 * @param newPlayer
	 */
	public void insertNewCustomer(final NTTDataCustomer newCustomer);

	/**
	 * Actualiza un cliente existente.
	 * 
	 * @param updatedPlayer
	 */
	public void updateCustomer(final NTTDataCustomer updatedCustomer);

	/**
	 * Elimina un cliente existente.
	 * 
	 * @param deletedPlayer
	 */
	public void deleteCustomer(final NTTDataCustomer deletedCustomer);

	/**
	 * Obtiene un cliente mediante su ID.
	 * 
	 * @param playerId
	 */
	public NTTDataCustomer searchById(final Long customerId);

	/**
	 * Obtiene todos los clientes existentes.
	 * 
	 * @return List<EverisContract>
	 */
	public List<NTTDataCustomer> searchAll();

	/**
	 * Obtiene los clientes por nombre y apellidos.
	 * 
	 * @param nombre
	 * @param apellido1
	 * @param apellido2
	 * @return
	 */
	public List<NTTDataCustomer> searchByNameAndSurnames(String nombre, String apellido1, String apellido2);

}
