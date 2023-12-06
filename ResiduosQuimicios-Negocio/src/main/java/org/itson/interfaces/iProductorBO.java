/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Productor;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de productores.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar,
 * actualizar y buscar información relacionada con productores.
 */
public interface iProductorBO {

    /**
     * Registra un nuevo productor.
     * 
     * @param productorRegistrar El Productor que se registrará.
     * @return El Productor registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public Productor registrar(Productor productorRegistrar) throws BOException;

    /**
     * Actualiza la información de un productor existente.
     * 
     * @param productorActualizar El Productor con la información actualizada.
     * @return El Productor actualizado.
     * @throws BOException Si hay un problema durante el proceso de actualización, encapsulando
     *                     posibles excepciones específicas.
     */
    public Productor actualizar(Productor productorActualizar) throws BOException;

    /**
     * Busca un productor por su ID.
     * 
     * @param idProductor El ID del productor a buscar.
     * @return El Productor encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public Productor buscar(int idProductor) throws BOException;
}
