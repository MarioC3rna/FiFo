@echo off
setlocal

echo ========================================
echo    SIMULADOR DE PLANIFICACION FIFO
echo ========================================
echo.
echo CORRECCION: Cuando dos procesos llegan
echo al mismo tiempo, se prioriza el de
echo menor rafaga de CPU.
echo ========================================
echo.

REM Configurar Java 21
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

echo Compilando el proyecto...
cd /d "%~dp0src"

REM Limpiar archivos compilados anteriores
del /Q *.class 2>nul
del /Q models\*.class 2>nul
del /Q scheduler\*.class 2>nul
del /Q cli\*.class 2>nul
del /Q tests\*.class 2>nul

echo Compilando con Java 21...
javac -cp . cli\CLI.java models\Process.java models\ProcessAccessors.java models\ProcessCalculator.java models\ProcessData.java scheduler\FIFO.java tests\App.java tests\ResultFormatter.java

if %ERRORLEVEL% NEQ 0 (
    echo Error en la compilacion
    pause
    exit /b 1
)

echo Compilacion exitosa!
echo.
echo Ejecutando el simulador...
echo ========================================
java -cp . tests.App

pause