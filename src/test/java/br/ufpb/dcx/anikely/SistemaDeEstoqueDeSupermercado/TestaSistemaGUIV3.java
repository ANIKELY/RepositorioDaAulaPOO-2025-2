package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI.SistemaGUI3ComMenu;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestaSistemaGUIV3 {
    public static void main (String [] args){
        JFrame janela = new SistemaGUI3ComMenu();
        janela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(janela, "Deseja sair? ");
                if (resp == JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });
        janela.setVisible(true);
    }
}
