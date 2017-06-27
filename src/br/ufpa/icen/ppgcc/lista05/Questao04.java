package br.ufpa.icen.ppgcc.lista05;

import java.util.*;

public class Questao04 {

    private HashMap<String, HashSet<String>> producoes;
    private String estadoInicial;

    public Questao04(String estadoInicial) {
        this.estadoInicial = estadoInicial;
        this.producoes = new HashMap<String, HashSet<String>>();
    }

    public boolean testar(String entrada) {
        final char[] cadeia = entrada.toCharArray();
        final HashSet[][] tabela = criarTabela(cadeia.length);

        for (int i = 0; i < cadeia.length; i++) {
            ArrayList<String> geradores = listarGeradores(String.valueOf(cadeia[i]));
            if (geradores != null)
                for (String gerador : geradores)
                    tabela[i][i].add(gerador);
        }

        for (int step = 1; step < cadeia.length; step++) {
            int i = 0;
            for (int j = step; j < cadeia.length; j++) {
                for (int k = i; k < j; k++) {
                    Set<String> combinacoes = combinarItens(tabela[i][k],tabela[k+1][j]);
                    for (String producao : combinacoes) {
                        ArrayList<String> geradores = listarGeradores(producao);
                        if(geradores != null)
                            for (String gerador : geradores)
                                tabela[i][j].add(gerador);
                    }
                }
                i++;
            }
        }


        return tabela[0][cadeia.length - 1].contains(estadoInicial);
    }

    private HashSet[][] criarTabela(int tamanho) {
        HashSet[][] tabela = new HashSet[tamanho][tamanho];

        for (int i = 0; i < tamanho; i++)
            for (int j = 0; j < tamanho; j++)
                tabela[i][j] = new HashSet();

        return tabela;
    }

    private HashSet<String> combinarItens(HashSet<String> itensA, HashSet<String> itensB){
        HashSet<String> combinacoes = new HashSet<String>();
        for (String itemProducaoA : itensA)
            for (String itemProducaoB : itensB)
                combinacoes.add(itemProducaoA.concat(itemProducaoB));

        return combinacoes;
    }

    public void adicionar(String producao) {
        String[] regra = producao.split("->");
        String ladoEsquerdo = regra[0];
        HashSet<String> ladoDireito;

        if (producoes.containsKey(ladoEsquerdo))
            ladoDireito = producoes.get(ladoEsquerdo);
        else {
            ladoDireito = new HashSet<String>();
            producoes.put(ladoEsquerdo, ladoDireito);
        }

        String[] producoesLadoDireito = regra[1].split("\\|");
        for (String s : producoesLadoDireito)
            ladoDireito.add(s);
    }

    public ArrayList<String> listarGeradores(String item) {
        ArrayList<String> geradores = new ArrayList<String>();
        for (Map.Entry<String, HashSet<String>> entry : producoes.entrySet()) {
            HashSet<String> producoesResultados = entry.getValue();
            for (String producao : producoesResultados) {
                if (producao.equals(item))
                    geradores.add(entry.getKey());
            }
        }

        return (geradores.size() > 0) ? geradores : null;
    }

    public static void main(String[] args) {

        Questao04 questao04 = new Questao04("S");
        questao04.adicionar("S->AA|AS|b");
        questao04.adicionar("A->SA|AS|a");

        if(questao04.testar("abaab")) {
            System.out.println("Cadeia reconhecida");
        } else {
            System.out.println("Cadeia não reconhecida");
        }
    }
}