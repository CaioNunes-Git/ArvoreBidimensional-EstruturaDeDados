import util.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        // 5, 7, 2, 1, 8, 9, 8, 7, 3 ,0
        // arvore.tamanho();
        System.out.println("Tamanho da Árvore: " + arvore.alturaArvore(arvore.raiz));
        arvore.inserir(5);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(7);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(2);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(1);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(8);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(9);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(8);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(7);
        System.out.println(arvore.isFolha(arvore.raiz));
        arvore.inserir(3);
        System.out.println(arvore.isFolha(arvore.raiz));
        System.out.println("Tamanho da Árvore: " + arvore.alturaArvore(arvore.raiz));
        arvore.inserir(0);
        System.out.println("\n");
        imprimirArvore(arvore);
        System.out.println("");
        listarDireitaEsquerda(arvore);
        System.out.println("\n");
        removerDireitaEsquerda(arvore);
        System.out.println("Tamanho da Árvore: " + arvore.alturaArvore(arvore.raiz));
        //arvore.totalFolha
    //System.out.println(arvore.listaEsquerda());
        //arvore.listaEsquerda();

    }

    private static void imprimirArvore(Arvore arvore) {
        arvore.imprimirPos();
        arvore.imprimirInfix();
        arvore.imprimirPre();
    }

    private static void removerDireitaEsquerda(Arvore arvore) {
        System.out.println("---Removendo todos os elementos da direita---");
        for (int i = 0; i < arvore.direita.size(); i++) {
            arvore.direita.remove(i);
        }
        System.out.println("\n");
        System.out.println("---Removendo todos os elementos da esquerda---");
        for (int i = 0; i < arvore.esquerda.size(); i++) {
            arvore.esquerda.remove(i);
        }
    }

    private static void listarDireitaEsquerda(Arvore arvore) {
        System.out.println("---Listando Direita---");
        for (int i = 0; i < arvore.direita.size(); i++) {
            System.out.println(arvore.direita.get(i));
        }
        System.out.println("---Listando Esquerda---");
        for (int i = 0; i < arvore.esquerda.size(); i++) {
            System.out.println(arvore.esquerda.get(i));
        }
    }
}
