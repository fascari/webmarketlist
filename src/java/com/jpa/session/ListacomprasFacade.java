/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.jpa.entities.Listacompras;

/**
 *
 * @author Felipe
 */
@Stateless
public class ListacomprasFacade extends AbstractFacade<Listacompras> {
    @PersistenceContext(unitName = "WebMarketListPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ListacomprasFacade() {
        super(Listacompras.class);
    }
    
}
