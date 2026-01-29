package com.example.proyecto1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyecto1.databinding.FragmentDetallePokemonBinding;
import com.example.proyecto1.model.Pokemon;
import com.example.proyecto1.repository.PokemonRepository;

// Asegúrate de que el import de la clase 'Args' generada exista.
// Si no, Android Studio te pedirá que lo añadas.
// import com.example.proyecto1.ui.DetallePokemonFragmentArgs;

public class DetallePokemonFragment extends Fragment {

    private FragmentDetallePokemonBinding binding;
    private PokemonRepository repository;

    Pokemon pokemonSeleccionado;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            pokemonSeleccionado = (Pokemon) getArguments().getSerializable("pokemon");

        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetallePokemonBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        repository = new PokemonRepository();

        if (pokemonSeleccionado != null) {
            binding.tvNum.setText("#" + pokemonSeleccionado.getNumero());
            // Corregido: tu clase Pokemon usa getImagen(), no getImage()
            binding.ivDetalle.setImageResource(pokemonSeleccionado.getImage());
            binding.tvNombre.setText(pokemonSeleccionado.getNombre());
        } else {
            Toast.makeText(getContext(), "Error: No se pudo encontrar el Pokémon.", Toast.LENGTH_SHORT).show();
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
