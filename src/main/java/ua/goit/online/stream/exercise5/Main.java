package ua.goit.online.stream.exercise5;

import ua.goit.online.stream.Student;

import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    //5. Сгрупировать студентов по идентификатору и вывести имя и фамилию студента Map<Integer, String>
    public static void main(String[] args) {
        Map<Integer, String> students = new Exercise5().getStudents().stream()
                .collect(Collectors.toMap(Student::getId, student -> student.getFirstName() + " " + student.getLastName(),
                        (ex, rep) -> rep));
        System.out.println(students);
        //{1=Eric Cantona, 2=David Beckham, 3=Zinedine Zidane, 4=Ronaldinho Gaucho}
    }
}
