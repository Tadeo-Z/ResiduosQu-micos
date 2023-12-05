/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.Transporte;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iTransporteBO;

/**
 *
 * @author TADEO
 */
public class TransporteBO implements iTransporteBO{

    FachadaPersistencia persistencia;
    
    public TransporteBO(){
        persistencia = new FachadaPersistencia();
    }
    
    @Override
    public Transporte registrar(Transporte transporteRegistrar) throws BOException {
        try{
            this.validarRegistrarTransporte(transporteRegistrar);
            return persistencia.registrar(transporteRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    private void validarRegistrarTransporte(Transporte transporteValidar) throws ValidacionesException{
        if(transporteValidar == null){
            throw new ValidacionesException("Transporte a registrar es nulo / No hay informacion");
        }
    }
    
}
