/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.EmpresaTransportista;
import org.itson.entidades.Productor;
import org.itson.entidades.ProductorResiduo;
import org.itson.entidades.Quimico;
import org.itson.entidades.Residuo;
import org.itson.entidades.ResiduoSolicitud;
import org.itson.entidades.Solicitud;
import org.itson.entidades.Transporte;
import org.itson.entidades.Traslado;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 */
public interface iFachadaPersistencia {
    
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException;
    
    public Productor registrar(Productor productorRegistrar) throws PersistenciaException;
    
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws PersistenciaException;
    
    public Quimico registrar(Quimico quimicoRegistrar) throws PersistenciaException;
    
    public Residuo registrar(Residuo residuoRegistrar) throws PersistenciaException;
    
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws PersistenciaException;
    
    public Solicitud registrar(Solicitud solicitudRegistrar) throws PersistenciaException;
    
    public Transporte registrar(Transporte transporteRegistrar) throws PersistenciaException;
    
    public Traslado registrar(Traslado trasladoRegistrar) throws PersistenciaException;
}
