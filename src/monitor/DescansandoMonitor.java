package monitor;

import core.AbstractState;
import core.Main;

public class DescansandoMonitor extends AbstractState<Monitor>  {
    private String mensagemSaida = "";
    
    public DescansandoMonitor(Monitor character) {
        super(character);
    }

    @Override
    public void enter() {
        mensagemSaida = "O monitor está descansando.";
    }   

    @Override
    public void execute() {
        character.setEnergia(character.getEnergia() + 2);

        if (Main.pedidoAjuda && character.getEnergia() >= 6) {
            mensagemSaida = "O monitor parou de descansar para explicar as regras do jogo.";
            character.setState(new ExplicandoRegras(character));
        } else if (character.getEnergia() >= 10) {
            mensagemSaida = "O monitor está descansado e vai organizar a prateleira.";
            character.setState(new OrganizandoPrateleira(character));
        }
    }

    @Override
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println(mensagemSaida);
        }
    }
}
