/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.AlteracaoDeHP;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.AlteracaoDeSanidade;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Cachorro;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Chilofompila;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Efeito;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.EsvaziamentoDeInventario;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Farmaceuta;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Item;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Medico;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.NPC;
import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.entities.Vendedor;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.TipoDeRecurso.BACKGROUND;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.TipoDeRecurso.ITEM;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.TipoDeRecurso.NPC;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.UtilitariosGUI.CAMINHO_DOS_BACKGROUNDS;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.UtilitariosGUI.CAMINHO_DOS_ICONES;
import static br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui.UtilitariosGUI.CAMINHO_DOS_ITENS;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author biiirl
 */
public class DialogoNavegadoraDeRecursos extends javax.swing.JDialog {

    private JLabel ultimaLabelSelecionada;
    private String arquivoSelecionado;
    private List<Efeito> efeitosAtual;
    private List<Item> itens;
    private Item itemSelecionado;
    private NPC npcSelecionado, auxNPC;
    private int modo;
    
    /**
     * Creates new form DialogoNavegadoraDeImagens
     * @param parent O componente que invocou esse diálogo
     * @param modal Se o diálogo força o foco, <code>true</code>. Senão, <code>false</code>.
     * @param modo O tipo de requisição desse diálogo.
     */
    public DialogoNavegadoraDeRecursos(java.awt.Frame parent, boolean modal, TipoDeRecurso modo) {
        super(parent, modal);
        initComponents();
        initAtributos(modo);
    }
    
    private void initAtributos(TipoDeRecurso modo) {
        ultimaLabelSelecionada = null;
        arquivoSelecionado = null;
        itemSelecionado = null;
        npcSelecionado = null;
        efeitosAtual = new ArrayList<>();
        carregarItens();
        switch (modo) {
            case BACKGROUND:
                this.modo = 0;
                break;
            case ICONE:
                this.modo = 1;
                break;
            case ITEM:
                this.modo = 2;
                break;
            default:
                this.modo = 3;
                break;
        }
        preencherGaleria();
        preencherItens();
        setLocationRelativeTo(this.getParent());
        habilitarAbas();
    }
    
