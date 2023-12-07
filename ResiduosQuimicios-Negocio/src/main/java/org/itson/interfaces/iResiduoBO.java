/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import java.util.List;
import org.itson.entidades.Residuo;
import org.itson.excepciones.BOException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define las operaciones de lógica de negocio (BO) para la gestión de residuos.
 * 
 * Las clases que implementen esta interfaz deben proporcionar implementaciones para registrar
 * y buscar información relacionada con residuos.
 */
public interface iResiduoBO {

    /**
     * Registra un nuevo residuo.
     * 
     * @param residuoRegistrar El Residuo que se registrará.
     * @return El Residuo registrado.
     * @throws BOException Si hay un problema durante el proceso de registro, encapsulando
     *                     posibles excepciones específicas.
     */
    public Residuo registrar(Residuo residuoRegistrar) throws BOException;

    /**
     * Busca un residuo por su ID.
     * 
     * @param idResiduo El ID del residuo a buscar.
     * @return El Residuo encontrado.
     * @throws BOException Si hay un problema durante el proceso de búsqueda, encapsulando
     *                     posibles excepciones específicas.
     */
    public Residuo buscar(int idResiduo) throws BOException;
    
    public List<Residuo> obtenerTodosLosResiduos() throws BOException;
}
