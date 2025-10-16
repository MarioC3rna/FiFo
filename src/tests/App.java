package tests;

import java.util.List;

import cli.CLI;
import models.Process;
import scheduler.FIFO;

/**
 * Aplicación principal del Simulador de Planificación de Procesos FIFO
 */
public class App {
    public static void main(String[] args) {
        System.out.println("🚀 Iniciando Simulador de Planificación FIFO...\n");
        
        CLI cli = new CLI();
        ResultFormatter formatter = new ResultFormatter();
        boolean continueSimulation = true;
        
        try {
            while (continueSimulation) {
                FIFO scheduler = new FIFO();
                
                // Paso 1: Obtener procesos del usuario
                List<Process> inputProcesses = cli.getProcessesFromUser();
                
                // Mostrar resumen de entrada
                cli.showProcessSummary(inputProcesses);
                
                // Confirmar antes de procesar
                if (!cli.confirmAction("\n¿Desea proceder con la simulación FIFO?")) {
                    System.out.println("❌ Simulación cancelada por el usuario.");
                    break;
                }
                
                // Paso 2: Ejecutar algoritmo FIFO
                System.out.println("\n⚙️  Procesando...\n");
                scheduler.schedule(inputProcesses);
                
                // Paso 3: Mostrar resultados
                formatter.displayResults(scheduler);
                
                System.out.println("✅ Simulación completada exitosamente.");
                
                // Preguntar si desea realizar otra simulación
                System.out.println();
                continueSimulation = cli.confirmAction("¿Desea realizar otra simulación?");
                
                if (!continueSimulation) {
                    // Confirmar salida
                    if (!cli.confirmAction("¿Está seguro que desea salir del simulador?")) {
                        continueSimulation = true; // Continúa si no confirma la salida
                        System.out.println("\n🔄 Continuando con el simulador...\n");
                    }
                }
                
                if (continueSimulation) {
                    System.out.println("\n" + "=".repeat(60));
                    System.out.println("           NUEVA SIMULACIÓN");
                    System.out.println("=".repeat(60) + "\n");
                }
            }
            
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error en los datos de entrada: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Limpiar recursos
            cli.close();
            formatter.close();
            System.out.println("\n👋 ¡Gracias por usar el simulador FIFO!");
        }
    }
}
