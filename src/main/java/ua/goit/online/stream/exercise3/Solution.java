package ua.goit.online.stream.exercise3;

import ua.goit.online.stream.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Exercise3 exercise = new Exercise3();
        System.out.println(geoupingByAge(exercise.getStudents()));
    }

    private static Map<Integer, List<Student>> geoupingByAge(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(Student::getAge));

    }

}
