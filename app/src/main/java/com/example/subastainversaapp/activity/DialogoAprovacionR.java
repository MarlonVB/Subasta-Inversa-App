package com.example.subastainversaapp.activity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoAprovacionR extends DialogFragment {

    Button btnAceptarDialogoSer,btnAceptarServi;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return null;
    }

    /*private AlertDialog dialogoAprovacion() {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getLayoutInflater();
        View v = inflater.inflate(R.layout.activity_dialogo_aprovacion_r, null);
        builder.setView(v);
        btnAceptarDialogoSer = v.findViewById(R.id.btnAceptarDialogoCli);


        //SE MOSTRARA LA VENTANA DE APROVACION EN CLIENTES
        /*btnAceptarDialogoSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });



        btnAceptarServi = v.findViewById(R.id.btnAceptarDialogoCli);
        //SE MOSTRARA LA VENTANA DE APROVACION EN PROVEEDORES/AGREGAR SERVICIO
        btnAceptarServi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { dismiss();}
        });

        return builder.create();
    }*/
}