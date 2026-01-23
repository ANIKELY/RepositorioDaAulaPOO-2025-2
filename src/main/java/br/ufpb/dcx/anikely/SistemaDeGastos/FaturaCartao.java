package br.ufpb.dcx.anikely.SistemaDeGastos;

public class FaturaCartao {
    private String data;
    private String parcela;
    private double valor;
    public FaturaCartao (double valor, String parcela, String data){
        this.data = data;
        this.parcela = parcela;
        this.valor = valor;
    }
    public String getData(){
        return this.data;
    }
    public String getParcela (){
        return this.parcela;
    }
    public double getValor(){
        return this.valor;
    }
    public String toString (){
        return "Data da fatura: "+ this.data + "\n Parcela: "+ this.parcela +
                "\nValor a ser pago R$: " + this.valor;
    }
}
