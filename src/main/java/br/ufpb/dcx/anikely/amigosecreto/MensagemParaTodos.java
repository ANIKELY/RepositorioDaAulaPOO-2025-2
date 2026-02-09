package br.ufpb.dcx.anikely.amigosecreto;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
       super(texto,emailRemetente,ehAnonima);
    }
    @Override
    public String getTextoCompletoAExibir (){
        if (!ehAnonima()){
            return "Mensagem enviada para todos. "+ getTexto();
        }
        return "Mensagem de "+ getEmailRemetente() + " para todos. Texto: "+ getTexto();
    }
}
