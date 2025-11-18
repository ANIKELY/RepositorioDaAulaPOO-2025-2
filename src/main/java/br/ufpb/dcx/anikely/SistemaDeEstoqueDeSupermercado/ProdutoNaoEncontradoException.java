package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException(String message) {

        super(message);
    }
}
