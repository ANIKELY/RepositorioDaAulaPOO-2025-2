package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.ProdutoNaoRemovidoException;

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
        try{
            sistema.removerProduto(codigo);
            JOptionPane.showMessageDialog(janelaPrincipal,"Produto removido com sucesso!");
        }catch(ProdutoNaoRemovidoException ex){
            JOptionPane.showMessageDialog(janelaPrincipal, "Erro, produto não encontrado para remoção!");
        }
    }
}
