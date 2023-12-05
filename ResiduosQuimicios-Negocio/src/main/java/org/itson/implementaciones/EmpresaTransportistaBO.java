/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.EmpresaTransportista;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iEmpresaTransportistaBO;

/**
 *
 * @author TADEO
 */
public class EmpresaTransportistaBO implements iEmpresaTransportistaBO{

    FachadaPersistencia persistencia;
    
    public EmpresaTransportistaBO(){
        persistencia = new FachadaPersistencia();
    }
    
    @Override
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws BOException {
        try{
            this.validarRegistrarEmpresaTransportista(empresaTransportistaRegistrar);
            return persistencia.registrar(empresaTransportistaRegistrar);
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage(), e);
        }catch(ValidacionesException a){
            throw new BOException(a.getMessage(), a);
        }
    }
    
    private void validarRegistrarEmpresaTransportista(EmpresaTransportista empresaTransportistaValidar) throws ValidacionesException{
        if(empresaTransportistaValidar == null){
            throw new ValidacionesException("Persona a insertar es nulo / No hay informacion");
        }
    }
    
}
