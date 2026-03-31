package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Cargo;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.LoginInvalidoException;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SistemaAddFuncionarioController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercadoMap sistema;
    private JFrame janelaPricipal;

    public SistemaAddFuncionarioController(MeuSistemaDeEstoqueDeSupermercadoMap sistema, JFrame janelaPricipal) {
        this.sistema = sistema;
        this.janelaPricipal = janelaPricipal;
    }
    public void actionPerformed(ActionEvent e) {
        String senhaAdmin = JOptionPane.showInputDialog(janelaPricipal, "Digite a senha do administrador: ");
        if (senhaAdmin != null && !senhaAdmin.isEmpty()) {
            try {
                sistema.autenticar("admin", senhaAdmin);
                String nome = JOptionPane.showInputDialog(janelaPricipal, "Digite o nome do funcionário que deseja cadastrar: ");
                if (nome != null && !nome.isEmpty()) {
                    String usuario = JOptionPane.showInputDialog(janelaPricipal, "Digite um nome de usuário: ");
                    if (usuario != null && !usuario.isEmpty()) {
                        String senha = JOptionPane.showInputDialog(janelaPricipal, "Digite uma senha: ");
                        if (senha != null && !senha.isEmpty()) {
                            String[] cargos = {"ADMIN", "FUNCIONARIO"};
                            String escolha = (String) JOptionPane.showInputDialog(janelaPricipal, "Escolha um cargo: ", "Cargo", JOptionPane.QUESTION_MESSAGE, null, cargos, cargos[0]);
                            if (escolha != null) {
                                boolean cadastrado = sistema.cadastrarFuncionario(nome, usuario, senha, Cargo.valueOf(escolha));
                                if (cadastrado) {
                                    sistema.salvarDadosFuncionarios();
                                    JOptionPane.showMessageDialog(janelaPricipal, "Cadastro de funcionário realizado com sucesso!");
                                } else {
                                    JOptionPane.showMessageDialog(janelaPricipal, "Usuário já está cadastrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }
                }
            } catch (LoginInvalidoException ex) {
                JOptionPane.showMessageDialog(janelaPricipal, "Senha incorreta!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(janelaPricipal, "Erro ao salvar funcionário!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
