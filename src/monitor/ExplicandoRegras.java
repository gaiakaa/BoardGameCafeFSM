package monitor;

import core.AbstractState;
import core.Main;

public class ExplicandoRegras extends AbstractState<Monitor>  {
    private String mensagemSaida = "";

    public ExplicandoRegras(Monitor character) {
        super(character);
    }

    @Override 
    public void enter() {
        mensagemSaida = "O monitor está explicando as regras do jogo.";
        Main.pedidoAjuda = false;
        Main.ensinandoRegras = true;
    }

    @Override 
    public void execute() {
        character.setEnergia(character.getEnergia() - 3);

        if (Main.ajudaConcluida) {
            Main.ensinandoRegras = false;
            Main.ajudaConcluida = false;

            if (character.getEnergia() > 3) {
                mensagemSaida = "O monitor terminou de explicar as regras e vai organizar a prateleira.";
                character.setState(new OrganizandoPrateleira(character));
            } else {
                mensagemSaida = "O monitor está cansado e precisa descansar.";
                character.setState(new DescansandoMonitor(character));
            }
           
        }
    }

    @Override 
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
             System.out.println(mensagemSaida);
        }
    }
    
}
