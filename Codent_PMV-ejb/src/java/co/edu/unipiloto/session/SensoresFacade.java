/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entitys.Sensores;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Noelia
 */
@Stateless
public class SensoresFacade extends AbstractFacade<Sensores> implements SensoresFacadeLocal {

    @PersistenceContext(unitName = "registroEmergenciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SensoresFacade() {
        super(Sensores.class);
    }
    
}
