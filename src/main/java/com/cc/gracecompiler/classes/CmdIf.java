package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

public class CmdIf extends Comando {

    public Expressao exp;

    public CmdIf(Expressao exp){
        this.exp = exp;
    }

    @Override
    public boolean analiseSemantica(Token linha) {

        if(exp.tipo != Tipo.BOOL) throw new RuntimeException("ERRO: Condicao invalida para o comando IF. \r\nLine: " + linha.beginLine);

        return true;
    }
}
