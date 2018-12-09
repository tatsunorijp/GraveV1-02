package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

public class Variavel extends Identificavel {
    public Tipo tipo;
    public Token token;

    @Override
    public Token getToken() {
        return token;
    }

    @Override
    public Tipo getTipo() {
        return tipo;
    }


}
