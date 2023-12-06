/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Solicitud;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 */
public interface iSolicitudBO {
    
    public Solicitud registrar(Solicitud solicitudRegistrar) throws BOException;
    
    public Solicitud buscar(int idSolicitud) throws BOException;
}
