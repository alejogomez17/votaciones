package com.desarrollo.votaciones.api.datos.dominio;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Alejo Gómez
 */
@Entity
@Table(name = "eleccion")
@NamedQueries({
    @NamedQuery(name = "Eleccion.findByEstado", query = ""
            + "SELECT e "
            + "FROM Eleccion e "
            + "WHERE e.estado = :estado ")
})
public class Eleccion implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "id_eleccion")
    private Integer id;

    @Column(name = "nombre_eleccion")
    private String nombre;

    @Column(name = "inicio_eleccion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT-05:00")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date inicio;

    @Column(name = "fin_eleccion")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT-05:00")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fin;

    @Column(name = "estado_eleccion")
    private Character estado;

    public Eleccion() {
    }

    public Eleccion(Integer id, String nombre, Date inicio, Date fin, Character estado) {
        this.id = id;
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

}
