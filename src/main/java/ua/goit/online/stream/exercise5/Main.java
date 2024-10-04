package ua.goit.online.stream.exercise5;

import ua.goit.online.stream.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    //5. Сгрупировать студентов по идентификатору и вывести имя и фамилию студента Map<Integer, String>
    public static void main(String[] args) {
        //1. Should be Map<Integer, String> or Integer <List<Student?>>
        //2. grouping and printing should be in one stream?
        Map<Integer, List<Student>> students = new Exercise5().getStudents().stream().collect(Collectors.groupingBy(Student::getId));
        System.out.println(students);
//        {1=[Student{id=1, firstName='Eric', lastName='Cantona', age=31}],
//        2=[Student{id=2, firstName='David', lastName='Beckham', age=28}],
//        3=[Student{id=3, firstName='Luis', lastName='Suares', age=33}, Student{id=3, firstName='Zinedine', lastName='Zidane', age=28}],
//        4=[Student{id=4, firstName='Cristiano', lastName='Ronaldo', age=31}, Student{id=4, firstName='Ronaldinho', lastName='Gaucho', age=33}]}
        new Exercise5().getStudents().forEach(
                student -> System.out.println(student.getFirstName() + " " + student.getLastName())
        );
        //Eric Cantona
        //David Beckham
        //Luis Suares
        //Zinedine Zidane
        //Cristiano Ronaldo
        //Ronaldinho Gaucho
    }
}
