package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

public class CmdAtribuicao extends Comando {

    public Identificavel identificavel;
    public Expressao exp;

    public CmdAtribuicao(Identificavel identificavel, Expressao exp){
        this.identificavel = identificavel;
        this.exp = exp;
    }

    @Override
    public boolean analiseSemantica(Token linha) {

        if(identificavel instanceof SubPrograma) throw new RuntimeException("ERRO: Identificador " + identificavel.getToken().image +" nao e variavel. \r\nLine: " + linha.beginLine);
        if(identificavel == null) throw new RuntimeException("ERRO: Variavel nao instanciada. \r\nLine: " + linha.beginLine);
        if(identificavel.getTipo() != exp.tipo) throw new RuntimeException("ERRO: Tipos incompativeis na atribuicao. \r\nLine: " + linha.beginLine);

        ((Variavel) identificavel).inicializada = true;

        return true;
    }

}
