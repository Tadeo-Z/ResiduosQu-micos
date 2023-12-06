/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Transporte;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 *
 * Interfaz que define los métodos de persistencia para la entidad Transporte.
 */
public interface iTransporte {

    public Transporte registrar(Transporte transporteRegistrar) throws PersistenciaException;

    public Transporte buscar(int idTransporte) throws PersistenciaException;
}
