/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "supermercados")
@NamedQueries({
    @NamedQuery(name = "Supermercados.findAll", query = "SELECT s FROM Supermercados s"),
    @NamedQuery(name = "Supermercados.findByIdSupermercados", query = "SELECT s FROM Supermercados s WHERE s.idSupermercados = :idSupermercados"),
    @NamedQuery(name = "Supermercados.findByNome", query = "SELECT s FROM Supermercados s WHERE s.nome = :nome")})
public class Supermercados implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSupermercados", nullable = false)
    private Integer idSupermercados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome", nullable = false, length = 200)
    private String nome;
    @OneToMany(mappedBy = "idSupermercados")
    private Collection<Itenslistacompras> itenslistacomprasCollection;

    public Supermercados() {
    }

    public Supermercados(Integer idSupermercados) {
        this.idSupermercados = idSupermercados;
    }

    public Supermercados(Integer idSupermercados, String nome) {
        this.idSupermercados = idSupermercados;
        this.nome = nome;
    }

    public Integer getIdSupermercados() {
        return idSupermercados;
    }

    public void setIdSupermercados(Integer idSupermercados) {
        this.idSupermercados = idSupermercados;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (idSupermercados != null ? idSupermercados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Supermercados)) {
            return false;
        }
        Supermercados other = (Supermercados) object;
        if ((this.idSupermercados == null && other.idSupermercados != null) || (this.idSupermercados != null && !this.idSupermercados.equals(other.idSupermercados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idSupermercados + " - " + nome;
    }
    
}
