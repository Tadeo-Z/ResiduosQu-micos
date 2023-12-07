/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import org.itson.entidades.Solicitud;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iSolicitudBO;

/**
 *
 * @author TADEO
 *
 * Clase que representa la lógica de negocio (BO) para la gestión de solicitudes.
 * Implementa la interfaz iSolicitudBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar y buscar información
 * relacionada con solicitudes, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 */
public class SolicitudBO implements iSolicitudBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public SolicitudBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra una nueva solicitud.
     * 
     * @param solicitudRegistrar La Solicitud que se registrará.
     * @return La Solicitud registrada.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public Solicitud registrar(Solicitud solicitudRegistrar) throws BOException {
        try {
            // Valida la Solicitud antes del registro
            this.validarRegistrarSolicitud(solicitudRegistrar);
            
            // Registra la Solicitud utilizando la capa de persistencia
            return persistencia.registrar(solicitudRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca una solicitud por su ID.
     * 
     * @param idSolicitud El ID de la solicitud a buscar.
     * @return La Solicitud encontrada.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public Solicitud buscar(int idSolicitud) throws BOException {
        try {
            // Valida el ID antes de buscar la Solicitud
            this.validarBuscarSolicitud(idSolicitud);
            
            // Busca la Solicitud utilizando la capa de persistencia
            return persistencia.buscarSolicitud(idSolicitud);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }
    
    /**
     * Obtiene todas las solicitudes registradas en la BD
     * @return Lista de todas las solicitudes registradas
     * @throws BOException Si hay un problema durante el proceso de busqueda,
     * encapsulamiento o persistencia.
     */
    public List<Solicitud> obtenerTodasLasSolicitudes() throws BOException{
        try{
            return persistencia.obtenerTodasLasSolicitudes();
        }catch(PersistenciaException e){
            throw new BOException(e.getMessage());
        }
    }

    /**
     * Valida la Solicitud antes del registro.
     * 
     * @param solicitudValidar La Solicitud a validar.
     * @throws ValidacionesException Si la validación falla, indicando que la Solicitud
     *                              es nula o carece de información necesaria.
     */
    private void validarRegistrarSolicitud(Solicitud solicitudValidar) throws ValidacionesException {
        if (solicitudValidar == null) {
            throw new ValidacionesException("Solicitud a registrar es nula / No hay información");
        }
    }

    /**
     * Valida el ID de la Solicitud antes de la búsqueda.
     * 
     * @param solicitudValidar El ID de la Solicitud a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validarBuscarSolicitud(int solicitudValidar) throws ValidacionesException {
        if (solicitudValidar <= 0) {
            throw new ValidacionesException("ID de la solicitud es menor o igual a 0");
        }
    }
}
