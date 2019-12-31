package com.desarrollo.votaciones.api;

import com.desarrollo.votaciones.api.datos.dominio.OpcionEleccion;
import com.desarrollo.votaciones.api.modelo.peticion.VotoOpcion;
import com.desarrollo.votaciones.api.modelo.respuesta.RespuestaGeneral;
import com.desarrollo.votaciones.api.negocio.control.AdministradorVotoService;
import com.desarrollo.votaciones.api.utilidades.Comunes;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejo Gómez
 */
@RestController
@RequestMapping("/voto")
public class VotoController {

    @Autowired
    private AdministradorVotoService administradorVotoServiceImpl;
    
    @CrossOrigin
    @RequestMapping(path = "/generar", method = RequestMethod.POST, consumes = "application/json")
    public RespuestaGeneral verificarRegistrosDeIngresoDeArchivo(HttpServletRequest request, @RequestBody VotoOpcion peticion) {
        String ip = Comunes.getClientIp(request);
        boolean resp = this.administradorVotoServiceImpl.generarVoto(peticion.getIdEleccion(), ip);
        return new RespuestaGeneral(resp);
    }
}
