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
        Escopo escopo = this;

        while(escopo != null){
            if(escopo.buscarSimbolo(identificador)==null){
                escopo = escopo.escopoPai;
            }
            else{
                throw new RuntimeException("ERRO: Variavel " + identificador.image + " ja instanciada. \r\nLine: " + identificador.beginLine);
            }
        }

        tabela.put(identificador.image, identificado);

    }

    public Identificavel buscarSimbolo(Token checkTok){

        try
        {
            // Se o identificador existe na tabela, retorne-o
            Identificavel identificavel = tabela.get(checkTok.image);
            return identificavel;//" ";
        }
        catch(Exception e)
        {
            // Se o identificador nao existe na tabela, retorne null
            return null;//"Error: The identifier " + checkTok.image + " hasn't been declared \r\nLine: " + checkTok.beginLine;
        }

    }

    public void imprimeTabela(){
        for(String var : tabela.keySet()){
            System.out.println(var);
        }
    }

}







