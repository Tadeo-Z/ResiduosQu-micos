/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.entidades.Residuo;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iResiduoBO;

/**
 *
 * @author TADEO
 *
 *
 * Clase que representa la lógica de negocio (BO) para la gestión de residuos.
 * Implementa la interfaz iResiduoBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar y buscar información
 * relacionada con residuos, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 * 
 * Autor: TADEO
 */
public class ResiduoBO implements iResiduoBO {
    
    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public ResiduoBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra un nuevo residuo.
     * 
     * @param residuoRegistrar El objeto Residuo que se registrará.
     * @return El Residuo registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public Residuo registrar(Residuo residuoRegistrar) throws BOException {
        try {
            // Valida el Residuo antes del registro
            this.validarRegistrarResiduo(residuoRegistrar);
            
            // Registra el Residuo utilizando la capa de persistencia
            return persistencia.registrar(residuoRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca un residuo por su ID.
     * 
     * @param idResiduo El ID del residuo a buscar.
     * @return El Residuo encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public Residuo buscar(int idResiduo) throws BOException {
        try {
            // Valida el ID antes de buscar el Residuo
            this.validaBuscarResiduo(idResiduo);
            
            // Busca el Residuo utilizando la capa de persistencia
            return persistencia.buscarResiduo(idResiduo);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Obtiene todos los residuos registrados en la BD
     * @return Lista de todos los residuos registrados
     * @throws BOException Si hay un problema durante el proceso de busqueda,
     * encapsulamiento o persistencia.
     */
    public List<Residuo> obtenerTodosLosResiduos() throws BOException{
        try{
            return persistencia.obtenerTodosLosResiduos();
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage());
        }
    }
    
    /**
     * Valida el objeto Residuo antes del registro.
     * 
     * @param residuoValidar El objeto Residuo a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el objeto Residuo
     *                              es nulo o carece de información necesaria.
     */
    private void validarRegistrarResiduo(Residuo residuoValidar) throws ValidacionesException {
        if (residuoValidar == null) {
            throw new ValidacionesException("Residuo a registrar es nulo / No hay información");
        }
    }

    /**
     * Valida el ID del Residuo antes de la búsqueda.
     * 
     * @param residuoValidar El ID del Residuo a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validaBuscarResiduo(int residuoValidar) throws ValidacionesException {
        if (residuoValidar <= 0) {
            throw new ValidacionesException("ID del residuo es menor o igual a 0");
        }
    }
}
