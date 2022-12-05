package util;

public class Arvore {
    public No raiz = null;
    private boolean yesItIs=false;

    public Arvore() {
    }

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
            inserir(valor, local.direita);
            return;
        }
        local.direita = new No(valor);
        local.direita.pai = local;
        System.out.println("Numero " + valor + " inserido na direita!");

    }

    private void inserirMenor(int valor, No local) {
        if (local.esquerda != null) {
            inserir(valor, local.esquerda);
            return;
        }
        local.esquerda = new No(valor);
        local.esquerda.pai = local;
        System.out.println("Numero " + valor + " inserido na esquerda!");
    }

    public void remover(int valor) {
        if (raiz != null) {
            if(raiz.valor != valor) {
                remover(valor, raiz);
                return;
            }
            raiz = null;
            System.out.println("Raiz foi removida!");
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
        }
    }

    public void imprimir() {
        if (raiz != null) {
            No local = raiz;
            System.out.print("Pos fix: ");
            imprimirPos(local);
            System.out.print("\nPre fix: ");
            imprimirPre(local);
            System.out.print("\nIn fix: ");
            imprimirIn(local);
            System.out.println("");
            return;
        }
        System.out.println("Arvore vazia!");
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

    public Integer alturaArvore() {
        return alturaArvore(raiz);
    }

    private Integer alturaArvore(No raiz) {
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

    public void listarDireita() {
        No local = raiz;
        listarDireita(local);
        System.out.println("");
    }

    private void listarDireita(No local) {
        if (local.esquerda != null) {
            listarDireita(local.esquerda);
        }
        if (local.direita != null) {
            listarDireita(local.direita);
            System.out.print(local.direita.valor);
        }
    }

    public void listarEsquerda() {
        No local = raiz;
        listarEsquerda(local);
        System.out.println("");
    }

    private void listarEsquerda(No local) {
        if (local.esquerda != null) {
            listarEsquerda(local.esquerda);
            System.out.print(local.esquerda.valor);
        }
        if (local.direita != null) {
            listarEsquerda(local.direita);
        }
    }
    
    public void isFolha(int valor) {
        No local = raiz;
        yesItIs = false;
        if (local.valor == valor) {
            System.out.println(valor+ " e raiz!\n");
            return;
        }
        isFolha(local, valor);
        if (yesItIs) {
            System.out.println(valor+" e folha!\n");
        } else {
            System.out.println(valor+" nao e folha!\n");
        }
    }

    private void isFolha(No local, int valor) {
        if (local.esquerda != null) {
            isFolha(local.esquerda, valor);
        }
        if (local.direita != null) {
            isFolha(local.direita, valor);
        }
        if (local.valor == valor && local.direita == null && local.esquerda == null) {
            yesItIs = true;
        }
    }
}
