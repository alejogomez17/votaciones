package com.desarrollo.votaciones.api.modelo.respuesta;

/**
 *
 * @author Alejo Gómez
 */
public class RespuestaGeneral {
    private boolean respuesta;

    public RespuestaGeneral() {
    }

    public RespuestaGeneral(boolean respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isRespuesta() {
        return respuesta;
    }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
    
}
