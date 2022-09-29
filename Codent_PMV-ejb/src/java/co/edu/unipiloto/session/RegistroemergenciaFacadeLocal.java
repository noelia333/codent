/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.session;

import co.edu.unipiloto.entitys.Registroemergencia;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Noelia
 */
@Local
public interface RegistroemergenciaFacadeLocal {

    void create(Registroemergencia registroemergencia);

    void edit(Registroemergencia registroemergencia);

    void remove(Registroemergencia registroemergencia);

    Registroemergencia find(Object id);

    List<Registroemergencia> findAll();

    List<Registroemergencia> findRange(int[] range);

    int count();
    
}
