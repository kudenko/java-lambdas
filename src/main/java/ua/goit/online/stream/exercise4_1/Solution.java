package ua.goit.online.stream.exercise4_1;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Exercise4 exercise4 = new Exercise4();
        List<Integer> modified = collect(exercise4.getList());
        System.out.println(modified);
    }

    private static List<Integer> collect(List<String> input) {
        return input.stream()
                .map(Integer::parseInt)
                .filter(value -> value >= 10)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }
}
