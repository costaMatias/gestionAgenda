/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionagenda;
import java.util.*;
/**
 *
 * @author benjamin
 */
public class Agenda {
    Lista ag;
    Scanner entrada = new Scanner(System.in);
    Scanner entrada1 = new Scanner(System.in);
    Scanner entrada2 = new Scanner(System.in);
    
    public Agenda(){
        ag = new Lista();
        
    }
    
    public void menu(){
        int opcion=0;
        do{        
            System.out.println("\n");
            System.out.println("+--------Contactos--------+");
            System.out.println("|1-  Agregar contacto     |");
            System.out.println("|2-  Modificar contacto   |");
            System.out.println("|3-  Buscar contacto      |");
            System.out.println("|4-  Eliminar contacto    |");
            System.out.println("|5-  Mostrar contactos    |");
            System.out.println("|0-  Salir                |");
            System.out.println("+-------------------------+\n");
            System.out.print("\n\tIngrese su opcion: ");
            opcion = entrada.nextInt();
            
            switch(opcion){
                case 1:
                    generar();
                    break;
                case 2:
                    modificarContacto();
                    break;
                case 3:
                    
                    if(buscarContacto() != null){
                        Contacto contactoBuscado = buscarContacto().getInfo();
                        mostrarContacto( contactoBuscado );
                    }
                     
                    
                    break;
                case 4:
                    eliminarElementos();
                    break;
                case 5:
                    mostrarLista();
                    break;
                case 0:
                    break;
            }
            
        } while (opcion != 0);
            
            }
    
    
    public void generar(){
        String op;
        Nodo p = ag.getList();
        int num;
        String nomb;
        String dir;
        op="s";
        int op1=0;
        System.out.println("Carga de la lista");
        while (op.charAt(0) != 'n')
        {
            System.out.println("Ingrese un numero: ");
            num = entrada.nextInt();
            entrada.nextLine();
            System.out.println("Ingrese nombre: ");
            nomb = entrada.nextLine();
            System.out.println("Ingrese dirección: ");
            dir = entrada.nextLine();            
            Contacto x = new Contacto(num,nomb,dir);
            System.out.println("Desea agregar al principio o al final?");
            System.out.println("1- Inicio");
            System.out.println("2- Final");
            op1 = entrada.nextInt();
            switch(op1){
                case 1:
                    ag.insertarPrincipio(x);
                    break;
                case 2:
                    ag.insertarFinal(x);
                    break;
                default:
                    break;
            }
            
            System.out.println("Desea seguir cargando");
            System.out.println("s/n");
            System.out.println(" ");
            
            op = entrada.next();
        }
    
        }

    private void eliminarElementos() {
        String opcion;
        System.out.print("¿Desea Borrar un contacto?: s/n");
        opcion = entrada.next();
        while(opcion.charAt(0) != 'n'){
            System.out.println("Ingrese telefono de contacto a eliminar");
            int tel = entrada.nextInt();
            if(BuscarEliminar() != true)
                System.out.println("Eliminación fallída");
            else
                System.out.println("Eliminación Satisfactoria");
            
            System.out.println("Desea eliminar otro contacto?\n s/n :");
            opcion = entrada.next();
        }
    }

    private void mostrarLista() {
        Nodo p = ag.getList();
        int nroContacto = 0;
        while(p != null){
            System.out.println("----------Contacto nro "+nroContacto+"---------");
            System.out.println("Número: "+ p.getInfo().getNumt());
            System.out.println("Nombre: "+ p.getInfo().getNomb());
            System.out.println("Dirección: "+ p.getInfo().getDir());
            System.out.println("----------------------------------\n");
            p = p.getPs();
            nroContacto += 1;
        }
    }

   

    private Nodo buscarContacto() {
       Nodo p;
       Nodo contactoAux = null;
       boolean b=false;
       String nomBuscar;
       int nroBuscar;
       int opcion;
       System.out.println("\tRealizar busqueda por: ");
       System.out.println("\t 1- Numero de telefono");
       System.out.println("\t 2- Nombre de contacto\n\n");
       opcion = entrada.nextInt();
       switch(opcion){
           case 1:
               System.out.println("Ingrese telefono de contacto que desea buscar:");
               nroBuscar  = entrada.nextInt();
               p = ag.getList();
               while((p!=null) && (b != true)){
                   if( nroBuscar == (p.getInfo().getNumt()) ){
                   b=true;
                   contactoAux = p;                   
               }
                   p = p.getPs();
               }
               
               break;
               
           case 2:
               
               System.out.println("Ingrese nombre de contacto que desea buscar: ");
               entrada.nextLine();
       nomBuscar = entrada.nextLine();
       p = ag.getList();
       while((p != null) && (b != true)){
           if((p.getInfo().getNomb().compareTo(nomBuscar))== 0){
               b = true;
               contactoAux = p;
           }
           p = p.getPs();
       }
       
               break;
               
           default:
               System.out.println("Opcion no valida\n\n");
               break;
       }
       if (b){
           System.out.println("Contacto encontrado!");
           return contactoAux;
           
       }
       else
           System.out.println("Contacto inexistente");
       
       return null;
    }

     private boolean BuscarEliminar() {
        Nodo p = null;
        Nodo q = null;
           int b=0;
         if(buscarContacto() != null)           
       {
            p = buscarContacto();
           
               Nodo contactDeleted = ag.quitar(q, p);
               System.out.println("Contacto eliminado: ");
               System.out.println("Nombre: "+contactDeleted.getInfo().getNomb());
               System.out.println("Dirección: "+ contactDeleted.getInfo().getDir());
               System.out.println("--------------------------------------\n\n");
               p = null;
               b = 1;
           }
           else {
               q = p;
               p = p.getPs();
           }
       
       if (b == 1)
           return true;
       else
           return false;
    }

    private void modificarContacto() {
        ;
    }

        
    public void mostrarContacto(Contacto contact){
        
            System.out.println("+------"+contact.getNomb()+"----------------");
            System.out.println("| Número: "+contact.getNumt());
            System.out.println("| Dirección: "+ contact.getDir());
            System.out.println("+--------------------------------------");
            
    }
    
}
