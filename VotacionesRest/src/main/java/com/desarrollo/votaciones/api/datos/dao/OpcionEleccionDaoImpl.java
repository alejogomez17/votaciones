package com.desarrollo.votaciones.api.datos.dao;

import com.desarrollo.votaciones.api.datos.dominio.OpcionEleccion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Alejo Gómez
 */
public class OpcionEleccionDaoImpl implements OpcionEleccionDao{

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<OpcionEleccion> obtenerOpcionEleccionPorIdEleccion(Integer idEleccion) {
        try {
            Query query = this.entityManager.createNamedQuery("OpcionEleccion.findByIdEleccion", OpcionEleccion.class);
            query.setParameter("idEleccion", idEleccion);
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error obteniendo opciones de eleccion por elección. Desc: " + ex.getMessage());
        }
        return new ArrayList<>();
    }
}
