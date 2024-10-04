package ua.goit.online.stream.exercise2;

import ua.goit.online.stream.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    //2. Получить список студентов, возраст которых больше 30, отсортировав их по фамилии в обратном порядке
    public static void main(String[] args) {
        List<Student> studentList = new Exercise2().getStudents().stream().filter(student -> student.getAge() > 30)
                .sorted(Comparator.comparing(Student::getLastName).reversed()).collect(Collectors.toList());

        System.out.println(studentList);
        //[Student{id=4, firstName='Zinedine', lastName='Zidane', age=33},
        // Student{id=3, firstName='Luis', lastName='Suares', age=33},
        // Student{id=1, firstName='Eric', lastName='Cantona', age=31}]
    }
}
