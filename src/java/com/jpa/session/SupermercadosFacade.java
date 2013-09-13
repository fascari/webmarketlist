/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jpa.entities.Supermercados;

/**
 *
 * @author Felipe
 */
@Stateless
public class SupermercadosFacade extends AbstractFacade<Supermercados> {
    @PersistenceContext(unitName = "WebMarketListPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SupermercadosFacade() {
        super(Supermercados.class);
    }
    
}
