package util;

import java.util.ArrayList;

public class Arvore {
    public No raiz = null;
    public ArrayList<Integer> direita = new ArrayList<>();
    public ArrayList<Integer> esquerda = new ArrayList<>();

    public Arvore() {
    }

    public void remover(int valor) {
        if (raiz != null) {
            remover(valor, raiz);
            return;
        }
        System.out.println("Arvore vazia!");
    }

    private void remover(int valor, No local) {
        if (valor > local.valor) {
            if (local.direita == null) {
                System.out.println("Numero nao existente na arvore...");
                return;
            }
            if (local.direita.valor == valor) {
                local.direita = null;
                System.out.println("Numero " + valor + " removido da arvore!");
                return;
            }
            remover(valor, local.direita);
            return;
        }
        if (valor < local.valor) {
            if (local.esquerda == null) {
                System.out.println("Numero nao existente na arvore...");
                return;
            }
            if (local.esquerda.valor == valor) {
                local.esquerda = null;
                System.out.println("Numero " + valor + " removido da arvore!");
                return;
            }
            remover(valor, local.esquerda);
            return;
        }
    }

    public void imprimir() {
        No local = raiz;
        System.out.print("Pos fix: ");
        imprimirPos(local);
        System.out.print("\nPre fix: ");
        imprimirPre(local);
        System.out.print("\nIn fix: ");
        imprimirIn(local);
        System.out.println("");
    }

    private void imprimirPre(No local) {
        System.out.print(local.valor);
        if (local.esquerda != null) {
            imprimirPre(local.esquerda);
        }
        if (local.direita != null) {
            imprimirPre(local.direita);
        }
    }

    private void imprimirIn(No local) {
        if (local.esquerda != null) {
            imprimirIn(local.esquerda);
        }
        System.out.print(local.valor);
        if (local.direita != null) {
            imprimirIn(local.direita);
        }
    }

    private void imprimirPos(No local) {
        if (local.esquerda != null) {
            imprimirPos(local.esquerda);
        }
        if (local.direita != null) {
            imprimirPos(local.direita);
        }
        System.out.print(local.valor);
    }

    /*
    public int ElementosEsq(int valor) {
        if (local.esquerda != null) {
            return local.esquerda;
        }
        return null;
    }

    public int ElementosDir(No local) {
        if (local.direita != null) {
            return local.direita;
        }
        return 0;
    }*/



    public void inserir(int valor) {
        if (raiz != null) {
            inserir(valor, raiz);
            return;
        }
        raiz = new No(valor);
        System.out.println("Numero " + valor + " inserido na raiz!");
    }

    private void inserir(int valor, No local) {
        if (valor > local.valor) {
            inserirMaior(valor, local);
            return;
        }
        if (valor < local.valor) {
            inserirMenor(valor, local);
            return;
        }
        System.out.println("Numero " + valor + " ja existia na arvore!");
    }

    private void inserirMaior(int valor, No local) {
        if (local.direita != null) {
            System.out.println("Direita");
            inserir(valor, local.direita);
            return;
        }
        local.direita = new No(valor);
        direita.add(local.direita.valor);
        local.direita.pai = local;
        System.out.println("Numero " + valor + " inserido na direita!");

    }

    private void inserirMenor(int valor, No local) {
        if (local.esquerda != null) {
            System.out.println("Esquerda");
            inserir(valor, local.esquerda);
            return;
        }
        local.esquerda = new No(valor);
        esquerda.add(local.esquerda.valor);
        local.esquerda.pai = local;
        System.out.println("Numero " + valor + " inserido na esquerda!");

    }

    public Integer alturaArvore(No raiz) {
        if (raiz == null || raiz.direita == null && raiz.esquerda == null) {
            return 0;
        } else {
            Integer ramoEsquerdo = alturaArvore(raiz.esquerda);
            Integer ramoDireito = alturaArvore(raiz.direita);
            if (ramoEsquerdo > ramoDireito){
                return ramoEsquerdo + 1;
            }else{
                return ramoDireito + 1;
            }
        }
    }
//    public int totalFolhas(No no) {
//        if (no == null){
//            return 0;
//        }
//        if(no.direita == null && no.esquerda == null){
//            return 1;
//        }
//        return totalFolhas(no.esquerda) + totalFolhas(no.direita);
//    }
    public boolean isFolha(No no) {
        if (no.direita == null && no.esquerda == null) {
            return true;
        }

        isFolha(no.direita);
        return false;
    }
}
