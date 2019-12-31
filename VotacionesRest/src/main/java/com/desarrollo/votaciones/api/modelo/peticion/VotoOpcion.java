package com.desarrollo.votaciones.api.modelo.peticion;

/**
 *
 * @author Alejo Gómez
 */
public class VotoOpcion {
    private Integer idEleccion;

    public VotoOpcion() {
    }

    public VotoOpcion(Integer idEleccion) {
        this.idEleccion = idEleccion;
    }

    public Integer getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(Integer idEleccion) {
        this.idEleccion = idEleccion;
    }
    
    
}
