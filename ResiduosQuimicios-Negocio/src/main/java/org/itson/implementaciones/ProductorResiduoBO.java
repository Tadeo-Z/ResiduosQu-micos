/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.ProductorResiduo;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iProductorResiduoBO;

/**
 *
 * @author TADEO
 */
public class ProductorResiduoBO implements iProductorResiduoBO{
    
    FachadaPersistencia persistencia;
    
    public ProductorResiduoBO(){
        persistencia = new FachadaPersistencia();
    }

    @Override
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws BOException {
        try{
            this.validarRegistrarProductorResiduo(productorResiduoRegistrar);
            return persistencia.registrar(productorResiduoRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
 
    private void validarRegistrarProductorResiduo(ProductorResiduo productorResiduoValidar) throws ValidacionesException{
        if(productorResiduoValidar == null){
            throw new ValidacionesException("ProductorResiduo a insertar es nulo / No hay informacion");
        }
    }
    
}
