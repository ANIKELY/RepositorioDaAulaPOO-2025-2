package br.ufpb.dcx.anikely.heloworld;

import java.io.IO;

public class AnikelyTest {
    void main (){
        IO.println("Olá");
        String nome = IO.readln("Diga seu nome: ");
        IO.println("Olá "+ nome);
    }
}