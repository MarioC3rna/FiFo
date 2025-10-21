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
            System.out.println("ERROR: No hay resultados validos");
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
        System.out.println("\n================================================");
        System.out.println("           TABLA DE PROCESOS                  ");
        System.out.println("================================================");
        System.out.println();
        System.out.println("+------------+--------------+----------------+");
        System.out.println("|  Proceso   |  Rafaga CPU  | Tiempo Llegada |");
        System.out.println("+------------+--------------+----------------+");
        
        for (Process p : processes) {
            System.out.printf("|     %2s     |      %2d      |       %2d       |\n",
                    "P" + p.getPid(), p.getBurstTime(), p.getArrivalTime());
        }
        
        System.out.println("+------------+--------------+----------------+");
    }
    
    private void displayTimeline(List<Process> processes) {
        System.out.println("\n================================================");
        System.out.println("           LINEA DE TIEMPO                    ");
        System.out.println("================================================");
        System.out.println();
        
        // Mostrar cada proceso con su tiempo de ejecución
        for (Process p : processes) {
            System.out.printf("P%d ejecuta de tiempo %d a tiempo %d\n", 
                p.getPid(), 
                p.getStartTime(), 
                p.getCompletionTime());
        }
        
        System.out.println();
    }
    
    private void displayWaitingTimes(List<Process> processes) {
        System.out.println("================================================");
        System.out.println("       TIEMPOS DE ESPERA (Waiting Time)       ");
        System.out.println("================================================");
        System.out.println();
        
        for (Process p : processes) {
            System.out.printf("P%d = (%d - %d) = %d ut\n",
                    p.getPid(), p.getStartTime(), p.getArrivalTime(), p.getWaitingTime());
        }
        System.out.println();
    }
    
    private void displayTurnaroundTimes(List<Process> processes) {
        System.out.println("================================================");
        System.out.println("      TIEMPOS DE RETORNO (Turnaround Time)    ");
        System.out.println("================================================");
        System.out.println();
        
        for (Process p : processes) {
            System.out.printf("P%d = %d ut\n",
                    p.getPid(), p.getTurnaroundTime());
        }
        System.out.println();
    }
    
    private void displayFinalMetrics(double avgWaiting, double avgTurnaround) {
        System.out.println("================================================");
        System.out.println("             METRICAS FINALES                 ");
        System.out.println("================================================");
        System.out.println();
        System.out.printf("TME (Tiempo Medio de Espera)   = %.2f ut\n", avgWaiting);
        System.out.printf("TMR (Tiempo Medio de Retorno)  = %.2f ut\n", avgTurnaround);
        System.out.println();
    }
    
    public void close() {
        // Método para compatibilidad
    }
}
