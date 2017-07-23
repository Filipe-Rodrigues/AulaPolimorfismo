/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author filip
 */
public class NavegacaoEvent {
    private String linhaDeComando;
    
    public NavegacaoEvent (String linhaDeComando) {
        this.linhaDeComando = linhaDeComando;
    }
    
    public String getLinhaDeComando () {
        return linhaDeComando;
    }
}
