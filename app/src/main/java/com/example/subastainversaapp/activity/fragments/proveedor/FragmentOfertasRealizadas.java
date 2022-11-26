package com.example.subastainversaapp.activity.fragments.proveedor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.subastainversaapp.R;
import com.example.subastainversaapp.adapters.ListOferRealizadaAdapter;
import com.example.subastainversaapp.entity.Oferta;
import com.example.subastainversaapp.repository.ServiceOferta;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;

public class FragmentOfertasRealizadas extends Fragment {

    private List<Oferta> offers;
    private RecyclerView recyclerView;
    private ListOferRealizadaAdapter adapteroferes;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_ofertas_realizadas,container,false);
        recyclerView= view.findViewById(R.id.listaOferRealizadas);
        offers= new ArrayList<>();
        mostrarDatos();
        return view;
    }

    public void mostrarDatos(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9090") //Url del emulador predeterminado
                .addConverterFactory(GsonConverterFactory.create()).build();

        // Call<List<Servicio>> call = api.listServicios();
        Call<List<Oferta>> call = retrofit.create(ServiceOferta.class).listOferta(); //Se llama el método predefinido en la Api para listar
        call.enqueue(new Callback<List<Oferta>>() {
            @Override
            public void onResponse(Call<List<Oferta>> call, Response<List<Oferta>> response) {
                if(response.isSuccessful()){
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    offers=response.body();
                    adapteroferes= new ListOferRealizadaAdapter(offers, getContext()); //Aquí la consulta ya debe realizarse a la base para poder mostrar los datos
                    recyclerView.setAdapter(adapteroferes);
                }
            }

            @Override
            public void onFailure(Call<List<Oferta>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de extracción de ofertas", Toast.LENGTH_SHORT).show();

            }
        });
    }

}