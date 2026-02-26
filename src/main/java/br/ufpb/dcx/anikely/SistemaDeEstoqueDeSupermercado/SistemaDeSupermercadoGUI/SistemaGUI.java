package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;
import javax.swing.JFrame;
import java.awt.*;

public class SistemaGUI extends JFrame {
    public SistemaGUI(){
        setTitle("Estoque de Supermercado");
        setSize(800,400);
        setLocation(150,150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);
        setVisible(true);
    }
    public static void main (String [] args){
        SistemaGUI janela = new SistemaGUI();
    }
}
