/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.excepciones;

/**
 *
 * @author TADEO
 * Excepción personalizada para manejar errores relacionados con la persistencia.
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor predeterminado.
     */
    public PersistenciaException() {
        // Llama al constructor de la clase base (Exception) sin argumentos.
    }

    /**
     * Constructor que acepta un mensaje descriptivo del error.
     *
     * @param message Mensaje descriptivo del error.
     */
    public PersistenciaException(String message) {
        // Llama al constructor de la clase base (Exception) con el mensaje proporcionado.
        super(message);
    }

    /**
     * Constructor que acepta un mensaje descriptivo y una causa del error.
     *
     * @param message Mensaje descriptivo del error.
     * @param cause   Causa del error.
     */
    public PersistenciaException(String message, Throwable cause) {
        // Llama al constructor de la clase base (Exception) con el mensaje y la causa proporcionados.
        super(message, cause);
    }
}
