package com.example.proyecto1.repository;

import com.example.proyecto1.R;
import com.example.proyecto1.model.Pokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokemonRepository {
    private List<Pokemon> listaPokemons;
    private static List<Pokemon> miEquipo = new ArrayList<>();


    public PokemonRepository(){
        listaPokemons = new ArrayList<>();

// 1º Gen
        listaPokemons.add(new Pokemon("Bulbasaur", R.drawable.bulbasur, "001",
                Arrays.asList("Planta", "Veneno")));
        listaPokemons.add(new Pokemon("Ivysaur", R.drawable.ivysaur, "002",
                Arrays.asList("Planta", "Veneno")));
        listaPokemons.add(new Pokemon("Venusaur", R.drawable.venosaur, "003",
                Arrays.asList("Planta", "Veneno")));
        listaPokemons.add(new Pokemon("Charmander", R.drawable.charmander, "004",
                Arrays.asList("Fuego")));
        listaPokemons.add(new Pokemon("Charmeleon", R.drawable.charmeleon, "005",
                Arrays.asList("Fuego")));
        listaPokemons.add(new Pokemon("Charizard", R.drawable.charizard, "006",
                Arrays.asList("Fuego", "Volador")));
        listaPokemons.add(new Pokemon("Squirtle", R.drawable.squirtle, "007",
                Arrays.asList("Agua")));
        listaPokemons.add(new Pokemon("Wartortle", R.drawable.wartortle, "008",
                Arrays.asList("Agua")));
        listaPokemons.add(new Pokemon("Blastoise", R.drawable.blastoise, "009",
                Arrays.asList("Agua")));

// 2º Gen
        listaPokemons.add(new Pokemon("Chikorita", R.drawable.chikorita, "152",
                Arrays.asList("Planta")));
        listaPokemons.add(new Pokemon("Bayleef", R.drawable.bayleef, "153",
                Arrays.asList("Planta")));
        listaPokemons.add(new Pokemon("Meganium", R.drawable.meganium, "154",
                Arrays.asList("Planta")));
        listaPokemons.add(new Pokemon("Cyndaquil", R.drawable.cyndaquil, "155",
                Arrays.asList("Fuego")));
        listaPokemons.add(new Pokemon("Quilava", R.drawable.quilava, "156",
                Arrays.asList("Fuego")));
        listaPokemons.add(new Pokemon("Typhlosion", R.drawable.typhlosion, "157",
                Arrays.asList("Fuego")));
        listaPokemons.add(new Pokemon("Totodile", R.drawable.totodile, "158",
                Arrays.asList("Agua")));
        listaPokemons.add(new Pokemon("Croconaw", R.drawable.croconaw, "159",
                Arrays.asList("Agua")));
        listaPokemons.add(new Pokemon("Feraligatr", R.drawable.feraligatr, "160",
                Arrays.asList("Agua")));

// 3º Gen
        listaPokemons.add(new Pokemon("Treecko", R.drawable.treecko, "252",
                Arrays.asList("Planta")));
        listaPokemons.add(new Pokemon("Grovyle", R.drawable.grovyle, "253",
                Arrays.asList("Planta")));
        listaPokemons.add(new Pokemon("Sceptile", R.drawable.sceptile, "254",
                Arrays.asList("Planta")));
        listaPokemons.add(new Pokemon("Torchic", R.drawable.torchic, "255",
                Arrays.asList("Fuego")));
        listaPokemons.add(new Pokemon("Combusken", R.drawable.combusken, "256",
                Arrays.asList("Fuego", "Lucha")));
        listaPokemons.add(new Pokemon("Blaziken", R.drawable.blaziken, "257",
                Arrays.asList("Fuego", "Lucha")));
        listaPokemons.add(new Pokemon("Mudkip", R.drawable.mudkip, "258",
                Arrays.asList("Agua")));
        listaPokemons.add(new Pokemon("Marshtomp", R.drawable.marshtomp, "259",
                Arrays.asList("Agua", "Tierra")));
        listaPokemons.add(new Pokemon("Swampert", R.drawable.swampert, "260",
                Arrays.asList("Agua", "Tierra")));


    }

    public static void setMiEquipo(List<Pokemon> miEquipo) {
        PokemonRepository.miEquipo = miEquipo;
    }

    public List<Pokemon> getListaPokemons() {
        return listaPokemons;
    }

    public Pokemon getPokemon(int position) {
        if (position >= 0 && position < listaPokemons.size()) {
            return listaPokemons.get(position);
        }
        return null; // Devuelve null si la posición no es válida
    }

    public void eliminarPokemon(Pokemon pokemon){
        miEquipo.remove(pokemon);
    }

    public List<Pokemon> getPokemons(){
        return listaPokemons;
    }

    public List<Pokemon> getPokemonsPorRango(int inicio, int fin) {
        List<Pokemon> pokemonsFiltrados = new ArrayList<>();
        for (Pokemon pokemon : listaPokemons) {
            // Convertimos el número de Pokémon (String) a un entero para comparar
            int numeroPokemon = Integer.parseInt(pokemon.getNumero());
            if (numeroPokemon >= inicio && numeroPokemon <= fin) {
                pokemonsFiltrados.add(pokemon);
            }
        }
        return pokemonsFiltrados;
    }

    public static List<Pokemon> getMiEquipo() {
        return miEquipo;
    }

    public void setListaPokemons(List<Pokemon> listaPokemons) {
        this.listaPokemons = listaPokemons;
    }

    public Pokemon anadirPokemonAleatorioAlEquipo() {
        if (listaPokemons == null || listaPokemons.isEmpty()) {
            return null; // Evita errores si la lista está vacía
        }

        if (miEquipo.size() >= listaPokemons.size()) {
            return null; // Evita un bucle infinito si ya están todos los Pokémon en el equipo
        }
        Pokemon pokemonAleatorio;
        do {
            // 1. Selecciona un Pokémon al azar de la lista completa
            int randomIndex = (int) (Math.random() * listaPokemons.size());
            pokemonAleatorio = listaPokemons.get(randomIndex);

        }while (miEquipo.contains(pokemonAleatorio));

        // 2. Lo añade a la lista estática del equipo
        miEquipo.add(pokemonAleatorio);

        // 3. Devuelve el Pokémon que acaba de ser añadido
        return pokemonAleatorio;
    }

}
