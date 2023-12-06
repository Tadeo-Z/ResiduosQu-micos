/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.EmpresaTransportista;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de empresas transportistas.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar y buscar
 * información relacionada con empresas transportistas.
 */
public interface iEmpresaTransportistaBO {

    /**
     * Registra una nueva empresa transportista.
     * 
     * @param empresaTransportistaRegistrar La EmpresaTransportista que se registrará.
     * @return La EmpresaTransportista registrada.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws BOException;

    /**
     * Busca una empresa transportista por su ID.
     * 
     * @param idEmpresaTransportista El ID de la empresa transportista a buscar.
     * @return La EmpresaTransportista encontrada.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public EmpresaTransportista buscar(int idEmpresaTransportista) throws BOException;
}
