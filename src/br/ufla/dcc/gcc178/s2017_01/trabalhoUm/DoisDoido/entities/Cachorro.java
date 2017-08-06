package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import java.util.ArrayList;

/**
 * Classe Cachorro.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por guardar objetos do tipo cachorro, com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Cachorro extends NPC {
    
    /**
     * Construtor da classe Cachorro.
     * 
     * @param nome uma String com o nome do cachorro a ser criado.
     */
    public Cachorro(String nome) {
        super(nome, 10, 0, null, new ArrayList<>(), true, true);
        Efeito hp = new AlteracaoDeHP("Subtrair HP", "Retira 1 ponto de HP", -1);
        ArrayList<Efeito> umEfeito = new ArrayList<>();
        umEfeito.add(hp);
        Efeito san = new AlteracaoDeSanidade("Subtrair Sanidade", "Retira 1 ponto de Sanidade", -1);
        umEfeito.add(san);
        Habilidade hab = new Habilidade("Mordida Raivosa"
                    , "Cão de rua contaminado com Raiva. Subtrai 1 ponto de HP e de Sanidade."
                    , umEfeito);
        super.setHabilidade(hab);
        super.setImagem("Cachorro");
    }
    
    /**
     * Metodo mensagemConversa.
     * 
     * Metodo implementado da Classe {@link Ator}, funciona como dialogo do 
     * ator principal com Cachorro.
     * 
     * @return String com uma mensagem de conversa entre Cesar e o Cachorro.
     */
    @Override
    public String mensagemConversa() {
            String fraseDeEfeito;
            if (super.ehAliado()) {
                    fraseDeEfeito = "***Choramingo leve de fome*** AU!";
            } else {
                    fraseDeEfeito = "GRRRRRRRRRR!!!";
            }
            return fraseDeEfeito;
    }
    
    /**
     * Metodo entregarItemDeQuest.
     * 
     * Metodo implementado da Classe {@link NPC}.
     * 
     * @return {@link Item} null, pois cachorro não tem nenhum item para dar a Cesar.
     */
    @Override
    public Item entregarItemDeQuest() {
        return null;
    }

    @Override
    public int getHPMaximo() {
        return 10;
    }

}
