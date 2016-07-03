/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiTransferObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author Nina777
 */
public class NitKlijent extends Thread {

    Socket soket;

    public NitKlijent(Socket soket) {
        this.soket = soket;
    }

    @Override
    public void run() {
        while (true) {
            KlijentskiTransferObjekat kto = primiZahtev();
            ServerskiTransferObjekat sto = new ServerskiTransferObjekat();
            switch (kto.getOperacija()) {
                
                //TODO: case konstanti u zavisnosti sta se trazi u programu
                
//                case Konstante.VRATI_ANGAZOVANJA:
//                    ArrayList<Angazovanje> listaAng = Kontroler.getInstanca().vratiListuAngazovanja();
//                    sto.setOdgovor(listaAng);
//                    break;
//                case Konstante.VRATI_VRSTE_PROJEKATA:
//                    ArrayList<VrstaProjekta> listaVrPr = Kontroler.getInstanca().vratiListuVrstaProjekata();
//                    sto.setOdgovor(listaVrPr);
//                    break;
//                case Konstante.VRATI_INZENJERE:
//                    ArrayList<Inzenjer> listaInz = Kontroler.getInstanca().vratiListuInzenjera();
//                    sto.setOdgovor(listaInz);
//                    break;
//                case Konstante.SACUVAJ_PROJEKAT:
//                    Projekat proj = (Projekat) kto.getParametar();
//                    boolean sacuvano = Kontroler.getInstanca().sacuvajProjekat(proj);
//                    if (sacuvano) {
//                        sto.setPoruka("Sve uspesno sacuvano");
//                    } else {
//                        sto.setPoruka("Doslo je do greske, nije sacuvano");
//                    }
//                    sto.setOdgovor(sacuvano);
//                    break;
//                case Konstante.SACUVAJ_ANGAZOVANJE:
//                    Angazovanje ang = (Angazovanje) kto.getParametar();
//                    boolean sacuvano1 = Kontroler.getInstanca().sacuvajAngazovanje(ang);
//                    if (sacuvano1) {
//                        sto.setPoruka("Sve uspesno sacuvano");
//                    } else {
//                        sto.setPoruka("Doslo je do greske, nije sacuvano");
//                    }
//                    sto.setOdgovor(sacuvano1);
//                    break;
//                case Konstante.VRATI_ID_PROJEKTA:
//                    int prID = Kontroler.getInstanca().vratiProjekatID();
//                    sto.setOdgovor(prID);
//                    break;
            }
            posalji(sto);
        }
    }

    public void posalji(ServerskiTransferObjekat sto) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(soket.getOutputStream());
            oos.writeObject(sto);
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public KlijentskiTransferObjekat primiZahtev() {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        try {
            ObjectInputStream ois = new ObjectInputStream(soket.getInputStream());
            kto = (KlijentskiTransferObjekat) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kto;
    }
}