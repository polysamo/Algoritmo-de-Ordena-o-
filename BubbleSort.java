public class BubbleSort implements SortAlgorithm{

    private int comparacoes;
    private int trocas;

    @Override
    public int[] Sort(int vetor[]) {
        boolean loop = true; //Variável de loop
        int aux; // Variaviel de auxílio para trocas
        while (loop) {
            loop = false; //Se o bubbleSort não tiver acabado, o método irá deixar a troca == true
            //Se o bubblesort tiver acabado, troca vai ser igual a false e loop quebrará
            for (int i = 0; i < vetor.length - 1; i++) { //Iterando o vetor
                if (vetor[i] > vetor[i + 1]) {
                    /**
                     * Se o vetor[i] for maior que o vetor[i+1] então o vetor[i+1] assume o lugar do vetor[i] e visse-versa
                     * */
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    loop = true;
                    this.trocas ++;
                    this.comparacoes++;
                } else{this.comparacoes++;}
            }
        }
        return vetor; //retornando o vetor depois do método
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
    public void setComparacoes(int comparacoes){

    }
}