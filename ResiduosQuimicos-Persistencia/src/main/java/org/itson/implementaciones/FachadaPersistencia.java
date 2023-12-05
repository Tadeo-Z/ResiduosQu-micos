/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.EmpresaTransportista;
import org.itson.entidades.Productor;
import org.itson.entidades.ProductorResiduo;
import org.itson.entidades.Quimico;
import org.itson.entidades.Residuo;
import org.itson.entidades.ResiduoSolicitud;
import org.itson.entidades.Solicitud;
import org.itson.entidades.Transporte;
import org.itson.entidades.Traslado;
import org.itson.excepciones.PersistenciaException;
import org.itson.interfaces.iEmpresaTransportista;
import org.itson.interfaces.iFachadaPersistencia;

/**
 *
 * @author TADEO
 */
public class FachadaPersistencia implements iFachadaPersistencia{

    private EmpresaTransportistaDAO empresaTransportistaDAO;
    private ProductorDAO productorDAO;
    private ProductorResiduoDAO productorResiduoDAO;
    private QuimicoDAO quimicoDAO;
    private ResiduoDAO residuoDAO;
    private ResiduoSolicitudDAO residuoSolicitudDAO;
    private SolicitudDAO solicitudDAO;
    private TransporteDAO transporteDAO;
    private TrasladoDAO trasladoDAO;

    public FachadaPersistencia(){}
    
    public FachadaPersistencia(EmpresaTransportistaDAO empresaTransportistaDAO, ProductorDAO productorDAO, ProductorResiduoDAO productorResiduoDAO, QuimicoDAO quimicoDAO, ResiduoDAO residuoDAO, ResiduoSolicitudDAO residuoSolicitudDAO, SolicitudDAO solicitudDAO, TransporteDAO transporteDAO, TrasladoDAO trasladoDAO) {
        this.empresaTransportistaDAO = empresaTransportistaDAO;
        this.productorDAO = productorDAO;
        this.productorResiduoDAO = productorResiduoDAO;
        this.quimicoDAO = quimicoDAO;
        this.residuoDAO = residuoDAO;
        this.residuoSolicitudDAO = residuoSolicitudDAO;
        this.solicitudDAO = solicitudDAO;
        this.transporteDAO = transporteDAO;
        this.trasladoDAO = trasladoDAO;
    }
    
    @Override
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException {
        try{
            empresaTransportistaDAO.registrar(empresaTransportistaRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return empresaTransportistaRegistrar;
    }

    @Override
    public Productor registrar(Productor productorRegistrar) throws PersistenciaException {
        try{
            productorDAO.registrar(productorRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return productorRegistrar;
    }

    @Override
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws PersistenciaException {
        try{
            productorResiduoDAO.registrar(productorResiduoRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return productorResiduoRegistrar;
    }

    @Override
    public Quimico registrar(Quimico quimicoRegistrar) throws PersistenciaException {
        try{
            quimicoDAO.registrar(quimicoRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return quimicoRegistrar;
    }

    @Override
    public Residuo registrar(Residuo residuoRegistrar) throws PersistenciaException {
        try{
            residuoDAO.registrar(residuoRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return residuoRegistrar;
    }

    @Override
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws PersistenciaException {
        try{
            residuoSolicitudDAO.registrar(residuoSolicitudRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return residuoSolicitudRegistrar;
    }

    @Override
    public Solicitud registrar(Solicitud solicitudRegistrar) throws PersistenciaException {
        try{
            solicitudDAO.registrar(solicitudRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return solicitudRegistrar;
    }

    @Override
    public Transporte registrar(Transporte transporteRegistrar) throws PersistenciaException {
        try{
            transporteDAO.registrar(transporteRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return transporteRegistrar;
    }

    @Override
    public Traslado registrar(Traslado trasladoRegistrar) throws PersistenciaException {
        try{
            trasladoDAO.registrar(trasladoRegistrar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return trasladoRegistrar;
    }
    
}
