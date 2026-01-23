package br.ufpb.dcx.anikely.SistemaDeGastos;

import java.io.*;

public class SistemaDeGastosArquivo {

    public void salvarDados (SistemaDeGastos sistema){
        File file = new File("Gastos.csv");

        try (BufferedWriter bw = new BufferedWriter (new FileWriter(file))) {
            bw.write ("LISTA DE GASTOS \n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public SistemaDeGastos carregarDados() throws Exception{
        SistemaDeGastos sistema = new SistemaDeGastos();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Gastos.csv"));
            String linha;
            while ((linha=br.readLine())!= null){
                System.out.println (linha);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return sistema;
    }
}
