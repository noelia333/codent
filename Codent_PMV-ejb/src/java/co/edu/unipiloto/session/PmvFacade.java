/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entitys.Pmv;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Noelia
 */
@Stateless
public class PmvFacade extends AbstractFacade<Pmv> implements PmvFacadeLocal {

    @PersistenceContext(unitName = "registroEmergenciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PmvFacade() {
        super(Pmv.class);
    }
    
}
