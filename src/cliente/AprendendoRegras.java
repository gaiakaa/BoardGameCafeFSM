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
        character.setProgresso(character.getProgresso() - 4);

        if (character.getEnergia() <= 0) {
            mensagemSaida = "O cliente terminou de aprender as regras mas vai pedir um café.";
            character.setState(new EsperandoCafe(character));
        } else if (character.getProgresso() <= 0) {
            mensagemSaida = "O cliente terminou de aprender as regras e vai continuar jogando.";
            character.setState(new Jogando(character));
        }
    }

    @Override
    public void leave() {
        Main.ajudaConcluida = true;
        if (!mensagemSaida.isEmpty()) {
            System.out.println(mensagemSaida);
        }
    }
    
}
