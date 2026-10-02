package monitor;

import core.Character;
import core.State;

public class Monitor implements Character {
    private int energia = 10;
    private State<Monitor> estadoAtual;

    public Monitor() {
        this.energia = 10;
        this.estadoAtual = new OrganizandoPrateleira(this);
        this.estadoAtual.enter();
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, Math.min(10, energia));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setState(State<?> state) {
        if (this.estadoAtual != null) {
            this.estadoAtual.leave();
        }
        this.estadoAtual = (State<Monitor>) state;
        if (this.estadoAtual != null) {
            this.estadoAtual.enter();
        }
    }
    
    @Override
    public void update() {
        if (this.estadoAtual != null) {
            this.estadoAtual.execute();
        }
        printState("Monitor");
    }

    @Override
    public void printState(String nomeAgente) {
        String nomeEstado = estadoAtual != null ? estadoAtual.getClass().getSimpleName() : "Desconhecido";
        System.out.println(nomeAgente + " - Energia: " + energia + ", Estado: " + nomeEstado);
    }
}
