package cliente;

import core.AbstractState;
import core.Main;

public class EscolhendoJogo extends AbstractState<Cliente> {
    private String mensagemSaida = "";

    public EscolhendoJogo(Cliente character) {
        super(character);
    }

    @Override
    public void enter() {
        mensagemSaida = "O cliente está escolhendo um jogo.";
        Main.pedidoAjuda =  true;
    }

    @Override
    public void execute() {
        if (Main.ensinandoRegras) {
            mensagemSaida = "O monitor chegoou para ensinar as regras do jogo.";
            character.getState(new AprendendoRegras(character));
        } 
    }

    @Override
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println(mensagemSaida);
        }
    }
    
}
