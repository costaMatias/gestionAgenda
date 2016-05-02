/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionagenda;

/**
 *
 * @author benjamin
 */
public class Nodo {
    private Contacto info;
    private Nodo ps;

    public Nodo(Contacto info2) {
        this.info = info2;
        this.ps = null;
    }

    public Contacto getInfo() {
        return info;
    }

    public Nodo getPs() {
        return ps;
    }

    public void setInfo(Contacto info) {
        this.info = info;
    }

    public void setPs(Nodo ps) {
        this.ps = ps;
    }
    
    
}
