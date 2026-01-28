package com.example.proyecto1.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.proyecto1.R;
import com.example.proyecto1.databinding.FragmentGeneradorBinding;
import com.example.proyecto1.model.Pokemon;
import com.example.proyecto1.repository.PokemonRepository;


public class GeneradorFragment extends Fragment {

    private FragmentGeneradorBinding binding;
    private PokemonRepository repository;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflar el layout usando View Binding
        binding = FragmentGeneradorBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Instanciar el repositorio
        repository = new PokemonRepository();

        // Configurar el listener del botón
        binding.btnGenerarPokemon.setOnClickListener(v -> {
            // Llama al método del repositorio para obtener y añadir un Pokémon
            Pokemon pokemonGenerado = repository.anadirPokemonAleatorioAlEquipo();

            if (pokemonGenerado != null) {
                // Actualiza la UI con el nuevo Pokémon
                actualizarVista(pokemonGenerado);

                // Muestra un mensaje de confirmación
                Toast.makeText(getContext(), pokemonGenerado.getNombre() + " se ha unido a tu equipo!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "No se pudo generar un Pokémon.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Método auxiliar para mantener el código limpio
    private void actualizarVista(Pokemon pokemon) {
        // Asigna la imagen y el nombre a los elementos de la vista
        binding.ivPokemonGenerado.setImageResource(pokemon.getImage());
        binding.tvNombrePokemonGenerado.setText(pokemon.getNombre());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Limpia la referencia al binding para evitar memory leaks
        binding = null;
    }
}