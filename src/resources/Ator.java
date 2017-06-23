package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static resources.Atributo.*;
import static resources.Resultado.*;

/**
 * Classe Abstrata Ator - A generalização de todo personagem do jogo.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é o modelo padrão de todo personagem do jogo, desde os NPCs
 * inimigos até mesmo o próprio personagem principal. Todo personagem está
 * inserido em algum {@link Ambiente}, com exceção do {@link Cesar}, o
 * personagem principal.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public abstract class Ator {

    protected String nome;
    protected HashMap<Atributo, Integer> atributos;
    protected Habilidade habilidade;
    protected List<Item> bagagem;
    protected boolean aliado;
    protected boolean neutralizado;

    /**
     * Construtor padrão da classe Ator.
     *
     * @param nome O nome do Ator.
     * @param hp A quantidade de pontos de vida do Ator. Se for igual a zero,
     * está morto. Maior que zero, vivo. Menor que zero é imortal.
     * @param capacidade Capacidade máxima de carga de itens (em n° de itens).
     * @param habilidade A habilidade especial do Ator.
     * @param bagagem Uma {@link java.util.List} de {@link Item}s portados pelo Ator.
     * @param aliado Se o Ator é aliado do protagonista ({@link Cesar}), true. Senão, false.
     */
    public Ator (String nome, int hp, int capacidade, Habilidade habilidade, List<Item> bagagem, boolean aliado) {
        this.nome = nome;
        this.atributos = new HashMap<>();
        this.atributos.put(HP, hp);
        this.atributos.put(CAPACIDADE, capacidade);
        this.habilidade = habilidade;
        this.bagagem = new ArrayList<>(bagagem);
        this.aliado = aliado;
        this.neutralizado = false;
    }
    
    /**
     * Metodo afetarAtor.
     *
     * Tem a função de aplicar um efeito em um determinado ator. 
     * 
     * @param efeitos Lista de efeitos para afetar um ator
     * @param alvo Alvo que recebera os efeitos
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
     * Metodo getItemPorNome.
     * 
     * Tem como funcao pegar um determinado item atraves de seu nome.
     *
     * @param nomeDoItem uma String com o nome do item que desejo verificar pelo nome
     * @return int
     */
    private int getItemPorNome (String nomeDoItem) {
        int encontrado = -1;
        int i = 0;
        
        while (i < bagagem.size() && encontrado < 0) {
            if (nomeDoItem.equalsIgnoreCase(bagagem.get(i).getNome())) {
                encontrado = i;
            }
            i++;
        }
        
        return encontrado;
    }
    
    /**
     * Metodo darItem.
     * 
     * tem como funcao dar um determinado item passado por parametro.
     *
     * @param nomeDoItem uma String com o nome do item que desejo dar
     * @return {@link Item}
     */
    public Item darItem (String nomeDoItem) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = bagagem.get(index);
            bagagem.remove(index);
            return item;
        }
        return null;
    }
    
    /**
     * Metodo getDescricaoItem.
     * 
     * Pega a descricao de determinado item.
     *
     * @param nomeDoItem uma String com o nome do item que desejo verificar a descricao
     * @return String
     */
    public String getDescricaoItem (String nomeDoItem) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            return bagagem.get(index).getDescricao();
        }
        return "";
    }
    
    /**
     * Metodo usarItem.
     * 
     * Tem como funcao usar um item em um {@link Ator} alvo.
     *
     * @param nomeDoItem uma String que passa o nome do item a ser trabalhado
     * @param alvo um {@link Ator} para usar o item passado
     * @return Resultado
     */
    public Resultado usarItem (String nomeDoItem, Ator alvo) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = bagagem.get(index);
            if (item.ehConsumivel()) {
            	bagagem.remove(index);
            }
            return afetarAtor(item.getEfeitos(), alvo);
        }
        
        return ITEM_NAO_ENCONTRADO;
    }
    
    /**
     * Metodo usarItem.
     * 
     * aplica os efeitos de um item em um ator alvo.
     *  
     * @param item um {@link Item} que aplica seus efeitos em um alvo
     * @param alvo um {@link Ator} que recebe os efeitos do item passado
     * @return Resultado
     */
    public Resultado usarItem (Item item, Ator alvo) {
        return afetarAtor(item.getEfeitos(), alvo);
    }
    
    /**
     * Metodo coletarItem.
     * 
     * Coleta um determinado item de um ambiente
     *
     * @param item um {@link Item} que coleta os itens de um ambiente
     * @return Resultado
     */
    public Resultado coletarItem (Item item) {
        if (bagagem.size() <= atributos.get(CAPACIDADE)) {
            bagagem.add(item);
            return SUCESSO;
        }
        return BAGAGEM_LOTADA;
    }
    /**
     * Metodo udarHabilidade.
     *
     * Usa determinada habilidade do ator principal em um ator secundario,
     * dependendo da habilidade que ele tiver no momento.
     * 
     * @param alvo um {@link Ator} que recebera os danos da habilidade do ator
     * principal.
     * @return Resultado
     */
    public Resultado usarHabilidade (Ator alvo) {
        return alvo.afetarAtor(habilidade.getEfeitos(), alvo);
    }
    
    /**
     * Metodo afetarHP.
     * 
     * afeta o HP de um ator, reduzindo a quantidade passado por parametro 
     *
     * @param quantidade um inteiro que determina a quantidade de HP que um
     * Ator ira perder.
     * @return Resultado
     */
    private Resultado afetarHP (int quantidade) {
        int hp = atributos.get(HP);
        if (hp > 0) {
            if (-quantidade < hp) {
                hp += quantidade;
                atributos.put(HP, hp);
                if (quantidade > 0) {
                    return ATOR_CURADO;
                } else {
                    return ATOR_FERIDO;
                }
            } else {
                hp = 0;
                atributos.put(HP, hp);
                return ATOR_ASSASSINADO;
            }
        } else if (hp == 0) {
            return ATOR_MORTO;
        } 
        return ATOR_IMORTAL;
    }
    
    /**
     * Metodo afetarAtributo.
     * 
     * Tem como funcao alterar os atributos do Ator reduzindo também seu HP.
     *
     * @param atributo um {@link Atributo} que ira sofrer danos
     * @param quantidade um inteiro que diz a quantidade que um 
     * atributo ira perder.
     * @return boolean
     */
    public Resultado afetarAtributo (Atributo atributo, int quantidade) {
        if (atributo == HP) {
            return afetarHP(quantidade);
        }
        return ATRIBUTO_NAO_APROPRIADO;
    }
    
    /**
     * Metodo getStatus.
     * 
     * Pega o status atual do Ator, retornando uma String com esse status.
     *
     * @return String
     */
    public String getStatus () {
        int hp = atributos.get(HP);
        
        String status = "";
        status += "Nome:          " + nome;
        if (hp == 0) {
            status += " (MORTO)\n";
        } else if (neutralizado) {
            status += " (NEUTRALIZADO)\n";
        } else {
        	status += "\n";
        }
        status += "Habilidade:    " + getNomeHabilidade() + "\n";
        status += "               " + getDescricaoHabilidade() + "\n";
        status += "HP:            " + ((hp < 0) ? ("infinito") : (hp)) + "\n";
        
        return status;
    }

    /**
     * Metodo getNome.
     * 
     * Tem como funcao pegar o nome do ator e retornar como uma String
     *
     * @return String
     */
    public String getNome () {
        return nome;
    }
    
    /**
     * Metodo getAtributo.
     *
     * Tem como funcao pegar os atributos do Ator e retornar um inteiro.
     * 
     * @param atributo os {@link Atributo} do ator.
     * @return int
     */
    public int getAtributo (Atributo atributo) {
        if (atributo == HP) {
            return atributos.get(HP);
        } else if (atributo == CAPACIDADE) {
            return atributos.get(CAPACIDADE);
        }
        return -10;
    }
    
    /**
     * Metodo getListaItens.
     * 
     * Pega tudo que ator tem em sua bagagem e retorna como uma String
     *
     * @return String
     */
    public String getListaItens () {
        int quantidadeDeItens = bagagem.size();
        int capacidade = atributos.get(CAPACIDADE);
        String lista = "Carga no inv.: " + quantidadeDeItens + "/" + capacidade + "\n";
        if (quantidadeDeItens > 0) {
            lista += "Itens:\n";
            for (Item item : bagagem) {
                lista += "       " + item.getNome() + "\n";
            }
        }
        lista += "\n";
        return lista;
    }
    
    /**
     * Metodo getNomeHabilidade.
     * 
     * retorna o nome da habilidade do ator naquele momento.
     *
     * @return String
     */
    public String getNomeHabilidade () {
        return habilidade.getNome();
    }
    
    /**
     * Metodo getDescricaoHabilidade.
     *
     * retorna a descricao da habilidade que o ator tem naquele momento.
     * 
     * @return String
     */
    public String getDescricaoHabilidade () {
        return habilidade.getDescricao();
    }
    
    /**
     * Metodo taVivo.
     * 
     * retorna um booleano se o Ator esta vivo ou morto.
     *
     * @return boolean
     */
    public boolean taVivo () {
        return ((atributos.get(HP) == 0) ? (false) : (true));
    }
    
    /**
     * Metodo setAliado.
     * 
     * tem funcao de setar um ator como seu aliado.
     *
     * @param aliado
     */
    public void setAliado (boolean aliado) {
        this.aliado = aliado;
    }
    
    /**
     * Metodo ehAliado.
     * 
     * retorna um booleano pra dizer se um ator eh seu aliado ou nao
     * 
     * @return boolean
     */
    public boolean ehAliado () {
        return aliado;
    }
    
    /**
     * Metodo taNeutralizado.
     * 
     * retorna um booleano se o ator ta neutralizado ou nao.
     *
     * @return boolean
     */
    public boolean taNeutralizado () {
        return neutralizado;
    }
    
    /**
     * Metodo ehImortal.
     * 
     * retorna um booleano se o ator eh imortal ou nao.
     *
     * @return boolean
     */
    public boolean ehImortal () {
        return atributos.get(HP) < 0;
    }
    
    /**
     * Metodo temEspacoNoInventario.
     * 
     * retorna um booleano se tem espaco no inventario do ator.
     *
     * @return boolean
     */
    public boolean temEspacoNoInventario () {
        return (bagagem.size() < atributos.get(CAPACIDADE));
    }
    
    /**
     * Metodo temItem.
     * 
     * retorna um booleano dizendo se tem o item atraves do nome passado.
     *
     * @return boolean
     */
    public boolean temItem (String nome) {
        for (Item item : bagagem) {
        	if (item.getNome().equalsIgnoreCase(nome)) {
        		return true;
        	}
        }
        return false;
    }
    
    /**
     * Metodo Abstrato mensagemConversa.
     */
    public abstract String mensagemConversa ();
    
}
