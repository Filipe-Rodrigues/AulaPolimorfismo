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
 *
 * @author filip
 */
public class InformacoesDeJogo implements Serializable{
    private static final long serialVersionUID = 1L;
    private int pontuacao;
    private String data;
    private ManicomioDeZulu jogo;

    public InformacoesDeJogo(int pontuacao, Date data, ManicomioDeZulu jogo) {
        this.pontuacao = pontuacao;
        setData(data);
        this.jogo = jogo;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getData() {
        return data;
    }

    public void setData(Date data) {
        SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yy HH:mm");
        Date now = new Date();
        this.data = sdfDate.format(now);
    }

    public boolean isZerado() {
        return jogo.foiFinalizado();
    }
    
    public Resultado getEstadoDoProtagonista() {
        return jogo.getEstadoDoProtagonista();
    }
    
    public ManicomioDeZulu getJogo() {
        return jogo;
    }
}
