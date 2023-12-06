/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Traslado;
import org.itson.excepciones.BOException;


/**
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de traslados.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar
 * y buscar información relacionada con traslados.
 */
public interface iTrasladoBO {

    /**
     * Registra un nuevo traslado.
     * 
     * @param trasladoRegistrar El Traslado que se registrará.
     * @return El Traslado registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public Traslado registrar(Traslado trasladoRegistrar) throws BOException;

    /**
     * Busca un traslado por su ID.
     * 
     * @param idTraslado El ID del traslado a buscar.
     * @return El Traslado encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public Traslado buscar(int idTraslado) throws BOException;
}
