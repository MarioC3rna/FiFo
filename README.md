
Comandos para poder ejecutar el programa en la cmd con java 21

Compilar en Java 21

"C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\javac" -d bin -cp src src\*.java src\models\*.java src\scheduler\*.java src\cli\*.java

Ejecutar el programa con java 21
"C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java" -cp bin App


Comando todo-en-uno (compilar y ejecutar):

cd "C:\Users\mario\Desktop\FiFo" && "C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\javac" -d bin -cp src src\*.java src\models\*.java src\scheduler\*.java src\cli\*.java && "C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java" -cp bin App