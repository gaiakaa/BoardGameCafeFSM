package core;
import java.util.ArrayList;

public class Main {
    public static boolean pedidoCafe = false;
    public static boolean cafePronto = false;
    
    public static boolean pedidoAjuda = false;
    public static boolean ensinandoRegras = false;
    public static boolean ajudaConcluida = false;

    public static void main(String[] args) {
        System.out.println("=== Iniciando Board Game Cafe ===");
        
        ArrayList<Character> agentes = new ArrayList<>();

        while (true) {
            System.out.println("\n--- Novo Ciclo ---");
            
            for (Character agente : agentes) {
                agente.update();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}