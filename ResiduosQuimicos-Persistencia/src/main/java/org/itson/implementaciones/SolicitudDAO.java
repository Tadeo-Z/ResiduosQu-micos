/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.Solicitud;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iSolicitud;

/**
 *
 * @author TADEO
 */
public class SolicitudDAO implements iSolicitud{

    EntityManagerFactory emf;
    
    public SolicitudDAO(){
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public Solicitud registrar(Solicitud solicitudRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(solicitudRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return solicitudRegistrar;
    }
    
    public Solicitud buscar(int idSolicitud) throws PersistenciaException{
        EntityManager em = emf.createEntityManager();
        Solicitud solicitudBuscar = null;
        
        try{
            em.getTransaction().begin();
            solicitudBuscar = em.find(Solicitud.class, idSolicitud);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return solicitudBuscar;
    }
    
}
