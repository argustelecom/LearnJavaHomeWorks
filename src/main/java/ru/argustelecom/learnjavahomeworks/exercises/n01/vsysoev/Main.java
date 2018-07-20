package ru.argustelecom.learnjavahomeworks.exercises.n01.vsysoev;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Event;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Pair;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Main {

    public static <A extends Comparable<A>> String concatSorted(List<Pair<A, String>> list) {
        return list.stream()
                .sorted(Comparator.comparing(Pair::getFirst))
                .map(Pair::getSecond)
                .collect(Collectors.joining(","));
    }

    public static <A extends Number, B> void handle(Event<Pair<A, B>> event, BiConsumer<? super A, ? super B> consumer) {
        consumer.accept(event.getData().getFirst(), event.getData().getSecond());
    }
}