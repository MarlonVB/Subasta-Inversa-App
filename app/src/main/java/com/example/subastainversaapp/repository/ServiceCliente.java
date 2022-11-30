package com.example.subastainversaapp.repository;

import com.example.subastainversaapp.entity.Cliente;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface ServiceCliente {
    @POST("/cliente/crear")
    Call<Cliente> createCliente(@Body Cliente cliente);
    @GET("/cliente/listar")
    Call<List<Cliente>> listCliente();
    @GET("/cliente/listar_filtro/{filtro}")
    Call<List<Cliente>> listCliente(@Path("filtro") String filtro);
    @PUT("/clienet/editar/{idCliente}")
    Call<Cliente> editCliente(@Path("idCliente") Long id, @Body Cliente cliente);
    @DELETE("/cliente/eliminar/{idCliente}")
    Call<Cliente> deleteCliente(@Path("idCliente") Long id);
}
