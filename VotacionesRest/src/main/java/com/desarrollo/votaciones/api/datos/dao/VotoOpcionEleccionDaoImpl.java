package com.desarrollo.votaciones.api.datos.dao;

import com.desarrollo.votaciones.api.datos.dominio.VotoOpcionEleccion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo Gómez
 */
public class VotoOpcionEleccionDaoImpl implements VotoOpcionEleccionDao {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public VotoOpcionEleccion save(VotoOpcionEleccion votoOpcionEleccion) {
        return this.entityManager.merge(votoOpcionEleccion);
    }

}
