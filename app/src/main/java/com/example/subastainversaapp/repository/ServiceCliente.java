package com.example.subastainversaapp.repository;

import com.example.subastainversaapp.entity.Cliente;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ServiceCliente {
    @POST("/auth/cliente/crear")
    Call<Cliente> createCliente(@Body Cliente cliente);
    @GET("/auth/cliente/listar")
    Call<List<Cliente>> listCliente();
    @GET("/auth/cliente/listar_filtro/{filtro}")
    Call<List<Cliente>> list_filtroCliente(@Path("filtro") String filtro);
    @PUT("/auth/cliente/editar/{idCliente}")
    Call<Cliente> editCliente(@Path("idCliente") Long id, @Body Cliente cliente);
    @DELETE("/auth/cliente/eliminar/{idCliente}")
    Call<Cliente> deleteCliente(@Path("idCliente") Long id);
}
