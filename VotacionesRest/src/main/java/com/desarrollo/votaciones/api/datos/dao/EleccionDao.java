package com.desarrollo.votaciones.api.datos.dao;

import com.desarrollo.votaciones.api.datos.dominio.Eleccion;
import java.util.List;

/**
 *
 * @author Alejo Gomez
 */
public interface EleccionDao {

    List<Eleccion> obtenerEleccionesActivas();

    List<Object[]> obtenerResumenDeVotosPorEleccion(Integer idEleccion);
}
