package com.example.proyecto1.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.proyecto1.R;
import com.example.proyecto1.databinding.FragmentDetallePokemonBinding;
import com.example.proyecto1.model.Pokemon;
import com.example.proyecto1.repository.PokemonRepository;

import java.util.List;

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
            binding.ivDetalle.setImageResource(pokemonSeleccionado.getImage());
            binding.tvNombre.setText(pokemonSeleccionado.getNombre());
        } else {
            Toast.makeText(getContext(), "Error: No se pudo encontrar el Pokémon.", Toast.LENGTH_SHORT).show();
            requireActivity().getOnBackPressedDispatcher().onBackPressed();
        }

        if (getArguments() != null) {
            int position = getArguments().getInt("pokemon_position", -1);
            Pokemon pokemonSeleccionado = repository.getPokemon(position);

            if (pokemonSeleccionado != null) {
                binding.ivDetalle.setImageResource(pokemonSeleccionado.getImage());
                binding.tvNombre.setText(pokemonSeleccionado.getNombre());
                binding.tvNum.setText("#" + pokemonSeleccionado.getNumero());

                mostrarTiposPokemon(pokemonSeleccionado.getTipos());

            } else {
                Toast.makeText(getContext(), "Error: No se pudo encontrar el tipo.", Toast.LENGTH_SHORT).show();
                requireActivity().getOnBackPressedDispatcher().onBackPressed();
            }
        }
    }
    private void mostrarTiposPokemon(List<String> tipos) {
        // Limpiamos cualquier vista previa que pudiera haber en el contenedor
        binding.contenedorTipos.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (String nombreTipo : tipos) {
            // Inflamos el layout de la etiqueta de tipo
            TextView etiquetaTipo = (TextView) inflater.inflate(R.layout.item_tipo, binding.contenedorTipos, false);

            // Establecemos el texto del tipo
            etiquetaTipo.setText(nombreTipo);

            // Obtenemos el color correspondiente y lo aplicamos al fondo
            int colorId = obtenerColorPorTipo(nombreTipo);
            etiquetaTipo.getBackground().setTint(getResources().getColor(colorId, null));

            // Añadimos la etiqueta al contenedor LinearLayout
            binding.contenedorTipos.addView(etiquetaTipo);
        }
    }

    // Método auxiliar para mapear el nombre del tipo a su recurso de color
    private int obtenerColorPorTipo(String tipo) {
        switch (tipo.toLowerCase()) {
            case "planta": return R.color.tipo_planta;
            case "fuego": return R.color.tipo_fuego;
            case "agua": return R.color.tipo_agua;
            case "bicho": return R.color.tipo_bicho;
            case "normal": return R.color.tipo_normal;
            case "veneno": return R.color.tipo_veneno;
            case "electrico": case "eléctrico": return R.color.tipo_electrico;
            case "tierra": return R.color.tipo_tierra;
            case "hada": return R.color.tipo_hada;
            case "lucha": return R.color.tipo_lucha;
            case "psiquico": case "psíquico": return R.color.tipo_psiquico;
            case "roca": return R.color.tipo_roca;
            case "fantasma": return R.color.tipo_fantasma;
            case "hielo": return R.color.tipo_hielo;
            case "dragon": case "dragón": return R.color.tipo_dragon;
            case "acero": return R.color.tipo_acero;
            case "siniestro": return R.color.tipo_siniestro;
            case "volador": return R.color.tipo_volador;
            default: return R.color.tipo_desconocido;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
