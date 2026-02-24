package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.util.Collection;
import java.util.List;

public interface SistemaDeEstoqueInterface {
    public boolean cadastrarProduto(String nome, String codigo, double preco, int quantidade);
    public Collection<Produto> pesquisarProdutoPorCodigo(String codigo) throws ProdutoNaoEncontradoException;
    public List<Produto> listarProdutos () throws ListaVaziaException;
    public void atualizarEstoque (String codigo, int novaQuantidade) throws ProdutoNaoEncontradoException;
    public double calcularValorTotalEstoque ();
    public boolean removerProduto (String codigo);
}
