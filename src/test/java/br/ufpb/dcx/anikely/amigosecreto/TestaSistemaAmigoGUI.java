package br.ufpb.dcx.anikely.amigosecreto;
import java.util.Scanner;
public class TestaSistemaAmigoGUI {
    void main (){
        Scanner tc = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        IO.readln("Quantos amigos irão participar? ");
        int quant = Integer.parseInt(tc.nextLine());

        for (int i = 0; i < quant; i++){
            IO.println("Nome do amigo: ");
            String nome = tc.nextLine();

            IO.println("Email: ");
            String email = tc.nextLine();
            try{
                sistema.cadastraAmigo(nome,email);
            } catch (AmigoJaExisteException e){
                IO.println(e.getMessage());
            }
        }
    }
}
