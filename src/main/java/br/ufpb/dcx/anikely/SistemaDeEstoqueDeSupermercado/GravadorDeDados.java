package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.io.*;
import java.util.HashMap;

public class GravadorDeDados {
    public static final String ARQUIVO_PRODUTOS = "ESTOQUE.dat";
    public HashMap<String, Produto> recuperarDadosProdutos() throws IOException{
        File arquivo = new File(ARQUIVO_PRODUTOS);
        if (!arquivo.exists()){
            return new HashMap<>();
        }
    try (ObjectInputStream in = new ObjectInputStream((new FileInputStream(ARQUIVO_PRODUTOS)))){
        HashMap<String, Produto> produtos = (HashMap<String, Produto>) in.readObject();
        return produtos;
    }catch (ClassNotFoundException e){
        throw  new IOException("Erro ao carregar arquivo de produtos"+ e.getMessage(), e);
    }
    }
    public void salvarDadosProdutos(HashMap<String, Produto> produtos) throws IOException{
        File dir = new File("estoque");
        if (!dir.exists()){
            dir.mkdir();
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_PRODUTOS))){
            out.writeObject (produtos);
        }
    }
}
