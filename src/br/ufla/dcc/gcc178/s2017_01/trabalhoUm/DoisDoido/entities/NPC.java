package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import java.util.List;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Atributo.*;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado.*;

/**
 * Classe NPC.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por guardar objetos do tipo NPC, com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public abstract class NPC extends Ator {

    private boolean entregouItemDeQuest;
    
    /**
     * Construtor Da Classe NPC.
     * 
     * @param nome
     * @param hp
     * @param capacidade
     * @param habilidade
     * @param bagagem
     * @param aliado
     * @param entregue 
     */
    public NPC(String nome, int hp, int capacidade, Habilidade habilidade, List<Item> bagagem, boolean aliado, boolean entregue) {
        super(nome, hp, capacidade, habilidade, bagagem, aliado);
        entregouItemDeQuest = entregue;
    }
    
    /**
     * Metodo afetarAtributo.
     * 
     * Metodo implementado da Classe {@link Ator}, afeta os atributos do NPC
     * 
     * @param quantidade inteiro com a quantidade que um atritubuto vai ser 
     * alterado.
     * @param atributo {@link Atributo} que vai ser afetado.
     * @return {@link  Resultado} com o atributo afetado na quantidade passada. 
     */ 
    @Override
    public Resultado afetarAtributo (Atributo atributo, int quantidade) {
        Resultado resultado = super.afetarAtributo(atributo, quantidade);
        if (resultado == ATRIBUTO_NAO_APROPRIADO && atributo == SANIDADE) {
            setNeutralizado(true);
            resultado =  ATOR_NEUTRALIZADO;
        }
        return resultado;
    }
    
    /**
     * Metodo setEntregouItemDeQuest.
     *
     * Modifica o status de entrega do item
     *
     * @param entregou true se sim, false se não.
     */
    protected void setEntregouItemDeQuest (boolean entregou) {
        entregouItemDeQuest = entregou;
    }
    
    /**
     * Metodo entregouOItem.
     *
     * retorna um booleano se o item foi entregue ou não.
     *
     * @return boolean true se sim, false se não.
     */
    protected boolean entregouOItem () {
        return entregouItemDeQuest;
    }
    
    /**
     * Metodo Abstrato entregarItemDeQuest.
     *
     * @return Item 
     */
    public abstract Item entregarItemDeQuest ();
    
}
