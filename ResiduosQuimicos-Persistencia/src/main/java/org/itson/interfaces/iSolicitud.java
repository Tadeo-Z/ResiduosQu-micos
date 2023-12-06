/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Solicitud;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define los métodos de persistencia para la entidad Solicitud.
 */
public interface iSolicitud {

    public Solicitud registrar(Solicitud solicitudRegistrar) throws PersistenciaException;

    public Solicitud buscar(int idSolicitud) throws PersistenciaException;
}
