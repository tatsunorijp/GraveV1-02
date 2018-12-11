package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

public class CmdWhile extends Comando {

    Expressao exp;

    public CmdWhile(Expressao exp){
        this.exp = exp;
    }

    @Override
    public boolean analiseSemantica(Token linha) {

        if(exp.tipo != Tipo.BOOL) throw new RuntimeException("ERRO: Condicao invalida para o comando WHILE. \r\nLine: " + linha.beginLine);

        return true;
    }
}
