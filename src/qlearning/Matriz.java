package qlearning;

import java.io.File;
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
    
    public static float[] matQAnt;
    
    public static float[] matQSig;
    
    public static boolean compMatQ = false;
    /**
    * Se agregan todas las acciones posibles que cada estado puede realizar y se setea
    * el valor de Q incial en cada acción.
    * En cada posición del arreglo de estados, se comprueba cuáles de los 8 movimientos
    * posibles puede realizar ese estado. Se comprueban los movimientos en la siguiente
    * secuencia: NorOeste (NO), Norte (N), NorEste(NE), Este (E), SurEste (E), Sur (S),
    * SurOeste (SO) y Oeste (O).
    * Un movimiento es válido si los índices del estado en la "matriz" de estados no son
    * menores a 0 y mayores a el tamaño del lado de la matriz de estados.
    */
    public static void inicializarEstados(){
        //inicializar el vector estados
        cargarEstados();
        int lado;
        lado = ConfTab.getSize();
        for (int i = 0; i < lado*lado; i++) {
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
  
    /**
     * En este método se aplica Q-Learning
     */
    public static void aprendizaje(){
        long tiempoInicio = System.currentTimeMillis(); // Para controlar el tiempo
        Random aleat = new Random();
        Politica p = new Politica();
        int i = 0; 
        float nuevoQ;
        inicializarMatQ();
        boolean esPozo=false;
        while (i < ConfTab.getEpisodios() && !compMatQ){
            int indice = ConfTab.getSize()*ConfTab.getSize();
            int posAleat = aleat.nextInt(indice);
            Estado e = estados[posAleat];
            int posAccion ;
            boolean trancada = false;
            do {
                //selección de la acción según la política de selección elegida
                if (ConfTab.getEpsilon()!= -1) {
                    posAccion = p.eGreedy(e);
                } else {
                    posAccion = p.softmax(e);
                }
                //cálculo de la función de valor
                float a = e.getRecompensa();
                float b = ConfTab.getGamma();
                int aux = e.acciones.get(posAccion).getDestino();
                float c = estados[aux].acciones.get(estados[aux].posAccionMayorQ()).getValorQ();
                nuevoQ = (a + (b*c));
                e.acciones.get(posAccion).setValorQ(nuevoQ); 
                //verificación si el estado es Pozo
                if (e.getRecompensa()== ConfTab.getrPozo()){
                   esPozo=true;
                }
                e = estados[e.acciones.get(posAccion).getDestino()];
                //verificación del tiempo transcurrido en el episodio
                long transcurrido = System.currentTimeMillis() - tiempoInicio;		
		if(transcurrido > ConfTab.tiempoLimite)
			trancada = true;
            } while (e.getRecompensa() != ConfTab.getrFin() && !trancada && !esPozo);
            i++;
            System.out.println("numero de episodio" + i);
//            if ((i%50) == 0) {
//                for (int j = 0; j < estados.length; j++) {
//                    reducirQ(estados[j]);
//                }
//            }
            // cada 100 episodios, verifica la evolución del aprendizaje
            if ((i%100) == 0){ 
                cargarValoresQ();
                compMatQ = compararMatricesQ();
                System.arraycopy(matQSig, 0, matQAnt, 0, estados.length);
                if (compMatQ) {
                    System.out.println("Episodio en que se estabiliza: " + i);
                }
            }
        }
    }
      
    /**
     * borra la lista de acciones del estado final y agrega una única accion
     * con destino a sí mismo y valor Q ConfTab.valorQ
     * @param posAbs: posición del estado final 
     */
    public static void actualizarEstadoFinal(int posAbs){
        estados[posAbs].acciones.clear();
        Accion a = new Accion();
        a.setDestino(posAbs);
        a.setValorQ(ConfTab.valorQ);
        estados[posAbs].acciones.add(a);
    }
    
    
//    public static  void reducirQ(Estado estado){
//        int x = estado.acciones.size();
//        for (int i = 0; i < x; i++) {
//            float qAnt = estado.acciones.get(i).getValorQ();
//            estado.acciones.get(i).setValorQ((float) (qAnt*0.1));
//        }
//    }    
    
    /**
     * inicializa el arreglo estados con la long size*size y
     * agrega un estado a cada posicion del vector
     */
    public static void cargarEstados(){
        estados = new Estado[ConfTab.getSize()*ConfTab.getSize()];
        for (int i = 0;i<estados.length;i++){
            Estado e = new Estado();
            e.setPosAbs(i);
            estados[i]= e;
        }
    }
    
    /**
     * inicializa los vectores con los cuales se hace la verificación de la estabilización
     * del aprendizaje.
     */        
    public static void inicializarMatQ (){
        compMatQ = false;
        matQAnt = new float[ConfTab.getSize()*ConfTab.getSize()];
        matQSig = new float[ConfTab.getSize()*ConfTab.getSize()];
        for (int i = 0; i < matQSig.length; i++) {
            matQAnt[i] = ConfTab.valorQ;
            matQSig[i] = ConfTab.valorQ;
        }
    }
    
    //  
    // 
    // 
    /**
     * Desde el estado de posicion inicial, toma la acción del mayor Q. El estado siguiente
     * es  el estado destino de esa accion.
     * Se guarda la posición del estado actual en un ArrayList para saber cuál es el camino recorrido
     * Se almacena la posicion del estado inicial y también la posicion absoluta del estado final
     * @return recorrido: lista de estados visitados
     */
    public static ArrayList recorrer(){
        long tiempoInicio = System.currentTimeMillis(); // Para controlar el tiempo
        ArrayList recorrido = new ArrayList();
        int posEstado = Tablero.posInic;
        int posAccion;
        System.out.println("Estados visitados:" + posEstado);
        boolean acorralado = false;
        if (rodeadoPozos()) {
            acorralado = true;
        } else {
            while (estados[posEstado].getRecompensa()!=ConfTab.getrFin() && !acorralado){
                recorrido.add(posEstado);
                posAccion = estados[posEstado].posAccionMayorQ();
                posEstado = estados[posEstado].acciones.get(posAccion).getDestino();
                System.out.println("Estados visitados:" + posEstado);
                long transcurrido = System.currentTimeMillis() - tiempoInicio;		
                if(transcurrido > (ConfTab.tiempoLimite)){
                    acorralado = true;
                    System.out.println("se cortó por tiempo en el recorrido");
                }
            }
        }
        if (acorralado){
            recorrido.clear();
        } else recorrido.add(posEstado);
        return recorrido;
        
    }
    
    // compara los valores q. 
    // el valor de q que se almacena es el valor de la accion de mayor q de ese estado.
    // devuelve verdadero cuando no hay gran variacion entre las matrices q
    public static boolean compararMatricesQ (){
        float error = 0;
        float diferencia;
        System.out.println("Matriz q siguiente: " + matQSig.toString());
        System.out.println("Matriz q anterior: " + matQAnt.toString());
        for (int i = 0;i<estados.length;i++){
            diferencia = matQSig[i]- matQAnt[i];
            error += (Math.pow(diferencia,2))/2;    
        }
        System.out.println("error: " + error);
        if (error <= ConfTab.getTolerancia()) { 
            return true; // significa que no hay grandes variaciones en el aprendizaje
        } else return false;
    }
    
    public static void cargarValoresQ () {
        for (int i = 0;i < matQSig.length;i++) {
            int posAccion = estados[i].posAccionMayorQ();
            matQSig[i]= estados[i].acciones.get(posAccion).getValorQ();
        }
    }
    
    public static boolean rodeadoPozos(){
        int cantidadPozos = 0;
        int posEstadoDestino;
        for (int i = 0; i < estados[Tablero.posInic].acciones.size(); i++) {
            posEstadoDestino = estados[Tablero.posInic].acciones.get(i).getDestino();
            if (estados[posEstadoDestino].getRecompensa()==ConfTab.getrPozo()) {
                cantidadPozos++;
            }
        }
        if (cantidadPozos == estados[Tablero.posInic].acciones.size()) {
            return true;
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

         //escribir la matriz Q
    public static void testMatrizQ(float[] matriz){
        System.out.println("Matriz Q");
        int lado = ConfTab.getSize();
	for(int y = 0; y < lado; y++) {
		for(int x = 0; x < lado; x++)
                        System.out.print(" " +matriz[x + y*lado] + " ");
			
		System.out.println();
		}
    }

}

