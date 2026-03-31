package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;
import java.io.Serial;
import java.io.Serializable;

public class Funcionario implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String usuario;
    private String senha;
    private Cargo cargo;

    public Funcionario (String nome, String usuario, String senha, Cargo cargo){

        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = cargo;
    }
    public String getNome (){
        return nome;
    }
    public String getUsuario (){
        return usuario;
    }
    public String getSenha (){
        return senha;
    }
    public Cargo getCargo (){
        return cargo;
    }
    @Override
    public String toString(){
        return "Funcionário: "+ nome +"\n Usuário: "+ usuario + "\n Cargo: "+ cargo;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
        return false;
        }
        Funcionario funcionario = (Funcionario) o;
        return usuario.equals(funcionario.usuario);
    }
    @Override
    public int hashCode(){
        return usuario.hashCode();
    }
}
