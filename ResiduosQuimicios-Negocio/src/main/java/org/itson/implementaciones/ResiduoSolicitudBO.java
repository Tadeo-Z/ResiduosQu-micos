/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.ResiduoSolicitud;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iResiduoSolicitudBO;

/**
 *
 * @author TADEO
 */
public class ResiduoSolicitudBO implements iResiduoSolicitudBO{
    
    FachadaPersistencia persistencia;
    
    public ResiduoSolicitudBO(){
        persistencia = new FachadaPersistencia();
    }

    @Override
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws BOException {
        try{
            this.validarRegistrarResiduoSolicitud(residuoSolicitudRegistrar);
            return persistencia.registrar(residuoSolicitudRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    private void validarRegistrarResiduoSolicitud(ResiduoSolicitud residuoSolicitudValidar) throws ValidacionesException{
        if(residuoSolicitudValidar == null){
            throw new ValidacionesException("ResiduoSolicitud a registrar vacio / No hay informacion");
        }
    }
    
}
