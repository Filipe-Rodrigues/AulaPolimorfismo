/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.core.ManicomioDeZulu;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe responsavel pelas informaçãoe do jogo
 * @author filip
 */
public class InformacoesDeJogo implements Serializable{
    private static final long serialVersionUID = 1L;
    private int pontuacao;
    private String data;
    private ManicomioDeZulu jogo;

    /**
     * constroi um objeto do tipo informações de jogo
     * @param pontuacao espera um inteiro
     * @param data espear um Date
     * @param jogo espera um Manicomio de zulu
     */
    public InformacoesDeJogo(int pontuacao, Date data, ManicomioDeZulu jogo) {
        this.pontuacao = pontuacao;
        setData(data);
        this.jogo = jogo;
    }

    /**
     * Metodo responsavel por retornar a pontuação
     * @return inteiro contendo a pontuação
     */
    public int getPontuacao() {
        return pontuacao;
    }

    /**
     * Metodo responsavel por alterar a pontuação
     * @param pontuacao 
     */
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    /**
     * Metodo responsavel por pegar a data
     * @return String contendo a data
     */
    public String getData() {
        return data;
    }

    /**
     * Metodo que altera a data 
     * @param data espera um Date
     */
    public void setData(Date data) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yy HH:mm");
        Date now = new Date();
        this.data = sdfDate.format(now);
    }

    /**
     * Metodo que verifica se está zerado
     * @return true caso sim e false caso ao contrário
     */
    public boolean isZerado() {
        return jogo.foiFinalizado();
    }
    
    /**
     * Metodo responsavel por pegar o estado do protagonista
     * @return Resultado com estado do protagonista
     */
    public Resultado getEstadoDoProtagonista() {
        return jogo.getEstadoDoProtagonista();
    }
    
    /**
     * Metodo responsavel por pegar o jogo
     * @return ManicomioDeZulu
     */
    public ManicomioDeZulu getJogo() {
        return jogo;
    }
}
