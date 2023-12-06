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
 */
public interface iProductorResiduoBO {
    
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws BOException;
    
    public ProductorResiduo buscar(int idProductorResiduo) throws BOException;
}
