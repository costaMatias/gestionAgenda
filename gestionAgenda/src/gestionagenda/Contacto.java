/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionagenda;;
/**
 *
 * @author benjamin
 */
public class Contacto {
    private int numt;
    private String nomb;
    private String dir;

    public Contacto(int numt, String nomb, String dir) {
        this.numt = numt;
        this.nomb = nomb;
        this.dir = dir;
    }

    public int getNumt() {
        return numt;
    }

    public String getNomb() {
        return nomb;
    }

    public String getDir() {
        return dir;
    }

    public void setNumt(int numt) {
        this.numt = numt;
    }

    public void setNomb(String nomb) {
        this.nomb = nomb;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }
    
    
}
