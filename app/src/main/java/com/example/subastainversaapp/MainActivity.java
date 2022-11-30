package com.example.subastainversaapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.subastainversaapp.activity.ActivityLogin;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String>messageList;
    public static String ID_USUARIO;
    public static String CORREO_USUARIO;
    public static String ID_CLIENTE;
    public static String ID_PROOVEDOR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent (MainActivity.this, ActivityLogin.class);
        startActivity(intent);
    }

}