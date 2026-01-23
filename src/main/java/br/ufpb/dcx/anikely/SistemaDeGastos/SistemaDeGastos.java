package br.ufpb.dcx.anikely.SistemaDeGastos;

import java.util.List;

public class SistemaDeGastos {
    private List<GastosNoPix> gastosPix;
    private List< GastosEmDinheiro > gastoEmDinheiro;
    private List < FaturaCartao > faturas;
    private List<Categoria> categorias;
    
    public void adicionarGastosPix (double valor, String data, Categoria categoria ){
        GastosNoPix g = new GastosNoPix(valor,data,categoria);
        gastosPix.add(g);
    }
    public void adicicionarGastoDinheiro (Double valor, String data){
        GastosEmDinheiro gD = new GastosEmDinheiro(valor,data);
        gastoEmDinheiro.add(gD);
    }
    public void adicionsrFatura (double valor,String parcela, String data){
        FaturaCartao f = new FaturaCartao(valor,parcela, data);
        faturas.add(f);
    }
    public double calcularTotalPix (){
        double tPix = 0.0;
        for (GastosNoPix p :this.gastosPix ){
            tPix += p.getValor();
        }
        return tPix;
    }
    public double calularTotalDinheiro (){
        double tDinheiro = 0.0;
        for (GastosEmDinheiro d : this.gastoEmDinheiro){
            tDinheiro += d.getValor();
        }
        return tDinheiro;
    }
    public double calcularTotalCartao (){
        double tCartao = 0.0;
        for (FaturaCartao c : this.faturas){
            tCartao += c.getValor();
        }
        return tCartao;
    }
    public double calcularValorTotal () {
        return  calcularTotalPix() + calcularTotalCartao() + calularTotalDinheiro();
    }
}
