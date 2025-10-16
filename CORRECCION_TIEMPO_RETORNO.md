# Corrección del Tiempo de Retorno

## ✅ PROBLEMA IDENTIFICADO Y SOLUCIONADO

### Problema Original
El simulador calculaba el **Tiempo de Retorno** usando la fórmula estándar de sistemas operativos:
```
Tiempo de Retorno = Tiempo de Finalización - Tiempo de Llegada
```

### Nueva Definición (Según tu ejercicio)
El **Tiempo de Retorno** simplemente es el **Tiempo de Finalización** del proceso:
```
Tiempo de Retorno = Tiempo de Finalización
```

## 📝 CAMBIOS REALIZADOS

### 1. Archivo: `models/ProcessCalculator.java`

**ANTES:**
```java
public void calculateTurnaroundTime() {
    // Tiempo de retorno = Tiempo de finalización - Tiempo de llegada
    this.turnaroundTime = this.completionTime - this.arrivalTime;
}
```

**AHORA:**
```java
public void calculateTurnaroundTime() {
    // Tiempo de retorno = Tiempo de finalización (sin restar tiempo de llegada)
    this.turnaroundTime = this.completionTime;
}
```

### 2. Archivo: `tests/ResultFormatter.java`

**ANTES:**
```java
for (Process p : processes) {
    System.out.printf("P%d = (%d - %d) = %d ut\n",
            p.getPid(), p.getCompletionTime(), p.getArrivalTime(), p.getTurnaroundTime());
}
```

**AHORA:**
```java
for (Process p : processes) {
    System.out.printf("P%d = %d ut\n",
            p.getPid(), p.getTurnaroundTime());
}
```

## 📊 EJEMPLO VERIFICADO

### Datos de Entrada
| Proceso | Llegada | Ráfaga |
|---------|---------|--------|
| A (P1)  | 2       | 3      |
| B (P2)  | 4       | 1      |
| C (P3)  | 0       | 3      |
| D (P4)  | 1       | 4      |
| E (P5)  | 3       | 2      |

### Orden de Ejecución
C(P3) → D(P4) → A(P1) → E(P5) → B(P2)

### Línea de Tiempo
```
       C(P3)     D(P4)     A(P1)   E(P5) B(P2)
  |---|---|---|---|---|---|---|---|---|---|---|---|---|
  0       3       7       10      12   13  
```

### Tiempos de Retorno (CORREGIDOS)
```
P3 (C) = 3 ut   ← Finaliza en 3
P4 (D) = 7 ut   ← Finaliza en 7
P1 (A) = 10 ut  ← Finaliza en 10
P5 (E) = 12 ut  ← Finaliza en 12
P2 (B) = 13 ut  ← Finaliza en 13
```

### Métricas Finales
```
TME = (0 + 2 + 5 + 7 + 8) / 5 = 22 / 5 = 4.4 ut
TMR = (3 + 7 + 10 + 12 + 13) / 5 = 45 / 5 = 9.0 ut ✓
```

## ✅ VERIFICACIÓN

Ahora el simulador produce **exactamente** los mismos resultados que tu imagen:
- ✅ Tiempos de Retorno correctos (3, 7, 10, 12, 13)
- ✅ TME = 4.4 ut
- ✅ TMR = 9.0 ut

## 🚀 CÓMO USAR

```cmd
.\run.bat
```

Ingresa los datos en este orden para replicar el ejercicio:
1. P1 (A): Llegada=2, Ráfaga=3
2. P2 (B): Llegada=4, Ráfaga=1
3. P3 (C): Llegada=0, Ráfaga=3
4. P4 (D): Llegada=1, Ráfaga=4
5. P5 (E): Llegada=3, Ráfaga=2

Los resultados ahora coincidirán perfectamente con tu imagen.

---

**Fecha de corrección**: 15 de octubre de 2025  
**Archivos modificados**:
- `src/models/ProcessCalculator.java`
- `src/tests/ResultFormatter.java`
