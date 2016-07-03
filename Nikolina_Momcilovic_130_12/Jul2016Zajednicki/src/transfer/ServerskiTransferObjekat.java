/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Nina777
 */
public class ServerskiTransferObjekat implements Serializable{
    private String poruka;
    private Object odgovor;

    public ServerskiTransferObjekat() {
    }

    public ServerskiTransferObjekat(String poruka, Object odgovor) {
        this.poruka = poruka;
        this.odgovor = odgovor;
    }

    public Object getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(Object odgovor) {
        this.odgovor = odgovor;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
    
}

