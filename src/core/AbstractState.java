package core;
public abstract class AbstractState<C> implements State<C> {
    protected C character;

    public AbstractState(C character) {
        this.character = character;
    }

    @Override
    public C getCharacter() {
        return this.character;
    }
}