/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.itson.excepciones;

/**
 *
 * @author TADEO
 */
public class BOException extends Exception{

    /**
     * Constructor predeterminado de la excepción sin mensaje.
     */
    public BOException() {
    }

    /**
     * Constructor que acepta un mensaje descriptivo para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     */
    public BOException(String message) {
        super(message);
    }

    /**
     * Constructor que acepta un mensaje descriptivo y una causa subyacente para la excepción.
     *
     * @param message Mensaje descriptivo de la excepción.
     * @param cause Causa subyacente de la excepción.
     */
    public BOException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
