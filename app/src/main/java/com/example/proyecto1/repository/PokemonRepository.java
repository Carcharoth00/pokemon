package com.example.proyecto1.repository;

import com.example.proyecto1.R;
import com.example.proyecto1.model.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class PokemonRepository {
    private List<Pokemon> listaPokemons;

    public PokemonRepository(){
        listaPokemons = new ArrayList<>();

        listaPokemons.add(new Pokemon("Bulbasaur", R.drawable.bulbasur, "001"));
        listaPokemons.add(new Pokemon("Ivysaur", R.drawable.ivysaur, "002"));
        listaPokemons.add(new Pokemon("Venusaur", R.drawable.venosaur, "003"));
        listaPokemons.add(new Pokemon("Charmander", R.drawable.charmander, "004"));
        listaPokemons.add(new Pokemon("Charmeleon", R.drawable.charmeleon, "005"));
        listaPokemons.add(new Pokemon("Charizard", R.drawable.charizard, "006"));
        listaPokemons.add(new Pokemon("Squirtle", R.drawable.squirtle, "007"));
        listaPokemons.add(new Pokemon("Wartortle", R.drawable.wartortle, "008"));
        listaPokemons.add(new Pokemon("Blastoise", R.drawable.blastoise, "009"));


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

}
