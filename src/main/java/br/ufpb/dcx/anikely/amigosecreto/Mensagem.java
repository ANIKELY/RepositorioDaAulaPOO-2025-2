package br.ufpb.dcx.anikely.amigosecreto;

public abstract class Mensagem {
    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public Mensagem (){
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }
}
