package cliente;

import core.AbstractState;
import core.Main;

public class BebendoCafe extends AbstractState<Cliente> {
    private String mensagemSaida = "";

    public BebendoCafe(Cliente character) {
        super(character);
    }

    @Override
    public void enter() {
        mensagemSaida = "O cliente está bebendo o café.";
        Main.pedidoCafe = false; 
    }

    @Override
    public void execute() {
        character.setEnergia(10);
        Main.cafePronto = false;

        if (character.getProgresso() < 10) {
            mensagemSaida = "O cliente terminou de beber o café e vai continuar jogando.";
            character.getState(new Jogando(character));
        } else {
            mensagemSaida = "O cliente terminou de beber o café e vai escolher outro jogo.";
            character.getState(new EscolhendoJogo(character));
        }
    }

    @Override
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println(mensagemSaida);
        }
    }
    
}
