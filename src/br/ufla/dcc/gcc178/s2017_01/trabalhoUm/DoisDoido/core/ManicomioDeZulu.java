package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.core;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io.Comando;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io.JogoEvent;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io.FormatoDeComandoException;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.io.Entrada;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.AlteracaoDeHP;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Cesar;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Item;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Ator;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Cachorro;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Medico;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Vendedor;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Chilofompila;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Efeito;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Farmaceuta;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.AlteracaoDeSanidade;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Ambiente;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.NPC;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.core.EstadoDeJogo.*;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Ambiente.SEM_SAIDA;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Resultado.*;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Atributo.*;
import java.io.Serializable;

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
public class ManicomioDeZulu implements Serializable{

    /**
     * Attributes
     */

    private static final long serialVersionUID = 1L;
    
    private Ambiente ambienteAtual;
    private Cesar protagonista;
    private EstadoDeJogo status;
    private transient List<ComandoDeJogoListener> interfacesDeJogo;
    private Entrada entrada;
    
    private Ambiente casaDoCesar;
    private Ambiente manicomio;
    private Ambiente portaDaFaculdade;
    private Ambiente loja;
    private Ambiente farmacia;
    
    private boolean finalizado;
    
    private NPC npcAtivo;

    /**
     * Construtor da classe ManicomioDeZulu.
     *
     */
    public ManicomioDeZulu() {
        criarAmbientes();
        inicializarIO();
        status = new EstadoDeJogo();
        finalizado = false;
        initEntradas();
    }

