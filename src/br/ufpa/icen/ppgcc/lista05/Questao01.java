package br.ufpa.icen.ppgcc.lista05;

import static br.ufpa.icen.ppgcc.Funcoes.np;
import static br.ufpa.icen.ppgcc.Funcoes.xp;
import static br.ufpa.icen.ppgcc.Funcoes.lePalavra;

public class Questao01 {

    public static void main(String[] args) {
        lePalavra("aabab@");

        while (xp("a") && np());

        if (xp("b") && np()) {
            while (xp("b") && np());

            if (xp("@")) System.out.println("Reconheceu.");
            else System.out.println("Não reconheceu.");
        }
    }
}
