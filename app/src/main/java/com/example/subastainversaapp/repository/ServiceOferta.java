package com.example.subastainversaapp.repository;

import com.example.subastainversaapp.entity.Oferta;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ServiceOferta {
    @GET("/auth/oferta/listar")
    Call<List<Oferta>> listOferta();

    @GET("/auth/oferta/subasta/listar/{idSubasta}")
    Call<List<Oferta>> listOfertaSubasta();

    @POST("/auth/oferta/crear")
    Call<Oferta> createOferta(@Body Oferta oferta);

    @PUT("/auth/oferta/editar/{idOferta}")
    Call<Oferta> editOferta(@Path("idOferta") Long id, @Body Oferta oferta);

    @DELETE("/oferta/eliminar/{idOferta}")
    Call<Oferta> deleteSubasta(@Path("idOferta") String idOferta);

    @GET("/auth/oferta/listar/id/{id}")
    Call<Oferta> listOfertaId(@Path("id") Long id);

    @GET("/auth/oferta/listar/fecha/{fecha}")
    Call<Oferta> listOfertaFecha(@Path("fecha") String fecha);

    @GET("/oferta/listar/estado/{estado}")
    Call<Oferta> listOfertaEstado(@Path("estado") Boolean estado);
    @GET("/oferta/listar/proveedor/{proveedor}")
    Call<Oferta> listOfertaProveedor(@Path("estado") Boolean estado);

    @GET("/oferta/listar/calificacion/{califiacion:.*}")
    Call<Oferta> listOfertaCalificacion(@Path("estado") Boolean estado);
}

