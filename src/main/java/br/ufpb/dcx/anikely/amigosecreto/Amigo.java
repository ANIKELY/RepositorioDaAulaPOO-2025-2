package br.ufpb.dcx.anikely.amigosecreto;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;
    private String emailAmigoSecreto;

    public Amigo(String nome, String email){
        this.nome=nome;
        this.email = email;
        this.emailAmigoSorteado = null;
        this.emailAmigoSecreto = emailAmigoSecreto;
    }

    public String Amigo(String nomeAmiga, String emailAmiga){
        return "Nome: "+nomeAmiga+ " Email: "+emailAmiga;
    }
    public String getNome(){
        return nome;
    }
    public void setNome (String nome){
        this.nome = nome;
    }
    public String getEmail (){
        return email;
    }
    public void setEmail (String email){
        this.email = email;
    }

    public String getEmailAmigoSorteado() {
        return emailAmigoSorteado;
    }
    public void setEmailAmigoSorteado (String emailAmigoSorteado){
        this.emailAmigoSorteado = emailAmigoSorteado;
    }

    public String getEmailAmigoSecreto() {
        return this.emailAmigoSecreto;
    }

    public void setEmailAmigoSecreto(String emailRemetente) {
        this.emailAmigoSecreto = emailAmigoSecreto;
    }
}
