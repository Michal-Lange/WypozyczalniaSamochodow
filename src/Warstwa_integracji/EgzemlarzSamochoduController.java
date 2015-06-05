/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_integracji;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Falco
 */
public class EgzemlarzSamochoduController {
    private EntityManagerFactory emf = null;
    
    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("WypozyczalniaSamochodowPU");
        }
        return emf.createEntityManager();
    } 
}
