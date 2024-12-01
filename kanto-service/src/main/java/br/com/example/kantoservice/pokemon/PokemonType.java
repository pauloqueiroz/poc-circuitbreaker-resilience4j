package br.com.example.kantoservice.pokemon;

public enum PokemonType {
    PLANTA("planta"),
    FOGO("fogo"),
    AGUA("água"),
    ELETRICO("elétrico");

    private String descryption;

    PokemonType(String descryption) {
        this.descryption = descryption;
    }

    public String getDescryption(){
        return this.descryption;
    }
}
