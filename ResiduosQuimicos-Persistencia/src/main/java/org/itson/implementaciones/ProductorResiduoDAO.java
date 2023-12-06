/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.ProductorResiduo;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iProductorResiduo;

/**
 *
 * @author TADEO
 * Clase que implementa la interfaz iProductorResiduo y se encarga de realizar operaciones de persistencia
 * relacionadas con la entidad ProductorResiduo.
 */
public class ProductorResiduoDAO implements iProductorResiduo {

    /**
     * Factoría de Entity Manager para gestionar las entidades de persistencia.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de Entity Manager.
     */
    public ProductorResiduoDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra un nuevo ProductorResiduo en la base de datos.
     *
     * @param productorResiduoRegistrar El ProductorResiduo a registrar.
     * @return El ProductorResiduo registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(productorResiduoRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return productorResiduoRegistrar;
    }

    /**
     * Busca un ProductorResiduo en la base de datos por su identificador.
     *
     * @param idProductorResiduo El identificador del ProductorResiduo a buscar.
     * @return El ProductorResiduo encontrado o null si no se encuentra.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public ProductorResiduo buscar(int idProductorResiduo) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        ProductorResiduo productorResiduoBuscar = null;

        try {
            em.getTransaction().begin();
            productorResiduoBuscar = em.find(ProductorResiduo.class, idProductorResiduo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }

        return productorResiduoBuscar;
    }
}
