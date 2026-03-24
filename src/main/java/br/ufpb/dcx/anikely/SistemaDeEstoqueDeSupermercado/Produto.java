package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.io.Serial;
import java.io.Serializable;

public class Produto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nome;
    private String codigo;
    private double preco;
    private int quantidade;

    public Produto ( String nome, String codigo, double preco, int quantidade){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome (){
        return this.nome;
    }

    public void setNome ( String nome){
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setQuantidade (int quantidade){this.quantidade = quantidade;}

    public double getPreco (){return  preco;}

    public int getQuantidade (){return quantidade;}

    @Override
    public int hashCode() {
        return codigo.hashCode();
    }
    @Override
    public boolean equals (Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
            return false;

        Produto produto = (Produto) obj;
        return codigo.equals(produto.codigo);
    }
    @Override
    public String toString (){
        return "Nome do produto: "+nome+ " Código: "+ codigo
                + " Preço: "+preco+ " Quantidade de itens: "+ quantidade;
    }
}

