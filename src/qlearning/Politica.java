/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qlearning;

import java.util.Random;

/**
 *
 * @author Grupo 6
 */
public class Politica {
    
    //Genera un numero aleatorio mayor o igual que 0.0 y menor que 1.0
    public static double redondear(double numero,int numeroDecimales) {
        long mult=(long)Math.pow(10,numeroDecimales);
        double resultado=(Math.round(numero*mult))/(double)mult;
        return resultado;
    }
    public double numAleat (){
        
        Random x = new Random();
        double rand = redondear (x.nextDouble(), 2);
        return rand;
    }
    

    //Politica de seleccion de acciones e-greedy
    public Accion eGreedy (Estado e){
        if (ConfTab.getInstance().getEpsilon() < numAleat()) {
            
                        
        }
        
        return a;
    }
    
    //Politica de seleccion de acciones Softmax
    public Accion softmax (Estado e){
        
        return a;
    }
}
