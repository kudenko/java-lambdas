package ua.goit.online.stream.exercise1;

import ua.goit.online.stream.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //1. Получить список студентов, отсортировав их по имени
    public static void main(String[] args) {
        List<Student> studentList = new Exercise1().getStudents().stream()
                .sorted(Comparator.comparing(Student::getFirstName)).collect(Collectors.toList());
        System.out.println(studentList);
        // [Student{id=2, firstName='David', lastName='Beckham', age=28}, Student{id=1, firstName='Eric', lastName='Cantona', age=31},
        // Student{id=3, firstName='Luis', lastName='Suares', age=33}, Student{id=4, firstName='Zinedine', lastName='Zidane', age=33}]
    }
}
