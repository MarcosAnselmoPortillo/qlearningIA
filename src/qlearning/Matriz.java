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
   
    public static Estado[] estados; //Arreglo de elementos tipo Estado  
    
    public static float[] mat1;
    
    public static float[] mat2;
    
    public static boolean compMatQ = false;
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
            
            estados[i].setRecompensa(ConfTab.getrNeutro());
            
            //inicializando la lista de acciones posibles
            int posY = i/lado;
            int posX = i%lado;
            //comprobar movimiento NO
            int desY = posY - 1;
            int desX = posX - 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }
            //comprobar movimiento N
            desY = posY - 1;
            desX = posX;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }
            //comprobar movimiento NE
            desY = posY - 1;
            desX = posX + 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }
            //comprobar movimiento E
            desY = posY;
            desX = posX + 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }
            //comprobar movimiento SE
            desY = posY + 1;
            desX = posX + 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }
            //comprobar movimiento S
            desY = posY + 1;
            desX = posX;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }
            //comprobar movimiento SO
            desY = posY + 1;
            desX = posX - 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }
            //comprobar movimiento O
            desY = posY;
            desX = posX - 1;
            if (desY >= 0 && desY < lado && desX >= 0 && desX < lado){
                Accion a = new Accion();
                a.setDestino(estados[(desX +lado*desY)].getPosAbs());
                a.setValorQ(ConfTab.valorQ);
                estados[i].acciones.add(a);
            }              
        }
     }
  
    public static void aprendizaje(){
        Random aleat = new Random();
        Politica p = new Politica();
        int i = 0;
        float nuevoQ;
        while (i < ConfTab.getEpisodios() && !compMatQ){
            int indice = ConfTab.getSize()*ConfTab.getSize();
            int posAleat = aleat.nextInt(indice - 1);
            Estado e = estados[posAleat];
            int posAccion ;
            
            do {
                if (ConfTab.getEpsilon()!= -1) {
                    posAccion = p.eGreedy(e);
                } else {
                    posAccion = p.softmax(e);
                }
                //posAccion = e.accionAleatoria();
                float a = estados[e.acciones.get(posAccion).getDestino()].getRecompensa();
                float b = ConfTab.getGamma();
                float c = e.acciones.get(e.posAccionMayorQ()).getValorQ();
                //nuevoQ = e.getRecompensa()+ConfTab.getGamma()*e.acciones.get(e.accionMayorQ()).getValorQ();
                nuevoQ = (a + (b*c));
                e.acciones.get(posAccion).setValorQ(nuevoQ); 
                if (e.getRecompensa()== ConfTab.getrPozo()){
                    break;
                }
                e = estados[e.acciones.get(posAccion).getDestino()];             
            } while (e.getRecompensa() != ConfTab.getrFin());
            i++;
            //compMatQ = compararMatricesQ();
        }
    }
    
        //borra la lista de acciones del estado final y agrega una única accion
        //con destino a sí mismo y valor Q ConfTab.valorQ   
    public static void actualizarEstadoFinal(int posAbs){
        estados[posAbs].setRecompensa(ConfTab.getrFin()); //agregado sólo para probar desde aca
        estados[posAbs].acciones.clear();
        Accion a = new Accion();
        a.setDestino(posAbs);
        a.setValorQ(0);
        estados[posAbs].acciones.add(a);
    }
    
   
    
    
    // inicializa los arreglos estados, mat1 y mat2 con la long size*size
    // agrega un estado a cada posicion del vector estados
    public static void cargarEstados(){
        estados = new Estado[ConfTab.getSize()*ConfTab.getSize()];
        mat1 = new float[ConfTab.getSize()*ConfTab.getSize()];
        mat2 = new float[ConfTab.getSize()*ConfTab.getSize()];
        for (int i = 0;i<estados.length;i++){
            Estado e = new Estado();
            e.setPosAbs(i);
            e.setRecompensa(0);
            estados[i]= e;
            mat1[i] = ConfTab.valorQ;
            mat2[i] = ConfTab.valorQ;
        }
    }
    
    // desde el estado de posicion inicial, toma la acción del mayor Q. El estado siguiente es  el estado destino de esa accion
    // se guarda la posición del estado actual en un ArrayList para saber cuál es el camino recorrido
    // se almacena la posicion del estado inicial y también la posicion absoluta del estado final
    public static ArrayList recorrer(){
        ArrayList recorrido = new ArrayList();
        int posEstado = Tablero.posInic;
        int posAccion;
        while (estados[posEstado].getRecompensa()!=ConfTab.getrFin()){
            recorrido.add(posEstado);
            //posAccion = estados[posAux].accionQOptimo(); // se obtiene la posicion de la accion de mayor Q
            posAccion = estados[posEstado].posAccionMayorQ();
            posEstado = estados[posEstado].acciones.get(posAccion).getDestino();
            //posAux = estados[posAux].acciones.get(posAccion).getDestino(); // se actualiza posAux
        }
        recorrido.add(posEstado);
        return recorrido;
    }
    
    // compara los valores q. 
    // el valor de q que se almacena es el valor de la accion de mayor q de ese estado.
    // devuelve verdadero cuando no hay gran variacion entre las matrices q
    public static boolean compararMatricesQ (){
        float error = 0;
        float diferencia;
        for (int i = 0;i<estados.length;i++){
            diferencia = mat1[i]-mat2[i];
            error += (Math.pow(2, diferencia))/2;
            
        }
        if (error <= ConfTab.getTolerancia()) { 
            return true; // significa que no hay grandes modificaciones en el aprendizaje
        } else return false;
    }
    
    
    
    //////////////PARA PRUEBAS///////////////////////

    
