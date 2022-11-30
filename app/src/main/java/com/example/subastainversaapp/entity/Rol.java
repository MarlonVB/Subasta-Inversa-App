package com.example.subastainversaapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Rol implements Serializable {
    @SerializedName("id_rol")
    private Long id_rol;
    @SerializedName("rolNombre")
    private String rolNombre;

    public Rol() {
    }

    public Rol(Long id_rol, String rolNombre) {
        this.id_rol = id_rol;
        this.rolNombre = rolNombre;
    }

    public Long getId_rol() {
        return id_rol;
    }

    public void setId_rol(Long id_rol) {
        this.id_rol = id_rol;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
}
