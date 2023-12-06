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
    
    public Productor actualizar(Productor productorActualizar) throws BOException{
        try{
            this.validarActualizarProductor(productorActualizar);
            return persistencia.actualizar(productorActualizar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    public Productor buscar(int idProductor) throws BOException{
        try{
            this.validarBuscarProductor(idProductor);
            return persistencia.buscarProductor(idProductor);
        }catch(PersistenciaException | ValidacionesException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    private void validarRegistrarProductor(Productor productorValidar) throws ValidacionesException{
        if(productorValidar == null){
            throw new ValidacionesException("Producto a insertar es nulo / No hay informacion");
        }
    }
    
    private void validarActualizarProductor(Productor productorValidar) throws ValidacionesException{
        if(productorValidar == null){
            throw new ValidacionesException("Productor a actualizar es nulo / No hay informacion");
        }
    }
    
    private void validarBuscarProductor(int productorValidar) throws ValidacionesException{
        if(productorValidar <= 0){
            throw new ValidacionesException("ID de productor es menor o igual a 0");
        }
    }
    
}
