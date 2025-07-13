package br.com.example.pokedex.future;

public class CompletableFutureMain {

    public static void main(String[] args) {
        BuscaDadosPokedex buscaDadosPokedex = new BuscaDadosPokedex();
        buscaDadosPokedex.run();
        System.out.println();
    }

}
