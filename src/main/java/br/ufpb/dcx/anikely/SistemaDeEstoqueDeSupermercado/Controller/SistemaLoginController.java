package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Controller;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Funcionario;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.LoginInvalidoException;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.MeuSistemaDeEstoqueDeSupermercadoMap;
import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.SistemaDeSupermercadoGUI.SistemaGUIV3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaLoginController implements ActionListener {
    private MeuSistemaDeEstoqueDeSupermercadoMap sistema;
    private JFrame janelaPrincipal;
    private JTextField usuarioLogin;
    private JPasswordField senhaLogin;

    public SistemaLoginController(MeuSistemaDeEstoqueDeSupermercadoMap sistema,JFrame janelaPrincipal, JTextField usuarioLogin,JPasswordField senhaLogin) {
        this.sistema = sistema;
        this.janelaPrincipal = janelaPrincipal;
        this.usuarioLogin = usuarioLogin;
        this.senhaLogin = senhaLogin;
    }
    @Override
    public void actionPerformed(ActionEvent e){
         String usuario = usuarioLogin.getText();
         String senha = new String(senhaLogin.getPassword());

         if (usuario.isEmpty() || senha.isEmpty()){
             JOptionPane.showMessageDialog(janelaPrincipal, "Preencha todos os campos, por favor","ERROR", JOptionPane.ERROR_MESSAGE);
             return;
         }
         try{
             Funcionario funcionario = sistema.autenticar(usuario,senha);
             JOptionPane.showMessageDialog(janelaPrincipal, "Seja bem vindo(a) "+ funcionario.getNome() +
                     "!", "Login", JOptionPane.INFORMATION_MESSAGE);
             janelaPrincipal.dispose();
             new SistemaGUIV3(sistema);
         }catch(LoginInvalidoException ex){
             JOptionPane.showMessageDialog(janelaPrincipal, ex.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
         }
    }
}
