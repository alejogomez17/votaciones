package com.desarrollo.votaciones.api.modelo.respuesta;

/**
 *
 * @author Alejo Gómez
 */
public class OpcionResultado {

    private String nombre;
    private String url;
    private int cantidadVotos;

    public OpcionResultado() {
    }

    public OpcionResultado(String nombre, String url, int cantidadVotos) {
        this.nombre = nombre;
        this.url = url;
        this.cantidadVotos = cantidadVotos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCantidadVotos() {
        return cantidadVotos;
    }

    public void setCantidadVotos(int cantidadVotos) {
        this.cantidadVotos = cantidadVotos;
    }

}
