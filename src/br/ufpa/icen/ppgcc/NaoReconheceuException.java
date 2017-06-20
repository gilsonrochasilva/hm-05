package br.ufpa.icen.ppgcc;

/**
 * Created by gilson on 19/06/17.
 */
public class NaoReconheceuException extends RuntimeException {

    public NaoReconheceuException(char simbolo, String estado) {
        super(String.format("Travou no estado %s na leitura do símbolo %s", estado, simbolo));
    }

    public NaoReconheceuException(String simbolo, String estado) {
        super(String.format("Travou no estado %s na leitura do símbolo %s", estado, simbolo));
    }
}
