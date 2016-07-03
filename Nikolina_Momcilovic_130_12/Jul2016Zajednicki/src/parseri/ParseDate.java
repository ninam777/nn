/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parseri;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nina777
 */
public class ParseDate {
    
    public static Date vratiUtilDatum (String datum){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date d = new Date();
        try {
            d = sdf.parse(datum);
        } catch (ParseException ex) {
            Logger.getLogger(ParseDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    public static java.sql.Date vratiSqlDatum(Date utilDatum){
        java.sql.Date sql = new java.sql.Date(utilDatum.getTime());
        return sql;
    }
}