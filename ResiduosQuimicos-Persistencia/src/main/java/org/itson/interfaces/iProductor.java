/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Productor;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 */
public interface iProductor {
    public Productor registrar(Productor productorRegistrar) throws PersistenciaException;
}
