package core;
public interface Character {
    void update();
    void printState(String estadoAtual);
    void setState(State<?> state);
}
