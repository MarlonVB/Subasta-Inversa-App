package com.example.subastainversaapp;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.subastainversaapp.entity.Servicio;
import com.example.subastainversaapp.repository.ServiceServicio;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityRegistrarServicio extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ImageButton IbtnAgregar;
    Button btnAceptarServicio;
    //array de ejemplo
    List<String> lista= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_servicio);
        //IbtnAgregar= (ImageButton) findViewById(R.id.IbtnAgregar);
        btnAceptarServicio= (Button) findViewById(R.id.btnAceptarServicio);
        getPosts();

        //implementando el spinner
        Spinner spinn = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,lista);
        /* arrayAdapter.add();*/
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinn.setAdapter(arrayAdapter);

        //
        /*btnAceptarServi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (v.getContext(), DialogoAprovacionR.class);
                startActivityForResult(intent, 0);
            }

        });*/

        btnAceptarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DialogoAprovacionR dc = new DialogoAprovacionR();
                dc.show(fm, "tagAlerta");
                //finish();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //se mostrara el menu en pantalla
        Toast.makeText(getApplicationContext(), lista.get(position), Toast.LENGTH_LONG).show();
    }

    //AQUI AGREMAMOS EL CODIGO PARA GUARDAR DATOS
    private void onClickListeners() {
        //MOSTRAR VENTANA DE APROVACION
        btnAceptarServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                DialogoAprovacionR dc = new DialogoAprovacionR();
                dc.show(fm, "tagAlerta");
                //finish();
            }
        });
    }
    private void getPosts() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9090")
                .addConverterFactory(GsonConverterFactory.create()).build();
        ServiceServicio api = retrofit.create(ServiceServicio.class);
        Call<List<Servicio>> call = api.listServicios();
        call.enqueue(new Callback<List<Servicio>>() {
            @Override
            public void onResponse(Call<List<Servicio>> call, Response<List<Servicio>> response) {
                if( response.isSuccessful()){
                    List<Servicio> listaServicios = response.body();
                    for(int i =0; i<listaServicios.size();i++) {
                        lista.add(listaServicios.get(i).getNombreServicio());
                    }
                }
            }

            @Override
            public void onFailure(Call<java.util.List<Servicio>> call, Throwable t) {

            }

        });

    }
}