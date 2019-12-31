package com.desarrollo.votaciones.api.datos.dao;

import com.desarrollo.votaciones.api.datos.dominio.Voto;

/**
 *
 * @author Alejo Gómez
 */
public interface VotoDao {
    Voto save(Voto voto);
}
