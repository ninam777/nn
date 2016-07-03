/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pomocneKlase.PrikazKlasa;

/**
 *
 * @author Nina777
 */
public class DBBroker {

    Connection konekcija;

    public void ucitajDrajver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Nije se ucitao drajver");
        }
    }

    public void otvoriKonekciju() {
        try {
            // TODO: promeni ime baze ako treba, ako postoji grupa pogledaj
            konekcija = DriverManager.getConnection("jdbc:mysql://localhost:3306/prosoftjul16", "root", "");
            konekcija.setAutoCommit(false);
        } catch (SQLException ex) {
            System.out.println("Nije otvorena konekcija");
        }
    }

    public void zatvoriKonekciju() {
        try {
            konekcija.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void komit() {
        try {
            konekcija.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void rollback() {
        try {
            konekcija.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// *metora vratiListu
//    public ArrayList<Angazovanje> vratiListuAngazovanja() {
//        String upit = "Select * from angazovanje";
//        ArrayList<Angazovanje> lista = new ArrayList<>();
//
//        try {
//            Statement s = konekcija.createStatement();
//            ResultSet rs = s.executeQuery(upit);
//            while (rs.next()) {
//                int angazovanjeID = rs.getInt("AngazovanjeID");
//                int inzID = rs.getInt("InzenjerID");
//                int projID = rs.getInt("ProjekatID");
//                Date datAng = rs.getDate("DatumAngazovanja");
//
//                Angazovanje ang = new Angazovanje(angazovanjeID, null, null, datAng); // TODO
//                lista.add(ang);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return lista;
//    }

    
//      *sacuvaj metoda, u sacuvajAngazovanje pise kako se cuva ako povlaci ID iz neke druge tabele
//      *odradjeno preko MAXID
//      *TODO: promeni upit, shodno tome koja je tabela i koji upit(insert, update, delete, select)
//      *UPITI: 
//          *"INSERT INTO Tabela(Kolona1,Kolona2,Kolona3) VALUES (?,?,?)"
//          *"UPDATE Tabela SET Kolona1=?,Kolona2=?,Kolona3=? WHERE KolonaUslov=?"
//              Primer:
//                      String upit = "UPDATE Racun SET Datum=?,KlijentID=?,UkupanIznos=? WHERE RacunID=?";
//          *"SELECT * from Tabela"
//              Primer za slozeniji select:         
//                      String upit = "Select *, k.Naziv as NazivKlijenta, p.Naziv as NazivProizvoda from stavkaRacuna sr join racun r on sr.RacunID=r.RacunID join proizvod p on p.ProizvodID=sr.ProizvodID join klijent k on k.KlijentID=r.KlijentID";
//          *"DELETE FROM Tabela WHERE KolonaUslov=?"
//              Primer:
//                      String upit = "DELETE FROM StavkaRacuna WHERE RacunID=? AND RB=?";
    
//    public void sacuvajProjekat(Projekat proj) throws SQLException {
//        String upit = "INSERT INTO Projekat(ProjekatID,Naziv,DatumOd,DatumDo,VrstaID) VALUES (?,?,?,?,?)";
//        int maksID = vratiMaksIDDez();
//        PreparedStatement ps = konekcija.prepareStatement(upit);
//        ps.setInt(1, maksID+1);
//        ps.setString(2, proj.getNaziv());
//        ps.setDate(3, new Date(proj.getDatumOd().getTime()));
//        ps.setDate(4, new Date(proj.getDatumDo().getTime()));
//        ps.setInt(5, proj.getVrstaProjekta().getVrstaID());
//        
//        ps.executeUpdate();
//    }
//    public void sacuvajAngazovanje(Angazovanje ang) throws SQLException {
//        String upit = "INSERT INTO Angazovanje(AngazovanjeID,InzenjerID,ProjekatID,DatumAngazovanja) VALUES (?,?,?,?)";
//        ang.getProjekat().setProjekatID(vratiMaksIDDez()+1);
//        int maksID = vratiMaksIDDez2();
//        PreparedStatement ps = konekcija.prepareStatement(upit);
//        ps.setInt(1, maksID+1);
//        ps.setInt(2, ang.getInzenjer().getInzenjerID());
//        ps.setInt(3, vratiProjekatID());
//        ps.setDate(4, new Date(ang.getDatumAngazovanja().getTime()));
//        
//        ps.executeUpdate();
//    }
    
//    *ID za tabelu u kojoj se koristi kao spoljasnji kljuc
    
//    public int vratiProjekatID() {
//        String upit = "Select ProjekatID from projekat";
//        int prID = -1;
//
//        try {
//            Statement s = konekcija.createStatement();
//            ResultSet rs = s.executeQuery(upit);
//            while (rs.next()) {
//                prID = rs.getInt("ProjekatID");
//                
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return prID;
//    }

//      *MAXID
//    
//    private int vratiMaksIDDez() {
//        String upit = "Select max(ProjekatID) as maks from Projekat";
//        int maks = 0;
//
//        try {
//            Statement s = konekcija.createStatement();
//            ResultSet rs = s.executeQuery(upit);
//            while (rs.next()) {
//                maks = rs.getInt("maks");
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return maks;
//    }
    
   

    public ArrayList<PrikazKlasa> vratiListuPrikaz() {
//        TODO: promeni upit, prikaz klasa ima one atribute koji su kolone tabele na serverskoj strani
       String upit = "select p.*, vp.*, count(a.AngazovanjeID) as brAngazovanih    from projekat p join vrstaProjekta vp on p.VrstaID=vp.VrstaProjekta join angazovanje a on a.ProjekatID=p.ProjekatID group by a.AngazovanjeID";
        ArrayList<PrikazKlasa> lista = new ArrayList<>();

        try {
            Statement s = konekcija.createStatement();
            ResultSet rs = s.executeQuery(upit);
            while (rs.next()) {
                PrikazKlasa p = new PrikazKlasa();
//                TODO: dodaj p.setAtribut1(); ... atributi su kolone tabele servera
//                p.setProjekat(new Projekat(rs.getInt("ProjekatID"), rs.getString("Naziv"), rs.getDate("DatumOd"), rs.getDate("DatumDo"), null));
//                p.setVrstaProjekta(new VrstaProjekta(rs.getInt("VrstaID"), rs.getString("Naziv")));
//                p.setBrAngazovanih(rs.getInt("brAngazovanih"));
                
                lista.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lista;

    }
    
//    *Filter: Ukoliko se filtrira i vraca prikazKlasa po parametrima, 
//              obratiti paznju na upit, sve ostalo ostaje isto kao i kod obicnog prikazaKlasa ^^^
    
//    public ArrayList<PrikazKlasa> vratiListuPrikaz(int pred, int ir) {
//       String upit = "select n.*, count(d.DezurstvoID) as ukBrDez, sum(p.TrajanjeIspita) as ukBrSati    from nastavnik n join dezurstvo d on n.NastavnikID=d.NastavnikID join predmet p on p.PredmetID=d.PredmetID join ispitniRok isp on isp.IspitniRokID=d.IspitniRokID where p.PredmetID="+pred+" AND isp.IspitniRokID="+ir+" group by n.NastavnikID";
//        ArrayList<PrikazKlasa> lista = new ArrayList<>();
//
//        try {
//            Statement s = konekcija.createStatement();
//            ResultSet rs = s.executeQuery(upit);
//            while (rs.next()) {
//                PrikazKlasa p = new PrikazKlasa();
//                p.setNastavnik(new Nastavnik(rs.getInt("NastavnikID"), rs.getString("Ime"), rs.getString("Prezime"), rs.getString("Zvanje")));
//                p.setUkupanBrojDezurstava(rs.getInt("ukBrDez"));
//                p.setUkupanBrojSati(rs.getInt("ukBrSati"));
//     
//                lista.add(p);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return lista;
//    }
    
//    *IZBRISI I SACUVAJ iz liste, u zavisnosti od toga sta je u bazi
//    
//    public void sacuvajListuStavki(ArrayList<StavkaRacuna> sr) {
//        ArrayList<StavkaRacuna> listaIzBaze = vratiListuStavki();
//
//        for (StavkaRacuna stavka : sr) {
//            if (!listaIzBaze.contains(stavka)) {
//                try {
//                    sacuvajStavku(stavka);
//                } catch (SQLException ex) {
//                    Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//
//                }
//            }
//        }
//
//        for (StavkaRacuna stavka : listaIzBaze) {
//            if (!sr.contains(stavka)) {
//                for(StavkaRacuna srac : sr){
//                    if(srac.getRacun().getRacunID()==stavka.getRacun().getRacunID()){
//                        try {
//                            izbrisiStavku(stavka);
//                        } catch (SQLException ex) {
//                            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    public void sacuvajStavku(StavkaRacuna sr) throws SQLException {
//        String upit = "INSERT INTO StavkaRacuna(RacunID,RB,Kolicina,ProizvodID,Iznos) VALUES (?,?,?,?,?)";
//        int maksID = vratiMaksID2();
//        System.out.println("proizvodID" + vratiProizvodID());
//        System.out.println("RacunID "+sr.getRacun());
//        PreparedStatement ps = konekcija.prepareStatement(upit);
//        ps.setInt(1, sr.getRacun().getRacunID());
//        ps.setInt(2, maksID + 1);
//        ps.setInt(3, sr.getKolicina());
//        ps.setInt(4, sr.getProizvod().getProizvodID());
//        ps.setDouble(5, sr.getIznos());
//
//        ps.executeUpdate();
//    }
//
//    public void izbrisiStavku(StavkaRacuna sr) throws SQLException {
//        String upit = "DELETE FROM StavkaRacuna WHERE RacunID=? AND RB=?";
//
//        PreparedStatement ps = konekcija.prepareStatement(upit);
//        ps.setInt(1, sr.getRacun().getRacunID());
//        ps.setInt(2, sr.getRB());
//
//        ps.executeUpdate();
//    }
}

