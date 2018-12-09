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
            if(!escopo.buscarSimbolo(identificador)){
                escopo = escopo.escopoPai;
            }
            else{
                System.out.println("Erro: Variavel " + identificador.image + " ja instanciada. \r\nLine: " + identificador.beginLine);
                return;
            }
        }

        tabela.put(identificador.image, identificado);

    }

    public Boolean buscarSimbolo(Token checkTok){

        try
        {
            // Se o identificador existe na tabela, ok
            int tipoIdent1 = (Integer) tabela.get(checkTok.image).getTipo().kind;
            return true;//" ";
        }
        catch(Exception e)
        {
            // Se o identificador nao existe na tabela, retorne um erro
            return false;//"Error: The identifier " + checkTok.image + " hasn't been declared \r\nLine: " + checkTok.beginLine;
        }

    }

    public void imprimeTabela(){
        for(String var : tabela.keySet()){
            System.out.println(var);
        }
    }

}







