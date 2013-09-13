package com.jpa.entities;

import com.jpa.entities.Itenslistacompras;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-09-12T22:58:20")
@StaticMetamodel(Produtos.class)
public class Produtos_ { 

    public static volatile CollectionAttribute<Produtos, Itenslistacompras> itenslistacomprasCollection;
    public static volatile SingularAttribute<Produtos, byte[]> imagem;
    public static volatile SingularAttribute<Produtos, String> nome;
    public static volatile SingularAttribute<Produtos, Integer> idProdutos;

}