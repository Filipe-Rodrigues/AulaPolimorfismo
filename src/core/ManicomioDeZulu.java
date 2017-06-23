package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.*;
import resources.*;
import static core.EstadoDeJogo.*;
import static resources.Ambiente.SEM_SAIDA;
import static resources.Resultado.*;
import static resources.Atributo.*;

/**
 * Classe ManicomioDeZulu - responsável por criar os ambientes
 * colocar os objetos pelas ruas e os npc's em seus lugares.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.
 * 
 * Essa classe é uma das mais importantes, pois ela cria todos os ambientes,
 * colococa todos os objetos espalhados no mapa, e todos os npc's pra que
 * o jogador possa interagir.
 * 
 * @author Raydson Ferreira Carlota
 * @version 2017.06.09
 */
public class ManicomioDeZulu {
	/** Attributes */
	private Entrada entrada;
	private Saida saida;
	private Ambiente ambienteAtual;
	private Cesar protagonista;
	private EstadoDeJogo status;

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
		entrada = new Entrada(palavrasDeComando);
		saida = new Saida();
		protagonista = new Cesar();
	}

	/**
	 * Metodo jogar
         * 
         * chama o metodo imprimir boas vindas e incializa o jogo
         * fica em loop ate terminar o jogo.
	 */
	public void jogar() {
		imprimirBoasVindas();

		// Entra no loop de comando principal. Aqui nos repetidamente lemos
		// comandos e os executamos ate o jogo terminar.

		boolean terminado = false;
		while (!terminado) {
			Comando comando = entrada.pegarComando();
			terminado = processarComando(comando);
		}
		saida.imprimirLinha("Obrigado por jogar. Ate mais!");
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

		esquina_Fortran_Python = new Ambiente("Esquina da rua Fortran com a rua Python");
		esquina_Fortran_Cobol = new Ambiente("Esquina da rua Fortran com a rua Cobol");
		esquina_Fortran_Lua = new Ambiente("Esquina da rua Fortran com a rua Lua");
		esquina_Fortran_Snobol = new Ambiente("Esquina da rua Fortran com a rua Snobol");
		esquina_Smalltalk_Python = new Ambiente("Esquina da rua Smalltalk com a rua Python");
		esquina_Smalltalk_Cobol = new Ambiente("Esquina da rua Smalltalk com a rua Cobol");
		esquina_Smalltalk_Lua = new Ambiente("Esquina da rua Smalltalk com a rua Lua");
		esquina_Smalltalk_Snobol = new Ambiente("Esquina da rua Smalltalk com a rua Snobol");
		esquina_Haskell_Python = new Ambiente("Esquina da rua Haskell com a rua Python");
		esquina_Haskell_Cobol = new Ambiente("Esquina da rua Haskell com a rua Cobol");
		esquina_Haskell_Lua = new Ambiente("Esquina da rua Haskell com a rua Lua");
		esquina_Haskell_Snobol = new Ambiente("Esquina da rua Haskell com a rua Snobol");
		esquina_Prolog_Python = new Ambiente("Esquina da rua Prolog com a rua Python");
		esquina_Prolog_Cobol = new Ambiente("Esquina da rua Prolog com a rua Cobol");
		esquina_Prolog_Lua = new Ambiente("Esquina da rua Prolog com a rua Lua");
		esquina_Prolog_Snobol = new Ambiente("Esquina da rua Prolog com a rua Snobol");

		List<Ambiente> ruaPython = new ArrayList<>();
		for (int i = 0; i < 17; i++) {
			String descricao = "Rua Python, " + (i * 4 + 50);
			ruaPython.add(new Ambiente(descricao));
		}
		Ambiente casaDoCesar = new Ambiente("Rua Python, 118 - Sua casa");

		List<Ambiente> ruaCobol = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String descricao = "Rua Cobol, " + (i * 4 + 150);
			ruaCobol.add(new Ambiente(descricao));
		}
		Ambiente loja = new Ambiente("Loja do Coveiro");
		Ambiente cemiterio = new Ambiente("Entrada do Cemitério Parada Final");

		List<Ambiente> ruaLua = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			String descricao = "Rua Lua, " + (i * 4 + 350);
			ruaLua.add(new Ambiente(descricao));
		}

		List<Ambiente> ruaSnobol = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String descricao = "Rua Snobol, " + (i * 4 + 450);
			ruaSnobol.add(new Ambiente(descricao));
		}
		Ambiente farmacia = new Ambiente("Drogaria Saradão");
		Ambiente faculdade = new Ambiente("UFLA 'Universidade Federal de Loucos Autistas' [FECHADA]");

		List<Ambiente> ruaSmalltalk = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String descricao = "Rua Smalltalk, " + (i * 4 + 550);
			ruaSmalltalk.add(new Ambiente(descricao));
		}
		Ambiente manicomio = new Ambiente("Recepção do Manicômio Olo & Co");

		List<Ambiente> ruaHaskell = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String descricao = "Rua Haskell, " + (i * 4 + 650);
			ruaHaskell.add(new Ambiente(descricao));
		}

		List<Ambiente> ruaProlog = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			String descricao = "Rua Prolog, " + (i * 4 + 750);
			ruaProlog.add(new Ambiente(descricao));
		}

		List<Ambiente> saidaDaCidade = new ArrayList<>();
		for (int i = 0; i < 12; i++) {
			String descricao = "Saída de Zulu";
			saidaDaCidade.add(new Ambiente(descricao));
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
			if (i == 0) {
				ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
				ruaPython.get(i).ajustarSaida("oeste", esquina_Fortran_Python);
			} else if (i == 4) {
				ruaPython.get(i).ajustarSaida("leste", esquina_Smalltalk_Python);
				ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
			} else if (i == 5) {
				ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
				ruaPython.get(i).ajustarSaida("oeste", esquina_Smalltalk_Python);
			} else if (i == 8) {
				ruaPython.get(i).ajustarSaida("leste", esquina_Haskell_Python);
				ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
			} else if (i == 9) {
				ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
				ruaPython.get(i).ajustarSaida("oeste", esquina_Haskell_Python);
			} else if (i == 13) {
				ruaPython.get(i).ajustarSaida("leste", esquina_Prolog_Python);
				ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
			} else if (i == 14) {
				ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
				ruaPython.get(i).ajustarSaida("oeste", esquina_Prolog_Python);
			} else if (i == 16) {
				ruaPython.get(i).ajustarSaida("leste", casaDoCesar);
				ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
			} else {
				ruaPython.get(i).ajustarSaida("leste", ruaPython.get(i + 1));
				ruaPython.get(i).ajustarSaida("oeste", ruaPython.get(i - 1));
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
		manicomio.ajustarSaida("norte", saidaDaCidade.get(10));

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
		saidaDaCidade.get(10).ajustarSaida("norte", esquina_Smalltalk_Snobol);
		saidaDaCidade.get(11).ajustarSaida("norte", esquina_Fortran_Snobol);

		ambienteAtual = esquina_Haskell_Python;

		Efeito chuveiradaSan = new AlteracaoDeSanidade("Restaurar Sanidade", "Restaura 9 pontos de Sanidade", 9);
		Efeito chuveiradaHP = new AlteracaoDeHP("Restaurar HP", "Restaura 5 pontos de HP", 5);
		List<Efeito> efeitosChuveiro = new ArrayList<>();
		efeitosChuveiro.add(chuveiradaHP);
		efeitosChuveiro.add(chuveiradaSan);
		Item chuveiro = new Item("Chuveiro", "Uma bela ducha quente, ótima nesse friozinho de Zulu!", efeitosChuveiro, false, false);
		Item carteira = new Item("Carteira", "Contém seus documentos, dinheiro o suficiente e alguns endereços.", new ArrayList<>(), false, true);
		casaDoCesar.colocarItem(chuveiro);
		casaDoCesar.colocarItem(carteira);
		
		int contaCachorro;
		contaCachorro = adicionarCachorrosEPedras(ruaCobol, 1);
		contaCachorro = adicionarCachorrosEPedras(ruaHaskell, contaCachorro);
		contaCachorro = adicionarCachorrosEPedras(ruaLua, contaCachorro);
		contaCachorro = adicionarCachorrosEPedras(ruaProlog, contaCachorro);
		contaCachorro = adicionarCachorrosEPedras(ruaPython, contaCachorro);
		contaCachorro = adicionarCachorrosEPedras(ruaSmalltalk, contaCachorro);
		contaCachorro = adicionarCachorrosEPedras(ruaSnobol, contaCachorro);
		
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
         *  coloca os objetos e os npc's nos ambientes.
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
         * responsavel por processar o camando de entrada e indica o que fazer
         * em seguida com o comando passado.
         * 
	 * @param comando do tipo {@link Comando}, passa o comando de entrada do usuario
	 * @return boolean.
	 */
	private boolean processarComando(Comando comando) {
		boolean ehPraSair = false;

		if (comando.ehDesconhecido()) {
			saida.imprimirLinha("Você está louco? Digite [ajuda] se precisar de algo...");
			return false;
		}

		String palavraDeComando = comando.getPalavraDeComando();
		if (palavraDeComando.equals("ajuda")) {
			imprimirAjuda();
		} else if (palavraDeComando.equals("ir")) {
			irParaAmbiente(comando);
		} else if (palavraDeComando.equals("sair")) {
			ehPraSair = sair();
		} else if (palavraDeComando.equals("status")) {
			imprimirStatus(comando);
		} else if (palavraDeComando.equals("descrever")) {
			descrever(comando);
		} else if (palavraDeComando.equals("detalhar")) {
			detalhar(comando);
		} else if (palavraDeComando.equals("mostrar")) {
			mostrarInventario(comando);
		} else if (palavraDeComando.equals("conversar")) {
			conversar(comando);
		} else if (palavraDeComando.equals("atacar")) {
			atacar(comando);
		} else if (palavraDeComando.equals("coletar")) {
			coletar(comando);
		} else if (palavraDeComando.equals("usar")) {
			usar(comando);
		} else if (palavraDeComando.equals("descartar")) {
			descartar(comando);
		} else if (palavraDeComando.equals("pedir")) {
			pedir(comando);
		} else if (palavraDeComando.equals("cancelar")) {
			cancelar();
		} else if (palavraDeComando.equals("fugir")) {
			fugir();
		} else if (palavraDeComando.equals("checar")) {
			checar(comando);
		}
		
		if (!protagonista.taVivo() || protagonista.enlouqueceuDeVez()) {
			saida.imprimirLinha("Você perdeu!!! Você deixou que te tua loucura te dominasse por");
			saida.imprimirLinha("completo!!!");
			ehPraSair = true;
		} else if (protagonista.taCurado()) {
			saida.imprimirLinha("PARABÉNS, VOCÊ FOI CURADO!!!! Agora fique esperto para não deixar");
			saida.imprimirLinha("de tomar teus remédios na hora certa!!");
			ehPraSair = true;
		}
		
		return ehPraSair;
	}
        
        /**
         * Metodo atacar
         * 
         * responsavel por atacar um npc que estiver no ambiente.
         * 
         * @param comando do tipo {@link Comando}, recebe alem do comando atacar, tambem
         * indica quem atacar, caso não passe quem atacar nao ha o que fazer.
         */
	private void atacar(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Atacar quem?");
			return;
		}
		if (status.getEstadoAtual() == NAVEGANDO) {
			NPC alvo = ambienteAtual.selecionarNPC(comando.getSegundaPalavra());
			if (alvo != null) {
				status.setEstadoAtual(ATACANDO, alvo.getNome());
				saida.imprimirLinha("Você se prepara para emboscar " + alvo.getNome() + "...");
				saida.imprimirLinha("");
				saida.imprimirLinha("O que vai fazer?");
			} else {
				saida.imprimirLinha("Você está atacando alguém que não existe! Procure [ajuda] urgente!!");
			}
		} else {
			saida.imprimirLinha("Você não pode fazer isso agora!");
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
	private void conversar(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Conversar com quem?");
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
				status.setEstadoAtual(CONVERSANDO, alvo.getNome());
				saida.imprimirLinha("Você se aproximou de " + alvo.getNome() + " e o cumprimentou...");
				saida.imprimirLinha("");
				saida.imprimirLinha(alvo.mensagemConversa());
			} else {
				saida.imprimirLinha("Você está conversando com alguém que não existe! Procure [ajuda] urgente!!");
			}
		} else {
			saida.imprimirLinha("Você não pode fazer isso agora!");
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
	private void pedir(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Pedir o quê?");
			return;
		}
		if (status.getEstadoAtual() == CONVERSANDO) {
			NPC alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
			if (alvo.temItem(comando.getSegundaPalavra())) {
				if (protagonista.temItem("Carteira")) {
					if (protagonista.temEspacoNoInventario()) {
						protagonista.coletarItem(alvo.entregarItemDeQuest());
						saida.imprimirLinha("Item recebido!");
					} else {
						saida.imprimirLinha("Inventário lotado!");
					}
				} else {
					saida.imprimirLinha("Você não tem carteira agora!");
				}
			} else {
				saida.imprimirLinha("Ele não tem esse item!");
			}
		} else {
			saida.imprimirLinha("Como assim pedir, tá doido? Peça [ajuda] urgente...");
		}
	}
        
        /**
         * Metodo cancelar
         * 
         * cancela uma operacao.
         * 
         */
	private void cancelar() {
		if (status.getEstadoAtual() == CONVERSANDO) {
			status.setEstadoAtual(NAVEGANDO, "");
			saida.imprimirLinha("Você foi embora!");
		} else {
			saida.imprimirLinha("Cancelar o quê?");
		}
	}
        
        /**
         * Metodo fugir
         * 
         * foge de uma luta com um npc.
         * 
         * 
         */
	private void fugir() {
		if (status.getEstadoAtual() == ATACANDO) {
			if (ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual()).ehImortal()) {
				status.setEstadoAtual(NAVEGANDO, "");
				saida.imprimirLinha("Você fugiu!");
			} else {
				saida.imprimirLinha("Você não pode fugir dessa luta!");
			}
		} else {
			saida.imprimirLinha("Fugir de onde?");
		}
	}
        
        /**
         * Metodo usar
         * 
         * responsavel por fazer o usuario usar um item.
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando usar,
         * tambem qual item usar.
         */
	private void usar(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Usar o quê?");
			return;
		}
		if (status.getEstadoAtual() == NAVEGANDO) {
			if (protagonista.temItem(comando.getSegundaPalavra())) {
				Resultado resultado = protagonista.usarItem(comando.getSegundaPalavra(), protagonista);
				if (resultado == SUCESSO) {
					saida.imprimirLinha("Item usado! Cheque seu status!");
				}
			} else if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
				Resultado resultado = ambienteAtual.aplicarItem(comando.getSegundaPalavra(), protagonista);
				if (resultado == SUCESSO) {
					saida.imprimirLinha("Item usado! Cheque seu status!");
				}
			} else {
				saida.imprimirLinha("Item inexistente!");
			} 
		} else if (status.getEstadoAtual() == ATACANDO) {
			Ator alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
			if (comando.getSegundaPalavra().equalsIgnoreCase("habilidade")) {
				Resultado resultado = protagonista.usarHabilidade(alvo);
				if (resultado == SUCESSO) {
					saida.imprimirLinha("Habilidade usada! Cheque o status de seu inimigo!");
				}
			} else {
				if (protagonista.temItem(comando.getSegundaPalavra())) {
					Resultado resultado = protagonista.usarItem(comando.getSegundaPalavra(), alvo);
					if (resultado == SUCESSO) {
						saida.imprimirLinha("Item usado! Cheque o status de seu inimigo!");
					}
				} else if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
					Resultado resultado = ambienteAtual.aplicarItem(comando.getSegundaPalavra(), alvo);
					if (resultado == SUCESSO) {
						saida.imprimirLinha("Item usado! Cheque o status de seu inimigo!");
					}
				} else {
					saida.imprimirLinha("Item inexistente!");
				} 
			}
			if (alvo.taVivo()) {
				Resultado resultado = alvo.usarHabilidade(protagonista);
				if (resultado == SUCESSO) {
					saida.imprimirLinha("Você foi atacado! Cheque seu status!");
				}
			} else {
				saida.imprimirLinha("Você pode continuar o jogo, e conseguiu segurar seu surto por mais uma rodada!");
				status.setEstadoAtual(NAVEGANDO, "");
				status.matou(true);
			}
		}
	}
        
        /**
         * Metodo checar
         * 
         * responsavel por checar o que tem dentro de cada ambiente.
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando checar,
         * tambem qual ambiente checar.
         */
	private void checar(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Checar o quê?");
			return;
		}
		if (comando.getSegundaPalavra().equalsIgnoreCase("enderecos")) {
			if (status.getEstadoAtual() == NAVEGANDO) {
				if (protagonista.temItem("Carteira")) {
					saida.imprimirLinha("Lista de Endereços:");
					saida.imprimirLinha("Minha casa:      Rua Python, 118 (Leste da esquina Prolog com Python)");
					saida.imprimirLinha("Manicômio:       Sul da esquina da Smalltalk com Snobol");
					saida.imprimirLinha("Farmacia:        Leste da esquina da Haskell com Snobol");
					saida.imprimirLinha("Loja do Coveiro: Oeste da esquina Haskell com Cobol");
					saida.imprimirLinha("Cemitério:       Leste da esquina Prolog com Cobol");
				} else {
					saida.imprimirLinha("Lista de Endereços: (O único que sei agora)");
					saida.imprimirLinha("Minha casa:      Rua Python, 118 (Leste da esquina Prolog com Python)");
				}
			}
		}
	}
        
        /**
         * Metodo descartar
         * 
         * responsavel por descartar um item coletado que esta com cesar
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando descartar,
         * tambem qual item descartar. 
         */
	private void descartar(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Descartar o quê?");
			return;
		}
		if (protagonista.temItem(comando.getSegundaPalavra())) {
			ambienteAtual.colocarItem(protagonista.darItem(comando.getSegundaPalavra()));
			saida.imprimirLinha("Item descartado!");
		} else {
			saida.imprimirLinha("Você não tem esse item!");
		}
	}
        
        /**
         * Metodo coletar
         * 
         * responsavel por coletar um item do ambiente onde cesar esta.
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando coletar,
         * tambem qual item coletar. 
         */
	private void coletar(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Coletar o quê?");
			return;
		}
		if (status.getEstadoAtual() != CONVERSANDO) {
			if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
				protagonista.coletarItem(ambienteAtual.recolherItem(comando.getSegundaPalavra()));
				saida.imprimirLinha("Item coletado!");
			} else {
				saida.imprimirLinha("Não tem item neste ambiente com esse nome!");
			}
		} else {
			saida.imprimirLinha("Agora não dá!");
		}
	}
        
        /**
         * Metodo mostrarInventario
         * 
         * responsavel por mostrar o inventario de cesar.
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando Mostrar,
         * tambem o inventario a mostrar. 
         */
	private void mostrarInventario(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Mostrar o quê?");
			return;
		}
		if (comando.getSegundaPalavra().equalsIgnoreCase("inventario")) {
			saida.imprimirLinha(protagonista.getListaItens());
		}
	}

        /**
         * Metodo detalhar
         * 
         * responsavel por detalhar um ambiente ou um protagonista.
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando detalhar,
         * tambem o que detalhar. 
         */
	private void detalhar(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Detalhar o quê?");
			return;
		}
		if (protagonista.temItem(comando.getSegundaPalavra())) {
			saida.imprimirLinha(protagonista.getDescricaoItem(comando.getSegundaPalavra()));
		} else if (ambienteAtual.temItem(comando.getSegundaPalavra())) {
			saida.imprimirLinha(ambienteAtual.getDescricaoItem(comando.getSegundaPalavra()));
		} else {
			saida.imprimirLinha("Item inexistente!");
		}
	}

        /**
         * Metodo descrever
         * 
         * responsavel por descrever um ambiente.
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando descrever,
         * tambem qual ambiente descrever. 
         */
	private void descrever(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Descrever o quê?");
			return;
		}
		if (comando.getSegundaPalavra().equalsIgnoreCase("ambiente")) {
			if (status.getEstadoAtual() == NAVEGANDO) {
				exibirAmbienteAtual();
			}
			if (status.getEstadoAtual() != CONVERSANDO) {
				saida.imprimirLinha("NPCs agora no ambiente:");
				saida.imprimirLinha(ambienteAtual.getListaNPCs());
				saida.imprimirLinha("Objetos no ambiente:");
				saida.imprimirLinha(ambienteAtual.getListaItens());
			} else {
				saida.imprimirLinha("Agora não!");
			}
		} else if (comando.getSegundaPalavra().equalsIgnoreCase("npc")) {
			if (status.getEstadoAtual() == CONVERSANDO) {
				saida.imprimirLinha(ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual()).getListaItens());
			} else {
				saida.imprimirLinha("Você não pode usar esse comando agora!");
			}
		} else {
			saida.imprimirLinha("Forma incorreta de descrever algo! Digite [ajuda] e confira...");
		}
	}

        /**
         * Metodo imprimirStatus
         * 
         * responsavel por imprimir o status de cesar ou de um protagonista
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando status,
         * tambem o status de quem deseja imprimir. 
         */
	private void imprimirStatus(Comando comando) {
		if (!comando.temSegundaPalavra()) {
			saida.imprimirLinha("Status de quem?");
			return;
		}
		if (comando.getSegundaPalavra().equalsIgnoreCase("npc")) {
			if (status.getEstadoAtual() == ATACANDO) {
				NPC alvo = ambienteAtual.selecionarNPC(status.getNomeDoNPCAtual());
				saida.imprimirLinha(alvo.getStatus());
			} else {
				saida.imprimirLinha("Nesse estado você só pode ver o seu status! Tente [status eu]...");
			}
		} else if (comando.getSegundaPalavra().equalsIgnoreCase("eu")) {
			saida.imprimirLinha(protagonista.getStatus());
		} else {
			saida.imprimirLinha("Forma incorreta de solicitar o status! Digite [ajuda] e confira...");
		}
	}

	/**
	 * Metodo imprimirBoasVindas
         * 
         * Responsavel por imprimir as boas vindas do jogo (cabecalho).
	 *
         * Chama o metodo exibir ambiente depois das boas vindas.
	 */
	private void imprimirBoasVindas() {
		saida.imprimirLinha("    Bem Vindo ao Jogo \"World of Zuul - O Manicômio de Zulu\".");
		saida.imprimirLinha("    Este é um jogo no estilo Adventure em modo texto.");
		saida.imprimirLinha("\n    Boa Sorte e não enlouqueça!!!");
		saida.imprimirLinha("\n    Você é César, o professor de PPOO ");
		saida.imprimirLinha("(Planejamento de Planos de Organizações Organizacionais).");
		saida.imprimirLinha("Você saiu da faculdade e está terrivelmente estressado, e de repente você se");
		saida.imprimirLinha("lembra de que não tomou seus remédios controlados e está prestes a");
		saida.imprimirLinha("enlouquecer!!!");
		saida.imprimirLinha("\n    Você está no meio da cidade de Zulu, uma pequena cidade castigada pelo");
		saida.imprimirLinha("descuido da prefeitura, lotada de cães raivosos de rua, num ponto próximo à");
		saida.imprimirLinha("sua casa. Lá você esqueceu sua carteira, e precisa dela para comprar");
		saida.imprimirLinha("seu medicamento na farmácia.");
		saida.imprimirLinha("\n    Seu objetivo aqui é conseguir alcançar 30 pontos de Sanidade ou mais,");
		saida.imprimirLinha("tendo em mente que como você está em uma delicada situação psicológica,");
		saida.imprimirLinha("perderá 1 ponto de Sanidade a cada ambiente que você avançar, tornando");
		saida.imprimirLinha("cada vez mais desafiadora a sua experiência! Descubra maneiras de explorar");
		saida.imprimirLinha("o jogo com mais tempo, maneiras de controlar sua loucura e muito mais!!!");
		saida.imprimirLinha("\n    E cuidado pra não zerar nenhum dos seus atributos mais importantes,");
		saida.imprimirLinha("porque senão você pode acabar num caixão... Ou pior ainda... Internado");
		saida.imprimirLinha("compulsoriamente no MANICÔMIO DE ZULU!");

		exibirAmbienteAtual();
	}

	/**
	 * Metodo imprimirAjuda
         * 
         * Imprime uma ajuda pro usuario do jogo com todos os comando validos em 
         * determinada situacao.
	 *
	 */
	private void imprimirAjuda() {
		saida.imprimirLinha("Você precisa de medicamentos para lidar com a psicose!!");
		saida.imprimirLinha("Seus comandos agora são:");
		if (status.getEstadoAtual() == NAVEGANDO) {
			saida.imprimirLinha("[ir <direcao>]\tVá para a direção que quiser da lista de saídas de cada ambiente!");
			saida.imprimirLinha("[descrever ambiente]\tVeja a descrição completa de onde estás!");
			saida.imprimirLinha("[mostrar inventario]\tVeja o que estás carregando!");
			saida.imprimirLinha("[coletar <nome_item>]\tSe seu inventário não estiver cheio, ele é seu!");
			saida.imprimirLinha("[usar <nome_item>]\tVocê usará um item, em você mesmo (mesmo um ofensivo)!");
			saida.imprimirLinha("[descartar <nome_item>]\tQuando já não lhe servir, deixe que alguém o pegue!");
			saida.imprimirLinha("[status eu]\tVeja o seu Status!");
			saida.imprimirLinha("[conversar <nome_npc>]\tConverse com eles e veja como podem te ajudar!");
			saida.imprimirLinha("[atacar <nome_npc>]\tOu mostre a eles o inferno hahahaha!!");
		} else if (status.getEstadoAtual() == CONVERSANDO) {
			saida.imprimirLinha("[status eu]\tVeja o seu Status!");
			saida.imprimirLinha("[mostrar inventario]\tVeja o que estás carregando!");
			saida.imprimirLinha("[pedir <nome_item>]\tSe tiver como pagar, peça, senão, fique aguado!");
			saida.imprimirLinha("[descrever npc]\tVocê vê o inventário do NPC!");
			saida.imprimirLinha("[descartar <nome_item>]\tQuando já não lhe servir, deixe que alguém o pegue!");
			saida.imprimirLinha("[cancelar]\tVolte ao que estava fazendo!");
		} else if (status.getEstadoAtual() == ATACANDO) {
			saida.imprimirLinha("[status eu]\tVeja o seu Status!");
			saida.imprimirLinha("[status npc]\tVeja o Status do seu inimigo!");
			saida.imprimirLinha("[mostrar inventario]\tVeja o que estás carregando!");
			saida.imprimirLinha("[usar habilidade]\tFaça o que faz de melhor e use sua habilidade para massacrar!");
			saida.imprimirLinha("[usar <nome_item>]\tVocê usará um item no seu oponente (mesmo um item positivo)!");
			saida.imprimirLinha("[descrever ambiente]\tVeja o que está a sua volta!");
			saida.imprimirLinha("[fugir]\tSe tiver azar de enfrentar alguém muito forte, apenas tente!");
		}
	}

	/**
         * Metodo irParaAmbiente
         * 
         * responsavel por sair de um ambiente atual e ir para outro ambiente passado
         * atraves do sentido.
         * 
         * @param comando do tipo  {@link Comando}, rescebe alem do comando ir,
         * tambem qual direcao ir. 
         */
	private void irParaAmbiente(Comando comando) {
		if (status.getEstadoAtual() == NAVEGANDO) {
			if (!comando.temSegundaPalavra()) {
				// caso o comando não tiver segunda palavra.
				saida.imprimirLinha("Você é doido? Quer ir aonde?");
				return;
			}
			String direcao = comando.getSegundaPalavra();
			Ambiente proximoAmbiente = ambienteAtual.getAmbiente(direcao);
			if (proximoAmbiente == null) {
				saida.imprimirLinha("Você não vai a lugar algum, procure outra saída!");
			} else {
				if (!status.teveMatanca()) {
					protagonista.afetarAtributo(SANIDADE, -1);
				}
				status.matou(false);
				ambienteAtual = proximoAmbiente;
				exibirAmbienteAtual();
			}
		} else {
			saida.imprimirLinha("Você está no meio de uma interação! Acabe-a e pode andar!");
		}
	}

	/**
	 * Metodo exibirAmbienteAtual
         * 
         * responsavel por dizer onde cesar esta no momento.
	 *
	 */
	private void exibirAmbienteAtual() {
		saida.imprimirLinha("Você está na " + ambienteAtual.getDescricao());
		saida.imprimirLinha("Saidas:");
		String saidasDisponiveis = ambienteAtual.getListaSaidas();
		if (saidasDisponiveis.equals(SEM_SAIDA)) {
			saida.imprimirLinha("[ATENÇÃO!! O AMBIENTE ATUAL NÃO POSSUI SAÍDAS! CUIDE DISSO!]");
		} else {
			saida.imprimirLinha(saidasDisponiveis);
		}
	}

	/**
	 * Metodo sair
         * 
         * responsavel por retornar um comando validando a saida do usuario do
         * jogo.
         * 
         * @return boolean
	 */
	private boolean sair() {
		return true;
	}
}