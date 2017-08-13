/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.user;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.InformacoesDeJogo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que representa um usuario e implementa uma Serializable
 * @author filip
 */
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String nome;
    private String gamerID;
    private List<InformacoesDeJogo> jogos;

    /**
     * controe um objeto do tipo Usuario
     * @param nome espera uma String contendo o nome do usuario
     * @param gamerID espera uma String contendo o gamerID do usuario
     */
    public Usuario(String nome, String gamerID) {
        this.nome = nome;
        this.gamerID = gamerID;
        jogos = new ArrayList<>();
    }
    
    /**
     * Metodo responsavel por retornar o nome do usuario
     * @return String contendo o nome do usuario
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Metodo responsavel por pegar o gamerId do usuario
     * @return retorna uma String contendo o gamerID do usuario
     */
    public String getGamerID() {
        return gamerID;
    }
    
    /**
     * Metodo responsavel por adicionar um novo jogo 
     * @param jogo espera um argumento do tipo InformacoesDeJogo
     */
    public void adicionarJogo(InformacoesDeJogo jogo) {
        jogos.add(jogo);
    }
    
    /**
     * Metodo resonsavel por obter a pontuação 
     * @return um List<Interger> contendo as pontuações
     */
    public List<Integer> getPontuacoes() {
        List<Integer> pontuacoes = new ArrayList<>();
        for (InformacoesDeJogo informacoesDeJogo : jogos) {
            pontuacoes.add(informacoesDeJogo.getPontuacao());
        }
        Collections.sort(pontuacoes);
        return pontuacoes;
    }
    
    /**
     * Metodo responsavel por obter as informações dos jogos
     * @return um List<InformacoesDeJogo> contendo as informações do jogos
     */
    public List<InformacoesDeJogo> getInformacoesDeJogos() {
        return Collections.unmodifiableList(jogos);
    }
    
    /**
     * Metodo responsavel por atualizar as informações do jogo
     * @param pos espera um argumento do tipo inteiro
     * @param info espera um argumento do tipo InformacoesDeJogo
     */
    public void atualizarInformacoesDoJogo(int pos, InformacoesDeJogo info) {
        jogos.set(pos, info);
    }
}
