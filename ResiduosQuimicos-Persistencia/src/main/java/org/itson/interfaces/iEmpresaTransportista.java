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
 */
public interface iEmpresaTransportista {
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException;
    public EmpresaTransportista buscar(int idEmpresaTransportista) throws PersistenciaException;
}
