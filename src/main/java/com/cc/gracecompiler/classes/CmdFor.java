package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

public class CmdFor extends Comando {

    public Expressao exp;

    public CmdFor(Expressao exp){
        this.exp = exp;
    }

    @Override
    public boolean analiseSemantica(Token linha) {

        if(exp.tipo != Tipo.BOOL) throw new RuntimeException("ERRO: Condicao invalida para o comando FOR. \r\nLine: " + linha.beginLine);

        return true;
    }
}
