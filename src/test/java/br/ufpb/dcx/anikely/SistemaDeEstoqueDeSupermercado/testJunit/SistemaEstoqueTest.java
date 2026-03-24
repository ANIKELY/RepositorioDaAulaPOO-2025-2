package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.testJunit;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.*;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaEstoqueTest {
    @Test
    public void testaCadastroAddListarBuscarRemocao () {
        MeuSistemaDeEstoqueDeSupermercadoMap sistema = new MeuSistemaDeEstoqueDeSupermercadoMap();
        boolean cadastro1 = sistema.cadastrarProduto("Pippo's 75g", "1234", 3.50, 4);
        boolean cadastro2 = sistema.cadastrarProduto("Coca cola 250ml", "2345", 5.00,5);
        assertTrue (cadastro1);
        assertTrue (cadastro2);

        Collection<Produto> produtoAchado = null;
        try {
            produtoAchado = sistema.listarProdutos();
        } catch (ListaVaziaException e) {
            fail ("Não deveria lançar exceção, há produtos cadastrados");
        }
        assertEquals (2, produtoAchado.size());

        Produto pippos = new  Produto("Pippo's 75g", "1234", 3.50,4);
        assertTrue (produtoAchado.contains(pippos));
        Produto coca = new Produto("Coca cola 250ml", "2345", 5.00,5);
        assertTrue (produtoAchado.contains(coca));
        try {
            sistema.removerProduto("1234");
        }catch (ProdutoNaoRemovidoException e){
            fail ("Lançou exceção quando não deveria");
        }
        try {
            sistema.pesquisarProdutoPorCodigo("1234");
            fail ("Deveria lançar uma exceção ao buscar produto removido");
        }catch (ProdutoNaoEncontradoException ex){
            /*Esperado é que o produto seja removido
             *Por isso esse catch vázio
             */
        }
        try {
            Collection<Produto> produtosRestantes = sistema.listarProdutos();
            assertEquals(1, produtosRestantes.size());
            assertTrue(produtosRestantes.contains(coca));
            assertFalse(produtosRestantes.contains(pippos));
        } catch (ListaVaziaException e) {
            fail("Ainda deveria ter 1 produto");
        }

    }
}

