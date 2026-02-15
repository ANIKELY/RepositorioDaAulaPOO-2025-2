package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaRemoveController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercado sistema;
    private JFrame janelaPrincipal;

    public SistemaRemoveController (MeuSistemaDeEstoqueDeSupermercado sistema, JFrame janelaPrincipal){
        this.sistema=sistema;
        this.janelaPrincipal=janelaPrincipal;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String codigo = JOptionPane.showInputDialog(janelaPrincipal,"Digite o código do produto que deseja remover: ");
        boolean remover = sistema.removerProduto(codigo);
        if (remover){
            JOptionPane.showMessageDialog(janelaPrincipal,"Produto removido com sucesso");
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal,"Erro ao remover produto");
        }
    }

}
