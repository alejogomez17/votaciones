package com.desarrollo.votaciones.api.modelo.respuesta;

import java.util.List;

/**
 *
 * @author Alejo Gómez
 */
public class ResultadoEleccion {
    private List<OpcionResultado> opciones;

    public ResultadoEleccion(List<OpcionResultado> opciones) {
        this.opciones = opciones;
    }

    public List<OpcionResultado> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<OpcionResultado> opciones) {
        this.opciones = opciones;
    }  
    
}
