/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.Traslado;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iTrasladoBO;

/**
 *
 * @author TADEO
 */
public class TrasladoBO implements iTrasladoBO{

    FachadaPersistencia persistencia;
    
    public TrasladoBO(){
        persistencia = new FachadaPersistencia();
    }
    
    @Override
    public Traslado registrar(Traslado trasladoRegistrar) throws BOException {
        try{
            this.validarRegistrarTraslado(trasladoRegistrar);
            return persistencia.registrar(trasladoRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    public Traslado buscar(int idTraslado) throws BOException{
        try{
            this.validarBuscarTraslado(idTraslado);
            return persistencia.buscarTraslado(idTraslado);
        }catch(PersistenciaException | ValidacionesException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    private void validarRegistrarTraslado(Traslado trasladoValidar) throws ValidacionesException{
        if(trasladoValidar == null){
            throw new ValidacionesException("Traslado a registrar es nulo / No hay informacion");
        }
    }
    
    private void validarBuscarTraslado(int trasladoValidar) throws ValidacionesException{
        if(trasladoValidar <= 0){
            throw new ValidacionesException("ID de traslado es menor o igual a 0");
        }
    }
}
