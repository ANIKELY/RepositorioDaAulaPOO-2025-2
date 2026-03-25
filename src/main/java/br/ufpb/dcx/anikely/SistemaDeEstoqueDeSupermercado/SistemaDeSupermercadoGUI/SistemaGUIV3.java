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

        EstoqueImg = redimensionarIcone("./imgs/IconLogo1.png", 400, 200);
        EstoqueImg2 = redimensionarIcone("./imgs/IconLogo2.png",500,300);
        addBusca = redimensionarIcone("./imgs/IconDeBusca.png", 400, 400);
        addList = redimensionarIcone("./imgs/IconListar.png", 400, 400);
        addAdicionar = redimensionarIcone("./imgs/IconAdd.png", 400, 400);
        addRemove = redimensionarIcone("./imgs/IconRemove.png", 400, 400);
        addCalculaTotal = redimensionarIcone("./imgs/IconCalculaTotal.png",400,400);
        addAlteraPreco = redimensionarIcone("./imgs/IconAlteraPreco.png", 400,400);
        addVerificaEstoque = redimensionarIcone("./imgs/IconVerificaEstoqueBaixo.png",400,400);
        addExit = redimensionarIcone("./imgs/IconExit.png",800,400);
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

        botaoAlteraPreco = new JButton(addAlteraPreco);
        botaoAlteraPreco.addActionListener(new SistemaAlteraPrecoController(sistemaDeEstoque,this));
        botaoAlteraPreco.setBackground(Color.BLACK);

        botaoVerifica = new JButton(addVerificaEstoque);
        botaoVerifica.addActionListener(new SistemaVerifyStockController(sistemaDeEstoque,this));
        botaoVerifica.setBackground(Color.BLACK);

        botaoSair = new JButton(addExit);
        botaoSair.addActionListener(new SistemaExitController(sistemaDeEstoque,this));
        botaoSair.setBackground(Color.BLACK);

        getContentPane().setLayout(new GridLayout(8,3,10,10));
        getContentPane().add(new JLabel());
        getContentPane().add(botaoBuscar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoListar);

        getContentPane().add((linha1));
        getContentPane().add(botaoAdicionar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);

        getContentPane().add(linha2);
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