/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Quimico;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de productos químicos.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar
 * y buscar información relacionada con productos químicos.
 */
public interface iQuimicoBO {

    /**
     * Registra un nuevo producto químico.
     * 
     * @param quimicoRegistrar El Quimico que se registrará.
     * @return El Quimico registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public Quimico registrar(Quimico quimicoRegistrar) throws BOException;

    /**
     * Busca un producto químico por su ID.
     * 
     * @param idQuimico El ID del producto químico a buscar.
     * @return El Quimico encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public Quimico buscar(int idQuimico) throws BOException;
}
