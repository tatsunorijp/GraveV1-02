package com.cc.gracecompiler.classes;

public abstract class Comando {
    public abstract boolean analisarSemantica();
    public abstract String gerarCodigoIntermediario();
}
