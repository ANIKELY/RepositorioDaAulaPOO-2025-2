package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SistemaGUI extends JFrame {
    public SistemaGUI(){
        setTitle("Estoque de Supermercado");
        setSize(600,400);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.DARK_GRAY);
    }
    public static void main (String [] args){
        SistemaGUI janela = new SistemaGUI();
        janela.setResizable(true);
        WindowListener fechandorJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };
    }
}
