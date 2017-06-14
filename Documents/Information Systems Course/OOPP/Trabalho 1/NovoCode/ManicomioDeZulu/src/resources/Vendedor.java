package resources;

import java.util.ArrayList;

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
        habilidade = hab;
        umEfeito = new ArrayList<>();
        hp = new AlteracaoDeHP("Subtrair HP", "Retira 15 pontos de HP", -15);
        umEfeito.add(hp);
        Item picareta = new Item("Picareta", "Um belo exemplar de picareta, pode ser usado como arma.", umEfeito, false, true);
        bagagem.add(picareta);
	}
        
         /**
         * Metodo entregarItemDeQuest.
         * 
         * Metodo implementado da Classe {@link NPC}.
         * 
         * @return {@link Item}
         */
	@Override
	public Item entregarItemDeQuest() {
		entregouItemDeQuest = true;
		return darItem("Picareta");
	}
        
        /**
        * Metodo mensagemConversa.
        * 
        * Metodo implementado da Classe {@link Ator}, funciona como dialogo do 
        * ator principal com vendedor.
        * 
        * @return String
        */
	@Override
	public String mensagemConversa() {
		String fraseDeEfeito = "";
        if (aliado) {
            fraseDeEfeito = "OLá eSTranHo!... Sua aLMa aToRMentADa proCurA aLGO qUe posSO oFErecEr?";
        } else {
            fraseDeEfeito = "É chEGAda a horA de ENTERRAR-TE!! VenHA e mOStRe suA dISposiÇão paRA moRRER!!";
        }
        return fraseDeEfeito;
	}
	
}
