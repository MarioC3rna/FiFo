package models;

/**
 * Clase que contiene únicamente los campos de datos del proceso
 */
public class ProcessData {
    // Campos de entrada (proporcionados por el usuario)
    protected int pid;                // ID del proceso
    protected int arrivalTime;        // Tiempo de llegada
    protected int burstTime;          // Ráfaga de CPU
    protected int priority;           // Prioridad (opcional para FIFO)
    
    // Campos calculados por el planificador
    protected int startTime;          // Tiempo de inicio de ejecución
    protected int completionTime;     // Tiempo de finalización
    protected int waitingTime;        // Tiempo de espera
    protected int turnaroundTime;     // Tiempo de retorno
    
    // Constructor protegido para uso interno
    protected ProcessData(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = 0; // Por defecto para FIFO
        
        // Inicializar campos calculados
        this.startTime = 0;
        this.completionTime = 0;
        this.waitingTime = 0;
        this.turnaroundTime = 0;
    }
    
    protected ProcessData(int pid, int arrivalTime, int burstTime, int priority) {
        this(pid, arrivalTime, burstTime);
        this.priority = priority;
    }
}