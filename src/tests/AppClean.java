package tests;

import java.util.List;
import cli.CLI;
import models.Process;
import scheduler.FIFO;

/**
 * Simulador de Planificación FIFO
 * Versión optimizada y simplificada
 */
public class AppClean {
    public static void main(String[] args) {
        CLI cli = new CLI();
        ResultFormatterNew formatter = new ResultFormatterNew();
        boolean continuar = true;
        
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║   SIMULADOR DE PLANIFICACIÓN FIFO            ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        try {
            while (continuar) {
                // 1. Obtener procesos del usuario
                List<Process> inputProcesses = cli.getProcessesFromUser();
                
                // 2. Confirmar simulación
                if (!cli.confirmAction("\n¿Ejecutar simulación?")) {
                    System.out.println("Simulación cancelada.");
                    break;
                }
                
                // 3. Ejecutar algoritmo FIFO
                System.out.println("\nProcesando...\n");
                FIFO scheduler = new FIFO();
                scheduler.schedule(inputProcesses);
                
                // 4. Mostrar resultados
                formatter.displayResults(scheduler);
                
                // 5. Preguntar si desea continuar
                System.out.println("=".repeat(50));
                continuar = cli.confirmAction("¿Realizar otra simulación?");
                
                if (continuar) {
                    System.out.println("\n" + "=".repeat(50));
                    System.out.println("NUEVA SIMULACIÓN");
                    System.out.println("=".repeat(50) + "\n");
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            cli.close();
            formatter.close();
            System.out.println("\n¡Gracias por usar el simulador!");
        }
    }
}
