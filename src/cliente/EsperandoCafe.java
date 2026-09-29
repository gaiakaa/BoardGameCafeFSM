package cliente;

import core.AbstractState;
import core.Main;

public class EsperandoCafe extends AbstractState<Cliente> {
    private String mensagemSaida = "";

    public EsperandoCafe(Cliente character) {
        super(character);
    }

    @Override
    public void enter() {
        mensagemSaida = "O cliente está esperando o café.";
        Main.pedidoCafe = true; 
    }

    @Override
    public void execute() {
        
        if (Main.cafePronto) {
            mensagemSaida = "O cafe do cliente está pronto.";
            character.getState(new BebendoCafe(character));
        }
    }

    @Override
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println(mensagemSaida);
        }
    }
    
}
