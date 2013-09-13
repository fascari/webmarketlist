/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "listacompras")
@NamedQueries({
    @NamedQuery(name = "Listacompras.findAll", query = "SELECT l FROM Listacompras l"),
    @NamedQuery(name = "Listacompras.findByIdListaCompras", query = "SELECT l FROM Listacompras l WHERE l.idListaCompras = :idListaCompras"),
    @NamedQuery(name = "Listacompras.findByDescricao", query = "SELECT l FROM Listacompras l WHERE l.descricao = :descricao")})
public class Listacompras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idListaCompras", nullable = false)
    private Integer idListaCompras;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descricao", nullable = false, length = 200)
    private String descricao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "listacompras")
    private Collection<Itenslistacompras> itenslistacomprasCollection;

    public Listacompras() {
    }

    public Listacompras(Integer idListaCompras) {
        this.idListaCompras = idListaCompras;
    }

    public Listacompras(Integer idListaCompras, String descricao) {
        this.idListaCompras = idListaCompras;
        this.descricao = descricao;
    }

    public Integer getIdListaCompras() {
        return idListaCompras;
    }

    public void setIdListaCompras(Integer idListaCompras) {
        this.idListaCompras = idListaCompras;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Collection<Itenslistacompras> getItenslistacomprasCollection() {
        return itenslistacomprasCollection;
    }

    public void setItenslistacomprasCollection(Collection<Itenslistacompras> itenslistacomprasCollection) {
        this.itenslistacomprasCollection = itenslistacomprasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idListaCompras != null ? idListaCompras.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Listacompras)) {
            return false;
        }
        Listacompras other = (Listacompras) object;
        if ((this.idListaCompras == null && other.idListaCompras != null) || (this.idListaCompras != null && !this.idListaCompras.equals(other.idListaCompras))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idListaCompras + " - " + descricao;
    }
}
