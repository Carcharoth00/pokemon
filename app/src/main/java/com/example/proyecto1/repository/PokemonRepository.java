package com.example.proyecto1.repository;

import com.example.proyecto1.R;
import com.example.proyecto1.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {
    private List<Pokemon> listaPokemons;
    private static List<Pokemon> miEquipo = new ArrayList<>();


    public PokemonRepository(){
        listaPokemons = new ArrayList<>();

        //1º Gen
        listaPokemons.add(new Pokemon("Bulbasaur", R.drawable.bulbasur, "001"));
        listaPokemons.add(new Pokemon("Ivysaur", R.drawable.ivysaur, "002"));
        listaPokemons.add(new Pokemon("Venusaur", R.drawable.venosaur, "003"));
        listaPokemons.add(new Pokemon("Charmander", R.drawable.charmander, "004"));
        listaPokemons.add(new Pokemon("Charmeleon", R.drawable.charmeleon, "005"));
        listaPokemons.add(new Pokemon("Charizard", R.drawable.charizard, "006"));
        listaPokemons.add(new Pokemon("Squirtle", R.drawable.squirtle, "007"));
        listaPokemons.add(new Pokemon("Wartortle", R.drawable.wartortle, "008"));
        listaPokemons.add(new Pokemon("Blastoise", R.drawable.blastoise, "009"));

        //2º Gen
        listaPokemons.add(new Pokemon("Chikorita", R.drawable.chikorita, "152"));
        listaPokemons.add(new Pokemon("Bayleef", R.drawable.bayleef, "153"));
        listaPokemons.add(new Pokemon("Meganium", R.drawable.meganium, "154"));
        listaPokemons.add(new Pokemon("Cyndaquil", R.drawable.cyndaquil, "155"));
        listaPokemons.add(new Pokemon("Quilava", R.drawable.quilava, "156"));
        listaPokemons.add(new Pokemon("Typhlosion", R.drawable.typhlosion, "157"));
        listaPokemons.add(new Pokemon("Totodile", R.drawable.totodile, "158"));
        listaPokemons.add(new Pokemon("Croconaw", R.drawable.croconaw, "159"));
        listaPokemons.add(new Pokemon("Feraligatr", R.drawable.feraligatr, "160"));

        //3º Gen
        listaPokemons.add(new Pokemon("Treecko", R.drawable.treecko, "252"));
        listaPokemons.add(new Pokemon("Grovyle", R.drawable.grovyle, "253"));
        listaPokemons.add(new Pokemon("Sceptile", R.drawable.sceptile, "254"));
        listaPokemons.add(new Pokemon("Torchic", R.drawable.torchic, "255"));
        listaPokemons.add(new Pokemon("Combusken", R.drawable.combusken, "256"));
        listaPokemons.add(new Pokemon("Blaziken", R.drawable.blaziken, "257"));
        listaPokemons.add(new Pokemon("Mudkip", R.drawable.mudkip, "258"));
        listaPokemons.add(new Pokemon("Marshtomp", R.drawable.marshtomp, "259"));
        listaPokemons.add(new Pokemon("Swampert", R.drawable.swampert, "260"));

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
        listaPokemons.remove(pokemon);
    }

    public List<Pokemon> getPokemons(){
        return listaPokemons;
    }

    public static List<Pokemon> getMiEquipo() {
        return miEquipo;
    }

    public void pokemonAleatorio(){
        int random = (int) (Math.random() * listaPokemons.size());
        miEquipo.add(listaPokemons.get(random));
    }

}
