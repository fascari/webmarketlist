/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jpa.entities.Produtos;

/**
 *
 * @author Felipe
 */
@Stateless
public class ProdutosFacade extends AbstractFacade<Produtos> {
    @PersistenceContext(unitName = "WebMarketListPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProdutosFacade() {
        super(Produtos.class);
    }
    
}
