/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.ResiduoSolicitud;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 * Interfaz que define los métodos de persistencia para la entidad ResiduoSolicitud.
 */
public interface iResiduoSolicitud {

    public ResiduoSolicitud registrar(ResiduoSolicitud solicitudResiduoRegistrar) throws PersistenciaException;

    public ResiduoSolicitud buscar(int idResiduoSolicitud) throws PersistenciaException;
}
