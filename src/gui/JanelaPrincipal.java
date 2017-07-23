package gui;

import core.EstadoDeJogo;
import core.InterfaceDeJogoListener;
import core.InterfaceDeNavegacaoListenter;
import core.ManicomioDeZulu;
import entities.Item;
import entities.NPC;
import io.FormatoDeComandoException;
import io.JogoEvent;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 * Classe JanelaPrincipal - Controla a janela Principal do jogo.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * A implementação dessa classe tem como objetivo implementar o codigo para exibição
 * da janela do jogo, sendo uma facilitação e tornando o jogo mais empolgante.
 * 
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.07.01
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    private ManicomioDeZulu jogo;
    private BufferedImage notFound;
    private Mapa mapa;
    private JanelaNovoJogo pontuacoes;
    private int pontuacaoAtual;

    /**
     * Construtor Da Classe JanelaPrincipal.
     */
    public JanelaPrincipal() {
        initComponents();
        initAtributos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        painelImagem = new javax.swing.JPanel();
        labelImagem = new javax.swing.JLabel();
        grupoPainelAmbiente = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botaoNorte = new javax.swing.JButton();
        botaoSul = new javax.swing.JButton();
        botaoOeste = new javax.swing.JButton();
        botaoLeste = new javax.swing.JButton();
        painelObjetosDoAmbiente = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        painelNPCs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        painelItensDoAmbiente = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        grupoPainelItensNPCs = new javax.swing.JPanel();
        painelObjetosDoCesar = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        painelItensNPC = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        painelItensCesar = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        labelPontuacao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jButton1.setText("Executar comando");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextArea1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTextArea1);
        //create the font
        UtilitariosGUI.mudarFonte (jTextArea1, "SpaceMono-Regular.ttf", 14f);

        jTextField1.setToolTipText("");
        UtilitariosGUI.mudarFonte(jTextField1, "SpaceMono-Regular.ttf", 14f);
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        painelImagem.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        painelImagem.setMaximumSize(new java.awt.Dimension(804, 404));
        painelImagem.setMinimumSize(new java.awt.Dimension(804, 404));
        painelImagem.setPreferredSize(new java.awt.Dimension(804, 404));
        painelImagem.setLayout(new java.awt.BorderLayout());

        labelImagem.setText("dasdasd");
        painelImagem.add(labelImagem, java.awt.BorderLayout.CENTER);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setMaximumSize(new java.awt.Dimension(235, 150));
        jPanel1.setMinimumSize(new java.awt.Dimension(235, 120));
        jPanel1.setLayout(new javax.swing.OverlayLayout(jPanel1));

        jPanel2.setMaximumSize(new java.awt.Dimension(200, 100));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 100));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 100));

        botaoNorte.setText("Norte");
        botaoNorte.setFocusable(false);
        botaoNorte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNorteActionPerformed(evt);
            }
        });

        botaoSul.setText("Sul");
        botaoSul.setFocusable(false);
        botaoSul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSulActionPerformed(evt);
            }
        });

        botaoOeste.setText("Oeste");
        botaoOeste.setFocusable(false);
        botaoOeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOesteActionPerformed(evt);
            }
        });

        botaoLeste.setText("Leste");
        botaoLeste.setFocusable(false);
        botaoLeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLesteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoOeste, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(botaoLeste, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(botaoNorte, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(botaoSul, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNorte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoOeste)
                    .addComponent(botaoLeste))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoSul)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);

        painelObjetosDoAmbiente.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        painelNPCs.setLayout(new javax.swing.BoxLayout(painelNPCs, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane3.setViewportView(painelNPCs);

        painelObjetosDoAmbiente.add(jScrollPane3);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        painelItensDoAmbiente.setLayout(new javax.swing.BoxLayout(painelItensDoAmbiente, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane2.setViewportView(painelItensDoAmbiente);

        painelObjetosDoAmbiente.add(jScrollPane2);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        jLabel1.setText("NPCs:");
        jPanel3.add(jLabel1);
        UtilitariosGUI.mudarFonte(jLabel1, "SpaceMono-Regular.ttf", 12f);

        jLabel2.setText("Itens no Ambiente:");
        jPanel3.add(jLabel2);
        UtilitariosGUI.mudarFonte(jLabel2, "SpaceMono-Regular.ttf", 12f);

        javax.swing.GroupLayout grupoPainelAmbienteLayout = new javax.swing.GroupLayout(grupoPainelAmbiente);
        grupoPainelAmbiente.setLayout(grupoPainelAmbienteLayout);
        grupoPainelAmbienteLayout.setHorizontalGroup(
            grupoPainelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(grupoPainelAmbienteLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(grupoPainelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelObjetosDoAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        grupoPainelAmbienteLayout.setVerticalGroup(
            grupoPainelAmbienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
            .addGroup(grupoPainelAmbienteLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelObjetosDoAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelObjetosDoCesar.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jScrollPane5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        painelItensNPC.setLayout(new javax.swing.BoxLayout(painelItensNPC, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane5.setViewportView(painelItensNPC);

        painelObjetosDoCesar.add(jScrollPane5);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        painelItensCesar.setLayout(new javax.swing.BoxLayout(painelItensCesar, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane4.setViewportView(painelItensCesar);

        painelObjetosDoCesar.add(jScrollPane4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jLabel3.setText("Inventário do NPC ativo:");
        jPanel5.add(jLabel3);
        UtilitariosGUI.mudarFonte(jLabel3, "SpaceMono-Regular.ttf", 12f);

        jLabel4.setText("Meu inventário:");
        jPanel5.add(jLabel4);
        UtilitariosGUI.mudarFonte(jLabel4
            , "SpaceMono-Regular.ttf", 12f);

        javax.swing.GroupLayout grupoPainelItensNPCsLayout = new javax.swing.GroupLayout(grupoPainelItensNPCs);
        grupoPainelItensNPCs.setLayout(grupoPainelItensNPCsLayout);
        grupoPainelItensNPCsLayout.setHorizontalGroup(
            grupoPainelItensNPCsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelObjetosDoCesar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        grupoPainelItensNPCsLayout.setVerticalGroup(
            grupoPainelItensNPCsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, grupoPainelItensNPCsLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelObjetosDoCesar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelPontuacao.setText("Pontuação: 100");
        UtilitariosGUI.mudarFonte(labelPontuacao, "SpaceMono-Regular.ttf", 12f);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelPontuacao)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPontuacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1180, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(grupoPainelAmbiente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(painelImagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grupoPainelItensNPCs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(painelImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grupoPainelAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(grupoPainelItensNPCs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**Metodo initAtributos.
     * 
     * inicializa a janela.
     */
    private void initAtributos() {
        pontuacaoAtual = 100;
        inicializarMapa();
        loadImagemNotFound();
        initEngine();
        setLocationRelativeTo(null);
    }

    /**Metodo initEngine.
     *  
     */
    private void initEngine() {
        jogo = new ManicomioDeZulu();
        jogo.adicionarInterfaceDeJogoListener(new InterfaceDeJogoListener() {
            @Override
            public void envioDeComandoPerformed(JogoEvent evt) {
                envioDeComandoDoManicomio(evt);
            }
        });
    }
    
    /**Metodo loadImagemNotFound.
     * 
     * carrega a imagem not found para um ambiente que não tenha imagem.
     * 
     */
    private void loadImagemNotFound() {
        try {
            notFound = ImageIO.read(new File("res/images/bg/404.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**Metodo inicializarMapa.
     * 
     * inicializa o mapa para o auxilio do jogador.
     */
    private void inicializarMapa() {
        mapa = new Mapa(this, true);
    }

    /**Metodo jButton1ActionPerformed.
     * 
     * @param evt java.awt.event.ActionEvent.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        iniciarEnvioDoCampoDeComando();
        //testeCriarItem();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void testeCriarItem() {
        ModeloDeNavegacao modelo = new ModeloDeNavegacao(TipoDeGUI.ITEM_DO_AMBIENTE, "Teste", "Bora ver se dá certo saporra", "Carteira");
        //jScrollPane4.getViewport().add(modelo);
        painelItensCesar.add(modelo);
        revalidate();
        repaint();
   }
    
    /**Metodo jTextField1KeyReleased.
     * 
     * @param evt java.awt.event.KeyEvent.
     */
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarEnvioDoCampoDeComando();
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    /** Metodo formFocusGained
     *
     * @param evt java.awt.event.FocusEvent.
     */
    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        jTextField1.requestFocus();
    }//GEN-LAST:event_formFocusGained
    
    /**Metodo jTextArea1KeyPressed.
     * 
     * @param evt java.awt.event.KeyEvent.
     */
    private void jTextArea1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea1KeyPressed
        jTextField1.requestFocus();
    }//GEN-LAST:event_jTextArea1KeyPressed

    /**Metodo botaoNorteActionPerformed.
     * 
     * metodo que cria o botão para ir para o norte.
     * 
     * @param evt java.awt.event.ActionEvent.
     */
    private void botaoNorteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNorteActionPerformed
        jogo.receberComando("ir norte");
    }//GEN-LAST:event_botaoNorteActionPerformed
    
    /**Metodo botaoLesteActionPerformed.
     * 
     * metodo que cria o botão para ir para o leste.
     * 
     * @param evt java.awt.event.ActionEvent
     */
    private void botaoLesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoLesteActionPerformed
        jogo.receberComando("ir leste");
    }//GEN-LAST:event_botaoLesteActionPerformed
    
    /**Metodo botaoOesteActionPerformed.
     * 
     * metodo que cria o botão para ir para o oeste.
     * 
     * @param evt java.awt.event.ActionEvent 
     */
    private void botaoOesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOesteActionPerformed
        jogo.receberComando("ir oeste");
    }//GEN-LAST:event_botaoOesteActionPerformed

    /**Metodo botaoSulActionPerformed.
     * 
     * metodo que cria o botão para ir para o sul.
     * 
     * @param evt java.awt.event.ActionEvent
     */
    private void botaoSulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSulActionPerformed
        jogo.receberComando("ir sul");
    }//GEN-LAST:event_botaoSulActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        pontuacoes.receberFinalizacaoDeJogo(pontuacaoAtual);
    }//GEN-LAST:event_formWindowClosed

    /**Metodo envioDeComandoDoManicomio.
     * 
     * envia um evento como um comando.
     * 
     * @param evt JogoEvent que é responsavel por passar o comando a ser executado.
     */
    private void envioDeComandoDoManicomio(JogoEvent evt) {
        atualizarCampoDeTexto(evt);
        atualizarImagem(evt.getImagem() + ".png");
        atualizarBotoesDeNavegacao(evt);
        atualizarNavegacaoItens(evt);
        mostrarMapa(evt.querMapa());
        atualizarPontuacao(evt.getPontos());
        verificarSeTerminou(evt.taFinalizado());
    }
    
    private void atualizarPontuacao(int pontos) {
        pontuacaoAtual += pontos;
        if (pontuacaoAtual < 0) {
            pontuacaoAtual = 0;
        }
        labelPontuacao.setText("Pontuação: " + pontuacaoAtual);
    }
    
    private void atualizarNavegacaoItens(JogoEvent evt) {
        List<Item> inventarioCesar = evt.getInventarioCesar();
        List<Item> inventarioNPC = evt.getInventarioNPC();
        List<Item> itensAmbiente = evt.getObjetosAmbiente();
        List<NPC> npcs = evt.getNPCsAmbiente();
        painelItensCesar.removeAll();
        if (inventarioCesar != null) {
            for (Item item : inventarioCesar) {
                ModeloDeNavegacao modelo = new ModeloDeNavegacao(TipoDeGUI.ITEM_DO_INVENTARIO, item.getNome(), 
                        item.getDescricao(), item.getNome());
                modelo.addInterfaceDeNavegacaoListener(new InterfaceDeNavegacaoListenter() {
                    @Override
                    public void solicitacaoDeNavegacaoPerformed(NavegacaoEvent evt) {
                        receberComandosNavegacaoItensENPCS(evt);
                    }
                });
                painelItensCesar.add(modelo);
            }
        }
        painelItensNPC.removeAll();
        if (inventarioNPC != null) {
            for (Item item : inventarioNPC) {
                ModeloDeNavegacao modelo = new ModeloDeNavegacao(TipoDeGUI.ITEM_DO_NPC, item.getNome(),
                        item.getDescricao(), item.getNome());
                modelo.addInterfaceDeNavegacaoListener(new InterfaceDeNavegacaoListenter() {
                    @Override
                    public void solicitacaoDeNavegacaoPerformed(NavegacaoEvent evt) {
                        receberComandosNavegacaoItensENPCS(evt);
                    }
                });
                painelItensNPC.add(modelo);
            }
        }
        painelItensDoAmbiente.removeAll();
        if (itensAmbiente != null) {
            for (Item item : itensAmbiente) {
                ModeloDeNavegacao modelo = new ModeloDeNavegacao(TipoDeGUI.ITEM_DO_AMBIENTE, item.getNome(), 
                        item.getDescricao(), item.getNome());
                modelo.addInterfaceDeNavegacaoListener(new InterfaceDeNavegacaoListenter() {
                    @Override
                    public void solicitacaoDeNavegacaoPerformed(NavegacaoEvent evt) {
                        receberComandosNavegacaoItensENPCS(evt);
                    }
                });
                painelItensDoAmbiente.add(modelo);
            }
        }
        painelNPCs.removeAll();
        if (npcs != null && evt.getEstadoAtual() != EstadoDeJogo.ATACANDO) {
            for (NPC npc : npcs) {
                ModeloDeNavegacao modelo = new ModeloDeNavegacao(TipoDeGUI.NPC, npc.getNome(), 
                        npc.getNome(), npc.getImagem());
                modelo.addInterfaceDeNavegacaoListener(new InterfaceDeNavegacaoListenter() {
                    @Override
                    public void solicitacaoDeNavegacaoPerformed(NavegacaoEvent evt) {
                        receberComandosNavegacaoItensENPCS(evt);
                    }
                });
                painelNPCs.add(modelo);
            }
        }
        revalidate();
        repaint();
    }
    
    /**Metodo atualizarCampoDeTexto.
     * 
     * Atualiza o campo de texto que é exibido na execução.
     * 
     * @param evt JogoEvent, que atualiza o campo de texto.
     */
    private void atualizarCampoDeTexto(JogoEvent evt) {
        if (evt.deveLimparTela()) {
            jTextArea1.setText("");
        }
        jTextArea1.append(evt.getSaida() + "\n");
    }
    
    /**Metodo atualizarBotoesDeNavegacao.
     * 
     * atualiza os botoes de navegação que são usados no jogo.
     * 
     * @param saidas List<String> com as saidas para que seja atualizado os 
     * botões da navegação..
     */
    private void atualizarBotoesDeNavegacao(JogoEvent evt) {
        botaoLeste.setEnabled(false);
        botaoOeste.setEnabled(false);
        botaoNorte.setEnabled(false);
        botaoSul.setEnabled(false);
        if (!evt.taFinalizado()) {
            List<String> saidas = evt.getSaidasDisponiveis();
            for (String direcao : saidas) {
                if (direcao.equals("leste")) {
                    botaoLeste.setEnabled(true);
                } else if (direcao.equals("oeste")) {
                    botaoOeste.setEnabled(true);
                } else if (direcao.equals("norte")) {
                    botaoNorte.setEnabled(true);
                } else if (direcao.equals("sul")) {
                    botaoSul.setEnabled(true);
                }
            }
        } else {
            jTextField1.setEnabled(false);
            jButton1.setEnabled(false);
        }
    }
    
    /**Metodo mostrarMapa.
     * 
     * Metodo responsavel por exibir o mapa para o usuario do jogo.
     * 
     * @param querMapa boolean que verifica se o usuario quer ver o mapa.
     */
    private void mostrarMapa(boolean querMapa) {
        if (querMapa) {
            mapa.setVisible(true);
        }
    }
    
    /**Metodo verificarSeTerminou.
     * 
     * responsavel por verificar se o jogo chegou em seu fim.
     * 
     * @param taFinalizado boolean que serve de parametro para a verificação.
     */
    private void verificarSeTerminou(boolean taFinalizado) {
        if (taFinalizado) {
            jTextField1.setEnabled(false);
            jButton1.setEnabled(false);
            painelItensCesar.removeAll();
            painelItensDoAmbiente.removeAll();
            painelItensNPC.removeAll();
            painelNPCs.removeAll();
        }
    }

    /**Metodo enviarComando.
     * 
     * envia um comando a ser executado no jogo.
     * 
     */
    private void iniciarEnvioDoCampoDeComando() {
        if (!jTextField1.getText().trim().equals("")) {
            String linha = jTextField1.getText();
            enviarComando(linha);
            jTextField1.setText("");
        }
        jTextField1.requestFocus();
    }
    
    private void enviarComando (String linha) {
        try {
            jogo.receberComando(linha);
        } catch (FormatoDeComandoException e) {
            jTextArea1.append(e.getMessage());
        }
    }
    
    private void receberComandosNavegacaoItensENPCS (NavegacaoEvent evt) {
        enviarComando(evt.getLinhaDeComando());
    }

    /**Metodo atualizarImagem.
     * 
     * metodo que atualiza a imagem dos ambientes.
     * 
     * @param nomeDaImagem String com o nome da nova imagem.
     */
    private void atualizarImagem(String nomeDaImagem) {
        if (!nomeDaImagem.equals(".png")) {
            try {
                BufferedImage img = ImageIO.read(new File("res/images/bg/" + nomeDaImagem));
                labelImagem.setIcon(new ImageIcon(img));
            } catch (IOException ex) {
                labelImagem.setIcon(new ImageIcon(notFound));
            }
        }
    }
    
    void registrarRequisidora(JanelaNovoJogo pontuacoes) {
        this.pontuacoes = pontuacoes;
    }

    /**Metodo Main.
     * 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoLeste;
    private javax.swing.JButton botaoNorte;
    private javax.swing.JButton botaoOeste;
    private javax.swing.JButton botaoSul;
    private javax.swing.JPanel grupoPainelAmbiente;
    private javax.swing.JPanel grupoPainelItensNPCs;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelImagem;
    private javax.swing.JLabel labelPontuacao;
    private javax.swing.JPanel painelImagem;
    private javax.swing.JPanel painelItensCesar;
    private javax.swing.JPanel painelItensDoAmbiente;
    private javax.swing.JPanel painelItensNPC;
    private javax.swing.JPanel painelNPCs;
    private javax.swing.JPanel painelObjetosDoAmbiente;
    private javax.swing.JPanel painelObjetosDoCesar;
    // End of variables declaration//GEN-END:variables

}
