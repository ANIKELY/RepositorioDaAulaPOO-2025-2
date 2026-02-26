package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

public class ProdutoNaoRemovidoException extends Exception{
    public ProdutoNaoRemovidoException(String mensagem){
        super(mensagem);
    }
}
