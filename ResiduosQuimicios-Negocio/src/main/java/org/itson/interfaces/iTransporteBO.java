/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Transporte;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 */
public interface iTransporteBO {
    
    public Transporte registrar(Transporte transporteRegistrar) throws BOException;
    
}
