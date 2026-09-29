package cliente;

import core.Character;
import core.State;

public class Cliente implements Character {
    private int energia;
    private int progresso;
    private State<Cliente> estadoAtual;
    
    public Cliente() {
        this.energia = 10;
        this.progresso = 0;
        this.estadoAtual = new EscolhendoJogo(this);
        this.estadoAtual.enter();
    }
    
    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = Math.max(0, Math.min(10, energia));
    }

    public int getProgresso() {
        return progresso;
    }

    public void setProgresso(int progresso) {
        this.progresso = Math.max(0, Math.min(10, progresso));
    }

    @Override
    public void getState(State<?> state) {
        if (this.estadoAtual != null) {
            this.estadoAtual.leave();
        }
        this.estadoAtual = (State<Cliente>) state;
        if (this.estadoAtual != null) {
            this.estadoAtual.enter();
        }
    }

    @Override 
    public void update() {
        if (this.estadoAtual != null) {
            this.estadoAtual.execute();
        }
        printState("Cliente");
    }
    
    @Override
    public void printState(String nomeAgente) {
        String nomeEstado = estadoAtual != null ? estadoAtual.getClass().getSimpleName() : "Desconhecido";
        System.out.println(nomeAgente + " - Energia: " + energia + ", Progresso: " + progresso + ", Estado: " + nomeEstado);
    }
}
