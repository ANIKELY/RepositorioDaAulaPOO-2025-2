package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Produto;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.ProdutoNaoEncontradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class SistemaSearchController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercado sistema;
    private JFrame janelaPrincipal;

    public SistemaSearchController(MeuSistemaDeEstoqueDeSupermercado sistema, JFrame janelaPrincipal){
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String codigo = JOptionPane.showInputDialog(janelaPrincipal, "Código de busca do produto: ");
        if (codigo != null && !codigo.isEmpty()){
            try {
                Collection<Produto> produtos = sistema.pesquisarProdutoPorCodigo(codigo);
                if (produtos.isEmpty()){
                    JOptionPane.showMessageDialog(janelaPrincipal, "Nenhum produto encotrado! :(");
                }else {
                    StringBuilder mensagem = new StringBuilder("Produtos encontrados: \n");
                    for (Produto produto : produtos){
                        mensagem.append(produto.toString()).append("\n");
                    }
                    JOptionPane.showMessageDialog(janelaPrincipal, mensagem.toString(), "Resultado da busca", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (ProdutoNaoEncontradoException exception) {
                JOptionPane.showMessageDialog(janelaPrincipal, exception.getMessage(), "Produto não encontrado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
