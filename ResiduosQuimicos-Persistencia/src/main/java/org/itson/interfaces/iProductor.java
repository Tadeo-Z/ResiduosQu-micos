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
 * Interfaz que define los métodos de persistencia para la entidad Productor.
 */
public interface iProductor {

    public Productor registrar(Productor productorRegistrar) throws PersistenciaException;

    public Productor actualizar(Productor productorActualizar) throws PersistenciaException;

    public Productor buscar(int idProductor) throws PersistenciaException;
}
