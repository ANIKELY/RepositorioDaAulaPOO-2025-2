package br.ufpb.dcx.anikely.amigosecreto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap implements SistemaAmigo {
    private Map<String, Amigo> amigos;
    private List<Mensagem> mensagens;
    public SistemaAmigoMap (){
        this.amigos = new HashMap<>();
        this.mensagens = new ArrayList<>();
    }

    @Override
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws  AmigoJaExisteException{
        if (amigos.containsKey(emailAmigo)){
            throw new AmigoJaExisteException();
        }
        amigos.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo));
    }

    @Override
    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        Amigo a = amigos.get(emailAmigo);
        if (a == null){
            throw new AmigoInexistenteException();
        }
        return a;
    }
    @Override
public void enviarMensagemParaTodos (String texto, String emailRemetente, boolean ehAnonima){
        Mensagem m = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(m);
    }
    @Override
    public void enviarMensagemParaAlguem (String texto, String emailRemetente, boolean ehAnonimma){
        Mensagem m = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(m);
    }
    @Override
    public List< Mensagem> pesquisaMensagensAnonimas (){
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }
    @Override
    public List<Mensagem> pesquisaTodasAsMensagens (){
        return mensagens;
    }
    @Override
    public void configuraAmigoSecretoDe (String emailDaPessoa, String emailRemetente) throws AmigoInexistenteException{

        Amigo pessoa = pesquisaAmigo(emailDaPessoa);
        pesquisaAmigo(emailRemetente);
        pessoa.setEmailAmigoSecreto(emailRemetente);
    }
    @Override
    public String pesquisaAmigoSecretoDe (String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        Amigo a = pesquisaAmigo(emailDaPessoa);
        if (a.getEmailAmigoSecreto() == null) {
            throw new AmigoNaoSorteadoException();
        }
        return a.getEmailAmigoSecreto();

    }
}
