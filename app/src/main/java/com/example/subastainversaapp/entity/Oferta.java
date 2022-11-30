package com.example.subastainversaapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Oferta implements Serializable{
    @SerializedName("id_oferta")
    private Long idOferta;
    @SerializedName("percio_ferta")
    private Double percioOferta;
    @SerializedName("fecha_oferta")
    private String fecha;
    @SerializedName("descripcion_oferta")
    private String descripcion_oferta;
    @SerializedName("estado_oferta")
    private String estado;
    @SerializedName("comentario_calificacion_oferta")
    private String comentario_calificacion_oferta;
    @SerializedName("calificacion_oferta")
    private double calificacion;
    @SerializedName("id_proveedor")
    Proveedor proveedor = new Proveedor();
    @SerializedName("id_subasta")
    Subasta subasta = new Subasta();

    public Oferta() {
    }

    public Oferta(Long idOferta, Double percioOferta, String fecha, String descripcion_oferta, String estado, String comentario_calificacion_oferta, double calificacion, Proveedor proveedor, Subasta subasta) {
        this.idOferta = idOferta;
        this.percioOferta = percioOferta;
        this.fecha = fecha;
        this.descripcion_oferta = descripcion_oferta;
        this.estado = estado;
        this.comentario_calificacion_oferta = comentario_calificacion_oferta;
        this.calificacion = calificacion;
        this.proveedor = proveedor;
        this.subasta = subasta;
    }

    public Long getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(Long idOferta) {
        this.idOferta = idOferta;
    }

    public Double getPercioOferta() {
        return percioOferta;
    }

    public void setPercioOferta(Double percioOferta) {
        this.percioOferta = percioOferta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion_oferta() {
        return descripcion_oferta;
    }

    public void setDescripcion_oferta(String descripcion_oferta) {
        this.descripcion_oferta = descripcion_oferta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario_calificacion_oferta() {
        return comentario_calificacion_oferta;
    }

    public void setComentario_calificacion_oferta(String comentario_calificacion_oferta) {
        this.comentario_calificacion_oferta = comentario_calificacion_oferta;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Subasta getSubasta() {
        return subasta;
    }

    public void setSubasta(Subasta subasta) {
        this.subasta = subasta;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "idOferta=" + idOferta +
                ", percioOferta=" + percioOferta +
                ", fecha='" + fecha + '\'' +
                ", descripcion_oferta='" + descripcion_oferta + '\'' +
                ", estado='" + estado + '\'' +
                ", comentario_calificacion_oferta='" + comentario_calificacion_oferta + '\'' +
                ", calificacion=" + calificacion +
                ", proveedor=" + proveedor +
                ", subasta=" + subasta +
                '}';
    }
}

