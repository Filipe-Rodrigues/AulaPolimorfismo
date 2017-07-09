package io;
/**
 *Classe Comando - Controla os comandos do player.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela tem como função pegar e os comandos da primeira e da segunda palavra
 * através da classe {@link Entrada}. Todo comando que ocorrer no jogo passara
 * por esta classe.
 * 
 * @author  Raydson Ferreira Carlota
 * @version 2017.06.08
 */

public class Comando {
    /** Attributes */
    private String palavraDeComando;
    private String segundaPalavra;

    /**
     * Construtor da classe Comando.
     * 
     * Primeira e segunda palavra devem ser 
     * fornecidas, mas também elas podem ser null.
     *
     * @param primeiraPalavra Primeira palavra do comando.
     * @param segundaPalavra Segunda palavra do comando.
     */
     public Comando(String primeiraPalavra, String segundaPalavra) {
        this.palavraDeComando = primeiraPalavra;
        this.segundaPalavra = segundaPalavra;
    }
     
    /**
     * Metodo getPalavraDeComando
     * 
     * Retorna a palavra de comando (a primeira palavra) deste comando.
     * Se o comando nao foi entendido, o resultado eh null.
     * 
     * @return String com uma palavra de comando.
     */
     public String getPalavraDeComando() {
        return palavraDeComando;
    }
     
    /**
     * Metodo getSegundaPalavra
     * 
     * retorna  segunda palavra deste comando, Retorna null se 
     * nao existe segunda palavra.
     * 
     * @return String com a segunda palavra de um comando.
     */
    public String getSegundaPalavra() {
        return segundaPalavra;
    }
    
    /**
     * Metodo ehDesconhecido
     * 
     * retorna true se o comando nao foi entendido. 
     * 
     * @return boolean se uma palavra de comando for igual a  null, true, senao, false.
     */
    public boolean ehDesconhecido() {
        return (palavraDeComando == null);
    }
    
    /**
     * Metodo temSegundaPalavra
     * 
     * retorna true se o comando tem uma segunda palavra. 
     * 
     * @return boolean se a segunda palavra do comando for igual a null,
     * true, senao, false.
     */
    public boolean temSegundaPalavra() {
        return (segundaPalavra != null);
    }
}