/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.itson.conexion.Conexion;
import org.itson.entidades.Solicitud;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iSolicitud;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iSolicitud y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad Solicitud.
 */
public class SolicitudDAO implements iSolicitud {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de Entity Manager.
     */
    public SolicitudDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra una nueva Solicitud en la base de datos.
     *
     * @param solicitudRegistrar La Solicitud a registrar.
     * @return La Solicitud registrada.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Solicitud registrar(Solicitud solicitudRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(solicitudRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return solicitudRegistrar;
    }

    /**
     * Busca una Solicitud en la base de datos por su identificador.
     *
     * @param idSolicitud El identificador de la Solicitud a buscar.
     * @return La Solicitud encontrada o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Solicitud buscar(int idSolicitud) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        Solicitud solicitudBuscar = null;

        try {
            em.getTransaction().begin();
            solicitudBuscar = em.find(Solicitud.class, idSolicitud);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return solicitudBuscar;
    }
    
    public List<Solicitud> obtenerTodasLasSolicitudes() throws PersistenciaException{
        EntityManager em = emf.createEntityManager();
        List<Solicitud> solicitudes = null;
        
        try{
            em.getTransaction().begin();
            TypedQuery<Solicitud> query = em.createQuery("SELECT s FROM Solicitud s", Solicitud.class);
            solicitudes = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return solicitudes;
    }
    
}
