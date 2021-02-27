package ua.goit.online.stream.collector;

import ua.goit.online.stream.Student;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MinAndMaxCollector implements Collector<Student, MinAndMaxCollector.CustomAccumulator<Student>, MinAndMaxCollector.Pair<Student>> {

    private Comparator<Student> comparator;

    public MinAndMaxCollector(Comparator<Student> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Supplier<CustomAccumulator<Student>> supplier() {
        return () -> new CustomAccumulator<>(comparator);
    }

    @Override
    public BiConsumer<CustomAccumulator<Student>, Student> accumulator() {
        return CustomAccumulator::accumulate;
    }

    @Override
    public BinaryOperator<CustomAccumulator<Student>> combiner() {
        return CustomAccumulator::combine;
    }

    @Override
    public Function<MinAndMaxCollector.CustomAccumulator<Student>, MinAndMaxCollector.Pair<Student>> finisher() {
        return CustomAccumulator::toMinMaxPair;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }

    public static class CustomAccumulator<Student> {
        private final Comparator<Student> comparator;

        private Student min = null;
        private Student max = null;

        public CustomAccumulator(Comparator<Student> comparator) {
            this.comparator = comparator;
        }

        public void accumulate(Student other) {
            min = (min == null || comparator.compare(other, min) < 0) ? other : min;
            max = (max == null || comparator.compare(other, max) > 0) ? other : max;
        }

        public CustomAccumulator<Student> combine(CustomAccumulator<Student> other) {
            Pair<Student> otherPair = other.toMinMaxPair();
            otherPair.getMin().ifPresent(this::accumulate);
            otherPair.getMax().ifPresent(this::accumulate);
            return this;
        }

        public Pair<Student> toMinMaxPair() {
            return new Pair<Student>(min, max);
        }
    }

    public static class Pair<Student> {
        private final Optional<Student> min;
        private final Optional<Student> max;

        public Pair(Student min, Student max) {
            this.min = Optional.ofNullable(min);
            this.max = Optional.ofNullable(max);
        }

        public Optional<Student> getMin() {
            return min;
        }

        public Optional<Student> getMax() {
            return max;
        }
    }
}
