package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui;

/**
 * Classe NavegacaoEvent.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por navegar no jogo a partir de comandos passados
 * através de eventos, todos em linha de comando.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.21.07
 */
public class NavegacaoEvent {
    private String linhaDeComando;
    
    /**
     * Metodo responsavel por criar um objeto do tipo NavegacaoEvent
     * @param linhaDeComando  string contendo o comando
     */
    public NavegacaoEvent (String linhaDeComando) {
        this.linhaDeComando = linhaDeComando;
    }
    
    /**
     * Metodo responsavel por pegar a linha de comando
     * @return String contendo os dados da linha de comando
     */
    public String getLinhaDeComando () {
        return linhaDeComando;
    }
}
