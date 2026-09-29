package barista;

import core.Character;
import core.State;


public class Barista implements Character{
    private int energia;
    private State<Barista> estadoAtual;

    public Barista() {
        this.energia = 10;
        this.estadoAtual = new LimpandoBalcao(this);
        this.estadoAtual.enter();
    }
    
    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, Math.min(10, energia));
    }

    @Override 
    public void getState(State<?> state) {
        if (this.estadoAtual != null) {
            this.estadoAtual.leave();
        }
        this.estadoAtual = (State<Barista>) state;
        if (this.estadoAtual != null) {
            this.estadoAtual.enter();
        }
    }

    @Override 
    public void update() {
        if (this.estadoAtual != null) {
            this.estadoAtual.execute();
        }
        printState("Barista");
    }

    @Override 
    public void printState(String nomeAgente) {
        String nomeEstado = estadoAtual != null ? estadoAtual.getClass().getSimpleName() : "Desconhecido";
        System.out.println(nomeAgente + " - Energia: " + energia + ", Estado: " + nomeEstado);
    }
}
