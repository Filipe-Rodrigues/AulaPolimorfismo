package resources;

import static resources.Resultado.ITEM_NAO_ENCONTRADO;
import static resources.Resultado.SUCESSO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Classe Ambiente.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Representa os os ambientes do jogo, com todos os itens da classe {@link Item),
 * e com os NPC derivados da classe {@link NPC}.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public class Ambiente {

    public static final String SEM_SAIDA = "SEM_SAIDA";
    private String descricao;
    private HashMap<String, Ambiente> saidas;
    private List<Item> itens;
    private List<NPC> npcs;
    
    /**
     * Construtor da classe Ambiente.
     *
     * @param descricao do tipo String recebe uma descricao do ambiente.
     */
    public Ambiente (String descricao) {
        this.descricao = descricao;
        saidas = new HashMap<>();
        itens = new ArrayList<Item>();
        npcs = new ArrayList<>();
    }
    
    /**
     * Metodo ajustarSaida.
     * 
     * inicializa as saidas dos ambientes, e pra onde essas saidas levam
     *
     * @param comando do tipo {@link Comando} recebe o sentido.
     * @param ambiente do tipo {@link Ambiente} recebe um ambiente de destino.
     */
    public void ajustarSaida (String comando, Ambiente ambiente) {
    	saidas.put(comando, ambiente);
    }

    /**
     * Metodo getDescricao.
     * 
     * retorna a descricao do ambiente.
     * 
     * @return String
     */
    public String getDescricao () {
        return this.descricao;
    }
    
    /**
     * Metodo getListaSaidas.
     * 
     * retorna as saidas oportunas.
     *
     * @return String
     */
    public String getListaSaidas () {
    	String descricaoSaidas;
        if (saidas.size() == 0) {
        	descricaoSaidas = SEM_SAIDA;
        } else {
        	descricaoSaidas = "";
        	List<String> chaves = new ArrayList<>(saidas.keySet());
        	for (String chave : chaves) {
        		descricaoSaidas += "[" + chave + "]\t" + saidas.get(chave).getDescricao() + "\n";
        	}
        }
        return descricaoSaidas;
    }

    /**
     * Metodo getAmbiente.
     *
     * retorna um ambiente atraves de uma direcao passada no parametro.
     * 
     * @param direcao do tipo String, indica uma direcao.
     * @return {@link Ambiente}
     */
    public Ambiente getAmbiente (String direcao) {
        return saidas.get(direcao);
    }

    /**
     * Metodo getListaItens.
     * 
     * retorna uma String com uma lista de itens no ambiente.
     * 
     * @return String
     */
    public String getListaItens (){
        String lista = "" ;
        for (Item item : itens) {
            lista += item.getNome() + "\n";
        }
        lista += "\n";
        return lista;
    }

    /**
     * Metodo getListaNPCs.
     * 
     * retorna uma String com todos os NPC's do ambiente.
     *
     * @return String
     */
    public String getListaNPCs () { 
        String lista = "" ;
        for (NPC ator : npcs) {
            lista += ator.getNome() + "\n";
        }
        lista += "\n";
        return lista;
    }
    
    /**
     * Metodo getItemPorNome
     *
     * @param nomeDoItem uma String com o nome do item
     * @return int com o numero de itens
     */
    private int getItemPorNome (String nomeDoItem) {
        int encontrado = -1;
        int i = 0;
        
        while (i < itens.size() && encontrado < 0) {
            if (nomeDoItem.equalsIgnoreCase(itens.get(i).getNome())) {
                encontrado = i;
            }
            i++;
        }
        
        return encontrado;
    }
    
    /**
     * Metodo getNPCPorNome
     *
     * @param nomeDoNPC uma String com o nome do NPC
     * @return int com o numero de NPC's
     */
    private int getNPCPorNome (String nomeDoNPC) {
        int encontrado = -1;
        int i = 0;
        
        while (i < npcs.size() && encontrado < 0) {
            if (nomeDoNPC.equalsIgnoreCase(npcs.get(i).getNome())) {
                encontrado = i;
            }
            i++;
        }
        
        return encontrado;
    }

    /**
     * Metodo recolherItem.
     *
     * recolhe o item passado atraves do seu nome.
     * 
     * @param nomeDoItem String com o nome do item a ser recolhido
     * @return {@link Item}
     */
    public Item recolherItem (String nomeDoItem) {
    	int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = itens.get(index);
            itens.remove(index);
            return item;
        }
        return null;
    }

    /**
     * Metodo colocarItem.
     * 
     * coloca itens no ambiente.
     *
     * @param item do tipo {@link Item}
     */
    public void colocarItem (Item item) {
        itens.add(item);
    }
    
    /**
     * Metodo colocarNPC.
     * 
     * coloca NPC no ambiente.
     *
     * @param NPC do tipo {@link NPC}
     */
    public void colocarNPC (NPC ator) {
        npcs.add(ator);
    }

    /**
     * Metodo selecionarNPC
     *
     * @param nomeDoNPC um String com o nome.
     * @return {@link NPC}
     */
    public NPC selecionarNPC (String nomeDoNPC) {
    	int index = getNPCPorNome(nomeDoNPC);
        if (index >= 0) {
            NPC ator = npcs.get(index);
            return ator;
        }
        return null;
    }
    
    /**
     * Metodo afetarAtor.
     * 
     * afeta um ator durante uma luta no ambiente.
     *
     * @param efeitos lista de {@link Efeito} causados com um objeto
     * @param alvo {@link Ator} a sofrer os danos
     * @return Resultado
     */
    private Resultado afetarAtor (List<Efeito> efeitos, Ator alvo) {
        for (Efeito efeito : efeitos) {
            Resultado resultado = efeito.aplicar(alvo);
            if (resultado == Resultado.ATRIBUTO_NAO_APROPRIADO) {
                return resultado;
            }
        }
        return SUCESSO;
    }
    
    /**
     * Metodo aplicarItem
     *
     * @param nomeDoItem String com o nome do item
     * @param alvo um {@link Ator} alvo que vai receber os danos. 
     * @return Resultado
     */
    public Resultado aplicarItem (String nomeDoItem, Ator alvo) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = itens.get(index);
            return afetarAtor(item.getEfeitos(), alvo);
        }
        
        return ITEM_NAO_ENCONTRADO;
    }
    
    /**
     * Metodo temItem.
     * 
     * verifica se existe algum item no ambiente.
     * 
     * @param nome uma String com o nome do item
     * @return boolean
     */
    public boolean temItem (String nome) {
        for (Item item : itens) {
        	if (item.getNome().equalsIgnoreCase(nome)) {
        		return true;
        	}
        }
        return false;
    }
    
    /**
     * Metodo getDescricaoItem.
     * 
     * pega uma descricao do item no ambiente.
     *
     * @param nomeDoItem uma String com o nome do item
     * @return String
     */
    public String getDescricaoItem (String nomeDoItem) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            return itens.get(index).getDescricao();
        }
        return "";
    }
    
}