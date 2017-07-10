package core;

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
public class EstadoDeJogo {

    public static final int NAVEGANDO = 0;
    public static final int CONVERSANDO = 1;
    public static final int ATACANDO = 2;
    private boolean assassinato;
    private boolean finalizado;
    private int estadoAtual;
    private String nomeDoNPCAtual;

    /**
     * Construtor da classe EstadoDeJogo
     * 
     * incializa os atributos dinamicos.
     */
    public EstadoDeJogo () {
    	assassinato = false;
        finalizado = false;
        estadoAtual = NAVEGANDO;
        nomeDoNPCAtual = "";
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
}