    /**Metodo initEntradas.
     * 
     * inicializa as entradas(Comandos) que o jogador pode usar durante o jogo.
     * 
     */
    private void initEntradas() {
        List<String> palavrasDeComando = new ArrayList<>();
        palavrasDeComando.add("ir");
        palavrasDeComando.add("ajuda");
        palavrasDeComando.add("sair");
        palavrasDeComando.add("status");
        palavrasDeComando.add("descrever");
        palavrasDeComando.add("mostrar");
        palavrasDeComando.add("conversar");
        palavrasDeComando.add("atacar");
        palavrasDeComando.add("coletar");
        palavrasDeComando.add("usar");
        palavrasDeComando.add("descartar");
        palavrasDeComando.add("pedir");
        palavrasDeComando.add("cancelar");
        palavrasDeComando.add("fugir");
        palavrasDeComando.add("checar");
        palavrasDeComando.add("detalhar");
        palavrasDeComando.add("recarregar");
        palavrasDeComando.add("welcome");
        entrada = new Entrada(palavrasDeComando);
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

    /**Metodo adicionarInterfaceDeJogoListener.
     * 
     * 
     * @param listener ComandoDeJogoListener com as interfaces do jogo.
     */
    public void adicionarInterfaceDeJogoListener(ComandoDeJogoListener listener) {
        if (interfacesDeJogo == null) {
            interfacesDeJogo = new ArrayList<>();
        }
        interfacesDeJogo.add(listener);
    }

    /**Metodo atualizarInterfaces.
     * 
     * @param evt JogoEvent com os eventos das interfaces.
     */
    public void atualizarInterfaces(JogoEvent evt) {
        for (ComandoDeJogoListener interfaceDeJogo : interfacesDeJogo) {
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

        esquina_Fortran_Python = new Ambiente("Esquina da rua Fortran com a rua Python", "esquina5");
        esquina_Fortran_Cobol = new Ambiente("Esquina da rua Fortran com a rua Cobol", "esquina6");
        esquina_Fortran_Lua = new Ambiente("Esquina da rua Fortran com a rua Lua", "esquina5");
        esquina_Fortran_Snobol = new Ambiente("Esquina da rua Fortran com a rua Snobol", "esquina6");
        esquina_Smalltalk_Python = new Ambiente("Esquina da rua Smalltalk com a rua Python", "esquina1");
        esquina_Smalltalk_Cobol = new Ambiente("Esquina da rua Smalltalk com a rua Cobol", "esquina3");
        esquina_Smalltalk_Lua = new Ambiente("Esquina da rua Smalltalk com a rua Lua", "esquina1");
        esquina_Smalltalk_Snobol = new Ambiente("Esquina da rua Smalltalk com a rua Snobol", "esquina3");
        esquina_Haskell_Python = new Ambiente("Esquina da rua Haskell com a rua Python", "esquina2");
        esquina_Haskell_Cobol = new Ambiente("Esquina da rua Haskell com a rua Cobol", "esquina4");
        esquina_Haskell_Lua = new Ambiente("Esquina da rua Haskell com a rua Lua", "esquina2");
        esquina_Haskell_Snobol = new Ambiente("Esquina da rua Haskell com a rua Snobol", "esquina4");
        esquina_Prolog_Python = new Ambiente("Esquina da rua Prolog com a rua Python", "esquina1");
        esquina_Prolog_Cobol = new Ambiente("Esquina da rua Prolog com a rua Cobol", "esquina3");
        esquina_Prolog_Lua = new Ambiente("Esquina da rua Prolog com a rua Lua", "esquina1");
        esquina_Prolog_Snobol = new Ambiente("Esquina da rua Prolog com a rua Snobol", "esquina3");

        List<Ambiente> ruaPython = new ArrayList<>();
        preencherArrayDeCasas(ruaPython, "Rua Python", 17, 50);
        
        casaDoCesar = new Ambiente("Minha Casa", "casaDoCesar");
        Ambiente portaDaCasaDoCesar = new Ambiente("Rua Python, 118 - Sua casa", "casa2");

        List<Ambiente> ruaCobol = new ArrayList<>();
        preencherArrayDeCasas(ruaCobol, "Rua Cobol", 5, 150);
        loja = new Ambiente("Interior da Loja do Coveiro", "lojaInterior");
        Ambiente portaDaLoja = new Ambiente("Loja do Coveiro", "loja");
        Ambiente cemiterio = new Ambiente("Entrada do Cemitério Parada Final", "cemiterio");

        List<Ambiente> ruaLua = new ArrayList<>();
        preencherArrayDeCasas(ruaLua, "Rua Lua", 4, 350);

        List<Ambiente> ruaSnobol = new ArrayList<>();
        preencherArrayDeCasas(ruaSnobol, "Rua Snobol", 3, 450);
        
        farmacia = new Ambiente("Interior da Drogaria Saradão", "farmaciaInterior");
        Ambiente portaDaFarmacia = new Ambiente("Drogaria Saradão", "farmacia");
        portaDaFaculdade = new Ambiente("UFLA - Universidade Federal de Loucos Autistas [FECHADA]", "escola");

        List<Ambiente> ruaSmalltalk = new ArrayList<>();
        preencherArrayDeCasas(ruaSmalltalk, "Rua Smalltalk", 3, 550);

        Ambiente portaDoManicomio = new Ambiente("Manicômio Olo & Co", "manicomio");
        manicomio = new Ambiente("Recepção do Manicômio Olo & Co", "manicomioInterior");

        List<Ambiente> ruaHaskell = new ArrayList<>();
        preencherArrayDeCasas(ruaHaskell, "Rua Haskell", 3, 650);

        List<Ambiente> ruaProlog = new ArrayList<>();
        preencherArrayDeCasas(ruaProlog, "Rua Prolog", 3, 750);

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
        esquina_Smalltalk_Cobol.ajustarSaida("leste", portaDaLoja);
        esquina_Smalltalk_Cobol.ajustarSaida("sul", esquina_Smalltalk_Lua);
        esquina_Smalltalk_Cobol.ajustarSaida("oeste", ruaCobol.get(1));

        esquina_Smalltalk_Lua.ajustarSaida("norte", esquina_Smalltalk_Cobol);
        esquina_Smalltalk_Lua.ajustarSaida("leste", esquina_Haskell_Lua);
        esquina_Smalltalk_Lua.ajustarSaida("sul", esquina_Smalltalk_Snobol);
        esquina_Smalltalk_Lua.ajustarSaida("oeste", ruaLua.get(0));

        esquina_Smalltalk_Snobol.ajustarSaida("norte", esquina_Smalltalk_Lua);
        esquina_Smalltalk_Snobol.ajustarSaida("leste", ruaSnobol.get(1));
        esquina_Smalltalk_Snobol.ajustarSaida("sul", portaDoManicomio);
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
        esquina_Haskell_Snobol.ajustarSaida("leste", portaDaFarmacia);
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
        esquina_Prolog_Snobol.ajustarSaida("oeste", portaDaFarmacia);

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
                    ruaPython.get(i).ajustarSaida("leste", portaDaCasaDoCesar);
                    ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
                    break;
                default:
                    ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
                    ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
                    break;
            }
        }
        
        casaDoCesar.ajustarSaida("sul", portaDaCasaDoCesar);
        
        portaDaCasaDoCesar.ajustarSaida("norte", casaDoCesar);
        portaDaCasaDoCesar.ajustarSaida("oeste", ruaPython.get(16));
        portaDaCasaDoCesar.ajustarSaida("leste", saidaDaCidade.get(4));

        ruaCobol.get(0).ajustarSaida("leste", ruaCobol.get(1));
        ruaCobol.get(0).ajustarSaida("oeste", esquina_Fortran_Cobol);
        ruaCobol.get(1).ajustarSaida("leste", esquina_Smalltalk_Cobol);
        ruaCobol.get(1).ajustarSaida("oeste", ruaCobol.get(0));
        ruaCobol.get(2).ajustarSaida("leste", esquina_Haskell_Cobol);
        ruaCobol.get(2).ajustarSaida("oeste", portaDaLoja);
        ruaCobol.get(3).ajustarSaida("leste", ruaCobol.get(4));
        ruaCobol.get(3).ajustarSaida("oeste", esquina_Prolog_Cobol);
        ruaCobol.get(4).ajustarSaida("leste", cemiterio);
        ruaCobol.get(4).ajustarSaida("oeste", ruaCobol.get(3));
        portaDaLoja.ajustarSaida("leste", ruaCobol.get(2));
        portaDaLoja.ajustarSaida("oeste", esquina_Smalltalk_Cobol);
        portaDaLoja.ajustarSaida("sul", loja);
        loja.ajustarSaida("norte", portaDaLoja);
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
        ruaSnobol.get(2).ajustarSaida("leste", portaDaFaculdade);
        ruaSnobol.get(2).ajustarSaida("oeste", esquina_Prolog_Snobol);
        portaDaFarmacia.ajustarSaida("leste", esquina_Prolog_Snobol);
        portaDaFarmacia.ajustarSaida("oeste", esquina_Haskell_Snobol);
        portaDaFarmacia.ajustarSaida("sul", farmacia);
        farmacia.ajustarSaida("norte", portaDaFarmacia);
        portaDaFaculdade.ajustarSaida("leste", saidaDaCidade.get(7));
        portaDaFaculdade.ajustarSaida("oeste", ruaSnobol.get(2));

        ruaSmalltalk.get(0).ajustarSaida("norte", saidaDaCidade.get(1));
        ruaSmalltalk.get(0).ajustarSaida("sul", ruaSmalltalk.get(1));
        ruaSmalltalk.get(1).ajustarSaida("norte", ruaSmalltalk.get(0));
        ruaSmalltalk.get(1).ajustarSaida("sul", esquina_Smalltalk_Python);
        ruaSmalltalk.get(2).ajustarSaida("norte", esquina_Smalltalk_Python);
        ruaSmalltalk.get(2).ajustarSaida("sul", esquina_Smalltalk_Cobol);
        
        portaDoManicomio.ajustarSaida("norte", esquina_Smalltalk_Snobol);
        portaDoManicomio.ajustarSaida("sul", saidaDaCidade.get(10));
        portaDoManicomio.ajustarSaida("oeste", manicomio);
        manicomio.ajustarSaida("leste", portaDoManicomio);

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
        saidaDaCidade.get(4).ajustarSaida("oeste", portaDaCasaDoCesar);
        saidaDaCidade.get(5).ajustarSaida("oeste", cemiterio);
        saidaDaCidade.get(6).ajustarSaida("oeste", ruaLua.get(3));
        saidaDaCidade.get(7).ajustarSaida("oeste", portaDaFaculdade);
        saidaDaCidade.get(8).ajustarSaida("norte", esquina_Prolog_Snobol);
        saidaDaCidade.get(9).ajustarSaida("norte", esquina_Haskell_Snobol);
        saidaDaCidade.get(10).ajustarSaida("norte", portaDoManicomio);
        saidaDaCidade.get(11).ajustarSaida("norte", esquina_Fortran_Snobol);

        ambienteAtual = esquina_Haskell_Python;

        adicionarObjetosCaseiros();

        int contaCachorro;
        contaCachorro = adicionarCachorrosEPedras(ruaCobol, 1);
        contaCachorro = adicionarCachorrosEPedras(ruaHaskell, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaLua, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaProlog, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaPython, contaCachorro);
        contaCachorro = adicionarCachorrosEPedras(ruaSmalltalk, contaCachorro);
        adicionarCachorrosEPedras(ruaSnobol, contaCachorro);

        adicionarChilofompilas(saidaDaCidade);
        adicionarAtoresChave();

    }
    
