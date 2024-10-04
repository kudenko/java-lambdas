package ua.goit.online.stream.exercise4;

import ua.goit.online.stream.Student;

import java.util.stream.Collectors;

public class Main {
    //4. Вывести все имена футболистов, возраст которых старше 30 лет, через запятую
    public static void main(String[] args) {
        System.out.println(new Exercise4().getStudents().stream().filter(student -> student.getAge() > 30)
                        .map(Student::getFirstName)
                .collect(Collectors.joining(", ")));
        //Eric, Luis, Cristiano, Ronaldinho
    }
}
