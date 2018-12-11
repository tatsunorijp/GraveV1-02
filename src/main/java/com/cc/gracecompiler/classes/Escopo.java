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

    public Escopo(Escopo escopo){
        escopoPai = escopo;
    }

    // Insere na tabela de simbolos o identificador sendo declarado junto com o seu tipo
    public void inserirSimbolo(Token identificador, Identificavel identificado)
    {
//        System.out.println("-----------------");
//        System.out.println("ANTES");
//        imprimeTabela();
//        System.out.println("ANTES");
//
//        System.out.println(identificador.image);
        tabela.put(identificador.image, identificado);

//        System.out.println("DEPOIS");
//        imprimeTabela();
//        System.out.println("DEPOIS");
//        System.out.println("-----------------");
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
                System.out.println(var);
            }

            e = e.escopoPai;
        }


    }

}







