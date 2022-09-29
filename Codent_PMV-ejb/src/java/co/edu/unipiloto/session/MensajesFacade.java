/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entitys.Mensajes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Noelia
 */
@Stateless
public class MensajesFacade extends AbstractFacade<Mensajes> implements MensajesFacadeLocal {

    @PersistenceContext(unitName = "registroEmergenciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MensajesFacade() {
        super(Mensajes.class);
    }
    
}
