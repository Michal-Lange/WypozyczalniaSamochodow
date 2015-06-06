/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_integracji;

import Warstwa_Biznesowa.EgzemplarzSamochodu;
import Warstwa_Biznesowa.Fasada;
import Warstwa_Biznesowa.ModelSamochodu;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Falco
 */
public class Base {
    ModelSamochoduController modelJpaController;
    EgzemplarzSamochoduController egzemplarzJpaController;
    
    Fasada fasada;
    ModelSamochodu[] modeleSamochodow;
    EgzemplarzSamochodu[] egzemplarzeSamochodu;
    
    public Base(Fasada fasada){
        this.fasada = fasada;
        modelJpaController = new ModelSamochoduController();
        egzemplarzJpaController = new EgzemplarzSamochoduController();
        try{
            update_data();
        } 
        catch(Exception e){
        }
    }

    public void update_data() throws Exception{
        update_modele();
        upsate_egzemplarze();
        fasada.update_data(modeleSamochodow, egzemplarzeSamochodu);
    }

    public void update_modele() throws Exception{
        modeleSamochodow = (ModelSamochodu[]) modelJpaController.getTModeleSamochodu_();
    }

    private void upsate_egzemplarze() throws Exception{
        egzemplarzeSamochodu = (EgzemplarzSamochodu[]) egzemplarzJpaController.getEgzemlarzeSamochodu_();
    }
    
    public void add_modele() throws Exception {
        try {
            modelJpaController.addModeleSamochodow(fasada.getModeleSamochodow());
        } catch (Exception e) {
        }
    }
    
    public void add_egzemplarze() throws Exception {
        try {
            egzemplarzJpaController.addEgzemplarzeSamochodu(fasada.getModeleSamochodow());
        } catch (Exception e) {
        }
    }
    
    public ArrayList<ArrayList<String>> modele() throws Exception {
        List<ModelSamochodu> help1 = modelJpaController.getModeleSamochodu();
        ArrayList<ArrayList<String>> help2 = new ArrayList();
        for (ModelSamochodu t : help1) {
            ArrayList<String> help3 = new ArrayList();
            help3.add(t.getModel());
            help3.add(t.getMarka());
            help3.add(Integer.toString(t.getIloscMiejsc()));
            help2.add(help3);
        }
        return help2;
    }   
}
