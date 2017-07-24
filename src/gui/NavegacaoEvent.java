package gui;

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
    
    public NavegacaoEvent (String linhaDeComando) {
        this.linhaDeComando = linhaDeComando;
    }
    
    public String getLinhaDeComando () {
        return linhaDeComando;
    }
}
