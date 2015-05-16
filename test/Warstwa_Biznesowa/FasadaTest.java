/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Warstwa_Biznesowa;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Falco
 */
public class FasadaTest {
    
    public FasadaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addModelSamochodu method, of class Fasada.
     */
    @Test
    public void testAddModelSamochodu_StringArr() {
        String[] data = {"Opel","Astra G","5"};
        String[] data1 = {"Fiat","126p","4"};
        String[] data2 = null;
        Fasada fasada = new Fasada();
        
        assertEquals(true, fasada.addModelSamochodu(data));
        assertEquals(true, fasada.addModelSamochodu(data1));
        assertEquals(false, fasada.addModelSamochodu(data1));
        assertEquals(false, fasada.addModelSamochodu(data2));
        
        assertEquals(fasada.getModeleSamochodow().get(0).getMarka(),"Opel");
        assertEquals(fasada.getModeleSamochodow().get(0).getModel(),"Astra G");
        assertEquals(fasada.getModeleSamochodow().get(0).getIloscMiejsc(),5);
        
        assertEquals(fasada.getModeleSamochodow().get(1).getMarka(),"Fiat");
        assertEquals(fasada.getModeleSamochodow().get(1).getModel(),"126p");
        assertEquals(fasada.getModeleSamochodow().get(1).getIloscMiejsc(),4);
        
        assertEquals(fasada.getModeleSamochodow().size(),2);
        
    }  
    
    @Test
    public void testAdd_EgzemplarzSamochodu() {
        String[] data = {"Opel","Astra G","5"};
        String[] data1 = {"Fiat","126p","4"};
        String[] data2 = {"Ford","Fiesta","5"};
        
        Fasada fasada = new Fasada();
        fasada.addModelSamochodu(data);
        fasada.addModelSamochodu(data1);
        
        String[] data1e = {"DL82852","2000","Benzyna","Kombi","1598"};
        String[] data2e = {"DW54323","2001","Diesel","Sedan","1998"};

        
        fasada.add_EgzemplarzSamochodu(data, data1e);
        
        assertEquals(fasada.add_EgzemplarzSamochodu(data, data1e),null);
        assertEquals(fasada.add_EgzemplarzSamochodu(data2, data1e),null);
        
        ArrayList<String> wyniki = fasada.add_EgzemplarzSamochodu(data, data2e);
        
        assertEquals("Opel, Astra G, Ilosc miejsc: 5, Nr rejstracyjny: DL82852, Rok: 2000, Pojemnosc : 1598, Paliwo: Benzyna, Nadwozie: Kombi",wyniki.get(0));
        assertEquals("Opel, Astra G, Ilosc miejsc: 5, Nr rejstracyjny: DW54323, Rok: 2001, Pojemnosc : 1998, Paliwo: Diesel, Nadwozie: Sedan",wyniki.get(1));
    }
}
