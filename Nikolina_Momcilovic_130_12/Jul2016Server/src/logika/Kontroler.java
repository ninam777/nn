/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import db.DBBroker;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pomocneKlase.PrikazKlasa;

/**
 *
 * @author Nina777
 */
public class Kontroler {

    private static Kontroler instanca;
    DBBroker db;

    private Kontroler() {
        db = new DBBroker();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

//    public ArrayList<Angazovanje> vratiListuAngazovanja() {
//        db.ucitajDrajver();
//        db.otvoriKonekciju();
//        ArrayList<Angazovanje> listaAng = db.vratiListuAngazovanja();
//        db.zatvoriKonekciju();
//        return listaAng;
//    }

    

//    public boolean sacuvajProjekat(Projekat proj) {
//        boolean sacuvano = false;
//        try {
//
//            db.ucitajDrajver();
//            db.otvoriKonekciju();
//            db.sacuvajProjekat(proj);
//
//            db.komit();
//            sacuvano = true;
//        } catch (SQLException ex) {
//            Logger.getLogger(Kontroler.class.getName()).log(Level.SEVERE, null, ex);
//
//            db.rollback();
//            sacuvano = false;
//        }
//        db.zatvoriKonekciju();
//        return sacuvano;
//    }
    
    
//    public int vratiProjekatID(){
//        db.ucitajDrajver();
//        db.otvoriKonekciju();
//        int prID = db.vratiProjekatID();
//        db.zatvoriKonekciju();
//        return prID;
//    }
    
//    *Ako je potrebna jedna stavka iz liste
//    public Racun vratiRacun(int sifra) {
//        db.ucitajDrajver();
//        db.otvoriKonekciju();
//        Racun rac = db.vratiRacun(sifra);
//        db.zatvoriKonekciju();
//        return rac;
//    }

    public ArrayList<PrikazKlasa> vratiPrikaz() {
        db.ucitajDrajver();
        db.otvoriKonekciju();
        ArrayList<PrikazKlasa> lista = db.vratiListuPrikaz();
        db.zatvoriKonekciju();
        return lista;

    }
    
//    * Filter: poziva se novi prikaz sa parametrima
//    public ArrayList<PrikazKlasa> vratiPrikaz(int pr, int ispR) {
//        db.ucitajDrajver();
//        db.otvoriKonekciju();
//        ArrayList<PrikazKlasa> lista = db.vratiListuPrikaz(pr, ispR);
//        db.zatvoriKonekciju();
//        return lista;
//
//    }

}
