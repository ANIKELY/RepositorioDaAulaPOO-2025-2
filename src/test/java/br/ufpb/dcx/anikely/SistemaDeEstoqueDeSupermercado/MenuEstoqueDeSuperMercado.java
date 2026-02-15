package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;
import javax.swing.JOptionPane;
import java.util.Collection;
import java.util.List;

public class MenuEstoqueDeSuperMercado {
    public static void main (String [] args){
        MeuSistemaDeEstoqueDeSupermercado sistema = new MeuSistemaDeEstoqueDeSupermercado();

        boolean sair = false;
        while (!sair){
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    MENU
                    Digite uma opção:
                    
                    1- Cadastrar Produto:
                    
                    2- Listar Produtos:
                    
                    3- Pesquisar por código:
                    
                    4- Atualizar estoque:
                    
                    5- Remover produto do estoque:
                    
                    6- Exibir valor total do estoque
                    
                    0- Sair"""));

            String codigo;
            switch (opcao){
                case 1 :
                    String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
                    codigo = JOptionPane.showInputDialog("Digite o código do produto: ");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço do produto: "));
                    int quantidade = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de " + nome + " para adicionar no estoque: "));
                    sistema.cadastrarProduto(nome,codigo,preco,quantidade);
                    break;

                case 2 :
                    try {
                        List<Produto> produtoList = sistema.listarProdutos();
                        StringBuilder msg = new StringBuilder("LISTA DE PRODUTOS NO ESTOQUE\n\n");
                        for (Produto p : produtoList) {
                            msg.append("Nome do produto: ").append(p.getNome()).append("\n")
                                    .append("Código do produto: ").append(p.getCodigo()).append("\n")
                                    .append("Preço: R$ ").append(String.format("%.2f", p.getPreco())).append("\n")
                                    .append("Quantidade no estoque: ").append(p.getQuantidade()).append("\n")
                                    .append("______________________________________\n\n");
                        }
                        JOptionPane.showMessageDialog(null, msg.toString());

                    } catch (ListaVaziaException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case 3:
                    codigo = JOptionPane.showInputDialog("Digite o código do produto: ");
                    try {
                        Collection<Produto> p = sistema.pesquisarProdutoPorCodigo(codigo);

                        if (!p.isEmpty()){
                            StringBuilder msg = new StringBuilder("Produto(s) encontrado(s) no estoque:");
                            for (Produto produto : p ){
                                msg.append(produto.toString()).append("\n");
                            }
                            JOptionPane.showMessageDialog(null, msg.toString());
                        }
                    }catch (ProdutoNaoEncontradoException e){
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case 4 :
                    codigo = JOptionPane.showInputDialog("Digite o código do produto: ");
                    int novaQuantidade = Integer.parseInt(JOptionPane.showInputDialog("Digite a nova quantidade do produto: "));
                    try {
                        sistema.atualizarEstoque(codigo, novaQuantidade);
                    } catch (ProdutoNaoEncontradoException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case 5 :
                    codigo = JOptionPane.showInputDialog("Digite o código do produto: ");
                    boolean remover = sistema.removerProduto(codigo);
                    if (remover){
                        JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null, "Produto não encontrado");
                    }
                    break;
                case 6 :
                    double valorTotalDoEstoque = sistema.calcularValorTotalEstoque();
                    String total = String.format("%.2f",valorTotalDoEstoque);
                    JOptionPane.showMessageDialog(null, "Valor total do estoque:R$ "+ total);
                    break;

                case 0 :
                    JOptionPane.showMessageDialog(null, "Encerrando programa...");
                    sair = true;
                    break;
            }

        }
    }
}
