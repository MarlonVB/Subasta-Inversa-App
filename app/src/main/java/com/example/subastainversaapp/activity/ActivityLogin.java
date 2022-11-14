package com.example.subastainversaapp.activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.subastainversaapp.MainActivity;
import com.example.subastainversaapp.R;

public class ActivityLogin extends AppCompatActivity {

    TextView txtOlvidar_contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtOlvidar_contrasena=findViewById(R.id.txtOlvidar_contrasena);

        txtOlvidar_contrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //METODO PARA CAMBIAR VENTANA
                /*Intent recuperarC = new Intent(ActivityLogin.this, ActivityRecuperaC.class);
                startActivity(recuperarC);
                finish();*/
                //startActivity(new Intent(ActivityLogin.this, ActivityRecuperaC.class));
           }
        });
        new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(ActivityLogin.this, ActivityRecuperaC.class);
            startActivity(intent);
            //finish();

        }
        }, 3000);
    }
}