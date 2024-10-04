package ua.goit.online.stream.exercise3;

import ua.goit.online.stream.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    //3. Сгруппировать студентов по возрасту Map<Integer, List<Student>>
    public static void main(String[] args) {
        Map<Integer, List<Student>> integerListMap = new Exercise3().getStudents().stream()
                .collect(Collectors.groupingBy(Student::getAge));
        System.out.println(integerListMap);
        //{33=[Student{id=3, firstName='Luis', lastName='Suares', age=33}, Student{id=4, firstName='Zinedine', lastName='Zidane', age=33}],
        // 28=[Student{id=2, firstName='David', lastName='Beckham', age=28}, Student{id=4, firstName='Zinedine', lastName='Zidane', age=28}],
        // 31=[Student{id=1, firstName='Eric', lastName='Cantona', age=31}, Student{id=4, firstName='Zinedine', lastName='Zidane', age=31}]}
    }
}
