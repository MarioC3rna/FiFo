package models;

/**
 * Clase que contiene los métodos de acceso (getters y setters)
 */
public class ProcessAccessors extends ProcessData {
    
    protected ProcessAccessors(int pid, int arrivalTime, int burstTime) {
        super(pid, arrivalTime, burstTime);
    }
    
    protected ProcessAccessors(int pid, int arrivalTime, int burstTime, int priority) {
        super(pid, arrivalTime, burstTime, priority);
    }
    
    // Getters
    public int getPid() { return pid; }
    public int getArrivalTime() { return arrivalTime; }
    public int getBurstTime() { return burstTime; }
    public int getPriority() { return priority; }
    public int getStartTime() { return startTime; }
    public int getCompletionTime() { return completionTime; }
    public int getWaitingTime() { return waitingTime; }
    public int getTurnaroundTime() { return turnaroundTime; }
    
    // Setters para campos calculados
    public void setStartTime(int startTime) { 
        this.startTime = startTime; 
    }
    
    public void setCompletionTime(int completionTime) { 
        this.completionTime = completionTime; 
    }
    
    public void setWaitingTime(int waitingTime) { 
        this.waitingTime = waitingTime; 
    }
    
    public void setTurnaroundTime(int turnaroundTime) { 
        this.turnaroundTime = turnaroundTime; 
    }
}