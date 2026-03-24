package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.ProdutoNaoEncontradoException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaVerifyStockController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercadoMap sistema;
    private JFrame janelaPrincipal;

    public SistemaVerifyStockController(MeuSistemaDeEstoqueDeSupermercadoMap sistema, JFrame janelaPrincipal){
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }
    @Override
    public void actionPerformed (ActionEvent e){
        String codigo = JOptionPane.showInputDialog(janelaPrincipal, "Digite o codigo do produto: ");
        if (codigo != null ){
           try{
               int quantMinima = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Digite a quantidade miníma que deve haver"+
                       "\n no estoque do produto com o código "+ codigo +":"));
               boolean estoqueBaixo = sistema.verificaEstoqueBaixo(codigo,quantMinima);
               if (estoqueBaixo){
                   JOptionPane.showMessageDialog(janelaPrincipal, "Estoque Baixo!", "\nAlerta", JOptionPane.WARNING_MESSAGE);
               }else{
                   JOptionPane.showMessageDialog(janelaPrincipal, "Estoque normal!", "\n OK", JOptionPane.INFORMATION_MESSAGE);
               }
           }catch (ProdutoNaoEncontradoException p){
               JOptionPane.showMessageDialog(janelaPrincipal, p.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
           }catch (NumberFormatException p){
               JOptionPane.showMessageDialog(janelaPrincipal, p.getMessage(),"Erro ao digitar, tente novamente!", JOptionPane.ERROR_MESSAGE);
           }
        }
    }

}
