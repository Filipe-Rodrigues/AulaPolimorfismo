package io;

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
    private boolean querMapa;
    private boolean apagaTudo;
    private boolean finalizado;
    
    /**Construtor da Classe.
     * 
     * @param saidas List<String> traz a lista de saidas de cada ambiente do jogo.
     */
    public JogoEvent (List<String> saidas) {
        saida = "";
        imagemDoAmbiente = "";
        apagaTudo = false;
        finalizado = false;
        querMapa = false;
        this.saidasDoAmbiente = saidas;
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
    
    /**Metodo emendarSaida.
     * 
     * emenda uma saida com uma outra saida passada por parametro.
     * 
     * @param saida String com o nome da saida a ser emendada.
     */
    public void emendarSaida(String saida) {
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
     * metodo que retorna se o programa foi finalizado ou não.
     * 
     * @return boolean, se o jogo acabou ou não.
     */
    public boolean taFinalizado() {
        return finalizado;
    }

    /**Metodo setFinalizado.
     * 
     * inicializa a variavel finalizado com uma boolean passada por parametro.
     * 
     * @param apagaTudo boolean se o programa finalizou.
     */
    public void setFinalizado(boolean apagaTudo) {
        this.finalizado = apagaTudo;
    }
    
}
