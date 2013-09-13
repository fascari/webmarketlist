package com.jpa.entities;

import com.jpa.entities.ItenslistacomprasPK;
import com.jpa.entities.Listacompras;
import com.jpa.entities.Produtos;
import com.jpa.entities.Supermercados;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-09-12T22:58:20")
@StaticMetamodel(Itenslistacompras.class)
public class Itenslistacompras_ { 

    public static volatile SingularAttribute<Itenslistacompras, Listacompras> listacompras;
    public static volatile SingularAttribute<Itenslistacompras, Integer> quantidade;
    public static volatile SingularAttribute<Itenslistacompras, Supermercados> idSupermercados;
    public static volatile SingularAttribute<Itenslistacompras, Produtos> produtos;
    public static volatile SingularAttribute<Itenslistacompras, Character> comprado;
    public static volatile SingularAttribute<Itenslistacompras, BigDecimal> valor;
    public static volatile SingularAttribute<Itenslistacompras, ItenslistacomprasPK> itenslistacomprasPK;

}