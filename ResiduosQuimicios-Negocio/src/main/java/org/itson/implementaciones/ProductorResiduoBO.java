/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.ProductorResiduo;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iProductorResiduoBO;

/**
 * Clase que representa la lógica de negocio (BO) para la gestión de productores de residuos.
 * Implementa la interfaz iProductorResiduoBO.
 * 
 * El propósito de esta clase es proporcionar métodos para registrar y buscar información
 * relacionada con productores de residuos, interactuando con la capa de persistencia.
 * 
 * El objeto FachadaPersistencia se utiliza para la interacción con la capa de persistencia.
 * Se manejan excepciones específicas (BOException) para encapsular posibles errores durante
 * las operaciones de negocio.
 */
public class ProductorResiduoBO implements iProductorResiduoBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public ProductorResiduoBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra un nuevo productor de residuos.
     * 
     * @param productorResiduoRegistrar El objeto ProductorResiduo que se registrará.
     * @return El ProductorResiduo registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public ProductorResiduo registrar(ProductorResiduo productorResiduoRegistrar) throws BOException {
        try {
            // Valida el ProductorResiduo antes del registro
            this.validarRegistrarProductorResiduo(productorResiduoRegistrar);
            
            // Registra el ProductorResiduo utilizando la capa de persistencia
            return persistencia.registrar(productorResiduoRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca un productor de residuos por su ID.
     * 
     * @param idProductorResiduo El ID del productor de residuos a buscar.
     * @return El ProductorResiduo encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     tanto PersistenciaException como ValidacionesException.
     */
    public ProductorResiduo buscar(int idProductorResiduo) throws BOException {
        try {
            // Valida el ID antes de buscar el ProductorResiduo
            this.validarBuscarProductorResiduo(idProductorResiduo);
            
            // Busca el ProductorResiduo utilizando la capa de persistencia
            return persistencia.buscarProductorResiduo(idProductorResiduo);
        } catch (PersistenciaException | ValidacionesException e) {
            // Propaga PersistenciaException o ValidacionesException como BOException
            throw new BOException(e.getMessage(), e);
        }
    }

    /**
     * Valida el objeto ProductorResiduo antes del registro.
     * 
     * @param productorResiduoValidar El objeto ProductorResiduo a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el objeto ProductorResiduo
     *                              es nulo o carece de información necesaria.
     */
    private void validarRegistrarProductorResiduo(ProductorResiduo productorResiduoValidar) throws ValidacionesException {
        if (productorResiduoValidar == null) {
            throw new ValidacionesException("ProductorResiduo a insertar es nulo / No hay información");
        }
    }

    /**
     * Valida el ID del ProductorResiduo antes de la búsqueda.
     * 
     * @param productorResiduoValidar El ID del ProductorResiduo a validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID es menor o igual a 0.
     */
    private void validarBuscarProductorResiduo(int productorResiduoValidar) throws ValidacionesException {
        if (productorResiduoValidar <= 0) {
            throw new ValidacionesException("ID de productor residuo es menor o igual a 0");
        }
    }
}
