/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nina777
 */
public class ModelTabeleKlijent  extends AbstractTableModel {
//    TODO: lista onoga sto su polja u tabeli, agregacija u modelu
//    ArrayList<Angazovanje> listaAngazovanja;
    //        TODO: Zameni Object za agregaciju
    ArrayList<Object> lista;
//    String nazivProjekta = "";

//    public String getNazivProjekta() {
//        return nazivProjekta;
//    }
//
//    public void setNazivProjekta(String nazivProjekta) {
//        this.nazivProjekta = nazivProjekta;
//    }

    public ModelTabeleKlijent() {
        lista = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
//        TODO: promeni broj kolona sa brojem kolona u tabeli klijenta
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        TODO: Zameni Object za agregaciju
        Object ang = lista.get(rowIndex);

        switch (columnIndex) {
//            TODO: namesti kolone
//            case 0:
//                return nazivProjekta;
//            case 1:
//                return ang.getInzenjer();
//            case 2:
//
//                if (ang.getDatumAngazovanja() == null) {
//                    return "";
//                }
//                return new SimpleDateFormat("dd.MM.yyyy").format(ang.getDatumAngazovanja());

            default:
                return "N/A";
        }

    }
//  TODO: namesti imena kolona
    String[] kolone = {"Projekat", "Inzenjer", "DatumAngazovanja"};

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
//        TODO: ukoliko zelimo da zabranimo promenu neke kolone ili polja u tabeli
//        if (columnIndex == 0) {
//            return false;
//        }

        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //        TODO: Zameni Object za agregaciju
        Object ang = lista.get(rowIndex);

        switch (columnIndex) {
//            TODO: podesi kolone
//            case 0:
//                ang.setProjekat((Projekat) aValue);
//                break;
//            case 1:
//                ang.setInzenjer((Inzenjer) aValue);
//                break;
//            case 2:
//
//                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//                Date datum;
//
//                 {
//                    try {
//                        datum = sdf.parse((String) aValue);
//                        ang.setDatumAngazovanja(datum);
//                    } catch (ParseException ex) {
//                        datum = new Date();
//                    }
//
//                    break;
//                }

        }
    }
    
//        TODO: Zameni Object za agregaciju
    public ArrayList<Object> getListaAngazovanja() {
        return lista;
    }
    
//        TODO: Zameni Object za agregaciju
    public void setListaDezurstava(ArrayList<Object> lista) {
        this.lista = lista;
    }

    public void dodajRed() {
//        TODO: Zameni Object za agregaciju
        lista.add(new Object());
        fireTableDataChanged();
    }

    public void obrisiRed(int red) {
        lista.remove(red);
        fireTableDataChanged();
    }

    public void skloniPodatke() {
        lista = new ArrayList<>();
        fireTableDataChanged();
    }

}
