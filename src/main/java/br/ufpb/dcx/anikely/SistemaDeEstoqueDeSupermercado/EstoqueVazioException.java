package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

public class EstoqueVazioException extends Exception {
    public  EstoqueVazioException(String message) {
        super(message);
    }
}
