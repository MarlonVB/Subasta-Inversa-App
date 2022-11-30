package com.example.subastainversaapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.subastainversaapp.R;
import com.example.subastainversaapp.entity.Proveedor;
import com.example.subastainversaapp.entity.Usuario;
import com.example.subastainversaapp.repository.ServiceProveedor;
import com.example.subastainversaapp.sqlite.DBHelper;
import com.example.subastainversaapp.sqlite.InsertsDBHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityCrearProveedor extends AppCompatActivity {

    Button btnCrearProveedor;
    String nombre, correo, oferta, dubsas, isd;
    EditText txt_NombreProv, txt_ApellidoProv, txt_CorreoP, txt_TelefonoProv,
            txt_DireccionProv, txtContraseniaProv, txtRepContraseniaProv;
    DBHelper dbHelper = new DBHelper(getBaseContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_proveedor);
        btnCrearProveedor= (Button) findViewById(R.id.btnCrearProveedor);

        txt_NombreProv =  findViewById(R.id.txtNombreC);
        txt_ApellidoProv =  findViewById(R.id.txtApellidoC);
        txt_CorreoP =  findViewById(R.id.txtCorreoC);
        txt_TelefonoProv =  findViewById(R.id.txtTelefonoC);
        txt_DireccionProv =  findViewById(R.id.txtDireccionC);
        txtContraseniaProv = findViewById(R.id.txtContraC);
        txtRepContraseniaProv =  findViewById(R.id.txtRepetirC);

        onClickListeners();
    }

    //AQUI AGREGAMOS EL CODIGO PARA GUARDAR
    private void onClickListeners() {
        //MOSTRARA LA VENTANA PARA AGREGAR SERVICIO
        btnCrearProveedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                if (txt_NombreProv.getText().toString().isEmpty() ||
                        txt_ApellidoProv.getText().toString().isEmpty() ||
                        txt_CorreoP.getText().toString().isEmpty() ||
                        txt_TelefonoProv.getText().toString().isEmpty() ||
                        txt_DireccionProv.getText().toString().isEmpty() ||
                        txtContraseniaProv.getText().toString().isEmpty()) {

                    Toast.makeText(ActivityCrearProveedor.this, "Datos Erroneos", Toast.LENGTH_SHORT).show();
                    return;
                } else if(txtContraseniaProv.getText()==txtRepContraseniaProv.getText()){
                    //DialogoConfirmarDatos dcd = new DialogoConfirmarDatos();
                    //dcd.show(fm, "tagAlerta");
                }else {
                    Toast.makeText(ActivityCrearProveedor.this, "Las Contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }
                Usuario u = new Usuario();
                //u.setNombreUsuario(txt_NombreProv.getText().toString());
                //u.setContraseniaUsuario(txtContraseniaProv.getText().toString());

                createPost(0L, txt_NombreProv.getText().toString(),
                        txt_ApellidoProv.getText().toString(),
                        txt_CorreoP.getText().toString(),
                        txt_TelefonoProv.getText().toString(),
                        txt_DireccionProv.getText().toString(),
                        u);

                Intent intent = new Intent (v.getContext(), ActivityLogin.class);
                startActivityForResult(intent, 0);

                //GUARDAMOS INFORMACIÓN EN LA BASE DE DATOS PARA QUE AL MOMENTO DE AGREGAR SERVIO BUSQUE LA DATA Y CREE
                InsertsDBHelper save = new InsertsDBHelper(ActivityCrearProveedor.this);
                //save.insertRProveedor(txt_NombreProv.getText().toString(), txt_ApellidoProv.getText().toString(), txt_CorreoP.getText().toString(), txt_TelefonoProv.getText().toString(), txt_DireccionProv.getText().toString(), txtContraseniaProv.getText().toString());
                //startActivity(new Intent(ActivityCrearProveedor.this, ActivityRegistrarServicio.class));
            }
        });
    }

    private void createPost(Long id_persona, String nombre, String apellido, String email, String telefono, String direccion, Usuario usuario) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://10.0.2.2:9090")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ServiceProveedor provservice = retrofit.create(ServiceProveedor.class);
        Usuario usuario1 = new Usuario(txt_CorreoP.getText().toString(), txtContraseniaProv.getText().toString());
        Proveedor c = new Proveedor(id_persona, nombre, apellido, email, telefono, direccion, usuario1);
        Call<Proveedor> call = provservice.createProveedor(c);

        call.enqueue(new Callback<Proveedor>() {
            @Override
            public void onResponse(Call<Proveedor> call, Response<Proveedor> response) {
                Toast.makeText(ActivityCrearProveedor.this, "Proveedor añadido con exito", Toast.LENGTH_SHORT).show();
                txt_NombreProv.setText("nombre");
                txt_ApellidoProv.setText("apellido");
                txt_CorreoP.setText("email");
                txt_TelefonoProv.setText("telefono");
                txt_DireccionProv.setText("direccion");
                usuario1.setContraseniaUsuario("contraseniaUsuario");
                usuario1.setNombreUsuario("nombreUsuario");
            }

            @Override
            public void onFailure(Call<Proveedor> call, Throwable t) {
                Toast.makeText(ActivityCrearProveedor.this, "ERROR de RED", Toast.LENGTH_SHORT).show();
            }

        });
    }

    //VALIDACIONES
    private boolean validarContrase() {
        if (txtContraseniaProv.getText().toString().length() < 4) {
            txtContraseniaProv.setError("la contraseña debe tener mas de 4 caracteres");
            txtRepContraseniaProv.requestFocus();
            return false;
        } else if (TextUtils.isEmpty(txtContraseniaProv.getText().toString())) {
            txtContraseniaProv.setError("contraseña no permititda");
            txtContraseniaProv.requestFocus();
            return false;
        }
        return true;
    }

}