/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.excepciones;

/**
 *
 * @author TADEO
 */
/**
 * Excepción personalizada para manejar errores relacionados con validaciones.
 * Puede ser utilizada para representar situaciones donde las validaciones de datos fallan.
 */
public class ValidacionesException extends Exception {

    /**
     * Constructor predeterminado de la excepción sin mensaje.
     */
    public ValidacionesException() {
    }

    /**
     * Constructor que acepta un mensaje descriptivo para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     */
    public ValidacionesException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta un mensaje descriptivo y una causa subyacente para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     * @param cause Causa subyacente de la excepción.
     */
    public ValidacionesException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
