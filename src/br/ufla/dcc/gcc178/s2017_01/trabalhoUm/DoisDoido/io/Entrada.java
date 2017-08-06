package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io;
import java.io.Serializable;
import java.util.Scanner;
import java.util.List;

/**
 * Classe Entrada - Controla operações de entrada de dados.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela tem como função ler entrada de usuarios, que servirão como comando 
 * para que o player possa controlar o seu personagem através de comandos.
 * 
 * @author  Raydson Ferreira Carlota
 * @version 2017.06.08
 */
public class Entrada implements Serializable{
    private static final long serialVersionUID = 1L;
    private PalavrasDeComando palavrasDeComando;
    private transient Scanner tokenizer;
    
    /**
     * Construtor da classe Efeito
     * 
     * @param palavras Lista de String com as palavras válidas do jogo; 
     */
    public Entrada(List<String> palavras){
        palavrasDeComando = new PalavrasDeComando(palavras);
    }
    
    /**
     * Metodo para pegar um comando.
     * 
     * Pega um comando do usuario, divide em duas palavras, e cria 
     * um objeto do tipo {@link Comando} e o retorna.
     * 
     * @return {@link Comando} o comando que uma pessoa for realizar.
     */
    public Comando pegarComando(String linha) throws FormatoDeComandoException {
        String palavra1 = null;
        String palavra2 = null;
        
        int numPalavras = linha.split(" ").length;
        if (numPalavras > 2) {
            throw new FormatoDeComandoException(numPalavras);
        }
        
        tokenizer = new Scanner(linha);
        if(tokenizer.hasNext()) {
            palavra1 = tokenizer.next();
            if(tokenizer.hasNext()) {
                palavra2 = tokenizer.next();
            }
        }
        
        if(palavrasDeComando.ehComando(palavra1)) {
            return new Comando(palavra1, palavra2);
        }
        else {
            return new Comando(null, palavra2); 
        }
    }
}