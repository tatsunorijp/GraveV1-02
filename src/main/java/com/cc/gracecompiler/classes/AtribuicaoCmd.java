package com.cc.gracecompiler.classes;

public class AtribuicaoCmd extends Comando {

    Variavel var;
    Expressao exp;

    @Override
    public boolean analisarSemantica() {
        if (var.getTipo() != exp.getTipo()) return false;
         return true;
    }

    @Override
    public String gerarCodigoIntermediario() {
        return null;
    }
}
