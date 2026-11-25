# COSC 311 Student Database

Java data structures coursework on maintaining sorted views of a single student-record store. The console app can add, delete, find, and list records using separate indexes for student ID, first name, and last name. [Record store](src/Database.java) · [Sorted index](src/IndexArray.java)

## Run locally

Run these commands in the repository root, where the program loads dataset.txt:

    mkdir build
    javac -d build -sourcepath src src/COSC311_Driver_Program1.java
    java -cp build COSC311_Driver_Program1

Use the numbered menu to work with records. Enter 0 to exit.
