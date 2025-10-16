# Explicación de PIDs y Nombres de Procesos

## Relación entre PIDs y Nombres

Cuando ingresas procesos en el simulador, se les asigna un **PID (Process ID)** secuencial según el orden de entrada:

### Ejemplo del Ejercicio

**Orden de Entrada:**
1. Proceso A → Se asigna **P1**
2. Proceso B → Se asigna **P2**
3. Proceso C → Se asigna **P3**
4. Proceso D → Se asigna **P4**
5. Proceso E → Se asigna **P5**

**Equivalencias:**
- A = P1
- B = P2
- C = P3
- D = P4
- E = P5

## Datos del Ejercicio

### Entrada
| Nombre | PID | Ráfaga CPU | Tiempo Llegada |
|--------|-----|------------|----------------|
| A      | P1  | 3          | 2              |
| B      | P2  | 1          | 4              |
| C      | P3  | 3          | 0              |
| D      | P4  | 4          | 1              |
| E      | P5  | 2          | 3              |

### Orden de Ejecución FIFO

Siguiendo el algoritmo FIFO (ordenar por tiempo de llegada, y si empatan por ráfaga menor):

1. **C (P3)**: Llega en 0 → Ejecuta de 0 a 3
2. **D (P4)**: Llega en 1 → Ejecuta de 3 a 7
3. **A (P1)**: Llega en 2 → Ejecuta de 7 a 10
4. **E (P5)**: Llega en 3 → Ejecuta de 10 a 12
5. **B (P2)**: Llega en 4 → Ejecuta de 12 a 13

### Línea de Tiempo

```
       C(P3)     D(P4)     A(P1)   E(P5) B(P2)
  |---|---|---|---|---|---|---|---|---|---|---|---|---|
  0       3       7       10      12   13  
```

### Tiempos de Espera

```
A (P1) = (7 - 2) = 5 ut
B (P2) = (12 - 4) = 8 ut
C (P3) = (0 - 0) = 0 ut
D (P4) = (3 - 1) = 2 ut
E (P5) = (10 - 3) = 7 ut
```

### Tiempos de Retorno

```
A (P1) = (10 - 2) = 8 ut
B (P2) = (13 - 4) = 9 ut
C (P3) = (3 - 0) = 3 ut
D (P4) = (7 - 1) = 6 ut
E (P5) = (12 - 3) = 9 ut
```

### Métricas Finales

```
TME = (5 + 8 + 0 + 2 + 7) / 5 = 22 / 5 = 4.4 ut
TMR = (8 + 9 + 3 + 6 + 9) / 5 = 35 / 5 = 7.0 ut
```

## ✅ Verificación

Los resultados del simulador son **CORRECTOS**. Solo tienes que recordar que:
- P1 corresponde a A
- P2 corresponde a B
- P3 corresponde a C
- P4 corresponde a D
- P5 corresponde a E

El simulador está funcionando perfectamente. Los cálculos coinciden exactamente con los de tu imagen.

## 📝 Nota Importante

Si quieres que los procesos aparezcan con nombres específicos (A, B, C, D, E) en lugar de PIDs numéricos (P1, P2, P3, P4, P5), se necesitaría modificar el código para aceptar nombres de procesos personalizados en lugar de solo números.

Por ahora, el sistema usa PIDs numéricos automáticos, lo cual es el estándar en sistemas operativos reales.
