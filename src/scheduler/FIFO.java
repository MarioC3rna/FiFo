package scheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import models.Process;

/**
 * Implementación del algoritmo de planificación FIFO (First In, First Out)
 * También conocido como FCFS (First Come, First Served)
 */
public class FIFO {
    private List<Process> processes;
    private List<Process> executionOrder;
    private double averageWaitingTime;
    private double averageTurnaroundTime;
    
    public FIFO() {
        this.processes = new ArrayList<>();
        this.executionOrder = new ArrayList<>();
        this.averageWaitingTime = 0.0;
        this.averageTurnaroundTime = 0.0;
    }
    
    /**
     * Ejecuta el algoritmo FIFO completo
     * @param inputProcesses Lista de procesos de entrada
     * @return Lista de procesos ordenados por ejecución con tiempos calculados
     */
    public List<Process> schedule(List<Process> inputProcesses) {
        // Validar entrada
        if (inputProcesses == null || inputProcesses.isEmpty()) {
            throw new IllegalArgumentException("La lista de procesos no puede estar vacía");
        }
        
        // Copiar procesos para no modificar la lista original
        this.processes = new ArrayList<>();
        for (Process p : inputProcesses) {
            this.processes.add(new Process(p.getPid(), p.getArrivalTime(), p.getBurstTime()));
        }
        
        // Paso 1: Ordenar procesos por tiempo de llegada (FIFO)
        sortProcessesByArrivalTime();
        
        // Paso 2: Calcular tiempos de ejecución
        calculateExecutionTimes();
        
        // Paso 3: Calcular métricas individuales
        calculateIndividualMetrics();
        
        // Paso 4: Calcular métricas promedio
        calculateAverageMetrics();
        
        // Crear orden de ejecución
        this.executionOrder = new ArrayList<>(this.processes);
        
        return new ArrayList<>(this.processes);
    }
    
    /**
     * Ordena los procesos por tiempo de llegada (base del algoritmo FIFO)
     */
    private void sortProcessesByArrivalTime() {
        Collections.sort(this.processes, new Comparator<Process>() {
            @Override
            public int compare(Process p1, Process p2) {
                // Primero por tiempo de llegada
                int arrivalComparison = Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
                if (arrivalComparison != 0) {
                    return arrivalComparison;
                }
                // Si llegan al mismo tiempo, ordenar por PID
                return Integer.compare(p1.getPid(), p2.getPid());
            }
        });
    }
    
    /**
     * Calcula los tiempos de inicio y finalización para cada proceso
     */
    private void calculateExecutionTimes() {
        int currentTime = 0;
        
        for (Process process : this.processes) {
            // El tiempo de inicio es máximo entre el tiempo actual y el tiempo de llegada
            int startTime = Math.max(currentTime, process.getArrivalTime());
            process.setStartTime(startTime);
            
            // El tiempo de finalización es el tiempo de inicio + ráfaga de CPU
            int completionTime = startTime + process.getBurstTime();
            process.setCompletionTime(completionTime);
            
            // Actualizar el tiempo actual
            currentTime = completionTime;
        }
    }
    
    /**
     * Calcula los tiempos de espera y retorno para cada proceso
     */
    private void calculateIndividualMetrics() {
        for (Process process : this.processes) {
            process.calculateTimes();
        }
    }
    
    /**
     * Calcula las métricas promedio (tiempo medio de espera y retorno)
     */
    private void calculateAverageMetrics() {
        if (this.processes.isEmpty()) {
            return;
        }
        
        double totalWaitingTime = 0;
        double totalTurnaroundTime = 0;
        
        for (Process process : this.processes) {
            totalWaitingTime += process.getWaitingTime();
            totalTurnaroundTime += process.getTurnaroundTime();
        }
        
        this.averageWaitingTime = totalWaitingTime / this.processes.size();
        this.averageTurnaroundTime = totalTurnaroundTime / this.processes.size();
    }
    
    /**
     * Obtiene el orden de ejecución de los procesos
     * @return Lista de procesos en orden de ejecución
     */
    public List<Process> getExecutionOrder() {
        return new ArrayList<>(this.executionOrder);
    }
    
    /**
     * Obtiene el tiempo medio de espera
     * @return Tiempo medio de espera
     */
    public double getAverageWaitingTime() {
        return this.averageWaitingTime;
    }
    
    /**
     * Obtiene el tiempo medio de retorno
     * @return Tiempo medio de retorno
     */
    public double getAverageTurnaroundTime() {
        return this.averageTurnaroundTime;
    }
    
    /**
     * Obtiene los procesos procesados con todos los tiempos calculados
     * @return Lista de procesos con métricas calculadas
     */
    public List<Process> getProcessedProcesses() {
        return new ArrayList<>(this.processes);
    }
    
    /**
     * Muestra información detallada del algoritmo para debugging
     */
    public void printDebugInfo() {
        System.out.println("\n=== DEBUG: INFORMACIÓN DEL ALGORITMO FIFO ===");
        System.out.println("Número de procesos: " + this.processes.size());
        System.out.println("Orden de ejecución:");
        
        for (int i = 0; i < this.processes.size(); i++) {
            Process p = this.processes.get(i);
            System.out.printf("  %d. P%d (Llegada: %d, Inicio: %d, Fin: %d)\n", 
                    i + 1, p.getPid(), p.getArrivalTime(), p.getStartTime(), p.getCompletionTime());
        }
        
        System.out.printf("Tiempo medio de espera: %.2f\n", this.averageWaitingTime);
        System.out.printf("Tiempo medio de retorno: %.2f\n", this.averageTurnaroundTime);
        System.out.println("============================================");
    }
    
    /**
     * Verifica si el planificador tiene resultados válidos
     * @return true si los resultados son válidos
     */
    public boolean hasValidResults() {
        return !this.processes.isEmpty() && 
               this.averageWaitingTime >= 0 && 
               this.averageTurnaroundTime >= 0;
    }
}
