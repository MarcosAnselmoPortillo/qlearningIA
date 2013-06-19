package qlearning;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Grupo 6
 */
public class Estado {
    
    public float recompensa; //Valor de recompensa para el estado
    
    public ArrayList<Accion> acciones = new ArrayList(); //lista de acciones válidas
    
    public int posAbs;  //posicion absoluta del estado en la matriz

    public ArrayList<Accion> getAcciones() {
        return acciones;
    }

    public void setAcciones(ArrayList<Accion> acciones) {
        this.acciones = acciones;
    }
    
    public int getPosAbs() {
        return posAbs;
    }

    public void setPosAbs(int posAbs) {
        this.posAbs = posAbs;
    }

    public float getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(float recompensa) {
        this.recompensa = recompensa;
    }
    
    public int posAccionMayorQ(){
        
        int longLista = this.acciones.size();
        //Estado eMayorQ = e.acciones.get(0).destino;
        //Accion aMayorQ = this.getAcciones().get(0);
        int posAccion = 0;
        float valorQresg = 0;
        for (int i = 0 ; i < longLista;i++){
            if (acciones.get(i).valorQ > valorQresg){
                    //posAccion = acciones.get(i).;
                    posAccion = i;
                    valorQresg = acciones.get(i).valorQ;
            }
        }        
        return posAccion;
    }
    
    // devuelve la posición del ArrayList acciones de la accion que tiene el qPromedio mas alto
    public int accionQOptimo(){
        float prom;
        float promResguardo = 0;
        int posEstado,posAccionOpt = 0;
        for (int i = 0; i < this.acciones.size(); i++) {
            posEstado = this.acciones.get(i).getDestino();
            prom = Matriz.estados[posEstado].qPromedio();
            if (i==0) {
                posAccionOpt = 0;
                promResguardo = prom;
            }
            if (promResguardo <= prom) {
                posAccionOpt = i;
                promResguardo = prom;
            }
        }
        return posAccionOpt;
    }
    
    //calcula el valor q promedio de un estado
    public float qPromedio(){
        float prom = 0;
        for (int i = 0;i<this.acciones.size();i++){
            prom += this.acciones.get(i).getValorQ();
        }
        prom = prom/this.acciones.size();
        return prom;
    }
    public int accionAleatoria (){
        int posAccion;
        int size = this.acciones.size();
        if (size <= 1){
            posAccion = 0;
        } else {
            int x = new Random().nextInt(size);
            posAccion = x;
        }
        
        return posAccion;
    }
    
    
}