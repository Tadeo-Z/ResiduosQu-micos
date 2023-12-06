/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Transporte;
import org.itson.excepciones.BOException;

/**
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de transportes.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar
 * y buscar información relacionada con transportes.
 */
public interface iTransporteBO {

    /**
     * Registra un nuevo transporte.
     * 
     * @param transporteRegistrar El Transporte que se registrará.
     * @return El Transporte registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public Transporte registrar(Transporte transporteRegistrar) throws BOException;

    /**
     * Busca un transporte por su ID.
     * 
     * @param idTransporte El ID del transporte a buscar.
     * @return El Transporte encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public Transporte buscar(int idTransporte) throws BOException;
}
