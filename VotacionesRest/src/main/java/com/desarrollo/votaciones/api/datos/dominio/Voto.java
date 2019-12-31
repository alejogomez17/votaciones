package com.desarrollo.votaciones.api.datos.dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author Alejo Gómez
 */
@Entity
@Table(name = "voto")
public class Voto implements Serializable{
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_voto")
    private Integer id;
    
    @Column(name = "fecha_voto")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "ip_voto")
    private String ip;

    public Voto() {
    }
    
    public Voto(Date fecha, String ip) {
        this.id = id;
        this.fecha = fecha;
        this.ip = ip;
    }

    public Voto(Integer id, Date fecha, String ip) {
        this.id = id;
        this.fecha = fecha;
        this.ip = ip;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    
    
    
}
