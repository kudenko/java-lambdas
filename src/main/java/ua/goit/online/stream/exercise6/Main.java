package ua.goit.online.stream.exercise6;

import ua.goit.online.stream.Student;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //6. вывести в консоль сообщение "Hello firstName lastName" по каждому студенту
    public static void main(String[] args) {
        new Exercise6().getStudents().forEach(student -> System.out.println("Hello " + student.getFirstName() + " " + student.getLastName()));

        //Hello Eric Cantona
        //Hello David Beckham
        //Hello Luis Suares
        //Hello Zinedine Zidane
        //Hello Cristiano Ronaldo
        //Hello Ronaldinho Gaucho

        System.out.println(new Exercise6().getStudents().stream().map(student -> "Hello " + student.getFirstName() + " " + student.getLastName()).collect(Collectors.joining(", ")));

        //Hello Eric Cantona, Hello David Beckham, Hello Luis Suares, Hello Zinedine Zidane, Hello Cristiano Ronaldo, Hello Ronaldinho Gaucho
    }
}
