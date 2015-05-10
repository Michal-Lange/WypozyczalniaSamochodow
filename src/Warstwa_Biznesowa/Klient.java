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
public class Klient {
    private String imie;
    private String nazwisko;
    private String pesel;
    
    private ArrayList<Rezerwacja> rezerwacje_klienta = new ArrayList<>();
    
    @Override
    public String toString()
    {
        return "Imie: " + getImie() + " Nazwisko: " + getNazwisko() + " Pesel: " + getPesel();
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
    public ArrayList<Rezerwacja> getRezerwacje_klienta() {
        return rezerwacje_klienta;
    }

    /**
     * @param rezerwacje_klienta the rezerwacje_klienta to set
     */
    public void setRezerwacje_klienta(ArrayList<Rezerwacja> rezerwacje_klienta) {
        this.rezerwacje_klienta = rezerwacje_klienta;
    }
 
}
