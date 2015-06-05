/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_Biznesowa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Falco
 */
@Entity
public class Rezerwacja implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Klient klient;
    @ManyToOne
    private ModelSamochodu modelSamochodu;
    @ManyToOne
    private EgzemplarzSamochodu egzemplarzSamochodu;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date czasWypozyczenia;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date czasZwrotu;

    @Override
    public String toString()
    {
        String wynik = 
                " Klient: " + klient.toString() +
                " Rezerwacja od: " + czasWypozyczenia.toString() +
                " Rezerwacja do: " + czasZwrotu.toString() +
                " Samochod: " + egzemplarzSamochodu.toString();
        return wynik;
    }
    
    @Override
    public boolean equals(Object ob){
        ModelSamochodu model1 = getModelSamochodu();
        ModelSamochodu model2 = ((Rezerwacja) ob).getModelSamochodu();
        Klient klient1 = getKlient();
        Klient klient2 = ((Rezerwacja) ob).getKlient();
        EgzemplarzSamochodu egzemplarz1 = getEgzemplarzSamochodu();
        EgzemplarzSamochodu egzemplarz2 = ((Rezerwacja) ob).getEgzemplarzSamochodu();
        Date datar1 = getCzasWypozyczenia();
        Date datar2 = ((Rezerwacja) ob).getCzasZwrotu();
        Date dataz1 = getCzasWypozyczenia();
        Date dataz2 = ((Rezerwacja) ob).getCzasZwrotu();
        return model1.equals(model2) && klient1.equals(klient2) &&
                egzemplarz1.equals(egzemplarz2) && datar1.equals(datar2)
                && dataz1.equals(dataz2);
    }
    /**
     * @return the klient
     */
    public Klient getKlient() {
        return klient;
    }

    /**
     * @param klient the klient to set
     */
    public void setKlient(Klient klient) {
        this.klient = klient;
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
     * @return the egzemplarzSamochodu
     */
    public EgzemplarzSamochodu getEgzemplarzSamochodu() {
        return egzemplarzSamochodu;
    }

    /**
     * @param egzemplarzSamochodu the egzemplarzSamochodu to set
     */
    public void setEgzemplarzSamochodu(EgzemplarzSamochodu egzemplarzSamochodu) {
        this.egzemplarzSamochodu = egzemplarzSamochodu;
    }

    /**
     * @return the czasWypozyczenia
     */
    public Date getCzasWypozyczenia() {
        return czasWypozyczenia;
    }

    /**
     * @param czasWypozyczenia the czasWypozyczenia to set
     */
    public void setCzasWypozyczenia(Date czasWypozyczenia) {
        this.czasWypozyczenia = czasWypozyczenia;
    }

    /**
     * @return the czasZwrotu
     */
    public Date getCzasZwrotu() {
        return czasZwrotu;
    }

    /**
     * @param czasZwrotu the czasZwrotu to set
     */
    public void setCzasZwrotu(Date czasZwrotu) {
        this.czasZwrotu = czasZwrotu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
