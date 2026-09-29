package barista;
import core.AbstractState;
import core.Main;

public class PreparandoCafe extends AbstractState<Barista> {
    private String mensagemSaida = "";

    public PreparandoCafe(Barista character) {
        super(character);
    }

    @Override 
    public void enter() {
       System.out.println("Barista entrou no estado PreparandoCafe.");
    }
    
    @Override
    public void execute() {
        character.setEnergia(character.getEnergia() - 3);

        Main.pedidoCafe = false;
        Main.cafePronto = true;

        if(character.getEnergia() > 3) {
            mensagemSaida = "Barista terminou de preparar o café.";
            character.getState(new LimpandoBalcao(character));
        } else {
            mensagemSaida = "Barista está cansado e vai descansar.";
            character.getState(new DescansandoBarista(character));
        }
    }

    @Override 
    public void leave() {
        if (!mensagemSaida.isEmpty()) {
            System.out.println("BARISTA: " + mensagemSaida);
        }
    }
}