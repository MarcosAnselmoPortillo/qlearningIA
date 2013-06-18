package qlearning;

/**
 *
 * @author Grupo 6
 */
public class ConfTab {
    
    public static int size; //Tamaño del tablero
    
    public static double epsilon = -1; //Valor de epsilon
    
    public static double tau = -1; //Valor de temperatura
    
    private static int episodios = 1000; //Cantidad de episodios
        
    private static float rPozo = -1000; //Valor de la recompensa asociada a pozo
    
    private static float rNeutro = 1; //Valor de la recompensa asociada a un casillero neutro
    
    private static float rMalo = 0; //Valor de la recompensa asociada a malo
    
    private static float rBueno = 5; //Valor de la recompensa asociada a bueno
    
    private static float rExc = 10; //Valor de la recompensa asociada a excelente
    
    private static float rFin = 1000; //Valor de la recompensa asociada al estado Final
    
    public static float gamma = (float) 0.8; // Valor de gamma 
    
    public static float tolerancia; // Valor de la tolerancia entre las variaciones de la matriz Q

    public static float valorQ = 100; // Valor por defecto de Q

    public static float getValorQ() {
        return valorQ;
    }

    public static void setValorQ(float valorQ) {
        ConfTab.valorQ = valorQ;
    }
    
    public static float getTolerancia() {
        return tolerancia;
    }

    public static void setTolerancia(float tolerancia) {
        ConfTab.tolerancia = tolerancia;
    }
    public static int getSize() {
        return size;
    }

    public static void setSize(int size) {
        ConfTab.size = size;
    }

    public static double getEpsilon() {
        return epsilon;
    }

    public static void setEpsilon(double epsilon) {
        ConfTab.epsilon = epsilon;
    }

    public static double getTau() {
        return tau;
    }

    public static void setTau(double tau) {
        ConfTab.tau = tau;
    }

    public static int getEpisodios() {
        return episodios;
    }

    public static void setEpisodios(int episodios) {
        ConfTab.episodios = episodios;
    }

    public static float getrPozo() {
        return rPozo;
    }

    public static void setrPozo(float rPozo) {
        ConfTab.rPozo = rPozo;
    }

    public static float getrNeutro() {
        return rNeutro;
    }

    public static void setrNeutro(float rNeutro) {
        ConfTab.rNeutro = rNeutro;
    }

    public static float getrMalo() {
        return rMalo;
    }

    public static void setrMalo(float rMalo) {
        ConfTab.rMalo = rMalo;
    }

    public static float getrBueno() {
        return rBueno;
    }

    public static void setrBueno(float rBueno) {
        ConfTab.rBueno = rBueno;
    }

    public static float getrExc() {
        return rExc;
    }

    public static void setrExc(float rExc) {
        ConfTab.rExc = rExc;
    }

    public static float getrFin() {
        return rFin;
    }

    public static void setrFin(float rFin) {
        ConfTab.rFin = rFin;
    }

    public static float getGamma() {
        return gamma;
    }

    public static void setGamma(float gamma) {
        ConfTab.gamma = gamma;
    }
    
}
