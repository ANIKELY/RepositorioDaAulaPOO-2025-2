package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface SistemaDeEstoqueInterface {
    public void salvarDadosProdutos() throws IOException;
    public void recuperarDadosProdutos() throws IOException;
    public boolean cadastrarProduto(String nome, String codigo, double preco, int quantidade);
    public Collection<Produto> pesquisarProdutoPorCodigo(String codigo) throws ProdutoNaoEncontradoException;
    public List<Produto> listarProdutos () throws ListaVaziaException;
    public void atualizarEstoque (String codigo, int novaQuantidade) throws AtualizacaoDeEstoqueException;
    public double calcularValorTotalEstoque () throws EstoqueVazioException;
    public void removerProduto (String codigo) throws ProdutoNaoRemovidoException, IOException;
}
