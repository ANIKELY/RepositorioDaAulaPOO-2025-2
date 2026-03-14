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
    ImageIcon addCalculaTotal;
    ImageIcon IconExit;
    JButton botaoBuscar, botaoListar, botaoAdicionar, botaoRemover,botaoCalculaValorTotalEstoque,botaoSair;
    MeuSistemaDeEstoqueDeSupermercadoMap sistemaDeEstoque;

    public SistemaGUIV3 (MeuSistemaDeEstoqueDeSupermercadoMap sistema) {
        this.sistemaDeEstoque = sistema;

        EstoqueImg = redimensionarIcone("./imgs/IconLogo1.png", 450, 200);
        EstoqueImg2 = redimensionarIcone("./imgs/IconLogo2.png",450,300);
        addBusca = redimensionarIcone("./imgs/IconDeBusca.png", 500, 500);
        addList = redimensionarIcone("./imgs/IconListar.png", 500, 500);
        addAdicionar = redimensionarIcone("./imgs/IconAdd.png", 500, 500);
        addRemove = redimensionarIcone("./imgs/IconRemove.png", 500, 500);
        addCalculaTotal = redimensionarIcone("./imgs/IconCalculaTotal.png",500,500);
        IconExit = redimensionarIcone("./imgs/IconExit.png",800,400);
        setSize(700,600);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        setTitle("Sistema de Estoque de Supermercado");

        linha1 = new JLabel(EstoqueImg, JLabel.CENTER);
        linha2 = new JLabel(EstoqueImg2, JLabel.CENTER);


        botaoBuscar = new JButton(addBusca);
        botaoBuscar.addActionListener(new SistemaSearchController(sistemaDeEstoque,this));
        botaoBuscar.setBackground(Color.BLACK);

        botaoListar = new JButton(addList);
        botaoListar.addActionListener(new SistemaListController(sistemaDeEstoque,this));
        botaoListar.setBackground(Color.BLACK);

        botaoAdicionar = new JButton(addAdicionar);
        botaoAdicionar.addActionListener(new SistemaAddController(sistemaDeEstoque,this));
        botaoAdicionar.setBackground(Color.BLACK);

        botaoRemover = new JButton(addRemove);
        botaoRemover.addActionListener(new SistemaRemoveController(sistemaDeEstoque,this));
        botaoRemover.setBackground(Color.BLACK);

        botaoCalculaValorTotalEstoque = new JButton(addCalculaTotal);
        botaoCalculaValorTotalEstoque.addActionListener(new SistemaCalculaValorTotalEstoqueController(sistemaDeEstoque,this));
        botaoCalculaValorTotalEstoque.setBackground(Color.BLACK);

        botaoSair = new JButton(IconExit);
        botaoSair.addActionListener(new SistemaExitController(sistemaDeEstoque,this));
        botaoSair.setBackground(Color.BLACK);

        getContentPane().setLayout(new GridLayout(6,2,10,10));
        getContentPane().add(new JLabel());
        getContentPane().add(botaoBuscar);

        getContentPane().add(linha1);
        getContentPane().add(botaoListar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoAdicionar);

        getContentPane().add(linha2);
        getContentPane().add(botaoRemover);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoCalculaValorTotalEstoque);

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