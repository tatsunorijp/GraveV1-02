package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class Expressao {

    public Tipo tipo;
    public List<Token> tokenList = new ArrayList<Token>();
    public Operador op = null;
    public Boolean unary = false;

    public Tipo getTipo() {
        return tipo;
    }
}
