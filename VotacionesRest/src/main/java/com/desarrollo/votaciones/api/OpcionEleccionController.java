package com.desarrollo.votaciones.api;

import com.desarrollo.votaciones.api.datos.dominio.Eleccion;
import com.desarrollo.votaciones.api.datos.dominio.OpcionEleccion;
import com.desarrollo.votaciones.api.negocio.control.AdministradorOpcionEleccionService;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejo Gómez
 */
@RestController
@RequestMapping("/opcionEleccion")
public class OpcionEleccionController {
    
    @Autowired
    private AdministradorOpcionEleccionService administradorOpcionEleccionServiceImpl;

    @CrossOrigin
    @RequestMapping(path = "/eleccion/{idEleccion}", method = RequestMethod.GET, produces = "application/json")
    public List<OpcionEleccion> saludar(@PathVariable("idEleccion") Integer idEleccion) {
        return this.administradorOpcionEleccionServiceImpl.obtenerOpcionesEleccionPorEleccion(idEleccion);
    }
}
