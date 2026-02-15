package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import javax.swing.*;
import java.awt.*;

public class TestaJanelaSimples2 {
    public static void main (String[] args){
        JFrame janela = new JFrame();
        janela.setTitle("Janela simples 2");
        janela.setLocation(0,0);
        janela.setSize(400,400);
        JButton botao = new JButton("Meu botao");
        botao.setToolTipText("Dica: Meu botao de teste");
        botao.addActionListener((ae) -> {
            JOptionPane.showMessageDialog(janela,"Testando botão");
        });
        janela.setLayout(new GridLayout(3,1));
        janela.add(new JLabel());
        janela.add(botao);
        janela.add(new JLabel());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
