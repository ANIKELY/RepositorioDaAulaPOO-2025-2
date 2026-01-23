package br.ufpb.dcx.anikely.SistemaDeGastos;

public class GastosNoPix {
    private String data;
    private double valor;
    private Categoria categoria;
    public GastosNoPix (Double valor, String data, Categoria categoria){
        this.valor = valor;
        this.data = data;
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }
    public String getData(){
        return data;
    }
    public Categoria getCategoria (){
        return categoria;
    }
}
