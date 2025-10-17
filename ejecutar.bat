@echo off
setlocal

title Simulador FIFO

cls
echo.
echo ================================================
echo        SIMULADOR DE PLANIFICACION FIFO
echo ================================================
echo.

REM Configurar Java 21
set JAVA_HOME=C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot
set PATH=%JAVA_HOME%\bin;%PATH%

echo [1/3] Verificando Java...
java -version 2>nul
if errorlevel 1 (
    echo ERROR: Java 21 no encontrado
    pause
    exit /b 1
)
echo OK - Java encontrado
echo.

echo [2/3] Limpiando compilaciones anteriores...
if exist bin rmdir /s /q bin
mkdir bin
echo OK - Limpieza completa
echo.

echo [3/3] Compilando proyecto...
javac -encoding UTF-8 -d bin src\cli\*.java src\models\*.java src\scheduler\*.java src\tests\*.java
if errorlevel 1 (
    echo.
    echo ERROR en la compilacion
    pause
    exit /b 1
)
echo OK - Compilacion exitosa
echo.

echo ================================================
echo.
java -cp bin -Dfile.encoding=UTF-8 tests.App

echo.
echo ================================================
pause
