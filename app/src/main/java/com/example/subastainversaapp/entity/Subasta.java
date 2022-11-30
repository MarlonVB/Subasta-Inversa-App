package com.example.subastainversaapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Subasta implements Serializable {
    @SerializedName("id_subasta")
    private Long idSubasta;
    @SerializedName("fecha_inicio_subasta")
    private Date fechaInicio;
    @SerializedName("fecha_fin_subasta")
    private Date fechaFin;
    @SerializedName("estado_subasta")
    private String estadoSubasta;
    @SerializedName("titulo_subasta")
    private String tituloSubasta;
    @SerializedName( "hora_cierre_subasta")
    private String horaCierreSubasta;
    @SerializedName( "desc_subasta")
    private String descSubasta;
    @SerializedName("img_subasta")
    private String imgSubasta;
    @SerializedName("id_cliente")
    Cliente cliente = new Cliente();
    @SerializedName("id_servicio")
    Servicio servicio = new Servicio();

    public Subasta() {
    }

    public Subasta(Long idSubasta, Date fechaInicio, Date fechaFin, String estadoSubasta, String tituloSubasta, String horaCierreSubasta, String descSubasta, String imgSubasta, Cliente cliente, Servicio servicio) {
        this.idSubasta = idSubasta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estadoSubasta = estadoSubasta;
        this.tituloSubasta = tituloSubasta;
        this.horaCierreSubasta = horaCierreSubasta;
        this.descSubasta = descSubasta;
        this.imgSubasta = imgSubasta;
        this.cliente = cliente;
        this.servicio = servicio;
    }

    public Long getIdSubasta() {
        return idSubasta;
    }

    public void setIdSubasta(Long idSubasta) {
        this.idSubasta = idSubasta;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getEstadoSubasta() {
        return estadoSubasta;
    }

    public void setEstadoSubasta(String estadoSubasta) {
        this.estadoSubasta = estadoSubasta;
    }

    public String getTituloSubasta() {
        return tituloSubasta;
    }

    public void setTituloSubasta(String tituloSubasta) {
        this.tituloSubasta = tituloSubasta;
    }

    public String getHoraCierreSubasta() {
        return horaCierreSubasta;
    }

    public void setHoraCierreSubasta(String horaCierreSubasta) {
        this.horaCierreSubasta = horaCierreSubasta;
    }

    public String getDescSubasta() {
        return descSubasta;
    }

    public void setDescSubasta(String descSubasta) {
        this.descSubasta = descSubasta;
    }

    public String getImgSubasta() {
        return imgSubasta;
    }

    public void setImgSubasta(String imgSubasta) {
        this.imgSubasta = imgSubasta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Subasta{" +
                "idSubasta=" + idSubasta +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", estadoSubasta='" + estadoSubasta + '\'' +
                ", tituloSubasta='" + tituloSubasta + '\'' +
                ", horaCierreSubasta='" + horaCierreSubasta + '\'' +
                ", descSubasta='" + descSubasta + '\'' +
                ", imgSubasta='" + imgSubasta + '\'' +
                ", cliente=" + cliente +
                ", servicio=" + servicio +
                '}';
    }
}
