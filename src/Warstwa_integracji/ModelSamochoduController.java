/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_integracji;

import Warstwa_Biznesowa.ModelSamochodu;
import java.util.ArrayList;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Falco
 */
public class ModelSamochoduController {
    private EntityManagerFactory emf = null;
    
    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("WypozyczalniaSamochodowPU");
        }
        return emf.createEntityManager();
    }
    
    public boolean addModelSamochodu(ModelSamochodu modelSamochodu) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(modelSamochodu);
            em.getTransaction().commit();
        } 
        finally {
            em.close();
            return false;
        }
    }
    
    public boolean addModeleSamochodow(ArrayList<ModelSamochodu> modeleSamochodow) {
        EntityManager em = getEntityManager();
        ModelSamochodu nowyModel = null;
        try {
            Iterator it = modeleSamochodow.iterator();
            em.getTransaction().begin();
            while (it.hasNext()) {
                nowyModel = (ModelSamochodu) it.next();
                if (nowyModel.getId() == null) {
                    em.persist(nowyModel);
                }
            }
            em.getTransaction().commit();
        } finally {
            em.close();
            return false;
        }
    }
}
