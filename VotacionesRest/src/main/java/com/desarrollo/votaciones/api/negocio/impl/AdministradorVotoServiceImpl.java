package com.desarrollo.votaciones.api.negocio.impl;

import com.desarrollo.votaciones.api.datos.dao.VotoDao;
import com.desarrollo.votaciones.api.datos.dao.VotoOpcionEleccionDao;
import com.desarrollo.votaciones.api.datos.dominio.Voto;
import com.desarrollo.votaciones.api.datos.dominio.VotoOpcionEleccion;
import com.desarrollo.votaciones.api.negocio.control.AdministradorVotoService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alejo Gómez
 */
public class AdministradorVotoServiceImpl implements AdministradorVotoService {

    @Autowired
    private VotoDao votoDaoImpl;

    @Autowired
    private VotoOpcionEleccionDao votoOpcionEleccionDaoImpl;

    @Transactional
    @Override
    public boolean generarVoto(Integer idEleccion, String ip) {
        try {

            Voto voto = new Voto(new Date(), ip);
            voto = this.votoDaoImpl.save(voto);
            VotoOpcionEleccion votoOpcionEleccion = new VotoOpcionEleccion(voto.getId(), idEleccion);
            this.votoOpcionEleccionDaoImpl.save(votoOpcionEleccion);
            return true;
        } catch (Exception ex) {
            System.out.println("Error guardando voto. Desc: " + ex.getMessage());
        }
        return false;
    }
}
