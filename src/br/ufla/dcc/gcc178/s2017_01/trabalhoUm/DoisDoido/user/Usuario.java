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
 *
 * @author filip
 */
public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    private String nome;
    private String gamerID;
    private List<InformacoesDeJogo> jogos;

    public Usuario(String nome, String gamerID) {
        this.nome = nome;
        this.gamerID = gamerID;
        jogos = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getGamerID() {
        return gamerID;
    }
    
    public void adicionarJogo(InformacoesDeJogo jogo) {
        jogos.add(jogo);
    }
    
    public List<Integer> getPontuacoes() {
        List<Integer> pontuacoes = new ArrayList<>();
        for (InformacoesDeJogo informacoesDeJogo : jogos) {
            pontuacoes.add(informacoesDeJogo.getPontuacao());
        }
        Collections.sort(pontuacoes);
        return pontuacoes;
    }
    
    public List<InformacoesDeJogo> getInformacoesDeJogos() {
        return Collections.unmodifiableList(jogos);
    }
    
    public void atualizarInformacoesDoJogo(int pos, InformacoesDeJogo info) {
        jogos.set(pos, info);
    }
}
