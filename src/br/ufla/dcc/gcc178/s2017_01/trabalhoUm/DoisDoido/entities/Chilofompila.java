package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import java.util.ArrayList;

/**
 * Classe Chilofompila.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por guardar objetos do tipo chilofompila, com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Chilofompila extends NPC {
    
     /**
     * Construtor da classe Chilofompila.
     */
    public Chilofompila() {
    	super("Chilofompila", -1, 0, null, new ArrayList<>(), false, true);
        Efeito san = new AlteracaoDeSanidade("Subtrair Sanidade", "Retira 2 pontos de Sanidade.", -2);
        ArrayList<Efeito> umEfeito = new ArrayList<>();
        umEfeito.add(san);
        Habilidade hab = new Habilidade("Alucinação"
        		, "Meu Deus, mas o que é esse ser?? Não sei, mas ele quer me matar!"
        		, umEfeito);
        super.setHabilidade(hab);
    }
    
    /**
     * Metodo mensagemConversa.
     * 
     * Metodo implementado da Classe {@link Ator}, funciona como dialogo do 
     * ator principal com Chilofompila.
     * 
     * @return String com uma mensagem de conversa entre a Chilofompila e César.
     */
    @Override
    public String mensagemConversa() {
    	return "EI CÉSAR, OLHA PRA MIM SUA BESTA!\n"
    			+ "Dois navios estavam sobrevoando.\n"
    			+ "Um deles caiu e furou o pneu...\n"
    			+ "QUANTAS ABÓBORAS SOBRARAM??????\n"
			+ "    .\n"
			+ "    .\n"
			+ "    .\n"
			+ "Nenhuma, porque gato não tem antena! MWAHAHAHAHAHAHAHA";
    }
    
    /**
     * Metodo entregarItemDeQuest.
     * 
     * Metodo implementado da Classe {@link NPC}.
     * 
     * @return {@link Item} null pois não há nenhum item a ser dado a Cesar.
     */
    @Override
    public Item entregarItemDeQuest() {
        return null;
    }

    /**
     * Metodo responsavel por retornar a quantidade maxima de Hp's
     * @return inteiro contendo o valor do HPMaximo
     */
    @Override
    public int getHPMaximo() {
        return -1;
    }
}
