/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_integracji;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Warstwa_Biznesowa.EgzemplarzSamochodu;
import Warstwa_Biznesowa.ModelSamochodu;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Falco
 */
public class EgzemplarzSamochoduController {
    private EntityManagerFactory emf = null;
    
    private EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("WypozyczalniaSamochodowPU");
        }
        return emf.createEntityManager();
    }
    
    public EgzemplarzSamochodu[] getEgzemlarzeSamochodu_() {
        return (EgzemplarzSamochodu[]) getEgzemplarzeSamochodu().toArray(new EgzemplarzSamochodu[0]);    }
    
    public List<EgzemplarzSamochodu> getEgzemplarzeSamochodu() {
        EntityManager em = getEntityManager();
        try {
        javax.persistence.Query q = em.createQuery("select c from EgzemplarzSamochodu as c");
        return q.getResultList();
        } finally {
        em.close();
        }
    }
    
    public boolean addEgzemplarzSamochodu(EgzemplarzSamochodu egzemplarz){
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(egzemplarz);
            em.getTransaction().commit();
        }
        finally{
            em.close();
            return false;
        }
    }
    
    public boolean addEgzemplarzeSamochodu(ArrayList<ModelSamochodu> modele){
        EntityManager em = getEntityManager();
        EgzemplarzSamochodu egzemplarz = null;
        Iterator it = modele.iterator();
        em.getTransaction().begin();
        try{
            while (it.hasNext()){
                ModelSamochodu model = (ModelSamochodu) it.next();
                if (model.getId() == null) {
                    continue;
                }
                Iterator it_ = model.getEgzemplarzeModelu().iterator();
                while (it_.hasNext()){
                    egzemplarz = (EgzemplarzSamochodu) it_.next();
                    if(egzemplarz.getId() == null)
                    {
                        em.persist(egzemplarz);
                    }
                    
                }
            }
            em.getTransaction().commit();
        }
        finally{
            em.close();
            return false;
        }
    }
}
