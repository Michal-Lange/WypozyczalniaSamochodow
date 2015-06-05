/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_Biznesowa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Falco
 */
@Entity
public class Klient implements Serializable {
    private static final long serialVersionUID = 1L;
    private String imie;
    private String nazwisko;
    private String pesel;
    
    @OneToMany(mappedBy = "klient")
    private ArrayList<Rezerwacja> rezerwacjeKlienta;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public Klient()
    {
        rezerwacjeKlienta = new ArrayList<>();
    }
    
    public boolean addRezerwacja(Rezerwacja rezerwacja)
    {
        return rezerwacjeKlienta.add(rezerwacja);
    }
    
    @Override
    public String toString()
    {
        return getImie() + " " + getNazwisko() + ", " + getPesel();
    }

    /**
     * @return the imie
     */
    public String getImie() {
        return imie;
    }

    /**
     * @param imie the imie to set
     */
    public void setImie(String imie) {
        this.imie = imie;
    }

    /**
     * @return the nazwisko
     */
    public String getNazwisko() {
        return nazwisko;
    }

    /**
     * @param nazwisko the nazwisko to set
     */
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    /**
     * @return the pesel
     */
    public String getPesel() {
        return pesel;
    }

    /**
     * @param pesel the pesel to set
     */
    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    /**
     * @return the rezerwacje_klienta
     */
    public ArrayList<Rezerwacja> getRezerwacjeKlienta() {
        return rezerwacjeKlienta;
    }

    /**
     * @param rezerwacjeKlienta
     */
    public void setRezerwacjeKlienta(ArrayList<Rezerwacja> rezerwacjeKlienta) {
        this.rezerwacjeKlienta = rezerwacjeKlienta;
    }
    
    @Override
    public boolean equals(Object ob){
        String imieKlient1 = this.getImie();
        String imieKlient2 = ((Klient)ob).getImie();
        
        String nazwiskoKlient1 = this.getNazwisko();
        String nazwiskoKlient2 = ((Klient)ob).getNazwisko();
        
        String peselKlient1 = this.getPesel();
        String peselKlient2 = ((Klient)ob).getPesel();

        return imieKlient1.equals(imieKlient2) && (nazwiskoKlient1.equals(nazwiskoKlient2)) && (peselKlient1.equals(peselKlient2));
    } 

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.imie);
        hash = 47 * hash + Objects.hashCode(this.nazwisko);
        hash = 47 * hash + Objects.hashCode(this.pesel);
        return hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