    /**Metodo preencherArrayDeCasas.
     * 
     * Metodo responsavel por preencher um ArrayList com as casas do programa
     * em cada rua.
     * 
     * @param rua List<Ambiente> com as ruas
     * @param nomeDaRua String com o nome das ruas
     * @param numeroDeCasas Integer com o numero de casas no programa
     * @param numeroInicial Integer com o numero inicial das casas 
     */
    private void preencherArrayDeCasas (List<Ambiente> rua, String nomeDaRua, int numeroDeCasas, int numeroInicial) {
        for (int i = 0; i < numeroDeCasas; i++) {
            String descricao = nomeDaRua + ", " + (i * 4 + numeroInicial);
            rua.add(new Ambiente(descricao, "casa" + ((i % 2) + 1)));
        }
    }
    
    /** Metodo adicionarAtoresChave.
     * 
     * Adiciona os atores nem cada ambiente.
     * 
     */
    private void adicionarAtoresChave () {
        for (int i = 0; i < 10; i++) {
            portaDaFaculdade.colocarNPC(new Cachorro("Cachorro" + (i + 1)));
        }
        manicomio.colocarNPC(new Medico("Raydson"));
        farmacia.colocarNPC(new Farmaceuta("Filipe"));
        loja.colocarNPC(new Vendedor("Velho"));
    }
    
    /**Metodo adicionarChilofompilas.
     * 
     * Adiciona Chilofompilas nas saidas da cidade.
     * 
     * @param lugares List<Ambiente> com os ambientes do jogo.
     */
    private void adicionarChilofompilas (List<Ambiente> lugares) {
        for (int i = 0; i < 12; i++) {
            lugares.get(i).colocarNPC(new Chilofompila());
        }
    }
    
    /**Metodo adicionarObjetosCaseiros.
     * 
     * adiciona os objetos que ficam dentro das casas, (nessa versão somente na
     * casa de César)
     * 
     */
    private void adicionarObjetosCaseiros () {
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
    }

    /**
     * Metodo adicionarCachorrosEPedras.
     *
     * coloca os objetos e os npc's nos ambientes.
     *
     * @param rua List<Ambiente> lista de ruas que receberão cachorros.
     * @param contador Inteiro com um numero a ser contado.
     * @return int com o numero de cachorros adicionados.
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
     * Metodo receberComando.
     * 
     * Responsável por receber o comando do usuario de
     * 
     * @param linha String com o comando passado pelo usuario.
     * @throws FormatoDeComandoException 
     */
    public void receberComando(String linha) throws FormatoDeComandoException {
        Comando comando = entrada.pegarComando(linha);
        processarComando(comando);
    }
    
    /**
     * Metodo processarComando.
     *
     * responsavel por processar o camando de entrada e indica o que fazer em
     * seguida com o comando passado.
     *
     * @param comando do tipo {@link Comando}, passa o comando de entrada do
     * usuario
     */
    public void processarComando(Comando comando) throws FormatoDeComandoException {
        JogoEvent evento = new JogoEvent(ambienteAtual.getListaSaidas(), status);
        if (comando.ehDesconhecido()) {
            evento.adicionarLinhaDeSaida("Você está louco? Digite [ajuda] se precisar de algo...");
        } else {
            String palavraDeComando = comando.getPalavraDeComando();
            if (palavraDeComando.equals("ajuda")) {
                imprimirAjuda(evento);
            } else if (palavraDeComando.equals("ir")) {
                irParaAmbiente(comando, evento);
            } else if (palavraDeComando.equals("sair")) {
                sair(comando, evento);
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
            } else if (palavraDeComando.equals("recarregar")) {
                recarregar(evento);
            } else if (palavraDeComando.equals("welcome")) {
                mensagemDeBoasVindas(evento);
            }
        }
        checarCondicoesDeFinalizacao(evento);
        atualizarNavegacao(evento);
        atualizarInterfaces(evento);
    }
    
