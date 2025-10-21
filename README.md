# Simulador FIFO - Planificacion de Procesos

Simulador del algoritmo FIFO (First In, First Out) para Sistemas Operativos.

## Ejecucion

```cmd
EJECUTAR.bat
```

## Estructura

```
FiFo/
├── src/
│   ├── cli/
│   │   └── CLI.java              # Interfaz de usuario
│   ├── models/
│   │   ├── Process.java          # Clase principal de proceso
│   │   ├── ProcessData.java      # Datos del proceso
│   │   ├── ProcessAccessors.java # Getters y setters
│   │   └── ProcessCalculator.java # Calculos de tiempos
│   ├── scheduler/
│   │   └── FIFO.java             # Algoritmo FIFO
│   └── tests/
│       ├── App.java              # Aplicacion principal
│       └── ResultFormatter.java  # Formato de resultados
├── EJECUTAR.bat                  # Script de ejecucion
└── README.md                     # Este archivo
```

## Estructura

```
FiFo/
├── src/
│   ├── cli/
│   │   └── CLI.java              # Interfaz de usuario
│   ├── models/
│   │   ├── Process.java          # Clase principal de proceso
│   │   ├── ProcessData.java      # Datos del proceso
│   │   ├── ProcessAccessors.java # Getters y setters
│   │   └── ProcessCalculator.java # Calculos de tiempos
│   ├── scheduler/
│   │   └── FIFO.java             # Algoritmo FIFO
│   └── tests/
│       ├── App.java              # Aplicacion principal
│       └── ResultFormatter.java  # Formato de resultados
├── EJECUTAR.bat                  # Script de ejecucion
└── README.md                     # Este archivo
```

## Descripcion de Carpetas

### 📁 `src/cli/`
Contiene la interfaz de linea de comandos del simulador.
Maneja toda la interaccion con el usuario: entrada de datos, validaciones y mensajes.
Se encarga de solicitar el numero de procesos y los datos de cada uno (tiempo de llegada y rafaga).

### 📁 `src/models/`
Define la estructura de datos de los procesos y sus calculos.
Incluye las clases principales para representar un proceso con todos sus atributos.
Contiene la logica para calcular tiempos de espera, retorno y otras metricas del proceso.

### 📁 `src/scheduler/`
Implementa el algoritmo de planificacion FIFO (First In, First Out).
Contiene la logica principal para ordenar procesos por tiempo de llegada y rafaga.
Se encarga de ejecutar la simulacion y calcular los tiempos de inicio y finalizacion.

### 📁 `src/tests/`
Contiene la aplicacion principal y el formateador de resultados.
App.java es el punto de entrada principal que coordina todo el flujo del programa.
ResultFormatter.java se encarga de mostrar los resultados de forma organizada y legible.

## Descripcion de Archivos Java

### 📄 `CLI.java`
Clase principal para la interfaz de usuario en consola.
Gestiona la entrada de datos del usuario con validaciones robustas para evitar errores.
Proporciona metodos para confirmar acciones y mostrar resumenes de los procesos ingresados.

### 📄 `Process.java`
Clase central que representa un proceso en el sistema operativo.
Hereda de ProcessAccessors y ProcessCalculator para tener funcionalidad completa.
Encapsula todos los datos necesarios: PID, tiempo de llegada, rafaga, inicio, fin, espera y retorno.

### 📄 `ProcessData.java`
Clase base que define los atributos fundamentales de un proceso.
Contiene las variables principales: pid, arrivalTime, burstTime y los tiempos calculados.
Sirve como fundacion para las demas clases del modelo de proceso.

### 📄 `ProcessAccessors.java`
Clase que proporciona metodos getter y setter para los atributos del proceso.
Permite acceso controlado a las propiedades del proceso manteniendo encapsulacion.
Incluye validaciones basicas para asegurar la integridad de los datos.

### 📄 `ProcessCalculator.java`
Clase especializada en realizar todos los calculos relacionados con tiempos de proceso.
Implementa las formulas para tiempo de espera, tiempo de retorno y validaciones.
Contiene la logica matematica especifica del algoritmo de planificacion FIFO.

### 📄 `FIFO.java`
Implementacion completa del algoritmo de planificacion FIFO (First In, First Out).
Ordena procesos por tiempo de llegada, con desempate por rafaga menor y luego por PID.
Ejecuta la simulacion completa calculando tiempos de inicio, fin y metricas finales.

### 📄 `App.java`
Punto de entrada principal del programa que coordina toda la ejecucion.
Maneja el flujo completo: entrada de datos, ejecucion del algoritmo y presentacion de resultados.
Incluye manejo de errores y opciones para realizar multiples simulaciones consecutivas.

### 📄 `ResultFormatter.java`
Clase encargada de formatear y presentar los resultados de la simulacion.
Genera tablas organizadas, linea de tiempo y calculos de metricas finales (TME y TMR).
Utiliza solo caracteres ASCII para garantizar compatibilidad con archivos ejecutables.

## Requisitos

- Java 21 (Eclipse Adoptium)
- Windows

## Algoritmo

**Criterio FIFO:**
1. Tiempo de llegada (menor primero)
2. Si empatan: Rafaga de CPU (menor primero)  
3. Si empatan: PID (menor primero)

**Calculos:**
- Tiempo de Espera = Inicio - Llegada
- Tiempo de Retorno = Finalizacion
- TME = Promedio de tiempos de espera
- TMR = Promedio de tiempos de retorno
