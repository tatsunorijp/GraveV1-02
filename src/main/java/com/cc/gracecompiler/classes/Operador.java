package com.cc.gracecompiler.classes;

public enum Operador {
    PLUS(25),MINUS(26),TIMES(27),DIVISION(28),PERCENT(29),EQUALS(30),DIFFERENT(31),BIGGEREQUAL(32),BIGGER(33),SMALLEREQUAL(34),SMALLER(35),OR(36),AND(37), NEGATION(38);

    public final int kind;

    Operador(int kind) {
        this.kind = kind;
    }
}
