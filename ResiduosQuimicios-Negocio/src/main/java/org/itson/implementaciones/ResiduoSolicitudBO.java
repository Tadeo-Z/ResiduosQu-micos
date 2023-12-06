/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.ResiduoSolicitud;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iResiduoSolicitudBO;

/**
 *
 * @author TADEO
 *
 * Clase que representa la lógica de negocio (BO) para la gestión de solicitudes de residuos.
 * Implementa la interfaz iResiduoSolicitudBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar y buscar información
 * relacionada con solicitudes de residuos, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 */
public class ResiduoSolicitudBO implements iResiduoSolicitudBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public ResiduoSolicitudBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra una nueva solicitud de residuo.
     * 
     * @param residuoSolicitudRegistrar La ResiduoSolicitud que se registrará.
     * @return La ResiduoSolicitud registrada.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws BOException {
        try {
            // Valida la ResiduoSolicitud antes del registro
            this.validarRegistrarResiduoSolicitud(residuoSolicitudRegistrar);
            
            // Registra la ResiduoSolicitud utilizando la capa de persistencia
            return persistencia.registrar(residuoSolicitudRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca una solicitud de residuo por su ID.
     * 
     * @param idResiduoSolicitud El ID de la solicitud de residuo a buscar.
     * @return La ResiduoSolicitud encontrada.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public ResiduoSolicitud buscar(int idResiduoSolicitud) throws BOException {
        try {
            // Valida el ID antes de buscar la ResiduoSolicitud
            this.validarBuscarResiduoSolicitud(idResiduoSolicitud);
            
            // Busca la ResiduoSolicitud utilizando la capa de persistencia
            return persistencia.buscarResiduoSolicitud(idResiduoSolicitud);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Valida la ResiduoSolicitud antes del registro.
     * 
     * @param residuoSolicitudValidar La ResiduoSolicitud a validar.
     * @throws ValidacionesException Si la validación falla, indicando que la ResiduoSolicitud
     *                              es nula o carece de información necesaria.
     */
    private void validarRegistrarResiduoSolicitud(ResiduoSolicitud residuoSolicitudValidar) throws ValidacionesException {
        if (residuoSolicitudValidar == null) {
            throw new ValidacionesException("ResiduoSolicitud a registrar vacío / No hay información");
        }
    }

    /**
     * Valida el ID de la ResiduoSolicitud antes de la búsqueda.
     * 
     * @param residuoSolicitudValidar El ID de la ResiduoSolicitud a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validarBuscarResiduoSolicitud(int residuoSolicitudValidar) throws ValidacionesException {
        if (residuoSolicitudValidar <= 0) {
            throw new ValidacionesException("ID del residuo solicitud es menor o igual a cero");
        }
    }
}
