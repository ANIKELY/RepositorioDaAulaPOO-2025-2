package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaExitController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercado sistemaDeEstoqueDeSupermercado;
    private JFrame janelaPrincipal;
    public SistemaExitController(MeuSistemaDeEstoqueDeSupermercado sistemaDeEstoqueDeSupermercado,JFrame janelaPrincipal){
        this.sistemaDeEstoqueDeSupermercado = sistemaDeEstoqueDeSupermercado;
        this.janelaPrincipal = janelaPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int resposta = JOptionPane.showConfirmDialog(janelaPrincipal,
                "Deseja sair?",
                "Comfirme sua saída",
                JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

        if (resposta == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
}
