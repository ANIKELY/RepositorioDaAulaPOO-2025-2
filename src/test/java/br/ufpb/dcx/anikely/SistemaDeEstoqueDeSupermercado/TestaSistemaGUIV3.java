package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI.SistemaGUIV3;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestaSistemaGUIV3 {
    public static void main(String[] args) {
        JFrame janelaPrincipal = new SistemaGUIV3();
        janelaPrincipal.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janelaPrincipal.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(
                        janelaPrincipal,
                        "Deseja realmente sair do sistema?",
                        "Confirmar Saída",
                        JOptionPane.YES_NO_OPTION
                );
                if (resp == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        janelaPrincipal.setVisible(true);
    }
}
