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
public class Factory {

    public Klient create_Klient(String[] klientString)
    {
        Klient klient = new Klient();
        if(klientString != null && klient !=null)
        {
            klient.setImie(klientString[0]);
            klient.setNazwisko(klientString[1]);
            klient.setPesel(klientString[2]);
            return klient;
        }
        else
        {
            return null;
        }
    }
            
    public ModelSamochodu create_modelSamochodu(String[] data1) {
        ModelSamochodu modelSamochodu = new ModelSamochodu();
        if(data1 != null && modelSamochodu !=null)
        {
            modelSamochodu.setMarka(data1[0]);
            modelSamochodu.setModel(data1[1]);
            modelSamochodu.setIloscMiejsc(Integer.parseInt(data1[2]));
            return modelSamochodu;
        }
        else
        {
            return null;
        }
    }

    public EgzemplarzSamochodu create_egzemplarzSamochodu(String[] data) {
        EgzemplarzSamochodu egzemplarzSamochodu = new EgzemplarzSamochodu();
        if(data!=null && egzemplarzSamochodu!=null)
        {
            egzemplarzSamochodu.setNrRejstracyjny(data[0]);
            egzemplarzSamochodu.setRokProdukcji(data[1]);
            egzemplarzSamochodu.setRodzajPaliwa(data[2]);
            egzemplarzSamochodu.setTypNadwozia(data[3]);
            egzemplarzSamochodu.setPojemoscSilnika(Integer.parseInt(data[4]));
            return egzemplarzSamochodu;
        }
        return null;
    }
}
