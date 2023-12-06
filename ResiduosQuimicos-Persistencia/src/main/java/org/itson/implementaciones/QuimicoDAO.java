/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.Quimico;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iQuimico;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iQuimico y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad Quimico.
 */
public class QuimicoDAO implements iQuimico {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de Entity Manager.
     */
    public QuimicoDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra un nuevo Quimico en la base de datos.
     *
     * @param quimicoRegistrar El Quimico a registrar.
     * @return El Quimico registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Quimico registrar(Quimico quimicoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(quimicoRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return quimicoRegistrar;
    }

    /**
     * Busca un Quimico en la base de datos por su identificador.
     *
     * @param idQuimico El identificador del Quimico a buscar.
     * @return El Quimico encontrado o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Quimico buscar(int idQuimico) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        Quimico quimicoBuscar = null;

        try {
            em.getTransaction().begin();
            quimicoBuscar = em.find(Quimico.class, idQuimico);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return quimicoBuscar;
    }
}
