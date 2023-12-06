/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Traslado;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define los métodos de persistencia para la entidad Traslado.
 */
public interface iTraslado {

    public Traslado registrar(Traslado trasladoRegistrar) throws PersistenciaException;

    public Traslado buscar(int idTraslado) throws PersistenciaException;
}
