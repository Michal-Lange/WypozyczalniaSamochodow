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
    
    public String[][] getWszystkieRezerwacje()
    {
        ArrayList<Rezerwacja> rezerwacjeList = new ArrayList();
        for(ModelSamochodu model: getModeleSamochodow())
        {
            for(Rezerwacja rezerwacja: model.getRezerwacjeModelu()){
                rezerwacjeList.add(rezerwacja);
            }
        }
        String wynik[][] = new String[rezerwacjeList.size()][];
        int i=0;
        for(Rezerwacja rez: rezerwacjeList)
        {
            String dodany[] = {rez.toString()};
            wynik[i++]=dodany;
        }
        return wynik;
    }
    
    public String[][] getModeleSamochoduAsStringArray()
    {
        String wynik[][] = new String[getModeleSamochodow().size()][];
        int i=0;
        for(ModelSamochodu model: getModeleSamochodow())
        {
            String dodany[] = {model.getMarka(), model.getModel(), Integer.toString(model.getIloscMiejsc())};
            wynik[i++]=dodany;
        }
        return wynik;
    }
    
    public String[][] getEgzemplarzeModeluAsStringArray(String model[])
    {
        Factory factory = new Factory();
        ModelSamochodu wzorzecModelu = factory.create_modelSamochodu(model);
        int idx = getModeleSamochodow().indexOf(wzorzecModelu);
        if(idx != -1)
        {
            String wynik[][] = new String[getModeleSamochodow().get(idx).getEgzemplarzeModelu().size()][];
            int i=0;
            for(EgzemplarzSamochodu egzemplarz: getModeleSamochodow().get(idx).getEgzemplarzeModelu())
            {
                String dodany[] = {egzemplarz.getModelSamochodu().getMarka(), egzemplarz.getModelSamochodu().getModel(), Integer.toString(egzemplarz.getModelSamochodu().getIloscMiejsc()),
                    egzemplarz.getNrRejstracyjny(), egzemplarz.getRodzajPaliwa(), egzemplarz.getRokProdukcji(), egzemplarz.getTypNadwozia(), Integer.toString(egzemplarz.getPojemoscSilnika())};
                wynik[i++]=dodany;
            }
            return wynik;
        }
        String epmty[][] = new String[0][];
        return epmty;
    }
    
    public String[][] getKlienciAsStringArray()
    {
        String wynik[][] = new String[getKlienci().size()][];
        int i=0;
        for(Klient klient: getKlienci())
        {
            String dodany[] = {klient.getImie(), klient.getNazwisko(), klient.getPesel()};
            wynik[i++]=dodany;
        }
        return wynik;
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
        Factory fabryka = new Factory();
        if(dane!= null)
        {
            Klient klient = fabryka.create_Klient(dane);
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
    
    public Klient szukajKlienta(String[] klient)
    {
        if(klient!=null)
        {
            Factory fabryka = new Factory();
            Klient klientWzorzec = fabryka.create_Klient(klient);
            int idx = getKlienci().indexOf(klientWzorzec);
            if(idx!=-1)
            {
                return getKlienci().get(idx);
            }
        }
        return null;
    }
    
    public EgzemplarzSamochodu szukajEgzemplarza(String[] dane)
    {
        if(dane!=null)
        {
            Factory fabryka = new Factory();
            String[] daneModel = {dane[0],dane[1],dane[2]};
            ModelSamochodu modelWzorzec = fabryka.create_modelSamochodu(daneModel);
            int idx = getModeleSamochodow().indexOf(modelWzorzec);
            if(idx!=-1)
            {
                String[] daneEgzemplarz = {dane[3],dane[4],dane[5],dane[6],dane[7]};
                EgzemplarzSamochodu egzemplarzWzorzec = fabryka.create_egzemplarzSamochodu(daneEgzemplarz);
                int idxe = getModeleSamochodow().get(idx).getEgzemplarzeModelu().indexOf(egzemplarzWzorzec);
                if(idxe!=-1)
                {
                    return getModeleSamochodow().get(idx).getEgzemplarzeModelu().get(idxe);
                }
            }
        }
        return null;
    }
    
      public ModelSamochodu szukaj_model(String[] dane)
    {
        if(dane!=null)
        {
            Factory fabryka = new Factory();
            String[] daneModel = {dane[0],dane[1],dane[2]};
            ModelSamochodu modelWzorzec = fabryka.create_modelSamochodu(daneModel);
            int idx = getModeleSamochodow().indexOf(modelWzorzec);
            if(idx!=-1)
            {
                    return getModeleSamochodow().get(idx);//.getEgzemplarzeModelu().get(idxe);
            }
        }
        return null;
    }
    
    public boolean addRezerwacja (String[] klient, String[] egzemplarz, long czasWypozyczenia, long czasZwrotu)
    {
        {
            Klient rKlient = szukajKlienta(klient);
            ModelSamochodu model = szukaj_model(egzemplarz);
            Date wypozyczenie = new Date(czasWypozyczenia);
            Date zwrot = new Date(czasZwrotu);
            if(rKlient != null && model!= null)
            {
                return model.addRezerwacja(rKlient, egzemplarz, wypozyczenie, zwrot);
            }
        }
        return false;
    }
    
    
    
    public boolean addRezerwacja (Klient klient, EgzemplarzSamochodu egzemplarz, Date czasWypozyczenia, Date czasZwrotu)
    {
        Rezerwacja rezerwacja = new Rezerwacja();
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
    
    public String[][] szukajKlientaR2(String wzorzec)
    {
        if(wzorzec==null)
            return null;
        ArrayList<Klient> wyszukani = szukajKlienta(wzorzec);
        String wynik[][] = new String[wyszukani.size()][];
        int i=0;
        for(Klient klient: wyszukani)
        {
            String dodany[] = {klient.getImie(), klient.getNazwisko(), klient.getPesel()};
            wynik[i++]=dodany;
        }
        return wynik;
    }
    
    public String[][] szukajModeluR2(String wzorzec)
    {
        if(wzorzec==null)
            return null;
        ArrayList<ModelSamochodu> wyszukane = new ArrayList();
        String[] wzorzecTab = wzorzec.split("\\s+");
        for (ModelSamochodu model: getModeleSamochodow()){
            boolean zawiera = false;
            for(String s: wzorzecTab)
            {
                if(model.getMarka().contains(s) || model.getModel().contains(s))
                {
                    zawiera = true;
                }
                else
                {
                    zawiera = false;
                    break;
                }
            }
            if(zawiera)
                wyszukane.add(model);
        }
        String wynik[][] = new String[wyszukane.size()][];
        int i=0;
        for(ModelSamochodu model: wyszukane)
        {
            String dodany[] = {model.getMarka(), model.getModel(), Integer.toString(model.getIloscMiejsc())};
            wynik[i++]=dodany;
        }
        return wynik;
    }
      
    public ArrayList<Klient> szukajKlienta(String wzorzec)
    {
        ArrayList<Klient> wyszukani = new ArrayList();
        String[] wzorzecTab = wzorzec.split("\\s+");
        for (Klient klient: getKlienci()){
            boolean zawiera = false;
            for(String s: wzorzecTab)
            {
                if( klient.getImie().contains(s) || klient.getNazwisko().contains(s) || klient.getPesel().contains(s) )
                {
                    zawiera = true;
                }
                else
                {
                    zawiera = false;
                    break;
                }
            }
            if(zawiera)
                wyszukani.add(klient);
        }
        return wyszukani;
    }
    
    public String[][] szukajEgzemplarzaR2Model(String[] model, String wzorzec, long czasWypozyczenia, long czasZwrotu)
    {
        Factory factory = new Factory();
        ModelSamochodu wzorzecModelu = factory.create_modelSamochodu(model);
        int idx = getModeleSamochodow().indexOf(wzorzecModelu);
        if(idx != -1)
        {
            Date wypozyczenie = new Date(czasWypozyczenia);
            Date zwrot = new Date(czasZwrotu);
            ArrayList<EgzemplarzSamochodu> wyszukane = new ArrayList() ;
            String[] wzorzecTab = wzorzec.split("\\s+");
            boolean zawiera = false;
            for(EgzemplarzSamochodu egzemplarzSamochodu: getModeleSamochodow().get(idx).getEgzemplarzeModelu())
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
                        zawiera = true;
                    }
                    else
                    {
                        zawiera = false;
                        break;
                    }
                }
                if(zawiera){
                    boolean wolny = true;
                    for(Rezerwacja rezerwacja: egzemplarzSamochodu.getRezerwacjeEgzemplarza())
                    {
                        if(!(zwrot.before(rezerwacja.getCzasWypozyczenia()) || wypozyczenie.after(rezerwacja.getCzasZwrotu()))){
                            wolny = false;
                        }
                    }
                    if(wolny)
                    {
                            wyszukane.add(egzemplarzSamochodu);
                    }
                }
            }
            String wynik[][] = new String[wyszukane.size()][];
            int i=0;
            for(EgzemplarzSamochodu egzemplarz: wyszukane)
            {
                String dodany[] = {egzemplarz.getModelSamochodu().getMarka(), egzemplarz.getModelSamochodu().getModel(), Integer.toString(egzemplarz.getModelSamochodu().getIloscMiejsc()),
                    egzemplarz.getNrRejstracyjny(), egzemplarz.getRodzajPaliwa(), egzemplarz.getRokProdukcji(), egzemplarz.getTypNadwozia(), Integer.toString(egzemplarz.getPojemoscSilnika())};
                wynik[i++]=dodany;
            }
            return wynik;
        }
        String epmty[][] = new String[0][];
        return epmty;
    }
    
    public String[][] szukajEgzemplarzaR2Wzorzec(String wzorzec, long czasWypozyczenia, long czasZwrotu)
    {
        Date wypozyczenie = new Date(czasWypozyczenia);
        Date zwrot = new Date(czasZwrotu);
        ArrayList<EgzemplarzSamochodu> wyszukane = new ArrayList() ;
        String[] wzorzecTab = wzorzec.split("\\s+");
        
        
        for(ModelSamochodu modelSamochodu: getModeleSamochodow())
        {
            boolean zawiera = false;
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
                            zawiera = true;
                        }
                        else
                        {
                            zawiera = false;
                            break;
                        }
                }
                if(zawiera){
                    boolean wolny = true;
                    for(Rezerwacja rezerwacja: egzemplarzSamochodu.getRezerwacjeEgzemplarza())
                    {
                        if(!(zwrot.before(rezerwacja.getCzasWypozyczenia()) || wypozyczenie.after(rezerwacja.getCzasZwrotu()))){
                            wolny = false;
                        }
                    }
                    if(wolny)
                    {
                        wyszukane.add(egzemplarzSamochodu);
                    }
                }
            }
        }
        String wynik[][] = new String[wyszukane.size()][];
        int i=0;
        for(EgzemplarzSamochodu egzemplarz: wyszukane)
        {
            String dodany[] = {egzemplarz.getModelSamochodu().getMarka(), egzemplarz.getModelSamochodu().getModel(), Integer.toString(egzemplarz.getModelSamochodu().getIloscMiejsc()),
                    egzemplarz.getNrRejstracyjny(), egzemplarz.getRodzajPaliwa(), egzemplarz.getRokProdukcji(), egzemplarz.getTypNadwozia(), Integer.toString(egzemplarz.getPojemoscSilnika())};
            wynik[i++]=dodany;
        }
        return wynik;
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
            
    
    public ArrayList<EgzemplarzSamochodu> szukajEgzemplarza(String wzorzec)
    {
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
    
    public ArrayList<String> add_EgzemplarzSamochodu(String model[], String egzemplarz[])
    {
        ModelSamochodu help1, model_exist;
        Factory fabryka = new Factory();
        help1 = fabryka.create_modelSamochodu(model);
        if((model_exist = search_model(help1)) != null)
        {
            return model_exist.add_egzemplarz(egzemplarz);
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

    public synchronized void update_data(ModelSamochodu[] modeleSamochodow, EgzemplarzSamochodu[] egzemplarzeSamochodu){
        this.modeleSamochodow.clear();
        for(ModelSamochodu model: modeleSamochodow) {
            this.modeleSamochodow.add(model);
        }
        for(ModelSamochodu model:  modeleSamochodow) {
            for(EgzemplarzSamochodu egzemplarz: egzemplarzeSamochodu) {
                ModelSamochodu model1 = egzemplarz.getModelSamochodu();
                if(model1!=null){
                    if(model1.equals(model)){
                        model.getEgzemplarzeModelu().add(egzemplarz);
                    }
                }
            }
        }
    }
}


