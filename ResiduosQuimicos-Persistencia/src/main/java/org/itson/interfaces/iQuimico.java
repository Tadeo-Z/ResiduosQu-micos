/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.itson.interfaces;

import org.itson.entidades.Quimico;
import org.itson.excepciones.PersistenciaException;

/**
 *
 * @author TADEO
 * Interfaz que define los métodos de persistencia para la entidad Quimico.
 */
public interface iQuimico {

    public Quimico registrar(Quimico quimicoRegistrar) throws PersistenciaException;

    public Quimico buscar(int idQuimico) throws PersistenciaException;
}
