package com.example.subastainversaapp.response;

import com.example.subastainversaapp.entity.Servicio;

import java.util.ArrayList;

public class ResponseServicio {
    private ArrayList<Servicio> results;

    public ArrayList<Servicio> getResults(){
        return results;
    }
    public void setResults(ArrayList<Servicio> results){
        this.results=results;
    }
}
