public class CountingSort implements SortAlgorithm {

    // Variáveis para contar o número de comparações e movimentações (trocas) realizadas
    private int comparacoes;
    private int trocas;

    @Override
    public int[] Sort(int[] vetor) {
        int max = findMax(vetor);  // Encontra o valor máximo no array
        int[] count = new int[max + 1];  // Cria o array de contagem
        int[] output = new int[vetor.length];  // Array de saída

        // Conta a ocorrência de cada elemento no vetor
        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i]]++;
            this.comparacoes++;  // Contagem de comparações
        }

        // Atualizar o array de contagem acumulada para saber onde estão localizadas
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            this.comparacoes++;  // Contagem de comparações
        }

        // Constroi o array de saída
        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[vetor[i]] - 1] = vetor[i];
            count[vetor[i]]--;
            this.trocas++;  // Contagem de trocas, já que estamos movendo elementos
        }

        // Copiar os elementos ordenados de volta para o vetor original
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = output[i];
        }

        return vetor;  // Retornar o vetor ordenado
    }

    // Uma função auxiliar para encontrar o valor máximo no array
    private int findMax(int[] vetor) {
        int max = vetor[0];  // Assume que o primeiro elemento é o maior
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {   // Verifica se algum elemento é maior que o atual 'max'
                max = vetor[i];  // Atualiza o valor máximo
            }
        }
        return max;
    }

    @Override
    public int getComparacoes() {
        return comparacoes;
    }

    @Override
    public int getTrocas() {
        return trocas;
    }

    @Override
    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }
}
