package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import java.util.ArrayList;

/**
 * Classe Vendedor.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por guardar objetos do tipo Vendedor, com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Vendedor extends NPC {

	/**
        * Construtor da classe Vendedor.
        *
        * @param nome uma String com o nome do medico a ser criado.
        */
        public Vendedor(String nome) {
		super(nome, 25, 1, null, new ArrayList<>(), true, false);
		Efeito hp = new AlteracaoDeHP("Subtrair HP", "Retira 10 pontos de HP", -10);
        ArrayList<Efeito> umEfeito = new ArrayList<>();
        umEfeito.add(hp);
        Habilidade hab = new Habilidade("Tiro de 12 (meio mascado)"
        		, "Utiliza uma espingarda calibre 12, mas envelhecida. Reduz 10 de HP."
        		, umEfeito);
        super.setHabilidade(hab);
        umEfeito = new ArrayList<>();
        hp = new AlteracaoDeHP("Subtrair HP", "Retira 15 pontos de HP", -15);
        umEfeito.add(hp);
        Item picareta = new Item("Picareta", "Um belo exemplar de picareta, pode ser usado como arma.", umEfeito, false, true);
        super.coletarItem(picareta);
	}
        
         /**
         * Metodo entregarItemDeQuest.
         * 
         * Metodo implementado da Classe {@link NPC}.
         * 
         * @return {@link Item}, uma picareta para César.
         */
	@Override
	public Item entregarItemDeQuest() {
		super.setEntregouItemDeQuest(true);
		return darItem("Picareta");
	}
        
        /**
        * Metodo mensagemConversa.
        * 
        * Metodo implementado da Classe {@link Ator}, funciona como dialogo do 
        * ator principal com vendedor.
        * 
        * @return String, uma mensagem de dialogo entre César e o Vendedor, 
        * se o Vendedor for aliado retorna primeira String, se não, a segunda.
        */
	@Override
	public String mensagemConversa() {
		String fraseDeEfeito = "";
        if (super.ehAliado()) {
            fraseDeEfeito = "OLá eSTranHo!... Sua aLMa aToRMentADa proCurA aLGO qUe posSO oFErecEr?";
        } else {
            fraseDeEfeito = "É chEGAda a horA de ENTERRAR-TE!! VenHA e mOStRe suA dISposiÇão paRA moRRER!!";
        }
        return fraseDeEfeito;
	}

    @Override
    public int getHPMaximo() {
        return 25;
    }
	
}
