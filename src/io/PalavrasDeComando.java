package io;
import java.util.List;
/**
 * Classe PalavrasDeComando - Controla as palavras válidas dos comandos.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela tem como função de verificar se uma palavra dada é um comando.
 *
 * @author  Raydson Ferreira Carlota
 * @version 2017.06.08
 */

public class PalavrasDeComando {
    // um vetor constante que guarda todas as palavras de comandos validas
    private String[] comandosValidos;

    /**
     * Construtor - inicializa as palavras de comando.
     * 
     * @param palavras Lista de String com as palavras válidas do jogo; 
     */
    public PalavrasDeComando(List<String> palavras) {
        this.comandosValidos = palavras.toArray(new String[palavras.size()]);
    }

    /**
     * Metodo ehComando.
     * 
     * Verifica se uma dada String eh uma palavra de comando valida e
     * retorna true se a string dada eh um comando valido, false se nao eh.
     * 
     * @param umaString String a ser verificada
     * @return boolean se a String passada é um comando, true, se não, false.
     */
    public boolean ehComando(String umaString) {
        for(int i = 0; i < comandosValidos.length; i++) {
            if(comandosValidos[i].equals(umaString))
                return true;
        }
        return false;
    }
}