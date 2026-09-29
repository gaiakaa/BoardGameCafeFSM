package monitor;

import core.AbstractState;
import core.Main;

public class OrganizandoPrateleira extends AbstractState<Monitor> {
    private String mensagemSaida = "";

    public OrganizandoPrateleira(Monitor character) {
        super(character);
    }
    
    @Override 
    public void enter() {
        mensagemSaida = "O monitor está organizando a prateleira.";
    }

    @Override 
    public void execute() {
        character.setEnergia(character.getEnergia() - 1);
        if (Main.pedidoAjuda) {
            mensagemSaida = "O monitor está sendo chamado por um cliente.";
            character.getState(new ExplicandoRegras(character));
        } else if (character.getEnergia() <= 0) {
            mensagemSaida = "O monitor está cansado e precisa descansar.";
            character.getState(new DescansandoMonitor(character));
        }
    }

    @Override 
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
             System.out.println(mensagemSaida);
        }
    }
}
