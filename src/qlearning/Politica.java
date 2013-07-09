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
    public int eGreedy (Estado e){
        int posAccion;
        if (ConfTab.getEpsilon() < numAleat()) {
            posAccion = e.posAccionMayorQ();
        } else {
            posAccion = e.accionAleatoria();
        }
        return posAccion;
    }
    
    //Politica de seleccion de acciones Softmax
    public int softmax (Estado e){
        Accion a;
        int longLista = e.acciones.size();
        double valorTau = ConfTab.getTau();
        float sum = 0;
        for (int i = 0; i < longLista; i++) {        
            sum += (float) Math.exp(e.acciones.get(i).getValorQ()/valorTau);
        }
        for (int i = 0; i < longLista; i++) {
            a = e.acciones.get(i);
            float total = (float) (Math.exp(a.getValorQ()/valorTau)/sum);
            a.setProb(total);
        }
        double rand = numAleat();
        float limInf = 0;
        float limSup = 0;
        int y = 0;
        for (int i = 0; i < longLista; i++) {
            a = e.acciones.get(i); 
            limSup += a.getProb();
            if (rand > limInf && rand < limSup) {
                y = i;
                return y;
            }
            limInf += a.getProb();
        }
        return y;
    }
}
