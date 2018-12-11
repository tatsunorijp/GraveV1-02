package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

import java.util.ArrayList;
import java.util.List;

public class Expressao {

    public Tipo tipo;
    public List<Operador> opList = new ArrayList<Operador>();
    public List<Expressao> expList = new ArrayList<Expressao>();

    public Expressao(){}

    public Expressao(List<Operador> opList, List<Expressao> expList){
        this.opList = opList;
        this.expList = expList;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public List<Operador> getOpList() {
        return opList;
    }

    public List<Expressao> getExpList() {
        return expList;
    }

    public Boolean analiseSemantica(Token linha){

        Tipo t = expList.get(0).getTipo();

        // verifica se os tipos das expressoes sao todos iguais
        //System.out.println("\n\n@\n@");
        for(Expressao e : expList){
            //System.out.println(e.tipo.kind);
            if(e.getTipo() != t) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + linha.beginLine);
        }

        // seta o tipo da expressao
        //this.tipo = t;

        // verifica se as expressoes sao compativeis com o(s) operador(es) sendo aplicado(s)

        if(opList.isEmpty()){
            this.tipo = expList.get(0).tipo;

        } else {
            Operador op = opList.get(0);

            if(op == Operador.AND || op == Operador.OR || op == Operador.NEGATION){
                this.tipo = Tipo.BOOL;
                if(t.kind != Tipo.BOOL.kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + linha.beginLine);
            }

            if(op == Operador.BIGGER || op == Operador.BIGGEREQUAL || op == Operador.SMALLER || op == Operador.SMALLEREQUAL){
                this.tipo = Tipo.BOOL;
                if(t.kind != Tipo.INT.kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + linha.beginLine);
            }

            if(op == Operador.EQUALS || op == Operador.DIFFERENT){
                this.tipo = Tipo.BOOL;
                if(t.kind != Tipo.BOOL.kind || t.kind != Tipo.INT.kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + linha.beginLine);
            }

            if(op == Operador.PLUS || op == Operador.MINUS || op == Operador.TIMES || op == Operador.DIVISION || op == Operador.PERCENT){
                this.tipo = Tipo.INT;
                if(t.kind != Tipo.INT.kind) throw new RuntimeException("ERRO: Tipos incompativeis na expressao. \r\nLine: " + linha.beginLine);
            }

        }


        return true;
    }

}
