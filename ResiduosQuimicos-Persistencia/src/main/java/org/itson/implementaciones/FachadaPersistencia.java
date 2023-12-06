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
 * Clase que implementa la interfaz iFachadaPersistencia y actúa como fachada para interactuar con las clases DAO.
 * La fachada proporciona métodos para realizar operaciones CRUD en las entidades del sistema.
 * 
 * @author TADEO
 */
public class FachadaPersistencia implements iFachadaPersistencia {

    // Instancias de las interfaces DAO para las entidades del sistema
    private iEmpresaTransportista empresaTransportistaDAO = new EmpresaTransportistaDAO();
    private iProductor productorDAO = new ProductorDAO();
    private iProductorResiduo productorResiduoDAO = new ProductorResiduoDAO();
    private iQuimico quimicoDAO = new QuimicoDAO();
    private iResiduo residuoDAO = new ResiduoDAO();
    private iResiduoSolicitud residuoSolicitudDAO = new ResiduoSolicitudDAO();
    private iSolicitud solicitudDAO = new SolicitudDAO();
    private iTransporte transporteDAO = new TransporteDAO();
    private iTraslado trasladoDAO = new TrasladoDAO();

    /**
     * Constructor por defecto que inicializa las instancias de las interfaces DAO con las implementaciones por defecto.
     */
    public FachadaPersistencia() {}

