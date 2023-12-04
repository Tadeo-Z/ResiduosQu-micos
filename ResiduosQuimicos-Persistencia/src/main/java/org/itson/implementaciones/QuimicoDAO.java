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
 */
public class QuimicoDAO implements iQuimico{

    EntityManagerFactory emf;
    
    public QuimicoDAO(){
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public Quimico registrar(Quimico quimicoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(quimicoRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return quimicoRegistrar;
    }
    
}
