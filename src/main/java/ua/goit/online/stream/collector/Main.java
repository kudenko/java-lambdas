package ua.goit.online.stream.collector;

import ua.goit.online.stream.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = getStudents();
        MinAndMaxCollector.Pair<Student> collect = students.stream()
                .collect(new MinAndMaxCollector<>(Comparator.comparing(Student::getFirstName)));

        System.out.println(collect.getMin());
        System.out.println(collect.getMax());
    }

    public static List<Student> getStudents() {
        return Arrays.asList(new Student(1, "Er", "Cantona", 31),
                new Student(2, "David", "Beckham", 28),
                new Student(3, "Luis", "Suares", 33),
                new Student(4, "Zinedine", "Zidane", 28),
                new Student(5, "Cristiano", "Ronaldo", 31),
                new Student(6, "Zlatan", "Ibrahimovich", 31),
                new Student(7, "Ronaldinho", "Gaucho", 33));
    }
}
