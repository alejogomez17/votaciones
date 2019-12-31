package com.desarrollo.votaciones.api.datos.dao;

import com.desarrollo.votaciones.api.datos.dominio.Eleccion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Alejo Gomez
 */
public class EleccionDaoImpl implements EleccionDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Eleccion> obtenerEleccionesActivas() {
        try {
            Query query = this.entityManager.createNamedQuery("Eleccion.findByEstado", Eleccion.class);
            query.setParameter("estado", 'A');
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error obteniendo elecciones activas. Desc: " + ex.getMessage());
        }
        return new ArrayList<>();
    }

    public boolean guardarEleccion(Eleccion eleccion) {
        try {
            this.entityManager.persist(eleccion);
            return true;
        } catch (Exception ex) {
            System.out.println("Error guardando elección. Desc: " + ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Object[]> obtenerResumenDeVotosPorEleccion(Integer idEleccion) {
        try {
            Query query = this.entityManager.createNativeQuery(""
                    + "SELECT p.id, p.nombre, p.url, p.cantidad FROM ( "
                    + "SELECT o.id_opcion as id, o.nombre_opcion as nombre, o.url_opcion as url, count(voe.id_voto_opcion_eleccion)as cantidad "
                    + "FROM voto_opcion_eleccion voe "
                    + "INNER JOIN voto v ON v.id_voto = voe.id_voto_voto_opcion_eleccion "
                    + "INNER JOIN opcion_eleccion oe ON oe.id_opcion_eleccion = voe.id_opcion_eleccion_voto_opcion_eleccion "
                    + "INNER JOIN opcion o ON o.id_opcion = oe.id_opcion_opcion_eleccion "
                    + "WHERE oe.id_eleccion_opcion_eleccion = :idEleccion "
                    + "GROUP BY o.id_opcion, o.nombre_opcion, o.url_opcion ) as p "
                    + "ORDER BY p.cantidad desc");
            query.setParameter("idEleccion", idEleccion);
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println("Error obteniendo cantida de votos de elección. Desc: " + ex.getMessage());
        }
        return new ArrayList<>();

    }
}
