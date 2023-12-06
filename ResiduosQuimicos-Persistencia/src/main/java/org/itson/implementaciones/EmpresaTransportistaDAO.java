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
 */
public class EmpresaTransportistaDAO implements iEmpresaTransportista{

    EntityManagerFactory emf;
    
    public EmpresaTransportistaDAO(){
        this.emf = Conexion.getConexion();
    }
    
    @Override
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException {
        EntityManager em = emf.createEntityManager();
        
        try{
            em.getTransaction().begin();
            em.persist(empresaTransportistaRegistrar);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return empresaTransportistaRegistrar;
    }
    
    public EmpresaTransportista buscar(int idEmpresaTransportista) throws PersistenciaException{
        EntityManager em = emf.createEntityManager();
        EmpresaTransportista empresaTransportistaBuscar = null;
        
        try{
            em.getTransaction().begin();
            empresaTransportistaBuscar = em.find(EmpresaTransportista.class, idEmpresaTransportista);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }
        
        return empresaTransportistaBuscar;
    }
    
}
