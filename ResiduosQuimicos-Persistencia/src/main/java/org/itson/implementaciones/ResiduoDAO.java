/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.Residuo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iResiduo;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iResiduo y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad Residuo.
 */
public class ResiduoDAO implements iResiduo {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de Entity Manager.
     */
    public ResiduoDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra un nuevo Residuo en la base de datos.
     *
     * @param residuoRegistrar El Residuo a registrar.
     * @return El Residuo registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Residuo registrar(Residuo residuoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(residuoRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return residuoRegistrar;
    }

    /**
     * Busca un Residuo en la base de datos por su identificador.
     *
     * @param idResiduo El identificador del Residuo a buscar.
     * @return El Residuo encontrado o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Residuo buscar(int idResiduo) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        Residuo residuoBuscar = null;

        try {
            em.getTransaction().begin();
            residuoBuscar = em.find(Residuo.class, idResiduo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return residuoBuscar;
    }
}
