package com.desarrollo.votaciones.api.negocio.control;

import com.desarrollo.votaciones.api.datos.dominio.Eleccion;
import com.desarrollo.votaciones.api.modelo.respuesta.ResultadoEleccion;
import java.util.List;

/**
 *
 * @author Alejo Gómez
 */
public interface AdministradorEleccionesService {

    List<Eleccion> obtenerEleccionesActivas();
    
    ResultadoEleccion obtenerResultadosDeEleccion(Integer idEleccion);
}
