package qlearning;

/**
 *
 * @author Grupo 6
 */
public class Accion {
    
    public float valorQ;
    
    public int destino; //posición del estado destino de la acción
     
    public float prob; //Probabilidad de elegir esta accion para softmax o cuando explora

    public float getValorQ() {
        return valorQ;
    }

    public void setValorQ(float valorQ) {
        this.valorQ = valorQ;
    }

     public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }

    public float getProb() {
        return prob;
    }

    public void setProb(float prob) {
        this.prob = prob;
    }
}
