package core;

import entities.AlteracaoDeHP;
import entities.Cesar;
import entities.Item;
import entities.Ator;
import entities.Cachorro;
import entities.Medico;
import entities.Vendedor;
import entities.Resultado;
import entities.Chilofompila;
import entities.Efeito;
import entities.Farmaceuta;
import entities.AlteracaoDeSanidade;
import entities.Ambiente;
import entities.NPC;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.*;
import static core.EstadoDeJogo.*;
import static entities.Ambiente.SEM_SAIDA;
import static entities.Resultado.*;
import static entities.Atributo.*;

/**
 * Classe ManicomioDeZulu - responsável por criar os ambientes colocar os
 * objetos pelas ruas e os npc's em seus lugares.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 *
 * Essa classe é uma das mais importantes, pois ela cria todos os ambientes,
 * colococa todos os objetos espalhados no mapa, e todos os npc's pra que o
 * jogador possa interagir.
 *
 * @author Raydson Ferreira Carlota
 * @version 2017.06.09
 */
public class ManicomioDeZulu {

    /**
     * Attributes
     */

    private Ambiente ambienteAtual;
    private Cesar protagonista;
    private EstadoDeJogo status;
    private List<InterfaceDeJogoListener> interfacesDeJogo;

    /**
     * Construtor da classe ManicomioDeZulu.
     *
     */
    public ManicomioDeZulu() {
        criarAmbientes();
        inicializarIO();
        status = new EstadoDeJogo();
    }

    /**
     * Metodo inicializar
     *
     * Incializa os comandos de entrada do jogo.
     */
    private void inicializarIO() {
        interfacesDeJogo = new ArrayList<>();
        protagonista = new Cesar();
    }

    public void adicionarInterfaceDeJogoListener(InterfaceDeJogoListener listener) {
        interfacesDeJogo.add(listener);
        JogoEvent evento = new JogoEvent(ambienteAtual.getListaSaidas());
        imprimirBoasVindas(evento);
    }

    public void atualizarInterfaces(JogoEvent evt) {
        for (InterfaceDeJogoListener interfaceDeJogo : interfacesDeJogo) {
            interfaceDeJogo.envioDeComandoPerformed(evt);
        }
    }

    /**
     * Metodo criarAmbientes
     *
     * responsavel por criar todos os ambientes, colocar as direcoes a cada
     * comando.
     *
     */
    private void criarAmbientes() {
        Ambiente esquina_Fortran_Python, esquina_Fortran_Cobol, esquina_Fortran_Lua, esquina_Fortran_Snobol,
                esquina_Smalltalk_Python, esquina_Smalltalk_Cobol, esquina_Smalltalk_Lua, esquina_Smalltalk_Snobol,
                esquina_Haskell_Python, esquina_Haskell_Cobol, esquina_Haskell_Lua, esquina_Haskell_Snobol,
                esquina_Prolog_Python, esquina_Prolog_Cobol, esquina_Prolog_Lua, esquina_Prolog_Snobol;

        esquina_Fortran_Python = new Ambiente("Esquina da rua Fortran com a rua Python", "esquina");
        esquina_Fortran_Cobol = new Ambiente("Esquina da rua Fortran com a rua Cobol", "esquina");
        esquina_Fortran_Lua = new Ambiente("Esquina da rua Fortran com a rua Lua", "esquina");
        esquina_Fortran_Snobol = new Ambiente("Esquina da rua Fortran com a rua Snobol", "esquina");
        esquina_Smalltalk_Python = new Ambiente("Esquina da rua Smalltalk com a rua Python", "esquina");
        esquina_Smalltalk_Cobol = new Ambiente("Esquina da rua Smalltalk com a rua Cobol", "esquina");
        esquina_Smalltalk_Lua = new Ambiente("Esquina da rua Smalltalk com a rua Lua", "esquina");
        esquina_Smalltalk_Snobol = new Ambiente("Esquina da rua Smalltalk com a rua Snobol", "esquina");
        esquina_Haskell_Python = new Ambiente("Esquina da rua Haskell com a rua Python", "esquina");
        esquina_Haskell_Cobol = new Ambiente("Esquina da rua Haskell com a rua Cobol", "esquina");
        esquina_Haskell_Lua = new Ambiente("Esquina da rua Haskell com a rua Lua", "esquina");
        esquina_Haskell_Snobol = new Ambiente("Esquina da rua Haskell com a rua Snobol", "esquina");
        esquina_Prolog_Python = new Ambiente("Esquina da rua Prolog com a rua Python", "esquina");
        esquina_Prolog_Cobol = new Ambiente("Esquina da rua Prolog com a rua Cobol", "esquina");
        esquina_Prolog_Lua = new Ambiente("Esquina da rua Prolog com a rua Lua", "esquina");
        esquina_Prolog_Snobol = new Ambiente("Esquina da rua Prolog com a rua Snobol", "esquina");

        List<Ambiente> ruaPython = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            String descricao = "Rua Python, " + (i * 4 + 50);
            ruaPython.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }
        Ambiente casaDoCesar = new Ambiente("Rua Python, 118 - Sua casa", "casa2");

