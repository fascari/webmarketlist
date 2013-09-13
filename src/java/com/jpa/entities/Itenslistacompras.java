/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Felipe
 */
@Entity
@Table(name = "itenslistacompras")
@NamedQueries({
    @NamedQuery(name = "Itenslistacompras.findAll", query = "SELECT i FROM Itenslistacompras i"),
    @NamedQuery(name = "Itenslistacompras.findByIdListaCompras", query = "SELECT i FROM Itenslistacompras i WHERE i.itenslistacomprasPK.idListaCompras = :idListaCompras"),
    @NamedQuery(name = "Itenslistacompras.findByIdListaComprasComprados",
            query = "SELECT i FROM Itenslistacompras i WHERE i.itenslistacomprasPK.idListaCompras = :idListaCompras and i.comprado = :comprado"),
    @NamedQuery(name = "Itenslistacompras.findByIdProdutos", query = "SELECT i FROM Itenslistacompras i WHERE i.itenslistacomprasPK.idProdutos = :idProdutos"),
    @NamedQuery(name = "Itenslistacompras.findByQuantidade", query = "SELECT i FROM Itenslistacompras i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "Itenslistacompras.findByValor", query = "SELECT i FROM Itenslistacompras i WHERE i.valor = :valor")})
public class Itenslistacompras implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "comprado", nullable = false)
    private char comprado;
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItenslistacomprasPK itenslistacomprasPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor", nullable = false, precision = 12, scale = 2)
    private BigDecimal valor;
    @JoinColumn(name = "idSupermercados", referencedColumnName = "idSupermercados")
    @ManyToOne
    private Supermercados idSupermercados;
    @JoinColumn(name = "idProdutos", referencedColumnName = "idProdutos", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produtos produtos;
    @JoinColumn(name = "idListaCompras", referencedColumnName = "idListaCompras", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Listacompras listacompras;

    public Itenslistacompras() {
    }

    public Itenslistacompras(ItenslistacomprasPK itenslistacomprasPK) {
        this.itenslistacomprasPK = itenslistacomprasPK;
    }

    public Itenslistacompras(ItenslistacomprasPK itenslistacomprasPK, int quantidade, BigDecimal valor) {
        this.itenslistacomprasPK = itenslistacomprasPK;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Itenslistacompras(int idListaCompras, int idProdutos) {
        this.itenslistacomprasPK = new ItenslistacomprasPK(idListaCompras, idProdutos);
    }

    public ItenslistacomprasPK getItenslistacomprasPK() {
        return itenslistacomprasPK;
    }

    public void setItenslistacomprasPK(ItenslistacomprasPK itenslistacomprasPK) {
        this.itenslistacomprasPK = itenslistacomprasPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Supermercados getIdSupermercados() {
        return idSupermercados;
    }

    public void setIdSupermercados(Supermercados idSupermercados) {
        this.idSupermercados = idSupermercados;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Listacompras getListacompras() {
        return listacompras;
    }

    public void setListacompras(Listacompras listacompras) {
        this.listacompras = listacompras;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itenslistacomprasPK != null ? itenslistacomprasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itenslistacompras)) {
            return false;
        }
        Itenslistacompras other = (Itenslistacompras) object;
        if ((this.itenslistacomprasPK == null && other.itenslistacomprasPK != null) || (this.itenslistacomprasPK != null && !this.itenslistacomprasPK.equals(other.itenslistacomprasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Itenslistacompras[ itenslistacomprasPK=" + itenslistacomprasPK + " ]";
    }

    public char getComprado() {
        return comprado;
    }

    public void setComprado(char comprado) {
        this.comprado = comprado;
    }

    public void setCompradoBoolean(boolean comprado) {
        this.comprado = (comprado) ? 'S' : 'N';
    }

    public boolean isCompradoBoolean() {
        return (comprado == 'S');
    }
}
