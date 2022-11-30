package com.example.subastainversaapp.activity.fragments;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.subastainversaapp.R;
import com.example.subastainversaapp.adapters.ListAdapterServicios;
import com.example.subastainversaapp.entity.Servicio;
import com.example.subastainversaapp.repository.ServiceServicio;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;


public class Fragment_ServiciosConfig extends Fragment {

    private List<Servicio> servicios;
    private RecyclerView recyclerView;
    private ListAdapterServicios adapterServicios;


    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment__servicios_config,container,false);
        recyclerView= view.findViewById(R.id.listaSubastas);
        servicios= new ArrayList<>();

      //  cargarLista();
        mostrarDatos();
        return view;
    }

    public void mostrarDatos(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9090") //Url del emulador predeterminado
                .addConverterFactory(GsonConverterFactory.create()).build();

       // Call<List<Servicio>> call = api.listServicios();
        ServiceServicio api = retrofit.create(ServiceServicio.class);
        Call<List<Servicio>> call = api.listServicios(); //Se llama el método predefinido en la Api para listar
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                if(response.isSuccessful()){
                    Log.e(" SUbasta Contexto",getContext().toString());
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    servicios=response.body();
                    adapterServicios= new ListAdapterServicios(servicios, getContext()); //Aquí la consulta ya debe realizarse a la base para poder mostrar los datos
                    recyclerView.setAdapter(adapterServicios);
                }
            }

            @Override
            public void onFailure(Call<List<Servicio>> call, Throwable t) {
                Toast.makeText(getContext(), "Error de Conexión al Servicio", Toast.LENGTH_SHORT).show();

            }
        });
    }

}