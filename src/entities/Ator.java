package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static entities.Atributo.*;
import static entities.Resultado.*;
import java.util.Collections;

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
 * @author Filipe Barros Rodrigues
 * @version 2017.06.07
 */
public abstract class Ator {

    private String nome;
    private String imagem;
    private HashMap<Atributo, Integer> atributos;
    private Habilidade habilidade;
    private List<Item> bagagem;
    private boolean aliado;
    private boolean neutralizado;

    /**
     * Construtor padrão da classe Ator.
     *
     * @param nome O nome do Ator.
     * @param hp A quantidade de pontos de vida do Ator. Se for igual a zero,
     * está morto. Maior que zero, vivo. Menor que zero é imortal.
     * @param capacidade Capacidade máxima de carga de itens (em n° de itens).
     * @param habilidade A habilidade especial do Ator.
     * @param bagagem Uma {@link java.util.List} de {@link Item}s portados pelo
     * Ator.
     * @param aliado Se o Ator é aliado do protagonista ({@link Cesar}), true.
     * Senão, false.
     */
    public Ator(String nome, int hp, int capacidade, Habilidade habilidade, List<Item> bagagem, boolean aliado) {
        this.nome = nome;
        this.imagem = nome;
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
     * @return List<Resultado> com os resultados após um ator sofrer ataque.
     */
    private List<Resultado> afetarAtor(List<Efeito> efeitos, Ator alvo) {
        List<Resultado> resultados = new ArrayList<>();
        for (Efeito efeito : efeitos) {
            resultados.add(efeito.aplicar(alvo));
        }
        return resultados;
    }

    /**
     * Metodo getItemPorNome.
     *
     * Tem como funcao pegar um determinado item atraves de seu nome.
     *
     * @param nomeDoItem uma String com o nome do item que desejo verificar pelo
     * nome
     * @return int com a posicao do item a ser pego.
     */
    private int getItemPorNome(String nomeDoItem) {
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
     * @return {@link Item} um Item a ser dado a um ator.
     */
    public Item darItem(String nomeDoItem) {
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
     * @param nomeDoItem uma String com o nome do item que desejo verificar a
     * descricao
     * @return String com a descricao dos itens possuidos.
     */
    public String getDescricaoItem(String nomeDoItem) {
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
     * @return List<Resultado> apos usar um item.
     */
    public List<Resultado> usarItem(String nomeDoItem, Ator alvo) {
        int index = getItemPorNome(nomeDoItem);
        if (index >= 0) {
            Item item = bagagem.get(index);
            if (item.ehConsumivel()) {
                bagagem.remove(index);
            }
            return afetarAtor(item.getEfeitos(), alvo);
        }
        List<Resultado> naoTem = new ArrayList<>();
        naoTem.add(ITEM_NAO_ENCONTRADO);
        return naoTem;
    }

    /**
     * Metodo usarItem.
     *
     * aplica os efeitos de um item em um ator alvo.
     *
     * @param item um {@link Item} que aplica seus efeitos em um alvo
     * @param alvo um {@link Ator} que recebe os efeitos do item passado
     * @return List<Resultado> com o resultado apos usar um item. 
     */
    public List<Resultado> usarItem(Item item, Ator alvo) {
        return afetarAtor(item.getEfeitos(), alvo);
    }

    /**
     * Metodo coletarItem.
     *
     * Coleta um determinado item de um ambiente
     *
     * @param item um {@link Item} que coleta os itens de um ambiente
     * @return Resultado após coletar tentar coletar um item.
     */
    public Resultado coletarItem(Item item) {
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
     * @return Resultado resultado de um ator após sofrer ataque de uma habilidade.
     */
    public List<Resultado> usarHabilidade(Ator alvo) {
        return alvo.afetarAtor(habilidade.getEfeitos(), alvo);
    }

    /**
     * Metodo afetarHP.
     *
     * afeta o HP de um ator, reduzindo a quantidade passado por parametro
     *
     * @param quantidade um inteiro que determina a quantidade de HP que um Ator
     * ira perder.
     * @return Resultado resultado após um ator perder HP.
     */
    private Resultado afetarHP(int quantidade) {
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
     * @param quantidade um inteiro que diz a quantidade que um atributo ira
     * perder.
     * @return Resultado resultado após sofrer ataque em um atributo.
     */
    public Resultado afetarAtributo(Atributo atributo, int quantidade) {
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
     * @return String com o status do Ator.
     */
    public String getStatus() {
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
     * @return String com o nome do Ator.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo setImagem.
     *
     * tem funcao de setar um nome pra imagem relacionada ao Ator.
     *
     * @param imagem String contendo o nome da imagem (sem extensão).
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    /**
     * Metodo getImagem.
     *
     * Tem como funcao pegar o nome da imagem relacionada ao ator e retornar como uma String
     *
     * @return String com o nome da imagem (sem extensão).
     */
    public String getImagem() {
        return imagem;
    }
    
    /**
     * Metodo getAtributo.
     *
     * Tem como funcao pegar os atributos do Ator e retornar um inteiro.
     *
     * @param atributo os {@link Atributo} do ator.
     * @return int com a quantidade de atributos.
     */
    public int getAtributo(Atributo atributo) {
        return atributos.get(atributo);
    }

    /**
     * Metodo getListaItens.
     *
     * Pega tudo que ator tem em sua bagagem e retorna como uma String
     *
     * @return String com uma lista de Itens que o ator Possui.
     */
    public String getListaItens() {
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
     * Metodo getItens.
     *
     * retorna uma lista não modificavel dos itens no inventário.
     *
     * @return List<Item> com todos os itens do inventário.
     */
    public List<Item> getItens() {
        return Collections.unmodifiableList(bagagem);
    }

    /**
     * Metodo getNomeHabilidade.
     *
     * retorna o nome da habilidade do ator naquele momento.
     *
     * @return String com o nome da habilidade atual do ator.
     */
    public String getNomeHabilidade() {
        return habilidade.getNome();
    }

    /**
     * Metodo getDescricaoHabilidade.
     *
     * retorna a descricao da habilidade que o ator tem naquele momento.
     *
     * @return String com a descricao da habilidade do ator.
     */
    public String getDescricaoHabilidade() {
        return habilidade.getDescricao();
    }

    /**
     * Metodo taVivo.
     *
     * retorna um booleano se o Ator esta vivo ou morto.
     *
     * @return boolean se o ator está vivo, true, senão, false.
     */
    public boolean taVivo() {
        return ((atributos.get(HP) == 0) ? (false) : (true));
    }

    /**
     * Metodo setAliado.
     *
     * tem funcao de setar um ator como seu aliado.
     *
     * @param aliado boolean pra definir se um ator é aliado do outro.
     */
    public void setAliado(boolean aliado) {
        this.aliado = aliado;
    }

    /**
     * Metodo ehAliado.
     *
     * retorna um booleano pra dizer se um ator eh seu aliado ou nao
     *
     * @return boolean se um ator é aliado do outro, true, senão, false.
     */
    public boolean ehAliado() {
        return aliado;
    }

    /**
     * Metodo taNeutralizado.
     *
     * retorna um booleano se o ator ta neutralizado ou nao.
     *
     * @return boolean se um ator foi neutralizado, true, senão, false.
     */
    public boolean taNeutralizado() {
        return neutralizado;
    }
    
    /**
     * Metodo setNeutralizado.
     *
     * Modifica o status de neutralização
     *
     * @param neutralizado true se sim, false se não.
     */
    protected void setNeutralizado(boolean neutralizado) {
        this.neutralizado = neutralizado;
    }

    /**
     * Metodo ehImortal.
     *
     * retorna um booleano se o ator eh imortal ou nao.
     *
     * @return boolean se um ator é imortal, true, senão, false.
     */
    public boolean ehImortal() {
        return atributos.get(HP) < 0;
    }

    /**
     * Metodo temEspacoNoInventario.
     *
     * retorna um booleano se tem espaco no inventario do ator.
     *
     * @return boolean se o ator tem espaco em seu inventario, true, senão, false.
     */
    public boolean temEspacoNoInventario() {
        return (bagagem.size() < atributos.get(CAPACIDADE));
    }

    /**
     * Metodo temItem.
     *
     * retorna um booleano dizendo se tem o item atraves do nome passado.
     * 
     * @param nome String com o nome do item para checar na bagagem.
     * @return boolean se um ator tem um determinado Item, true, senão, false.
     */
    public boolean temItem(String nome) {
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
    public abstract String mensagemConversa();

    /**
     * Método getHabilidade
     * 
     * @return Habilidade do Ator
     */
    public Habilidade getHabilidade() {
        return habilidade;
    }

    /**
     * Método setHabilidade
     * muda a habilidade do Ator
     * @param habilidade nova habilidade
     */
    public void setHabilidade(Habilidade habilidade) {
        this.habilidade = habilidade;
    }
    
    /**Metodo adicionarAtributo.
     * 
     * adiciona um atributo ao ator.
     * 
     * @param atributo atributo a ser adicionado
     * @param id id do ator
     */
    protected void adicionarAtributo (Atributo atributo, int id) {
        atributos.put(atributo, id);
    }

}
