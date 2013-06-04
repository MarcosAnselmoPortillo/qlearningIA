package qlearning;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author Grupo 6
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
            e.setPosAbs(i);
            //inicializando la lista de acciones posibles
            int posY = i/lado;
            int posX = i%lado;
            //comprobar movimiento NO
            int desY = posY - 1;
            int desX = posX - 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
            //comprobar movimiento N
            desY = posY - 1;
            desX = posX;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
            //comprobar movimiento NE
            desY = posY - 1;
            desX = posX + 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
            //comprobar movimiento E
            desY = posY;
            desX = posX + 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
            //comprobar movimiento SE
            desY = posY + 1;
            desX = posX + 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
            //comprobar movimiento S
            desY = posY + 1;
            desX = posX;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
            //comprobar movimiento SO
            desY = posY + 1;
            desX = posX - 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
            //comprobar movimiento O
            desY = posY;
            desX = posX - 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX*lado+desY)]);
                a.setValorQ(0);
                e.acciones.add(a);
            }
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
             e.setPosAbs(i);
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
    
    /**
     * la idea es recuperar de la interfaz la recompensa del estado 
     * que se quiere setear, y modificar, en la posición seleccionada,
     * la recompensa de ese estado.
     */
    
    public void estadosManuales(float rTab, int x, int y){
        int i;
        ConfTab tab = new ConfTab();
        int lado;
        lado = tab.getSize();
        i=x*lado+y;
        estados[i].setRecompensa(rTab);
    }
    
    
}
