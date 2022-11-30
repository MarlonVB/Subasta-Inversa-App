package com.example.subastainversaapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Proveedor implements Serializable {
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
    @SerializedName("anios_exp")
    private String anios_experiencia;
    @SerializedName("id_usuario")
    Usuario usuario = new Usuario();
    @SerializedName("id_servicio")
    Servicio servicios = new Servicio();

    public Proveedor() {
    }
    public Proveedor(Long id_persona, String nombre, String apellido, String email, String telefono, String direccion, String anios_experiencia, Usuario usuario, Servicio servicios) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.anios_experiencia = anios_experiencia;
        this.usuario = usuario;
        this.servicios = servicios;
    }

    public Proveedor(Long id_persona, String nombre, String apellido, String email, String telefono, String direccion, Usuario usuario) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
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

    public String getAnios_experiencia() {
        return anios_experiencia;
    }

    public void setAnios_experiencia(String anios_experiencia) {
        this.anios_experiencia = anios_experiencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Servicio getServicios() {
        return servicios;
    }

    public void setServicios(Servicio servicios) {
        this.servicios = servicios;
    }
}
