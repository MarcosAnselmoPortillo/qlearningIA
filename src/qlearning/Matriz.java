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
    // hay que ver como se lo inicializa..
    public static Estado[] estados; //Arreglo de elementos tipo Estado  
    
    /**
    * Se inicializan todos los estados a neutro
    * para despues poder cambiar a mano los necesarios
    */
    public static void inicializarEstados(){
        cargarEstados();
        int lado;
        lado = ConfTab.getSize();
        // Poner todos los estados a nuetro
        for (int i = 0; i < lado*lado; i++) {
            Estado e = estados[i];
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
        }
     }
    
    public static void estadosAleat(){
         int lado;
         lado = ConfTab.getSize();
         Random aleat = new Random();
         for (int i = 0; i < lado*lado; i++) {
             float numale = aleat.nextFloat();
             if (numale<0.2) {
                 estados[i].setRecompensa(ConfTab.getrMalo());
                 
                } else {
                 if (numale < 0.4){
                     estados[i].setRecompensa(ConfTab.getrPozo());
                     
                 } else {
                     if (numale < 0.6){
                         estados[i].setRecompensa(ConfTab.getrNeutro());
                     } else {
                         if (numale < 0.75){
                             estados[i].setRecompensa(ConfTab.getrBueno());
                         } else {
                             if (numale < 1){
                                 estados[i].setRecompensa(ConfTab.getrExc());
                             }
                         }
                     }
                 }
             }          
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
    
    public static void aprendizaje(){
        //inicializarEstados();
        Random aleat = new Random();
        Politica p = new Politica();
        int i = 0;
        while (i < ConfTab.getEpisodios()){
            int indice = ConfTab.getSize()*ConfTab.getSize();
            int pos = aleat.nextInt(indice - 1);
            Estado e = estados[pos];
            //System.out.println("Recompensa en aprendizaje " + e.getRecompensa() + " PosAbs " + e.getPosAbs() + " Pos: " + pos);
            while (e.getRecompensa() != ConfTab.getrFin()){
                if (e.getRecompensa()== ConfTab.getrPozo()){
                    break;
                }
                Accion a = e.accionAleatoria();// esta línea se tiene que cambiar de acuerdo a la política
                //a = p.eGreedy(e); // esta acción o la aleatoria es la que esta teniendo problemas
                a.setValorQ(e.getRecompensa()+ConfTab.getGamma()*e.accionMayorQ().getValorQ()); 
                //System.out.println(a.getValorQ());
                //System.out.println(a.getDestino());
                e = a.getDestino();
                //System.out.println("Recompensa " + e.getRecompensa());
            }
            i++;
        }
    }
    
        //borra la lista de acciones del estado final y agrega una única accion
        //con destino a sí mismo y valor Q alto   
//    public void actualizarEstadoFinal(Estado e){
//        e.acciones.clear();
//        Accion a = new Accion();
//        a.setDestino(estados[e.getPosAbs()]);
//        a.setValorQ(1000);
//        e.acciones.add(a);
//        
//    }
    
    public static void actualizarEstadoFinal(int posAbs){
        estados[posAbs].acciones.clear();
        Accion a = new Accion();
        a.setDestino(estados[posAbs]);
        a.setValorQ(1000);
        estados[posAbs].acciones.add(a);
        //para probar..
        //estados[posAbs].setRecompensa(ConfTab.getrFin());
    }
    
    //escribir la matriz R
    public static void testMatrizR(){
        System.out.println("Matriz R");
        int lado = ConfTab.getSize();
	for(int y = 0; y < lado; y++) {
		for(int x = 0; x < lado; x++)
                        System.out.print(estados[x + y*lado].getRecompensa()+ " ");
			
		System.out.println();
		}
    }
    
//    public static void main (String[] args){
//        //ConfTab x = new ConfTab();
//        ConfTab.setSize(3);
//        inicializarEstados();
//        estadosAleat();
//        actualizarEstadoFinal(3);
//        ConfTab.setEpsilon((float)0.2);
//        testMatrizR();
//        aprendizaje();
//        testMatrizR();
//    }
    
    public static void cargarEstados(){
        estados = new Estado[ConfTab.getSize()*ConfTab.getSize()];
        for (int i = 0;i<estados.length;i++){
            Estado e = new Estado();
            //e.setPosAbs(i);
            e.setRecompensa(0);
            estados[i]= e;
        }
    }
}
