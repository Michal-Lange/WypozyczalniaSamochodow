/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_Biznesowa;

import java.util.ArrayList;

/**
 *
 * @author Falco
 */
public class Fasada {
    private ArrayList<ModelSamochodu> modeleSamochodow;
    private ArrayList<Klient> klienci;
    
    private ModelSamochodu modelSamochodu;
    public Fasada(){
        modeleSamochodow = new ArrayList<>();
        klienci = new ArrayList<>();
        
    }
    
    public ArrayList<ModelSamochodu> getModeleSamochodow() {
        return modeleSamochodow;
    }
    
    void setModeleSamochodow(ArrayList<ModelSamochodu> modele) {
        modeleSamochodow = modele;
    }
    public void dodajModelSamochodu(String dane[])
    {
        modelSamochodu = new ModelSamochodu();
        modelSamochodu.setMarka(dane[0]);
        modelSamochodu.setModel(dane[1]);
        modelSamochodu.setIloscMiejsc(Integer.parseInt(dane[2]));
    }
    public ModelSamochodu getModelSamochodu(){
        return modelSamochodu;
    }
    public void setModelSamochodu(ModelSamochodu val){
        this.modelSamochodu = val;
    }
    
    public boolean addModelSamochodu(String data[])
    {
        ModelSamochodu modelSamochodu = new ModelSamochodu();
        if(data != null && modelSamochodu !=null)
        {
            modelSamochodu.setMarka(data[0]);
            modelSamochodu.setModel(data[1]);
            modelSamochodu.setIloscMiejsc(Integer.parseInt(data[2]));
            return addModelSamochodu(modelSamochodu);
        }
        else
        {
            return false;
        }
    }
    public boolean addModelSamochodu(ModelSamochodu modelSamochodu)
    {
        if(modelSamochodu != null)
        {
            if(modeleSamochodow.contains(modelSamochodu))
            {
                return false;
            }
            else
            {
                modeleSamochodow.add(modelSamochodu);
                return true;
            }
        }
        return false;
    }
    
     public EgzemplarzSamochodu addEgzemplarzSamochodu (String dane[], ModelSamochodu modelSamochodu)
    {  
        EgzemplarzSamochodu egzemplarzSamochodu = new EgzemplarzSamochodu();
        if(dane!=null && modelSamochodu!=null && egzemplarzSamochodu!=null)
        {
            egzemplarzSamochodu.setModelSamochodu(modelSamochodu);
            egzemplarzSamochodu.setNrRejstracyjny(dane[0]);
            egzemplarzSamochodu.setRokProdukcji(dane[1]);
            egzemplarzSamochodu.setRodzajPaliwa(dane[2]);
            egzemplarzSamochodu.setTypNadwozia(dane[3]);
            egzemplarzSamochodu.setPojemoscSilnika(Integer.parseInt(dane[4]));
            return modelSamochodu.addEgzemplarzSamochodu(egzemplarzSamochodu);
        }
        return null;
    }
    

    /**
     * @return the klienci
     */
    public ArrayList<Klient> getKlienci() {
        return klienci;
    }

    /**
     * @param klienci the klienci to set
     */
    public void setKlienci(ArrayList<Klient> klienci) {
        this.klienci = klienci;
    }
}


