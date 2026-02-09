package br.ufpb.dcx.anikely.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public  class SistemaAmigo implements InSistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo (){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        for (Amigo a : amigos){
            if (a.getEmail().equals(emailAmigo)) {
                throw new AmigoJaExisteException("Amigo já cadastrado!");
            }
        }
        amigos.add( new Amigo(nomeAmigo, emailAmigo));
    }
    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : mensagens){
            if (m.ehAnonima()){
                anonimas.add(m);
            }
        }
        return anonimas;
    }
    public List<Mensagem> pesquisaTodasAsMensagens(){
        return mensagens;
    }
    public Amigo pesquisaAmigo (String emailAmigo) throws AmigoInexistenteException {
        for (Amigo a : amigos){
            if (a.getEmail().equals(emailAmigo)){
                return a;
            }
        }
        throw new AmigoInexistenteException("Amigo inexistente!");
    }
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoNaoSorteadoException, AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo.getEmailAmigoSorteado() == null){
            throw new AmigoNaoSorteadoException("Amigo secreto ainda não foi encontrado!");
        }
        return amigo.getEmailAmigoSorteado();
    }
    @Override
    public void configuraAmigoSecretoDe (String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo (emailDaPessoa);
        pesquisaAmigo(emailAmigoSorteado);
        amigo.setEmailAmigoSorteado(emailAmigoSorteado);
    }
    public String pesquisaAmigoSecreto (String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Amigo amigo = pesquisaAmigo(emailDaPessoa);
        if (amigo == null){
            throw new AmigoInexistenteException("Amigo com o email: "+ emailDaPessoa + " não encontrado!");
        }
        if (amigo.getEmailAmigoSorteado() == null){
            throw  new AmigoNaoSorteadoException("Desculpe, o amigo secreto ainda não foi sorteado");
        }
        return amigo.getEmailAmigoSorteado();
    }
    @Override
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem m = new MensagemParaTodos (texto,emailRemetente,ehAnonima);
        mensagens.add(m);
    }
    public void enviarMensagemParaAlguem(String texto, String emailRemente, String emailDestinatario, boolean ehAnonima){
        Mensagem ms = new MensagemParaAlguem(texto, emailRemente, emailDestinatario, ehAnonima);
        mensagens.add(ms);
    }
}
