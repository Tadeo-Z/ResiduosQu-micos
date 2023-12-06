/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.ResiduoSolicitud;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
*
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de solicitudes de residuos.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar
 * y buscar información relacionada con solicitudes de residuos.
 */
public interface iResiduoSolicitudBO {

    /**
     * Registra una nueva solicitud de residuos.
     * 
     * @param residuoSolicitudRegistrar La ResiduoSolicitud que se registrará.
     * @return La ResiduoSolicitud registrada.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws BOException;

    /**
     * Busca una solicitud de residuos por su ID.
     * 
     * @param idResiduoSolicitud El ID de la solicitud de residuos a buscar.
     * @return La ResiduoSolicitud encontrada.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public ResiduoSolicitud buscar(int idResiduoSolicitud) throws BOException;
}
