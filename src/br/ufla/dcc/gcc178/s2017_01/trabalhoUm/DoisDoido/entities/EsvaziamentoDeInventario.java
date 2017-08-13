package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

/**
 * Classe AlteracaoDeHP - Produz efeito de manipulação de HP no Ator.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Representa o efeito de esvaziamento de inventário do {@link Ator} afetado.
 * É classe filha de {@link Efeito}, portanto pode ser utilizada indiretamente
 * a partir da aplicação de polimorfismo, permitindo que esteja em uma mesma
 * coleção de dados que uma classe irmã qualquer.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.08.11
 */
public class EsvaziamentoDeInventario extends Efeito {

    /**
     * Construtor da classe EsvaziamentoDeInventario
     *
     * @param nome Contém o nome do Efeito
     * @param descricao Contém a descrição do Efeito no Ator
     */
    public EsvaziamentoDeInventario(String nome, String descricao) {
        super(nome, descricao, 0);
    }

    /**
     * Metodo responsavel por aplicar a limpesa de inventario
     * @param alvo ator no qual deseja-se aplicar a limpesa
     * @return Resultado SUCESSO caso inventario seja limpo 
     */
    @Override
    public Resultado aplicar(Ator alvo) {
        return alvo.limparInventario();
    }
    
    /**
     * sobrescrita do metodo toString
     * @return String contendo a descrição esvaziamento do inventario
     */
    @Override
    public String toString() {
        return "Esvazia inventário";
    }
    
}
