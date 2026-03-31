package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MenuSistema {
    public static void main(String[] args) {
        MeuSistemaDeEstoqueDeSupermercadoMap sistema = new MeuSistemaDeEstoqueDeSupermercadoMap();
        try {
            sistema.recuperarDadosProdutos();
            System.out.println("Iniciando sistema...");
        }catch (IOException e){
            System.out.println("Erro ao iniciar sistema..." + "\n "+ e);
        }
        JFrame janelaPrincipal = new SistemaLoginGUI(sistema);
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
                        IO.println("Sistema finalizado e salvo com sucesso!");
                    }catch (IOException ex) {
                        IO.println("Erro ao salvar dados!" + "\n" + ex.getMessage());
                    }
                    System.exit(0);
                }
            }
        });
        janelaPrincipal.setVisible(true);
    }
}

