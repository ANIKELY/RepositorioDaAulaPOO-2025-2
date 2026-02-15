package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaAddController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaListController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaRemoveController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaSearchController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;

import javax.swing.*;
import java.awt.*;

public class SistemaGUI3ComMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon estoqueImg = new ImageIcon("./imgs/Logo.png");
    MeuSistemaDeEstoqueDeSupermercado sistemaDeEstoqueDeSupermercado = new MeuSistemaDeEstoqueDeSupermercado();
    JMenuBar barra = new JMenuBar();

    public SistemaGUI3ComMenu(){
        setTitle("Sistema de Estoque de Supermercado");
        setSize (400,400);
        setLocation (150,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable (false);
        getContentPane().setBackground(Color.BLACK);

        linha1 = new JLabel("Sistema de Estoque de Supermercado", JLabel.CENTER);
        linha1.setForeground(Color.CYAN);
        linha1.setFont(new Font("Serif",Font.BOLD,24));
        linha2 = new JLabel(estoqueImg, JLabel.CENTER);
        setLayout (new GridLayout(3,1));

        add(linha1);
        add(linha2);
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

        barra.add(menuBuscar);
        barra.add(menuListar);
        barra.add(menuAdicionar);
        barra.add(menuRemover);

        setJMenuBar(barra);
        setVisible(true);
    }
    public static void main (String [] args){
        new SistemaGUI3ComMenu();
    }
}
