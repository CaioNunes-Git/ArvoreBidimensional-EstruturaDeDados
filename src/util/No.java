package util;

public class No {
    No pai;
    No esquerda;
    No direita;
    int valor;

    public No(int valor) {
        pai = null;
        esquerda = null;
        direita = null;
        this.valor = valor;
    }
}
