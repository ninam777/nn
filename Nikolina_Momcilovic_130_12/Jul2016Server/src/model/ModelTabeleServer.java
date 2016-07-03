/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import pomocneKlase.PrikazKlasa;

/**
 *
 * @author Nina777
 */
public class ModelTabeleServer extends AbstractTableModel{

    ArrayList<PrikazKlasa> lista;

    public ModelTabeleServer(ArrayList<PrikazKlasa> lista) {
        this.lista = lista;
    }
    
    
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 3; // TODO: promeni broj kolona, shodno tome koliko kolona ima u tabeli
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PrikazKlasa pk = lista.get(rowIndex);
        
        switch(columnIndex){
            // TODO: Klasa pk ima ove kolone kao svoje atribute, tako da ih samo treba pozvati
//            case 0: return pk.getProjekat();
//            case 1: return pk.getVrstaProjekta(); 
//            case 2: return pk.getBrAngazovanih();
            default:return "N/A";
        }
    }
//    TODO: promeni ime kolona u shodno onome kako se zove u ovom projektu
    String[] kolone = {"Projekat","VrstaProjekta","BrojAngazovanih"};

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
}