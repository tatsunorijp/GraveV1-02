package com.cc.gracecompiler.classes;

public enum Tipo {
    INT(47), BOOL(48),WORD(49), ID(50), VOID(15);
    public final int kind;

    Tipo(int kind){
        this.kind = kind;
    }

    public static Tipo getTipo(int kind) {
        for (Tipo t : Tipo.values()) {
            if (t.kind == kind) return t;
        }
        throw new IllegalArgumentException("Tipo nao encontrado");
    }

}
