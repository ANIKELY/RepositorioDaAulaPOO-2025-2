package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import javax.swing.*;
import java.awt.*;

public class SistemaGUIV2 extends JFrame {
    JLabel linha1,linha2;
    ImageIcon EstoqueImg1 = new ImageIcon(new ImageIcon ("./imgs/IconLogo1.png").getImage().getScaledInstance(400,400, Image.SCALE_SMOOTH));
    ImageIcon EstoqueImg2 = new ImageIcon(new ImageIcon ("./imgs/IconLogo2.png").getImage().getScaledInstance(600,600, Image.SCALE_SMOOTH));
    public SistemaGUIV2(){
        setTitle("Estoque de Supermercado");
        setSize(600,400);
        setLocation(150,150);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane() .setBackground(Color.BLACK);

        linha1 =new JLabel(EstoqueImg1,JLabel.CENTER);
        linha2 = new JLabel(EstoqueImg2, JLabel.CENTER);

        getContentPane().setLayout(new GridLayout(2,1));
        getContentPane().add(linha1);
        getContentPane().add(linha2);
        setVisible(true);
    }
    public static void main(String[] args){
        new SistemaGUIV2();
    }
}
