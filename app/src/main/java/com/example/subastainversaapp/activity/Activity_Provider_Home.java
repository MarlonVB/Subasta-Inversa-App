package com.example.subastainversaapp.activity;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.subastainversaapp.ActivityConfigurarCli;
import com.example.subastainversaapp.R;

public class Activity_Provider_Home extends AppCompatActivity {

    Button btn_configuracion;

    Activity_Provider_Home binding;
    private ListView saleList;
    //ListAdapterCategorias adapatador = null; CUANDO SE LE ACTIVA SALE UN ERROR QUE HAY QUE CREAR LA CLASE lIDT ADAPTEC :/

    private String nombres [] ={"Mateo","Mayra"};
    private String edades []={"21","22"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provider_home);
        saleList= (ListView) findViewById(R.id.listSale);
        btn_configuracion= (Button) findViewById(R.id.btn_configuracion);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.sale_list_item, nombres);
        saleList.setAdapter(adapter);

        //MOSTRARA LA VENTANA PARA CONFIGURAR CLIENTE
        btn_configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Provider_Home.this, ActivityConfigurarCli.class));
            }
        });
        //MOSTRARA LA VENTANA PARA CONFIGURAR PROVEDOR
        /*btn_configuracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity_Provider_Home.this, ActivityConfigurarPro.class));
            }
        });*/



    }

}