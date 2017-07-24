package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

/**
 * Classe Abstrata Efeito - Modelo padrão de Efeitos em Atributos.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Ela provê um modelo padrão para todos os efeitos que um {@link Ator} poderá
 * sofrer. Todo efeito que surgirá no decorrer do jogo deverá partir de alguma
 * classe que herdará diretamente desta.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public abstract class Efeito {

    private String nome;
    private String descricao;
    private int quantidade;

    /**
     * Construtor da classe Efeito
     *
     * @param nome Contém o nome do Efeito
     * @param descricao Contém a descrição do Efeito no Ator
     * @param quantidade Descreve a quantidade de influência em algum atributo de Ator
     */
    public Efeito (String nome, String descricao, int quantidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }
    
    /**
     * Método getter para o campo "nome".
     *
     * @return String com o nome do Efeito.
     */
    public String getNome () {
        return nome;
    }
    
    /**
     * Método getter para o campo "descricao".
     *
     * @return String com a descrição do Efeito.
     */
    public String getDescricao () {
        return descricao;
    }
    
    /**
     * Método getter para o campo "quantidade".
     *
     * retorna A força de influência no Ator alvo.
     * 
     * @return int com a quantidade de influência em algum atributo de Ator
     */
    public int getQuantidade () {
        return quantidade;
    }
    
    /**
     * Método abstrato de aplicação de efeito em um dado Ator.
     * Toda subclasse deverá implementar de que maneira esse efeito será
     * aplicado ao Ator.
     *
     * @param alvo Ator a ser afetado pelo efeito.
     * @return bollean, true se o efeito foi aplicado corretamente, false caso contrário.
     */
    public abstract Resultado aplicar (Ator alvo);

}
