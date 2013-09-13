/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Felipe
 */
@Embeddable
public class ItenslistacomprasPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idListaCompras", nullable = false)
    private int idListaCompras;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idProdutos", nullable = false)
    private int idProdutos;

    public ItenslistacomprasPK() {
    }

    public ItenslistacomprasPK(int idListaCompras, int idProdutos) {
        this.idListaCompras = idListaCompras;
        this.idProdutos = idProdutos;
    }

    public int getIdListaCompras() {
        return idListaCompras;
    }

    public void setIdListaCompras(int idListaCompras) {
        this.idListaCompras = idListaCompras;
    }

    public int getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(int idProdutos) {
        this.idProdutos = idProdutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idListaCompras;
        hash += (int) idProdutos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItenslistacomprasPK)) {
            return false;
        }
        ItenslistacomprasPK other = (ItenslistacomprasPK) object;
        if (this.idListaCompras != other.idListaCompras) {
            return false;
        }
        if (this.idProdutos != other.idProdutos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.ItenslistacomprasPK[ idListaCompras=" + idListaCompras + ", idProdutos=" + idProdutos + " ]";
    }
    
}
