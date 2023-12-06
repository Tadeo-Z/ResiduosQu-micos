/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.Transporte;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iTransporte;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iTransporte y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad Transporte.
 */
public class TransporteDAO implements iTransporte {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de Entity Manager.
     */
    public TransporteDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra un nuevo Transporte en la base de datos.
     *
     * @param transporteRegistrar El Transporte a registrar.
     * @return El Transporte registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Transporte registrar(Transporte transporteRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(transporteRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return transporteRegistrar;
    }

    /**
     * Busca un Transporte en la base de datos por su identificador.
     *
     * @param idTransporte El identificador del Transporte a buscar.
     * @return El Transporte encontrado o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Transporte buscar(int idTransporte) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        Transporte transporteBuscar = null;

        try {
            em.getTransaction().begin();
            transporteBuscar = em.find(Transporte.class, idTransporte);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return transporteBuscar;
    }
}
