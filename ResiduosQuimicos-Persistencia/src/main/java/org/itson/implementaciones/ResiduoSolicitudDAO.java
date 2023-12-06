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
 */
public class ResiduoSolicitudDAO implements iResiduoSolicitud{

    EntityManagerFactory emf;
    
    public ResiduoSolicitudDAO(){
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(residuoSolicitudRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return residuoSolicitudRegistrar;
    }
    
    public ResiduoSolicitud buscar(int idResiduoSolicitud) throws PersistenciaException{
        EntityManager em = emf.createEntityManager();
        ResiduoSolicitud residuoSolicitudBuscar = null;
        
        try{
            em.getTransaction().begin();
            residuoSolicitudBuscar = em.find(ResiduoSolicitud.class, idResiduoSolicitud);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return residuoSolicitudBuscar;
    }
    
}
