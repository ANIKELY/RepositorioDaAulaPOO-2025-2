package br.ufpb.dcx.anikely.AgendaSimplificado;

public class Contato {
    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato (String nome, int diaAniversario, int mesAniversario){
        this.nome = nome;
        this.diaAniversario = diaAniversario;
        this.mesAniversario = mesAniversario;
    }
    public int getDiaAniversario (){
        return this.diaAniversario;
    }
    public void setDiaAniversario (int diaAniversario){
        this.diaAniversario = diaAniversario;
    }
    public int getMesAniversario (){
        return mesAniversario;
    }
    public void setMesAniversario (int mesAniversario){
        this.mesAniversario = mesAniversario;
    }
    public String toString (){
        return "Nome do contato: "+ this.nome +"\n Data do aniversário: "+ this.diaAniversario + "/"+ this.mesAniversario;
    }
}
