package br.ufpa.icen.ppgcc.lista05;

import static br.ufpa.icen.ppgcc.Funcoes.np;
import static br.ufpa.icen.ppgcc.Funcoes.xp;
import static br.ufpa.icen.ppgcc.Funcoes.lePalavra;

/**
 *
 W   -> A1 B
 A1  -> a A2
 A2  -> a A3
 A3  -> a A
 A   -> a
 B   -> bB
 B   -> &

 */

public class Questao01 {

    private static boolean W() {
        return A1() && B();
    }

    private static boolean A1() {
        return  xp("a") && np() && A2() || A();
    }

    private static boolean A2() {
        return  xp("a") && np() && A3() || A();
    }

    private static boolean A3() {
        return  xp("a") && np() && A() || A();
    }

    private static boolean A() {
        return  xp("a") && np();
    }

    private static boolean B() {
        return xp("b") && np() && B() || true;
    }

    public static void main(String[] args) {
        lePalavra("aaab@");

        if(W() && xp("@")) {
            System.out.println("Reconheceu");
        } else {
            System.out.println("Não reconheceu");
        }
    }
}
