/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui;

/**
 *
 * @author filip
 */
public class EntradaRanking implements Comparable<EntradaRanking>{
    private String gamerID;
    private int pontuacao;

    public EntradaRanking(String nome, int pontuacao) {
        this.gamerID = nome;
        this.pontuacao = pontuacao;
    }

    public String getGamerID() {
        return gamerID;
    }

    public void setGamerID(String nome) {
        this.gamerID = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    @Override
    public int compareTo(EntradaRanking outra) {
        if (this == outra || this.pontuacao == outra.pontuacao) {
            return 0;
        } else if (this.pontuacao < outra.pontuacao) {
            return 1;
        } else {
            return -1;
        }
    }
}
