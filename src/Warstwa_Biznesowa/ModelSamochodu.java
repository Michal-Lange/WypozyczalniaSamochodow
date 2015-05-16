/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_Biznesowa;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Falco
 */
public class ModelSamochodu {
    private String marka;
    private String model;
    private int iloscMiejsc;
    private ArrayList<Rezerwacja> rezerwacjeModelu;
    private ArrayList<EgzemplarzSamochodu> egzemplarzeSamochodu;
    
    public ModelSamochodu()
    {
        rezerwacjeModelu = new ArrayList<>();
        egzemplarzeSamochodu = new ArrayList<>();
    }
    
    //private ArrayList<Rezerwacja> rezerwacje = new ArrayList<Rezerwacja>();
   /* public ArrayList<String> dodajModelSamochodu(String data[])
    {
        Factory factory = new Factory();
        EgzemplarzSamochodu nowyEgzemplarzSamochodu;
        nowyEgzemplarzSamochodu = factory.utworzEgzemplarzSamochodu(data);
        if(szukajEgzemplarzSamodchodu(nowyEgzemplarzSamochodu) == null){
            
        }
    } */

    /**
     * @return the marka
     */
    
    public EgzemplarzSamochodu addEgzemplarzSamochodu(EgzemplarzSamochodu egzemplarzSamochodu) {
        if(egzemplarzeSamochodu.contains(egzemplarzSamochodu))
        {
            return null;
        }
        else
        {
            egzemplarzeSamochodu.add(egzemplarzSamochodu);
            return egzemplarzSamochodu;
        }
    }
    
    boolean addRezerwacja(Rezerwacja rezerwacja){
        return rezerwacjeModelu.add(rezerwacja);
    }

    
    public String getMarka() {
        return marka;
    }

    /**
     * @param marka the marka to set
     */
    public void setMarka(String marka) {
        this.marka = marka;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the iloscMiejsc
     */
    public int getIloscMiejsc() {
        return iloscMiejsc;
    }

    /**
     * @param iloscMiejsc the iloscMiejsc to set
     */
    public void setIloscMiejsc(int iloscMiejsc) {
        this.iloscMiejsc = iloscMiejsc;
    }
    
    @Override
    public String toString() {
        return getMarka()
                + ",  " + getModel()
                + ", Ilosc miejsc: " + getIloscMiejsc();
    }
    
    
    @Override
    public boolean equals(Object ob){
        String markaSamochodu1 = this.getMarka();
        String markaSamochodu2 = ((ModelSamochodu) ob).getMarka();
        String modelSamochodu1 = this.getModel();
        String modelSamochodu2 = ((ModelSamochodu) ob).getModel();
        int iloscMiejsc1 = this.getIloscMiejsc();
        int iloscMiejsc2 = ((ModelSamochodu) ob).getIloscMiejsc();
        if(markaSamochodu1.equals(markaSamochodu2) && (modelSamochodu1.equals(modelSamochodu2)) && (iloscMiejsc1 == iloscMiejsc2))
        {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.marka);
        hash = 41 * hash + Objects.hashCode(this.model);
        hash = 41 * hash + this.iloscMiejsc;
        return hash;
    }


    /**
     * @return the rezerwacjeModelu
     */
    public ArrayList<Rezerwacja> getRezerwacjeModelu() {
        return rezerwacjeModelu;
    }

    /**
     * @param rezerwacjeModelu the rezerwacjeModelu to set
     */
    public void setRezerwacjeModelu(ArrayList<Rezerwacja> rezerwacjeModelu) {
        this.rezerwacjeModelu = rezerwacjeModelu;
    }

    /**
     * @return the egzemplarzeModelu
     */
    public ArrayList<EgzemplarzSamochodu> getEgzemplarzeModelu() {
        return egzemplarzeSamochodu;
    }

    /**
     * @param egzemplarzeModelu the egzemplarzeModelu to set
     */
    public void setEgzemplarzeModelu(ArrayList<EgzemplarzSamochodu> egzemplarzeModelu) {
        this.egzemplarzeSamochodu = egzemplarzeModelu;
    }

    public ArrayList<String> add_egzemplarz(String data[]) {
        Factory factory = new Factory();
        EgzemplarzSamochodu newEgzemplarz = factory.create_egzemplarzSamochodu(data);
        newEgzemplarz.setModelSamochodu(this);
        if(search_egzemplarz(newEgzemplarz) == null)
        {
            egzemplarzeSamochodu.add(newEgzemplarz);
            return getEgzemplarzeString();
        }
        return null;
    }
    
    public ArrayList<String> getEgzemplarzeString()
    {
        ArrayList<String> egzemplarze = new ArrayList();
        for(EgzemplarzSamochodu e: this.getEgzemplarzeModelu())
        {
            egzemplarze.add(e.toString());
        }
        return egzemplarze;
    }
    
    public EgzemplarzSamochodu search_egzemplarz(EgzemplarzSamochodu egzemplarz)
    {
        int idx;
        if((idx = egzemplarzeSamochodu.indexOf(egzemplarz)) != -1)
        {
            egzemplarz = (EgzemplarzSamochodu)egzemplarzeSamochodu.get(idx);
            return egzemplarz;
        }
        return null;
    }
}
