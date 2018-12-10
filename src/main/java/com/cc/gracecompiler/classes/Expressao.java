package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class Expressao {

    /*public Tipo tipo = null;
    public Operador op = null;

    public Tipo getTipo() {
        return tipo;
    }

    public Operador getOp() {
        return op;
    }*/





    public Tipo tipo;
    public List<Token> tokenList = new ArrayList<Token>();
    public Operador op = null;
    public Boolean unary = false;

    public Tipo getTipo() {
        return tipo;
    }

    public void analiseSemantica(){

        if(op == Operador.AND || op == Operador.OR || op == Operador.NEGATION){
            for(Token t: tokenList){
                if(t.kind != Tipo.BOOL.kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + t.beginLine);
            }
        }

        if(op == Operador.BIGGER || op == Operador.BIGGEREQUAL || op == Operador.SMALLER || op == Operador.SMALLEREQUAL){
            if(tokenList.get(0).kind != Tipo.INT.kind || tokenList.get(1).kind != Tipo.INT.kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + tokenList.get(0).beginLine);
        }

        if(op == Operador.EQUALS || op == Operador.DIFFERENT){
            if(tokenList.get(0).kind != tokenList.get(1).kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + tokenList.get(0).beginLine);
        }

        if(op == Operador.PLUS || op == Operador.MINUS || op == Operador.TIMES || op == Operador.DIVISION || op == Operador.PERCENT){
            for(Token t: tokenList){
                if(t.kind != Tipo.INT.kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + t.beginLine);
            }
        }


    }

}
