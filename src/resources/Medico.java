package resources;

import java.util.ArrayList;

/**
 * Classe Medico.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por guardar objetos do tipo Medico, com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Medico extends NPC {
    
    /**
     * Construtor da classe Medico.
     *
     * @param nome uma String com o nome do medico a ser criado.
     */
    public Medico(String nome) {
        super(nome, 50, 1, null, new ArrayList<>(), true, false);
        Efeito san = new AlteracaoDeSanidade("Enfurecimento Supremo", "Depleta os pontos de Sanidade.", -999);
        ArrayList<Efeito> umEfeito = new ArrayList<>();
        umEfeito.add(san);
        Habilidade hab = new Habilidade("Imobilização"
                        , "Imobiliza seu alvo para internação, zerando os pontos de Sanidade."
                        , umEfeito);
        habilidade = hab;
        umEfeito = new ArrayList<>();
        Efeito cura = new AlteracaoDeSanidade("Recuperar Sanidade", "Restaura 15 de Sanidade", 15);
        umEfeito.add(cura);
        Item complementoPsicotropico = new Item("Largactil", "Um medicamento para crises de psicose. Só se consegue com o Médico.", umEfeito, true, true);
        bagagem.add(complementoPsicotropico);
    }
    
    /**
     * Metodo mensagemConversa.
     * 
     * Metodo implementado da Classe {@link Ator}, funciona como dialogo do 
     * ator principal com medico.
     * 
     * @return String
     */
    @Override
    public String mensagemConversa() {
        String fraseDeEfeito = "";
        if (aliado) {
                fraseDeEfeito = "Olá! Sou o Dr. " + nome + ", deseja algo?";
        } else {
                fraseDeEfeito = "Segurem ele!! Vou aplicar a injeção!!";
        }
        return fraseDeEfeito;
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
    	return darItem("Largactil");
    }
 
}
