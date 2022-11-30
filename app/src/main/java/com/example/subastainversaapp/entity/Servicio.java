package com.example.subastainversaapp.entity;;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Servicio implements Serializable {

    @SerializedName("id_servicio")
    private long idServicio;
    @SerializedName("nombre_servicio")
    private String nombreServicio;
    @SerializedName("descripcion_servicio")
    private String descripcion_servicio;

    public Servicio(long idServicio, String nombreServicio, String descripcion_servicio) {
        this.idServicio = idServicio;
        this.nombreServicio = nombreServicio;
        this.descripcion_servicio = descripcion_servicio;
    }

    public Servicio() {
    }

    public long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(long idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public String getDescripcion_servicio() {
        return descripcion_servicio;
    }

    public void setDescripcion_servicio(String descripcion_servicio) {
        this.descripcion_servicio = descripcion_servicio;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "idServicio=" + idServicio +
                ", nombreServicio='" + nombreServicio + '\'' +
                ", descripcion_servicio='" + descripcion_servicio + '\'' +
                '}';
    }

}
