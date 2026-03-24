package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.ProdutoNaoEncontradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaAlteraPrecoController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercadoMap sistema;
    private JFrame janelaPrincipal;

    public SistemaAlteraPrecoController(MeuSistemaDeEstoqueDeSupermercadoMap sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }
    @Override
    public void actionPerformed (ActionEvent e){
        String codigo = JOptionPane.showInputDialog(janelaPrincipal, "Digite o codigo do produto que deseja alterar o preço: ");
        if (codigo != null && !codigo.isEmpty()) {
            try {
                double novoPreco = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Digite o novo preço do produto: "));
                sistema.alteraPreco(codigo, novoPreco);
                JOptionPane.showMessageDialog(janelaPrincipal, "Preço alterado com sucesso!");
            }catch (ProdutoNaoEncontradoException ex){
                JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage(), "Erro ao alteraPreco!", JOptionPane.ERROR_MESSAGE);
            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(janelaPrincipal, "Por favor, digite um valor válido!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
