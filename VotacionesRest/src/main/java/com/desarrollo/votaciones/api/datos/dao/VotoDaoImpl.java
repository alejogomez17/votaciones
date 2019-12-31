package com.desarrollo.votaciones.api.datos.dao;

import com.desarrollo.votaciones.api.datos.dominio.Voto;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo Gómez
 */
public class VotoDaoImpl implements VotoDao {
    
    @Autowired
    private EntityManager entityManager;
    
    @Transactional
    @Override
    public Voto save(Voto voto){
        return this.entityManager.merge(voto);
    }
}
