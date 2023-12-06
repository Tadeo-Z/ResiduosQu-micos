/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.ProductorResiduo;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de productores de residuos.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar
 * y buscar información relacionada con productores de residuos.
 */
public interface iProductorResiduoBO {

    /**
     * Registra un nuevo productor de residuos.
     * 
     * @param productorResiduoRegistrar El ProductorResiduo que se registrará.
     * @return El ProductorResiduo registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws BOException;

    /**
     * Busca un productor de residuos por su ID.
     * 
     * @param idProductorResiduo El ID del productor de residuos a buscar.
     * @return El ProductorResiduo encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public ProductorResiduo buscar(int idProductorResiduo) throws BOException;
}
