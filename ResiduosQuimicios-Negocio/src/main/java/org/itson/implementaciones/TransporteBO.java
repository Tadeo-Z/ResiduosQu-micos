/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.Transporte;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iTransporteBO;

/**
 *
 * @author TADEO
 *
 * Clase que representa la lógica de negocio (BO) para la gestión de transportes.
 * Implementa la interfaz iTransporteBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar y buscar información
 * relacionada con transportes, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 */
public class TransporteBO implements iTransporteBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public TransporteBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra un nuevo transporte.
     * 
     * @param transporteRegistrar El Transporte que se registrará.
     * @return El Transporte registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public Transporte registrar(Transporte transporteRegistrar) throws BOException {
        try {
            // Valida el Transporte antes del registro
            this.validarRegistrarTransporte(transporteRegistrar);
            
            // Registra el Transporte utilizando la capa de persistencia
            return persistencia.registrar(transporteRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca un transporte por su ID.
     * 
     * @param idTransporte El ID del transporte a buscar.
     * @return El Transporte encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public Transporte buscar(int idTransporte) throws BOException {
        try {
            // Valida el ID antes de buscar el Transporte
            this.validarBuscarTransporte(idTransporte);
            
            // Busca el Transporte utilizando la capa de persistencia
            return persistencia.buscarTransporte(idTransporte);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Valida el Transporte antes del registro.
     * 
     * @param transporteValidar El Transporte a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el Transporte
     *                              es nulo o carece de información necesaria.
     */
    private void validarRegistrarTransporte(Transporte transporteValidar) throws ValidacionesException {
        if (transporteValidar == null) {
            throw new ValidacionesException("Transporte a registrar es nulo / No hay información");
        }
    }

    /**
     * Valida el ID del Transporte antes de la búsqueda.
     * 
     * @param transporteValidar El ID del Transporte a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validarBuscarTransporte(int transporteValidar) throws ValidacionesException {
        if (transporteValidar <= 0) {
            throw new ValidacionesException("ID de transporte es menor o igual a 0");
        }
    }
}
