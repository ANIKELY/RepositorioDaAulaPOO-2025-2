package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.io.IOException;
import java.util.*;

public class MeuSistemaDeEstoqueDeSupermercado implements SistemaDeEstoqueInterface {
    private HashMap<String,Produto> produtos;
    private GravadorDeDados gravador;
    public MeuSistemaDeEstoqueDeSupermercado(){
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
        Collection<Produto> resultado = new ArrayList<>();
        for (Produto p : produtos.values()) {
            if (p.getCodigo().equals(codigo)) {
                resultado.add(p);
            }
        }
        if (resultado.isEmpty()){
            throw new ProdutoNaoEncontradoException("Produto com o código " +codigo + " não encontrado! :(");
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
    public double calcularValorTotalEstoque (){
        double total = 0.0;
        for (Produto p : produtos.values()) {
            total += (p.getPreco() * p.getQuantidade());
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
