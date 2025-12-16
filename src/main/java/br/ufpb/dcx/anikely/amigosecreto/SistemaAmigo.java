package br.ufpb.dcx.anikely.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> amigos;
    private List<Mensagem> mensagens;

    public SistemaAmigo (){
        List<Mensagem> mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    public void cadastraAmigo(String nomeAmigo, String emailAmigo) {
        Amigo cadastro = new Amigo();
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
        return null;
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

    public void enviarMensagemParaTodos(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {

    }
}
