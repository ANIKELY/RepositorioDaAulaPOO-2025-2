package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MeuSistemaDeEstoqueDeSupermercadoMap implements SistemaDeEstoqueInterface {
    private HashMap<String,Produto> produtos;
    private GravadorDeDados gravador;
    public MeuSistemaDeEstoqueDeSupermercadoMap(){
        this.produtos = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }
    @Override
     public void salvarDadosProdutos() throws IOException {
        gravador.salvarDadosProdutos (produtos);
    }
    @Override
    public void recuperarDadosProdutos() throws IOException {
        HashMap<String, Produto> produtosRecuperados = gravador.recuperarDadosProdutos();
        if (produtosRecuperados != null){
            produtos = produtosRecuperados;
        }
    }
    @Override
    public boolean cadastrarProduto (String nome, String codigo, double preco, int quantidade) {
        Produto cadastro = new Produto(nome, codigo, preco, quantidade);
        if (produtos.containsKey(codigo)){
            return false;
        }else{
            produtos.put(codigo, cadastro);
            return true;
        }
    }
    @Override
    public Collection<Produto> pesquisarProdutoPorCodigo (String codigo) throws ProdutoNaoEncontradoException{
        List<Produto> resultado = produtos.values().stream().filter(produto -> produto.getCodigo().equals(codigo)).collect(Collectors.toList());
        if (resultado.isEmpty()){
            throw new ProdutoNaoEncontradoException("Produto com o código "+codigo+" não encontrado! :(");
        }
        return resultado;
    }
    @Override
    public List<Produto> listarProdutos () throws ListaVaziaException {
        if (produtos.isEmpty()){
            throw new ListaVaziaException("Não há produtos no estoque para listar!");
        }
        return new ArrayList<>(produtos.values());
    }
    @Override
    public void atualizarEstoque (String codigo, int novaQuantidade) throws AtualizacaoDeEstoqueException {
        Produto p = produtos.get(codigo);
        if (p != null){
            p.setQuantidade (novaQuantidade);
        }else{
            throw new AtualizacaoDeEstoqueException("Produto não encotrado!\n" + "Por favor tente novamente.");
        }
    }
    @Override
    public double calcularValorTotalEstoque () throws EstoqueVazioException{
        double total= produtos.values().stream().mapToDouble(p -> p.getPreco() * p.getQuantidade()).sum();
        if (total <= 0.0){
            throw new EstoqueVazioException("Não há produtos no estoque para calcular os valores! :(");
        }
        return total;
    }
    @Override
    public void removerProduto (String codigo) throws ProdutoNaoRemovidoException {
        if (produtos.containsKey(codigo)){
            produtos.remove(codigo);
        }else{
            throw new ProdutoNaoRemovidoException("Produto com o código "+ codigo + "\n" +
                    " não encontrado para remoção! :( ");
        }
    }
}
