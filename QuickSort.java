public class QuickSort implements SortAlgorithm{

    private int comparacoes;
    private int trocas;

    @Override
    public int[] Sort(int[] vetor) {
        Sort(vetor, 0, vetor.length - 1);
        return vetor;
    }

    private void Sort(int[] vetor, int inicio, int fim) {
        /**
         * Enquanto o inicio for menor que o fim, o código chamará o método "Separar", dividindo o vetor em
         vetores menores, com outros pivôs, até chegar o momento em que o vetor estará ordenado e não podendo
         mais se separar
         * */
        if (inicio < fim) {
            int posicaoPivo = separar(vetor, inicio, fim); // Separando o vetor com o pivô no meio
            Sort(vetor, inicio, posicaoPivo - 1); //Chamando o método de novo para o lado esquerdo do pivô
            Sort(vetor, posicaoPivo + 1, fim); // Chamando o método de novo para o lado direito do pivô
        }
    }

    private int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio]; //O pivô sempre será o primeiro elemento do vetor
        int i = inicio + 1; //O início da sepração vai ser início + 1 pois quem está no inicío é o pivô
        int f = fim; // final do vetor
        while (i <= f) { //enquanto o inicio for menor ou igual ao final
            /**
             * O i iterará o vetor
             * */
            if (vetor[i] <= pivo) {// Se o elemento na posição de início atual for menor ou igual ao pivô o, i incrementará
                i++;
                this.comparacoes++; // Está sendo feita uma comparação
            }
            else if (pivo < vetor[f]) {// Se o elemento na posição final atual for maior que o pivô, o final diminuirá
                f--;
                this.comparacoes++;
            }
            //Tanto o i quanto o f estão indo em direção ao centro do vetor
            else { // Se o vetor[i] não for menor que o pivô e o vetor[f] não for maior que o vetor:
                this.comparacoes = this.comparacoes + 2; // comparações incrementa 2 vezes porque para chegar ness else
                //o código fez as duas comparações dos Ifs
                int troca = vetor[i]; //É criada uma variável de auxílio que recebe o valor de vetor[i]
                vetor[i] = vetor[f]; //E os dois ponteiros fazem um swap
                vetor[f] = troca; //swap
                this.trocas++; //Está sendo feito um swap
                i++; //O ponteiro i incrementa para o próximo elemento
                f--; //igualmente o f
            }
        }
        vetor[inicio] = vetor[f]; //o início será aonde está o ponteiro f
        vetor[f] = pivo; // e o final será aonde está o pivô. formando assim um novo vetor dividido
        return f; //retornando a posição do pivô
    }

    @Override
    public int getComparacoes() {
        return this.comparacoes;
    }

    @Override
    public int getTrocas() {
        return this.trocas;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }
}