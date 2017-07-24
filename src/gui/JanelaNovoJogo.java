package gui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

    JanelaPrincipal interfaceDoGame;
    String nomeAtual;
    
    /**
     * Construtor de JanelaNovoJogo.
     */
    public JanelaNovoJogo() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        painelPontuacao = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" O Manicômio de Zulu");
        setMinimumSize(new java.awt.Dimension(328, 436));
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(5, 5));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(328, 50));
        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.columnWidths = new int[] {150, 150};
        jPanel1Layout.rowHeights = new int[] {50};
        jPanel1Layout.columnWeights = new double[] {0.25, 0.75};
        jPanel1Layout.rowWeights = new double[] {1.0};
        jPanel1.setLayout(jPanel1Layout);

        jLabel1.setText("Pontuações:");
        jPanel1.add(jLabel1, new java.awt.GridBagConstraints());

        jButton1.setText("Novo Jogo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new java.awt.GridBagConstraints());

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setPreferredSize(new java.awt.Dimension(328, 25));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jPanel3.setLayout(new java.awt.CardLayout(30, 0));

        painelPontuacao.setLayout(new javax.swing.BoxLayout(painelPontuacao, javax.swing.BoxLayout.Y_AXIS));
        jPanel3.add(painelPontuacao, "card2");

        jScrollPane1.setViewportView(jPanel3);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nomeAtual = JOptionPane.showInputDialog("Insira seu nome:");
        interfaceDoGame = new JanelaPrincipal();
        this.setVisible(false);
        interfaceDoGame.registrarRequisidora(this);
        interfaceDoGame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    
    /**
     * Método receberFinalizacaoDeJogo.
     * 
     * responsável por receber se o joogo deve ser finalizado.
     * 
     * @param pontuacao Integer com a pontuação a ser guardada no final do jogo.
     */
    public void receberFinalizacaoDeJogo (int pontuacao) {
        this.setVisible(true);
        JLabel label = new JLabel(nomeAtual + ": " + pontuacao);
        painelPontuacao.add(label);
        revalidate();
        repaint();
    }
    
    /**
     * @param args os argumentos da linha de comando
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
            java.util.logging.Logger.getLogger(JanelaNovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaNovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaNovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaNovoJogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaNovoJogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelPontuacao;
    // End of variables declaration//GEN-END:variables
}
