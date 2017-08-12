/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities;

import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.UtilitariosGUI.CAMINHO_DOS_MAPAS;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author biiirl
 */
public class TESTE {

    private Ambiente casaDoCesar;
    private Ambiente loja;
    private Ambiente farmacia;
    private Ambiente portaDaFaculdade;
    private Ambiente manicomio;
    private Ambiente ambienteAtual;
    
    private void criarAmbientes() {
        Ambiente esquina_Fortran_Python, esquina_Fortran_Cobol, esquina_Fortran_Lua, esquina_Fortran_Snobol,
                esquina_Smalltalk_Python, esquina_Smalltalk_Cobol, esquina_Smalltalk_Lua, esquina_Smalltalk_Snobol,
                esquina_Haskell_Python, esquina_Haskell_Cobol, esquina_Haskell_Lua, esquina_Haskell_Snobol,
                esquina_Prolog_Python, esquina_Prolog_Cobol, esquina_Prolog_Lua, esquina_Prolog_Snobol;

        esquina_Fortran_Python = new Ambiente("Esquina da rua Fortran com a rua Python", "esquina5.png");
        esquina_Fortran_Cobol = new Ambiente("Esquina da rua Fortran com a rua Cobol", "esquina6.png");
        esquina_Fortran_Lua = new Ambiente("Esquina da rua Fortran com a rua Lua", "esquina5.png");
        esquina_Fortran_Snobol = new Ambiente("Esquina da rua Fortran com a rua Snobol", "esquina6.png");
        esquina_Smalltalk_Python = new Ambiente("Esquina da rua Smalltalk com a rua Python", "esquina1.png");
        esquina_Smalltalk_Cobol = new Ambiente("Esquina da rua Smalltalk com a rua Cobol", "esquina3.png");
        esquina_Smalltalk_Lua = new Ambiente("Esquina da rua Smalltalk com a rua Lua", "esquina1.png");
        esquina_Smalltalk_Snobol = new Ambiente("Esquina da rua Smalltalk com a rua Snobol", "esquina3.png");
        esquina_Haskell_Python = new Ambiente("Esquina da rua Haskell com a rua Python", "esquina2.png");
        esquina_Haskell_Cobol = new Ambiente("Esquina da rua Haskell com a rua Cobol", "esquina4.png");
        esquina_Haskell_Lua = new Ambiente("Esquina da rua Haskell com a rua Lua", "esquina2.png");
        esquina_Haskell_Snobol = new Ambiente("Esquina da rua Haskell com a rua Snobol", "esquina4.png");
        esquina_Prolog_Python = new Ambiente("Esquina da rua Prolog com a rua Python", "esquina1.png");
        esquina_Prolog_Cobol = new Ambiente("Esquina da rua Prolog com a rua Cobol", "esquina3.png");
        esquina_Prolog_Lua = new Ambiente("Esquina da rua Prolog com a rua Lua", "esquina1.png");
        esquina_Prolog_Snobol = new Ambiente("Esquina da rua Prolog com a rua Snobol", "esquina3.png");

        List<Ambiente> ruaPython = new ArrayList<>();
        preencherArrayDeCasas(ruaPython, "Rua Python", 17, 50);
        
        casaDoCesar = new Ambiente("Minha Casa", "casaDoCesar.png");
        Ambiente portaDaCasaDoCesar = new Ambiente("Rua Python, 118 - Sua casa", "casa2.png");

        List<Ambiente> ruaCobol = new ArrayList<>();
        preencherArrayDeCasas(ruaCobol, "Rua Cobol", 5, 150);
        loja = new Ambiente("Interior da Loja do Coveiro", "lojaInterior.png");
        Ambiente portaDaLoja = new Ambiente("Loja do Coveiro", "loja.png");
        Ambiente cemiterio = new Ambiente("Entrada do Cemitério Parada Final", "cemiterio.png");

        List<Ambiente> ruaLua = new ArrayList<>();
        preencherArrayDeCasas(ruaLua, "Rua Lua", 4, 350);

        List<Ambiente> ruaSnobol = new ArrayList<>();
        preencherArrayDeCasas(ruaSnobol, "Rua Snobol", 3, 450);
        
        farmacia = new Ambiente("Interior da Drogaria Saradão", "farmaciaInterior.png");
        Ambiente portaDaFarmacia = new Ambiente("Drogaria Saradão", "farmacia.png");
        portaDaFaculdade = new Ambiente("UFLA - Universidade Federal de Loucos Autistas [FECHADA]", "escola.png");

        List<Ambiente> ruaSmalltalk = new ArrayList<>();
        preencherArrayDeCasas(ruaSmalltalk, "Rua Smalltalk", 3, 550);

        Ambiente portaDoManicomio = new Ambiente("Manicômio Olo & Co", "manicomio.png");
        manicomio = new Ambiente("Recepção do Manicômio Olo & Co", "manicomioInterior.png");

        List<Ambiente> ruaHaskell = new ArrayList<>();
        preencherArrayDeCasas(ruaHaskell, "Rua Haskell", 3, 650);

        List<Ambiente> ruaProlog = new ArrayList<>();
        preencherArrayDeCasas(ruaProlog, "Rua Prolog", 3, 750);

        List<Ambiente> saidaDaCidade = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            String descricao = "Saída de Zulu";
            saidaDaCidade.add(new Ambiente(descricao, "casa" + ((i % 2) + 1) + ".png"));
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
            rua.add(new Ambiente(descricao, "casa" + ((i % 2) + 1) + ".png"));
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
        Item chuveiro = new Item("Chuveiro", "Uma bela ducha quente, ótima nesse friozinho de Zulu!", "Chuveiro.png", efeitosChuveiro, true, false);
        Item carteira = new Item("Carteira", "Contém seus documentos e dinheiro o suficiente.", "Carteira.png", new ArrayList<>(), false, true);
        Item mapa = new Item("Mapa", "É um bom mapa de Zulu. Estão circulados pontos importantes", "Mapa.png", new ArrayList<>(), false, true);
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
            int x = rnd.nextInt(10);
            if (x > 2) {
                rua.get(i).colocarNPC(new Cachorro("Cachorro" + contaCachorro));
                contaCachorro++;
            }
            x = rnd.nextInt(10);
            if (x > 5) {
                rua.get(i).colocarItem(new Item("Pedra", "Um cascalho comum. Cabe na mão.", "Pedra.png", efeitosPedrada, true, true));
            }
        }
        return contaCachorro;
    }
    
    public TESTE() {
        criarAmbientes();
        salvar();
    }
    
    private void salvar() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fout = new FileOutputStream(new File(CAMINHO_DOS_MAPAS + "Cidade de Zulu.dat"));
            oos = new ObjectOutputStream(fout);
            oos.writeObject(ambienteAtual);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Nenhum registro encontrado! Iniciando novos registros!", 
                    "O Manicômio de Zulu", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum problema com sua unidade de armazenamento!", 
                    "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ocorreu algum problema com sua unidade de armazenamento!", 
                            "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Mundo salvo!", "O Manicômio de Zulu", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        new TESTE();
    }
}
