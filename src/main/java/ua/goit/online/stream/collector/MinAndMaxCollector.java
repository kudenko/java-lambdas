package ua.goit.online.stream.collector;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class MinAndMaxCollector<T> implements Collector<T, MinAndMaxCollector.CustomAccumulator<T>, MinAndMaxCollector.Pair<T>> {

    private final Comparator<? super T> comparator;

    public MinAndMaxCollector(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    @Override
    public Supplier<CustomAccumulator<T>> supplier() {
        return () -> new CustomAccumulator<>(comparator);
    }

    @Override
    public BiConsumer<CustomAccumulator<T>, T> accumulator() {
        return CustomAccumulator::accumulate;
    }

    @Override
    public BinaryOperator<CustomAccumulator<T>> combiner() {
        return CustomAccumulator::combine;
    }

    @Override
    public Function<CustomAccumulator<T>, Pair<T>> finisher() {
        return CustomAccumulator::toMinMaxPair;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.emptySet();
    }

    public static class CustomAccumulator<T> {
        private final Comparator<? super T> comparator;

        private T min = null;
        private T max = null;

        public CustomAccumulator(Comparator<? super T> comparator) {
            this.comparator = comparator;
        }

        public void accumulate(T other) {
            min = (min == null || comparator.compare(other, min) < 0) ? other : min;
            max = (max == null || comparator.compare(other, max) > 0) ? other : max;
        }

        public CustomAccumulator<T> combine(CustomAccumulator<T> other) {
            Pair<T> otherPair = other.toMinMaxPair();
            otherPair.getMin().ifPresent(this::accumulate);
            otherPair.getMax().ifPresent(this::accumulate);
            return this;
        }

        public Pair<T> toMinMaxPair() {
            return new Pair<>(min, max);
        }
    }

    public static class Pair<T> {
        private final Optional<T> min;
        private final Optional<T> max;

        public Pair(T min, T max) {
            this.min = Optional.ofNullable(min);
            this.max = Optional.ofNullable(max);
        }

        public Optional<T> getMin() {
            return min;
        }

        public Optional<T> getMax() {
            return max;
        }
    }
}
