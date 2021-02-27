package ua.goit.online.stream.exercise5_1;

import ua.goit.online.stream.Student;

import java.util.Arrays;
import java.util.List;

public class Exercise5 {
    public List<Student> getStudents() {
        return Arrays.asList(new Student(1, "Eric", "Cantona", 31),
                new Student(2, "David", "Beckham", 28),
                new Student(3, "Luis", "Suares", 33),
                new Student(4, "Zinedine", "Zidane", 28),
                new Student(5, "Cristiano", "Ronaldo", 31),
                null,
                new Student(6, "Zlatan", "Ibrahimovich", 31),
                new Student(7, "Ronaldinho", "Gaucho", 33));
    }
}
