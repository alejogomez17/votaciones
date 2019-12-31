package com.desarrollo.votaciones.api;

import com.desarrollo.votaciones.api.datos.dominio.Eleccion;
import com.desarrollo.votaciones.api.datos.dominio.OpcionEleccion;
import com.desarrollo.votaciones.api.modelo.respuesta.ResultadoEleccion;
import com.desarrollo.votaciones.api.negocio.control.AdministradorEleccionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejo Gomez
 */
@RestController
@RequestMapping("/eleccion")
public class EleccionController {

    @Autowired
    private AdministradorEleccionesService administradorEleccionesServiceImpl;

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Eleccion> saludar() {
        return this.administradorEleccionesServiceImpl.obtenerEleccionesActivas();
    }  
    
    @CrossOrigin
    @RequestMapping(path = "/resultados/{idEleccion}", method = RequestMethod.GET, produces = "application/json")
    public ResultadoEleccion saludar(@PathVariable("idEleccion") Integer idEleccion) {
        return this.administradorEleccionesServiceImpl.obtenerResultadosDeEleccion(idEleccion);
    }
}
