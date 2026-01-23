package br.ufpb.dcx.anikely.SistemaDeGastos;

public class GastosEmDinheiro {
    private double valor;
    private String data;

    public GastosEmDinheiro (double valor, String data){
        this.valor = valor;
        this.data = data;
    }

    public double getValor() {
        return valor;
    }
    public String getData (){
        return data;
    }
    public String toString (){
        return "Valor gasto em dinheiro: "+ this.valor + "\n " +
                "Data: "+ this.data;
    }
}
