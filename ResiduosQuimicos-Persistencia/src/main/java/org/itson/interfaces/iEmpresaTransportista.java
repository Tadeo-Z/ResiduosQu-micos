/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.EmpresaTransportista;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 * Interfaz que define los métodos de persistencia relacionados con la entidad EmpresaTransportista.
 */
public interface iEmpresaTransportista {
    
    /**
     * Registra una nueva empresa transportista en la capa de persistencia.
     *
     * @param empresaTransportistaRegistrar La empresa transportista a registrar.
     * @return La empresa transportista registrada.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException;
    
    /**
     * Busca una empresa transportista en la capa de persistencia por su identificador.
     *
     * @param idEmpresaTransportista El identificador de la empresa transportista a buscar.
     * @return La empresa transportista encontrada o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public EmpresaTransportista buscar(int idEmpresaTransportista) throws PersistenciaException;
}
