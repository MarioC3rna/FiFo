# Simulador de Planificación FIFO

Simulador del algoritmo de planificación FIFO (First In, First Out) para Sistemas Operativos.

## 🚀 Ejecución Rápida

```cmd
EJECUTAR.bat
```

## 📋 Características

✅ **Ordenamiento correcto**: Los procesos con el mismo tiempo de llegada se ordenan por ráfaga menor  
✅ **Interfaz limpia**: Resultados con formato profesional  
✅ **Cálculos automáticos**: Tiempos de espera, retorno y métricas finales  
✅ **Línea de tiempo visual**: Representación gráfica de la ejecución  

## 📊 Formato de Salida

### 1. Tabla de Procesos
Muestra los procesos con su ráfaga de CPU y tiempo de llegada.

### 2. Línea de Tiempo
Representación visual de cuándo se ejecuta cada proceso.

### 3. Tiempos de Espera
Cálculo: `Tiempo de Inicio - Tiempo de Llegada`

### 4. Tiempos de Retorno
Cálculo: `Tiempo de Finalización` (sin restar tiempo de llegada)

### 5. Métricas Finales
- **TME**: Tiempo Medio de Espera
- **TMR**: Tiempo Medio de Retorno

## 📁 Estructura del Proyecto

```
FiFo/
├── src/
│   ├── cli/
│   │   └── CLI.java              # Interfaz de usuario
│   ├── models/
│   │   ├── Process.java          # Clase principal de proceso
│   │   ├── ProcessData.java      # Datos del proceso
│   │   ├── ProcessAccessors.java # Getters y setters
│   │   └── ProcessCalculator.java # Cálculos de tiempos
│   ├── scheduler/
│   │   └── FIFO.java             # Algoritmo FIFO
│   └── tests/
│       ├── App.java              # Aplicación principal
│       └── ResultFormatter.java  # Formato de resultados
├── EJECUTAR.bat                  # Script de ejecución
└── README.md                     # Este archivo
```

## 🔧 Requisitos

- Java 21 (OpenJDK Eclipse Adoptium)
- Windows (PowerShell o CMD)

## 📝 Ejemplo de Uso

1. Ejecuta `EJECUTAR.bat`
2. Ingresa el número de procesos (1-20)
3. Para cada proceso ingresa:
   - Tiempo de llegada (≥ 0)
   - Ráfaga de CPU (> 0)
4. Confirma la simulación
5. Visualiza los resultados

## 🎯 Algoritmo FIFO

**Criterio de ordenamiento:**
1. Tiempo de llegada (menor primero)
2. Si empatan: Ráfaga de CPU (menor primero)
3. Si empatan: PID (menor primero)

## 💡 Notas

- Los procesos se identifican como P1, P2, P3, etc. según el orden de entrada
- El simulador calcula automáticamente todos los tiempos
- Los resultados se muestran con formato académico

---

**Versión**: 3.0 (Simplificada y Optimizada)  
**Fecha**: 16 de octubre de 2025
