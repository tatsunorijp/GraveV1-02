package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

public abstract class Comando {
    public abstract boolean analiseSemantica(Token linha);
    //public abstract String gerarCodigoIntermediario();
}
