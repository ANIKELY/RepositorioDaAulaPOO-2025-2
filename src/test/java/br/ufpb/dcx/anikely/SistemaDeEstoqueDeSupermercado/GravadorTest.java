package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class GravadorTest {
    @Test
    public void main() throws IOException {
        File arquivoProdutos = new File (GravadorDeDados.ARQUIVO_PRODUTOS);

        if (arquivoProdutos.exists()) {
            arquivoProdutos.delete();
        }

        GravadorDeDados gravador = new GravadorDeDados();
        assertFalse (arquivoProdutos.exists());
        HashMap<String, Produto> produtosMap = new HashMap<>();
        produtosMap.put("1234", new Produto("Pippo's 75g", "1234", 3.50,4));
        gravador.salvarDadosProdutos(produtosMap);
        assertTrue (arquivoProdutos.exists());
        HashMap<String, Produto> produtosRecuperados = gravador.recuperarDadosProdutos();
        Produto p1 = produtosRecuperados.get("1234");
        assertEquals ("1234", p1.getCodigo());
        assertEquals ("Pippo's 75g", p1.getNome());
        assertEquals (3.50, p1.getPreco());
        assertEquals (4, p1.getQuantidade());
        arquivoProdutos.delete();
    }
}
