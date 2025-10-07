
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
        FIFO scheduler = new FIFO();
        
        try {
            // Paso 1: Obtener procesos del usuario
            List<Process> inputProcesses = cli.getProcessesFromUser();
            
            // Mostrar resumen de entrada
            cli.showProcessSummary(inputProcesses);
            
            // Confirmar antes de procesar
            if (!cli.confirmAction("\n¿Desea proceder con la simulación FIFO?")) {
                System.out.println("❌ Simulación cancelada por el usuario.");
                return;
            }
            
            // Paso 2: Ejecutar algoritmo FIFO
            System.out.println("\n⚙️  Ejecutando algoritmo FIFO...");
            scheduler.schedule(inputProcesses);
            
            // Paso 3: Mostrar resultados completos
            formatter.displayCompleteResults(scheduler);
            
            // Paso 4: Mostrar resumen ejecutivo
            formatter.displaySummary(scheduler);
            
            // Opción de mostrar información de debug
            System.out.println();
            if (cli.confirmAction("¿Desea ver información de debug detallada?")) {
                scheduler.printDebugInfo();
            }
            
            System.out.println("\n✅ Simulación completada exitosamente.");
            
        } catch (IllegalArgumentException e) {
            System.err.println("❌ Error en los datos de entrada: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Limpiar recursos
            cli.close();
            System.out.println("\n👋 ¡Gracias por usar el simulador FIFO!");
        }
    }
}
