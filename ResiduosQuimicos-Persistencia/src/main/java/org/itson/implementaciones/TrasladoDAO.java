/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import org.itson.entidades.Traslado;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iTraslado;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iTraslado y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad Traslado.
 */
public class TrasladoDAO implements iTraslado {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Registra un nuevo Traslado en la base de datos.
     *
     * @param trasladoRegistrar El Traslado a registrar.
     * @return El Traslado registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Traslado registrar(Traslado trasladoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(trasladoRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return trasladoRegistrar;
    }

    /**
     * Busca un Traslado en la base de datos por su identificador.
     *
     * @param idTraslado El identificador del Traslado a buscar.
     * @return El Traslado encontrado o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Traslado buscar(int idTraslado) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        Traslado trasladoBuscar = null;

        try {
            em.getTransaction().begin();
            trasladoBuscar = em.find(Traslado.class, idTraslado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return trasladoBuscar;
    }
    
    /**
     * Obtiene todos los traslados registrados en la base de datos.
     * @return Lista de todos los traslados registrados en la base de datos.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public List<Traslado> obtenerTodosLosTraslados() throws PersistenciaException{
        EntityManager em = emf.createEntityManager();
        List<Traslado> traslados = null;
        
        try{
            em.getTransaction().begin();
            TypedQuery<Traslado> query = em.createQuery("SELECT t FROM Traslado t", Traslado.class);
            traslados = query.getResultList();
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return traslados;
    }
}
