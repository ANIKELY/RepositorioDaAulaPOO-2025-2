package br.ufpb.dcx.anikely.amigosecreto;

public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;
    public MensagemParaAlguem (String emailRemetente, String emailDestinatario, boolean ehAnonima){
        super(emailRemetente, emailDestinatario, ehAnonima);

    }

    public String getEmailDestinatario (){
        return this.emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if (ehAnonima()){
            return "Mensagem para " + getEmailDestinatario() + ". Texto: "+ getTexto();
        }else{
            return "Mensagem de " + getEmailRemetente() + " para "+ getEmailDestinatario() + ". Texto: "+getTexto();
        }
    }
}
