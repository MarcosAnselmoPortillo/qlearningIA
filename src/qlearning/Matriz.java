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
        int lado;
        lado = ConfTab.getSize();
        // Poner todos los estados a nuetro
        for (int i = 0; i < lado*lado; i++) {
            Estado e = new Estado();
            e.setRecompensa(ConfTab.getrNeutro());
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
         int lado;
         lado = ConfTab.getSize();
         Random aleat = new Random();
         for (int i = 0; i < lado*lado; i++) {
             Estado e= new Estado();
             e.setPosAbs(i);
             float numale = aleat.nextFloat();
             if (numale<0.2) {
                 e.setRecompensa(ConfTab.getrMalo());
                 
                } else {
                 if (numale < 0.4){
                     e.setRecompensa(ConfTab.getrPozo());
                     
                 } else {
                     if (numale < 0.6){
                         e.setRecompensa(ConfTab.getrNeutro());
                     } else {
                         if (numale < 0.75){
                             e.setRecompensa(ConfTab.getrBueno());
                         } else {
                             if (numale < 1){
                                 e.setRecompensa(ConfTab.getrExc());
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
        int lado;
        lado = ConfTab.getSize();
        i=x*lado+y;
        estados[i].setRecompensa(rTab);
    }
    
    public void aprendizaje(){
        inicializarEstados();
        Estado e = new Estado();
        Random aleat = new Random();
        Accion a = new Accion();
        
        int i = 0;
        while (i < ConfTab.getEpisodios()){
            e = estados[aleat.nextInt(ConfTab.getSize()*ConfTab.getSize()-1)];
            while (e.getRecompensa() != ConfTab.getrFin()){
                if (e.getRecompensa()== ConfTab.getrPozo()){
                    break;
                }
                a = e.accionAleatoria(e);// esta línea se tiene que cambiar de acuerdo a la política
                a.setValorQ(e.getRecompensa()+ConfTab.getGamma()*e.accionMayorQ(e).getValorQ()); 
                e = a.getDestino();
            }
            i++;
        }
    }
    
        //borra la lista de acciones del estado final y agrega una única accion
        //con destino a sí mismo y valor Q alto   
    public void actualizarEstadoFinal(Estado e){
        e.acciones.clear();
        Accion a = new Accion();
        a.setDestino(estados[e.getPosAbs()]);
        a.setValorQ(1000);
        e.acciones.add(a);
        
    }
    
    //escribir la matriz R
    public void testMatrizR(){
        System.out.println("Matriz R");
        int lado = ConfTab.getSize();
	for(int y = 0; y < lado; y++) {
		for(int x = 0; x < lado; x++)
			System.out.format("%05d ", estados[x*lado + y].getRecompensa());
			
		System.out.println();
		}
    }
}
