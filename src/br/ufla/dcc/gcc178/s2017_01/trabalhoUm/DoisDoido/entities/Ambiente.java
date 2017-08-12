package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado.ITEM_NAO_ENCONTRADO;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado.SUCESSO;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
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
public class Ambiente implements Serializable{

    private static final long serialVersionUID = 1L;
    
    public static final String SEM_SAIDA = "SEM_SAIDA";
    private String descricao;
    private String nomeDaImagem;
    private HashMap<String, Ambiente> saidas;
    private List<Item> itens;
    private List<NPC> npcs;

    /**
     * Construtor da classe Ambiente.
     *
     * @param descricao do tipo String recebe uma descricao do ambiente.
     * @param nomeDaImagem imagem do ambiente
     */
    public Ambiente(String descricao, String nomeDaImagem) {
        this();
        this.descricao = descricao;
        this.nomeDaImagem = nomeDaImagem;
    }
    
    /**
     * Construtor da classe Ambiente.
     *
     * @param descricao do tipo String recebe uma descricao do ambiente.
     */
    public Ambiente(String descricao) {
        this();
        this.descricao = descricao;
    }
    
    /**
     * Construtor da classe Ambiente.
     *
     */
    public Ambiente() {
        this.descricao = "";
        this.nomeDaImagem = "vazio.png";
        saidas = new HashMap<>();
        itens = new ArrayList<>();
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
    public void ajustarSaida(String comando, Ambiente ambiente) {
        saidas.put(comando, ambiente);
    }

    /**
     * Metodo getDescricao.
     *
     * retorna a descricao do ambiente.
     *
     * @return String com a descricao do ambiente.
     */
    public String getDescricao() {
        return this.descricao;
    }

    /**
     * Metodo getImagem.
     *
     * retorna a imagem do ambiente.
     *
     * @return String com o nome da Imagem do ambiente.
     */
    public String getImagem() {
        return this.nomeDaImagem;
    }
    
    /**
     * Metodo setImagem.
     *
     * configura uma nova imagem para o ambiente
     *
     * @param imagem String com o nome da Imagem do ambiente.
     */
    public void setImagem(String imagem) {
        nomeDaImagem = imagem;
    }

    /**
     * Metodo getListaSaidas.
     *
     * retorna as saidas oportunas.
     *
     * @return String com a lista de saidas disponiveis em um ambiente.
     */
    public String listarSaidasDisponiveis() {
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
     * Metodo getListaSaidas.
     *
     * retorna as saidas oportunas.
     *
     * @return List<String> com a lista das saidas.
     */
    public List<String> getListaSaidas() {
        if (saidas.isEmpty()) {
            return null;
        } 
        return new ArrayList<>(saidas.keySet());
    }

    /**
     * Metodo getAmbiente.
     *
     * retorna um ambiente atraves de uma direcao passada no parametro.
     *
     * @param direcao do tipo String, indica uma direcao.
     * @return {@link Ambiente} com o ambiente seguindo a direcao passada.
     */
    public Ambiente getAmbiente(String direcao) {
        return saidas.get(direcao);
    }

    /**
     * Metodo getListaItens.
     *
     * retorna uma String com uma lista de itens no ambiente.
     *
     * @return String Com a lista de itens no ambiente.
     */
    public String getListaItens() {
        String lista = "";
        for (Item item : itens) {
            lista += item.getNome() + "\n";
        }
        lista += "\n";
        return lista;
    }
    
    /**
     * Metodo getItens.
     *
     * retorna uma lista não modificavel dos itens no ambiente.
     *
     * @return List<Item> com todos os itens do ambiente.
     */
    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }
    
    /**
     * Metodo getNPCs.
     *
     * retorna uma lista não modificavel dos NPCs no ambiente.
     *
     * @return List<NPC> com todos os NPCs do ambiente.
     */
    public List<NPC> getNPCs() {
        return Collections.unmodifiableList(npcs);
    }

    /**
     * Metodo getListaNPCs.
     *
     * retorna uma String com todos os NPC's do ambiente.
     *
     * @return String com a lista de NPC's no ambiente.
     */
    public String getListaNPCs() {
        String lista = "";
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
    private int getItemPorNome(String nomeDoItem) {
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
    private int getNPCPorNome(String nomeDoNPC) {
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
     * @return {@link Item} a ser recolhido.
     */
    public Item recolherItem(String nomeDoItem) {
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
    public void colocarItem(Item item) {
        itens.add(item);
    }

    /**
     * Metodo colocarNPC.
     *
     * coloca NPC no ambiente.
     *
     * @param NPC do tipo {@link NPC}
     */
    public void colocarNPC(NPC ator) {
        npcs.add(ator);
    }

    /**
     * Metodo selecionarNPC
     *
     * @param nomeDoNPC um String com o nome.
     * @return {@link NPC} com o NPC achado pelo nome, se não achar retorna null.
     */
    public NPC selecionarNPC(String nomeDoNPC) {
        int index = getNPCPorNome(nomeDoNPC);
        if (index >= 0) {
            NPC ator = npcs.get(index);
            return ator;
        }
        return null;
    }
    
    public void matarNPC (NPC alvo) {
        npcs.remove(alvo);
    }
    
    public void removerNPC (String alvo) {
        for (NPC npc : npcs) {
            if (npc.getNome().equals(alvo)) {
                npcs.remove(npc);
            }
        }
    }

    /**
     * Metodo afetarAtor.
     *
     * afeta um ator durante uma luta no ambiente.
     *
     * @param efeitos lista de {@link Efeito} causados com um objeto
     * @param alvo {@link Ator} a sofrer os danos
     * @return Resultado após o ator sofrer um ataque.
     */
    private List<Resultado> afetarAtor(List<Efeito> efeitos, Ator alvo) {
        List<Resultado> resultados = new ArrayList<>();
        for (Efeito efeito : efeitos) {
            resultados.add(efeito.aplicar(alvo));
        }
        return resultados;
    }

    /**
     * Metodo aplicarItem
     *
     * @param nomeDoItem String com o nome do item
     * @param alvo um {@link Ator} alvo que vai receber os danos.
     * @return Resultado após o ator sofrer um ataque com um Item.
     */
    public List<Resultado> aplicarItem(String nomeDoItem, Ator alvo) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = itens.get(index);
            if (item.ehConsumivel()) {
                itens.remove(index);
            }
            return afetarAtor(item.getEfeitos(), alvo);
        }
        List<Resultado> naoTem = new ArrayList<>();
        naoTem.add(ITEM_NAO_ENCONTRADO);
        return naoTem;
    }

    /**
     * Metodo temItem.
     *
     * verifica se existe algum item no ambiente.
     *
     * @param nome uma String com o nome do item
     * @return boolean se tem o item, true, senão, false.
     */
    public boolean temItem(String nome) {
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
     * @return String com a descrição do item.
     */
    public String getDescricaoItem(String nomeDoItem) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            return itens.get(index).getDescricao();
        }
        return "";
    }

}
