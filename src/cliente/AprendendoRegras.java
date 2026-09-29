package cliente;

import core.AbstractState;
import core.Main;

public class AprendendoRegras extends AbstractState<Cliente> {
    private String mensagemSaida = "";

    public AprendendoRegras(Cliente character) {
        super(character);
    }

    @Override
    public void enter() {
        mensagemSaida = "O cliente está aprendendo as regras do jogo.";
    }

    @Override
    public void execute() {
        character.setEnergia(character.getEnergia() - 3);
        character.setProgresso(character.getProgresso() - 5);

        if (character.getProgresso() <= 0) {
            mensagemSaida = "O cliente terminou de aprender as regras mas vai pedir um café.";
            character.getState(new EsperandoCafe(character));
        } else {
            mensagemSaida = "O cliente terminou de aprender as regras e vai continuar jogando.";
            character.getState(new Jogando(character));
        }
    }

    @Override
    public void leave() {
        Main.ajudaConcluida = true;
        if (!mensagemSaida.isEmpty()) {
            System.out.println("CLIENTE: " + mensagemSaida);
        }
    }
    
}
