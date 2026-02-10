package br.ufpb.dcx.anikely.SistemaDeEstoqueDeSupermercado;
import javax.swing.JOptionPane;
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

                    if (sistema.listarProdutos().isEmpty()){
                        JOptionPane.showMessageDialog(null,"Não há produtos no estoque para listar");
                    }else{
                        String produto = "";
                        for (Produto p : sistema.listarProdutos()){
                          produto += "Nome do produto: "+p.getNome() + "\n" +
                                    "Código do produto: "+p.getCodigo() +"\n" +
                                    "Preço: R$ "+ String.format("%.2f", p.getPreco()) + "\n"+
                                    "Quantidade no estoque: "+p.getQuantidade() + "\n" +
                                    "______________________________________" + "\n";
                        }
                        JOptionPane.showMessageDialog(null,"LISTA DE PRODUTOS NO ESTOQUE" + "\n" + " "+produto);
                    }
                    break;

                case 3:
                    codigo = JOptionPane.showInputDialog("Digite o código do produto: ");
                    try {
                        Produto p = sistema.pesquisarProdutoPorCodigo(codigo);
                        JOptionPane.showMessageDialog(null, "Produto com o código "+codigo+ " encontrado: "+p);
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
