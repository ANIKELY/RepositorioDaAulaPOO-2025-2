package br.ufpb.dcx.anikely.amigosecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Amigo> amigos;

    public SistemaAmigo (Mensagem mensagem, Amigo amigo){
        List<Mensagem> mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }
    public void cadastrarAmigo(String nomeAmigo, String emailAmigo) {
        Amigo cadastro = new Amigo();
        for (Amigo a : amigos){
            if (a.getNome().equals(nomeAmigo) && a.getEmail().equals(emailAmigo)) {
                return;
            }
        }
        amigos.add(cadastro);
    }
}
