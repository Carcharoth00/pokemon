package com.example.proyecto1.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyecto1.R;
import com.example.proyecto1.databinding.ViewholderPokemonBinding;
import com.example.proyecto1.model.Pokemon;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private List<Pokemon> listaPokemons;
    private final LayoutInflater inflater;

    public PokemonAdapter(Context context, List<Pokemon> listaPokemons) {
        this.inflater = LayoutInflater.from(context);
        this.listaPokemons = listaPokemons;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.viewholder_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = listaPokemons.get(position);
        holder.binding.tvNum.setText(pokemon.getNumero());;
        holder.binding.ivPokemon.setImageResource(pokemon.getImage());
        holder.binding.tvNombre.setText(pokemon.getNombre());

        holder.itemView.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putSerializable("pokemon", pokemon);

            NavController navController = Navigation.findNavController(v);
            navController.navigate(R.id.action_pokedexFragment_to_detallePokemonFragment, bundle);
        });
    }

    @Override
    public int getItemCount() {
        return listaPokemons != null ? listaPokemons.size() : 0;
    }

    public void establecerLista(List<Pokemon> listaPokemons) {
        this.listaPokemons = listaPokemons;
        notifyDataSetChanged();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        ViewholderPokemonBinding binding;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ViewholderPokemonBinding.bind(itemView);
        }
    }

}
