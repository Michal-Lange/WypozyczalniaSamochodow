/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_Biznesowa;

import java.util.ArrayList;
import java.util.Date;

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
     
    public boolean addKlient (String dane[])
    {
        Klient klient = new Klient();
        if(klient!= null && dane!= null)
        {
            klient.setImie(dane[0]);
            klient.setNazwisko(dane[1]);
            klient.setPesel(dane[2]);
            return addKlient(klient);
        }
        else
        {
            return false;
        }
    }
    
    public boolean addKlient (Klient klient)
    {
        if(klient!=null)
        {
            if(klienci.contains(klient))
            {
                return false;
            }
            else
            {
                klienci.add(klient);
                return true;
            }
        }
        return false;
    }
    
    public boolean addRezerwacja (Klient klient, EgzemplarzSamochodu egzemplarz, Date czasWypozyczenia, Date czasZwrotu)
    {
        Rezerwacja rezerwacja = new Rezerwacja();
        if(klient!=null && egzemplarz!= null && czasZwrotu!=null && rezerwacja!=null){

            boolean wolny = true;
            for(Rezerwacja rezerwacjaIstniejaca: egzemplarz.getRezerwacjeEgzemplarza())
            {
                if(!(czasZwrotu.before(rezerwacjaIstniejaca.getCzasWypozyczenia()) || czasWypozyczenia.after(rezerwacjaIstniejaca.getCzasZwrotu()))){
                    wolny = false;
                }
            }
            if (wolny)
            {
                rezerwacja.setCzasWypozyczenia(czasWypozyczenia);
                rezerwacja.setCzasZwrotu(czasZwrotu);
                rezerwacja.setEgzemplarzSamochodu(egzemplarz);
                rezerwacja.setModelSamochodu(egzemplarz.getModelSamochodu());
                rezerwacja.setKlient(klient);
                klient.addRezerwacja(rezerwacja);
                egzemplarz.addRezerwacja(rezerwacja);
                egzemplarz.getModelSamochodu().addRezerwacja(rezerwacja);
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
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
    
    public ArrayList<Klient> szukajKlienta(String wzorzec) {
        ArrayList<Klient> wyszukani = new ArrayList();
        String[] wzorzecTab = wzorzec.split("\\s+");
        for (Klient klient: getKlienci()){
            for(String s: wzorzecTab)
            {
                if( klient.getImie().contains(s) || klient.getNazwisko().contains(s) || klient.getPesel().contains(s) )
                {
                    wyszukani.add(klient);
                }
            }
        }
        return wyszukani;
    }

    public ArrayList<EgzemplarzSamochodu> szukajEgzemplarza(String wzorzec, Date czasWypozyczenia, Date czasZwrotu)
    {
        ArrayList<EgzemplarzSamochodu> wyszukani = new ArrayList() ;
        boolean wolny;
        for(EgzemplarzSamochodu egzemplarzSamochodu: szukajEgzemplarza(wzorzec))
        {
            wolny = true;
            for(Rezerwacja rezerwacja: egzemplarzSamochodu.getRezerwacjeEgzemplarza())
            {
                if(!(czasZwrotu.before(rezerwacja.getCzasWypozyczenia()) || czasWypozyczenia.after(rezerwacja.getCzasZwrotu()))){
                    wolny = false;
                }
            }
            if(wolny)
            {
                wyszukani.add(egzemplarzSamochodu);
            }
        }
        return wyszukani;
    }
            
    
    public ArrayList<EgzemplarzSamochodu> szukajEgzemplarza(String wzorzec) {
        ArrayList<EgzemplarzSamochodu> wyszukani = new ArrayList();
        String[] wzorzecTab = wzorzec.split("\\s+");
        for(ModelSamochodu modelSamochodu: getModeleSamochodow())
        {
            for(EgzemplarzSamochodu egzemplarzSamochodu: modelSamochodu.getEgzemplarzeModelu())
            {
                for(String s: wzorzecTab)
                {
                    if(egzemplarzSamochodu.getModelSamochodu().getMarka().contains(s) ||
                        egzemplarzSamochodu.getModelSamochodu().getModel().contains(s) ||
                        Integer.toString(egzemplarzSamochodu.getModelSamochodu().getIloscMiejsc()).contains(s) ||
                        egzemplarzSamochodu.getNrRejstracyjny().contains(s) ||
                        egzemplarzSamochodu.getRodzajPaliwa().contains(s) ||
                        egzemplarzSamochodu.getRokProdukcji().contains(s) ||
                        egzemplarzSamochodu.getTypNadwozia().contains(s) ||
                        Integer.toString(egzemplarzSamochodu.getPojemoscSilnika()).contains(s))
                        {
                            wyszukani.add(egzemplarzSamochodu);
                        }
                }
            }
        }
        return wyszukani;
    }
    
    public ArrayList<String> add_EgzemplarzSamochodu(String data1[], String data2[])
    {
        
        ModelSamochodu help1, model_exist;
        Factory fabryka = new Factory();
        help1 = fabryka.create_modelSamochodu(data1);
        if((model_exist = search_model(help1)) != null)
        {
            return model_exist.add_egzemplarz(data2);
        }
        return null;
    }
    
    public ModelSamochodu search_model(ModelSamochodu help1){
        for(ModelSamochodu model: this.getModeleSamochodow())
        {
            if(help1.equals(model))
            {
                return model;
            }
        }
        return null;
    }
}


