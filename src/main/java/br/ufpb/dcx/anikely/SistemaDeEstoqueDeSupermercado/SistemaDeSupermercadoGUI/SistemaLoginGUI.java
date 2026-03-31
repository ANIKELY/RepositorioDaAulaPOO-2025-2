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

    public SistemaLoginGUI(MeuSistemaDeEstoqueDeSupermercadoMap sistema){
        this.sistema = sistema;

        setTitle("Login");
        setSize(700,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JLabel login = new JLabel(loginImg, JLabel.CENTER);

        usuarioLogin = new JTextField(15);
        senhaLogin = new JPasswordField(15);
        entrar = new JButton("Entrar");
        entrar.addActionListener(new SistemaLoginController(sistema,this, usuarioLogin, senhaLogin));
        adicionarUsuario = new JButton("Adicionar novo usuário");
        adicionarUsuario.addActionListener(new SistemaAddFuncionarioController(sistema,this));
        removerUsuario = new JButton("Remover usuário");
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

        JPanel panelCentral = new JPanel(new  GridLayout(2,1,10,10));
        panelCentral.setBackground(Color.BLACK);
        panelCentral.add(panelUsuario);
        panelCentral.add(panelSenha);

        add(login,BorderLayout.NORTH);
        add(panelCentral,BorderLayout.CENTER);
        add(botoes,BorderLayout.SOUTH);

        setVisible(true);
    }
}
