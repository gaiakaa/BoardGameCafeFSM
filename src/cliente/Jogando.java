package cliente;

import core.AbstractState;

public class Jogando extends AbstractState<Cliente> {
    private String mensagemSaida = "";

    public Jogando(Cliente character) {
        super(character);
    }

    @Override 
    public void enter() {
        mensagemSaida = "O cliente está jogando.";
    }

    @Override
    public void execute() {
        character.setEnergia(character.getEnergia() - 2);
        character.setProgresso(character.getProgresso() + 3);

        if (character.getEnergia() <= 0) {
            mensagemSaida = "O cliente está exausto e precisa de um café.";
            character.setState(new EsperandoCafe(character));
        } else if (character.getProgresso() >= 10) {
            mensagemSaida = "O cliente terminou de jogar pegar outro jogo.";
            character.setState(new EscolhendoJogo(character));
        }
    }

    @Override
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println(mensagemSaida);
        }
    }
}
