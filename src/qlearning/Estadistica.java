/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qlearning;

import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Grupo 6
 */
public class Estadistica {
    
    public static ArrayList tableros = new ArrayList();
    
    /**
     * Guarda la configuracion del tablero, para utilizarla en pruebas
     */
    public static void guardarTablero(){
        tableros.add(Tablero.estados);
    }
    
    public static JButton[] cargarTablero(int pos){
        return (JButton[]) tableros.get(pos);
    }
}
