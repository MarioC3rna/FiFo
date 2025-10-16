@echo off
setlocal

set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

cd /d "%~dp0src"

echo Compilando proyecto...
javac -cp . cli\CLI.java models\Process.java models\ProcessAccessors.java models\ProcessCalculator.java models\ProcessData.java scheduler\FIFO.java tests\App.java tests\ResultFormatter.java

if %ERRORLEVEL% NEQ 0 (
    echo Error en la compilacion
    pause
    exit /b 1
)

echo Compilacion exitosa!
echo.
echo Ejecutando simulador...
echo ========================================
java -cp . tests.App

pause
