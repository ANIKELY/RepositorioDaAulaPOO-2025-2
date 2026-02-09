package br.ufpb.dcx.anikely.amigosecreto;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaAmigoMapTest {

    SistemaAmigo sistema;

    @BeforeEach
    void setUp()  {
        this.sistema = new SistemaAmigoMap();
    }

    @Test
    void testSistemaAmigo() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigo("jose@teste.com"));
    }

    @Test
    void testPesquisaECadastraAmigo() {
        try {
            sistema.pesquisaAmigo("jose@teste.com");
            fail("Deveria falhar pois não existe ainda");
        } catch (AmigoInexistenteException e) {
            //Ok
        }
        try {
            sistema.cadastraAmigo("José", "jose@teste.com");
            sistema.cadastraAmigo("Maria", "maria@teste.com");
            Amigo a = sistema.pesquisaAmigo("jose@teste.com");
            assertEquals("José", a.getNome());
            assertEquals("jose@teste.com", a.getEmail());
        } catch (AmigoJaExisteException | AmigoInexistenteException  e) {
            fail("Não deveria lançar exceção");
        }
    }

    @Test
    void testEnviarMensagemParaTodos() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaTodos("texto", "jose@dcx.ufpb.br", false);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
        assertEquals(1, mensagensAchadas.size());
        assertEquals("jose@dcx.ufpb.br", mensagensAchadas.getFirst().getEmailRemetente());
    }

    @Test
    void testEnviarMensagemParaAlguem() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto", "jose@dcx.ufpb.br", "maria@dcx.ufpb.br", true);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
        assertEquals(1, mensagensAchadas.size());
        assertInstanceOf(MensagemParaAlguem.class, mensagensAchadas.getFirst());
        assertEquals("texto", mensagensAchadas.getFirst().getTexto());
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 1", "jose@dcx.ufpb.br", "maria@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 2", "jose@dcx.ufpb.br", "maria@dcx.ufpb.br", true);
        assertEquals(1, sistema.pesquisaMensagensAnonimas().size());
    }

    @Test
    void testPesquisaTodasAsMensagens() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 1", "maria@dcx.ufpb.br", "jose@dcx.ufpb.br", true);
        assertEquals(1, sistema.pesquisaTodasAsMensagens().size());
        sistema.enviarMensagemParaAlguem("texto 2", "jose@dcx.ufpb.br", "maria@dcx.ufpb.br", true);
        assertEquals(2, sistema.pesquisaTodasAsMensagens().size());
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigoSecretoDe("jose@dcx.ufpb.br"));
        try {
            sistema.cadastraAmigo("José", "jose@dcx.ufpb.br");
            sistema.cadastraAmigo("Maria", "maria@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("maria@dcx.ufpb.br", "jose@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("jose@dcx.ufpb.br", "maria@dcx.ufpb.br");
            assertEquals("maria@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("jose@dcx.ufpb.br"));
            assertEquals("jose@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("maria@dcx.ufpb.br"));
        } catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção");
        }
    }
}
