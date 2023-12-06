/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Residuo;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 * Interfaz que define los métodos de persistencia para la entidad Residuo.
 */
public interface iResiduo {

    public Residuo registrar(Residuo residuoRegistrar) throws PersistenciaException;

    public Residuo buscar(int idResiduo) throws PersistenciaException;
}
