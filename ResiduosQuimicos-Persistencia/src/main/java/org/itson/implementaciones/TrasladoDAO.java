/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.entidades.Traslado;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iTraslado;

/**
 *
 * @author TADEO
 */
public class TrasladoDAO implements iTraslado{

    EntityManagerFactory emf;
    
    @Override
    public Traslado registrar(Traslado trasladoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(trasladoRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return trasladoRegistrar;
    }
    
}
