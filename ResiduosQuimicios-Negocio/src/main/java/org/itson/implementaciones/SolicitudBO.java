/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.Solicitud;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iSolicitudBO;

/**
 *
 * @author TADEO
 */
public class SolicitudBO implements iSolicitudBO{

    FachadaPersistencia persistencia;
    
    public SolicitudBO(){
        persistencia = new FachadaPersistencia();
    }
    
    @Override
    public Solicitud registrar(Solicitud solicitudRegistrar) throws BOException {
        try{
            this.validarRegistrarSoliciutd(solicitudRegistrar);
            return persistencia.registrar(solicitudRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    private void validarRegistrarSoliciutd(Solicitud solicitudValidar) throws ValidacionesException{
        if(solicitudValidar == null){
            throw new ValidacionesException("Solicitud a registrar es nulo / No hay informacion");
        }
    }
    
}
