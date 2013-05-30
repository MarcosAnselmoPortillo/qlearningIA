package qlearning;

import java.util.ArrayList;

/**
 *
 * @author Grupo 6
 */
public class Estado {
    
    public float recompensa; //Valor de recompensa para el estado
    
    public ArrayList<Accion> acciones;
    
    public int posAbs;

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
    
    
}
