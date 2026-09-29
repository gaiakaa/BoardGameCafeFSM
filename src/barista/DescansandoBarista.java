package barista;

import core.AbstractState;
import core.Main;

public class DescansandoBarista extends AbstractState<Barista> {
    private String mensagemSaida = "";
    
    public DescansandoBarista(Barista character) {
        super(character);
    }

    @Override
    public void enter() {
        System.out.println("O Barista está descansando.");
    }

    @Override
    public void execute() {
        character.setEnergia(character.getEnergia() + 2);

        if (Main.pedidoCafe && character.getEnergia() >= 3) {
            mensagemSaida = "Barista parou de descansar para preparar o café.";
            character.getState(new PreparandoCafe(character));
        } else if (character.getEnergia() >= 10) {
            mensagemSaida = "Barista está descansado e vai limpar o balcão.";
            character.getState(new LimpandoBalcao(character));
        }
    }

    @Override
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println("BARISTA: " + mensagemSaida);
        }
    }
}