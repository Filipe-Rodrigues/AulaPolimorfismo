/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import core.InterfaceDeNavegacaoListenter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author filip
 */
public class ModeloDeNavegacao extends javax.swing.JPanel {

    private javax.swing.JButton botao1;
    private javax.swing.JButton botao2;
    private javax.swing.JLabel label;
    private String nome;
    private TipoDeGUI tipo;

    private List<InterfaceDeNavegacaoListenter> interfaces;

    public ModeloDeNavegacao (TipoDeGUI tipo, String nome, String descricao, String icone) {
        this.tipo = tipo;
        this.nome = nome;
        initCompoments();
        setupComponents(tipo, nome, descricao, icone);
        empacotarComponentes();
        interfaces = new ArrayList<>();
    }

    private void initCompoments() {
        botao1 = new javax.swing.JButton();
        botao2 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
    }

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
    
    public void addInterfaceDeNavegacaoListener (InterfaceDeNavegacaoListenter listener) {
        interfaces.add(listener);
    }
    
    public void atualizarInterfaces (NavegacaoEvent evento) {
        for (InterfaceDeNavegacaoListenter listener : interfaces) {
            listener.solicitacaoDeNavegacaoPerformed(evento);
        }
    }
}