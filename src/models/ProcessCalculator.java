package models;

/**
 * Clase que contiene los métodos de cálculo de tiempos
 */
public class ProcessCalculator extends ProcessAccessors {
    
    protected ProcessCalculator(int pid, int arrivalTime, int burstTime) {
        super(pid, arrivalTime, burstTime);
    }
    
    protected ProcessCalculator(int pid, int arrivalTime, int burstTime, int priority) {
        super(pid, arrivalTime, burstTime, priority);
    }
    
    // Métodos de cálculo
    public void calculateWaitingTime() {
        // Tiempo de espera = Tiempo de inicio - Tiempo de llegada
        this.waitingTime = this.startTime - this.arrivalTime;
    }
    
    public void calculateTurnaroundTime() {
        // Tiempo de retorno = Tiempo de finalización - Tiempo de llegada
        this.turnaroundTime = this.completionTime - this.arrivalTime;
    }
    
    // Método para calcular automáticamente todos los tiempos
    public void calculateTimes() {
        calculateWaitingTime();
        calculateTurnaroundTime();
    }
    
    // Validaciones
    public boolean isValidProcess() {
        return pid > 0 && arrivalTime >= 0 && burstTime > 0;
    }
    
    public boolean hasCalculatedTimes() {
        return startTime >= 0 && completionTime > 0 && 
               waitingTime >= 0 && turnaroundTime > 0;
    }
}