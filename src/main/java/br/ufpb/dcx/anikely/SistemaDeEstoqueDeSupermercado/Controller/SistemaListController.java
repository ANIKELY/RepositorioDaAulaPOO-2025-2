package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SistemaListController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercado sistemaDeEstoque;
    private JFrame janelaPrincipal;

    public  SistemaListController (MeuSistemaDeEstoqueDeSupermercado sistemaDeEstoque, JFrame janela){
        this.sistemaDeEstoque = sistemaDeEstoque;
        this.janelaPrincipal = janela;
    }
    public void actionPerformed(ActionEvent e){
        try{
            List<Produto> produtos = sistemaDeEstoque.listarProdutos();
            StringBuilder msg = new StringBuilder();
            for (Produto produto : produtos){
                msg.append(produto.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(janelaPrincipal,msg.toString(), "Lista de produtos",JOptionPane.INFORMATION_MESSAGE);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(janelaPrincipal,ex.getMessage(),"Estoque vazio",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
