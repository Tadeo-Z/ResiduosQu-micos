/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.implementaciones;

import org.itson.entidades.EmpresaTransportista;
import org.itson.excepciones.BOException;
import org.itson.excepciones.PersistenciaException;
import org.itson.excepciones.ValidacionesException;
import org.itson.interfaces.iEmpresaTransportistaBO;

/**
 *
 * @author TADEO
 *
 * Clase que representa la lógica de negocio (BO) para la gestión de empresas
 * transportistas. Implementa la interfaz iEmpresaTransportistaBO.
 */
public class EmpresaTransportistaBO implements iEmpresaTransportistaBO {

    /**
     * Objeto de la clase FachadaPersistencia utilizado para interactuar con la
     * capa de persistencia.
     */
    FachadaPersistencia persistencia;

    /**
     * Constructor predeterminado que inicializa el objeto FachadaPersistencia.
     */
    public EmpresaTransportistaBO() {
        persistencia = new FachadaPersistencia();
    }

    /**
     * Registra una nueva EmpresaTransportista.
     *
     * @param empresaTransportistaRegistrar El objeto EmpresaTransportista que
     * se registrará.
     * @return La EmpresaTransportista registrada.
     * @throws BOException Si hay un problema durante el proceso de registro,
     * encapsulando tanto PersistenciaException como ValidacionesException.
     */
    @Override
    public EmpresaTransportista registrar(EmpresaTransportista empresaTransportistaRegistrar) throws BOException {
        try {
            // Valida la EmpresaTransportista antes del registro
            this.validarRegistrarEmpresaTransportista(empresaTransportistaRegistrar);

            // Registra la EmpresaTransportista utilizando la capa de persistencia
            return persistencia.registrar(empresaTransportistaRegistrar);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Busca una EmpresaTransportista según el ID proporcionado.
     *
     * @param idEmpresaTransportista El ID de la EmpresaTransportista a buscar.
     * @return La EmpresaTransportista encontrada.
     * @throws BOException Si hay un problema durante el proceso de búsqueda,
     * encapsulando tanto PersistenciaException como ValidacionesException.
     */
    public EmpresaTransportista buscar(int idEmpresaTransportista) throws BOException {
        try {
            // Valida el ID antes de buscar la EmpresaTransportista
            this.validarBuscarEmpresaTransportista(idEmpresaTransportista);

            // Busca la EmpresaTransportista utilizando la capa de persistencia
            return persistencia.buscarEmpresaTransportista(idEmpresaTransportista);
        } catch (PersistenciaException e) {
            // Propaga PersistenciaException como BOException
            throw new BOException(e.getMessage(), e);
        } catch (ValidacionesException a) {
            // Propaga ValidacionesException como BOException
            throw new BOException(a.getMessage(), a);
        }
    }

    /**
     * Valida el objeto EmpresaTransportista antes del registro.
     *
     * @param empresaTransportistaValidar El objeto EmpresaTransportista a
     * validar.
     * @throws ValidacionesException Si la validación falla, indicando que el
     * objeto EmpresaTransportista es nulo o carece de información necesaria.
     */
    private void validarRegistrarEmpresaTransportista(EmpresaTransportista empresaTransportistaValidar) throws ValidacionesException {
        if (empresaTransportistaValidar == null) {
            throw new ValidacionesException("Empresa transportista a insertar es nulo / No hay información");
        }
    }

    /**
     * Valida el ID de la EmpresaTransportista antes de la búsqueda.
     *
     * @param empresaTransportistaValidar El ID de la EmpresaTransportista a
     * validar.
     * @throws ValidacionesException Si la validación falla, indicando que el ID
     * es menor o igual a 0.
     */
    private void validarBuscarEmpresaTransportista(int empresaTransportistaValidar) throws ValidacionesException {
        if (empresaTransportistaValidar <= 0) {
            throw new ValidacionesException("ID de la empresa transportista es menor o igual a 0");
        }
    }
}