    public void carregarCenarioAtualDoJogo() {
        receberComando("recarregar");
    }
    
    private void recarregar(JogoEvent evento) {
        evento.adicionarLinhaDeSaida("Você carregou um jogo salvo!\n");
        descrever(new Comando("descrever", "ambiente"), evento);
    }
    
    private void checarCondicoesDeFinalizacao(JogoEvent evento) {
        if (!protagonista.taVivo()) {
            evento.adicionarLinhaDeSaida("Você perdeu!!! Você foi mutilado como um pedaço de pernil na cozinha,");
            evento.adicionarLinhaDeSaida("agressivamente fateado por uma dona de casa ciumenta absolutely EMPUTECIDA");
            evento.adicionarLinhaDeSaida("depois de flagrar o histórico de seu marido procurando na internet");
            evento.adicionarLinhaDeSaida("fotos da Feiticeira e da Tiazinha em suas épocas de glória. Trágico!");
            status.setEstadoDoProtagonista(ATOR_ASSASSINADO);
            sairDoJogo(evento);
            finalizado = true;
        } else if (protagonista.enlouqueceuDeVez()) {
            evento.adicionarLinhaDeSaida("Você perdeu!!! Você, como um bom maluco, resolveu abraçar a causa de vez");
            evento.adicionarLinhaDeSaida("e saiu apedrejando as pessoas na rua enquanto gritava \"VOU PRA CASA FAZER SABÃO!\",");
            evento.adicionarLinhaDeSaida("até que chamaram o SAPU (Serviço de Atendimento Psiquiátrico de Urgência) pra te");
            evento.adicionarLinhaDeSaida("pegar, te imobiliar e te internar compulsoriamente! Que deprimente!!!");
            status.setEstadoDoProtagonista(ATOR_ENLOUQUECIDO);
            finalizado = true;
            sairDoJogo(evento);
        } else if (protagonista.taCurado()) {
            evento.adicionarLinhaDeSaida("PARABÉNS, VOCÊ FOI CURADO!!!! Agora fique esperto para não deixar");
            evento.adicionarLinhaDeSaida("de tomar teus remédios na hora certa!!");
            status.setEstadoDoProtagonista(SUCESSO);
            if (!finalizado) {
                afetarPontuacao(100);
            }
            sairDoJogo(evento);
            finalizado = true;
        }
    }

