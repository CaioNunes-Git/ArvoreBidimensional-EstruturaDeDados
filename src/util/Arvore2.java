package util;

public class Arvore2 {
    public No raiz;

    public Arvore2() {
        raiz = null;
    }

    public boolean inserir(int info) {
        No local = raiz;
        No no = new No(info);
        if (raiz == null) {
            raiz = no;
            return true;
        }
        while (local != null) {
            no.pai = local;
            if (info == local.valor) {
                return false;
            } else if (info < local.valor) {
                local = local.esquerda;
                if (local == null) {
                    no.pai.esquerda = no;
                    return true;
                }
            } else {
                local = local.direita;
                if (local == null) {
                    no.pai.direita = no;
                    return true;
                }
            }
        }
        return false;
    }
}
