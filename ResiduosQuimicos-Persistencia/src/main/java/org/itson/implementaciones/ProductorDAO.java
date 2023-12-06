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
 */
public class ProductorDAO implements iProductor{

    EntityManagerFactory emf;
    
    public ProductorDAO(){
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public Productor registrar(Productor productorRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(productorRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return productorRegistrar;
    }

    @Override
    public Productor actualizar(Productor productorActualizar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(productorActualizar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return productorActualizar;
    }
    
}
