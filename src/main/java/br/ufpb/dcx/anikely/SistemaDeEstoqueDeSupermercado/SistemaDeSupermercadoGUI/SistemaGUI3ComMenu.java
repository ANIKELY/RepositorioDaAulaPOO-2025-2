package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.*;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;

import javax.swing.*;
import java.awt.*;

public class SistemaGUI3ComMenu extends JFrame {
    JLabel linha1, linha2, linha3;
    ImageIcon estoqueImg = new ImageIcon("./imgs/IconLogo1.png");
    ImageIcon estoqueImg2 = new ImageIcon("./imgs/IconLogo2.png");
    MeuSistemaDeEstoqueDeSupermercadoMap sistemaDeEstoqueDeSupermercado = new MeuSistemaDeEstoqueDeSupermercadoMap();
    JMenuBar barra = new JMenuBar();

    public SistemaGUI3ComMenu(){
        setTitle("Sistema de Estoque de Supermercado");
        setSize (600,400);
        setLocation (150,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable (false);
        getContentPane().setBackground(Color.BLACK);

        linha1 = new JLabel(estoqueImg, JLabel.CENTER);
        linha2 = new JLabel(estoqueImg2, JLabel.CENTER);
        setLayout (new GridLayout(4,2));

        add(linha1);
        add(linha2);
        add(linha3);
        add(new JLabel());
        JMenu menuBuscar = new JMenu("Buscar");
        JMenuItem menuBuscarProduto = new JMenuItem("Buscar produtos");
        menuBuscar.add(menuBuscarProduto);
        menuBuscarProduto.addActionListener(new SistemaSearchController(sistemaDeEstoqueDeSupermercado,this));

        JMenu menuListar = new JMenu("Listar");
        JMenuItem menuListarProduto = new JMenuItem("Listar produtos");
        menuListar.add(menuListarProduto);
        menuListarProduto.addActionListener(new SistemaListController(sistemaDeEstoqueDeSupermercado,this));

        JMenu menuAdicionar = new JMenu("Adicionar");
        JMenuItem menuAdicionarProdutos = new JMenuItem ("Adicionar produtos");
        menuAdicionar.add(menuAdicionarProdutos);
        menuAdicionarProdutos.addActionListener(new SistemaAddController(sistemaDeEstoqueDeSupermercado,this));

        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverProdutos = new JMenuItem("Remover produtos");
        menuRemover.add(menuRemoverProdutos);
        menuRemoverProdutos.addActionListener(new SistemaRemoveController(sistemaDeEstoqueDeSupermercado,this));

        JMenu menuSair = new JMenu("Sair");
        JMenuItem menuSairSistema = new JMenuItem("Sair Sistema");
        menuSair.add(menuSairSistema);
        menuSairSistema.addActionListener(new SistemaExitController(sistemaDeEstoqueDeSupermercado, this));

        JMenu menuValorTotalEstoque = new JMenu ("Valor Total no Estoque");
        JMenuItem menuValorTotalEstoqueProduto = new JMenuItem ("Valor Total de produtos no Estoque");
        menuValorTotalEstoque.add(menuValorTotalEstoqueProduto);
        menuValorTotalEstoqueProduto.addActionListener(new SistemaAddController(sistemaDeEstoqueDeSupermercado,this));

        barra.add(menuBuscar);
        barra.add(menuListar);
        barra.add(menuAdicionar);
        barra.add(menuRemover);
        barra.add(menuValorTotalEstoque);
        barra.add(menuSair);

        setJMenuBar(barra);
        setVisible(true);
    }
    public static void main (String [] args){
        new SistemaGUI3ComMenu();
    }
}
