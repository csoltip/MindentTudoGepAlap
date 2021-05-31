package mindenttudogep;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* 1. lépés */
//Ennyi látszik az UML ábrából

public class Robot {
    
    /*# ADATTAGOK #*/

    /* Van OSZTÁLY- és van PÉLDÁNY- szintű metódus illetve adattag
    ha ott a static,. akkor az az osztályhoz tartozik egyébként a példányhoz
    */
    
//most ki a this? itt most a gep2

    /*most már csak egyszer hívódik meg, sem ciklusban, sem metódusban nics 
    de minden példányban ott van benne, tehát többször használjuk  anew-t
    */
    
    /* csak egyszer hozzuk létre, PÉLDÁNYONKÉNT és nem hívásonként */
    //Random rnd = new Random();
    /* csak egyszer hozzuk létre, az OSZTÁLYBAN */
    static Random rnd = new Random();
    
    //az adattagokat a kstr. inicializálja!
    
    private ArrayList<Integer> lottoSzamok /*= new ArrayList<>()*/;
    private ArrayList<String>mondasok /*= new ArrayList<String>(){
        {
            add("Nincsen rózsa tövis nélkül!");
            add("Minden kezdet nehéz");
        }
    }*/;
    
    private ArrayList<String> adatok /*= new ArrayList<>()*/;//több szám, szóközzel elválasztva
    
    
    /*# TAGFÜGGVÉNYEK #*/
    //#konstruktorok
    Robot(){
        lottoSzamok = new  ArrayList<>();
        mondasok = new ArrayList<>();
        mondasok.add("Nincsen rózsa tövis nélkül!");
        mondasok.add("Minden kezdet nehéz");
        adatok = new ArrayList<>();
    }
    
	//#felülírások
	
    
    //#saját metódusok
    ArrayList<Integer> lottoSzamokatGeneral(){
        /* 1. lépés */
        //return new int[5];//valódi, megjátszható számokat kell belerakni
        
        /* 3. Lépés */
        
        //Random rnd = new Random();////a new a legdrágább művelet, ha lehet, akkor csak egyszer használjuk:metósuban se legyen,(HA LEHET)
        while(lottoSzamok.size() < 5){
            //Random rnd = new Random();////a new a legdrágább művelet, ha lehet, akkor csak egyszer használjuk: ne legyen ciklusban. (HA LEHET)
            int szam = rnd.nextInt(90) + 1;
            if(!lottoSzamok.contains(szam)){
                lottoSzamok.add(szam);
            }
        }
        
        /* jó megoldás 2 egymásba ágyazott cciklussal, az eldöntés tételét felhazsnálva */
//    ciklus amíg nincs 5 jó
//        int[] szamok = new int[5];
        //eldöntés: a generált szám benne van e?
        
        /* pazarló */
//    ciklus amíg nincs 5 jó
//        boolean[] szamok = new boolean[91];
//        if(!szamok[szam]){
//            szamok[szam] = true;
//        }
        
        return lottoSzamok;
    }
    
    void aktualisLottoSzamok(){
         /* 1. lépés */
        //System.out.println("A megjátszható lottószámok: 1 2 3 4 5");
        
        /* 3. Lépés */
        System.out.println("A megjátszható lottószámok: ");
        for (int szam : lottoSzamok) {
            System.out.print( szam + " ");
        }
    }
    
    void mutatKorabbiak(){
        /* 1. lépés */
        //maradhat üres
        
        /* 3. Lépés */
        for (String szamok : adatok) {
            System.out.println(szamok);
        }
    }
    
    String adjonEgyMondast(){
        /* 1. lépés */
        //return "egy véletlen kiválasztott mondás";
        
        /* 3. Lépés */
        //int mondasDb = mondasok.length;
        //return mondasok[(int)(Math.random() * mondasDb)];
        int mondasDb = mondasok.size();
        //return mondasok.get((int)(Math.random() * mondasDb));
        return mondasok.get(rnd.nextInt(mondasDb));
    }
    
    void felveszUjmondast(String mondas){
        /* 1. lépés */
        //maradhat üres
        
        /* 3. Lépés */
        mondasok.add(mondas);
    }
    
    /* Hozzáírás meglévő fájlhoz: append
    az append mindig a végére ír
    Az utolsó kiírás kerüljön előre:
    1.: beolvassuk az eddigieket, ha létezik
    2.: előre beszúrjuk az aktulis mondást
    3.: az egészet kirjuk
    */
    
    /* túlterhelés helyett lehetne utolsoMondastKiir() */
    void mondastKiir() throws IOException{
        
        String mondas = mondasok.get(mondasok.size()-1);
        
        Path path = Paths.get("frazis.txt");
        if(Files.exists(path)){
            List<String> be = Files.readAllLines(path);
            //gyári megoldás, az add() túlterhelt metódusát használjuk
            be.add(0, mondas);
            
            //saját megoldás
            /*egy külön stringbe/tárolóba beírjuk a mondást
             * mögé rakjuk a beolvasottakat egy ciklus segítségével
             */
            
            Files.write(path, be);
        }
        
        mondastKiir(mondas);
    } 
    
    
    
    void mondastKiir(String mondas) throws IOException{
        //kiírja, de mindig felülírja a fájlt
        Files.write(Paths.get("frazis.txt"), mondas.getBytes());
        
        //felülírjuk, azaz mindig a meglévő fájl végére írunk
        Files.write(Paths.get("frazis.txt"), mondas.getBytes(), StandardOpenOption.APPEND);
    }
}
