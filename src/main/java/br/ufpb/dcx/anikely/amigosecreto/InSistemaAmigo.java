package br.ufpb.dcx.anikely.amigosecreto;

import java.util.List;

public interface InSistemaAmigo {
    void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException;
    Amigo pesquisaAmigo (String emailAmigo) throws AmigoInexistenteException;
    void enviarMensagemParaTodos (String texto, String emailRemetente, boolean ehAnonima);
    void enviarMensagemParaAlguem (String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima);
    List<Mensagem> pesquisaMensagensAnonimas();
    List<Mensagem> pesquisaTodasAsMensagens();
    void configuraAmigoSecretoDe (String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException;
    String pesquisaAmigoSecretoDe (String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException;
}
