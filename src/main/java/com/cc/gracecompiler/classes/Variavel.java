package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

public class Variavel extends Identificavel {
    public Tipo tipo;
    public Token token;
    public Boolean arranjo = false;
    public Boolean inicializada = false;

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public Tipo getTipo() {
        return tipo;
    }

    public Boolean isArranjo() {return arranjo;}

    public void analiseSemantica(Escopo escopo){

    }

}
