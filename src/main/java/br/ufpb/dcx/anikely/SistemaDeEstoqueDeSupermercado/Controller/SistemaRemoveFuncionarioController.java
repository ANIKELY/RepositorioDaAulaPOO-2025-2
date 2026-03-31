package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.FuncionarioNaoRemovidoException;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.LoginInvalidoException;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SistemaRemoveFuncionarioController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercadoMap sistema;
    private JFrame janelaPrincipal;
    public SistemaRemoveFuncionarioController (MeuSistemaDeEstoqueDeSupermercadoMap sistema, JFrame janelaPrincipal) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
    }
    public void actionPerformed(ActionEvent e) {
        String senhaAdmin = JOptionPane.showInputDialog(janelaPrincipal, "Digite a senha do administrador: ");
        if (senhaAdmin != null && !senhaAdmin.isEmpty()) {
            try {
                sistema.autenticar("admin", senhaAdmin);
                String usuario = JOptionPane.showInputDialog(janelaPrincipal, "Digite o usuário do funcionário: ");
                if (usuario != null && !usuario.isEmpty()) {
                    sistema.removerFuncionario(usuario);
                    sistema.salvarDadosFuncionarios();
                    JOptionPane.showMessageDialog(janelaPrincipal, "Funcionário removido com sucesso!");
                }
            } catch (LoginInvalidoException ex) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Senha incorreta!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (FuncionarioNaoRemovidoException ex) {
                JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(janelaPrincipal, "Erro ao salvar!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
