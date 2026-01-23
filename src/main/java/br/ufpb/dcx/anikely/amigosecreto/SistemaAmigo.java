package br.ufpb.dcx.anikely.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;
    public SistemaAmigo (){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo cadastro = new Amigo(nomeAmigo,emailAmigo);
        for (Amigo a : amigos){
            if (a.getNome().equals(nomeAmigo) && a.getEmail().equals(emailAmigo)) {
                return;
            }
        }
        amigos.add(cadastro);
    }
    public List<Mensagem> pesquisaMensagensAnomimas(List<Mensagem> mensagens){
        List<Mensagem> listaAnonima = new ArrayList<>();
        for (Mensagem m : mensagens){
            if (m.ehAnonima()){
                listaAnonima.add(m);
            }
        }
        return listaAnonima;
    }
    public Amigo pesquisaAmigo (String emailAmigo) throws AmigoInexistenteException {
        for (Amigo a : amigos){
            if (a.getEmail().equals(emailAmigo)){
                return a;
            }
        }
        throw new AmigoInexistenteException("Amigo com o email: " + emailAmigo + " não encontrado!");
    }
    public void configuraAmigoSecretoDe (String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        Amigo amigo = pesquisaAmigo (emailDaPessoa);
        if (emailDaPessoa == null){
            throw new AmigoInexistenteException("Amigo com o email: " + emailDaPessoa + " não encotrado!");
        }
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
    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }
    public void enviarMensagemParaTodos(String texto, String mail, boolean b) {
        Mensagem m = new MensagemParaTodos(texto, mail, b);
        mensagens.add(m);
    }

    public void enviarMensagemParaAlguem(String texto, String mail, String mail1, boolean b) {
         Mensagem m = new MensagemParaAlguem(texto, mail, mail1, b);
         mensagens.add(m);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {

        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) {
                anonimas.add(m);
            }
        }
        return anonimas;
    }
}
