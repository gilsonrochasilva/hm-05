package br.ufpa.icen.ppgcc;

/**
 * Created by gilson on 19/06/17.
 */
public class Funcoes {

    public static String s;
    public static int p;

    public static void lePalavra(final String _s) {
        p = 0;
        s = _s;
    }

    public static boolean xp(String c) {
        System.out.println("xp: " + s.substring(p, p + 1) + " == " + c + "? " + s.substring(p, p + 1).equals(c));
        return s.substring(p, p + 1).equals(c);
    }

    public static boolean np() {
        System.out.println("np: " + p++ + " --> " + p);
        return true;
    }
}