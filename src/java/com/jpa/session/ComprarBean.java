/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpa.session;

import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import com.jpa.entities.Itenslistacompras;
import com.jsf.util.JsfUtil;

/**
 *
 * @author Felipe
 */
@ManagedBean
@ViewScoped
public class ComprarBean {

    private Itenslistacompras itemCompra;
    private double totalCompra;
    private DataModel itenslistacompras;
    @EJB
    private com.jpa.session.ItenslistacomprasFacade ejbFacade;

    public ComprarBean() {
    }

    @PostConstruct
    public void iniciar() {
        if (itemCompra == null) {
            itemCompra = new Itenslistacompras(new com.jpa.entities.ItenslistacomprasPK());
        }
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public Itenslistacompras getItemCompra() {
        return itemCompra;
    }

    public void setItemCompra(Itenslistacompras itemCompra) {
        this.itemCompra = itemCompra;
    }

    public DataModel getItenslistacompras() {
        return itenslistacompras;
    }

    public void setItenslistacompras(DataModel itenslistacompras) {
        this.itenslistacompras = itenslistacompras;
    }

    public ItenslistacomprasFacade getEjbFacade() {
        return ejbFacade;
    }

    public void setEjbFacade(ItenslistacomprasFacade ejbFacade) {
        this.ejbFacade = ejbFacade;
    }

    public DataModel filterItemsByList() {
        itenslistacompras = new ListDataModel(ejbFacade.getItemsByList(itemCompra.getListacompras().getIdListaCompras()));
        return itenslistacompras;
    }

    public String comprar() {
        try {
            if (itenslistacompras != null) {
                for (Object item : itenslistacompras) {
                    getEjbFacade().edit((Itenslistacompras) item);
                }
                JsfUtil.addSuccessMessage(ResourceBundle.getBundle("resources/Bundle_pt_BR").getString("CompraRealizada"));
            }
            return "Comprar";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("resources/Bundle_pt_BR").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public void calculaTotalCompra() {
        totalCompra = 0;
        if (itenslistacompras != null) {
            for (Object item : itenslistacompras) {
                Itenslistacompras itemLista = (Itenslistacompras) item;
                if (itemLista.isCompradoBoolean()) {
                    totalCompra += (itemLista.getValor().doubleValue() * itemLista.getQuantidade());

                }
            }
        }
    }
}
