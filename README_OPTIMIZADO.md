# Simulador de Planificación FIFO - Versión Optimizada

## ✅ CARACTERÍSTICAS IMPLEMENTADAS

### 1. **Corrección del Ordenamiento**
Cuando dos o más procesos tienen el mismo tiempo de llegada, se prioriza el que tiene **menor ráfaga de CPU**.

**Criterio de ordenamiento:**
1. Tiempo de llegada (menor primero)
2. Si empatan: Ráfaga de CPU (menor primero)
3. Si empatan: PID (menor primero)

### 2. **Interfaz Optimizada**
Formato de salida profesional con:
- ✅ **Tabla de Procesos**: Proceso, Ráfaga CPU, Tiempo Llegada
- ✅ **Línea de Tiempo Visual**: Representación gráfica de la ejecución
- ✅ **Tiempos de Espera**: Cálculo detallado para cada proceso
- ✅ **Tiempos de Retorno**: Cálculo detallado para cada proceso
- ✅ **Métricas Finales**: TME y TMR con formato limpio

## 🚀 CÓMO EJECUTAR

### Opción Recomendada:
```cmd
.\run.bat
```

### Compilación Manual:
```cmd
cd src
"C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\javac" -cp . cli\CLI.java models\*.java scheduler\FIFO.java tests\*.java
"C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java" -cp . tests.App
```

## 📊 EJEMPLO DE SALIDA

```
╔════════════════════════════════════════════════╗
║           TABLA DE PROCESOS                  ║
╚════════════════════════════════════════════════╝

┌────────────┬──────────────┬────────────────┐
│  Proceso   │  Ráfaga CPU  │ Tiempo Llegada │
├────────────┼──────────────┼────────────────┤
│     P3     │       1      │        3       │
│     P2     │       2      │        3       │
│     P1     │       3      │        2       │
│     P5     │       2      │        3       │
│     P4     │       4      │        1       │
└────────────┴──────────────┴────────────────┘

╔════════════════════════════════════════════════╗
║           LÍNEA DE TIEMPO                    ║
╚════════════════════════════════════════════════╝

       P4      P1      P3   P2   P5  
    0      4      7      8   10  12  

╔════════════════════════════════════════════════╗
║       TIEMPOS DE ESPERA (Waiting Time)       ║
╚════════════════════════════════════════════════╝

P4 = (1 - 1) = 0 ut
P1 = (4 - 2) = 2 ut
P3 = (7 - 3) = 4 ut
P2 = (8 - 3) = 5 ut
P5 = (10 - 3) = 7 ut

╔════════════════════════════════════════════════╗
║      TIEMPOS DE RETORNO (Turnaround Time)    ║
╚════════════════════════════════════════════════╝

P4 = (4 - 1) = 3 ut
P1 = (7 - 2) = 5 ut
P3 = (8 - 3) = 5 ut
P2 = (10 - 3) = 7 ut
P5 = (12 - 3) = 9 ut

╔════════════════════════════════════════════════╗
║             MÉTRICAS FINALES                 ║
╚════════════════════════════════════════════════╝

TME (Tiempo Medio de Espera)   = 3.60 ut
TMR (Tiempo Medio de Retorno)  = 5.80 ut
```

## 📁 ESTRUCTURA DEL PROYECTO

```
FiFo/
├── src/
│   ├── cli/
│   │   └── CLI.java                 # Interfaz de usuario
│   ├── models/
│   │   ├── Process.java             # Modelo de proceso
│   │   ├── ProcessAccessors.java
│   │   ├── ProcessCalculator.java
│   │   └── ProcessData.java
│   ├── scheduler/
│   │   └── FIFO.java                # ⭐ Algoritmo FIFO (Optimizado)
│   └── tests/
│       ├── App.java                 # ⭐ Aplicación principal (Optimizada)
│       └── ResultFormatter.java     # ⭐ Formato de salida (Optimizado)
├── run.bat                          # Script de ejecución
├── ejecutar.bat                     # Script alternativo
└── README.md                        # Este archivo
```

## 🔧 ARCHIVOS MODIFICADOS/OPTIMIZADOS

1. **scheduler/FIFO.java**
   - Corrección del ordenamiento por ráfaga
   
2. **tests/ResultFormatter.java**
   - Formato de salida completamente rediseñado
   - Tablas con bordes profesionales
   - Línea de tiempo visual
   - Cálculos detallados de tiempos
   
3. **tests/App.java**
   - Flujo simplificado
   - Eliminación de pausas innecesarias
   - Código más limpio y legible

## 🧪 CASO DE PRUEBA

Para verificar el ordenamiento correcto, prueba con estos procesos:

```
Proceso 1: Llegada=3, Ráfaga=5
Proceso 2: Llegada=3, Ráfaga=2
Proceso 3: Llegada=3, Ráfaga=1
Proceso 4: Llegada=3, Ráfaga=10
```

**Orden esperado**: P3 (ráfaga=1) → P2 (ráfaga=2) → P1 (ráfaga=5) → P4 (ráfaga=10)

## 📝 NOTAS

- Se requiere **Java 21** (OpenJDK Temurin)
- El formato de salida cumple con estándares académicos
- Código completamente documentado
- Optimizado para claridad y mantenibilidad

## 🎯 MÉTRICAS CALCULADAS

- **Tiempo de Espera**: `Tiempo de Inicio - Tiempo de Llegada`
- **Tiempo de Retorno**: `Tiempo de Finalización - Tiempo de Llegada`
- **TME**: Promedio de todos los tiempos de espera
- **TMR**: Promedio de todos los tiempos de retorno

---

**Versión**: 2.0 (Optimizada)  
**Última actualización**: 15 de octubre de 2025
