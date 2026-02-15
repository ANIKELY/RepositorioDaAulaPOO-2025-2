package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestaJanelaSimples {
    public static void main (String[] args){
        JFrame janela = new JFrame ();
        janela.setTitle("Janela Simples");
        janela.setLocation(0,0);
        janela.setSize(400,400);
        JButton botao = new JButton ("Meu botão");
        botao.setToolTipText("Dica: Meu botão de teste");
        botao.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(janela, "Testando botão");
            }
        });
        janela.setLayout(new GridLayout(4,1));
        janela.add(new JLabel ("Teste"));
        janela.add(botao);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
