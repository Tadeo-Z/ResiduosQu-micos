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
 */
public class ProductorResiduoDAO implements iProductorResiduo{

    EntityManagerFactory emf;
    
    public ProductorResiduoDAO(){
        this.emf = Conexion.getConexion();
    }
    @Override
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(productorResiduoRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return productorResiduoRegistrar;
    }
    
    public ProductorResiduo buscar(int idProductorResiduo) throws PersistenciaException{
        EntityManager em = emf.createEntityManager();
        ProductorResiduo productorResiduoBuscar = null;
        
        try{
            em.getTransaction().begin();
            productorResiduoBuscar = em.find(ProductorResiduo.class, idProductorResiduo);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return productorResiduoBuscar;
    }
    
}
