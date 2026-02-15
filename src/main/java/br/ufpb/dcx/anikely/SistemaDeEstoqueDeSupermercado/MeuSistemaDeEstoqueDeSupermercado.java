package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MeuSistemaDeEstoqueDeSupermercado {
    private final List<Produto> produtos;
    public MeuSistemaDeEstoqueDeSupermercado(){
        this.produtos = new ArrayList<>();
    }
    public boolean cadastrarProduto (String nome, String codigo, double preco, int quantidade){
        Produto cadastro = new Produto(nome, codigo, preco, quantidade);
        if (!produtos.contains(cadastro)){
            produtos.add(cadastro);
            return true;
        }
        return false;
    }
    public Collection<Produto> pesquisarProdutoPorCodigo (String codigo) throws ProdutoNaoEncontradoException{
        Collection<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                resultado.add(produto);
            }
        }
        if (resultado.isEmpty()){
            throw new ProdutoNaoEncontradoException("Produto com o código " +codigo + " não encontrado");
        }
        return resultado;
    }
    public List<Produto> listarProdutos () throws ListaVaziaException {
        if (produtos.isEmpty()){
            throw new ListaVaziaException("Não há produtos no estoque para listar!");
        }
        return produtos;
    }
    public void atualizarEstoque (String codigo, int novaQuantidade) throws ProdutoNaoEncontradoException {
        for (Produto a : produtos){
            if (a.getCodigo().equals(codigo)){
                a.setQuantidade(novaQuantidade);
                return; /* return pra sair do for assim que mudar
                        a quantidade de estoque e não ir até o fim da lista */
            }
        }
        throw new ProdutoNaoEncontradoException("Produto não encotrado!\n" + "Por favor tente novamente.");
    }
    public double calcularValorTotalEstoque (){
        double total = 0.0;
        for (Produto p : produtos) {
            total += (p.getPreco() * p.getQuantidade());
        }
        return total;
    }
    public boolean removerProduto (String codigo) {
        for (Produto a : produtos) {
            if (a.getCodigo().equals(codigo)) {
                produtos.remove(a);
                return true;
            }
        }
        return false;
    }
}
