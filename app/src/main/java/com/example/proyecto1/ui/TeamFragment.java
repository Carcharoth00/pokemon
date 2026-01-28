package com.example.proyecto1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.proyecto1.adapter.PokemonAdapter;
import com.example.proyecto1.databinding.FragmentTeamBinding;
import com.example.proyecto1.model.Pokemon;
import com.example.proyecto1.repository.PokemonRepository;

import java.util.List;

public class TeamFragment extends Fragment {

    // Declarar las variables a nivel de clase para que estén disponibles en todos los métodos.
    private FragmentTeamBinding binding;
    private PokemonAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 1. Se infla la vista y se inicializa 'binding'.
        //    A partir de aquí y hasta onDestroyView(), 'binding' no será null.
        binding = FragmentTeamBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // --- LÓGICA DE CONFIGURACIÓN INICIAL (SE EJECUTA UNA SOLA VEZ POR CADA VISTA CREADA) ---

        // 2. Obtenemos la lista del equipo desde el repositorio.
        List<Pokemon> equipoActual = PokemonRepository.getMiEquipo();

        // 3. Creamos una nueva instancia del adaptador con la lista.
        adapter = new PokemonAdapter(requireContext(), equipoActual);

        // 4. Configuramos el RecyclerView con su LayoutManager y le asignamos el adaptador.
        //    Este es el lugar seguro para interactuar con 'binding'.
        binding.recyclerViewTeam.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        binding.recyclerViewTeam.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        // --- LÓGICA DE ACTUALIZACIÓN (SE EJECUTA CADA VEZ QUE EL FRAGMENTO SE HACE VISIBLE) ---

        // 5. Cuando el fragmento se vuelve visible, solo necesitamos notificar al adaptador
        //    que los datos pueden haber cambiado (por ej., si se añadió un Pokémon).
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // 6. Es una buena práctica limpiar la referencia al 'binding' para liberar memoria
        //    y evitar fugas. Este es el paso que hace que el 'binding' sea null
        //    y por qué no se debe usar en onResume() para inicializar vistas.
        binding = null;
    }
}
