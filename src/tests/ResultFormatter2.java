package tests;
import java.util.List;
import models.Process;
import scheduler.FIFO;

/**
 * Formateador de resultados optimizado para el algoritmo FIFO
 */
public class ResultFormatter {
    
    /**
     * Muestra todos los resultados en formato limpio
     */
    public void displayResults(FIFO fifo) {
        if (!fifo.hasValidResults()) {
            System.out.println("❌ Error: No hay resultados válidos");
            return;
        }
        
        List<Process> processes = fifo.getProcessedProcesses();
        
        // 1. Tabla de procesos
        displayProcessTable(processes);
        
        // 2. Línea de tiempo
        displayTimeline(processes);
        
        // 3. Tiempos de Espera
        displayWaitingTimes(processes);
        
        // 4. Tiempos de Retorno
        displayTurnaroundTimes(processes);
        
        // 5. Métricas finales
        displayFinalMetrics(fifo.getAverageWaitingTime(), fifo.getAverageTurnaroundTime());
    }
    
    private void displayProcessTable(List<Process> processes) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           TABLA DE PROCESOS                  ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("┌────────────┬──────────────┬────────────────┐");
        System.out.println("│  Proceso   │  Ráfaga CPU  │ Tiempo Llegada │");
        System.out.println("├────────────┼──────────────┼────────────────┤");
        
        for (Process p : processes) {
            System.out.printf("│     %2s     │      %2d      │       %2d       │\n",
                    "P" + p.getPid(), p.getBurstTime(), p.getArrivalTime());
        }
        
        System.out.println("└────────────┴──────────────┴────────────────┘");
    }
    
    private void displayTimeline(List<Process> processes) {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║           LÍNEA DE TIEMPO                    ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
        
        // Línea con nombres de procesos
        System.out.print("     ");
        for (Process p : processes) {
            int duration = p.getCompletionTime() - p.getStartTime();
            String label = "P" + p.getPid();
            int spaces = duration * 4;
            int leftPad = (spaces - label.length()) / 2;
            int rightPad = spaces - label.length() - leftPad;
            System.out.print(" ".repeat(leftPad) + label + " ".repeat(rightPad) + " ");
        }
        System.out.println();
        
        // Línea con tiempos
        System.out.print("  ");
        System.out.printf("%2d  ", 0);
        
        for (Process p : processes) {
            int duration = p.getCompletionTime() - p.getStartTime();
            for (int i = 1; i < duration; i++) {
                System.out.print("    ");
            }
            System.out.printf("%2d  ", p.getCompletionTime());
        }
        System.out.println("\n");
    }
    
    private void displayWaitingTimes(List<Process> processes) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║       TIEMPOS DE ESPERA (Waiting Time)       ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
        
        for (Process p : processes) {
            System.out.printf("P%d = (%d - %d) = %d ut\n",
                    p.getPid(), p.getStartTime(), p.getArrivalTime(), p.getWaitingTime());
        }
        System.out.println();
    }
    
    private void displayTurnaroundTimes(List<Process> processes) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║      TIEMPOS DE RETORNO (Turnaround Time)    ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
        
        for (Process p : processes) {
            System.out.printf("P%d = (%d - %d) = %d ut\n",
                    p.getPid(), p.getCompletionTime(), p.getArrivalTime(), p.getTurnaroundTime());
        }
        System.out.println();
    }
    
    private void displayFinalMetrics(double avgWaiting, double avgTurnaround) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║             MÉTRICAS FINALES                 ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println();
        System.out.printf("TME (Tiempo Medio de Espera)   = %.2f ut\n", avgWaiting);
        System.out.printf("TMR (Tiempo Medio de Retorno)  = %.2f ut\n", avgTurnaround);
        System.out.println();
    }
    
    public void close() {
        // Método para compatibilidad
    }
}
