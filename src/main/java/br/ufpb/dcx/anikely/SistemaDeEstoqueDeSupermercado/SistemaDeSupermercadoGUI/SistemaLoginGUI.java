package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaAddFuncionarioController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaLoginController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller.SistemaRemoveFuncionarioController;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;

import javax.swing.*;
import java.awt.*;

public class SistemaLoginGUI extends JFrame{
    JLabel linha1, linha2;
    MeuSistemaDeEstoqueDeSupermercadoMap sistema;
    JTextField usuarioLogin;
    JPasswordField senhaLogin;
    JButton entrar;
    JButton adicionarUsuario;
    JButton removerUsuario;
    ImageIcon loginImg = new ImageIcon(new ImageIcon("./imgs/IconUser.png").getImage().getScaledInstance(400,200, Image.SCALE_SMOOTH));
    ImageIcon enterImg = new ImageIcon(new ImageIcon("./imgs/IconEnter.png").getImage().getScaledInstance(250,200,Image.SCALE_SMOOTH));
    ImageIcon addFuncionario = new ImageIcon(new ImageIcon("./imgs/IconFuncionario.png").getImage().getScaledInstance(250,200,Image.SCALE_SMOOTH));
    ImageIcon removeFuncionario = new ImageIcon(new ImageIcon("./imgs/IconRemoveUsuario.png").getImage().getScaledInstance(250,200,Image.SCALE_SMOOTH));
    public SistemaLoginGUI(MeuSistemaDeEstoqueDeSupermercadoMap sistema){
        this.sistema = sistema;

        setTitle("Login");
        setSize(900,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel login = new JLabel(loginImg, JLabel.CENTER);

        usuarioLogin = new JTextField(15);
        senhaLogin = new JPasswordField(15);
        entrar = new JButton(enterImg);
        entrar.addActionListener(new SistemaLoginController(sistema,this, usuarioLogin, senhaLogin));
        entrar.setBackground(Color.BLACK);
        entrar.setBorderPainted(false);
        adicionarUsuario = new JButton(addFuncionario);
        adicionarUsuario.setBackground(Color.BLACK);
        adicionarUsuario.setBorderPainted(false);
        adicionarUsuario.addActionListener(new SistemaAddFuncionarioController(sistema,this));
        removerUsuario = new JButton(removeFuncionario);
        removerUsuario.setBackground(Color.BLACK);
        removerUsuario.setBorderPainted(false);
        removerUsuario.addActionListener(new SistemaRemoveFuncionarioController(sistema,this));

        getContentPane().setBackground(Color.BLACK);

        linha1 = new JLabel("Usuário: ");
        linha1.setForeground(Color.WHITE);
        linha2 = new JLabel("Senha: ");
        linha2.setForeground(Color.WHITE);

        JPanel panelUsuario = new JPanel();
        panelUsuario.setBackground(Color.BLACK);
        panelUsuario.add(linha1);
        panelUsuario.add(usuarioLogin);

        JPanel panelSenha = new JPanel();
        panelSenha.setBackground(Color.BLACK);
        panelSenha.add(linha2);
        panelSenha.add(senhaLogin);

        JPanel botoes = new JPanel();
        botoes.setBackground(Color.BLACK);
        botoes.add(entrar);
        botoes.add(adicionarUsuario);
        botoes.add(removerUsuario);

        JPanel panelCentral = new JPanel(new  GridLayout(4,1));
        panelCentral.setBackground(Color.BLACK);
        panelCentral.add(panelUsuario);
        panelCentral.add(panelSenha);

        add(login,BorderLayout.NORTH);
        add(panelCentral,BorderLayout.CENTER);
        add(botoes,BorderLayout.SOUTH);

        setVisible(true);
    }
}
