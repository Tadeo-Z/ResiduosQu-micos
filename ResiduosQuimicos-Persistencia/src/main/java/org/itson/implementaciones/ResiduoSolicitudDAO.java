/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.ResiduoSolicitud;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iResiduoSolicitud;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iResiduoSolicitud y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad ResiduoSolicitud.
 */
public class ResiduoSolicitudDAO implements iResiduoSolicitud {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de Entity Manager.
     */
    public ResiduoSolicitudDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra un nuevo ResiduoSolicitud en la base de datos.
     *
     * @param residuoSolicitudRegistrar El ResiduoSolicitud a registrar.
     * @return El ResiduoSolicitud registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(residuoSolicitudRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return residuoSolicitudRegistrar;
    }

    /**
     * Busca un ResiduoSolicitud en la base de datos por su identificador.
     *
     * @param idResiduoSolicitud El identificador del ResiduoSolicitud a buscar.
     * @return El ResiduoSolicitud encontrado o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public ResiduoSolicitud buscar(int idResiduoSolicitud) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        ResiduoSolicitud residuoSolicitudBuscar = null;

        try {
            em.getTransaction().begin();
            residuoSolicitudBuscar = em.find(ResiduoSolicitud.class, idResiduoSolicitud);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return residuoSolicitudBuscar;
    }
}
