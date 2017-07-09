package entities;

import java.util.ArrayList;

/**
 * Classe Farmaceuta.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por guardar objetos do tipo Farmaceuta, com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Farmaceuta extends NPC {
    
    
    /**
     * Construtor da classe Farmaceuta.
     * 
     * @param nome uma String com o nome do Farmaceuta a ser criado.
     */
    public Farmaceuta(String nome) {
	super(nome, 10, 2, null, new ArrayList<>(), true, true);
        Efeito hp = new AlteracaoDeHP("Subtrair HP", "Retira 10 pontos de HP.", -10);
        ArrayList<Efeito> umEfeito = new ArrayList<>();
        umEfeito.add(hp);
        Habilidade hab = new Habilidade("Tiro de 12 (meio mascado)"
        		, "Utiliza uma espingarda calibre 12, mas envelhecida. Reduz 10 de HP."
        		, umEfeito);
        habilidade = hab;
        umEfeito = new ArrayList<>();
        Efeito curaSan = new AlteracaoDeSanidade("Recuperar Sanidade", "Restaura 15 de Sanidade", 15);
        umEfeito.add(curaSan);
        Efeito curaHP = new AlteracaoDeHP("Recuperar HP", "Restaura 15 de HP", 15);
        umEfeito.add(curaHP);
        Item complementoPsicotropico = new Item("Clonazepam", "Um medicamento para ansiedade.", umEfeito, true, true);
        bagagem.add(complementoPsicotropico);
        umEfeito = new ArrayList<>();
    }
    
    /**
     * Metodo mensagemConversa.
     * 
     * Metodo implementado da Classe {@link Ator}, funciona como dialogo do 
     * ator principal com Farmaceuta.
     * 
     * @return String com uma mensagem de conversa entre o Farmaceuta e Cesar.
     */
    @Override
    public String mensagemConversa() {
        String fraseDeEfeito = "";
        if (aliado) {
            fraseDeEfeito = "Olá! Precisa de algum medicamento?";
        } else {
            fraseDeEfeito = "Cuidado, ele é um louco!! Deixe-me cuidar disso!!";
        }
        return fraseDeEfeito;
    }
    
    /**
     * Metodo entregarItemDeQuest.
     * 
     * Metodo implementado da Classe {@link NPC}.
     * 
     * @return {@link Item}, um remédio (Clonazepam) para Cesar.
     */
    @Override
    public Item entregarItemDeQuest() {
        entregouItemDeQuest = true;
        return darItem("Clonazepam");
    }

}
