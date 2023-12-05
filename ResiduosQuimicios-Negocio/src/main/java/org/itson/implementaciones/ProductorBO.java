/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.Productor;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iProductorBO;

/**
 *
 * @author TADEO
 */
public class ProductorBO implements iProductorBO{

    FachadaPersistencia persistencia;
    
    public ProductorBO(){
        persistencia = new FachadaPersistencia();
    }
    
    @Override
    public Productor registrar(Productor productorRegistrar) throws BOException {
        try{
            this.validarRegistrarProductor(productorRegistrar);
            return persistencia.registrar(productorRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    private void validarRegistrarProductor(Productor productorValidar) throws ValidacionesException{
        if(productorValidar == null){
            throw new ValidacionesException("Producto a insertar es nulo / No hay informacion");
        }
    }
    
}
