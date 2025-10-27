package com.yubo.Model;



public class Especialidad {
    private String nombreEsp;


    public Especialidad() {
    }

    public Especialidad(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }


    public String getNombreEsp() {
        return nombreEsp;
    }

    public void setNombreEsp(String nombreEsp) {
        this.nombreEsp = nombreEsp;
    }

    @Override
    public String toString() {
        return nombreEsp;
    }
}
