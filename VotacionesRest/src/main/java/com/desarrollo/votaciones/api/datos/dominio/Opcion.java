package com.desarrollo.votaciones.api.datos.dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Alejo Gómez
 */
@Entity
@Table(name = "opcion")
public class Opcion implements Serializable{
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_opcion")
    private Integer id;
    
    @Column(name = "nombre_opcion")
    private String nombre;
    
    @Column(name = "url_opcion")
    private String url;

    public Opcion() {
    }

    public Opcion(Integer id, String nombre, String url) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
