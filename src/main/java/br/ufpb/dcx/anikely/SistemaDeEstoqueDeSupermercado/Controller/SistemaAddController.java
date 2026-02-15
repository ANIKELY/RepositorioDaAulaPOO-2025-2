package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaAddController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercado sistema;
    private JFrame janelaPrincipal;
    public SistemaAddController (MeuSistemaDeEstoqueDeSupermercado sistema, JFrame janela){
        this.sistema = sistema;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String nomeProduto = JOptionPane.showInputDialog(janelaPrincipal,"Nome do produto: ");
        String codigo = JOptionPane.showInputDialog(janelaPrincipal,"Código do produto: ");
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"Quantidade há cadastrar: "));
        double preco = Double.parseDouble(JOptionPane.showInputDialog(janelaPrincipal,"Valor do produto: "));
        boolean cadastrou = sistema.cadastrarProduto(nomeProduto, codigo,preco,quantidade);
        if (cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto cadastrado com sucesso! :)");
        }else{
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto não cadastrado :("+"\n"+ "Verique ou tente novamente.");
        }
    }
}
