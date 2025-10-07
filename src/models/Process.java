package models;

/**
 * Clase principal Process que combina datos, accesores y calculadora
 * Esta es la clase que se usará en el resto del proyecto
 */
public class Process extends ProcessCalculator {
    
    // Constructor principal
    public Process(int pid, int arrivalTime, int burstTime) {
        super(pid, arrivalTime, burstTime);
    }
    
    // Constructor con prioridad (para futuros algoritmos)
    public Process(int pid, int arrivalTime, int burstTime, int priority) {
        super(pid, arrivalTime, burstTime, priority);
    }
    
    // Métodos de representación (toString)
    @Override
    public String toString() {
        return String.format("P%d [Llegada: %d, Ráfaga: %d, Inicio: %d, Fin: %d, Espera: %d, Retorno: %d]",
                pid, arrivalTime, burstTime, startTime, completionTime, waitingTime, turnaroundTime);
    }
    
    // Método para mostrar solo información básica
    public String toBasicString() {
        return String.format("P%d (Llegada: %d, Ráfaga: %d)", pid, arrivalTime, burstTime);
    }
    
    // Método para mostrar resultados formateados
    public String toResultString() {
        return String.format("Proceso P%d: Espera=%d, Retorno=%d", 
                pid, waitingTime, turnaroundTime);
    }
    
    // Método para comparar procesos por tiempo de llegada (útil para FIFO)
    public int compareByArrivalTime(Process other) {
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }
}
