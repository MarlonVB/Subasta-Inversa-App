package com.example.subastainversaapp.activity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.subastainversaapp.ActivityCrearCliente;
import com.example.subastainversaapp.R;
import com.example.subastainversaapp.api.Apis;
import com.example.subastainversaapp.entity.Usuario;
import com.example.subastainversaapp.repository.ServiceUsuario;
import com.example.subastainversaapp.sqlite.DBHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.ArrayList;

public class ActivityLogin extends AppCompatActivity {

    Button btnIngresar;
    TextView txtOlvidar_contrasena, txtCrear_cuenta, txtCear_provedor;
    EditText txtUsuario, txtContra;
    ArrayList<String> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9090") //Url del emulador predeterminado
                .addConverterFactory(GsonConverterFactory.create()).build();*/

        // Call<List<Servicio>> call = api.listServicios();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createDB();
        txtOlvidar_contrasena = findViewById(R.id.txtOlvidar_contrasena);
        txtCrear_cuenta = findViewById(R.id.txtCrear_cuenta);
        txtCear_provedor = findViewById(R.id.txtCear_provedor);
        btnIngresar = findViewById(R.id.btn_ingresar);
        txtUsuario = findViewById(R.id.edtTextUsuario);
        txtContra = findViewById(R.id.editTextTextPassword);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
       txtUsuario.setText("Ingrese su Correo");
       //txtContra.setText("1234");

        txtOlvidar_contrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //METODO PARA CAMBIAR VENTANA
                Intent recuperarC = new Intent(ActivityLogin.this, ActivityRecuperaC.class);
                startActivity(recuperarC);
                //finish();
                //startActivity(new Intent(ActivityLogin.this, ActivityRecuperaC.class));
            }
        });

        txtCrear_cuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogin.this, ActivityCrearCliente.class));
            }
        });

        txtCear_provedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityLogin.this, ActivityCrearProveedor.class));
            }
        });

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUsername() && validatePassword()) {
                    System.out.println("pasa validacion de campos");
                    Usuario s = new Usuario(txtUsuario.getText().toString(), txtContra.getText().toString());
                    Call<Usuario> call = Apis.getInstance().create(ServiceUsuario.class).getUser(s);

                    call.enqueue(new Callback<Usuario>() {
                       @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            System.out.println("Pasa las validaciones");
                            Toast.makeText(ActivityLogin.this, "Iniciando sesión", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(ActivityLogin.this, Activity_MenuProveedor.class);
                            Usuario p = new Usuario();
                            startActivity(intent);
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            Toast.makeText(ActivityLogin.this, "fallo", Toast.LENGTH_SHORT).show();
                       }
                    });

                }

            }
        });
    }

    private void createDB() {
        DBHelper dbHelper = new DBHelper(ActivityLogin.this);
        SQLiteDatabase dbsql = dbHelper.getWritableDatabase();
    }

    private boolean validateUsername() {
        if (txtUsuario.getText().toString().isEmpty() || txtUsuario.getText().toString() == "") {
            txtUsuario.setError("Nombre de usuario incorrecto");
            Toast.makeText(ActivityLogin.this, "Nombre de usuario incorrecto", Toast.LENGTH_SHORT).show();
            //System.out.println(etUsername+"USUARIOOOOOOOOO");
            txtUsuario.requestFocus();
            return false;
        }
        return true;
    }

    private boolean validatePassword() {
        if (txtContra.getText().toString().isEmpty() || txtContra.getText().toString() == "") {
            txtContra.setError("Contraseña incorrecta");
            Toast.makeText(ActivityLogin.this, "contraseña  incorrecto", Toast.LENGTH_SHORT).show();
            //System.out.println(etPassword+"CONTRAAAAAAAAAAAAAAA");
            txtContra.requestFocus();
            return false;
        }
        return true;
    }
}



        