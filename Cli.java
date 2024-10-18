import java.util.Scanner;
import java.util.Random;

public class Cli {
    public static void init(){
        System.out.println("\n" +
                " ____    _____   ____    ______      ____    ______  ______  ______     \n" +
                "/\\  _`\\ /\\  __`\\/\\  _`\\ /\\__  _\\    /\\  _`\\ /\\  _  \\/\\__  _\\/\\  _  \\    \n" +
                "\\ \\,\\L\\_\\ \\ \\/\\ \\ \\ \\L\\ \\/_/\\ \\/    \\ \\ \\/\\ \\ \\ \\L\\ \\/_/\\ \\/\\ \\ \\L\\ \\   \n" +
                " \\/_\\__ \\\\ \\ \\ \\ \\ \\ ,  /  \\ \\ \\     \\ \\ \\ \\ \\ \\  __ \\ \\ \\ \\ \\ \\  __ \\  \n" +
                "   /\\ \\L\\ \\ \\ \\_\\ \\ \\ \\\\ \\  \\ \\ \\     \\ \\ \\_\\ \\ \\ \\/\\ \\ \\ \\ \\ \\ \\ \\/\\ \\ \n" +
                "   \\ `\\____\\ \\_____\\ \\_\\ \\_\\ \\ \\_\\     \\ \\____/\\ \\_\\ \\_\\ \\ \\_\\ \\ \\_\\ \\_\\\n" +
                "    \\/_____/\\/_____/\\/_/\\/ /  \\/_/      \\/___/  \\/_/\\/_/  \\/_/  \\/_/\\/_/\n");

        Scanner scan = new Scanner(System.in);

        Random random = new Random();

        SortAlgorithm quickSort = new QuickSort();
        SortAlgorithm bubbleSort = new BubbleSort();
        SortAlgorithm countingSort = new CountingSort();


        System.out.println("Quantos valores de entrada desejas?\n- 10\n- 100\n- 1000\n- 10000");

        int quantidade = scan.nextInt();

        if (quantidade == 10 || quantidade == 100 || quantidade == 1000 || quantidade == 10000){
            System.out.println();
        } else{
            System.out.println("Exceção: Digite um valor válido");
            System.exit(0);
        }


        int[] vetor = new int[quantidade];

        System.out.println("Você quer que os elementos do vetor sejam (Digite o número correspondente):\n1 - Aleatórios\n2 - Ordem Decrescente e aleatórios");



        int ordem = scan.nextInt();
        try {
            if (ordem == 1) {
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random.nextInt(1000); // Gera números aleatórios com limite 1000.
                }
                System.out.print("Vetor atual: [");
                for (int elemento : vetor) {
                    System.out.print(elemento + ", ");
                }
                System.out.print("]");
                System.out.println();


                System.out.println("Qual algoritmo de ordenação você deseja usar? (Digite o número correspondente):\n1 - BubbleSort\n2 - QuickSort\n3 - CountingSort");

                int algo = scan.nextInt();
                if (algo == 1) {
                    long tempoInicial = System.currentTimeMillis();
                    bubbleSort.Sort(vetor);
                    long tempoFinal = System.currentTimeMillis();
                    System.out.print("Vetor ordenado: [");
                    for (int elemento : vetor) {
                        System.out.print(elemento + ", ");
                    }
                    System.out.print("]");
                    System.out.println();

                    System.out.println("BubbleSort executado em = " + (tempoFinal - tempoInicial) + " ms");
                    System.out.println("O algoritmo fez " + bubbleSort.getComparacoes() + " comparações e " + bubbleSort.getTrocas() + " trocas.");

                } else if (algo == 2) {
                    long tempoInicial = System.currentTimeMillis();
                    quickSort.Sort(vetor);
                    long tempoFinal = System.currentTimeMillis();
                    System.out.print("Vetor ordenado: [");
                    for (int elemento : vetor) {
                        System.out.print(elemento + ", ");
                    }
                    System.out.print("]");
                    System.out.println();

                    System.out.println("QuickSort executado em = " + (tempoFinal - tempoInicial) + " ms");
                    System.out.println("O algoritmo fez " + quickSort.getComparacoes() + " comparações e " + quickSort.getTrocas() + " trocas.");

                } else if (algo == 3) {
                    long tempoInicial = System.currentTimeMillis();
                    countingSort.Sort(vetor);
                    long tempoFinal = System.currentTimeMillis();
                    System.out.print("Vetor ordenado: [");
                    for (int elemento : vetor) {
                        System.out.print(elemento + ", ");
                    }
                    System.out.print("]");
                    System.out.println();

                    System.out.println("CountingSort executado em = " + (tempoFinal - tempoInicial) + " ms");
                    System.out.println("O algoritmo fez " + countingSort.getComparacoes() + " comparações e " + countingSort.getTrocas() + " trocas.");
                }

            } else if (ordem == 2) {
                for (int i = 0; i < vetor.length; i++) {
                    vetor[i] = random.nextInt(1000); // Gera números aleatórios com limite 1000.
                }
                quickSort.Sort(vetor); // Ordena o vetor em ordem crescente
                int[] vetorDecrescente = new int[quantidade]; // Variável que irá armazenar o vetor em ordem decrescente
                for (int i = 0; i < vetor.length; i++) {
                    vetorDecrescente[i] = vetor[vetor.length - 1 - i];
                }
                System.out.print("Vetor atual: [");
                for (int elemento : vetorDecrescente) {
                    System.out.print(elemento + ", ");
                }
                System.out.print("]");
                System.out.println();

                System.out.println("Qual algoritmo de ordenação você deseja usar? (Digite o número correspondente):\n1 - BubbleSort\n2 - QuickSort\n3 - CountingSort");


                int algo = scan.nextInt();
                if (algo == 1) {
                    long tempoInicial = System.currentTimeMillis();
                    bubbleSort.Sort(vetorDecrescente);
                    long tempoFinal = System.currentTimeMillis();
                    System.out.print("Vetor ordenado: [");
                    for (int elemento : vetor) {
                        System.out.print(elemento + ", ");
                    }
                    System.out.print("]");
                    System.out.println();

                    System.out.println("BubbleSort executado em = " + (tempoFinal - tempoInicial) + " ms");
                    System.out.println("O algoritmo fez " + bubbleSort.getComparacoes() + " comparações e " + bubbleSort.getTrocas() + " trocas.");

                } else if (algo == 2) {
                    long tempoInicial = System.currentTimeMillis();
                    quickSort.Sort(vetorDecrescente);
                    long tempoFinal = System.currentTimeMillis();
                    System.out.print("Vetor ordenado: [");
                    for (int elemento : vetor) {
                        System.out.print(elemento + ", ");
                    }
                    System.out.print("]");
                    System.out.println();
                    System.out.println("QuickSort executado em = " + (tempoFinal - tempoInicial) + " ms");
                    System.out.println("O algoritmo fez " + quickSort.getComparacoes() + " comparações e " + quickSort.getTrocas() + " trocas.");


                } else if (algo == 3) {
                    long tempoInicial = System.currentTimeMillis();
                    countingSort.Sort(vetorDecrescente);
                    long tempoFinal = System.currentTimeMillis();
                    System.out.print("Vetor ordenado: [");
                    for (int elemento : vetor) {
                        System.out.print(elemento + ", ");
                    }
                    System.out.print("]");
                    System.out.println();
                    System.out.println("CountingSort executado em = " + (tempoFinal - tempoInicial) + " ms");
                    System.out.println("O algoritmo fez " + countingSort.getComparacoes() + " comparações e " + countingSort.getTrocas() + " trocas.");

                }
            }
        }
        catch(Exception e){
            System.out.println("Um erro inesperado aconteceu, tente novamente");
        }
    }
}