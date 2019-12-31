package com.desarrollo.votaciones.api.datos.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alejo Gómez
 */
@Entity
@Table(name = "voto_opcion_eleccion")
public class VotoOpcionEleccion implements Serializable{
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto_opcion_eleccion")
    private Integer id;
    
    @Column(name = "id_voto_voto_opcion_eleccion")
    private Integer idVoto;
    
    @Column(name = "id_opcion_eleccion_voto_opcion_eleccion")
    private Integer idOpcionEleccion;

    public VotoOpcionEleccion() {
    }
    
    public VotoOpcionEleccion(Integer idVoto, Integer idOpcion) {
        this.idVoto = idVoto;
        this.idOpcionEleccion = idOpcion;
    }

    public VotoOpcionEleccion(Integer idVotoOpcionEleccion, Integer idVoto, Integer idOpcion) {
        this.id = idVotoOpcionEleccion;
        this.idVoto = idVoto;
        this.idOpcionEleccion = idOpcion;
    }

    public Integer getIdVotoOpcionEleccion() {
        return id;
    }

    public void setIdVotoOpcionEleccion(Integer idVotoOpcionEleccion) {
        this.id = idVotoOpcionEleccion;
    }

    public Integer getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public Integer getIdOpcion() {
        return idOpcionEleccion;
    }

    public void setIdOpcion(Integer idOpcion) {
        this.idOpcionEleccion = idOpcion;
    }
    
}
