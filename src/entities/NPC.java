package entities;

import java.util.List;
import static entities.Atributo.*;
import static entities.Resultado.*;

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

    protected boolean entregouItemDeQuest;
    
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
            neutralizado = true;
            resultado =  ATOR_NEUTRALIZADO;
        }
        return resultado;
    }
    
    /**
     * Metodo Abstrato entregarItemDeQuest.
     *
     */
    public abstract Item entregarItemDeQuest ();
    
}
