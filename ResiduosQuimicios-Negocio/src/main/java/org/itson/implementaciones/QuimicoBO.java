/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.Quimico;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iQuimicoBO;

/**
 *
 * @author TADEO
 */
public class QuimicoBO implements iQuimicoBO{
    
    FachadaPersistencia persistencia;
    
    public QuimicoBO(){
        persistencia = new FachadaPersistencia();
    }

    @Override
    public Quimico registrar(Quimico quimicoRegistrar) throws BOException {
        try{
            this.validarQuimicoRegistrar(quimicoRegistrar);
            return persistencia.registrar(quimicoRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    public Quimico buscar(int idQuimico) throws BOException{
        try{
            this.validarBuscarQuimico(idQuimico);
            return persistencia.buscarQuimico(idQuimico);
        }catch(PersistenciaException | ValidacionesException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    private void validarQuimicoRegistrar(Quimico quimicoValidar) throws ValidacionesException{
        if(quimicoValidar == null){
            throw new ValidacionesException("Quimico a validar es nulo / No hay informacion");
        }
    }
    
    private void validarBuscarQuimico(int quimicoValidar) throws ValidacionesException{
        if(quimicoValidar <= 0){
            throw new ValidacionesException("ID del quimico es menor o igual a 0");
        }
    }
    
}
