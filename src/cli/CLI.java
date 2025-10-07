package cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import models.Process;

/**
 * Interfaz de línea de comandos para el simulador de planificación de procesos
 */
public class CLI {
    private Scanner scanner;
    
    public CLI() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Método principal que maneja toda la interfaz de usuario
     * @return Lista de procesos ingresados por el usuario
     */
    public List<Process> getProcessesFromUser() {
        System.out.println("=== SIMULADOR DE PLANIFICACIÓN DE PROCESOS FIFO ===");
        System.out.println();
        
        int numProcesses = getNumberOfProcesses();
        List<Process> processes = new ArrayList<>();
        
        System.out.println("\nIngrese los datos para cada proceso:");
        System.out.println("-----------------------------------");
        
        for (int i = 1; i <= numProcesses; i++) {
            System.out.printf("\n--- PROCESO %d ---\n", i);
            Process process = getProcessData(i);
            processes.add(process);
        }
        
        return processes;
    }
    
    /**
     * Solicita y valida el número de procesos
     * @return Número válido de procesos (1-20)
     */
    private int getNumberOfProcesses() {
        int numProcesses = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.print("Ingrese el número de procesos (1-20): ");
            try {
                numProcesses = Integer.parseInt(scanner.nextLine().trim());
                
                if (numProcesses < 1 || numProcesses > 20) {
                    System.out.println("❌ Error: El número debe estar entre 1 y 20");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido");
            }
        }
        
        return numProcesses;
    }
    
    /**
     * Solicita y valida los datos de un proceso específico
     * @param processId ID del proceso
     * @return Objeto Process con los datos ingresados
     */
    private Process getProcessData(int processId) {
        int arrivalTime = getArrivalTime(processId);
        int burstTime = getBurstTime(processId);
        
        return new Process(processId, arrivalTime, burstTime);
    }
    
    /**
     * Solicita y valida el tiempo de llegada
     * @param processId ID del proceso
     * @return Tiempo de llegada válido (≥ 0)
     */
    private int getArrivalTime(int processId) {
        int arrivalTime = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.printf("Tiempo de llegada para P%d (≥ 0): ", processId);
            try {
                arrivalTime = Integer.parseInt(scanner.nextLine().trim());
                
                if (arrivalTime < 0) {
                    System.out.println("❌ Error: El tiempo de llegada no puede ser negativo");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido");
            }
        }
        
        return arrivalTime;
    }
    
    /**
     * Solicita y valida la ráfaga de CPU
     * @param processId ID del proceso
     * @return Ráfaga de CPU válida (> 0)
     */
    private int getBurstTime(int processId) {
        int burstTime = 0;
        boolean validInput = false;
        
        while (!validInput) {
            System.out.printf("Ráfaga de CPU para P%d (> 0): ", processId);
            try {
                burstTime = Integer.parseInt(scanner.nextLine().trim());
                
                if (burstTime <= 0) {
                    System.out.println("❌ Error: La ráfaga de CPU debe ser mayor a 0");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Error: Ingrese un número válido");
            }
        }
        
        return burstTime;
    }
    
    /**
     * Muestra un resumen de los procesos ingresados
     * @param processes Lista de procesos
     */
    public void showProcessSummary(List<Process> processes) {
        System.out.println("\n=== RESUMEN DE PROCESOS INGRESADOS ===");
        System.out.println("--------------------------------------");
        System.out.printf("%-8s %-15s %-10s\n", "Proceso", "Tiempo Llegada", "Ráfaga CPU");
        System.out.println("--------------------------------------");
        
        for (Process process : processes) {
            System.out.printf("%-8s %-15d %-10d\n", 
                    "P" + process.getPid(), 
                    process.getArrivalTime(), 
                    process.getBurstTime());
        }
        System.out.println("--------------------------------------");
    }
    
    /**
     * Solicita confirmación del usuario
     * @param message Mensaje a mostrar
     * @return true si el usuario confirma, false en caso contrario
     */
    public boolean confirmAction(String message) {
        System.out.print(message + " (s/n): ");
        String response = scanner.nextLine().trim().toLowerCase();
        return response.equals("s") || response.equals("si") || response.equals("yes") || response.equals("y");
    }
    
    /**
     * Pausa la ejecución hasta que el usuario presione Enter
     */
    public void waitForEnter() {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
    /**
     * Cierra el scanner
     */
    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }
}
