package com.desarrollo.votaciones.api.datos.dao;

import com.desarrollo.votaciones.api.datos.dominio.OpcionEleccion;
import java.util.List;

/**
 *
 * @author Alejo Gómez
 */
public interface OpcionEleccionDao {

    List<OpcionEleccion> obtenerOpcionEleccionPorIdEleccion(Integer idEleccion);
}
