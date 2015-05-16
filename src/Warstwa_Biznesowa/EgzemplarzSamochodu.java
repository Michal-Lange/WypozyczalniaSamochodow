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
public class EgzemplarzSamochodu {
    private ModelSamochodu modelSamochodu;
    private String nrRejstracyjny;
    private String rokProdukcji;
    private int pojemoscSilnika;
    private String rodzajPaliwa;
    private String typNadwozia;
    private ArrayList<Rezerwacja> rezerwacjeEgzemplarza;
    
    public EgzemplarzSamochodu()
    {
        rezerwacjeEgzemplarza = new ArrayList<>();
    }
    
    @Override
    public String toString()
    {
        return getModelSamochodu().toString() + " Nr rejstracyjny: " + getNrRejstracyjny() +
                " Rok: " + getRokProdukcji() + " Pojemnosc : " + Integer.toString(getPojemoscSilnika()) + 
                " Paliwo: " + getRodzajPaliwa() + " Nadwozie: " + getTypNadwozia();
    }
    
    @Override
    public boolean equals(Object ob){
        String nrRejstracyjny1 = this.getNrRejstracyjny();
        String nrRejstracyjny2 = ((EgzemplarzSamochodu) ob).getNrRejstracyjny();
      
        if(nrRejstracyjny1.equals(nrRejstracyjny2))
        {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.nrRejstracyjny);
        return hash;
    }

    boolean addRezerwacja(Rezerwacja rezerwacja){
        return rezerwacjeEgzemplarza.add(rezerwacja);
    }
    
    /**
     * @return the nrRejstracyjny
     */
    public String getNrRejstracyjny() {
        return nrRejstracyjny;
    }

    /**
     * @param nrRejstracyjny the nrRejstracyjny to set
     */
    public void setNrRejstracyjny(String nrRejstracyjny) {
        this.nrRejstracyjny = nrRejstracyjny;
    }

    /**
     * @return the rokProdukcji
     */
    public String getRokProdukcji() {
        return rokProdukcji;
    }

    /**
     * @param rokProdukcji the rokProdukcji to set
     */
    public void setRokProdukcji(String rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    /**
     * @return the pojemoscSilnika
     */
    public int getPojemoscSilnika() {
        return pojemoscSilnika;
    }

    /**
     * @param pojemoscSilnika the pojemoscSilnika to set
     */
    public void setPojemoscSilnika(int pojemoscSilnika) {
        this.pojemoscSilnika = pojemoscSilnika;
    }

    /**
     * @return the rodzajPaliwa
     */
    public String getRodzajPaliwa() {
        return rodzajPaliwa;
    }

    /**
     * @param rodzajPaliwa the rodzajPaliwa to set
     */
    public void setRodzajPaliwa(String rodzajPaliwa) {
        this.rodzajPaliwa = rodzajPaliwa;
    }

    /**
     * @return the typNadwozia
     */
    public String getTypNadwozia() {
        return typNadwozia;
    }

    /**
     * @param typNadwozia the typNadwozia to set
     */
    public void setTypNadwozia(String typNadwozia) {
        this.typNadwozia = typNadwozia;
    }

    /**
     * @return the modelSamochodu
     */
    public ModelSamochodu getModelSamochodu() {
        return modelSamochodu;
    }

    /**
     * @param modelSamochodu the modelSamochodu to set
     */
    public void setModelSamochodu(ModelSamochodu modelSamochodu) {
        this.modelSamochodu = modelSamochodu;
    }

    /**
     * @return the rezerwacjeEgzemplarza
     */
    public ArrayList<Rezerwacja> getRezerwacjeEgzemplarza() {
        return rezerwacjeEgzemplarza;
    }

    /**
     * @param rezerwacjeEgzemplarza the rezerwacjeEgzemplarza to set
     */
    public void setRezerwacjeEgzemplarza(ArrayList<Rezerwacja> rezerwacjeEgzemplarza) {
        this.rezerwacjeEgzemplarza = rezerwacjeEgzemplarza;
    }
            
}
