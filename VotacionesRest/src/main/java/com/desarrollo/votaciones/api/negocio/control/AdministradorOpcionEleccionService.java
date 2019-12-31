package com.desarrollo.votaciones.api.negocio.control;

import com.desarrollo.votaciones.api.datos.dominio.OpcionEleccion;
import java.util.List;

/**
 *
 * @author Alejo Gómez
 */
public interface AdministradorOpcionEleccionService {
    List<OpcionEleccion> obtenerOpcionesEleccionPorEleccion(Integer idEleccion);
}
