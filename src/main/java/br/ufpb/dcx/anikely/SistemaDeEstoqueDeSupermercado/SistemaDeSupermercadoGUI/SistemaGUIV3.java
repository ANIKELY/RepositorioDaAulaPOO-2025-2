package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaAddController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaListController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaRemoveController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaSearchController;
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
    JButton botaoBuscar, botaoListar, botaoAdicionar, botaoRemover;
    MeuSistemaDeEstoqueDeSupermercado sistemaDeEstoque = new MeuSistemaDeEstoqueDeSupermercado();

    public SistemaGUIV3 (){

        EstoqueImg = redimensionarIcone("./imgs/Logo.png", 800, 200);
        addBusca = redimensionarIcone("./imgs/IconDeBusca.png", 1000, 1000);
        addList = redimensionarIcone("./imgs/IconListar.png", 1000, 1000);
        addAdicionar = redimensionarIcone("./imgs/IconAdd.png", 1000, 1000);
        addRemove = redimensionarIcone("./imgs/IconRemove.png", 1000, 1000);
        setSize(800,600);
        setLocation(150,150);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.BLACK);

        linha1 = new JLabel();
        linha1.setForeground(Color.CYAN);
        linha1.setFont(new Font("Serif", Font.BOLD,24));
        linha2 = new JLabel(EstoqueImg, JLabel.CENTER);

        botaoBuscar = new JButton("Buscar", addBusca);
        botaoBuscar.addActionListener(new SistemaSearchController(sistemaDeEstoque,this));

        botaoListar = new JButton("Listar Produtos",addList);
        botaoListar.addActionListener(new SistemaListController(sistemaDeEstoque,this));

        botaoAdicionar = new JButton("Adicionar produtos", addAdicionar);
        botaoAdicionar.addActionListener(new SistemaAddController(sistemaDeEstoque,this));

        botaoRemover = new JButton("Remover produto",addRemove);
        botaoRemover.addActionListener(new SistemaRemoveController(sistemaDeEstoque,this));

        getContentPane().setLayout(new GridLayout(4,2));
        getContentPane().add(linha1);
        getContentPane().add(botaoBuscar);

        getContentPane().add(linha2);
        getContentPane().add(botaoListar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoAdicionar);

        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);
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
