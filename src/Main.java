import util.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore();
        // 5, 7, 2, 1, 8, 9, 8, 7, 3 ,0
        arvore.inserir(5);
        arvore.inserir(7);
        arvore.inserir(2);
        arvore.inserir(1);
        arvore.inserir(8);
        arvore.inserir(9);
        arvore.inserir(8);
        arvore.inserir(7);
        arvore.inserir(3);
        System.out.println("\nTamanho da arvore: " + arvore.alturaArvore() +"\n");
        arvore.inserir(0);
        System.out.print("\nListar direita: ");
        arvore.listarDireita();
        System.out.print("Listar esquerda: ");
        arvore.listarEsquerda();
        arvore.imprimir();
        arvore.isFolha(0);
        arvore.remover(0);
        arvore.remover(9);
        arvore.imprimir();
        System.out.println("\nTamanho da arvore: " + arvore.alturaArvore() +"\n");
        arvore.remover(5);
        arvore.imprimir();
        System.out.println("\nTamanho da arvore: " + arvore.alturaArvore() +"\n");
    }
}
