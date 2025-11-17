package br.ufpb.br.anikely.SistemaDeEstoqueDeSupermercado;

public class ProdutoNaoEncontradoException extends Exception {
    public ProdutoNaoEncontradoException(String message) {

        super(message);
    }
}
