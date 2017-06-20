package br.ufpa.icen.ppgcc.lista05;

import br.ufpa.icen.ppgcc.NaoReconheceuException;

import java.util.Stack;

/**
 * Created by gilson on 19/06/17.
 */
public class Questao02A {

    private Stack<String> pilha = new Stack<>();

    private char[] fitaEntrada;

    private int estadoAtual;

    private int ponteiro;

    public Questao02A(String fitaEntrada) {
        this.fitaEntrada = fitaEntrada.toCharArray();
    }

    public void lerFita() throws NaoReconheceuException {
        pilha.push("Z0");
        estadoAtual = 0;
        ponteiro = 0;

        for (char c : fitaEntrada) {
            avancar(c);
        }

        System.out.println("Aceitou a cadeia: " + new String(fitaEntrada));
    }

    private void avancar(char simbolo) throws NaoReconheceuException {
        String itemPilha = pilha.pop();
        System.out.println(String.format("Estado %s. Pop %s. Símbolo %s", estadoAtual, itemPilha, simbolo));

        switch (estadoAtual) {
            case 0:
                if(simbolo == 'a' && itemPilha.equals("Z0")) {
                    pilha.push("Z0");
                    pilha.push("X");
                    estadoAtual = 0;
                } else if(simbolo == 'a' && itemPilha.equals("X")) {
                    pilha.push("X");
                    pilha.push("X");
                    estadoAtual = 0;
                } else if(simbolo == 'b' && itemPilha.equals("X")) {
                    estadoAtual = 1;
                } else if(simbolo == 'c' && itemPilha.equals("Z0")) {
                    pilha.push("Z0");
                    estadoAtual = 2;
                } else {
                    throw new NaoReconheceuException(simbolo, "0");
                }

                break;

            case 1:
                if(simbolo == 'b' && itemPilha.equals("X")) {
                    estadoAtual = 1;
                } else if(simbolo == 'c' && itemPilha.equals("Z0")) {
                    pilha.push("Z0");
                    estadoAtual = 2;
                } else {
                    throw new NaoReconheceuException(simbolo, "1");
                }

                break;

            case 2:
                if(simbolo == 'c' && itemPilha.equals("Z0")) {
                    pilha.push("Z0");
                    estadoAtual = 2;
                } else if(simbolo == '@' && pilha.isEmpty()) {
                    estadoAtual = 2;
                } else {
                    throw new NaoReconheceuException(simbolo, "2");
                }

                break;
        }
    }

    public static void main(String[] args) {
        try {
            new Questao02A("ab@").lerFita();
        } catch (NaoReconheceuException e) {
            System.out.println(e.getMessage());
        }
    }
}
