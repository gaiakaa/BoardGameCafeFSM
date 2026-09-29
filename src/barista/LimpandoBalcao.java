package barista;

import core.AbstractState;
import core.Main;

public class LimpandoBalcao extends AbstractState<Barista> {
    private String mensagemSaida = "";

    public LimpandoBalcao(Barista character) {
        super(character);
    }

    @Override 
    public void enter() {
       mensagemSaida = "Barista entrou no estado LimpandoBalcao.";
    }
    
    @Override
    public void execute() {
        character.setEnergia(character.getEnergia() - 1);

        if(Main.pedidoCafe) {
            mensagemSaida = "Barista está preparando o café.";
            character.getState(new PreparandoCafe(character));
        } else if (character.getEnergia() <= 0) {
            mensagemSaida = "Barista está cansado e vai descansar.";
            character.getState(new DescansandoBarista(character));
        }
    }

    @Override 
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println(mensagemSaida);
        }
    }

}
