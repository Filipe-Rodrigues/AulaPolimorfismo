package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.core;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado.SUCESSO;
import java.io.Serializable;

/**
 * Classe EstadoDeJogo - responsavel por guardar o estado em
 * que Cesar esta no jogo.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Esta Classe guarda o estado em que Cesar e os npc's estao.
 * 
 * @author Filipe Barros Rodrigues
 * @version 2017.06.08
 */
public class EstadoDeJogo implements Serializable{
    private static final long serialVersionUID = 1L;
    public static final int NAVEGANDO = 0;
    public static final int CONVERSANDO = 1;
    public static final int ATACANDO = 2;
    private boolean assassinato;
    private boolean finalizado;
    private Resultado estadoDoProtagonista;
    private int estadoAtual;
    private String nomeDoNPCAtual;
    private float inimigoHP;
    private float meuHP;
    private float minhaSanidade;
    private int pontuacao;

    /**
     * Construtor da classe EstadoDeJogo
     * 
     * incializa os atributos dinamicos.
     */
    public EstadoDeJogo () {
    	assassinato = false;
        finalizado = false;
        estadoDoProtagonista = SUCESSO;
        estadoAtual = NAVEGANDO;
        nomeDoNPCAtual = "";
        inimigoHP = 0;
        meuHP = 25f/55f;
        minhaSanidade = 23f/30f;
        pontuacao = 100;
    }
    
    /**
     * Metodo getEstadoAtual.
     *
     * Retorna o estado atual de Cesar.
     * 
     * @return inteiro com o estado atual do jogo de acordo com a classe
     * do tipo enum {@link Resultado}.
     */
    public int getEstadoAtual () {
    	return estadoAtual;
    }
    
    /**
     * Metodo getNomeDoNPCAtual.
     * 
     * retorna o nome do NPC que cesar esta interagindo.
     *
     * @return String com um nome de um NPC.
     */
    public String getNomeDoNPCAtual () {
    	return nomeDoNPCAtual;
    }
    
    /**
     * Metodo setEstadoAtual.
     * 
     * recebe o estado e o nome de um NPC.
     *
     * @param estado estado em que um NPC esta
     * @param nome nome de um NPC
     * @return boolean, se conseguiu atualizar os dados, true, se não, false.
     */
    public boolean setEstadoAtual (int estado, String nome) {
        if (estado >= 0 && estado <= 2) {
        	estadoAtual = estado;
        	nomeDoNPCAtual = nome;
        	return true;
        }
        return false;
    }
    
    /**
     * Metodo matou.
     * 
     * recebe se um NPC foi morto.
     *
     * @param assassinato recebe true se um NPC foi morto.
     */
    public void matou (boolean assassinato) {
        this.assassinato = assassinato;
    }
    
    /**
     * Metodo teveMatanca.
     * 
     * retorna se houve morte de NPC.
     *
     * @return boolean, se houve morte, true, se não false.
     */
    public boolean teveMatanca () {
        return assassinato;
    }
    
    /**Metodo taFinalizado.
     * 
     * retorna se o jogo foi finalizado.
     * 
     * @return boolean, se o jogo foi finalizado, true, se não, false.
     */
    public boolean taFinalizado() {
        return finalizado;
    }

    /**Metodo setFinalizado.
     * 
     * recebe um boolean dizendo se o jogo foi finalizado.
     * 
     * @param finalizado do tipo boolean que traz true, se o jogo foi
     * finalizado, e false se o jogo não foi finalizado.
     */
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    /**Metodo getEstadoDoProtagonista.
     * 
     * Retorna o estado do protagonista.\n
     * Esse método é utilizado para fins de controle na tabela de exibição de jogos.
     * 
     * @return @link{Resultado.SUCESSO}, se o protagonista teve sorte,\n 
     * @link{Resultado.ATOR_ENLOUQUECIDO}, se o protagonista resolveu tacar pedra na lua, e\n
     * @link{Resultado.ATOR_ASSASSINADO}, se o protagonista foi encontrar seu criador.
     */
    public Resultado getEstadoDoProtagonista() {
        return estadoDoProtagonista;
    }

    /**Metodo setEstadoDoProtagonista.
     * 
     * Recebe um @link{Resultado} informando o estado em que o protagonista se encontra.\n
     * 
     * @param estadoDoProtagonista do tipo boolean que traz true, se o protagonista sossegou,
     * e false se o protagonista trombou com o sinistro.
     */
    public void setEstadoDoProtagonista(Resultado estadoDoProtagonista) {
        this.estadoDoProtagonista = estadoDoProtagonista;
    }
    
    /**
     * Metodo setInimigoHP.
     * 
     * @param hp Float com os pontos de HP do inimigo enfrentado.
     * Se o inimigo for imortal, passe -1 no parâmetro.
     */
    public void setInimigoHP (float hp) {
        this.inimigoHP = (hp > 1) ? (1) : (hp);
    }
    
    /**
     * Metodo getInimigoHP.
     * 
     * @return Float com a quantidade de HP do inimigo enfrentado.
     * Se não houver um inimigo (ou se estiver morto), retorna 0.
     * Se o inimigo for imortal, retorna -1.
     */
    public float getInimigoHP () {
        return inimigoHP;
    }
    
    /**
     * Metodo setMeuHP.
     * 
     * @param hp Float com os pontos de HP do César.
     */
    public void setMeuHP (float hp) {
        this.meuHP = (hp > 1) ? (1) : (hp);
    }
    
    /**
     * Metodo getMeuHP.
     * 
     * @return Float com a quantidade de HP do César.
     */
    public float getMeuHP () {
        return meuHP;
    }
    
    /**
     * Metodo setMinhaSanidade.
     * 
     * @param sanidade Float com os pontos de Sanidade do César.
     */
    public void setMinhaSanidade (float sanidade) {
        this.minhaSanidade = (sanidade > 1) ? (1) : sanidade;
    }
    
    /**
     * Metodo getMinhaSanidade.
     * 
     * @return Float com a quantidade de Sanidade do César.
     */
    public float getMinhaSanidade () {
        return minhaSanidade;
    }
    
    /**
     * Metodo getPontuacao.
     * 
     * @return Integer com a quantidade de pontos acumulados no jogo.
     */
    public int getPontuacao() {
        return pontuacao;
    }
    
    /**
     * Metodo atualizarPontuacao.
     * 
     * Atualiza a pontuação no decorrer do jogo.
     * 
     * @param quantidade Integer com a quantidade de pontos.
     */
    public void atualizarPontuacao(int quantidade) {
        pontuacao += quantidade;
        if (pontuacao < 0) {
            pontuacao = 0;
        }
    }
}
