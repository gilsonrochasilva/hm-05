package br.ufpa.icen.ppgcc.lista05;

import br.ufpa.icen.ppgcc.NaoReconheceuException;

/**
 * Created by gilson on 19/06/17.
 */
public class Questao03 {

    private String[] fitaEntrada;

    private String fitaEntradaFormatada;

    private int estadoAtual;

    private int ponteiro;

    public Questao03(String fitaEntrada) {
        this.fitaEntrada = fitaEntrada.split(",");
        this.fitaEntradaFormatada = fitaEntrada;
    }

    public void lerFita() throws NaoReconheceuException {
        estadoAtual = 0;
        ponteiro = 0;

        for (String simbolo : fitaEntrada) {
            avancar(simbolo);
        }

        System.out.println("Aceitou a cadeia: " + fitaEntradaFormatada);
    }

    private void avancar(String simbolo) throws NaoReconheceuException {
        switch (estadoAtual) {
            case 0:
                if(simbolo.equals("25")) {
                    System.out.println("25\t->\t0");
                    estadoAtual = 1;
                } else if(simbolo.equals("50")) {
                    System.out.println("50\t->\t0");
                    estadoAtual = 2;
                } else if(simbolo.equals("100")) {
                    System.out.println("100\t->\t1");
                    estadoAtual = 0;
                } else if(simbolo.equals("@")) {
                    estadoAtual = 0;
                } else {
                    throw new NaoReconheceuException(simbolo, "0");
                }

                break;

            case 1:
                if(simbolo.equals("25")) {
                    System.out.println("25\t->\t0");
                    estadoAtual = 2;
                } else if(simbolo.equals("50")) {
                    System.out.println("50\t->\t0");
                    estadoAtual = 3;
                } else if(simbolo.equals("100")) {
                    System.out.println("100\t->\t1");
                    estadoAtual = 1;
                } else {
                    throw new NaoReconheceuException(simbolo, "1");
                }

                break;

            case 2:
                if(simbolo.equals("25")) {
                    System.out.println("25\t->\t0");
                    estadoAtual = 3;
                } else if(simbolo.equals("50")) {
                    System.out.println("50\t->\t1");
                    estadoAtual = 0;
                } else if(simbolo.equals("100")) {
                    System.out.println("100\t->\t1");
                    estadoAtual = 2;
                } else {
                    throw new NaoReconheceuException(simbolo, "2");
                }

                break;

            case 3:
                if(simbolo.equals("25")) {
                    System.out.println("25\t->\t1");
                    estadoAtual = 0;
                } else if(simbolo.equals("50")) {
                    System.out.println("50\t->\t1");
                    estadoAtual = 1;
                } else if(simbolo.equals("100")) {
                    System.out.println("100\t->\t1");
                    estadoAtual = 3;
                } else {
                    throw new NaoReconheceuException(simbolo, "3");
                }

                break;
        }
    }

    public static void main(String[] args) {
        try {
            new Questao03("50,25,50,100,25,50,25,25,50,@").lerFita();
        } catch (NaoReconheceuException e) {
            System.out.println(e.getMessage());
        }
    }
}
