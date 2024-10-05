package ua.goit.online.stream.exercise7;

import ua.goit.online.stream.Student;
import ua.goit.online.stream.exercise5_1.Exercise5;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    //7. Найти студента с самой длинной фамилией.
    public static void main(String[] args) {
        Student studentMaxLengthLastName = new Exercise7().getStudents().stream()
                .max(Comparator.comparingInt((Student student) -> student.getLastName().length())
                        .thenComparing(student -> student.getFirstName().length()))
                .orElseThrow(() -> new RuntimeException("No data with current filter"));

        System.out.println(studentMaxLengthLastName);
    }
}
