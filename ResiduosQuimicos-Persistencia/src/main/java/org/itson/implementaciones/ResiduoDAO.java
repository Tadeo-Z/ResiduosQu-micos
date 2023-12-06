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
 */
public class ResiduoDAO implements iResiduo{
    
    EntityManagerFactory emf;

    public ResiduoDAO(){
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public Residuo registrar(Residuo residuoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(residuoRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return residuoRegistrar;
    }
    
    public Residuo buscar(int idResiduo) throws PersistenciaException{
        EntityManager em = emf.createEntityManager();
        Residuo residuoBuscar = null;
        
        try{
            em.getTransaction().begin();
            residuoBuscar = em.find(Residuo.class, idResiduo);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return residuoBuscar;
    }
}
