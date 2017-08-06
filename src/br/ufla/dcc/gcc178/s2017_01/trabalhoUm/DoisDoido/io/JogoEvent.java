package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.core.EstadoDeJogo;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Item;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.NPC;
import java.util.Collections;
import java.util.List;

/**Classe JogoEvent.
 * 
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela tem como função tratar os eventos que apareção na interface grafica
 * do jogo, guardando os comandos que o jogador der entrada.
 * 
 * @author  Fillipe Barros Rodrigues
 * @version 2017.07.01
 */
public class JogoEvent {
    private String saida;
    private String imagemDoAmbiente;
    private List<String> saidasDoAmbiente;
    private List<Item> inventarioCesar;
    private List<Item> inventarioNPC;
    private List<Item> objetosAmbiente;
    private List<NPC> npcs;
    private boolean querMapa;
    private boolean apagaTudo;
    private EstadoDeJogo estado;
    private int pontuacao;
    
    /**Construtor da Classe.
     * 
     * @param saidas List<String> traz a lista de saidas de cada ambiente do jogo.
     * @param estado Contém o estado do jogo.
     */
    public JogoEvent (List<String> saidas, EstadoDeJogo estado) {
        saida = "";
        imagemDoAmbiente = "";
        apagaTudo = false;
        querMapa = false;
        this.saidasDoAmbiente = saidas;
        this.estado = estado;
        inventarioCesar = null;
        inventarioNPC = null;
        npcs = null;
        objetosAmbiente = null;
        pontuacao = 0;
    }
    
    /**Metodo getSaida.
     * 
     * retorna as Saidas de um Ambiente
     * 
     * @return String com as saidas de um ambiente.
     */
    public String getSaida() {
        return saida;
    }
    
    /**Metodo setSaida.
     * 
     * inicializa uma saida de um Ambiente.
     * 
     * @param saida String com o nome da saida
     */
    public void setSaida(String saida) {
        this.saida = saida;
    }
    
    /**Metodo getImagem.
     * 
     * retorna o nome da imagem a ser colocada na tela da interface.
     * 
     * @return String com o nome da imagem que quero colocar na interface.
     */
    public String getImagem() {
        return imagemDoAmbiente;
    }

    /**Metodo setImagem.
     * 
     * inicializa o atributo imagemDoAmbiente com um nome de imagem.
     * 
     * @param imagem String com o nome de uma imagem.
     */
    public void setImagem(String imagem) {
        this.imagemDoAmbiente = imagem;
    }
    
    /**Metodo getSaidasDisponiveis.
     * 
     * retorna uma lista com as saidas disponiveis.
     * 
     * @return List<String> com os nomes das saidas disponiveis.
     */
    public List<String> getSaidasDisponiveis() {
        return Collections.unmodifiableList(saidasDoAmbiente);
    }
    
    /**Metodo setSaidasDisponiveis.
     * 
     * inicializa o atributo saidasDoAmbiente com o nome das 
     * saidas disponiveis.
     * 
     * @param saidas List<String> com os nomes das saidas disponiveis.
     */
    public void setSaidasDisponiveis(List<String> saidas) {
        this.saidasDoAmbiente = saidas;
    }
    
    /**Metodo adicionarLinhaDeSaida.
     * 
     * Adiciona uma linha saida com a String de saída registrada até o momento.
     * Funciona como se fosse um println.
     * 
     * @param saida String com a informação a ser impressa.
     */
    public void adicionarLinhaDeSaida(String saida) {
        this.saida += "\n" + saida;
    }

    /**Metodo querMapa.
     * 
     * retorna se o jogador quer usar o mapa.
     *
     * @return boolean se o jogador quer usar o mapa. 
     */
    public boolean querMapa() {
        return querMapa;
    }

    /**Metodo setQuerMapa.
     * 
     * inicializa a variavel querMapa com uma boolean passada como parametro
     * 
     * @param querMapa boolean se a pessoa que o mapa.
     */
    public void setQuerMapa(boolean querMapa) {
        this.querMapa = querMapa;
    }
    
    /**Metodo deveLimparTela.
     * 
     * retorna se deve limpar a tela.
     * 
     * @return boolean, se a tela deve ser limpa ou não.
     */
    public boolean deveLimparTela() {
        return apagaTudo;
    }

    /**Metodo setLimparTela.
     * 
     * inicializa a variavel apagaTudo com uma boolean passada por parametro.
     * 
     * @param apagaTudo boolean se a pessoa quer limpar a tela.
     */
    public void setLimparTela(boolean apagaTudo) {
        this.apagaTudo = apagaTudo;
    }
    
    /**Metodo taFinalizado.
     * 
     * retorna se o jogo foi finalizado.
     * 
     * @return boolean, se o jogo foi finalizado, true, se não, false.
     */
    public boolean taFinalizado() {
        return estado.taFinalizado();
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
    	return estado.getEstadoAtual();
    }
    
    /**
     * Metodo getInventarioCesar.
     * 
     * @return List<Item> com o inventario que cesar possui de itens 
     */
    public List<Item> getInventarioCesar () {
        return inventarioCesar;
    }
    
    /**
     * Metodo getObjetosAmbiente.
     * 
     * @return List<Item> com os itens presentes no ambiente
     */
    public List<Item> getObjetosAmbiente () {
        return objetosAmbiente;
    }
    
    /**
     * Metodo getInventarioNPC.
     * 
     * @return List<Item> com os itens do inventário do NPC.
     */
    public List<Item> getInventarioNPC () {
        return inventarioNPC;
    }
    
    /**
     * Metodo getNPCsAmbiente.
     * 
     * @return List<NPC> com os NPC's presentes no ambiente.
     */
    public List<NPC> getNPCsAmbiente () {
        return npcs;
    }
    
    /**
     * Metodo setInventarioCesar
     * 
     * @param inventario atribui um inventario para Cesar.
     */
    public void setInventarioCesar (List<Item> inventario) {
        this.inventarioCesar = inventario;
    }
    /**
     * Metodo setObjetosAmbiente.
     * 
     * @param objetos List<Item> com os itens a serem colocados no ambiente.
     */
    public void setObjetosAmbiente (List<Item> objetos) {
        this.objetosAmbiente = objetos;
    }
    
    /**
     * Metodo setInventarioNPC.
     * 
     * @param inventario List<Item> atribui um inventario a um NPC.
     */
    public void setInventarioNPC (List<Item> inventario) {
        this.inventarioNPC = inventario;
    }
    
    /**
     * Metodo setNPCsAmbiente.
     * 
     * @param npcs List<NPC> com os NPC's a serem colocados no ambiente.
     */
    public void setNPCsAmbiente (List<NPC> npcs) {
        this.npcs = npcs;
    }
    
    /**
     * Metodo getPontuacao.
     * 
     * @return Integer com a quantidade de pontos possuida no momento.
     */
    public int getPontos () {
        return estado.getPontuacao();
    }
    
    /**
     * Metodo getInimigoHP.
     * 
     * @return Integer com a quantidade de HP do inimigo enfrentado.
     * Se não houver um inimigo (ou se estiver morto), retorna 0.
     * Se o inimigo for imortal, retorna -1.
     */
    public float getInimigoHP () {
        return estado.getInimigoHP();
    }
    
    /**
     * Metodo getMeuHP.
     * 
     * @return Float com a quantidade de HP do César.
     */
    public float getMeuHP () {
        return estado.getMeuHP();
    }
    
    /**
     * Metodo getMinhaSanidade.
     * 
     * @return Float com a quantidade de Sanidade do César.
     */
    public float getMinhaSanidade () {
        return estado.getMinhaSanidade();
    }
}
