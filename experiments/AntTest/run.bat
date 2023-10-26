@echo off

md build\classes
javac -sourcepath src -d build\classes src\mine\HelloWorld.java
java -cp build\classes mine.HelloWorld

pause