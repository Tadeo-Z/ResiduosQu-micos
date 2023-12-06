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
import org.itson.interfaces.iProductor;
import org.itson.interfaces.iProductorResiduo;
import org.itson.interfaces.iQuimico;
import org.itson.interfaces.iResiduo;
import org.itson.interfaces.iResiduoSolicitud;
import org.itson.interfaces.iSolicitud;
import org.itson.interfaces.iTransporte;
import org.itson.interfaces.iTraslado;

/**
 *
 * @author TADEO
 */
public class FachadaPersistencia implements iFachadaPersistencia{

    private iEmpresaTransportista empresaTransportistaDAO = new EmpresaTransportistaDAO();
    private iProductor productorDAO = new ProductorDAO();
    private iProductorResiduo productorResiduoDAO = new ProductorResiduoDAO();
    private iQuimico quimicoDAO = new QuimicoDAO();
    private iResiduo residuoDAO = new ResiduoDAO();
    private iResiduoSolicitud residuoSolicitudDAO = new ResiduoSolicitudDAO();
    private iSolicitud solicitudDAO = new SolicitudDAO();
    private iTransporte transporteDAO = new TransporteDAO();
    private iTraslado trasladoDAO = new TrasladoDAO();

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

    public EmpresaTransportista buscarEmpresaTransportista(int idEmpresaTransportista) throws PersistenciaException{
        try{
            empresaTransportistaDAO.buscar(idEmpresaTransportista);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        return empresaTransportistaDAO.buscar(idEmpresaTransportista);
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
    
    public Productor actualizar(Productor productorActualizar) throws PersistenciaException{
        try{
            productorDAO.actualizar(productorActualizar);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return productorActualizar;
    }
    
    public Productor buscarProductor(int idProductor) throws PersistenciaException{
        try{
            productorDAO.buscar(idProductor);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return productorDAO.buscar(idProductor);
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
    
    public ProductorResiduo buscarProductorResiduo(int idProductorResiduo) throws PersistenciaException{
        try{
            productorResiduoDAO.buscar(idProductorResiduo);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return productorResiduoDAO.buscar(idProductorResiduo);
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
    
    public Quimico buscarQuimico(int idQuimico) throws PersistenciaException{
        try{
            quimicoDAO.buscar(idQuimico);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return quimicoDAO.buscar(idQuimico);
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

    public Residuo buscarResiduo(int idResiduo) throws PersistenciaException{
        try{
            residuoDAO.buscar(idResiduo);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return residuoDAO.buscar(idResiduo);
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

    public ResiduoSolicitud buscarResiduoSolicitud(int idResiduoSolicitud) throws PersistenciaException{
        try{
            residuoSolicitudDAO.buscar(idResiduoSolicitud);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return residuoSolicitudDAO.buscar(idResiduoSolicitud);
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

    public Solicitud buscarSolicitud(int idSolicitud) throws PersistenciaException{
        try{
            solicitudDAO.buscar(idSolicitud);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return solicitudDAO.buscar(idSolicitud);
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
    
    public Transporte buscarTransporte(int idTransporte) throws PersistenciaException{
        try{
            transporteDAO.buscar(idTransporte);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return transporteDAO.buscar(idTransporte);
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
    
    public Traslado buscarTraslado(int idTraslado) throws PersistenciaException{
        try{
            trasladoDAO.buscar(idTraslado);
        }catch(PersistenciaException e){
            throw new PersistenciaException(e.getMessage());
        }
        
        return trasladoDAO.buscar(idTraslado);
    }
    
}
