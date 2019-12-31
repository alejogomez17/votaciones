package com.desarrollo.votaciones.api.datos.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Alejo Gómez
 */
@Entity
@Table(name = "opcion_eleccion")
@NamedQueries({
    @NamedQuery(name = "OpcionEleccion.findByIdEleccion", query = ""
            + "SELECT o "
            + "FROM OpcionEleccion o "
            + "WHERE o.idEleccion = :idEleccion ")
})
public class OpcionEleccion implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_opcion_eleccion")
    private Integer id;
    
    @JoinColumn(name = "id_opcion_opcion_eleccion")
    @ManyToOne
    private Opcion idOpcion;
    
    @Column(name = "id_eleccion_opcion_eleccion")
    private Integer idEleccion;
    
    @Column(name = "orden_opcion_eleccion")
    private Integer orden;

    public OpcionEleccion() {
    }

    public OpcionEleccion(Integer id, Opcion idOpcion, Integer idEleccion, Integer orden) {
        this.id = id;
        this.idOpcion = idOpcion;
        this.idEleccion = idEleccion;
        this.orden = orden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Opcion getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(Opcion idOpcion) {
        this.idOpcion = idOpcion;
    }

    public Integer getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(Integer idEleccion) {
        this.idEleccion = idEleccion;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }
    
}
