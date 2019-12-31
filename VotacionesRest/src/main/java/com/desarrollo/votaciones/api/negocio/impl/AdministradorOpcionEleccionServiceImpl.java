package com.desarrollo.votaciones.api.negocio.impl;

import com.desarrollo.votaciones.api.datos.dao.OpcionEleccionDao;
import com.desarrollo.votaciones.api.datos.dominio.OpcionEleccion;
import com.desarrollo.votaciones.api.negocio.control.AdministradorOpcionEleccionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Alejo Gómez
 */
public class AdministradorOpcionEleccionServiceImpl implements AdministradorOpcionEleccionService {

    @Autowired
    private OpcionEleccionDao opcionEleccionDaoImpl;
    
    @Override
    public List<OpcionEleccion> obtenerOpcionesEleccionPorEleccion(Integer idEleccion){
        return this.opcionEleccionDaoImpl.obtenerOpcionEleccionPorIdEleccion(idEleccion);
    }
}
