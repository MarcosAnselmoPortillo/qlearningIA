package qlearning;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Grupo 6
 */
public class Estado {
    
    public float recompensa; //Valor de recompensa para el estado
    
    public ArrayList<Accion> acciones; //lista de acciones válidas
    
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
    
    public Accion accionMayorQ(Estado e){
        int longLista = acciones.size();
//        Estado eMayorQ = e.acciones.get(0).destino;
        Accion aMayorQ = new Accion();
        if (longLista >0){ // pude pasar que la lista de estados esté vacía??
            float valorQresg = acciones.get(0).valorQ;
            for (int i = 0 ; i < longLista;i++){
                if (acciones.get(i).valorQ > valorQresg){
                    aMayorQ = acciones.get(i);
                }
            } 
        }
               
        return aMayorQ;
    }
    
    public Accion accionAleatoria (Estado e){
        int x = new Random().nextInt(e.acciones.size());
        Accion accion = e.acciones.get(x);
        return accion;
    }
        
}