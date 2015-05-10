/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_klienta;

import Warstwa_Biznesowa.Fasada;
import javax.swing.JOptionPane;

/**
 *
 * @author Falco
 */
public class GUI {
    Fasada ap = new Fasada();
    
    public void demo() {
        String daneModelu[] = {"Opel","Astra","5"};
        ap.dodajModelSamochodu(daneModelu);
        String lan = ap.getModelSamochodu().toString();
        System.out.println(lan);
        JOptionPane.showMessageDialog(null, lan);
    }
    
    static public void main (String args[])
    {
        GUI gui = new GUI();
        gui.demo();
    }
}
