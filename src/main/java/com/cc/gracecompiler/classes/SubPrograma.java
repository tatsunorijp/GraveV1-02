package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class SubPrograma extends Identificavel{
    public Token token;
    public Tipo tipo;
    public List<Variavel> listaParametros = new ArrayList<>();
    public Escopo escopo = null;

    @Override
    public Token getToken() {
        return null;
    }

    @Override
    public Tipo getTipo() {
        return null;
    }

}
