/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.jpa.entities.Itenslistacompras;

/**
 *
 * @author Felipe
 */
@Stateless
public class ItenslistacomprasFacade extends AbstractFacade<Itenslistacompras> {
    @PersistenceContext(unitName = "WebMarketListPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ItenslistacomprasFacade() {
        super(Itenslistacompras.class);
    }
    
    public List<Itenslistacompras> getItemsByList(Integer codListaCompras){
        Query query = em.createNamedQuery("Itenslistacompras.findByIdListaComprasComprados");
        query.setParameter("idListaCompras", codListaCompras);
        query.setParameter("comprado", 'N');
        return query.getResultList();
    }
}
