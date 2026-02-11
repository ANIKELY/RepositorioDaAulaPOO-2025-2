package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import javax.swing.*;
import java.awt.*;

public class SistemaGUIV2 extends JFrame {
    JLabel linha1,linha2;
    ImageIcon EstoqueImg = new ImageIcon("./imgs/EtoqueImg.jpg");
    public SistemaGUIV2(){
        setTitle("Estoque de Supermercado");
        setSize(400,400);
        setLocation(0,9);
        setResizable(true);
        getContentPane() .setBackground(Color.blue);
        linha1 = new JLabel("Meu Sistema Estoque de Supermercado", JLabel.CENTER);
        linha1.setForeground(Color.CYAN);
        linha1.setFont(new Font("Serif",Font.BOLD,46 ));
        linha2 = new JLabel(EstoqueImg, JLabel.CENTER);
        getContentPane().setLayout(new GridLayout());
        getContentPane().add(linha1);
        getContentPane().add(linha2);
    }
    static void main(String[] args){
        JFrame janela = new SistemaGUIV2();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
