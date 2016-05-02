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
public class Lista {
    private Nodo list;
    
    public Lista(){
        list = null;
    }
    
    public boolean vacia(){
        if(list == null)
            return true;
        else
            return false;
            }
    
    public Nodo getList() {
        return list;
    }
    
    public void insertarPrincipio(Contacto dato){
        Nodo x= new Nodo(dato);
        if(list == null)
            list = x;
        else{
            x.setPs(list);
            list = x;
        }
    }
    
    
    public Nodo quitar(Nodo q, Nodo p){
        Nodo x = p;
        if(list == p)
            list = list.getPs();
        else
            q.setPs(p.getPs());
        return x;
    }
    
    
    public void insertarAntes(Contacto dato){
        Nodo x= new Nodo(dato);
        Nodo p = list;
        Nodo q = null;
        System.out.println("Ingrese nombre");
        
    }
    
    public void insertarFinal(Contacto dato){
        Nodo p=list;
        while(p.getPs() != null)
            p=p.getPs();
        Nodo q = new Nodo(dato);
        p.setPs(q);
        
    }
}
