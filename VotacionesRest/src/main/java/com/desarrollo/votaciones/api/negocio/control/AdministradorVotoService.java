package com.desarrollo.votaciones.api.negocio.control;

/**
 *
 * @author Alejo Gómez
 */
public interface AdministradorVotoService {

    boolean generarVoto(Integer idEleccion, String ip);
}
