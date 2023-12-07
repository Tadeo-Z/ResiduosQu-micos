/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
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

/**
 *
 * @author TADEO
 * Interfaz que define los métodos de persistencia para la fachada de persistencia.
 */
public interface iFachadaPersistencia {

    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException;

    public EmpresaTransportista buscarEmpresaTransportista(int idEmpresaTransportista) throws PersistenciaException;

    public Productor registrar(Productor productorRegistrar) throws PersistenciaException;

    public Productor actualizar(Productor productorActualizar) throws PersistenciaException;

    public Productor buscarProductor(int idProductor) throws PersistenciaException;

    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws PersistenciaException;

    public ProductorResiduo buscarProductorResiduo(int idProductorResiduo) throws PersistenciaException;

    public Quimico registrar(Quimico quimicoRegistrar) throws PersistenciaException;

    public Quimico buscarQuimico(int idQuimico) throws PersistenciaException;

    public List<Quimico> obtenerTodosLosQuimicos() throws PersistenciaException;
    
    public Residuo registrar(Residuo residuoRegistrar) throws PersistenciaException;

    public Residuo buscarResiduo(int idResiduo) throws PersistenciaException;

    public List<Residuo> obtenerTodosLosResiduos() throws PersistenciaException;
    
    public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws PersistenciaException;

    public ResiduoSolicitud buscarResiduoSolicitud(int idResiduoSolicitud) throws PersistenciaException;

    public Solicitud registrar(Solicitud solicitudRegistrar) throws PersistenciaException;

    public Solicitud buscarSolicitud(int idSolicitud) throws PersistenciaException;

    public List<Solicitud> obtenerTodasLasSolicitudes() throws PersistenciaException;
    
    public Transporte registrar(Transporte transporteRegistrar) throws PersistenciaException;

    public Transporte buscarTransporte(int idTransporte) throws PersistenciaException;

    public Traslado registrar(Traslado trasladoRegistrar) throws PersistenciaException;

    public Traslado buscarTraslado(int idTraslado) throws PersistenciaException;
    
    public List<Traslado> obtenerTodosLosTraslados() throws PersistenciaException;
}
