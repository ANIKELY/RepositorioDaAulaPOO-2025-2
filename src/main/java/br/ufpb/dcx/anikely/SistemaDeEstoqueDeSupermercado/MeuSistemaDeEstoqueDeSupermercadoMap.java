package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class MeuSistemaDeEstoqueDeSupermercadoMap implements SistemaDeEstoqueInterface {
    private HashMap<String,Produto> produtos;
    private HashMap<String, Funcionario> funcionarios;
    private GravadorDeDados gravador;
    public MeuSistemaDeEstoqueDeSupermercadoMap(){
        this.produtos = new HashMap<>();
        this.funcionarios = new HashMap<>();
        this.gravador = new GravadorDeDados();
        try{
            recuperarDadosFuncionarios();
        }catch(IOException e){
            funcionarios = new HashMap<>();
        }
        if (funcionarios.isEmpty()){
            funcionarios.put("admin", new Funcionario("Administrador", "admin","admin123",Cargo.ADMIN));
        }
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
    public void salvarDadosFuncionarios() throws IOException {
        gravador.salvarDadosFuncionarios(funcionarios);
    }
    @Override
    public void recuperarDadosFuncionarios() throws IOException {
         HashMap<String, Funcionario> funcionariosRecuperados = gravador.recuperarDadosFuncionarios();
         if (funcionariosRecuperados != null){
             funcionarios = funcionariosRecuperados;
         }
    }
    @Override
    public void removerFuncionario(String usuario) throws FuncionarioNaoRemovidoException{
        if (funcionarios.containsKey(usuario)){
            funcionarios.remove(usuario);
        }else{
            throw new FuncionarioNaoRemovidoException("Funicionário com o usuário "+usuario+ "\n não encontrado para a remoção!");
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
    public boolean cadastrarFuncionario (String nome, String usuario, String senha, Cargo cargo) {
        Funcionario cadastraFuncionario = new Funcionario(nome,usuario,senha, cargo);
        if (funcionarios.containsKey(usuario)){
            return false;
        }else{
            funcionarios.put(usuario, cadastraFuncionario);
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
            p.setQuantidade (p.getQuantidade() + novaQuantidade);
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
        /*O Math.round está sendo utilizado pra
        * retornar o total em duas casas decimais */
        return Math.round (total * 100.00) / 100.00;
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
    public void alteraPreco (String codigo, double novoPreco) throws ProdutoNaoEncontradoException{
        Produto encontrado = produtos.get(codigo);
        if (encontrado != null){
            encontrado.setPreco(novoPreco);
        }else{
            throw new ProdutoNaoEncontradoException("Produto com o código "+codigo+"\n não encontrado!");
        }
    }
    public boolean verificaEstoqueBaixo (String codigo, int quantMinima) throws ProdutoNaoEncontradoException{
        Produto p = produtos.get(codigo);
        if (p == null){
            throw new ProdutoNaoEncontradoException("Produto não encontrado no estoque! ");
        }
        return p.getQuantidade() < quantMinima;
    }
    public Funcionario autenticar (String usuario, String senha) throws LoginInvalidoException{
        Funcionario funcionario = funcionarios.get(usuario);
        if (funcionario == null || !funcionario.getSenha().equals(senha)){
            throw new LoginInvalidoException("Usuário ou senhas inválidos!");
        }
        return funcionario;
    }
}
