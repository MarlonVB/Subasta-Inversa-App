package com.example.subastainversaapp.repository;

import com.example.subastainversaapp.entity.Subasta;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ServiceSubasta {

    @GET("/subasta/listar/todo")
    Call<List<Subasta>> listSubasta();
    @GET("/subasta/listar_filtro/{filtro}") //filtro de cualquier campo de subasta
    Call<List<Subasta>> listSubastaFiltro(@Path("filtro") String filtro);
    @GET("/subasta/listar_fecha/{fechaInicio}/{fechaFin}")
    Call<List<Subasta>> listSubastaFiltroFechas(@Path("fechaInicio") String fechaInicio, @Path("fechaFin") String fechaFin);
    @POST("/subasta/crear")
    Call<Subasta> createSubasta(@Body Subasta subasta);
    @DELETE("/subasta/eliminar/{idSubasta}")
    Call<Subasta> deleteSubasta(@Path("idSubasta") String idSubasta);
    @PUT("/subasta/editar/{idSubasta}")
    Call<Subasta> editSubasta(@Path("idSubasta") Long id,@Body Subasta subasta);
}
