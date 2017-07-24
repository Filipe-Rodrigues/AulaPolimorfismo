package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe NPC.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Descreve características e funcionalidades do conceito de Habilidade, que
 * são pertinentes a cada {@link Ator} presente no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Habilidade {

    private final String nome;
    private final String descricao;
    private List<Efeito> efeitos;

    /**
     * Construtor Da Classe NPC.
     * 
     * @param nome O nome da habilidade.
     * @param descricao Caracteriza com uma frase o seu conceito.
     * @param efeitos Uma lista de {@link Efeito}s que uma habilidade pode provocar.
     */
    public Habilidade (String nome, String descricao, List<Efeito> efeitos) {
        this.nome = nome;
        this.descricao = descricao;
        this.efeitos = new ArrayList<>(efeitos);
    }
    
    /**
     * Getter para o nome da habilidade
     *
     * @return String com o nome.
     */
    public String getNome () {
        return nome;
    }
    
    /**
     * Getter para a descrição da habilidade
     *
     * @return String com a descrição.
     */
    public String getDescricao () {
        return descricao;
    }
    
    /**
     * Getter para a lista de efeitos
     *
     * @return Lista com os efeitos da habilidade.
     */
    public List<Efeito> getEfeitos () {
        return Collections.unmodifiableList(efeitos);
    }

}