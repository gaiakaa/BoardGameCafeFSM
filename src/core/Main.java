package core;
import java.util.ArrayList;

import barista.Barista;
import cliente.Cliente;
import monitor.Monitor;

public class Main {
    public static boolean pedidoCafe = false;
    public static boolean cafePronto = false;
    
    public static boolean pedidoAjuda = false;
    public static boolean ensinandoRegras = false;
    public static boolean ajudaConcluida = false;

    public static void main(String[] args) {
        System.out.println("=== Iniciando Board Game Cafe ===");
        
        ArrayList<Character> agentes = new ArrayList<>();

        agentes.add(new Barista());
        agentes.add(new Monitor());
        agentes.add(new Cliente());

        while (true) {
            System.out.println("\n================= Nova Rodada =================");
            
            for (Character agente : agentes) {
                agente.update();
                System.out.println("-----------------------------------");
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}