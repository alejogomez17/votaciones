package com.desarrollo.votaciones.api.modelo.respuesta;

import com.desarrollo.votaciones.api.datos.dominio.Eleccion;
import com.desarrollo.votaciones.api.utilidades.Formato;
import java.util.Date;

/**
 *
 * @author Alejo Gómez
 */
public class EleccionModel {

    private int id;
    private String nombre;
    private String inicio;
    private String fin;
    private Character estado;

    public EleccionModel() {
    }

    public EleccionModel(Eleccion eleccion) {
        this.id = eleccion.getId();
        this.nombre = eleccion.getNombre();
        this.inicio = Formato.FORMATO_FECHA_HORA.format(eleccion.getInicio());
        this.fin = Formato.FORMATO_FECHA_HORA.format(eleccion.getFin());
        this.estado = eleccion.getEstado();
    }

    public EleccionModel(int id, String nombre, String inicio, String fin, Character estado) {
        this.id = id;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

}
