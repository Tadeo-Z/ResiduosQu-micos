/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.Productor;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iProductor;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iProductor y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad Productor.
 */
public class ProductorDAO implements iProductor {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de Entity Manager.
     */
    public ProductorDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra un nuevo Productor en la base de datos.
     *
     * @param productorRegistrar El Productor a registrar.
     * @return El Productor registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Productor registrar(Productor productorRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(productorRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return productorRegistrar;
    }

    /**
     * Actualiza la información de un Productor en la base de datos.
     *
     * @param productorActualizar El Productor con la información actualizada.
     * @return El Productor actualizado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Productor actualizar(Productor productorActualizar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(productorActualizar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return productorActualizar;
    }

    /**
     * Busca un Productor en la base de datos por su identificador.
     *
     * @param idProductor El identificador del Productor a buscar.
     * @return El Productor encontrado o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Productor buscar(int idProductor) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        Productor productorBuscar = null;

        try {
            em.getTransaction().begin();
            productorBuscar = em.find(Productor.class, idProductor);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return productorBuscar;
    }
}
