package ua.goit.online.stream.exercise8;

import ua.goit.online.stream.Student;
import ua.goit.online.stream.exercise5.Exercise5;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    //8. Сгрупировать студентов по возрасту и получить коллекцию Map<Integer, Optional<Student>>, где Student - студент с самым
    //коротким именем

    public static void main(String[] args) {
        Map<Integer, Optional<Student>> studentMap = new Exercise8().getStudents().stream().filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Student::getAge,
                        Collectors.minBy(Comparator.comparing(student -> student.getFirstName().length()))));
        System.out.println(studentMap);
    }
}
