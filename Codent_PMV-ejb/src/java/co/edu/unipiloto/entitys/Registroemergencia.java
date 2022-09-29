/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.entitys;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Noelia
 */
@Entity
@Table(name = "REGISTROEMERGENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroemergencia.findAll", query = "SELECT r FROM Registroemergencia r"),
    @NamedQuery(name = "Registroemergencia.findByIdemergencia", query = "SELECT r FROM Registroemergencia r WHERE r.idemergencia = :idemergencia"),
    @NamedQuery(name = "Registroemergencia.findByDescripcion", query = "SELECT r FROM Registroemergencia r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Registroemergencia.findByEstado", query = "SELECT r FROM Registroemergencia r WHERE r.estado = :estado")})
public class Registroemergencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDEMERGENCIA")
    private Integer idemergencia;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private Boolean estado;

    public Registroemergencia() {
    }

    public Registroemergencia(Integer idemergencia, String descripcion, Boolean estado) {
        this.idemergencia = idemergencia;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Registroemergencia(Integer idemergencia) {
        this.idemergencia = idemergencia;
    }

    public Integer getIdemergencia() {
        return idemergencia;
    }

    public void setIdemergencia(Integer idemergencia) {
        this.idemergencia = idemergencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idemergencia != null ? idemergencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroemergencia)) {
            return false;
        }
        Registroemergencia other = (Registroemergencia) object;
        if ((this.idemergencia == null && other.idemergencia != null) || (this.idemergencia != null && !this.idemergencia.equals(other.idemergencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.entitys.Registroemergencia[ idemergencia=" + idemergencia + " ]";
    }
    
}
