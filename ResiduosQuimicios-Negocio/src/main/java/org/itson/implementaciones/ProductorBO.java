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
 * Clase que representa la lógica de negocio (BO) para la gestión de productores.
 * Implementa la interfaz iProductorBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar, actualizar y buscar
 * información relacionada con productores, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 * @author TADEO
 */
public class ProductorBO implements iProductorBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public ProductorBO() {
        persistencia = new FachadaPersistencia();
    }
    
    /**
     * Registra un nuevo productor.
     * 
     * @param productorRegistrar El objeto Productor que se registrará.
     * @return El Productor registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public Productor registrar(Productor productorRegistrar) throws BOException {
        try {
            // Valida el Productor antes del registro
            this.validarRegistrarProductor(productorRegistrar);
            
            // Registra el Productor utilizando la capa de persistencia
            return persistencia.registrar(productorRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }
    
    /**
     * Actualiza la información de un productor existente.
     * 
     * @param productorActualizar El objeto Productor con la información actualizada.
     * @return El Productor actualizado.
     * @throws BOException Si hay un problema durante el proceso de actualización, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public Productor actualizar(Productor productorActualizar) throws BOException {
        try {
            // Valida el Productor antes de la actualización
            this.validarActualizarProductor(productorActualizar);
            
            // Actualiza el Productor utilizando la capa de persistencia
            return persistencia.actualizar(productorActualizar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca un productor por su ID.
     * 
     * @param idProductor El ID del productor a buscar.
     * @return El Productor encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public Productor buscar(int idProductor) throws BOException {
        try {
            // Valida el ID antes de buscar el Productor
            this.validarBuscarProductor(idProductor);
            
            // Busca el Productor utilizando la capa de persistencia
            return persistencia.buscarProductor(idProductor);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Valida el objeto Productor antes del registro.
     * 
     * @param productorValidar El objeto Productor a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el objeto Productor
     *                              es nulo o carece de información necesaria.
     */
    private void validarRegistrarProductor(Productor productorValidar) throws ValidacionesException {
        if (productorValidar == null) {
            throw new ValidacionesException("Productor a insertar es nulo / No hay información");
        }
    }

    /**
     * Valida el objeto Productor antes de la actualización.
     * 
     * @param productorValidar El objeto Productor a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el objeto Productor
     *                              es nulo o carece de información necesaria.
     */
    private void validarActualizarProductor(Productor productorValidar) throws ValidacionesException {
        if (productorValidar == null) {
            throw new ValidacionesException("Productor a actualizar es nulo / No hay información");
        }
    }

    /**
     * Valida el ID del Productor antes de la búsqueda.
     * 
     * @param productorValidar El ID del Productor a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validarBuscarProductor(int productorValidar) throws ValidacionesException {
        if (productorValidar <= 0) {
            throw new ValidacionesException("ID de productor es menor o igual a 0");
        }
    }
}
