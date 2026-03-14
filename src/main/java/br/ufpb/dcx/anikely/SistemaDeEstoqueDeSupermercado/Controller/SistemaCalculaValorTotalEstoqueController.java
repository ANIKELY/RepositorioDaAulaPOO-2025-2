package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.EstoqueVazioException;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaCalculaValorTotalEstoqueController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercadoMap sistema;
    private JFrame frame;
    public SistemaCalculaValorTotalEstoqueController(MeuSistemaDeEstoqueDeSupermercadoMap sistema, JFrame frame){
        this.sistema = sistema;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double total = 0.0;
        try {
            total = sistema.calcularValorTotalEstoque();
            JOptionPane.showMessageDialog(frame, "Valor total do estoque: R$  " + String.format("%.2f", total));
        } catch (EstoqueVazioException ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage());
        }
    }
}
