package gui;

import core.InterfaceDeNavegacaoListenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe Vendedor.
 *
 * Esta classe eh parte da aplicacao "World of Zuul - O Manicômio de Zulu".
 * "World of Zuul" é um jogo de aventura muito simples, baseado em texto.  
 *
 * Essa classe é responsavel por guardar objetos do tipo Vendedor, com todos
 * os seu atributos e funcoes a serem desenvolvidas no jogo.
 * 
 * @author  Filipe Barros Rodrigues
 * @version 2017.21.07
 */
public class ModeloDeNavegacao extends javax.swing.JPanel {

    private javax.swing.JButton botao1;
    private javax.swing.JButton botao2;
    private javax.swing.JLabel label;
    private String nome;
    private TipoDeGUI tipo;

    private List<InterfaceDeNavegacaoListenter> interfaces;
    
    /**
     * Construtor da classe.
     * 
     * @param tipo TipoDeGUI tipo que será carregado
     * @param nome String com o nome do que será carregado
     * @param descricao String com a descrição do mesmo
     * @param icone String com o item a ser carregado
     */
    public ModeloDeNavegacao (TipoDeGUI tipo, String nome, String descricao, String icone) {
        this.tipo = tipo;
        this.nome = nome;
        initCompoments();
        setupComponents(tipo, nome, descricao, icone);
        empacotarComponentes();
        interfaces = new ArrayList<>();
    }
    
    /**
     * Metodo initCompoments.
     * 
     * Inicia os botões na tela.
     */
    private void initCompoments() {
        botao1 = new javax.swing.JButton();
        botao2 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
    }
    
    /**
     * Metodo setupComponents.
     * 
     * seta os atributos do GUI. 
     * 
     * @param tipo TipoDeGUI com o tipo do componente(Gui).
     * @param nome String com o nome do componente(Gui).
     * @param descricao String com a descrição do componete(Gui).
     * @param icone String com o icone do componete(Gui).
     */
    private void setupComponents(TipoDeGUI tipo, String nome, String descricao, String icone) {
        if (tipo == TipoDeGUI.NPC) {
            botao1.setIcon(new javax.swing.ImageIcon("res/images/icons/conversar.png"));
            botao2.setIcon(new javax.swing.ImageIcon("res/images/icons/atacar.png"));
        } else {
            botao1.setIcon(new javax.swing.ImageIcon("res/images/icons/usar.png"));
            if (tipo == TipoDeGUI.ITEM_DO_AMBIENTE) {
                botao2.setIcon(new javax.swing.ImageIcon("res/images/icons/coletar.png"));
            } else if (tipo == TipoDeGUI.ITEM_DO_NPC) {
                botao2.setIcon(new javax.swing.ImageIcon("res/images/icons/solicitar.png"));
            } else {
                botao2.setIcon(new javax.swing.ImageIcon("res/images/icons/descartar.png"));
            }
        }
        UtilitariosGUI.mudarFonte (label, "SpaceMono-Regular.ttf", 12f);
        label.setIcon(new javax.swing.ImageIcon("res/images/icons/" + icone + ".png")); // NOI18N
        label.setText(nome);
        label.setToolTipText(descricao);

        botao1.setFocusable(false);
        botao2.setFocusable(false);
        botao1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoActionPerformed(e);
            }
        });
        botao2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                botaoActionPerformed(e);
            }
        });
    }
    
    /**
     * Metodo empacotarComponentes.
     * 
     * Guarda os componentes coletados durante o jogo.
     */
    private void empacotarComponentes () {
        if (tipo == TipoDeGUI.ITEM_DO_NPC) {
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            setLayout(layout);
            layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label)
            .addComponent(botao2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
        } else {
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
            setLayout(layout);
            layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(label, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botao1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botao2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            );
            layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(label)
            .addComponent(botao1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(botao2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
        }
    }
    
    /**
     * Metodo botaoActionPerformed.
     * 
     * Responsavel por pegar o evento passado ao acionar o botão no jogo.
     * 
     * @param e ActionEvent com o evento passado ao clicar algum botão.
     */
    private void botaoActionPerformed(ActionEvent e) {
        if (e.getSource() == botao1) {
            if (tipo == TipoDeGUI.NPC) {
                atualizarInterfaces(new NavegacaoEvent("conversar " + nome));
            } else {
                atualizarInterfaces(new NavegacaoEvent("usar " + nome));
            }
        } else {
            switch (tipo) {
                case ITEM_DO_AMBIENTE:
                    atualizarInterfaces(new NavegacaoEvent("coletar " + nome));
                    break;
                case ITEM_DO_INVENTARIO:
                    atualizarInterfaces(new NavegacaoEvent("descartar " + nome));
                    break;
                case ITEM_DO_NPC:
                    atualizarInterfaces(new NavegacaoEvent("pedir " + nome));
                    break;
                default:
                    atualizarInterfaces(new NavegacaoEvent("atacar " + nome));
                    break;
            }
        }
    }
    
    /**
     * Metodo addInterfaceDeNavegacaoListener.
     * 
     * Metodo responsável por adicionar a interface de navegação
     * 
     * @param listener 
     */
    public void addInterfaceDeNavegacaoListener (InterfaceDeNavegacaoListenter listener) {
        interfaces.add(listener);
    }
    
    /**
     * Metodo atualizarInterfaces.
     * 
     * Atualiza as interfaces graficas ao decorrer do jogo.
     * @param evento 
     */
    public void atualizarInterfaces (NavegacaoEvent evento) {
        for (InterfaceDeNavegacaoListenter listener : interfaces) {
            listener.solicitacaoDeNavegacaoPerformed(evento);
        }
    }
}