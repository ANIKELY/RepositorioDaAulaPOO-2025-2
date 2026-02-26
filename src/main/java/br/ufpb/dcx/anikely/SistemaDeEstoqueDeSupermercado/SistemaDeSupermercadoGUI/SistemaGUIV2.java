package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import javax.swing.*;
import java.awt.*;

public class SistemaGUIV2 extends JFrame {
    JLabel linha1,linha2;
    ImageIcon EstoqueImg = new ImageIcon("./imgs/IconLogo2.png");
    public SistemaGUIV2(){
        setTitle("Estoque de Supermercado");
        setSize(800,400);
        setLocation(0,0);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane() .setBackground(Color.BLACK);

        linha1 = new JLabel("SEJA BEM VINDO(A)!", JLabel.CENTER);
        linha1.setForeground(Color.CYAN);
        linha1.setFont(new Font("Serif",Font.BOLD,24 ));
        linha2 = new JLabel(EstoqueImg, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(5,2));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        setVisible(true);
    }
    public static void main(String[] args){
        new SistemaGUIV2();
    }
}
