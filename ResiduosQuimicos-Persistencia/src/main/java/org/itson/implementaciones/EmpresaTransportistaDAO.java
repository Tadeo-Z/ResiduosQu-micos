/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.EmpresaTransportista;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iEmpresaTransportista;

/**
 *
 * @author TADEO
 * Esta clase implementa la interfaz iEmpresaTransportista y proporciona métodos
 * para interactuar con la entidad EmpresaTransportista en la capa de persistencia.
 */
public class EmpresaTransportistaDAO implements iEmpresaTransportista {

    /**
     * Factoría de EntityManager para gestionar instancias de EntityManager.
     */
    EntityManagerFactory emf;

    /**
     * Constructor de la clase que inicializa la factoría de EntityManager.
     */
    public EmpresaTransportistaDAO() {
        this.emf = Conexion.getConexion();
    }

    /**
     * Registra una nueva instancia de EmpresaTransportista en la base de datos.
     *
     * @param empresaTransportistaRegistrar La instancia de EmpresaTransportista a registrar.
     * @return La instancia de EmpresaTransportista registrada.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    @Override
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(empresaTransportistaRegistrar);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            // Puedes loguear o relanzar la excepción aquí si es necesario.
            throw new PersistenciaException("Error al registrar la empresa transportista", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return empresaTransportistaRegistrar;
    }

    /**
     * Busca y devuelve una instancia de EmpresaTransportista por su identificador.
     *
     * @param idEmpresaTransportista El identificador de la EmpresaTransportista a buscar.
     * @return La instancia de EmpresaTransportista encontrada o null si no se encuentra.
     * @throws PersistenciaException Si ocurre un error durante la operación de persistencia.
     */
    public EmpresaTransportista buscar(int idEmpresaTransportista) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        EmpresaTransportista empresaTransportistaBuscar = null;

        try {
            em.getTransaction().begin();
            empresaTransportistaBuscar = em.find(EmpresaTransportista.class, idEmpresaTransportista);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            // Puedes loguear o relanzar la excepción aquí si es necesario.
            throw new PersistenciaException("Error al buscar la empresa transportista", e);
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
        }

        return empresaTransportistaBuscar;
    }
}
