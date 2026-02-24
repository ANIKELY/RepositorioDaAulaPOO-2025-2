package br.ufpb.dcx.anikely.SistemaDeGastos;

public interface SistemaDeGastosInterface {
    public void adicionarGastosPix (double valor, String data, Categoria categoria );
    public void adicicionarGastoDinheiro (Double valor, String data);
    public void adicionsrFatura (double valor,String parcela, String data);
    public double calcularTotalPix ();
    public double calularTotalDinheiro ();
    public double calcularTotalCartao ();
    public double calcularValorTotal ();
}
