package br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.gui;

import br.ufla.dcc.gcc178.s2017_01.trabalhoUm.DoisDoido.user.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Classe JanelaNovoJogo.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por abrir uma janela do novo jogo, colhendo o 
 * nome do usuário e guardar a pontuação ganhada até o final do jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.21.07
 */
public class JanelaNovoJogo extends javax.swing.JFrame {

    private List<EntradaRanking> ranking;
    private List<Usuario> usuarios;

    /**
     * Construtor de JanelaNovoJogo.
     */
    public JanelaNovoJogo() {
        initComponents();
        initAtributos();
        setLocationRelativeTo(null);
    }
    
    private void initAtributos() {
        carregarDadosSalvos();
    }
    
    /**
     * Função carregarDadosSalvos
     * 
     * Executada no início da execução do programa, ela é responsável por carregar
     * os objetos salvos em arquivo contendo os dados dos jogos de todos os usuários
     * registrados.
     * 
     * A anotação <code>@SupressWarnings("unchecked")</code> teve de ser utilizada aqui para
     * instruir o compilador a ignorar a checagem do cast da leitura de um <code>List<Usuario></code>
     * do arquivo, porque a função <code>readObject()</code> retorna <code>Object</code>, e o cast não
     * consegue garantir a checagem do tipo genérico.
     */
    @SuppressWarnings("unchecked")
    private void carregarDadosSalvos() {
        ObjectInputStream ooi = null;
        try {
            FileInputStream fin = new FileInputStream(new File("res/saved/gameData/userRecords.dat"));
            ooi = new ObjectInputStream(fin);
            usuarios = (List<Usuario>) ooi.readObject();
            ranking = new ArrayList<>();
            atualizarRanking();
            preencherLista();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado! Iniciando novos registros!", 
                    "O Manicômio de Zulu", JOptionPane.INFORMATION_MESSAGE);
            ranking = new ArrayList<>();
            usuarios = new ArrayList<>();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Ocorreu algum problema ao ler o arquivo!\n"
                    + "Ele pode estar corrompido ou não permite leitura...", 
                    "OH MY GOD!!", JOptionPane.ERROR_MESSAGE);
            ranking = new ArrayList<>();
            usuarios = new ArrayList<>();
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
    

