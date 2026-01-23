package br.ufpb.dcx.anikely.SistemaDeGastos;

import javax.swing.*;

public class MenuSistemaDeGastos {
    static void main () throws Exception {
        SistemaDeGastos sistema = new SistemaDeGastos();
        SistemaDeGastosArquivo arquivo = new SistemaDeGastosArquivo();

        boolean sair = false;
        while (!sair){
            int opcao = Integer.parseInt(JOptionPane.showInputDialog("""
                    1 - Adicionar gastos
                    2- Calcular total de gastos no mês
                    3- Carregar dados
                    0 - Sair
                    """));

            switch (opcao){
                case 1:
                    String tipoPagamento = JOptionPane.showInputDialog("Tipo de pagamento: ");
                    if (tipoPagamento.equalsIgnoreCase("PIX")){
                        double valorPix = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do pix: "));
                        String dataPix = JOptionPane.showInputDialog("Data do valor gasto: ");
                        String  nomeCategoria = JOptionPane.showInputDialog("Categoria: ");
                        Categoria categoria = new Categoria(nomeCategoria);
                        sistema.adicionarGastosPix(valorPix, dataPix,categoria);
                    } else if (tipoPagamento.equalsIgnoreCase("DINHEIRO")){
                        Double valorDinheiro = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor gasto em dinheiro: "));
                        String dataDinheiro = JOptionPane.showInputDialog("Data do valor gasto: ");
                        sistema.adicicionarGastoDinheiro(valorDinheiro,dataDinheiro);
                    }else if (tipoPagamento.equalsIgnoreCase("CARTÃO")){
                        double valorFatura = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor da fatura: "));
                        String parcela = JOptionPane.showInputDialog("Digite qual a parcela: ");
                        String data = JOptionPane.showInputDialog("Digite a data da fatura: ");
                        sistema.adicionsrFatura(valorFatura, parcela,data);
                    }else{
                        JOptionPane.showMessageDialog(null, "ERROR! \n" +
                                "Tipo de pagamento não encontrado!");
                    }
                    break;
                case 2:
                     if (sistema.calcularValorTotal() > 1400){
                         JOptionPane.showMessageDialog(null, "Você ultrapassou o seu limite de gastos!");
                     }else{
                         JOptionPane.showMessageDialog(null, "Você gastou um total de: R$ "+sistema.calcularValorTotal());
                     }
                case 3:
                    sistema = arquivo.carregarDados();
                case 0:
                    sair = true;
                    arquivo.salvarDados(sistema);
            }
        }
    }
}
