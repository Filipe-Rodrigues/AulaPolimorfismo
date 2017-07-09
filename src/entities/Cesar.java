package entities;

import java.util.ArrayList;
import static entities.Atributo.*;
import static entities.Resultado.*;

/**
 * Classe Cesar.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é a responsavel por nosso ator principal, ela que tem a funcao
 * construir e realizar as funcoes do personagem Cesar.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Cesar extends Ator {
    
    /**
     * Construtor da Classe Cesar.
     * Aqui ja foi inicializado com atributos pre estabelecidos.
     */
    public Cesar () {
        super ("César", 25, 5, null, new ArrayList<>(), true);
        AlteracaoDeHP hp = new AlteracaoDeHP("Subtrair HP", "Retira 4 pontos de HP", -4);
        ArrayList<Efeito> umEfeito = new ArrayList<>();
        umEfeito.add(hp);
        Habilidade hab = new Habilidade("Esmurrar", "Desfere vários murros e mordidas. É muito estranho de se ver.", umEfeito);
        atributos.put(SANIDADE, 23);
        habilidade = hab;
    }

    /**
     * Metodo getStatus.
     * 
     * Retorna o Status atual de Cesar
     *
     * @return String com o status de Cesar após ser afetado sua sanidade.
     */
    @Override
    public String getStatus () {
        String status = super.getStatus();
        status += "Sanidade:      " + atributos.get(SANIDADE) + getStatusSanidade();
        return status;
    }
    
    /**
     * Metodo afetarSanidade.
     *
     * Afeta a sanidade do Cesar do tamanho da quantidade passada
     * 
     * @param quantidade inteiro com a quantidade a ser afetada.
     * @return Resultado, com o resultado após afetar a sanidade. 
     */
    private Resultado afetarSanidade (int quantidade) {
        int sanidade = atributos.get(SANIDADE);
        if (sanidade > 0) {
            if (-quantidade < sanidade) {
                sanidade += quantidade;
                atributos.put(SANIDADE, sanidade);
                if (quantidade > 0) {
                    return ATOR_SANADO;
                } else {
                    return ATOR_ENFURECIDO;
                }
            } else {
                sanidade = 0;
                atributos.put(SANIDADE, sanidade);
                return ATOR_ENLOUQUECIDO;
            }
        } else if (sanidade == 0) {
            return ATOR_NEUTRALIZADO;
        } 
        return ATOR_EQUILIBRADO;
    }
    
    
    /**
     * Metodo afetarAtributo
     * 
     * Implementacao a partir da Classe Ator
     * 
     * @param atributo, atributo a ser afetado.
     * @param quantidade, inteiro com a quantidade a afetar.
     * @return Resultado retorna o resultado da sanidade afetada pela quantia. 
     */
    @Override
    public Resultado afetarAtributo (Atributo atributo, int quantidade) {
        Resultado resultado = super.afetarAtributo(atributo, quantidade);
        if (resultado == ATRIBUTO_NAO_APROPRIADO && atributo == SANIDADE) {
            resultado = afetarSanidade(quantidade);
        }
        return resultado;
    }
    
    /**
     * Metodo taSuportando.
     * 
     * Verifica se Cesar ainda suporta os ataques sofridos
     *
     * @return boolean, true, se cesar estiver com sanidade menor ou igual 15,
     * false, caso contrario.
     */
    public boolean taSuportando () {
        return (atributos.get(SANIDADE) <= 15 && atributos.get(SANIDADE) >= 10);
    }
    
    /**
     * Metodo taInsano.
     * 
     * Verifica se Cesar esta no estado insano.
     *
     * @return boolean, true, se cesar estiver com sanidade menor ou igual 15,
     * false, caso contrario.
     */
    public boolean taInsano () {
        return (atributos.get(SANIDADE) <= 15 && atributos.get(SANIDADE) >= 10);
    }
    
    /**
     * Metodo taMuitoInsano.
     * 
     * Verifica se Cesar esta em um estado Muito Insano
     *
     * @return boolean, true, se Cesar estiver com sanidade menor que dez,
     * false, caso contrario.
     */
    public boolean taMuitoInsano () {
        return (atributos.get(SANIDADE) < 10 && atributos.get(SANIDADE) > 0);
    }
    
    /**
     * Metodo enlouqueceuDeVez.
     * 
     * retorna se ele ficou fora de controle
     *
     * @return boolean, true se a sanidade de Cesar chegou a zero, false, caso
     * contrario.
     */
    public boolean enlouqueceuDeVez () {
        return (atributos.get(SANIDADE) == 0);
    }
    
    /**
     * Metodo taCurado.
     *
     * Retorna se Cesar conseguiu se curar de sua loucura.
     * 
     * @return boolean, true, se Cesar conseguiu se curar, false, caso contrario.
     */
    public boolean taCurado () {
        return (atributos.get(SANIDADE) >= 30);
    }

    /**
     * Metodo getStatusSanidade.
     *
     * Retorna se o Status da sanidade de Cesar.
     * 
     * @return String com o Status da Sanidade.
     */
    private String getStatusSanidade () {
        if (taCurado()) {
            return " (CURADO)\n";
        } else if (taMuitoInsano()) {
            return " (VOCÊ ACHA QUE TODOS SÃO HOSTIS)\n";
        } else if (taInsano()) {
            return " (COMEÇANDO A SURTAR)\n";
        }
        return " (PROCURE TRATAMENTO)\n";
    }
    
   /** 
    * Metodo mensagemConversa.
    * 
    * Metodo implementado da Classe {@link Ator}, funciona como dialogo do 
    * Cesar com NPC.
    * 
    * @return String uma mensagem de conversa entre Cesar e um NPC.
    */
    @Override
    public String mensagemConversa () {
        String fraseDeEfeito = "";
        if (taMuitoInsano()) {
        	fraseDeEfeito = "Eu sei que você anda me seguindo... Acha que eu não sei que\n"
        			+ "com R$4,20 compro duas Pitchula? SAIA DA MINHA CABEÇA!!!...\n"
        			+ "... Quando eu chegar no PV2 acho que vou fazer sabão...";
        } else if (taInsano()) {
        	fraseDeEfeito = "Tenho que falar com minha tia de Piracicaba que eu\n"
        			+ "assisti Faustão com eles. Foi o maior que já pesquei!\n"
        			+ "... Meu Deus, preciso de tratamento RÁPIDO!!";
        } else if (taSuportando()) {
        	fraseDeEfeito = "DROGA DROGA preciso ir pra casa rápido pegar a carteira,\n"
        			+ "tá cada vez mais difícil suportar! Talvez um banho quente\n"
        			+ "me ajude a colocar a cabeça um pouco no lugar...";
        }
        return fraseDeEfeito;
    }
    
}