//     //escribir la matriz R
//    public static void testMatrizR(){
//        System.out.println("Matriz R");
//        int lado = ConfTab.getSize();
//	for(int y = 0; y < lado; y++) {
//		for(int x = 0; x < lado; x++)
//                        System.out.print(estados[x + y*lado].getRecompensa()+ " ");
//			
//		System.out.println();
//		}
//    }
    
//    public static void main (String[] args){
//        //ConfTab x = new ConfTab();
//        ConfTab.setSize(6);
//        inicializarEstados();
//        estadosAleat();
//        actualizarEstadoFinal(3);
//        //cargarRecompensasTest();
//        //ConfTab.setEpsilon((float)0.2);
//        testMatrizR();
//        ConfTab.setEpisodios(10000);
//        aprendizaje();
//        testMatrizR();
//    }
//        public static void estadosAleat(){
//         int lado;
//         lado = ConfTab.getSize();
//         Random aleat = new Random();
//         for (int i = 0; i < lado*lado; i++) {
//             float numale = aleat.nextFloat();
//             if (numale<0.2) {
//                 estados[i].setRecompensa(ConfTab.getrMalo());
//                 
//                } else {
//                 if (numale < 0.4){
//                     estados[i].setRecompensa(ConfTab.getrPozo());
//                     
//                 } else {
//                     if (numale < 0.6){
//                         estados[i].setRecompensa(ConfTab.getrNeutro());
//                     } else {
//                         if (numale < 0.75){
//                             estados[i].setRecompensa(ConfTab.getrBueno());
//                         } else {
//                             if (numale < 1){
//                                 estados[i].setRecompensa(ConfTab.getrExc());
//                             }
//                         }
//                     }
//                 }
//             }          
//        }
//     }
//        
//        public static void cargarRecompensasTest(){
//            estados[0].setRecompensa(ConfTab.getrPozo());
//            estados[1].setRecompensa(ConfTab.getrNeutro());
//            estados[2].setRecompensa(ConfTab.getrPozo());
//            estados[7].setRecompensa(ConfTab.getrMalo());
//            estados[5].setRecompensa(ConfTab.getrNeutro());
//            estados[8].setRecompensa(ConfTab.getrBueno());
//            estados[6].setRecompensa(ConfTab.getrExc());
//            estados[4].setRecompensa(ConfTab.getrNeutro());
//        }
}
