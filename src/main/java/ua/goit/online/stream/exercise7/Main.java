package ua.goit.online.stream.exercise7;

import ua.goit.online.stream.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    //7. Найти студента с самой длинной фамилией.
    public static void main(String[] args) {
        Optional<Student> studentMaxLengthLastName = new Exercise7().getStudents().stream()
                .max(Comparator.comparing(student -> student.getLastName().length()));
        System.out.println(studentMaxLengthLastName.get());
        //Student{id=6, firstName='Zlatan', lastName='Ibrahimovich', age=31}

        //Is it Ok to grab last element after filtering, or it should be done in the stream?

    }
}