    private void habilitarAbas() {
        for (int i = 0; i < 5; i++) {
            painelDeAbas.setEnabledAt(i, false);
        }
        switch(modo) {
            case 0:
                painelDeAbas.setEnabledAt(0, true);
                painelDeAbas.setSelectedIndex(0);
                break;
            case 1:
                painelDeAbas.setEnabledAt(1, true);
                painelDeAbas.setSelectedIndex(1);
                break;
            case 2:
                painelDeAbas.setEnabledAt(1, true);
                painelDeAbas.setEnabledAt(2, true);
                painelDeAbas.setEnabledAt(3, true);
                painelDeAbas.setSelectedIndex(3);
                break;
            case 3:
                painelDeAbas.setEnabledAt(4, true);
                painelDeAbas.setSelectedIndex(4);
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        seletorDeArquivo = new javax.swing.JFileChooser();
        jSeparator1 = new javax.swing.JSeparator();
        painelDeAbas = new javax.swing.JTabbedPane();
        painelPlanosDeFundo = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        painelBackgorunds = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        botaoArquivoBackground = new javax.swing.JButton();
        campoImagemBackgorund = new javax.swing.JTextField();
        botaoAdicionar = new javax.swing.JButton();
        painelOpcoesDeIcones = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        botaoArquivoIcone = new javax.swing.JButton();
        campoImagemIcone = new javax.swing.JTextField();
        botaoAdicionarIcone = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        painelIcones = new javax.swing.JPanel();
        botaoSelecionarIcone = new javax.swing.JButton();
        painelItens = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoNomeItem = new javax.swing.JTextField();
        campoDescricaoItem = new javax.swing.JTextField();
        checkConsumivel = new javax.swing.JCheckBox();
        checkColetavel = new javax.swing.JCheckBox();
        labelIconeItem = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        campoNomeEfeito = new javax.swing.JTextField();
        campoDescricaoEfeito = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboTipoDeEfeito = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        campoQuantidadeEfeito = new javax.swing.JTextField();
        labelQuantidade = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEfeitos = new javax.swing.JTable();
        adicionarOuAlterarEfeito = new javax.swing.JButton();
        botaoRegistrarItem = new javax.swing.JButton();
        painelExibirItens = new javax.swing.JPanel();
        painelInserirItem = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        painelItensRegistrados = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        labelNomeItem = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        labelDescricaoItem = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        labelEfeitosItem = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelColetavel = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        labelConsumivel = new javax.swing.JLabel();
        painelNPCs = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        botaoFarmaceuta = new javax.swing.JButton();
        botaoMedico = new javax.swing.JButton();
        botaoChilofompila = new javax.swing.JButton();
        botaoVelho = new javax.swing.JButton();
        botaoCachorro = new javax.swing.JButton();
        labelNPCselecionado = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botaoOk = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();

        seletorDeArquivo.setAcceptAllFileFilterUsed(false);
        seletorDeArquivo.setApproveButtonText("Abrir");
        seletorDeArquivo.setApproveButtonToolTipText("Copiar o arquivo para o diretório do jogo");
        seletorDeArquivo.setDialogTitle("Abrir imagem de Background");
        seletorDeArquivo.addChoosableFileFilter(new FileNameExtensionFilter("Arquivos de Imagem", ImageIO.getReaderFileSuffixes()));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(510, 614));
        setMinimumSize(new java.awt.Dimension(510, 614));
        setModal(true);
        setResizable(false);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Galeria"));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        painelBackgorunds.setBackground(new java.awt.Color(255, 255, 255));
        painelBackgorunds.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelBackgorundsMouseClicked(evt);
            }
        });
        painelBackgorunds.setLayout(new java.awt.GridLayout(0, 2, 5, 5));
        jScrollPane2.setViewportView(painelBackgorunds);

        botaoArquivoBackground.setText("Selecionar arquivo");
        botaoArquivoBackground.setFocusable(false);
        botaoArquivoBackground.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoArquivoBackgroundActionPerformed(evt);
            }
        });

        campoImagemBackgorund.setFocusable(false);
        campoImagemBackgorund.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoImagemBackgorundMouseClicked(evt);
            }
        });

        botaoAdicionar.setText("Adicionar à galeria");
        botaoAdicionar.setEnabled(false);
        botaoAdicionar.setFocusable(false);
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoArquivoBackground)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoImagemBackgorund)
                .addContainerGap())
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoArquivoBackground)
                    .addComponent(campoImagemBackgorund, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botaoAdicionar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelPlanosDeFundoLayout = new javax.swing.GroupLayout(painelPlanosDeFundo);
        painelPlanosDeFundo.setLayout(painelPlanosDeFundoLayout);
        painelPlanosDeFundoLayout.setHorizontalGroup(
            painelPlanosDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPlanosDeFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPlanosDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        painelPlanosDeFundoLayout.setVerticalGroup(
            painelPlanosDeFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPlanosDeFundoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        painelDeAbas.addTab("Planos de fundo", painelPlanosDeFundo);

        painelOpcoesDeIcones.setEnabled(false);

        botaoArquivoIcone.setText("Selecionar arquivo");
        botaoArquivoIcone.setFocusable(false);
        botaoArquivoIcone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoArquivoIconeActionPerformed(evt);
            }
        });

        campoImagemIcone.setFocusable(false);
        campoImagemIcone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoImagemIconeMouseClicked(evt);
            }
        });

        botaoAdicionarIcone.setText("Adicionar aos Ícones");
        botaoAdicionarIcone.setEnabled(false);
        botaoAdicionarIcone.setFocusable(false);
        botaoAdicionarIcone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarIconeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoArquivoIcone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoImagemIcone, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(botaoAdicionarIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(158, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoArquivoIcone)
                    .addComponent(campoImagemIcone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(botaoAdicionarIcone)
                .addContainerGap())
        );

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder("Galeria"));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        painelIcones.setBackground(new java.awt.Color(255, 255, 255));
        painelIcones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelIconesMouseClicked(evt);
            }
        });
        painelIcones.setLayout(new java.awt.GridLayout(0, 8, 2, 2));
        jScrollPane3.setViewportView(painelIcones);

        botaoSelecionarIcone.setText("Selecionar ícone >>");
        botaoSelecionarIcone.setEnabled(false);
        botaoSelecionarIcone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSelecionarIconeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelOpcoesDeIconesLayout = new javax.swing.GroupLayout(painelOpcoesDeIcones);
        painelOpcoesDeIcones.setLayout(painelOpcoesDeIconesLayout);
        painelOpcoesDeIconesLayout.setHorizontalGroup(
            painelOpcoesDeIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOpcoesDeIconesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelOpcoesDeIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOpcoesDeIconesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botaoSelecionarIcone)))
                .addContainerGap())
        );
        painelOpcoesDeIconesLayout.setVerticalGroup(
            painelOpcoesDeIconesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOpcoesDeIconesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoSelecionarIcone)
                .addContainerGap())
        );

        painelDeAbas.addTab("Ícones", painelOpcoesDeIcones);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações do item"));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Nome do item:");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Descrição do item:");

        checkConsumivel.setText("Consumível");

        checkColetavel.setText("Coletável");

        labelIconeItem.setToolTipText("Clique aqui para selecionar um ícone");
        labelIconeItem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelIconeItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelIconeItemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                labelIconeItemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelIconeItemMouseExited(evt);
            }
        });

        jLabel4.setText("Ícone:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkColetavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(checkConsumivel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(labelIconeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(campoDescricaoItem, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoNomeItem))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDescricaoItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(labelIconeItem, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkColetavel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkConsumivel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Efeitos"));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });

        campoNomeEfeito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNomeEfeitoKeyPressed(evt);
            }
        });

        campoDescricaoEfeito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoDescricaoEfeitoKeyPressed(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Nome do efeito:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descrição do efeito:");

        comboTipoDeEfeito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alteração de HP", "Alteração de Sanidade", "Esvaziamento de Inventário" }));
        comboTipoDeEfeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoDeEfeitoActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Tipo de efeito:");

        campoQuantidadeEfeito.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoQuantidadeEfeitoKeyPressed(evt);
            }
        });

        labelQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelQuantidade.setText("Quantidade:");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(100, 100));

        tabelaEfeitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Descrição", "Tipo", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaEfeitos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaEfeitos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                tabelaEfeitosLinhaSelecionada(event);
            }
        });
        jScrollPane1.setViewportView(tabelaEfeitos);

        adicionarOuAlterarEfeito.setText("Adicionar efeito");
        adicionarOuAlterarEfeito.setEnabled(false);
        adicionarOuAlterarEfeito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarOuAlterarEfeitoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(campoNomeEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboTipoDeEfeito, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(campoDescricaoEfeito, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(campoQuantidadeEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(adicionarOuAlterarEfeito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNomeEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDescricaoEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboTipoDeEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoQuantidadeEfeito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adicionarOuAlterarEfeito)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        botaoRegistrarItem.setText("Registrar item");
        botaoRegistrarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoRegistrarItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelItensLayout = new javax.swing.GroupLayout(painelItens);
        painelItens.setLayout(painelItensLayout);
        painelItensLayout.setHorizontalGroup(
            painelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(botaoRegistrarItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painelItensLayout.setVerticalGroup(
            painelItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelItensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoRegistrarItem, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelDeAbas.addTab("Editor de itens", painelItens);

        painelInserirItem.setBorder(javax.swing.BorderFactory.createTitledBorder("Itens registrados"));

        painelItensRegistrados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelItensRegistradosMouseClicked(evt);
            }
        });
        painelItensRegistrados.setLayout(new java.awt.GridLayout(0, 8, 2, 2));
        jScrollPane4.setViewportView(painelItensRegistrados);

        javax.swing.GroupLayout painelInserirItemLayout = new javax.swing.GroupLayout(painelInserirItem);
        painelInserirItem.setLayout(painelInserirItemLayout);
        painelInserirItemLayout.setHorizontalGroup(
            painelInserirItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInserirItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
        );
        painelInserirItemLayout.setVerticalGroup(
            painelInserirItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInserirItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalhes"));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nome do item:");

        labelNomeItem.setText("-");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Descrição do Item:");

        labelDescricaoItem.setText("-");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Efeitos:");

        labelEfeitosItem.setText("-");

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Coletável:");

        labelColetavel.setText("-");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Consumível:");

        labelConsumivel.setText("-");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelNomeItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDescricaoItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelEfeitosItem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelColetavel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelConsumivel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelNomeItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(labelDescricaoItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(labelEfeitosItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(labelColetavel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(labelConsumivel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelExibirItensLayout = new javax.swing.GroupLayout(painelExibirItens);
        painelExibirItens.setLayout(painelExibirItensLayout);
        painelExibirItensLayout.setHorizontalGroup(
            painelExibirItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelExibirItensLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelExibirItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelInserirItem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelExibirItensLayout.setVerticalGroup(
            painelExibirItensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelExibirItensLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelInserirItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDeAbas.addTab("Itens", painelExibirItens);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Selecionar NPC"));
        java.awt.GridBagLayout jPanel4Layout = new java.awt.GridBagLayout();
        jPanel4Layout.columnWidths = new int[] {0, 20, 0, 20, 0};
        jPanel4Layout.rowHeights = new int[] {0, 80, 0, 80, 0};
        jPanel4.setLayout(jPanel4Layout);

        botaoFarmaceuta.setFocusable(false);
        botaoFarmaceuta.setMaximumSize(new java.awt.Dimension(100, 100));
        botaoFarmaceuta.setMinimumSize(new java.awt.Dimension(100, 100));
        botaoFarmaceuta.setPreferredSize(new java.awt.Dimension(100, 100));
        botaoFarmaceuta.setIcon(new ImageIcon(CAMINHO_DOS_ICONES + "Filipe.png"));
        botaoFarmaceuta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFarmaceutaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(botaoFarmaceuta, gridBagConstraints);

        botaoMedico.setFocusable(false);
        botaoMedico.setMaximumSize(new java.awt.Dimension(100, 100));
        botaoMedico.setMinimumSize(new java.awt.Dimension(100, 100));
        botaoMedico.setPreferredSize(new java.awt.Dimension(100, 100));
        botaoMedico.setIcon(new ImageIcon(CAMINHO_DOS_ICONES + "Raydson.png"));
        botaoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoMedicoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(botaoMedico, gridBagConstraints);

        botaoChilofompila.setFocusable(false);
        botaoChilofompila.setMaximumSize(new java.awt.Dimension(100, 100));
        botaoChilofompila.setMinimumSize(new java.awt.Dimension(100, 100));
        botaoChilofompila.setPreferredSize(new java.awt.Dimension(100, 100));
        botaoChilofompila.setIcon(new ImageIcon(CAMINHO_DOS_ICONES + "Chilofompila.png"));
        botaoChilofompila.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoChilofompilaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(botaoChilofompila, gridBagConstraints);

        botaoVelho.setFocusable(false);
        botaoVelho.setMaximumSize(new java.awt.Dimension(100, 100));
        botaoVelho.setMinimumSize(new java.awt.Dimension(100, 100));
        botaoVelho.setPreferredSize(new java.awt.Dimension(100, 100));
        botaoCachorro.setIcon(new ImageIcon(CAMINHO_DOS_ICONES + "Velho.png"));
        botaoVelho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVelhoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(botaoVelho, gridBagConstraints);

        botaoCachorro.setIcon(new ImageIcon(CAMINHO_DOS_ICONES + "Cachorro.png"));
        botaoCachorro.setFocusable(false);
        botaoCachorro.setMaximumSize(new java.awt.Dimension(100, 100));
        botaoCachorro.setMinimumSize(new java.awt.Dimension(100, 100));
        botaoCachorro.setPreferredSize(new java.awt.Dimension(100, 100));
        botaoCachorro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCachorroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel4.add(botaoCachorro, gridBagConstraints);

        labelNPCselecionado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout painelNPCsLayout = new javax.swing.GroupLayout(painelNPCs);
        painelNPCs.setLayout(painelNPCsLayout);
        painelNPCsLayout.setHorizontalGroup(
            painelNPCsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNPCsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelNPCsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(labelNPCselecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        painelNPCsLayout.setVerticalGroup(
            painelNPCsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelNPCsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelNPCselecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelDeAbas.addTab("NPCs", painelNPCs);

        jPanel3.setMaximumSize(new java.awt.Dimension(32767, 65));
        jPanel3.setMinimumSize(new java.awt.Dimension(100, 65));
        jPanel3.setPreferredSize(new java.awt.Dimension(0, 65));

        botaoOk.setText("OK");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });

        botaoCancelar.setText("Cancelar");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDeAbas)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDeAbas)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaEfeitosLinhaSelecionada(ListSelectionEvent evt) {
        int linha = tabelaEfeitos.getSelectedRow();
        if (linha != -1) {
            DefaultTableModel model = (DefaultTableModel) tabelaEfeitos.getModel();
            campoNomeEfeito.setText((String) model.getValueAt(linha, 0));
            campoDescricaoEfeito.setText((String) model.getValueAt(linha, 1));
            String tipo = (String) model.getValueAt(linha, 2);
            int pos = (tipo.equals("AlteracaoDeHP") ? (0) : 
                     ((tipo.equals("AlteracaoDeSanidade") ? (1) : (2))));
            comboTipoDeEfeito.setSelectedIndex(pos);
            String quant = model.getValueAt(linha, 3) + "";
            campoQuantidadeEfeito.setText((quant.equals("-")? ("") : quant));
            adicionarOuAlterarEfeito.setText("Alterar efeito");
            adicionarOuAlterarEfeito.setEnabled(true);
        } else {
            campoNomeEfeito.setText("");
            campoDescricaoEfeito.setText("");
            campoQuantidadeEfeito.setText("");
            comboTipoDeEfeito.setSelectedIndex(0);
            adicionarOuAlterarEfeito.setText("Adicionar efeito");
            adicionarOuAlterarEfeito.setEnabled(false);
        }
    }
    
    
    
    private void preencherTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaEfeitos.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        int i = 1;
        for (Efeito efeito : efeitosAtual) {
            String tipo = efeito.getClass().getSimpleName();
            int quant = efeito.getQuantidade();
            model.addRow(new Object[] {efeito.getNome(), 
                efeito.getDescricao(), tipo, (quant == 0) ? ("-") : (quant)});
        }
    }
    
    private boolean checarInformacoesItem() {
        return (campoNomeItem.getText() != null) &&
               (campoNomeItem.getText().split(" ").length == 1)
               && temPreenchimento(campoDescricaoItem)
               && (labelIconeItem.getIcon() != null);
    }
    
    private boolean checarEfeitos() {
        return temPreenchimento(campoNomeEfeito)
               && temPreenchimento(campoDescricaoEfeito)
               && (comboTipoDeEfeito.getSelectedIndex() == 2
                || (temPreenchimento(campoQuantidadeEfeito) 
                 && ehNumeroInteiro(campoQuantidadeEfeito.getText())));
    }
    
    private boolean temPreenchimento(JTextField campo) {
        return campo.getText() != null && 
              !campo.getText().trim().equals("");
    }
    
    public static boolean ehNumeroInteiro(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    return true;
}
    
    private void preencherGaleria() {
        if (modo <= 2) {
            File folder;
            if (modo == 0) {
                folder = new File(CAMINHO_DOS_BACKGROUNDS);
            } else {
                folder = new File(CAMINHO_DOS_ICONES);
            }
            File[] listOfFiles = folder.listFiles();
            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    inserirMiniatura(listOfFiles[i].getAbsolutePath(), 
                            (modo == 0) 
                            ? (painelBackgorunds) : (painelIcones),
                            listOfFiles[i].getName());
                }
            }
        }
    }
    
    private void preencherItens() {
        painelItensRegistrados.removeAll();
        if (modo == 2) {
            for (Item iten : itens) {
                inserirMiniatura(CAMINHO_DOS_ICONES + iten.getIcone(), 
                        painelItensRegistrados, iten.getNome());
            }
        }
    }
    
    private void inserirMiniatura(String caminhoDoArquivo, JPanel painel, String tipText) {
        ImageIcon icon;
        if (modo == 0) {
            icon = new ImageIcon(new ImageIcon(caminhoDoArquivo)
                .getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH));
        } else {
            icon = new ImageIcon(new ImageIcon(caminhoDoArquivo)
                .getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        }
        JLabel label = new JLabel(icon) {
            @Override
            public String toString() {
                return getToolTipText();
            }
            
        };
        
        label.setToolTipText(tipText);
        
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                labelImagemMouseClicked(evt);
            }
        });
        
        int quant = painel.getComponentCount();
        GridLayout gl = (GridLayout) painel.getLayout();
        int mod = (modo == 0) ? (2) : (8);
        if (quant % mod == 0) {
            gl.setRows(gl.getRows() + 1);
        }
        painel.add(label);
        revalidate();
        repaint();
    }
    
    private void copiarArquivoParaDiretorio(String origem, String destino) {
        File source = new File(origem);
        File dest = new File(destino + "/" + source.getName());
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destChannel = new FileOutputStream(dest).getChannel();
            destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DialogoNavegadoraDeRecursos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DialogoNavegadoraDeRecursos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if (sourceChannel != null) {
                    sourceChannel.close();
                }
                if (destChannel != null) {
                    destChannel.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(DialogoNavegadoraDeRecursos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    private void desmarcarUltimaLabel() {
        if (ultimaLabelSelecionada != null) {
            ultimaLabelSelecionada.setBorder(null);
            ultimaLabelSelecionada = null;
            botaoSelecionarIcone.setEnabled(false);
        }
    }
    
    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        copiarArquivoParaDiretorio(campoImagemBackgorund.getText(), CAMINHO_DOS_BACKGROUNDS);
        File arquivo = new File(campoImagemBackgorund.getText());
        inserirMiniatura(arquivo.getAbsolutePath(), painelBackgorunds, arquivo.getName());
        campoImagemBackgorund.setText("");
        botaoAdicionar.setEnabled(false);
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void procurarArquivoNoComputador(JButton botao, JTextField campo) {
        int returnVal = seletorDeArquivo.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            campo.setText(seletorDeArquivo.getSelectedFile().getAbsolutePath());
            botao.setEnabled(true);
        } else {
            campo.setText("");
            botao.setEnabled(false);
        }
    }
    
    public void labelImagemMouseClicked(MouseEvent evt) {
        if (ultimaLabelSelecionada != null) {
            ultimaLabelSelecionada.setBorder(null);
        }
        ultimaLabelSelecionada = (JLabel) evt.getSource();
        ultimaLabelSelecionada.setBorder(BorderFactory.createLineBorder(Color.red));
        botaoSelecionarIcone.setEnabled(true);
        if (modo == 2) {
            Item item = getItem(ultimaLabelSelecionada.getToolTipText());
            if (item != null) {
                labelNomeItem.setText(item.getNome());
                labelDescricaoItem.setText(item.getDescricao());
                List<Efeito> efeitos = item.getEfeitos();
                String quaisEfeitos = "";
                for (Efeito efeito : efeitos) {
                    quaisEfeitos += efeito + " / ";
                }
                if (quaisEfeitos.equals("")) {
                    quaisEfeitos = "-";
                } else {
                    quaisEfeitos = quaisEfeitos.substring(0, quaisEfeitos.length() - 3);
                }
                labelEfeitosItem.setText(quaisEfeitos);
                labelColetavel.setText((item.ehColetavel()) ? ("Sim") : ("Não"));
                labelConsumivel.setText((item.ehConsumivel()) ? ("Sim") : ("Não"));
            } else {
                limparLabels();
            }
        } 
    }
    
    private void limparLabels() {
        labelNomeItem.setText("-");
        labelDescricaoItem.setText("-");
        labelEfeitosItem.setText("-");
        labelColetavel.setText("-");
        labelConsumivel.setText("-");
    }
    
    private boolean conferirNome(String nome) {
        for (Item iten : itens) {
            if (iten.getNome().equals(nome)) {
                return false;
            }
        }
        return true;
    }
    
    private void reiniciarCamposDeEfeito() {
        campoNomeEfeito.setText("");
        campoDescricaoEfeito.setText("");
        campoQuantidadeEfeito.setText("");
        comboTipoDeEfeito.setSelectedIndex(0);
    }
    
    private void reiniciarCampos() {
        campoNomeItem.setText("");
        campoDescricaoItem.setText("");
        reiniciarCamposDeEfeito();
        checkColetavel.setSelected(false);
        checkConsumivel.setSelected(false);
        adicionarOuAlterarEfeito.setText("Adicionar efeito");
        adicionarOuAlterarEfeito.setEnabled(false);
        labelIconeItem.setToolTipText("Clique aqui para selecionar um ícone");
        labelIconeItem.setIcon(null);
        efeitosAtual = new ArrayList<>();
        preencherTabela();
    }
    
    private Item getItem(String nome) {
        for (Item iten : itens) {
            if (iten.getNome().equals(nome)) {
                return iten;
            }
        }
        return null;
    }
    
    private void botaoArquivoBackgroundActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoArquivoBackgroundActionPerformed
        procurarArquivoNoComputador(botaoAdicionar, campoImagemBackgorund);
    }//GEN-LAST:event_botaoArquivoBackgroundActionPerformed

    private void campoImagemBackgorundMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoImagemBackgorundMouseClicked
        procurarArquivoNoComputador(botaoAdicionar, campoImagemBackgorund);
    }//GEN-LAST:event_campoImagemBackgorundMouseClicked

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        if (ultimaLabelSelecionada != null) {
            if (modo == 0 || modo == 1) {
                arquivoSelecionado = ultimaLabelSelecionada.getToolTipText();
            } else if (modo == 2) {
                itemSelecionado = getItem(ultimaLabelSelecionada.getToolTipText());
            }
            this.dispose();
        } else if (modo == 3) {
            if (auxNPC != null) {
                npcSelecionado = auxNPC;
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this.getParent(), "Nenhum NPC foi selecionado!", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this.getParent(), "Nenhuma imagem foi selecionada!", "Atenção", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoOkActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

    private void painelBackgorundsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelBackgorundsMouseClicked
        desmarcarUltimaLabel();
    }//GEN-LAST:event_painelBackgorundsMouseClicked

    private void botaoArquivoIconeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoArquivoIconeActionPerformed
        procurarArquivoNoComputador(botaoAdicionarIcone, campoImagemIcone);
    }//GEN-LAST:event_botaoArquivoIconeActionPerformed

    private void campoImagemIconeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoImagemIconeMouseClicked
        procurarArquivoNoComputador(botaoAdicionarIcone, campoImagemIcone);
    }//GEN-LAST:event_campoImagemIconeMouseClicked

    private void botaoAdicionarIconeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarIconeActionPerformed
        copiarArquivoParaDiretorio(campoImagemIcone.getText(), CAMINHO_DOS_ICONES);
        File arquivo = new File(campoImagemIcone.getText());
        inserirMiniatura(arquivo.getAbsolutePath(), painelIcones, arquivo.getName());
        campoImagemIcone.setText("");
        botaoAdicionarIcone.setEnabled(false);
    }//GEN-LAST:event_botaoAdicionarIconeActionPerformed

    private void painelIconesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelIconesMouseClicked
        desmarcarUltimaLabel();
    }//GEN-LAST:event_painelIconesMouseClicked

    private void labelIconeItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconeItemMouseClicked
        painelDeAbas.setSelectedIndex(1);
    }//GEN-LAST:event_labelIconeItemMouseClicked

    private void botaoSelecionarIconeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSelecionarIconeActionPerformed
        labelIconeItem.setIcon(new ImageIcon(new ImageIcon(CAMINHO_DOS_ICONES + 
                ultimaLabelSelecionada.getToolTipText()).getImage()
                .getScaledInstance(48, 48, Image.SCALE_SMOOTH)));
        labelIconeItem.setToolTipText(ultimaLabelSelecionada.getToolTipText());
        botaoSelecionarIcone.setEnabled(false);
        painelDeAbas.setSelectedIndex(2);
    }//GEN-LAST:event_botaoSelecionarIconeActionPerformed

    private void labelIconeItemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconeItemMouseEntered
        labelIconeItem.setBorder(null);
        labelIconeItem.setBorder(new LineBorder(Color.red));
    }//GEN-LAST:event_labelIconeItemMouseEntered

    private void labelIconeItemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelIconeItemMouseExited
        labelIconeItem.setBorder(null);
        labelIconeItem.setBorder(new LineBorder(Color.black));
    }//GEN-LAST:event_labelIconeItemMouseExited

    private void adicionarOuAlterarEfeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarOuAlterarEfeitoActionPerformed
        Efeito efeito;
        switch (comboTipoDeEfeito.getSelectedIndex()) {
            case 0:
                efeito = new AlteracaoDeHP(campoNomeEfeito.getText(),
                        campoDescricaoEfeito.getText(),
                        Integer.parseInt(campoQuantidadeEfeito.getText()));
                break;
            case 1:
                efeito = new AlteracaoDeSanidade(campoNomeEfeito.getText(),
                        campoDescricaoEfeito.getText(),
                        Integer.parseInt(campoQuantidadeEfeito.getText()));
                break;
            default:
                efeito = new EsvaziamentoDeInventario(campoNomeEfeito.getText(),
                        campoDescricaoEfeito.getText());
                break;
            }
        if (tabelaEfeitos.getSelectedRow() != -1) {
            efeitosAtual.set(tabelaEfeitos.getSelectedRow(), efeito);
        } else {
            efeitosAtual.add(efeito);
        }
        reiniciarCamposDeEfeito();
        preencherTabela();
    }//GEN-LAST:event_adicionarOuAlterarEfeitoActionPerformed

    private void comboTipoDeEfeitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoDeEfeitoActionPerformed
        adicionarOuAlterarEfeito.setEnabled(checarEfeitos());
        if (comboTipoDeEfeito.getSelectedIndex() == 2) {
            campoQuantidadeEfeito.setEnabled(false);
        } else {
            campoQuantidadeEfeito.setEnabled(true);
        }
    }//GEN-LAST:event_comboTipoDeEfeitoActionPerformed

    private void painelItensRegistradosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelItensRegistradosMouseClicked
        limparLabels();
        desmarcarUltimaLabel();
    }//GEN-LAST:event_painelItensRegistradosMouseClicked

    private void botaoRegistrarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoRegistrarItemActionPerformed
        if (checarInformacoesItem()) {
            String nome = campoNomeItem.getText();
            if (conferirNome(nome)) {
                conferirNome(nome);
                String descricao = campoDescricaoItem.getText();
                Item item = new Item(nome, descricao, labelIconeItem.getToolTipText(), efeitosAtual, checkConsumivel.isSelected(), checkColetavel.isSelected());
                itens.add(item);
                reiniciarCampos();
                preencherItens();
                salvarItens();
            } else {
                JOptionPane.showMessageDialog(this, "Não se pode ter 2 itens com mesmo nome!", 
                        "O Manicômio de Zulu", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Preencha corretamente os campos!", 
                        "O Manicômio de Zulu", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_botaoRegistrarItemActionPerformed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        tabelaEfeitos.clearSelection();
    }//GEN-LAST:event_jPanel2MousePressed

    private void campoNomeEfeitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNomeEfeitoKeyPressed
        adicionarOuAlterarEfeito.setEnabled(checarEfeitos());
    }//GEN-LAST:event_campoNomeEfeitoKeyPressed

    private void campoDescricaoEfeitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoDescricaoEfeitoKeyPressed
        adicionarOuAlterarEfeito.setEnabled(checarEfeitos());
    }//GEN-LAST:event_campoDescricaoEfeitoKeyPressed

    private void campoQuantidadeEfeitoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoQuantidadeEfeitoKeyPressed
        adicionarOuAlterarEfeito.setEnabled(checarEfeitos());
    }//GEN-LAST:event_campoQuantidadeEfeitoKeyPressed

    private String getNomeDoAtor(String parteDaMensagem) {
        return JOptionPane.showInputDialog(this, "Qual é o nome " + parteDaMensagem + "?",
                "O Manicômio de Zulu", JOptionPane.QUESTION_MESSAGE);
    }
    
    private void imprimirAtorEscolhido(String tipoDeAtor, String nome) {
        labelNPCselecionado.setText(tipoDeAtor + " conhecido como " + nome 
                    + " gerado com sucesso! Clique OK para continuar...");
    }
    
    private void botaoFarmaceutaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFarmaceutaActionPerformed
        String nome = getNomeDoAtor("do seu Farmaceuta");
        if (nome != null) {
            nome = nome.split(" ")[0];
            auxNPC = new Farmaceuta(nome);
            imprimirAtorEscolhido("Farmaceuta", nome);
        }
    }//GEN-LAST:event_botaoFarmaceutaActionPerformed

    private void botaoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoMedicoActionPerformed
        String nome = getNomeDoAtor("do seu Médico");
        if (nome != null) {
            nome = nome.split(" ")[0];
            auxNPC = new Medico(nome);
            imprimirAtorEscolhido("Médico", nome);
        }
    }//GEN-LAST:event_botaoMedicoActionPerformed

    private void botaoCachorroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCachorroActionPerformed
        String nome = getNomeDoAtor("do seu Cachorro");
        if (nome != null) {
            nome = nome.split(" ")[0];
            auxNPC = new Cachorro(nome);
            imprimirAtorEscolhido("Cachorro", nome);
        }
    }//GEN-LAST:event_botaoCachorroActionPerformed

    private void botaoChilofompilaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoChilofompilaActionPerformed
        auxNPC = new Chilofompila();
        imprimirAtorEscolhido("Chilofompila", "Chilofompila (óbvio)");
    }//GEN-LAST:event_botaoChilofompilaActionPerformed

    private void botaoVelhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVelhoActionPerformed
        String nome = getNomeDoAtor("do seu Vendedor");
        if (nome != null) {
            nome = nome.split(" ")[0];
            auxNPC = new Vendedor(nome);
            imprimirAtorEscolhido("Vendedor", nome);
        }
    }//GEN-LAST:event_botaoVelhoActionPerformed

    public String getImagemSelecionada() {
        return arquivoSelecionado;
    }
    
    public Item getItemSelecionado() {
        return itemSelecionado;
    }
    
    public NPC getNPCselecionado() {
        return npcSelecionado;
    }
    
    public static String selecionarImagem(Frame componentePai) {
        DialogoNavegadoraDeRecursos navegadora = new DialogoNavegadoraDeRecursos(componentePai, true, BACKGROUND);
        navegadora.setVisible(true);
        return navegadora.getImagemSelecionada();
    }
    
    public static Item selecionarItem(Frame componentePai) {
        DialogoNavegadoraDeRecursos navegadora = new DialogoNavegadoraDeRecursos(componentePai, true, ITEM);
        navegadora.setVisible(true);
        return navegadora.getItemSelecionado();
    }
    
    public static NPC selecionarNPC(Frame componentePai) {
        DialogoNavegadoraDeRecursos navegadora = new DialogoNavegadoraDeRecursos(componentePai, true, NPC);
        navegadora.setVisible(true);
        return navegadora.getNPCselecionado();
    }
    
    @SuppressWarnings("unchecked")
    private void carregarItens() {
        ObjectInputStream ooi = null;
        try {
            FileInputStream fin = new FileInputStream(new File(CAMINHO_DOS_ITENS + "allItems.dat"));
            ooi = new ObjectInputStream(fin);
            itens = (List<Item>) ooi.readObject();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado! Iniciando novos registros!", 
                    "O Manicômio de Zulu", JOptionPane.INFORMATION_MESSAGE);
            itens = new ArrayList<>();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu algum problema ao ler o arquivo!\n"
                    + "Ele pode estar corrompido ou não permite leitura...", 
                    "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
            itens = new ArrayList<>();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu algum erro interno no programa!", 
                    "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (ooi != null) {
                try {
                    ooi.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ocorreu algum problema com sua unidade de armazenamento!", 
                    "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    
    private void salvarItens() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fout = new FileOutputStream(new File(CAMINHO_DOS_ITENS + "allItems.dat"));
            oos = new ObjectOutputStream(fout);
            oos.writeObject(itens);
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado! Iniciando novos registros!", 
                    "O Manicômio de Zulu", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu algum problema com sua unidade de armazenamento!", 
                    "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Ocorreu algum problema com sua unidade de armazenamento!", 
                            "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarOuAlterarEfeito;
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAdicionarIcone;
    private javax.swing.JButton botaoArquivoBackground;
    private javax.swing.JButton botaoArquivoIcone;
    private javax.swing.JButton botaoCachorro;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoChilofompila;
    private javax.swing.JButton botaoFarmaceuta;
    private javax.swing.JButton botaoMedico;
    private javax.swing.JButton botaoOk;
    private javax.swing.JButton botaoRegistrarItem;
    private javax.swing.JButton botaoSelecionarIcone;
    private javax.swing.JButton botaoVelho;
    private javax.swing.JTextField campoDescricaoEfeito;
    private javax.swing.JTextField campoDescricaoItem;
    private javax.swing.JTextField campoImagemBackgorund;
    private javax.swing.JTextField campoImagemIcone;
    private javax.swing.JTextField campoNomeEfeito;
    private javax.swing.JTextField campoNomeItem;
    private javax.swing.JTextField campoQuantidadeEfeito;
    private javax.swing.JCheckBox checkColetavel;
    private javax.swing.JCheckBox checkConsumivel;
    private javax.swing.JComboBox<String> comboTipoDeEfeito;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelColetavel;
    private javax.swing.JLabel labelConsumivel;
    private javax.swing.JLabel labelDescricaoItem;
    private javax.swing.JLabel labelEfeitosItem;
    private javax.swing.JLabel labelIconeItem;
    private javax.swing.JLabel labelNPCselecionado;
    private javax.swing.JLabel labelNomeItem;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JPanel painelBackgorunds;
    private javax.swing.JTabbedPane painelDeAbas;
    private javax.swing.JPanel painelExibirItens;
    private javax.swing.JPanel painelIcones;
    private javax.swing.JPanel painelInserirItem;
    private javax.swing.JPanel painelItens;
    private javax.swing.JPanel painelItensRegistrados;
    private javax.swing.JPanel painelNPCs;
    private javax.swing.JPanel painelOpcoesDeIcones;
    private javax.swing.JPanel painelPlanosDeFundo;
    private javax.swing.JFileChooser seletorDeArquivo;
    private javax.swing.JTable tabelaEfeitos;
    // End of variables declaration//GEN-END:variables
}
