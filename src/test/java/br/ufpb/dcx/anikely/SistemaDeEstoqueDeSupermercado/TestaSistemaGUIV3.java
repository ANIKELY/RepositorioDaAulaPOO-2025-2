package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI.SistemaGUIV3;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class TestaSistemaGUIV3 {
    public static void main(String[] args) {
        MeuSistemaDeEstoqueDeSupermercadoMap sistema = new MeuSistemaDeEstoqueDeSupermercadoMap();
        try {
            sistema.recuperarDadosProdutos();
            IO.println("Iniciando sistema...");
        }catch (IOException e){
            JOptionPane.showMessageDialog(null,"Erro ao iniciar sistema...");
        }
        JFrame janelaPrincipal = new SistemaGUIV3(sistema);
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
                    try {
                        sistema.salvarDadosProdutos();
                        JOptionPane.showMessageDialog(null,"Sistema finalizado e salvo com sucesso!");
                    }catch (IOException ex) {
                        JOptionPane.showMessageDialog(null,"Erro ao salvar dados!" + "\n" + ex.getMessage());
                    }
                    System.exit(0);
                }
            }
        });
        janelaPrincipal.setVisible(true);
    }
}

