package ru.argustelecom.learnjavahomeworks.exercises.n01.app;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Event;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 *
 * v.semchenko
 */
public class App 
{
    public static void main( String[] args )
    {
        Pair<Integer, String> p1 = new Pair<>(2, "bb");
        Pair<Integer, String> p2 = new Pair<>(1, "aa");

        System.out.println(concatSorted(Arrays.asList(p1, p2)));
        System.out.println(concatSorted(Arrays.asList(p2, p1)));
        System.out.println(concatSorted(Arrays.asList(p1)));
        System.out.println(concatSorted(Arrays.asList()));
    }

    private static String concatSorted(List<Pair<Integer,String>> list) {
        return list.stream().sorted(Comparator.comparing(p -> p.getFirst())).map(s -> s.getSecond()).collect(Collectors.joining(","));
    }

    public static <A extends Integer, B> void handle(Event<Pair<A,B>> event, BiConsumer<? super A, ? super B> consumer) {
        consumer.accept(event.getData().getFirst(), event.getData().getSecond());
    }
}


