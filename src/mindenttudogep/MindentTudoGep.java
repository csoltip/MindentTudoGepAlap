package mindenttudogep;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/* HF:
itt is használd a konstr inicializálást, illetve az adatrejtést 
a fájlbaíró metódus /mondastKiir()/ úgy működjön, hogy minden mondást hozzáír az eddig kiírtakhoz
úgy, hogy az utoljára kiírt mondás van legfelelül!
*/


/* Feladat végrehajtásának lépése:
 1 szöveg alapján átgondoljuk, megtervezzük -> UML ábra
 2 modellezzük a felhasználást 
 3 valódi implementációkat adunk, specifikáció szerinti működést készítünk
*/

public class MindentTudoGep {
    
    /* BEMUTATÓHOZ
    void semmi(){}
    static void semmiStatic(){}
    */
    
    /* 2. LÉPÉS */
    public static void main(String[] args) throws IOException { 
        
        /* KORÁBBAN IS HASZNÁLTUK MÁR */
//        double d;
//        
//        Random rnd = new Random();//rnd a PÉLDÁNY / OBJEKTUM
//        d = rnd.nextDouble();//a nextDouble() az rnd példány metódusa
//        
//        //nincs példányosítáas, 
//        d = Math.random();//a random() a Math osztály static metódusa
        
        /* JELENLEGI FELADATBAN IS BEMUTATHATÓ- csak semmi értelme... */
//        MindentTudoGep mtg = new MindentTudoGep();//mtg a MindentTudoGep osztály PÉLDÁNYA / OBJEKTUMA
//        mtg.semmi();
//        
//        MindentTudoGep.semmiStatic();//a semmiStatic() a MindentTudoGep osztály static metódusa
        
        
        Robot gep = new Robot();
        Robot gep2 = new Robot();

        gep.lottoSzamokatGeneral();
        
        gep.aktualisLottoSzamok();
        
        System.out.println("korábbi számok listája: ");
        gep.mutatKorabbiak();
        
        gep.felveszUjmondast("A 10 000 mérföldes utazás is egyetlen lépéssel kezdődik!");
        
        String mondas = gep.adjonEgyMondast();//ezt ki lehet írni fájlba
        System.out.println("aktuális mondás: " + mondas); //meg lehet jeleníteni képernyőn
        gep.mondastKiir(mondas);
        
        /* ezt kiírja, de nincs benne a reperotárban */
        gep.mondastKiir("Semmilyen szél nem jó annak, aki nem tudja merre tart");
        
        
        gep.mondastKiir();//utolsó mondást írja ki
        
        
        /* HA NEM LENNE ADATREJTÉS */
        //gep.adatok = new ArrayList<>();
    }
    
}
