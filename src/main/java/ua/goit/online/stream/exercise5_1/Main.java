package ua.goit.online.stream.exercise5_1;

import ua.goit.online.stream.Student;

import java.util.Comparator;
import java.util.Objects;

public class Main {
    //5.Предоставлен список студентов, отсортировать студентов сначала по имени, потом по фамилии
    public static void main(String[] args) {
        new Exercise5().getStudents().stream().filter(Objects::nonNull).sorted(Comparator.comparing(Student::getFirstName)
                .thenComparing(Student::getLastName)).forEach(System.out::println);
        //Student{id=5, firstName='Cristiano', lastName='Ronaldo', age=31}
        //Student{id=2, firstName='David', lastName='Beckham', age=28}
        //Student{id=1, firstName='Eric', lastName='Cantona', age=31}
        //Student{id=3, firstName='Luis', lastName='Suares', age=33}
        //Student{id=7, firstName='Ronaldinho', lastName='Gaucho', age=33}
        //Student{id=4, firstName='Zinedine', lastName='Zidane', age=28}
        //Student{id=6, firstName='Zlatan', lastName='Ibrahimovich', age=31}
    }
}
