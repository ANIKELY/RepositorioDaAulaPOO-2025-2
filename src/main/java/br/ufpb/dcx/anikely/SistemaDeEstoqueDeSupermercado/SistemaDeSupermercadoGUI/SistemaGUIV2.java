package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import javax.swing.*;
import java.awt.*;

public class SistemaGUIV2 extends JFrame {
    JLabel linha1,linha2;
    ImageIcon EstoqueImg1 = new ImageIcon("./imgs/IconLogo1.png");
    ImageIcon EstoqueImg2 = new ImageIcon("./imgs/IconLogo2.png");
    public SistemaGUIV2(){
        setTitle("Estoque de Supermercado");
        setSize(800,400);
        setLocation(0,0);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane() .setBackground(Color.BLACK);

        linha1 =new JLabel(EstoqueImg1,JLabel.CENTER);
        linha1 = new JLabel();
        linha2 = new JLabel(EstoqueImg2, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(6,2));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        setVisible(true);
    }
    public static void main(String[] args){
        new SistemaGUIV2();
    }
}
