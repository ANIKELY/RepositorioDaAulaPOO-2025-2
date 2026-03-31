package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public interface SistemaDeEstoqueInterface {
    public void salvarDadosProdutos() throws IOException;
    public void recuperarDadosProdutos() throws IOException;
    public void salvarDadosFuncionarios() throws IOException;
    public void recuperarDadosFuncionarios() throws IOException;
    public void removerFuncionario(String usuario) throws FuncionarioNaoRemovidoException;
    public boolean cadastrarProduto(String nome, String codigo, double preco, int quantidade);
    public boolean cadastrarFuncionario (String nome, String usuario, String senha, Cargo cargo);
    public Funcionario autenticar (String usuario, String senha) throws LoginInvalidoException;
    public Collection<Produto> pesquisarProdutoPorCodigo(String codigo) throws ProdutoNaoEncontradoException;
    public List<Produto> listarProdutos () throws ListaVaziaException;
    public void atualizarEstoque (String codigo, int novaQuantidade) throws AtualizacaoDeEstoqueException;
    public double calcularValorTotalEstoque () throws EstoqueVazioException;
    public void removerProduto (String codigo) throws ProdutoNaoRemovidoException, IOException;
    public void alteraPreco(String codigo, double novoPreco) throws ProdutoNaoEncontradoException;
    public boolean verificaEstoqueBaixo (String codigo, int quantMinima) throws ProdutoNaoEncontradoException;
}
