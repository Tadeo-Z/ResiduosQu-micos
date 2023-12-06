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
 * Clase que representa la lógica de negocio (BO) para la gestión de productos químicos.
 * Implementa la interfaz iQuimicoBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar y buscar información
 * relacionada con productos químicos, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 */
public class QuimicoBO implements iQuimicoBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public QuimicoBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra un nuevo producto químico.
     * 
     * @param quimicoRegistrar El objeto Quimico que se registrará.
     * @return El Quimico registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public Quimico registrar(Quimico quimicoRegistrar) throws BOException {
        try {
            // Valida el Quimico antes del registro
            this.validarQuimicoRegistrar(quimicoRegistrar);
            
            // Registra el Quimico utilizando la capa de persistencia
            return persistencia.registrar(quimicoRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca un producto químico por su ID.
     * 
     * @param idQuimico El ID del producto químico a buscar.
     * @return El Quimico encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public Quimico buscar(int idQuimico) throws BOException {
        try {
            // Valida el ID antes de buscar el Quimico
            this.validarBuscarQuimico(idQuimico);
            
            // Busca el Quimico utilizando la capa de persistencia
            return persistencia.buscarQuimico(idQuimico);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Valida el objeto Quimico antes del registro.
     * 
     * @param quimicoValidar El objeto Quimico a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el objeto Quimico
     *                              es nulo o carece de información necesaria.
     */
    private void validarQuimicoRegistrar(Quimico quimicoValidar) throws ValidacionesException {
        if (quimicoValidar == null) {
            throw new ValidacionesException("Quimico a validar es nulo / No hay información");
        }
    }

    /**
     * Valida el ID del Quimico antes de la búsqueda.
     * 
     * @param quimicoValidar El ID del Quimico a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validarBuscarQuimico(int quimicoValidar) throws ValidacionesException {
        if (quimicoValidar <= 0) {
            throw new ValidacionesException("ID del quimico es menor o igual a 0");
        }
    }
}
