package com.example.proyecto1.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyecto1.adapter.PokemonAdapter;
import com.example.proyecto1.databinding.FragmentPokedexBinding;
import com.example.proyecto1.model.Pokemon;
import com.example.proyecto1.repository.PokemonRepository;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.List;


public class PokedexFragment extends Fragment {

    private FragmentPokedexBinding binding;
    private PokemonRepository repository;
    private PokemonAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPokedexBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        repository = new PokemonRepository();
        List<Pokemon> listaPokemons = repository.getListaPokemons();

        adapter = new PokemonAdapter(requireContext(), listaPokemons);
        binding.recyclerView.setAdapter(adapter);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));

        establecerAdaptadorViewPager();
        vincularTabLayoutConViewPager();

    }
    /**
     * Crea y asigna el adaptador del ViewPager2.
     * Este adaptador indica cuántas páginas (fragments) hay y cuál debe mostrarse según la posición.
     */
    private void establecerAdaptadorViewPager() {
        binding.viewPager.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                // Devuelve el fragment correspondiente a cada pestaña
                switch (position) {
                    default:
                    case 0: return new Gen1Fragment();
                    case 1: return new Gen2Fragment();
                    case 2: return new Gen3Fragment();
                }
            }

            @Override
            public int getItemCount() {
                // Número total de pestañas
                return 3;
            }
        });
    }

    /**
     * Sincroniza el TabLayout con el ViewPager2 usando TabLayoutMediator.
     * Esto permite que al tocar una pestaña cambie la página, y al deslizar se actualice la pestaña activa.
     */
    private void vincularTabLayoutConViewPager() {
        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Local");
                            break;
                        case 1:
                            tab.setText("Nacional");
                            break;
                        case 2:
                            tab.setText("Internacional");
                            break;
                    }
                }).attach();
    }

}