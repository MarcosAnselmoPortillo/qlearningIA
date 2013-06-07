package qlearning;

/**
 *
 * @author Grupo 6
 */
public class ConfTab {
    
    public int size; //Tamaño del tablero
    
    public float epsilon; //Valor de epsilon
    
    public float tau; //Valor de temperatura
    
    public int episodios; //Cantidad de episodios
        
    public float rPozo; //Valor de la recompensa asociada a pozo
    
    public float rNeutro; //Valor de la recompensa asociada a un casillero neutro
    
    public float rMalo; //Valor de la recompensa asociada a malo
    
    public float rBueno; //Valor de la recompensa asociada a bueno
    
    public float rExc; //Valor de la recompensa asociada a excelente
    
    public float rFin; //Valor de la recompensa asociada al estado Final
    
    public static ConfTab instance = null;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public float getEpsilon() {
        return epsilon;
    }

    public void setEpsilon(float epsilon) {
        this.epsilon = epsilon;
    }

    public float getTau() {
        return tau;
    }

    public void setTau(float tau) {
        this.tau = tau;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public float getrPozo() {
        return rPozo;
    }

    public void setrPozo(float rPozo) {
        this.rPozo = rPozo;
    }

    public float getrNeutro() {
        return rNeutro;
    }

    public void setrNeutro(float rNeutro) {
        this.rNeutro = rNeutro;
    }
    
    public float getrMalo() {
        return rMalo;
    }

    public void setrMalo(float rMalo) {
        this.rMalo = rMalo;
    }

    public float getrBueno() {
        return rBueno;
    }

    public void setrBueno(float rBueno) {
        this.rBueno = rBueno;
    }

    public float getrExc() {
        return rExc;
    }

    public void setrExc(float rExc) {
        this.rExc = rExc;
    }

    public float getrFin() {
        return rFin;
    }

    public void setrFin(float rFin) {
        this.rFin = rFin;
    }
    
    public static ConfTab getInstance(int size, float epsilon, float tau, int episodios)
	{
		if(instance == null)
			instance = new ConfTab(size, epsilon, tau, episodios);
		
		return instance;
	}

    public ConfTab(int size, float epsilon, float tau, int episodios) {
        this.size = size;
        this.epsilon = epsilon;
        this.tau = tau;
        this.episodios = episodios;
    }
    
}
