# Simulador de Planificación FIFO

## ✅ Corrección Implementada

**PROBLEMA SOLUCIONADO**: El algoritmo ahora ordena correctamente los procesos cuando tienen el mismo tiempo de llegada, priorizando el que tiene la ráfaga más pequeña.

### Lógica de Ordenamiento:
1. **Primero**: Se ordena por tiempo de llegada (menor primero)
2. **Si dos procesos llegan al mismo tiempo**: Se ordena por ráfaga de CPU (menor primero)
3. **Si ambos tienen la misma ráfaga**: Se ordena por PID

## 🚀 Cómo Ejecutar el Proyecto

### Opción 1: Script Automático (Recomendado)
```cmd
# Desde el directorio raíz del proyecto
.\run.bat
```

### Opción 2: Comandos Manuales con Java 21

**Compilar:**
```cmd
cd src
"C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\javac" -cp . cli\CLI.java models\*.java scheduler\FIFO.java tests\*.java
```

**Ejecutar:**
```cmd
"C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java" -cp . tests.App
```

## 📋 Ejemplo de Prueba

Para verificar que el ordenamiento funciona correctamente, prueba con estos procesos que **todos llegan al mismo tiempo (3)**:

```
Proceso 1: Llegada=3, Ráfaga=5
Proceso 2: Llegada=3, Ráfaga=2
Proceso 3: Llegada=3, Ráfaga=1
Proceso 4: Llegada=3, Ráfaga=10
```

**Orden de ejecución esperado**: P3 → P2 → P1 → P4  
(ordenados por ráfaga: 1, 2, 5, 10)

## 📁 Estructura del Proyecto

```
FiFo/
├── src/
│   ├── cli/
│   │   └── CLI.java                # Interfaz de usuario
│   ├── models/
│   │   ├── Process.java            # Modelo de proceso
│   │   ├── ProcessAccessors.java
│   │   ├── ProcessCalculator.java
│   │   └── ProcessData.java
│   ├── scheduler/
│   │   └── FIFO.java               # ⭐ Algoritmo FIFO (CORREGIDO)
│   └── tests/
│       ├── App.java                # Aplicación principal
│       ├── AppFixed.java
│       └── ResultFormatter.java    # Formateo de resultados
├── run.bat                         # Script de ejecución
└── README.md                       # Este archivo
```

## 🔧 Requisitos

- **Java 21** (Eclipse Adoptium OpenJDK)
- Windows (PowerShell o CMD)

## ⚠️ Notas Importantes

- Asegúrate de usar Java 21 (el proyecto fue compilado con esta versión)
- Si encuentras errores de "clase no encontrada", verifica que estés en el directorio `src` al ejecutar
- El script `run.bat` maneja automáticamente la compilación y ejecución