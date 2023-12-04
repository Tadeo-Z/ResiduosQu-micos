/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.itson.conexion.Conexion;
import org.itson.entidades.Transporte;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iTransporte;

/**
 *
 * @author TADEO
 */
public class TransporteDAO implements iTransporte{

    EntityManagerFactory emf;
    
    public TransporteDAO(){
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public Transporte registrar(Transporte transporteRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(transporteRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return transporteRegistrar;
    }
    
}
