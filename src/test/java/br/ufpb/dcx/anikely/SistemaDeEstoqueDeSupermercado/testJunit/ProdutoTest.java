package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.testJunit;

import br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado.Produto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProdutoTest {
    @Test
    public void testarConstrutor (){
        Produto p1 = new Produto("Pippo's 75g", "1234", 3.50,4);
        assertEquals("Pippo's 75g", p1.getNome());
        assertEquals ("1234", p1.getCodigo());
        assertEquals(3.50, p1.getPreco());
        assertEquals(4, p1.getQuantidade());
    }
}
