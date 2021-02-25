package ua.goit.online.stream.exercise2;

import ua.goit.online.stream.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Exercise2 exercise = new Exercise2();

        System.out.println(ageMoreThen30(exercise.getStudents()));
    }

    private static List<Student> ageMoreThen30(List<Student> students) {
        return students.stream()
                .filter(student -> student.getAge() >= 30)
                .sorted(Comparator.comparing(Student::getLastName).reversed())
                .collect(Collectors.toList());
    }
}
