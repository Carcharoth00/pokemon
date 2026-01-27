package com.example.proyecto1.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto1.R;
import com.example.proyecto1.adapter.PokemonAdapter;
import com.example.proyecto1.databinding.FragmentGen1Binding;
import com.example.proyecto1.databinding.FragmentPokedexBinding;
import com.example.proyecto1.model.Pokemon;
import com.example.proyecto1.repository.PokemonRepository;

import java.util.List;


public class Gen1Fragment extends Fragment {

    private FragmentGen1Binding binding;
    private PokemonRepository repository;
    private PokemonAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentGen1Binding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtenemos la lista desde el Repository
        repository = new PokemonRepository();
        List<Pokemon> listaPokemons = repository.getPokemons();

        // Configuramos el RecyclerView
        adapter = new PokemonAdapter(requireContext(), listaPokemons);
        binding.recyclerView.setAdapter(adapter);

        // Definimos el LayoutManager (en cuadrícula de 2 columnas)
        binding.recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
    }
}