        List<Ambiente> ruaCobol = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String descricao = "Rua Cobol, " + (i * 4 + 150);
            ruaCobol.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }
        Ambiente loja = new Ambiente("Loja do Coveiro", "coveiro");
        Ambiente cemiterio = new Ambiente("Entrada do Cemitério Parada Final", "cemiterio");

        List<Ambiente> ruaLua = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String descricao = "Rua Lua, " + (i * 4 + 350);
            ruaLua.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }

        List<Ambiente> ruaSnobol = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String descricao = "Rua Snobol, " + (i * 4 + 450);
            ruaSnobol.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }
        Ambiente farmacia = new Ambiente("Drogaria Saradão", "farmacia");
        Ambiente faculdade = new Ambiente("UFLA 'Universidade Federal de Loucos Autistas' [FECHADA]", "escola");

        List<Ambiente> ruaSmalltalk = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String descricao = "Rua Smalltalk, " + (i * 4 + 550);
            ruaSmalltalk.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }
        Ambiente manicomio = new Ambiente("Recepção do Manicômio Olo & Co", "manicomio");

        List<Ambiente> ruaHaskell = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String descricao = "Rua Haskell, " + (i * 4 + 650);
            ruaHaskell.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }

        List<Ambiente> ruaProlog = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String descricao = "Rua Prolog, " + (i * 4 + 750);
            ruaProlog.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }

        List<Ambiente> saidaDaCidade = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            String descricao = "Saída de Zulu";
            saidaDaCidade.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }

        esquina_Fortran_Python.ajustarSaida("norte", saidaDaCidade.get(0));
        esquina_Fortran_Python.ajustarSaida("leste", ruaPython.get(0));
        esquina_Fortran_Python.ajustarSaida("sul", esquina_Fortran_Cobol);

        esquina_Fortran_Cobol.ajustarSaida("norte", esquina_Fortran_Python);
        esquina_Fortran_Cobol.ajustarSaida("leste", ruaCobol.get(0));
        esquina_Fortran_Cobol.ajustarSaida("sul", esquina_Fortran_Lua);

        esquina_Fortran_Lua.ajustarSaida("norte", esquina_Fortran_Cobol);
        esquina_Fortran_Lua.ajustarSaida("leste", ruaLua.get(0));
        esquina_Fortran_Lua.ajustarSaida("sul", esquina_Fortran_Snobol);

        esquina_Fortran_Snobol.ajustarSaida("norte", esquina_Fortran_Lua);
        esquina_Fortran_Snobol.ajustarSaida("leste", ruaSnobol.get(0));
        esquina_Fortran_Snobol.ajustarSaida("sul", saidaDaCidade.get(11));

        esquina_Smalltalk_Python.ajustarSaida("norte", ruaSmalltalk.get(1));
        esquina_Smalltalk_Python.ajustarSaida("leste", ruaPython.get(5));
        esquina_Smalltalk_Python.ajustarSaida("sul", ruaSmalltalk.get(2));
        esquina_Smalltalk_Python.ajustarSaida("oeste", ruaPython.get(4));

        esquina_Smalltalk_Cobol.ajustarSaida("norte", ruaSmalltalk.get(2));
        esquina_Smalltalk_Cobol.ajustarSaida("leste", loja);
        esquina_Smalltalk_Cobol.ajustarSaida("sul", esquina_Smalltalk_Lua);
        esquina_Smalltalk_Cobol.ajustarSaida("oeste", ruaCobol.get(1));

        esquina_Smalltalk_Lua.ajustarSaida("norte", esquina_Smalltalk_Cobol);
        esquina_Smalltalk_Lua.ajustarSaida("leste", esquina_Haskell_Lua);
        esquina_Smalltalk_Lua.ajustarSaida("sul", esquina_Smalltalk_Snobol);
        esquina_Smalltalk_Lua.ajustarSaida("oeste", ruaLua.get(0));

        esquina_Smalltalk_Snobol.ajustarSaida("norte", esquina_Smalltalk_Lua);
        esquina_Smalltalk_Snobol.ajustarSaida("leste", ruaSnobol.get(1));
        esquina_Smalltalk_Snobol.ajustarSaida("sul", manicomio);
        esquina_Smalltalk_Snobol.ajustarSaida("oeste", ruaSnobol.get(0));

        esquina_Haskell_Python.ajustarSaida("norte", ruaHaskell.get(2));
        esquina_Haskell_Python.ajustarSaida("leste", ruaPython.get(9));
        esquina_Haskell_Python.ajustarSaida("sul", esquina_Haskell_Cobol);
        esquina_Haskell_Python.ajustarSaida("oeste", ruaPython.get(8));

        esquina_Haskell_Cobol.ajustarSaida("norte", esquina_Haskell_Python);
        esquina_Haskell_Cobol.ajustarSaida("leste", esquina_Prolog_Cobol);
        esquina_Haskell_Cobol.ajustarSaida("sul", esquina_Haskell_Lua);
        esquina_Haskell_Cobol.ajustarSaida("oeste", ruaCobol.get(2));

        esquina_Haskell_Lua.ajustarSaida("norte", esquina_Haskell_Cobol);
        esquina_Haskell_Lua.ajustarSaida("leste", ruaLua.get(1));
        esquina_Haskell_Lua.ajustarSaida("sul", esquina_Haskell_Snobol);
        esquina_Haskell_Lua.ajustarSaida("oeste", esquina_Smalltalk_Lua);

        esquina_Haskell_Snobol.ajustarSaida("norte", esquina_Haskell_Lua);
        esquina_Haskell_Snobol.ajustarSaida("leste", farmacia);
        esquina_Haskell_Snobol.ajustarSaida("sul", saidaDaCidade.get(9));
        esquina_Haskell_Snobol.ajustarSaida("oeste", ruaSnobol.get(1));

        esquina_Prolog_Python.ajustarSaida("norte", ruaProlog.get(2));
        esquina_Prolog_Python.ajustarSaida("leste", ruaPython.get(14));
        esquina_Prolog_Python.ajustarSaida("sul", esquina_Prolog_Cobol);
        esquina_Prolog_Python.ajustarSaida("oeste", ruaPython.get(13));

        esquina_Prolog_Cobol.ajustarSaida("norte", esquina_Prolog_Python);
        esquina_Prolog_Cobol.ajustarSaida("leste", ruaCobol.get(3));
        esquina_Prolog_Cobol.ajustarSaida("sul", esquina_Prolog_Lua);
        esquina_Prolog_Cobol.ajustarSaida("oeste", esquina_Haskell_Cobol);

        esquina_Prolog_Lua.ajustarSaida("norte", esquina_Prolog_Cobol);
        esquina_Prolog_Lua.ajustarSaida("leste", ruaLua.get(2));
        esquina_Prolog_Lua.ajustarSaida("sul", esquina_Prolog_Snobol);
        esquina_Prolog_Lua.ajustarSaida("oeste", ruaLua.get(1));

        esquina_Prolog_Snobol.ajustarSaida("norte", esquina_Prolog_Lua);
        esquina_Prolog_Snobol.ajustarSaida("leste", ruaSnobol.get(2));
        esquina_Prolog_Snobol.ajustarSaida("sul", saidaDaCidade.get(8));
        esquina_Prolog_Snobol.ajustarSaida("oeste", farmacia);

        for (int i = 0; i < 17; i++) {
            switch (i) {
                case 0:
                    ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
                    ruaPython.get(i).ajustarSaida("oeste", esquina_Fortran_Python);
                    break;
                case 4:
                    ruaPython.get(i).ajustarSaida("leste", esquina_Smalltalk_Python);
                    ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
                    break;
                case 5:
                    ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
                    ruaPython.get(i).ajustarSaida("oeste", esquina_Smalltalk_Python);
                    break;
                case 8:
                    ruaPython.get(i).ajustarSaida("leste", esquina_Haskell_Python);
                    ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
                    break;
                case 9:
                    ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
                    ruaPython.get(i).ajustarSaida("oeste", esquina_Haskell_Python);
                    break;
                case 13:
                    ruaPython.get(i).ajustarSaida("leste", esquina_Prolog_Python);
                    ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
                    break;
                case 14:
                    ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
                    ruaPython.get(i).ajustarSaida("oeste", esquina_Prolog_Python);
                    break;
                case 16:
                    ruaPython.get(i).ajustarSaida("leste", casaDoCesar);
                    ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
                    break;
                default:
                    ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
                    ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
                    break;
            }
        }
        casaDoCesar.ajustarSaida("oeste", ruaPython.get(16));
        casaDoCesar.ajustarSaida("leste", saidaDaCidade.get(4));

        ruaCobol.get(0).ajustarSaida("leste", ruaCobol.get(1));
        ruaCobol.get(0).ajustarSaida("oeste", esquina_Fortran_Cobol);
        ruaCobol.get(1).ajustarSaida("leste", esquina_Smalltalk_Cobol);
        ruaCobol.get(1).ajustarSaida("oeste", ruaCobol.get(0));
        ruaCobol.get(2).ajustarSaida("leste", esquina_Haskell_Cobol);
        ruaCobol.get(2).ajustarSaida("oeste", loja);
        ruaCobol.get(3).ajustarSaida("leste", ruaCobol.get(4));
        ruaCobol.get(3).ajustarSaida("oeste", esquina_Prolog_Cobol);
        ruaCobol.get(4).ajustarSaida("leste", cemiterio);
        ruaCobol.get(4).ajustarSaida("oeste", ruaCobol.get(3));
        loja.ajustarSaida("leste", ruaCobol.get(2));
        loja.ajustarSaida("oeste", esquina_Smalltalk_Cobol);
        cemiterio.ajustarSaida("leste", saidaDaCidade.get(5));
        cemiterio.ajustarSaida("oeste", ruaCobol.get(4));

        ruaLua.get(0).ajustarSaida("leste", esquina_Smalltalk_Lua);
        ruaLua.get(0).ajustarSaida("oeste", esquina_Fortran_Lua);
        ruaLua.get(1).ajustarSaida("leste", esquina_Prolog_Lua);
        ruaLua.get(1).ajustarSaida("oeste", esquina_Haskell_Lua);
        ruaLua.get(2).ajustarSaida("leste", ruaLua.get(3));
        ruaLua.get(2).ajustarSaida("oeste", esquina_Prolog_Lua);
        ruaLua.get(3).ajustarSaida("leste", saidaDaCidade.get(6));
        ruaLua.get(3).ajustarSaida("oeste", ruaLua.get(2));

        ruaSnobol.get(0).ajustarSaida("leste", esquina_Smalltalk_Snobol);
        ruaSnobol.get(0).ajustarSaida("oeste", esquina_Fortran_Snobol);
        ruaSnobol.get(1).ajustarSaida("leste", esquina_Haskell_Snobol);
        ruaSnobol.get(1).ajustarSaida("oeste", esquina_Smalltalk_Snobol);
        ruaSnobol.get(2).ajustarSaida("leste", faculdade);
        ruaSnobol.get(2).ajustarSaida("oeste", esquina_Prolog_Snobol);
        farmacia.ajustarSaida("leste", esquina_Prolog_Snobol);
        farmacia.ajustarSaida("oeste", esquina_Haskell_Snobol);
        faculdade.ajustarSaida("leste", saidaDaCidade.get(7));
        faculdade.ajustarSaida("oeste", ruaSnobol.get(2));

        ruaSmalltalk.get(0).ajustarSaida("norte", saidaDaCidade.get(1));
        ruaSmalltalk.get(0).ajustarSaida("sul", ruaSmalltalk.get(1));
        ruaSmalltalk.get(1).ajustarSaida("norte", ruaSmalltalk.get(0));
        ruaSmalltalk.get(1).ajustarSaida("sul", esquina_Smalltalk_Python);
        ruaSmalltalk.get(2).ajustarSaida("norte", esquina_Smalltalk_Python);
        ruaSmalltalk.get(2).ajustarSaida("sul", esquina_Smalltalk_Cobol);
        manicomio.ajustarSaida("norte", esquina_Smalltalk_Snobol);
        manicomio.ajustarSaida("sul", saidaDaCidade.get(10));

        ruaHaskell.get(0).ajustarSaida("norte", saidaDaCidade.get(2));
        ruaHaskell.get(0).ajustarSaida("sul", ruaHaskell.get(1));
        ruaHaskell.get(1).ajustarSaida("norte", ruaHaskell.get(0));
        ruaHaskell.get(1).ajustarSaida("sul", ruaHaskell.get(2));
        ruaHaskell.get(2).ajustarSaida("norte", ruaHaskell.get(1));
        ruaHaskell.get(2).ajustarSaida("sul", esquina_Haskell_Python);

        ruaProlog.get(0).ajustarSaida("norte", saidaDaCidade.get(3));
        ruaProlog.get(0).ajustarSaida("sul", ruaProlog.get(1));
        ruaProlog.get(1).ajustarSaida("norte", ruaProlog.get(0));
        ruaProlog.get(1).ajustarSaida("sul", ruaProlog.get(2));
        ruaProlog.get(2).ajustarSaida("norte", ruaProlog.get(1));
        ruaProlog.get(2).ajustarSaida("sul", esquina_Prolog_Python);

        saidaDaCidade.get(0).ajustarSaida("sul", esquina_Fortran_Python);
        saidaDaCidade.get(1).ajustarSaida("sul", esquina_Smalltalk_Python);
        saidaDaCidade.get(2).ajustarSaida("sul", esquina_Haskell_Python);
        saidaDaCidade.get(3).ajustarSaida("sul", esquina_Prolog_Python);
        saidaDaCidade.get(4).ajustarSaida("oeste", casaDoCesar);
        saidaDaCidade.get(5).ajustarSaida("oeste", cemiterio);
        saidaDaCidade.get(6).ajustarSaida("oeste", ruaLua.get(3));
        saidaDaCidade.get(7).ajustarSaida("oeste", faculdade);
        saidaDaCidade.get(8).ajustarSaida("norte", esquina_Prolog_Snobol);
        saidaDaCidade.get(9).ajustarSaida("norte", esquina_Haskell_Snobol);
        saidaDaCidade.get(10).ajustarSaida("norte", manicomio);
        saidaDaCidade.get(11).ajustarSaida("norte", esquina_Fortran_Snobol);

        ambienteAtual = esquina_Haskell_Python;

        Efeito chuveiradaSan = new AlteracaoDeSanidade("Restaurar Sanidade", "Restaura 9 pontos de Sanidade", 9);
        Efeito chuveiradaHP = new AlteracaoDeHP("Restaurar HP", "Restaura 5 pontos de HP", 5);
        List<Efeito> efeitosChuveiro = new ArrayList<>();
        efeitosChuveiro.add(chuveiradaHP);
        efeitosChuveiro.add(chuveiradaSan);
        Item chuveiro = new Item("Chuveiro", "Uma bela ducha quente, ótima nesse friozinho de Zulu!", efeitosChuveiro, true, false);
        Item carteira = new Item("Carteira", "Contém seus documentos e dinheiro o suficiente.", new ArrayList<>(), false, true);
        Item mapa = new Item("Mapa", "É um bom mapa de Zulu. Estão circulados pontos importantes", new ArrayList<>(), false, true);
        casaDoCesar.colocarItem(chuveiro);
        casaDoCesar.colocarItem(carteira);
        casaDoCesar.colocarItem(mapa);

        int contaCachorro;
        contaCachorro = adicionarCachorrosEPedras(ruaCobol, 1);
        contaCachorro = adicionarCachorrosEPedras(ruaHaskell, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaLua, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaProlog, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaPython, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaSmalltalk, contaCachorro);
        adicionarCachorrosEPedras(ruaSnobol, contaCachorro);

        for (int i = 0; i < 12; i++) {
            saidaDaCidade.get(i).colocarNPC(new Chilofompila());
        }
        faculdade.colocarNPC(new Cachorro("Cachorro"));
        manicomio.colocarNPC(new Medico("Raydson"));
        farmacia.colocarNPC(new Farmaceuta("Filipe"));
        loja.colocarNPC(new Vendedor("Velho"));

    }

    /**
     * Metodo adicionarCachorrosEPedras
     *
     * coloca os objetos e os npc's nos ambientes.
     *
     * @param rua
     * @param contador
     * @return int
     */
    private int adicionarCachorrosEPedras(List<Ambiente> rua, int contador) {
        int contaCachorro = contador;
        Efeito pedrada = new AlteracaoDeHP("Subtrair HP", "Retira 5 pontos de HP", -5);
        List<Efeito> efeitosPedrada = new ArrayList<>();
        efeitosPedrada.add(pedrada);
        Random rnd = new Random();
        for (int i = 0; i < rua.size(); i++) {
            int x = rnd.nextInt(3);
            if (x > 0) {
                rua.get(i).colocarNPC(new Cachorro("Cachorro" + contaCachorro));
                contaCachorro++;
            }
            x = rnd.nextInt(3);
            if (x > 0) {
                rua.get(i).colocarItem(new Item("Pedra", "Um cascalho comum. Cabe na mão.", efeitosPedrada, true, true));
            }
        }
        return contaCachorro;
    }

    /**
     * Metodo processarComando
     *
     * responsavel por processar o camando de entrada e indica o que fazer em
     * seguida com o comando passado.
     *
     * @param comando do tipo {@link Comando}, passa o comando de entrada do
     * usuario
     * @return boolean.
     */
    public void processarComando(Comando comando) {
        JogoEvent evento = new JogoEvent(ambienteAtual.getListaSaidas());
        if (comando.ehDesconhecido()) {
            evento.emendarSaida("Você está louco? Digite [ajuda] se precisar de algo...");
            atualizarInterfaces(evento);
            return;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda(evento);
        } else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando, evento);
        } else if (palavraDeComando.equals("sair")) {
            sair(evento);
        } else if (palavraDeComando.equals("status")) {
            imprimirStatus(comando, evento);
        } else if (palavraDeComando.equals("descrever")) {
            descrever(comando, evento);
        } else if (palavraDeComando.equals("detalhar")) {
            detalhar(comando, evento);
        } else if (palavraDeComando.equals("mostrar")) {
            mostrarInventario(comando, evento);
        } else if (palavraDeComando.equals("conversar")) {
            conversar(comando, evento);
        } else if (palavraDeComando.equals("atacar")) {
            atacar(comando, evento);
        } else if (palavraDeComando.equals("coletar")) {
            coletar(comando, evento);
        } else if (palavraDeComando.equals("usar")) {
            usar(comando, evento);
        } else if (palavraDeComando.equals("descartar")) {
            descartar(comando, evento);
        } else if (palavraDeComando.equals("pedir")) {
            pedir(comando, evento);
        } else if (palavraDeComando.equals("cancelar")) {
            cancelar(evento);
        } else if (palavraDeComando.equals("fugir")) {
            fugir(evento);
        } else if (palavraDeComando.equals("checar")) {
            checar(comando, evento);
        }

        if (!protagonista.taVivo() || protagonista.enlouqueceuDeVez()) {
            evento.emendarSaida("Você perdeu!!! Você deixou que te tua loucura te dominasse por");
            evento.emendarSaida("completo!!!");
            sair(evento);
        } else if (protagonista.taCurado()) {
            evento.emendarSaida("PARABÉNS, VOCÊ FOI CURADO!!!! Agora fique esperto para não deixar");
            evento.emendarSaida("de tomar teus remédios na hora certa!!");
            sair(evento);
        }
        atualizarInterfaces(evento);
    }

    /**
     * Metodo atacar
     *
     * responsavel por atacar um npc que estiver no ambiente.
     *
     * @param comando do tipo {@link Comando}, recebe alem do comando atacar,
     * tambem indica quem atacar, caso não passe quem atacar nao ha o que fazer.
     */
    private void atacar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Atacar quem?");
            return;
        }
        if (status.getEstadoAtual() == NAVEGANDO) {
            NPC alvo = ambienteAtual.selecionarNPC(comando.getSegundaPalavra());
            if (alvo != null) {
                status.setEstadoAtual(ATACANDO, alvo.getNome());
                evento.setLimparTela(true);
                evento.emendarSaida("Você se prepara para emboscar " + alvo.getNome() + "...");
                evento.emendarSaida("");
                evento.emendarSaida("O que vai fazer?");
            } else {
                evento.emendarSaida("Você está atacando alguém que não existe! Procure [ajuda] urgente!!");
            }
        } else {
            evento.emendarSaida("Você não pode fazer isso agora!");
        }
    }

    /**
     * Metodo conversar
     *
     * responsavel por conversar com um npc.
     *
     * @param comando do tipo {@link Comando}, recebe alem do comando conversar,
     * tambem com quem conversar.
     */
    private void conversar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Conversar com quem?");
            return;
        }
        if (status.getEstadoAtual() == NAVEGANDO) {
            NPC alvo = ambienteAtual.selecionarNPC(comando.getSegundaPalavra());
            if (alvo != null) {
                if (protagonista.taMuitoInsano()) {
                    alvo.setAliado(false);
                } else {
                    alvo.setAliado(true);
                }
                evento.setLimparTela(true);
                status.setEstadoAtual(CONVERSANDO, alvo.getNome());
                evento.emendarSaida("Você se aproximou de " + alvo.getNome() + " e o cumprimentou...");
                evento.emendarSaida("");
                evento.emendarSaida(alvo.mensagemConversa());
            } else {
                evento.emendarSaida("Você está conversando com alguém que não existe! Procure [ajuda] urgente!!");
            }
        } else {
            evento.emendarSaida("Você não pode fazer isso agora!");
        }
    }

    /**
     * Metodo pedir
     *
     * responsavel por pedir algo a um npc.
     *
     * @param comando do tipo {@link Comando}, recebe alem do comando pedir,
     * tambem a quem pedir
     */
    private void pedir(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Pedir o quê?");
            return;
        }
        if (status.getEstadoAtual() == CONVERSANDO) {
            NPC alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
            if (alvo.temItem(comando.getSegundaPalavra())) {
                if (protagonista.temItem("Carteira")) {
                    if (protagonista.temEspacoNoInventario()) {
                        protagonista.coletarItem(alvo.entregarItemDeQuest());
                        evento.emendarSaida("Item recebido!");
                    } else {
                        evento.emendarSaida("Inventário lotado!");
                    }
                } else {
                    evento.emendarSaida("Você não tem carteira agora!");
                }
            } else {
                evento.emendarSaida("Ele não tem esse item!");
            }
        } else {
            evento.emendarSaida("Como assim pedir, tá doido? Peça [ajuda] urgente...");
        }
    }

    /**
     * Metodo cancelar
     *
     * cancela uma operacao.
     *
     */
    private void cancelar(JogoEvent evento) {
        if (status.getEstadoAtual() == CONVERSANDO) {
            status.setEstadoAtual(NAVEGANDO, "");
            evento.setLimparTela(true);
            evento.emendarSaida("Você foi embora!");
            exibirAmbienteAtual(evento);
        } else {
            evento.emendarSaida("Cancelar o quê?");
        }
    }

    /**
     * Metodo fugir
     *
     * foge de uma luta com um npc.
     *
     *
     */
    private void fugir(JogoEvent evento) {
        if (status.getEstadoAtual() == ATACANDO) {
            if (ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual()).ehImortal()) {
                status.setEstadoAtual(NAVEGANDO, "");
                evento.setLimparTela(true);
                evento.emendarSaida("Você fugiu!");
                exibirAmbienteAtual(evento);
            } else {
                evento.emendarSaida("Você não pode fugir dessa luta!");
            }
        } else {
            evento.emendarSaida("Fugir de onde?");
        }
    }

    /**
     * Metodo usar
     *
     * responsavel por fazer o usuario usar um item.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando usar,
     * tambem qual item usar.
     */
    private void usar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Usar o quê?");
            return;
        }
        if (status.getEstadoAtual() == NAVEGANDO) {
            if (protagonista.temItem(comando.getSegundaPalavra())) {
                List<Resultado> resultados = protagonista.usarItem(comando.getSegundaPalavra(), protagonista);
                verificarResultados(protagonista, resultados, evento);
            } else {
                List<Resultado> resultados = ambienteAtual.aplicarItem(comando.getSegundaPalavra(), protagonista);
                verificarResultados(protagonista, resultados, evento);
            }
        } else if (status.getEstadoAtual() == ATACANDO) {
            Ator alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
            if (comando.getSegundaPalavra().equalsIgnoreCase("habilidade")) {
                List<Resultado> resultados = protagonista.usarHabilidade(alvo);
                verificarResultados(alvo, resultados, evento);
            } else {
                if (protagonista.temItem(comando.getSegundaPalavra())) {
                    List<Resultado> resultados = protagonista.usarItem(comando.getSegundaPalavra(), alvo);
                    verificarResultados(alvo, resultados, evento);
                } else {
                    List<Resultado> resultados = ambienteAtual.aplicarItem(comando.getSegundaPalavra(), alvo);
                    verificarResultados(alvo, resultados, evento);
                }
            }
            if (alvo.taVivo()) {
                List<Resultado> resultados = alvo.usarHabilidade(protagonista);
                verificarResultados(protagonista, resultados, evento);
            } else {
                evento.emendarSaida("Você pode continuar o jogo, e conseguiu segurar seu surto por mais uma rodada!");
                status.setEstadoAtual(NAVEGANDO, "");
                status.matou(true);
                exibirAmbienteAtual(evento);
            }
        }
    }

    private void verificarResultados(Ator alvo, List<Resultado> resultados, JogoEvent evento) {
        for (Resultado resultado : resultados) {
            switch (resultado) {
                case ATOR_ASSASSINADO:
                    evento.emendarSaida(alvo.getNome() + " foi assassinado!");
                    break;
                case ATOR_CURADO:
                    evento.emendarSaida(alvo.getNome() + " restaurou HP!");
                    break;
                case ATOR_ENFURECIDO:
                    evento.emendarSaida(alvo.getNome() + " perdeu sanidade!");
                    break;
                case ATOR_ENLOUQUECIDO:
                    evento.emendarSaida(alvo.getNome() + " enloqueceu de vez!");
                    break;
                case ATOR_EQUILIBRADO:
                    evento.emendarSaida(alvo.getNome() + " é incorruptível!");
                    break;
                case ATOR_FERIDO:
                    evento.emendarSaida(alvo.getNome() + " foi atacado e perdeu HP!");
                    break;
                case ATOR_IMORTAL:
                    evento.emendarSaida(alvo.getNome() + " é imortal!");
                    break;
                case ATOR_MORTO:
                    evento.emendarSaida(alvo.getNome() + " está morto, deixe-o!");
                    break;
                case ATOR_NEUTRALIZADO:
                    evento.emendarSaida(alvo.getNome() + " está sem condição de lutar, deixe-o!");
                    break;
                case ATOR_SANADO:
                    evento.emendarSaida(alvo.getNome() + " recuperou um pouco de Sanidade!");
                    break;
                case ATRIBUTO_NAO_APROPRIADO:
                    evento.emendarSaida(alvo.getNome() + " não sofreu dano algum!");
                    break;
                case BAGAGEM_LOTADA:
                    evento.emendarSaida("A bagagem de " + alvo.getNome() + " está lotada!");
                    break;
                case ITEM_NAO_ENCONTRADO:
                    evento.emendarSaida("Quê? Isso que você quer usar não existe, procure [ajuda] para sua loucura!");
            }
        }
    }

    /**
     * Metodo checar
     *
     * responsavel por checar o que tem dentro de cada ambiente.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando checar,
     * tambem qual ambiente checar.
     */
    private void checar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Checar o quê?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("mapa")) {
            if (status.getEstadoAtual() == NAVEGANDO) {
                if (protagonista.temItem("Mapa")) {
                    evento.setQuerMapa(true);
                } else {
                    evento.emendarSaida("Não estou com meu mapa! Mas sei que minha casa fica");
                    evento.emendarSaida("na Rua Python, 118 (Leste da esquina Prolog com Python)");
                }
            }
        }
    }

    /**
     * Metodo descartar
     *
     * responsavel por descartar um item coletado que esta com cesar
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando
     * descartar, tambem qual item descartar.
     */
    private void descartar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Descartar o quê?");
            return;
        }
        if (protagonista.temItem(comando.getSegundaPalavra())) {
            ambienteAtual.colocarItem(protagonista.darItem(comando.getSegundaPalavra()));
            evento.emendarSaida("Item descartado!");
        } else {
            evento.emendarSaida("Você não tem esse item!");
        }
    }

    /**
     * Metodo coletar
     *
     * responsavel por coletar um item do ambiente onde cesar esta.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando coletar,
     * tambem qual item coletar.
     */
    private void coletar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Coletar o quê?");
            return;
        }
        if (status.getEstadoAtual() != CONVERSANDO) {
            if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
                Item item = ambienteAtual.recolherItem(comando.getSegundaPalavra());
                if (item.ehColetavel()) {
                    protagonista.coletarItem(item);
                    evento.emendarSaida("Item coletado!");
                } else {
                    ambienteAtual.colocarItem(item);
                    evento.emendarSaida("Item não coletável!");
                }
            } else {
                evento.emendarSaida("Não tem item neste ambiente com esse nome!");
            }
        } else {
            evento.emendarSaida("Agora não dá!");
        }
    }

    /**
     * Metodo mostrarInventario
     *
     * responsavel por mostrar o inventario de cesar.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando Mostrar,
     * tambem o inventario a mostrar.
     */
    private void mostrarInventario(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Mostrar o quê?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("inventario")) {
            evento.emendarSaida(protagonista.getListaItens());
        }
    }

    /**
     * Metodo detalhar
     *
     * responsavel por detalhar um ambiente ou um protagonista.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando detalhar,
     * tambem o que detalhar.
     */
    private void detalhar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Detalhar o quê?");
            return;
        }
        if (protagonista.temItem(comando.getSegundaPalavra())) {
            evento.emendarSaida(protagonista.getDescricaoItem(comando.getSegundaPalavra()));
        } else if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
            evento.emendarSaida(ambienteAtual.getDescricaoItem(comando.getSegundaPalavra()));
        } else {
            evento.emendarSaida("Item inexistente!");
        }
    }

    /**
     * Metodo descrever
     *
     * responsavel por descrever um ambiente.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando
     * descrever, tambem qual ambiente descrever.
     */
    private void descrever(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Descrever o quê?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("ambiente")) {
            if (status.getEstadoAtual() == NAVEGANDO) {
                exibirAmbienteAtual(evento);
            }
            if (status.getEstadoAtual() != CONVERSANDO) {
                evento.emendarSaida("NPCs agora no ambiente:");
                evento.emendarSaida(ambienteAtual.getListaNPCs());
                evento.emendarSaida("Objetos no ambiente:");
                evento.emendarSaida(ambienteAtual.getListaItens());
            } else {
                evento.emendarSaida("Agora não!");
            }
        } else if (comando.getSegundaPalavra().equalsIgnoreCase("npc")) {
            if (status.getEstadoAtual() == CONVERSANDO) {
                evento.emendarSaida(ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual()).getListaItens());
            } else {
                evento.emendarSaida("Você não pode usar esse comando agora!");
            }
        } else {
            evento.emendarSaida("Forma incorreta de descrever algo! Digite [ajuda] e confira...");
        }
    }

    /**
     * Metodo imprimirStatus
     *
     * responsavel por imprimir o status de cesar ou de um protagonista
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando status,
     * tambem o status de quem deseja imprimir.
     */
    private void imprimirStatus(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.emendarSaida("Status de quem?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("npc")) {
            if (status.getEstadoAtual() == ATACANDO) {
                NPC alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
                evento.emendarSaida(alvo.getStatus());
            } else {
                evento.emendarSaida("Nesse estado você só pode ver o seu status! Tente [status eu]...");
            }
        } else if (comando.getSegundaPalavra().equalsIgnoreCase("eu")) {
            evento.emendarSaida(protagonista.getStatus());
        } else {
            evento.emendarSaida("Forma incorreta de solicitar o status! Digite [ajuda] e confira...");
        }
    }

    /**
     * Metodo imprimirBoasVindas
     *
     * Responsavel por imprimir as boas vindas do jogo (cabecalho).
     *
     * Chama o metodo exibir ambiente depois das boas vindas.
     */
    private void imprimirBoasVindas(JogoEvent evento) {
        evento.emendarSaida("    Bem Vindo ao Jogo \"World of Zuul - O Manicômio de Zulu\".");
        evento.emendarSaida("    Este é um jogo no estilo Adventure em modo texto.");
        evento.emendarSaida("\n    Boa Sorte e não enlouqueça!!!");
        evento.emendarSaida("\n    Você é César, o professor de PPOO ");
        evento.emendarSaida("(Planejamento de Planos de Organizações Organizacionais).");
        evento.emendarSaida("Você saiu da faculdade e está terrivelmente estressado, e de repente você se");
        evento.emendarSaida("lembra de que não tomou seus remédios controlados e está prestes a");
        evento.emendarSaida("enlouquecer!!!");
        evento.emendarSaida("\n    Você está no meio da cidade de Zulu, uma pequena cidade castigada pelo");
        evento.emendarSaida("descuido da prefeitura, lotada de cães raivosos de rua, num ponto próximo à");
        evento.emendarSaida("sua casa. Lá você esqueceu sua carteira, e precisa dela para comprar");
        evento.emendarSaida("seu medicamento na farmácia.");
        evento.emendarSaida("\n    Seu objetivo aqui é conseguir alcançar 30 pontos de Sanidade ou mais,");
        evento.emendarSaida("tendo em mente que como você está em uma delicada situação psicológica,");
        evento.emendarSaida("perderá 1 ponto de Sanidade a cada ambiente que você avançar, tornando");
        evento.emendarSaida("cada vez mais desafiadora a sua experiência! Descubra maneiras de explorar");
        evento.emendarSaida("o jogo com mais tempo, maneiras de controlar sua loucura e muito mais!!!");
        evento.emendarSaida("\n    E cuidado pra não zerar nenhum dos seus atributos mais importantes,");
        evento.emendarSaida("porque senão você pode acabar num caixão... Ou pior ainda... Internado");
        evento.emendarSaida("compulsoriamente no MANICÔMIO DE ZULU!\n\n");

        exibirAmbienteAtual(evento);

        atualizarInterfaces(evento);
    }

    /**
     * Metodo imprimirAjuda
     *
     * Imprime uma ajuda pro usuario do jogo com todos os comando validos em
     * determinada situacao.
     *
     */
    private void imprimirAjuda(JogoEvent evento) {
        evento.emendarSaida("Você precisa de medicamentos para lidar com a psicose!!");
        evento.emendarSaida("Seus comandos agora são:");
        evento.setLimparTela(true);
        if (status.getEstadoAtual() == NAVEGANDO) {
            evento.emendarSaida("[ir <direcao>]\tVá para a direção que quiser da lista de saídas de cada ambiente!");
            evento.emendarSaida("[descrever ambiente]\tVeja a descrição completa de onde estás!");
            evento.emendarSaida("[mostrar inventario]\tVeja o que estás carregando!");
            evento.emendarSaida("[coletar <nome_item>]\tSe seu inventário não estiver cheio, ele é seu!");
            evento.emendarSaida("[usar <nome_item>]\tVocê usará um item, em você mesmo (mesmo um ofensivo)!");
            evento.emendarSaida("[descartar <nome_item>]\tQuando já não lhe servir, deixe que alguém o pegue!");
            evento.emendarSaida("[status eu]\tVeja o seu Status!");
            evento.emendarSaida("[conversar <nome_npc>]\tConverse com eles e veja como podem te ajudar!");
            evento.emendarSaida("[atacar <nome_npc>]\tOu mostre a eles o inferno hahahaha!!");
        } else if (status.getEstadoAtual() == CONVERSANDO) {
            evento.emendarSaida("[status eu]\tVeja o seu Status!");
            evento.emendarSaida("[mostrar inventario]\tVeja o que estás carregando!");
            evento.emendarSaida("[pedir <nome_item>]\tSe tiver como pagar, peça, senão, fique aguado!");
            evento.emendarSaida("[descrever npc]\tVocê vê o inventário do NPC!");
            evento.emendarSaida("[descartar <nome_item>]\tQuando já não lhe servir, deixe que alguém o pegue!");
            evento.emendarSaida("[cancelar]\tVolte ao que estava fazendo!");
        } else if (status.getEstadoAtual() == ATACANDO) {
            evento.emendarSaida("[status eu]\tVeja o seu Status!");
            evento.emendarSaida("[status npc]\tVeja o Status do seu inimigo!");
            evento.emendarSaida("[mostrar inventario]\tVeja o que estás carregando!");
            evento.emendarSaida("[usar habilidade]\tFaça o que faz de melhor e use sua habilidade para massacrar!");
            evento.emendarSaida("[usar <nome_item>]\tVocê usará um item no seu oponente (mesmo um item positivo)!");
            evento.emendarSaida("[descrever ambiente]\tVeja o que está a sua volta!");
            evento.emendarSaida("[fugir]\tSe tiver azar de enfrentar alguém muito forte, apenas tente!");
        }
    }

    /**
     * Metodo irParaAmbiente
     *
     * responsavel por sair de um ambiente atual e ir para outro ambiente
     * passado atraves do sentido.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando ir,
     * tambem qual direcao ir.
     */
    private void irParaAmbiente(Comando comando, JogoEvent evento) {
        if (status.getEstadoAtual() == NAVEGANDO) {
            if (!comando.temSegundaPalavra()) {
                // caso o comando não tiver segunda palavra.
                evento.emendarSaida("Você é doido? Quer ir aonde?");
                return;
            }
            String direcao = comando.getSegundaPalavra();
            Ambiente proximoAmbiente = ambienteAtual.getAmbiente(direcao);
            if (proximoAmbiente == null) {
                evento.emendarSaida("Você não vai a lugar algum, procure outra saída!");
            } else {
                if (!status.teveMatanca()) {
                    protagonista.afetarAtributo(SANIDADE, -1);
                }
                evento.setLimparTela(true);
                status.matou(false);
                ambienteAtual = proximoAmbiente;
                evento.setSaidasDisponiveis(ambienteAtual.getListaSaidas());
                exibirAmbienteAtual(evento);
            }
        } else {
            evento.emendarSaida("Você está no meio de uma interação! Acabe-a e pode andar!");
        }
    }

    /**
     * Metodo exibirAmbienteAtual
     *
     * responsavel por dizer onde cesar esta no momento.
     *
     */
    private void exibirAmbienteAtual(JogoEvent evento) {
        evento.emendarSaida("Você está na " + ambienteAtual.getDescricao());
        evento.emendarSaida("Saidas:");
        String saidasDisponiveis = ambienteAtual.listarSaidasDisponiveis();
        if (saidasDisponiveis.equals(SEM_SAIDA)) {
            evento.emendarSaida("[ATENÇÃO!! O AMBIENTE ATUAL NÃO POSSUI SAÍDAS! CUIDE DISSO!]");
        } else {
            evento.emendarSaida(saidasDisponiveis);
        }
        System.out.println(ambienteAtual.getImagem());
        evento.setImagem(ambienteAtual.getImagem());
    }

    /**
     * Metodo sair
     *
     * responsavel por retornar um comando validando a saida do usuario do jogo.
     *
     * @return boolean
     */
    private void sair(JogoEvent evento) {
        evento.emendarSaida("Obrigado por jogar, até mais!");
        evento.setFinalizado(true);
        status.setFinalizado(true);
    }
}
