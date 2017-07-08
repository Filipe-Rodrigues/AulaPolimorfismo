/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

/**
 *
 * @author filip
 */
public class FormatoDeComandoException extends RuntimeException {

    /**
     * Creates a new instance of <code>ExcessoDeComandosException</code> without
     * detail message.
     */
    public FormatoDeComandoException() {
    }

    /**
     * Constructs an instance of <code>ExcessoDeComandosException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public FormatoDeComandoException(int numeroDeComandos) {
        super("São esperadas 1 ou 2 palavras de comando, mas foram enviadas " + numeroDeComandos + "!\n");
    }
}