    /**
     * Metodo atacar.
     *
     * responsavel por atacar um npc que estiver no ambiente.
     *
     * @param comando do tipo {@link Comando}, recebe alem do comando atacar,
     * tambem indica quem atacar, caso não passe quem atacar nao ha o que fazer.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void atacar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Atacar quem?");
            return;
        }
        if (status.getEstadoAtual() == NAVEGANDO) {
            NPC alvo = ambienteAtual.selecionarNPC(comando.getSegundaPalavra());
            if (alvo != null) {
                npcAtivo = alvo;
                status.setEstadoAtual(ATACANDO, alvo.getNome());
                evento.setLimparTela(true);
                evento.adicionarLinhaDeSaida("Você se prepara para emboscar " + alvo.getNome() + "...");
                evento.adicionarLinhaDeSaida("");
                evento.adicionarLinhaDeSaida("O que vai fazer?");
                evento.setImagem(alvo.getImagem());
            } else {
                evento.adicionarLinhaDeSaida("Você está atacando alguém que não existe! Procure [ajuda] urgente!!");
            }
        } else {
            evento.adicionarLinhaDeSaida("Você não pode fazer isso agora!");
        }
    }

    /**
     * Metodo conversar
     *
     * responsavel por conversar com um npc.
     *
     * @param comando do tipo {@link Comando}, recebe alem do comando conversar,
     * tambem com quem conversar.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void conversar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Conversar com quem?");
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
                npcAtivo = alvo;
                evento.adicionarLinhaDeSaida("Você se aproximou de " + alvo.getNome() + " e o cumprimentou...");
                evento.adicionarLinhaDeSaida("");
                evento.adicionarLinhaDeSaida(alvo.mensagemConversa());
                evento.setImagem(alvo.getImagem());
            } else {
                evento.adicionarLinhaDeSaida("Você está conversando com alguém que não existe! Procure [ajuda] urgente!!");
            }
        } else {
            evento.adicionarLinhaDeSaida("Você não pode fazer isso agora!");
        }
    }

    /**
     * Metodo pedir
     *
     * responsavel por pedir algo a um npc.
     *
     * @param comando do tipo {@link Comando}, recebe alem do comando pedir,
     * tambem a quem pedir
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void pedir(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Pedir o quê?");
            return;
        }
        if (status.getEstadoAtual() == CONVERSANDO) {
            NPC alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
            if (alvo.temItem(comando.getSegundaPalavra())) {
                if (protagonista.temItem("Carteira")) {
                    if (protagonista.temEspacoNoInventario()) {
                        protagonista.coletarItem(alvo.entregarItemDeQuest());
                        evento.adicionarLinhaDeSaida("Item recebido!");
                    } else {
                        evento.adicionarLinhaDeSaida("Inventário lotado!");
                    }
                } else {
                    evento.adicionarLinhaDeSaida("Você não tem carteira agora!");
                }
            } else {
                evento.adicionarLinhaDeSaida("Ele não tem esse item!");
            }
        } else {
            evento.adicionarLinhaDeSaida("Como assim pedir, tá doido? Peça [ajuda] urgente...");
        }
    }

    /**
     * Metodo cancelar.
     *
     * cancela uma operacao.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void cancelar(JogoEvent evento) {
        if (status.getEstadoAtual() == CONVERSANDO) {
            status.setEstadoAtual(NAVEGANDO, "");
            npcAtivo = null;
            evento.setLimparTela(true);
            evento.adicionarLinhaDeSaida("Você foi embora!");
            exibirAmbienteAtual(evento);
        } else {
            evento.adicionarLinhaDeSaida("Cancelar o quê?");
        }
    }

    /**
     * Metodo fugir.
     *
     * foge de uma luta com um npc.
     *
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void fugir(JogoEvent evento) {
        if (status.getEstadoAtual() == ATACANDO) {
            if (ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual()).ehImortal()) {
                status.setEstadoAtual(NAVEGANDO, "");
                npcAtivo = null;
                evento.setLimparTela(true);
                evento.adicionarLinhaDeSaida("Você fugiu!");
                exibirAmbienteAtual(evento);
            } else {
                evento.adicionarLinhaDeSaida("Você não pode fugir dessa luta!");
            }
        } else {
            evento.adicionarLinhaDeSaida("Fugir de onde?");
        }
    }

    /**
     * Metodo usar.
     *
     * responsavel por fazer o usuario usar um item.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando usar,
     * tambem qual item usar.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void usar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Usar o quê?");
            return;
        }
        if (status.getEstadoAtual() == NAVEGANDO) {
            if (comando.getSegundaPalavra().equalsIgnoreCase("mapa")) {
                checar(comando, evento);
            } else if (protagonista.temItem(comando.getSegundaPalavra())) {
                List<Resultado> resultados = protagonista.usarItem(comando.getSegundaPalavra(), protagonista);
                verificarResultados(protagonista, resultados, evento);
            } else {
                List<Resultado> resultados = ambienteAtual.aplicarItem(comando.getSegundaPalavra(), protagonista);
                verificarResultados(protagonista, resultados, evento);
            }
        } else if (status.getEstadoAtual() == ATACANDO) {
            NPC alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
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
                evento.adicionarLinhaDeSaida("Você pode continuar o jogo, e conseguiu segurar seu surto por mais uma rodada!");
                status.setEstadoAtual(NAVEGANDO, "");
                npcAtivo = null;
                if (status.teveMatanca()) {
                    protagonista.afetarAtributo(SANIDADE, 1);
                } else {
                    status.matou(true);
                }
                ambienteAtual.matarNPC(alvo);
                exibirAmbienteAtual(evento);
            }
            
        }
    }
    
    /**Metodo verificarResultados
     * 
     * @param alvo {@link Ator}, o qual vai receber a verificação.
     * @param resultados List<Resultado> com os resultados sofridos pelo ator.
     * @param evento JogoEvent, gera um evento na interface. 
     */
    private void verificarResultados(Ator alvo, List<Resultado> resultados, JogoEvent evento) {
        for (Resultado resultado : resultados) {
            switch (resultado) {
                case ATOR_ASSASSINADO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " foi assassinado!");
                    if (!alvo.getNome().equals("Cesar")) {
                        afetarPontuacao(50);
                    } else {
                        afetarPontuacao(-100);
                    }
                    break;
                case ATOR_CURADO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " restaurou HP!");
                    afetarPontuacao(50);
                    break;
                case ATOR_ENFURECIDO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " perdeu sanidade!");
                    afetarPontuacao(-10);
                    break;
                case ATOR_ENLOUQUECIDO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " enloqueceu de vez!");
                    afetarPontuacao(-50);
                    break;
                case ATOR_EQUILIBRADO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " é incorruptível!");
                    break;
                case ATOR_FERIDO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " foi atacado e perdeu HP!");
                    if (!alvo.getNome().equals("Cesar")) {
                        afetarPontuacao(10);
                    } else {
                        afetarPontuacao(-5);
                    }
                    break;
                case ATOR_IMORTAL:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " é imortal!");
                    break;
                case ATOR_MORTO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " está morto, deixe-o!");
                    break;
                case ATOR_NEUTRALIZADO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " está sem condição de lutar, deixe-o!");
                    break;
                case ATOR_SANADO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " recuperou um pouco de Sanidade!");
                    afetarPontuacao(30);
                    break;
                case ATRIBUTO_NAO_APROPRIADO:
                    evento.adicionarLinhaDeSaida(alvo.getNome() + " não sofreu dano algum!");
                    break;
                case BAGAGEM_LOTADA:
                    evento.adicionarLinhaDeSaida("A bagagem de " + alvo.getNome() + " está lotada!");
                    break;
                case ITEM_NAO_ENCONTRADO:
                    evento.adicionarLinhaDeSaida("Quê? Isso que você quer usar não existe, procure [ajuda] para sua loucura!");
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
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void checar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Checar o quê?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("mapa")) {
            if (status.getEstadoAtual() == NAVEGANDO) {
                if (protagonista.temItem("Mapa")) {
                    evento.setQuerMapa(true);
                } else {
                    evento.adicionarLinhaDeSaida("Não estou com meu mapa! Mas sei que minha casa fica");
                    evento.adicionarLinhaDeSaida("na Rua Python, 118 (Leste da esquina Prolog com Python)");
                }
            }
        } else {
            evento.adicionarLinhaDeSaida("Cara, agora você quer checar um négocio bem nada a ver... Eu tô falando,");
            evento.adicionarLinhaDeSaida("você precisa muito de [ajuda]!!!");
        }
    }

    /**
     * Metodo descartar
     *
     * responsavel por descartar um item coletado que esta com cesar
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando
     * descartar, tambem qual item descartar.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void descartar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Descartar o quê?");
            return;
        }
        if (protagonista.temItem(comando.getSegundaPalavra())) {
            ambienteAtual.colocarItem(protagonista.darItem(comando.getSegundaPalavra()));
            evento.adicionarLinhaDeSaida("Item descartado!");
        } else {
            evento.adicionarLinhaDeSaida("Você não tem esse item!");
        }
    }

    /**
     * Metodo coletar
     *
     * responsavel por coletar um item do ambiente onde cesar esta.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando coletar,
     * tambem qual item coletar.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void coletar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Coletar o quê?");
            return;
        }
        if (status.getEstadoAtual() != CONVERSANDO) {
            if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
                Item item = ambienteAtual.recolherItem(comando.getSegundaPalavra());
                if (item.ehColetavel()) {
                    if (protagonista.temEspacoNoInventario()) {
                        protagonista.coletarItem(item);
                        evento.adicionarLinhaDeSaida("Item coletado!");
                        afetarPontuacao(20);
                    } else {
                        ambienteAtual.colocarItem(item);
                        evento.adicionarLinhaDeSaida("Inventário cheio!");
                    }
                } else {
                    ambienteAtual.colocarItem(item);
                    evento.adicionarLinhaDeSaida("Item não coletável!");
                }
            } else {
                evento.adicionarLinhaDeSaida("Não tem item neste ambiente com esse nome!");
            }
        } else {
            evento.adicionarLinhaDeSaida("Agora não dá!");
        }
    }

    /**
     * Metodo mostrarInventario
     *
     * responsavel por mostrar o inventario de cesar.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando Mostrar,
     * tambem o inventario a mostrar.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void mostrarInventario(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Mostrar o quê?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("inventario")) {
            evento.adicionarLinhaDeSaida(protagonista.getListaItens());
        }
    }

    /**
     * Metodo detalhar
     *
     * responsavel por detalhar um ambiente ou um protagonista.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando detalhar,
     * tambem o que detalhar.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void detalhar(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Detalhar o quê?");
            return;
        }
        if (protagonista.temItem(comando.getSegundaPalavra())) {
            evento.adicionarLinhaDeSaida(protagonista.getDescricaoItem(comando.getSegundaPalavra()));
        } else if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
            evento.adicionarLinhaDeSaida(ambienteAtual.getDescricaoItem(comando.getSegundaPalavra()));
        } else {
            evento.adicionarLinhaDeSaida("Item inexistente!");
        }
    }

    /**
     * Metodo descrever
     *
     * responsavel por descrever um ambiente.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando
     * descrever, tambem qual ambiente descrever.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void descrever(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Descrever o quê?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("ambiente")) {
            if (status.getEstadoAtual() == NAVEGANDO) {
                exibirAmbienteAtual(evento);
            }
            if (status.getEstadoAtual() != CONVERSANDO) {
                evento.adicionarLinhaDeSaida("NPCs agora no ambiente:");
                evento.adicionarLinhaDeSaida(ambienteAtual.getListaNPCs());
                evento.adicionarLinhaDeSaida("Objetos no ambiente:");
                evento.adicionarLinhaDeSaida(ambienteAtual.getListaItens());
            } else {
                evento.adicionarLinhaDeSaida("Agora não!");
            }
        } else if (comando.getSegundaPalavra().equalsIgnoreCase("npc")) {
            if (status.getEstadoAtual() == CONVERSANDO) {
                evento.adicionarLinhaDeSaida(ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual()).getListaItens());
            } else {
                evento.adicionarLinhaDeSaida("Você não pode usar esse comando agora!");
            }
        } else {
            evento.adicionarLinhaDeSaida("Forma incorreta de descrever algo! Digite [ajuda] e confira...");
        }
    }

    /**
     * Metodo imprimirStatus
     *
     * responsavel por imprimir o status de cesar ou de um protagonista
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando status,
     * tambem o status de quem deseja imprimir.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void imprimirStatus(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            evento.adicionarLinhaDeSaida("Status de quem?");
            return;
        }
        if (comando.getSegundaPalavra().equalsIgnoreCase("npc")) {
            if (status.getEstadoAtual() == ATACANDO) {
                NPC alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
                evento.adicionarLinhaDeSaida(alvo.getStatus());
            } else {
                evento.adicionarLinhaDeSaida("Nesse estado você só pode ver o seu status! Tente [status eu]...");
            }
        } else if (comando.getSegundaPalavra().equalsIgnoreCase("eu")) {
            evento.adicionarLinhaDeSaida(protagonista.getStatus());
        } else {
            evento.adicionarLinhaDeSaida("Forma incorreta de solicitar o status! Digite [ajuda] e confira...");
        }
    }

    /**
     *  
     */
    public void mostrarBoasVindas() {
        receberComando("welcome");
    }
    
    /**
     * Metodo mensagemDeBoasVindas.
     *
     * Responsavel por imprimir as boas vindas do jogo (cabecalho).
     *
     * Chama o metodo exibir ambiente depois das boas vindas.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void mensagemDeBoasVindas(JogoEvent evento) {
        evento.adicionarLinhaDeSaida("    Bem Vindo ao Jogo \"World of Zuul - O Manicômio de Zulu\".");
        evento.adicionarLinhaDeSaida("    Este é um jogo no estilo Adventure em modo texto.");
        evento.adicionarLinhaDeSaida("\n    Boa Sorte e não enlouqueça!!!");
        evento.adicionarLinhaDeSaida("\n    Você é César, o professor de PPOO ");
        evento.adicionarLinhaDeSaida("(Planejamento de Planos de Organizações Organizacionais).");
        evento.adicionarLinhaDeSaida("Você saiu da faculdade e está terrivelmente estressado, e de repente você se");
        evento.adicionarLinhaDeSaida("lembra de que não tomou seus remédios controlados e está prestes a");
        evento.adicionarLinhaDeSaida("enlouquecer!!!");
        evento.adicionarLinhaDeSaida("\n    Você está no meio da cidade de Zulu, uma pequena cidade castigada pelo");
        evento.adicionarLinhaDeSaida("descuido da prefeitura, lotada de cães raivosos de rua, num ponto próximo à");
        evento.adicionarLinhaDeSaida("sua casa. Lá você esqueceu sua carteira, e precisa dela para comprar");
        evento.adicionarLinhaDeSaida("seu medicamento na farmácia.");
        evento.adicionarLinhaDeSaida("\n    Seu objetivo aqui é conseguir alcançar 30 pontos de Sanidade ou mais,");
        evento.adicionarLinhaDeSaida("tendo em mente que como você está em uma delicada situação psicológica,");
        evento.adicionarLinhaDeSaida("perderá 1 ponto de Sanidade a cada ambiente que você avançar, tornando");
        evento.adicionarLinhaDeSaida("cada vez mais desafiadora a sua experiência! Descubra maneiras de explorar");
        evento.adicionarLinhaDeSaida("o jogo com mais tempo, maneiras de controlar sua loucura e muito mais!!!");
        evento.adicionarLinhaDeSaida("\n    E cuidado pra não zerar nenhum dos seus atributos mais importantes,");
        evento.adicionarLinhaDeSaida("porque senão você pode acabar num caixão... Ou pior ainda... Internado");
        evento.adicionarLinhaDeSaida("compulsoriamente no MANICÔMIO DE ZULU!\n\n");

        exibirAmbienteAtual(evento);

        atualizarNavegacao(evento);
        atualizarInterfaces(evento);
    }

    /**
     * Metodo imprimirAjuda.
     *
     * Imprime uma ajuda pro usuario do jogo com todos os comando validos em
     * determinada situacao.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void imprimirAjuda(JogoEvent evento) {
        evento.adicionarLinhaDeSaida("Você precisa de medicamentos para lidar com a psicose!!");
        evento.adicionarLinhaDeSaida("Seus comandos agora são:");
        evento.setLimparTela(true);
        switch (status.getEstadoAtual()) {
            case NAVEGANDO:
                evento.adicionarLinhaDeSaida("[ir <direcao>]\tVá para a direção que quiser da lista de saídas de cada ambiente!");
                evento.adicionarLinhaDeSaida("[descrever ambiente]\tVeja a descrição completa de onde estás!");
                evento.adicionarLinhaDeSaida("[checar mapa]\tColete o mapa e visualize os pontos mais importantes da cidade!");
                evento.adicionarLinhaDeSaida("[mostrar inventario]\tVeja o que estás carregando!");
                evento.adicionarLinhaDeSaida("[coletar <nome_item>]\tSe seu inventário não estiver cheio, ele é seu!");
                evento.adicionarLinhaDeSaida("[detalhar <nome_item>]\tObserve de perto seu item, quando a curiosidade for mais forte que a loucura!");
                evento.adicionarLinhaDeSaida("[usar <nome_item>]\tVocê usará um item, em você mesmo (mesmo um ofensivo)!");
                evento.adicionarLinhaDeSaida("[descartar <nome_item>]\tQuando já não lhe servir, deixe que alguém o pegue!");
                evento.adicionarLinhaDeSaida("[status eu]\tVeja o seu Status!");
                evento.adicionarLinhaDeSaida("[conversar <nome_npc>]\tConverse com eles e veja como podem te ajudar!");
                evento.adicionarLinhaDeSaida("[atacar <nome_npc>]\tOu mostre a eles o inferno hahahaha!!");
                evento.adicionarLinhaDeSaida("[sair jogo]\tO nome já diz tudo...");
                break;
            case CONVERSANDO:
                evento.adicionarLinhaDeSaida("[status eu]\tVeja o seu Status!");
                evento.adicionarLinhaDeSaida("[mostrar inventario]\tVeja o que estás carregando!");
                evento.adicionarLinhaDeSaida("[pedir <nome_item>]\tSe tiver como pagar, peça, senão, fique aguado!");
                evento.adicionarLinhaDeSaida("[descrever npc]\tVocê vê o inventário do NPC!");
                evento.adicionarLinhaDeSaida("[descartar <nome_item>]\tQuando já não lhe servir, deixe que alguém o pegue!");
                evento.adicionarLinhaDeSaida("[cancelar]\tVolte ao que estava fazendo!");
                evento.adicionarLinhaDeSaida("[sair]\tO mesmo que cancelar!");
                evento.adicionarLinhaDeSaida("[sair jogo]\tO nome já diz tudo...");
                break;
            case ATACANDO:
                evento.adicionarLinhaDeSaida("[status eu]\tVeja o seu Status!");
                evento.adicionarLinhaDeSaida("[status npc]\tVeja o Status do seu inimigo!");
                evento.adicionarLinhaDeSaida("[mostrar inventario]\tVeja o que estás carregando!");
                evento.adicionarLinhaDeSaida("[usar habilidade]\tFaça o que faz de melhor e use sua habilidade para massacrar!");
                evento.adicionarLinhaDeSaida("[usar <nome_item>]\tVocê usará um item no seu oponente (mesmo um item positivo)!");
                evento.adicionarLinhaDeSaida("[descrever ambiente]\tVeja o que está a sua volta!");
                evento.adicionarLinhaDeSaida("[fugir]\tSe tiver azar de enfrentar alguém muito forte, apenas tente!");
                evento.adicionarLinhaDeSaida("[sair]\tO mesmo que fugir!");
                evento.adicionarLinhaDeSaida("[sair jogo]\tO nome já diz tudo...");
                break;
            default:
                break;
        }
    }

    /**
     * Metodo irParaAmbiente.
     *
     * responsavel por sair de um ambiente atual e ir para outro ambiente
     * passado atraves do sentido.
     *
     * @param comando do tipo {@link Comando}, rescebe alem do comando ir,
     * tambem qual direcao ir.
     *@param evento JogoEvent, gera um evento na interface.
     */
    private void irParaAmbiente(Comando comando, JogoEvent evento) {
        if (status.getEstadoAtual() == NAVEGANDO) {
            if (!comando.temSegundaPalavra()) {
                // caso o comando não tiver segunda palavra.
                evento.adicionarLinhaDeSaida("Você é doido? Quer ir aonde?");
                return;
            }
            String direcao = comando.getSegundaPalavra();
            Ambiente proximoAmbiente = ambienteAtual.getAmbiente(direcao);
            if (proximoAmbiente == null) {
                evento.adicionarLinhaDeSaida("Você não vai a lugar algum, procure outra saída!");
            } else {
                if (!status.teveMatanca()) {
                    protagonista.afetarAtributo(SANIDADE, -1);
                    afetarPontuacao(-5);
                }
                evento.setLimparTela(true);
                status.matou(false);
                ambienteAtual = proximoAmbiente;
                evento.setSaidasDisponiveis(ambienteAtual.getListaSaidas());
                exibirAmbienteAtual(evento);
            }
        } else {
            evento.adicionarLinhaDeSaida("Você está no meio de uma interação! Acabe-a e pode andar!");
        }
    }
    /**
     * Metodo afetarPontuacao.
     * 
     * afeta a pontuação acumulada no decorrer do jogo.
     * 
     * @param evento JogoEvent com o evento a ser executado.
     * @param pontos Integer com a quantidade de pontos.
     */
    private void afetarPontuacao(int pontos) {
        status.atualizarPontuacao(pontos);
    }
    
    /**
     * Metodo atualizarNavegacao.
     * 
     * Atualiza a navegação do jogo a cada interação do usuario.
     * 
     * @param evento JogoEvent com o evento a ser executado.
     */
    private void atualizarNavegacao (JogoEvent evento) {
        if (status.getEstadoAtual() == NAVEGANDO) {
            List<NPC> npcs = ambienteAtual.getNPCs();
            if (!npcs.isEmpty()) {
                evento.setNPCsAmbiente(npcs);
            }
            List<Item> itemsAmbiente = ambienteAtual.getItens();
            if (!itemsAmbiente.isEmpty()) {
                evento.setObjetosAmbiente(itemsAmbiente);
            }
        } else if (status.getEstadoAtual() == CONVERSANDO){
            List<Item> inventarioNPC = npcAtivo.getItens();
            if (!inventarioNPC.isEmpty()) {
                evento.setInventarioNPC(inventarioNPC);
            }
        }
        List<Item> inventario = protagonista.getItens();
            if (!inventario.isEmpty()) {
                evento.setInventarioCesar(inventario);
            }
        status.setMeuHP((protagonista.getAtributo(HP) + 0f)/(protagonista.getHPMaximo() + 0f));
        status.setMinhaSanidade((protagonista.getAtributo(SANIDADE) + 0f)/30f);
        if (status.getEstadoAtual() == ATACANDO) {
            status.setInimigoHP((npcAtivo.getAtributo(HP) + 0f)/(npcAtivo.getHPMaximo() + 0f));
        } else {
            status.setInimigoHP(0f);
        }
    }

    /**
     * Metodo exibirAmbienteAtual.
     *
     * responsavel por dizer onde cesar esta no momento.
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void exibirAmbienteAtual(JogoEvent evento) {
        evento.adicionarLinhaDeSaida("Você está na " + ambienteAtual.getDescricao());
        evento.adicionarLinhaDeSaida("Saidas:");
        String saidasDisponiveis = ambienteAtual.listarSaidasDisponiveis();
        if (saidasDisponiveis.equals(SEM_SAIDA)) {
            evento.adicionarLinhaDeSaida("[ATENÇÃO!! O AMBIENTE ATUAL NÃO POSSUI SAÍDAS! CUIDE DISSO!]");
        } else {
            evento.adicionarLinhaDeSaida(saidasDisponiveis);
        }
        evento.setImagem(ambienteAtual.getImagem());
    }

    /**
     * Metodo sair
     *
     * responsavel por retornar um comando validando a saida do usuario do jogo.
     *
     * @param evento JogoEvent, gera um evento na interface.
     */
    private void sair(Comando comando, JogoEvent evento) {
        if (!comando.temSegundaPalavra()) {
            switch (status.getEstadoAtual()) {
                case CONVERSANDO:
                    cancelar(evento);
                    break;
                case ATACANDO:
                    fugir(evento);
                    break;
                default:
                    evento.adicionarLinhaDeSaida("Sair de onde?");
                    break;
            }
        } else if (comando.getSegundaPalavra().equals("jogo")) {
            sairDoJogo(evento);
        }
    }
    
    /**
     * Metodo sairDoJogo.
     * 
     * metodo responsável para sair do Jogo.
     * 
     * @param evento JogoEvent com o evento a ser executado.
     */
    private void sairDoJogo (JogoEvent evento) {
        evento.adicionarLinhaDeSaida("Obrigado por jogar, até mais!");
        status.setFinalizado(true);
    }
    
    public boolean foiFinalizado() {
        return status.taFinalizado();
    }
    
    public Resultado getEstadoDoProtagonista() {
        return status.getEstadoDoProtagonista();
    }
    
    public int getPontuacao() {
        return status.getPontuacao();
    }
}
