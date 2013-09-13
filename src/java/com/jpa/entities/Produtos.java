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
import javax.persistence.Lob;
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
@Table(name = "produtos")
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByIdProdutos", query = "SELECT p FROM Produtos p WHERE p.idProdutos = :idProdutos"),
    @NamedQuery(name = "Produtos.findByNome", query = "SELECT p FROM Produtos p WHERE p.nome = :nome")})
public class Produtos implements Serializable {
    @Lob
    @Column(name = "imagem")
    private byte[] imagem;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idProdutos", nullable = false)
    private Integer idProdutos;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nome", nullable = false, length = 200)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produtos")
    private Collection<Itenslistacompras> itenslistacomprasCollection;

    public Produtos() {
    }

    public Produtos(Integer idProdutos) {
        this.idProdutos = idProdutos;
    }

    public Produtos(Integer idProdutos, String nome) {
        this.idProdutos = idProdutos;
        this.nome = nome;
    }

    public Integer getIdProdutos() {
        return idProdutos;
    }

    public void setIdProdutos(Integer idProdutos) {
        this.idProdutos = idProdutos;
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
        hash += (idProdutos != null ? idProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.idProdutos == null && other.idProdutos != null) || (this.idProdutos != null && !this.idProdutos.equals(other.idProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idProdutos + " - " + nome;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
    
}
