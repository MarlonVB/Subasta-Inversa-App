package com.example.subastainversaapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Cliente implements Serializable {

    @SerializedName("id_persona")
    private Long id_persona;
    @SerializedName("nombre")
    private String nombre;
    @SerializedName("apellido")
    private String apellido;
    @SerializedName("email")
    private String email;
    @SerializedName("telefono")
    private String telefono;
    @SerializedName("direccion")
    private String direccion;
    @SerializedName("usuario_id")
    Usuario usuario = new Usuario();

    public Cliente(Long id_persona, String nombre, String apellido, String email, String telefono, String direccion, Usuario usuario) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
    }

    public Cliente() {
    }

    public Cliente(Long id_persona, String nombre, String apellido, String email, String telefono, String direccion, String usuario) {
    }
    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}


