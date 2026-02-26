package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.*;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercado;

import javax.swing.*;
import java.awt.*;

public class SistemaGUIV3 extends JFrame {
    JLabel linha1, linha2;
    ImageIcon EstoqueImg;
    ImageIcon addBusca;
    ImageIcon addList;
    ImageIcon addAdicionar;
    ImageIcon addRemove;
    ImageIcon IconExit;
    JButton botaoBuscar, botaoListar, botaoAdicionar, botaoRemover,botaoSair;
    MeuSistemaDeEstoqueDeSupermercado sistemaDeEstoque = new MeuSistemaDeEstoqueDeSupermercado();

    public SistemaGUIV3 (){

        EstoqueImg = redimensionarIcone("./imgs/IconLogo2.png", 600, 400);
        addBusca = redimensionarIcone("./imgs/IconDeBusca.png", 500, 500);
        addList = redimensionarIcone("./imgs/IconListar.png", 500, 500);
        addAdicionar = redimensionarIcone("./imgs/IconAdd.png", 500, 500);
        addRemove = redimensionarIcone("./imgs/IconRemove.png", 500, 500);
        IconExit = redimensionarIcone("./imgs/IconExit.png",800,400);
        setSize(700,600);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.BLACK);

        linha1 = new JLabel("SEJA BEM VINDO (A)!", JLabel.CENTER);

        linha1.setForeground(Color.CYAN);
        linha1.setFont(new Font("Serif", Font.BOLD,24));
        linha2 = new JLabel(EstoqueImg, JLabel.CENTER);


        botaoBuscar = new JButton(addBusca);
        botaoBuscar.addActionListener(new SistemaSearchController(sistemaDeEstoque,this));

        botaoListar = new JButton(addList);
        botaoListar.addActionListener(new SistemaListController(sistemaDeEstoque,this));

        botaoAdicionar = new JButton(addAdicionar);
        botaoAdicionar.addActionListener(new SistemaAddController(sistemaDeEstoque,this));

        botaoRemover = new JButton(addRemove);
        botaoRemover.addActionListener(new SistemaRemoveController(sistemaDeEstoque,this));

        botaoSair = new JButton(IconExit);
        botaoSair.addActionListener(new SistemaExitController(sistemaDeEstoque,this));

        getContentPane().setLayout(new GridLayout(5,2,10,10));
        getContentPane().add(linha1);
        getContentPane().add(botaoBuscar);

        getContentPane().add(linha2);
        getContentPane().add(botaoListar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoAdicionar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);

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
        new SistemaGUIV3();
    }
}
