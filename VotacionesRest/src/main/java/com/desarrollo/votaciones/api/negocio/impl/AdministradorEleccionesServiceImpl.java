package com.desarrollo.votaciones.api.negocio.impl;

import com.desarrollo.votaciones.api.datos.dao.EleccionDao;
import com.desarrollo.votaciones.api.datos.dominio.Eleccion;
import com.desarrollo.votaciones.api.modelo.respuesta.EleccionModel;
import com.desarrollo.votaciones.api.modelo.respuesta.OpcionResultado;
import com.desarrollo.votaciones.api.modelo.respuesta.ResultadoEleccion;
import com.desarrollo.votaciones.api.negocio.control.AdministradorEleccionesService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Alejo Gómez
 */
public class AdministradorEleccionesServiceImpl implements AdministradorEleccionesService {

    @Autowired
    private EleccionDao eleccionDaoImpl;

    @Override
    public List<Eleccion> obtenerEleccionesActivas() {
        return this.eleccionDaoImpl.obtenerEleccionesActivas();
    }

    @Override
    public ResultadoEleccion obtenerResultadosDeEleccion(Integer idEleccion) {
        List<OpcionResultado> opcionesResultado = new ArrayList<>();
        List<Object[]> resultados = this.eleccionDaoImpl.obtenerResumenDeVotosPorEleccion(idEleccion);
        if (!resultados.isEmpty()) {
            for (Object[] resultado : resultados) {
                opcionesResultado.add(new OpcionResultado(
                        String.valueOf(resultado[1]),
                        String.valueOf(resultado[2]),
                        Integer.parseInt(String.valueOf(resultado[3])))
                );
            }
        }
        return new ResultadoEleccion(opcionesResultado);
    }
}
