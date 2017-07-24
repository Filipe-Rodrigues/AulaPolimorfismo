package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io;

/**
 * Classe Saida - Controla operações de saída de dados.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * A implementação dessa classe tem como objetivo portabilizar o mecanismo de
 * escrita de dados do jogo, de maneira que se quiser colocá-la em um ambiente
 * diferente do console padrão do Java, apenas essa classe deverá ser alterada.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Saida implements SaidaDeJogoListener {

    /**
     * Método construtor da classe.
     *
     */
    public Saida () {
    }
    
    /**
     * Metodo imprimir.
     * 
     * implementacao da classe {@link SaidaDeJogoListener}
     *
     * @param sentenca String com a sentença a ser impressa.
     */
    @Override
    public void imprimir (String sentenca) {
        System.out.print(sentenca);
    }
    
    /**
     * Metodo imprimirLinha.
     * 
     * implementacao da classe {@link SaidaDeJogoListener}
     * 
     * @param sentenca String com a sentença a ser impressa.
     */
    @Override
    public void imprimirLinha (String sentenca) {
    	System.out.println(sentenca);
    }

}