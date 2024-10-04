package ua.goit.online.stream.exercise4_1;

import java.util.stream.Collectors;

public class Main {
    //4. Предоставлен список строк, нужно привести строки к числовому представлению и вернуть список чисел,
    // которые больше 10 или равняются 10, отсорированые в натуральном порядке.

    public static void main(String[] args) {
        System.out.println(new Exercise4().getList().stream().map(Integer::parseInt)
                .filter(number -> number >= 10)
                .sorted().collect(Collectors.toList()));
    // [10, 11, 15, 33]
    }
}
