# Prueba de Corrección del Algoritmo FIFO

## Problema Original
Cuando dos o más procesos tenían el mismo tiempo de llegada, el algoritmo NO estaba priorizando correctamente por ráfaga de CPU.

## Solución Implementada
Se modificó el método `sortProcessesByArrivalTime()` en `FIFO.java` (líneas 66-79) para implementar el siguiente criterio de ordenamiento:

```java
1. Ordenar por tiempo de llegada (menor primero)
2. SI dos procesos tienen el mismo tiempo de llegada:
   → Ordenar por ráfaga de CPU (menor primero)
3. SI también tienen la misma ráfaga:
   → Ordenar por PID (menor primero)
```

## Caso de Prueba 1: Todos llegan al mismo tiempo

**Entrada:**
```
Número de procesos: 4

Proceso 1: Llegada=3, Ráfaga=5
Proceso 2: Llegada=3, Ráfaga=2
Proceso 3: Llegada=3, Ráfaga=1
Proceso 4: Llegada=3, Ráfaga=10
```

**Resultado Esperado:**
Orden de ejecución: **P3 → P2 → P1 → P4**

**Explicación:**
- Todos llegan en t=3
- Se ordenan por ráfaga: 1 < 2 < 5 < 10
- Por lo tanto: P3(1) → P2(2) → P1(5) → P4(10)

## Caso de Prueba 2: Mezcla de tiempos

**Entrada:**
```
Número de procesos: 5

Proceso 1: Llegada=0, Ráfaga=4
Proceso 2: Llegada=2, Ráfaga=3
Proceso 3: Llegada=2, Ráfaga=1
Proceso 4: Llegada=5, Ráfaga=2
Proceso 5: Llegada=2, Ráfaga=5
```

**Resultado Esperado:**
Orden de ejecución: **P1 → P3 → P2 → P5 → P4**

**Explicación:**
1. P1 llega primero (t=0)
2. En t=2 llegan P2, P3, P5 → se ordenan por ráfaga:
   - P3 (ráfaga=1)
   - P2 (ráfaga=3)
   - P5 (ráfaga=5)
3. P4 llega al final (t=5)

## Caso de Prueba 3: Según tu imagen

**Entrada (20 procesos):**
```
P1:  Llegada=3,  Ráfaga=2
P2:  Llegada=3,  Ráfaga=1  ← debe ir ANTES que P1
P3:  Llegada=10, Ráfaga=9
P4:  Llegada=9,  Ráfaga=9
P5:  Llegada=23, Ráfaga=1
P6:  Llegada=3,  Ráfaga=5
P7:  Llegada=10, Ráfaga=10 ← debe ir DESPUÉS que P3
P8:  Llegada=11, Ráfaga=10
P9:  Llegada=10, Ráfaga=3  ← debe ir ANTES que P3 y P7
P10: Llegada=5,  Ráfaga=2
P11: Llegada=5,  Ráfaga=7
P12: Llegada=3,  Ráfaga=5
P13: Llegada=4,  Ráfaga=2
P14: Llegada=5,  Ráfaga=3
P15: Llegada=4,  Ráfaga=6
P16: Llegada=1,  Ráfaga=5
P17: Llegada=3,  Ráfaga=2
P18: Llegada=9,  Ráfaga=3
P19: Llegada=2,  Ráfaga=4
P20: Llegada=2,  Ráfaga=1
```

**Orden Esperado:**
1. **t=1**: P16
2. **t=2**: P20 (ráfaga=1), P19 (ráfaga=4)
3. **t=3**: P2 (ráfaga=1), P1 (ráfaga=2), P17 (ráfaga=2), P6 (ráfaga=5), P12 (ráfaga=5)
4. **t=4**: P13 (ráfaga=2), P15 (ráfaga=6)
5. **t=5**: P10 (ráfaga=2), P14 (ráfaga=3), P11 (ráfaga=7)
6. **t=9**: P18 (ráfaga=3), P4 (ráfaga=9)
7. **t=10**: P9 (ráfaga=3), P3 (ráfaga=9), P7 (ráfaga=10)
8. **t=11**: P8
9. **t=23**: P5

## Cómo Verificar

1. Ejecuta el simulador: `.\ejecutar.bat`
2. Ingresa los procesos de cualquier caso de prueba
3. Observa el orden de ejecución en la sección "🔄 ORDEN DE EJECUCIÓN DEL CPU"
4. Verifica que cuando dos procesos tienen el mismo tiempo de llegada, el de menor ráfaga va primero

## Código Relevante

Ver archivo: `src/scheduler/FIFO.java` líneas 66-79

```java
private void sortProcessesByArrivalTime() {
    Collections.sort(this.processes, new Comparator<Process>() {
        @Override
        public int compare(Process p1, Process p2) {
            // Primero por tiempo de llegada
            int arrivalComparison = Integer.compare(p1.getArrivalTime(), p2.getArrivalTime());
            if (arrivalComparison != 0) {
                return arrivalComparison;
            }
            // Si llegan al mismo tiempo, ordenar por ráfaga (menor ráfaga primero)
            int burstComparison = Integer.compare(p1.getBurstTime(), p2.getBurstTime());
            if (burstComparison != 0) {
                return burstComparison;
            }
            // Si tanto tiempo de llegada como ráfaga son iguales, ordenar por PID
            return Integer.compare(p1.getPid(), p2.getPid());
        }
    });
}
```