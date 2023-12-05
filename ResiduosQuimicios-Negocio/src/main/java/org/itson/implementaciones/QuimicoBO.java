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
    
    private void validarQuimicoRegistrar(Quimico quimicoValidar) throws ValidacionesException{
        if(quimicoValidar == null){
            throw new ValidacionesException("Quimico a validar es nulo / No hay informacion");
        }
    }
    
}
