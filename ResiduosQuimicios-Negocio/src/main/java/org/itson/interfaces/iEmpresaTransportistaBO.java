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
 */
public interface iEmpresaTransportistaBO {
    
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws BOException;

    public EmpresaTransportista buscar(int idEmpresaTransportista) throws BOException;
    
}