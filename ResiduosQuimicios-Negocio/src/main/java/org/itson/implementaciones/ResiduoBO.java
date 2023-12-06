/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.Residuo;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iResiduoBO;

/**
 *
 * @author TADEO
 */
public class ResiduoBO implements iResiduoBO{
    
    FachadaPersistencia persistencia;

    public ResiduoBO(){
        persistencia = new FachadaPersistencia();
    }
    
    @Override
    public Residuo registrar(Residuo residuoRegistrar) throws BOException {
        try{
            this.validarRegistrarResiduo(residuoRegistrar);
            return persistencia.registrar(residuoRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    public Residuo buscar(int idResiduo) throws BOException{
        try{
            this.validaBuscarResiduo(idResiduo);
            return persistencia.buscarResiduo(idResiduo);
        }catch(PersistenciaException | ValidacionesException e){
            throw new BOException(e.getMessage(), e);
        }
    }
    
    private void validarRegistrarResiduo(Residuo residuoValidar) throws ValidacionesException{
        if(residuoValidar == null){
            throw new ValidacionesException("Residuo a registrar es nulo / No hay informacion");
        }
    }
    
    private void validaBuscarResiduo(int residuoValidar) throws ValidacionesException{
        if(residuoValidar <= 0){
            throw new ValidacionesException("ID del residuo es menor o igual a 0");
        }
    }
}