    /**
     * Esse método é chamado de dentro do construtor para inicializar o formulário.
     * AVISO: NÃO modifique este código. O conteúdo deste método é sempre
     * regenerado pelo Editor de Formulários.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        botaoNovoUsuario = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaRanking = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaUsuarios = new javax.swing.JList<>();
        botaoEntrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" O Manicômio de Zulu");
        setMinimumSize(new java.awt.Dimension(328, 436));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(328, 50));

        botaoNovoUsuario.setText("Novo Usuário");
        botaoNovoUsuario.setFocusable(false);
        botaoNovoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoNovoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNovoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoNovoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setPreferredSize(new java.awt.Dimension(328, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(300, 403));

        TableModel model = new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Jogador", "Pontuação"
            }
        ){

            @Override
            public boolean isCellEditable(int row, int column) {
                //all cells false
                return false;
            }
        };
        tabelaRanking.setModel(model);
        tabelaRanking.setShowHorizontalLines(false);
        tabelaRanking.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tabelaRanking);
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        sorter.setSortsOnUpdates(true);
        tabelaRanking.setRowSorter(sorter);
        tabelaRanking.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
        tabelaRanking.getColumnModel().getColumn(0).setMinWidth(25);
        tabelaRanking.getColumnModel().getColumn(0).setMaxWidth(30);
        tabelaRanking.getColumnModel().getColumn(1).setMinWidth(100);
        tabelaRanking.getColumnModel().getColumn(1).setMaxWidth(150);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ListSelectionModel listModel = listaUsuarios.getSelectionModel();
        listModel.addListSelectionListener(new ListSelectionListener () {
            public void valueChanged(ListSelectionEvent e) {
                checarSelecaoDaLista();
            }
        });
        listaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaUsuarios);
        listaUsuarios.setModel(new DefaultListModel<String>());

        botaoEntrar.setText("Entrar");
        botaoEntrar.setEnabled(false);
        botaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(botaoEntrar, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoEntrar))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoNovoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoNovoUsuarioActionPerformed
        String novoUsuario = JOptionPane.showInputDialog(this, "Qual é o seu nome?");
        if (novoUsuario != null) {
            String novoGamerID = new DialogoNovoGamerID(this, true).getGamerId();
            boolean jaTem = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().equalsIgnoreCase(novoUsuario)) {
                    JOptionPane.showMessageDialog(this, "Esse nome já está registrado! Selecione-o na lista à direita do Ranking!!",
                            "Atenção", JOptionPane.WARNING_MESSAGE);
                    jaTem = true;
                    novoUsuario = usuario.getNome();
                    break;
                }
            }
            if (!jaTem) {
                usuarios.add(new Usuario(novoUsuario, novoGamerID));
                adicionarUsuarioNaLista(novoUsuario);
            }
            listaUsuarios.setSelectedValue(novoUsuario, true);
        }
    }//GEN-LAST:event_botaoNovoUsuarioActionPerformed

    private void procurarUsuario() {
        for (Usuario usuario : usuarios) {
            if (listaUsuarios.getSelectedValue().equalsIgnoreCase(usuario.getNome())) {
                selecionarUsuario(usuario);
            }
        }
    }
    
    private void adicionarUsuarioNaLista(String nomeUsuario) {
        DefaultListModel<String> listModel = (DefaultListModel<String>) listaUsuarios.getModel();
        listModel.addElement(nomeUsuario);
    }
    
    private void preencherLista() {
        for (Usuario usuario : usuarios) {
            adicionarUsuarioNaLista(usuario.getNome());
        }
    }
    
    private void checarSelecaoDaLista() {
        if (listaUsuarios.getSelectedIndex() == -1) {
            botaoEntrar.setEnabled(false);
        } else {
            botaoEntrar.setEnabled(true);
        }
    }
    
    private void listaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaUsuariosMouseClicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            if (listaUsuarios.getSelectedValue() != null) {
                procurarUsuario();
            }
        }
    }//GEN-LAST:event_listaUsuariosMouseClicked

    private void botaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEntrarActionPerformed
        procurarUsuario();
    }//GEN-LAST:event_botaoEntrarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        JOptionPane.showMessageDialog(null, "Seus dados serão salvos!", "O Manicômio de Zulu", JOptionPane.INFORMATION_MESSAGE);
        salvarTudo();
    }//GEN-LAST:event_formWindowClosing
    
    /**
     * Método receberInformacoesUsuario.
     * 
     * responsável por receber todo o score de determinado @link{Usuario} a ser classificado.
     * 
     * @param usuario @link{Usuario} contendo um array de inteiros, representando os scores.
     */
    private void selecionarUsuario (Usuario usuario) {
        DialogoInformacoesDoUsuario informacoesDoUsuario = new DialogoInformacoesDoUsuario(usuario, this, true);
        this.setVisible(false);
        informacoesDoUsuario.setVisible(true);
    }
    
    private void redesenharTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaRanking.getModel();
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        int i = 1;
        for (EntradaRanking entrada : ranking) {
            model.addRow(new Object[] {i++, entrada.getGamerID(), entrada.getPontuacao()});
        }
    }
    
    public void atualizarRanking() {
        ranking.clear();
        for (Usuario usuario : usuarios) {
            for (int pontuacao : usuario.getPontuacoes()) {
                ranking.add(new EntradaRanking(usuario.getGamerID(), pontuacao));
            }
        }
        Collections.sort(ranking);
        redesenharTabela();
    }
    
    public void salvarTudo() {
        ObjectOutputStream oos = null;
        try {
            FileOutputStream fout = new FileOutputStream(new File("res/saved/gameData/userRecords.dat"));
            oos = new ObjectOutputStream(fout);
            oos.writeObject(usuarios);
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
    private javax.swing.JButton botaoEntrar;
    private javax.swing.JButton botaoNovoUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listaUsuarios;
    private javax.swing.JTable tabelaRanking;
    // End of variables declaration//GEN-END:variables
}
