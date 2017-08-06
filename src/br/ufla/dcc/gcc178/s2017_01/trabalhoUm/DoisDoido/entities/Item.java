package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe Item.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por descrever os itens e suas , com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Item implements Serializable{
    
    /** Attributes */
    private static final long serialVersionUID = 1L;
    private final String nome;
    private final String descricao;
    private List<Efeito> efeitos;
    private final boolean consumivel;
    private final boolean coletavel;
  
    /**
     * Construtor da Classes Item.
     *
     * @param nome String com o nome do Item
     * @param descricao String com a Descricao Do Item
     * @param efeitos List de Efeitos com os efeitos Causados pelo Item
     * @param consumivel bollean Se é consumivel.
     * @param coletavel bollean Se é coletavel.
     */
    public Item (String nome, String descricao, List<Efeito> efeitos, boolean consumivel, boolean coletavel) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeitos = new ArrayList<>();
        for (Efeito efeito : efeitos) {
            this.efeitos.add(efeito);
        }
        this.consumivel = consumivel;
        this.coletavel = coletavel;
    }
    
    /**
     * Metodo getNome.
     * 
     * retorna o nome do Item com uma String.
     * 
     * @return String, retorna o nome do Item.
     */
    public String getNome () {
        return this.nome;
    }
    
    /**
     * Metodo getDescricao.
     * 
     * retorna com uma String a descricao do Item. 
     *
     * @return String, retorna uma String com a descrição do Item.
     */
    public String getDescricao () {
        return this.descricao;
    }
    
    /**
     * Metodo getEfeitos.
     * 
     * retorna os efeitos de um Item.
     *
     * @return List do tipo {@link Efeito) com os efeitos causados
     */
    public List<Efeito> getEfeitos () {
        return Collections.unmodifiableList(efeitos);
    }
    
    /**
     * Metodo ehConsumivel
     * 
     * @return {@code true} se o item é consumível. {@code false} caso contrário.
     */
    public boolean ehConsumivel () {
        return consumivel;
    }
    
    /**
     * Metodo ehColetavel
     *
     * @return {@code true} se o item é consumível. {@code false} caso contrário.
     */
    public boolean ehColetavel () {
        return coletavel;
    }

}