    /**
     * Constructor que permite inyectar instancias específicas de las interfaces DAO.
     * Útil para la inyección de dependencias en pruebas unitarias.
     *
     * @param empresaTransportistaDAO      Instancia de la interfaz iEmpresaTransportista para DAO de EmpresaTransportista.
     * @param productorDAO                 Instancia de la interfaz iProductor para DAO de Productor.
     * @param productorResiduoDAO          Instancia de la interfaz iProductorResiduo para DAO de ProductorResiduo.
     * @param quimicoDAO                   Instancia de la interfaz iQuimico para DAO de Quimico.
     * @param residuoDAO                   Instancia de la interfaz iResiduo para DAO de Residuo.
     * @param residuoSolicitudDAO          Instancia de la interfaz iResiduoSolicitud para DAO de ResiduoSolicitud.
     * @param solicitudDAO                 Instancia de la interfaz iSolicitud para DAO de Solicitud.
     * @param transporteDAO                Instancia de la interfaz iTransporte para DAO de Transporte.
     * @param trasladoDAO                  Instancia de la interfaz iTraslado para DAO de Traslado.
     */
    public FachadaPersistencia(
            iEmpresaTransportista empresaTransportistaDAO, iProductor productorDAO,
            iProductorResiduo productorResiduoDAO, iQuimico quimicoDAO,
            iResiduo residuoDAO, iResiduoSolicitud residuoSolicitudDAO,
            iSolicitud solicitudDAO, iTransporte transporteDAO,
            iTraslado trasladoDAO) {
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
    
   /**
     * Registra una nueva EmpresaTransportista en la base de datos.
     *
     * @param empresaTransportistaRegistrar La EmpresaTransportista a registrar.
     * @return La EmpresaTransportista registrada.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws PersistenciaException {
        try {
            empresaTransportistaDAO.registrar(empresaTransportistaRegistrar);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }

        return empresaTransportistaRegistrar;
    }

    /**
     * Busca una EmpresaTransportista en la base de datos por su identificador.
     *
     * @param idEmpresaTransportista El identificador de la EmpresaTransportista a buscar.
     * @return La EmpresaTransportista encontrada.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public EmpresaTransportista buscarEmpresaTransportista(int idEmpresaTransportista) throws PersistenciaException {
        try {
            empresaTransportistaDAO.buscar(idEmpresaTransportista);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }

        return empresaTransportistaDAO.buscar(idEmpresaTransportista);
    }

    /**
     * Registra un nuevo Productor en la base de datos.
     *
     * @param productorRegistrar El Productor a registrar.
     * @return El Productor registrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    @Override
    public Productor registrar(Productor productorRegistrar) throws PersistenciaException {
        try {
            productorDAO.registrar(productorRegistrar);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }

        return productorRegistrar;
    }

    /**
     * Actualiza un Productor en la base de datos.
     *
     * @param productorActualizar El Productor actualizado.
     * @return El Productor actualizado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Productor actualizar(Productor productorActualizar) throws PersistenciaException {
        try {
            productorDAO.actualizar(productorActualizar);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }

        return productorActualizar;
    }

    /**
     * Busca un Productor en la base de datos por su identificador.
     *
     * @param idProductor El identificador del Productor a buscar.
     * @return El Productor encontrado.
     * @throws PersistenciaException Si hay un error en la capa de persistencia.
     */
    public Productor buscarProductor(int idProductor) throws PersistenciaException {
        try {
            productorDAO.buscar(idProductor);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }

        return productorDAO.buscar(idProductor);
    }

    /**
 * Registra un nuevo ProductorResiduo en la base de datos.
 *
 * @param productorResiduoRegistrar El ProductorResiduo a registrar.
 * @return El ProductorResiduo registrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
@Override
public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws PersistenciaException {
    try {
        productorResiduoDAO.registrar(productorResiduoRegistrar);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return productorResiduoRegistrar;
}

/**
 * Busca un ProductorResiduo en la base de datos por su identificador.
 *
 * @param idProductorResiduo El identificador del ProductorResiduo a buscar.
 * @return El ProductorResiduo encontrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
public ProductorResiduo buscarProductorResiduo(int idProductorResiduo) throws PersistenciaException {
    try {
        productorResiduoDAO.buscar(idProductorResiduo);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return productorResiduoDAO.buscar(idProductorResiduo);
}

/**
 * Registra un nuevo Quimico en la base de datos.
 *
 * @param quimicoRegistrar El Quimico a registrar.
 * @return El Quimico registrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
@Override
public Quimico registrar(Quimico quimicoRegistrar) throws PersistenciaException {
    try {
        quimicoDAO.registrar(quimicoRegistrar);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return quimicoRegistrar;
}

/**
 * Busca un Quimico en la base de datos por su identificador.
 *
 * @param idQuimico El identificador del Quimico a buscar.
 * @return El Quimico encontrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
public Quimico buscarQuimico(int idQuimico) throws PersistenciaException {
    try {
        quimicoDAO.buscar(idQuimico);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return quimicoDAO.buscar(idQuimico);
}

/**
 * Registra un nuevo Residuo en la base de datos.
 *
 * @param residuoRegistrar El Residuo a registrar.
 * @return El Residuo registrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
@Override
public Residuo registrar(Residuo residuoRegistrar) throws PersistenciaException {
    try {
        residuoDAO.registrar(residuoRegistrar);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return residuoRegistrar;
}

/**
 * Busca un Residuo en la base de datos por su identificador.
 *
 * @param idResiduo El identificador del Residuo a buscar.
 * @return El Residuo encontrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
public Residuo buscarResiduo(int idResiduo) throws PersistenciaException {
    try {
        residuoDAO.buscar(idResiduo);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return residuoDAO.buscar(idResiduo);
}

/**
 * Registra una nueva ResiduoSolicitud en la base de datos.
 *
 * @param residuoSolicitudRegistrar La ResiduoSolicitud a registrar.
 * @return La ResiduoSolicitud registrada.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
@Override
public ResiduoSolicitud registrar(ResiduoSolicitud residuoSolicitudRegistrar) throws PersistenciaException {
    try {
        residuoSolicitudDAO.registrar(residuoSolicitudRegistrar);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return residuoSolicitudRegistrar;
}

/**
 * Busca una ResiduoSolicitud en la base de datos por su identificador.
 *
 * @param idResiduoSolicitud El identificador de la ResiduoSolicitud a buscar.
 * @return La ResiduoSolicitud encontrada.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
public ResiduoSolicitud buscarResiduoSolicitud(int idResiduoSolicitud) throws PersistenciaException {
    try {
        residuoSolicitudDAO.buscar(idResiduoSolicitud);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return residuoSolicitudDAO.buscar(idResiduoSolicitud);
}

/**
 * Registra una nueva Solicitud en la base de datos.
 *
 * @param solicitudRegistrar La Solicitud a registrar.
 * @return La Solicitud registrada.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
@Override
public Solicitud registrar(Solicitud solicitudRegistrar) throws PersistenciaException {
    try {
        solicitudDAO.registrar(solicitudRegistrar);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return solicitudRegistrar;
}

/**
 * Busca una Solicitud en la base de datos por su identificador.
 *
 * @param idSolicitud El identificador de la Solicitud a buscar.
 * @return La Solicitud encontrada.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
public Solicitud buscarSolicitud(int idSolicitud) throws PersistenciaException {
    try {
        solicitudDAO.buscar(idSolicitud);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return solicitudDAO.buscar(idSolicitud);
}

/**
 * Registra un nuevo Transporte en la base de datos.
 *
 * @param transporteRegistrar El Transporte a registrar.
 * @return El Transporte registrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
@Override
public Transporte registrar(Transporte transporteRegistrar) throws PersistenciaException {
    try {
        transporteDAO.registrar(transporteRegistrar);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return transporteRegistrar;
}

/**
 * Busca un Transporte en la base de datos por su identificador.
 *
 * @param idTransporte El identificador del Transporte a buscar.
 * @return El Transporte encontrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
public Transporte buscarTransporte(int idTransporte) throws PersistenciaException {
    try {
        transporteDAO.buscar(idTransporte);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return transporteDAO.buscar(idTransporte);
}

/**
 * Registra un nuevo Traslado en la base de datos.
 *
 * @param trasladoRegistrar El Traslado a registrar.
 * @return El Traslado registrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
@Override
public Traslado registrar(Traslado trasladoRegistrar) throws PersistenciaException {
    try {
        trasladoDAO.registrar(trasladoRegistrar);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return trasladoRegistrar;
}

/**
 * Busca un Traslado en la base de datos por su identificador.
 *
 * @param idTraslado El identificador del Traslado a buscar.
 * @return El Traslado encontrado.
 * @throws PersistenciaException Si hay un error en la capa de persistencia.
 */
public Traslado buscarTraslado(int idTraslado) throws PersistenciaException {
    try {
        trasladoDAO.buscar(idTraslado);
    } catch (PersistenciaException e) {
        throw new PersistenciaException(e.getMessage());
    }

    return trasladoDAO.buscar(idTraslado);
}
}

