package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaEstoqueTest {
    MeuSistemaDeEstoqueDeSupermercadoMap sistema;

    @BeforeEach
    public void setUp() {
        sistema = new MeuSistemaDeEstoqueDeSupermercadoMap();
    }

    @Test
    public void testarCadastrarProduto() {
        boolean cadastro = sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        assertTrue(cadastro);
    }

    @Test
    public void testarListarProdutos() throws ListaVaziaException {
        sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        Collection<Produto> produtos = sistema.listarProdutos();
        assertEquals(1, produtos.size());
    }

    @Test
    public void testarPesquisarProdutoPorCodigo() throws ProdutoNaoEncontradoException {
        sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        Collection<Produto> resultado = sistema.pesquisarProdutoPorCodigo("1234");
        assertEquals(1, resultado.size());
    }

    @Test
    public void testarCalcularValorTotalEstoque() throws EstoqueVazioException {
        sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        double total = sistema.calcularValorTotalEstoque();
        assertEquals(14.0, total);
    }

    @Test
    public void testarAtualizarEstoque() throws AtualizacaoDeEstoqueException, ProdutoNaoEncontradoException {
        sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        sistema.atualizarEstoque("1234", 6);
        Collection<Produto> resultado = sistema.pesquisarProdutoPorCodigo("1234");
        assertEquals(10, resultado.iterator().next().getQuantidade());
    }

    @Test
    public void testarAlteraPreco() throws ProdutoNaoEncontradoException {
        sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        sistema.alteraPreco("1234", 5.00);
        Collection<Produto> resultado = sistema.pesquisarProdutoPorCodigo("1234");
        assertEquals(5.00, resultado.iterator().next().getPreco());
    }

    @Test
    public void testarVerificaEstoqueBaixo() throws ProdutoNaoEncontradoException {
        sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        boolean resultado = sistema.verificaEstoqueBaixo("1234", 10);
        assertTrue(resultado);
    }

    @Test
    public void testarAutenticar() throws LoginInvalidoException {
        Funcionario funcionario = sistema.autenticar("admin", "admin123");
        assertEquals("admin", funcionario.getUsuario());
    }

    @Test
    public void testarRemoverProduto() throws ProdutoNaoRemovidoException, ListaVaziaException {
        sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        sistema.cadastrarProduto("Coca cola 250ml", "2345", 5.00, 5);
        sistema.removerProduto("1234");
        Collection<Produto> produtos = sistema.listarProdutos();
        assertEquals(1, produtos.size());
    }
}

