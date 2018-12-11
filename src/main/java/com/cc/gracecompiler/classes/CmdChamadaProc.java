package com.cc.gracecompiler.classes;

import com.cc.gracecompiler.parser.Token;

import java.util.List;

public class CmdChamadaProc extends Comando {

    Identificavel identificavel = null;
    List<Expressao> expList = null;

    public CmdChamadaProc(Identificavel identificavel, List<Expressao> expList){
        this.identificavel = identificavel;
        this.expList = expList;
    }

    @Override
    public boolean analiseSemantica(Token linha) {

        if(identificavel instanceof Variavel) throw new RuntimeException("ERRO: Identificador " + identificavel.getToken().image +" nao e subprograma. \r\nLine: " + linha.beginLine);
        if(identificavel == null) throw new RuntimeException("ERRO: Subprograma nao definido. \r\nLine: " + linha.beginLine);

        SubPrograma s = (SubPrograma) identificavel;

        if(s.listaParametros.size() != expList.size()) throw new RuntimeException("ERRO: Quantidade de parametros nao correspondem com a definicao da funcao. \r\nLine: " + linha.beginLine);

        if(expList.size() != 0){
            for(int i = 0; i<expList.size();i++){
                if(s.listaParametros.get(i).tipo != expList.get(i).tipo ) throw new RuntimeException("ERRO: Tipos dos parametros nao correspondem com a definicao da funcao. \r\nLine: " + linha.beginLine);
            }
        }

        return true;
    }
}
