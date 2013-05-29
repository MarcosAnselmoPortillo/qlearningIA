package qlearning;

import java.util.Random;


/**
 *
 * @author Leo
 */

public class Matriz {
    
    /**
     * creo q asi queda una lista
     * lo q tengo q ver es como definir que los elementos 
     * sean solo de tipo Estado
     */
    public Estado estados[]; //Arreglo de elementos tipo Estado  
    
    /**
    * Se inicializan todos los estados a neutro
    * para despues poder cambiar a mano los necesarios
    */
    public void inicializarEstados(){
        ConfTab x = new ConfTab ();
        int lado;
        lado = x.getSize();
        // Poner todos los estados a nuetro
        for (int i = 0; i < lado*lado; i++) {
            Estado e = new Estado();
            e.setRecompensa(x.getrNeutro());
            estados[i]= e;               
        }
     }
    
    public void estadosAleat(){
         ConfTab x = new ConfTab();
         int lado;
         lado = x.getSize();
         Random aleat = new Random();
         for (int i = 0; i < lado*lado; i++) {
             Estado e= new Estado();
             float numale = aleat.nextFloat();
             if (numale<0.2) {
                 e.setRecompensa(x.getrMalo());
                 
                } else {
                 if (numale < 0.4){
                     e.setRecompensa(x.getrPozo());
                     
                 } else {
                     if (numale < 0.6){
                         e.setRecompensa(x.getrNeutro());
                     } else {
                         if (numale < 0.75){
                             e.setRecompensa(x.getrBueno());
                         } else {
                             if (numale < 1){
                                 e.setRecompensa(x.getrExc());
                             }
                         }
                     }
                 }
             }
             estados[i]=e;            
        }
     }
}
