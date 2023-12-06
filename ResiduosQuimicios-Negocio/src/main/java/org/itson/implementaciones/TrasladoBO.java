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
 *
 * Clase que representa la lógica de negocio (BO) para la gestión de traslados.
 * Implementa la interfaz iTrasladoBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar y buscar información
 * relacionada con traslados, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 */
public class TrasladoBO implements iTrasladoBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public TrasladoBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra un nuevo traslado.
     * 
     * @param trasladoRegistrar El Traslado que se registrará.
     * @return El Traslado registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public Traslado registrar(Traslado trasladoRegistrar) throws BOException {
        try {
            // Valida el Traslado antes del registro
            this.validarRegistrarTraslado(trasladoRegistrar);
            
            // Registra el Traslado utilizando la capa de persistencia
            return persistencia.registrar(trasladoRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca un traslado por su ID.
     * 
     * @param idTraslado El ID del traslado a buscar.
     * @return El Traslado encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public Traslado buscar(int idTraslado) throws BOException {
        try {
            // Valida el ID antes de buscar el Traslado
            this.validarBuscarTraslado(idTraslado);
            
            // Busca el Traslado utilizando la capa de persistencia
            return persistencia.buscarTraslado(idTraslado);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Valida el Traslado antes del registro.
     * 
     * @param trasladoValidar El Traslado a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el Traslado
     *                              es nulo o carece de información necesaria.
     */
    private void validarRegistrarTraslado(Traslado trasladoValidar) throws ValidacionesException {
        if (trasladoValidar == null) {
            throw new ValidacionesException("Traslado a registrar es nulo / No hay información");
        }
    }

    /**
     * Valida el ID del Traslado antes de la búsqueda.
     * 
     * @param trasladoValidar El ID del Traslado a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validarBuscarTraslado(int trasladoValidar) throws ValidacionesException {
        if (trasladoValidar <= 0) {
            throw new ValidacionesException("ID de traslado es menor o igual a 0");
        }
    }
}

