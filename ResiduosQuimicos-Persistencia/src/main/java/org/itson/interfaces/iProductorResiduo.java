/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.ProductorResiduo;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 * Interfaz que define los métodos de persistencia para la entidad ProductorResiduo.
 */
public interface iProductorResiduo {

    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws PersistenciaException;

    public ProductorResiduo buscar(int idProductorResiduo) throws PersistenciaException;
}
