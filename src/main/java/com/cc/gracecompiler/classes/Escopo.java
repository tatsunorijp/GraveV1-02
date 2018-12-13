package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;
import jdk.nashorn.internal.ir.WhileNode;

import java.util.Hashtable;
import java.lang.String;

public class Escopo {

    // Tabela de simbolos
    public Hashtable<String, Identificavel> tabela = new Hashtable<>();

    // Escopo pai
    public Escopo escopoPai = null;

    //public Boolean isGlobal = false; // se o escopo for global. nao pode haver RETURN
    public Boolean isLoopOrCond = false; // usado para verificação de STOP ou SKIP
    //public Boolean isProcedure = false;
    //public Boolean isFunc = false;
    public Boolean hasReturn = false; // usado para verificar se houve comando RETURN na funcao
    public SubPrograma subPrograma = null; // usado para verificar RETURN


    public Escopo(Escopo escopo){
        escopoPai = escopo;
    }

    // Insere na tabela de simbolos o identificador sendo declarado junto com o seu tipo
    public void inserirSimbolo(Token identificador, Identificavel identificado)
    {

        if(this.tabela.get(identificador.image) != null) throw new RuntimeException("ERRO: Variavel" + identificador.image + " ja declarada neste escopo. \r\nLine: " + identificador.beginLine);
        tabela.put(identificador.image, identificado);
    }

    // Busca por um simbolo na tabela do escopo atual e nos escopos pai
    public Identificavel buscarSimbolo(Token checkTok){

        Escopo escopo = this;

        while(escopo != null){

            Identificavel identificavel = escopo.tabela.get(checkTok.image);
            if(identificavel == null){

                escopo = escopo.escopoPai;

            } else return identificavel;

        }
        return null;

    }

    public void imprimeTabela(){

        Escopo e = this;

        while(e !=null){

            for(String var : tabela.keySet()){
                System.out.println("NOME: " + var + "\tTIPO: " + tabela.get(var).getTipo());
            }

            e = e.escopoPai;
        }


    }

}







