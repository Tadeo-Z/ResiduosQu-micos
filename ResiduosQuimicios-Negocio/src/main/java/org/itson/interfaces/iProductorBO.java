/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Productor;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 */
public interface iProductorBO {
    
    public Productor registrar(Productor productorRegistrar) throws BOException;
    
    public Productor actualizar(Productor productorActualizar) throws BOException;
    
    public Productor buscar(int idProductor) throws BOException;
}
