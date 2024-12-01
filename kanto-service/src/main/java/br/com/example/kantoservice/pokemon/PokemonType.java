package br.com.example.kantoservice.pokemon;

public enum PokemonType {
    PLANTA("planta"),
    FOGO("fogo"),
    AGUA("água"),
    ELETRICO("elétrico");

    private final String descryption;

    PokemonType(String descryption) {
        this.descryption = descryption;
    }

    @Override
    public String toString() {
        return this.descryption;
    }
}
