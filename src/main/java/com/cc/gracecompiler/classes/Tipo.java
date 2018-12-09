package com.cc.gracecompiler.classes;

public enum Tipo {
    INT(47), BOOL(48),STRING(49), ID(50);
    public final int kind;

    Tipo(int kind){
        this.kind = kind;
    }
}
