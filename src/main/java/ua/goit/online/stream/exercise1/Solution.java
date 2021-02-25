package ua.goit.online.stream.exercise1;

import ua.goit.online.stream.Student;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Exercise1 exercise = new Exercise1();
        System.out.println(exercise1(exercise.getStudents()));
    }

    private static List<Student> exercise1(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
    }
}
