package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Atributo.HP;

/**
 * Classe AlteracaoDeHP - Produz efeito de manipulação de HP no Ator.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Representa o efeito de modificação nos pontos de vida do {@link Ator} afetado.
 * É classe filha de {@link Efeito}, portanto pode ser utilizada indiretamente
 * a partir da aplicação de polimorfismo, permitindo que esteja em uma mesma
 * coleção de dados que uma classe irmã qualquer.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class AlteracaoDeHP extends Efeito {
   
    /**
     * Construtor da classe AlteracaoDeHP
     *
     * @param nome Contém o nome do Efeito
     * @param descricao Contém a descrição do Efeito no Ator
     * @param quantidade Representa a influência no HP do Ator alvo.
     * Números positivos adicionam pontos de vida, números negativos retiram.
     */
    public AlteracaoDeHP (String nome, String descricao, int quantidade) {
        super(nome, descricao, quantidade);
    }

    /**
     * Método de aplicação do efeito em um dado Ator.
     * Nessa classe, este método irá somar o HP do Ator à quantidade descrita
     * pelo seu atributo representativo nessa classe. Se a quantidade for
     * positiva, o alvo ganhará pontos de vida. Se for negativa, perderá.
     * 
     * Para alvos "imortais" (isto é, pontos de vida negativos), o efeito não
     * deverá ser aplicado, e a função retornará valores que discriminarão isso.
     *
     * @param alvo Ator a ser afetado pelo efeito.
     * @return true se o efeito foi aplicado corretamente, false caso contrário.
     */
    @Override
    public Resultado aplicar (Ator alvo) {
        return alvo.afetarAtributo(HP, getQuantidade());
    }
    
    @Override
    public String toString() {
        return "Altera HP: " + getQuantidade() + "pts";
    }

}
