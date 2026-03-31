package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.*;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;

import javax.swing.*;
import java.awt.*;

public class SistemaGUIV3 extends JFrame {
    JLabel linha1, linha2;
    ImageIcon EstoqueImg;
    ImageIcon EstoqueImg2;
    ImageIcon addBusca;
    ImageIcon addList;
    ImageIcon addAdicionar;
    ImageIcon addRemove;
    ImageIcon addExit;
    ImageIcon addAlteraPreco;
    ImageIcon addVerificaEstoque;
    ImageIcon addCalculaTotal;
    JButton botaoBuscar, botaoListar, botaoAdicionar, botaoRemover,botaoCalculaValorTotalEstoque,botaoAlteraPreco,botaoVerifica,botaoSair;
    MeuSistemaDeEstoqueDeSupermercadoMap sistemaDeEstoque;

    public SistemaGUIV3 (MeuSistemaDeEstoqueDeSupermercadoMap sistema) {
        this.sistemaDeEstoque = sistema;

        EstoqueImg = redimensionarIcone("./imgs/IconLogo1.png", 500, 200);
        EstoqueImg2 = redimensionarIcone("./imgs/IconLogo2.png",700,250);
        addBusca = redimensionarIcone("./imgs/IconDeBusca.png", 700, 400);
        addList = redimensionarIcone("./imgs/IconListar.png", 700, 400);
        addAdicionar = redimensionarIcone("./imgs/IconAdd.png", 700, 400);
        addRemove = redimensionarIcone("./imgs/IconRemove.png", 700, 400);
        addCalculaTotal = redimensionarIcone("./imgs/IconCalculaTotal.png",700,400);
        addAlteraPreco = redimensionarIcone("./imgs/IconAlteraPreco.png", 700,400);
        addVerificaEstoque = redimensionarIcone("./imgs/IconVerificaEstoqueBaixo.png",700,400);
        addExit = redimensionarIcone("./imgs/IconExit.png",1000,400);
        setSize(800,600);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        setTitle("Sistema de Estoque de Supermercado");

        linha1 = new JLabel(EstoqueImg, JLabel.CENTER);
        linha2 = new JLabel(EstoqueImg2, JLabel.CENTER);

        botaoBuscar = new JButton(addBusca);
        botaoBuscar.addActionListener(new SistemaSearchController(sistemaDeEstoque,this));
        botaoBuscar.setBackground(Color.BLACK);
        botaoBuscar.setBorderPainted(false);

        botaoListar = new JButton(addList);
        botaoListar.addActionListener(new SistemaListController(sistemaDeEstoque,this));
        botaoListar.setBackground(Color.BLACK);
        botaoListar.setBorderPainted(false);

        botaoAdicionar = new JButton(addAdicionar);
        botaoAdicionar.addActionListener(new SistemaAddController(sistemaDeEstoque,this));
        botaoAdicionar.setBackground(Color.BLACK);
        botaoAdicionar.setBorderPainted(false);

        botaoRemover = new JButton(addRemove);
        botaoRemover.addActionListener(new SistemaRemoveController(sistemaDeEstoque,this));
        botaoRemover.setBackground(Color.BLACK);
        botaoRemover.setBorderPainted(false);

        botaoCalculaValorTotalEstoque = new JButton(addCalculaTotal);
        botaoCalculaValorTotalEstoque.addActionListener(new SistemaCalculaValorTotalEstoqueController(sistemaDeEstoque,this));
        botaoCalculaValorTotalEstoque.setBackground(Color.BLACK);
        botaoCalculaValorTotalEstoque.setBorderPainted(false);

        botaoAlteraPreco = new JButton(addAlteraPreco);
        botaoAlteraPreco.addActionListener(new SistemaAlteraPrecoController(sistemaDeEstoque,this));
        botaoAlteraPreco.setBackground(Color.BLACK);
        botaoAlteraPreco.setBorderPainted(false);

        botaoVerifica = new JButton(addVerificaEstoque);
        botaoVerifica.addActionListener(new SistemaVerifyStockController(sistemaDeEstoque,this));
        botaoVerifica.setBackground(Color.BLACK);
        botaoVerifica.setBorderPainted(false);

        botaoSair = new JButton(addExit);
        botaoSair.addActionListener(new SistemaExitController(sistemaDeEstoque,this));
        botaoSair.setBackground(Color.BLACK);
        botaoSair.setBorderPainted(false);

        getContentPane().setLayout(new GridLayout(8,3,10,10));
        getContentPane().add(new JLabel());
        getContentPane().add(botaoBuscar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoListar);

        getContentPane().add((linha1));
        getContentPane().add(botaoAdicionar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);

        getContentPane().add((linha2));
        getContentPane().add(botaoCalculaValorTotalEstoque);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoAlteraPreco);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoVerifica);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoSair);
        setVisible(true);
    }

    private ImageIcon redimensionarIcone(String caminho, int x, int y){
        ImageIcon icone = new ImageIcon(caminho);
        Image img = icone.getImage();
        Image imgRedimensionada = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        return new ImageIcon(imgRedimensionada);
    }
    public static void main (String[]args){
        new SistemaGUIV3(new MeuSistemaDeEstoqueDeSupermercadoMap());
    }
}