package ua.goit.online.stream.additional;

import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class AdditionalTasks {
    public static void main(String[] args) {
        /*TODO Задача №1*/
        //Конвертировать елементы коллекции в аппер кейс
        //Input Parameters
        // List<String> collection = asList("My", "name", "is", "John", "Doe");
        //Expected result
        // List<String> expected = asList("MY", "NAME", "IS", "JOHN", "DOE");

        List<String> collection1 = asList("My", "name", "is", "John", "Doe");

        List<String> convertedCollection1 = collection1.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(convertedCollection1);
        //[MY, NAME, IS, JOHN, DOE]

        /*TODO Задача №2*/
        //Отфильтровать коллекцию так, что бы только получить елементы длина которых меньше 4 символов
        //Input Parameters
        // List<String> collection = asList("My", "name", "is", "John", "Doe");
        //Expected result
        // List<String> expected = asList("My", "is", "Doe");

        List<String> collection2 = asList("My", "name", "is", "John", "Doe");
        List<String> filteredCollection2 = collection2.stream().filter(string -> string.length() < 4).collect(Collectors.toList());
        System.out.println(filteredCollection2);
        //[My, is, Doe]


        /*TODO Задача №3*/
        //Обьединить два списка в один!
        //Input Parameters
        // List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
        //Expected result
        // List<String> expected = asList("Viktor", "Farcic", "John", "Doe", "Third");

        List<List<String>> collection3 = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));

        List<String> collectionConverted3 = collection3.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println(collectionConverted3);
        //[Viktor, Farcic, John, Doe, Third]

        /*TODO Задача №4*/
        //Получить самого старого сотрудника с коллекции
        //Input Parameters
        // Employee sara = new Employee("Sara", 45);
        // Employee viktor = new Employee("Viktor", 40);
        // Employee eva = new Employee("Eva", 42);
        //List<Employee> collection = asList(sara, eva, viktor);
        //Expected result
        // Eva is the oldest person

         Employee sara = new Employee("Sara", 45);
         Employee viktor = new Employee("Viktor", 40);
         Employee eva = new Employee("Eva", 42);
        List<Employee> collectionEmployee = asList(sara, eva, viktor);

        Employee oldestPerson = collectionEmployee.stream().max(Comparator.comparingInt(Employee::getAge))
                .orElseThrow(() -> new RuntimeException("No employee was present"));
        System.out.println(oldestPerson.getName() + " is the oldest person");


        /*TODO Задача№5*/
        //Суммировать все елементы коллекции
        //Input Parameters
        //List<Integer> numbers = asList(1, 2, 3, 4, 5);
        //Expected result
        //15

        List<Integer> numbers = asList(1, 2, 3, 4, 5);

        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
        //15


        /*TODO Задача №6*/
        //Получить имена всех людей, которым меньше 25 лет
        //Input parameters
        // Employee sara = new Employee("Sara", 19);
        //        Employee viktor = new Employee("Viktor", 40);
        //        Employee eva = new Employee("Eva", 42);
        //        Employee anna = new Employee("Anna", 20);
        //        List<Employee> collection = asList(sara, eva, viktor, anna);
        //Expected result
        //[Sara, Anna]

        Employee sara1 = new Employee("Sara", 19);
        Employee viktor1 = new Employee("Viktor", 40);
        Employee eva1 = new Employee("Eva", 42);
        Employee anna1 = new Employee("Anna", 20);
        List<Employee> collectionEmployees = asList(sara1, eva1, viktor1, anna1);

        List<String> employeesNotMobilized = collectionEmployees.stream().filter(employee -> employee.getAge() < 25)
                .map(Employee::getName).collect(Collectors.toList());
        System.out.println(employeesNotMobilized);
        //[Sara, Anna]



        /*TODO Задача №7*/
        //Get people statistics: average age, count, maximum age, minimum age and sum og all ages.
        //Получить статистику по людям: средний возраст, подсчитать колличество людей, максимальный возраст, минимальный возраст, суммировать все возраста
        //Input parameters
        //Employee sara = new Employee("Sara", 44);
        //    Employee viktor = new Employee("Viktor", 40);
        //    Employee eva = new Employee("Eva", 42);
        //    List<Employee> collection = asList(sara, eva, viktor);
        //IntStream summaryStatistics

        Employee sara3 = new Employee("Sara", 44);
        Employee viktor3 = new Employee("Viktor", 40);
        Employee eva3 = new Employee("Eva", 42);
        List<Employee> collectionEmployee3 = asList(sara3, eva3, viktor3);

        IntSummaryStatistics summaryStatistics = collectionEmployee3.stream().mapToInt(Employee::getAge).summaryStatistics();
        System.out.println(summaryStatistics.getAverage());
        System.out.println(summaryStatistics.getCount());
        System.out.println(summaryStatistics.getMax());
        System.out.println(summaryStatistics.getMin());
        System.out.println(summaryStatistics.getSum());
        //42.0
        //3
        //44
        //40
        //126

        /*TODO Задача №8*/
        //Группировать людей по национальности
        //Input parameters
        // Employee sara = new Employee("Sara", 4, "Norwegian");
        // Employee viktor = new Employee("Viktor", 40, "Serbian");
        // Employee eva = new Employee("Eva", 42, "Norwegian");

        Employee sara4 = new Employee("Sara", 4, "Norwegian");
        Employee viktor4 = new Employee("Viktor", 40, "Serbian");
        Employee eva4 = new Employee("Eva", 42, "Norwegian");

        List<Employee> collectionEmployee4 = asList(sara4, eva4, viktor4);
        System.out.println(collectionEmployee4.stream().collect(Collectors.groupingBy(Employee::getCountry)));
        //{Serbian=[Employee{name='Viktor', age=40}], Norwegian=[Employee{name='Sara', age=4}, Employee{name='Eva', age=42}]}



        /*TODO Задача №9*/
        //Вернуть имена людей разделив их запятой
        //Input parameters
        // Employee sara = new Employee("Sara", 4);
        //        Employee viktor = new Employee("Viktor", 40);
        //        Employee eva = new Employee("Eva", 42);
        //        List<Employee> collection = asList(sara, viktor, eva);
        //Expected result
        //Names: Sara, Viktor, Eva.

        Employee sara5 = new Employee("Sara", 4);
        Employee viktor5 = new Employee("Viktor", 40);
        Employee eva5 = new Employee("Eva", 42);
        List<Employee> collectionEmployees5 = asList(sara5, viktor5, eva5);

        System.out.println(collectionEmployees5.stream().map(Employee::getName).collect(Collectors.joining(", ")));
        //Sara, Viktor, Eva


        //Как вы думаете сколько операций будет сделано в данном примере? 4???
        //Employee employee = Stream.of(empIds)
        //      .map(employeeRepository::findById)
        //      .filter(e -> e != null)
        //      .filter(e -> e.getSalary() > 100000)
        //      .findFirst()
        //      .orElse(null);
        // Все зависит от того, будет ли у нас присутствовать искомый элемент в промежуточных операциях.
        // если элемента не будет, то дальше первого фильтра операции не пройдут.
        // если элемент будет подходить под все параметры, то операций будет 4.
    }
}
