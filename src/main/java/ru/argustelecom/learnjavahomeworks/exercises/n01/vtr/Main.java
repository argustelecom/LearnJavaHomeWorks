package ru.argustelecom.learnjavahomeworks.exercises.n01.vtr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Pair;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Event;

public class Main {
    private static void print(String s, Integer l) { System.out.println(new String(new char[l]).replace('\0', ' ') + s); }
    private static void print(String s) { print(s, 0); }
    
    private static <T extends Pair<? extends Integer, ?>> String concatSorted(List<T> src) {
        final StringBuilder sb = new StringBuilder();
        src.stream()
                .sorted(Comparator.comparingInt(T::getFirst))
                .forEachOrdered(item -> { sb.append(item.getSecond() == null ? "[NULL]" : item.getSecond().toString()).append(','); } );
        return sb.length() == 0 ? "" : sb.deleteCharAt(sb.length() - 1).toString();
    }
    
    private static <F extends Number, S, E extends Event<? extends Pair<F, S>>> void handle(E event, BiConsumer<? super F, ? super S> consumer) {
        consumer.accept(event.getData().getFirst(), event.getData().getSecond());
    }
    
    private static void quest1() {
        print("Квест 1: отсортируй и собери");
        print(concatSorted(Arrays.asList(
                new Pair<>(2, "aa"),
                new Pair<>(1, "bb"),
                new Pair<>(5, 7),
                new Pair<>(4, null)
        )), 2);
    }
    
    private static void quest2() {
        print("Квест 2: типосплетения");
        Pair<Integer, String> p = new Pair<>(1, "bb");
        Pair<Double, String> p2 = new Pair<>(1.0, "bb");
        Pair<Boolean, String> p3 = new Pair<>(true, "bb");
        
        handle(new Event<>(p), (a, b) -> {print("case0 " + a.getClass().getName(), 2);});
        handle(new Event<>(p), (Object a, Object b) -> {print("case1 " + a.getClass().getName(), 2);});
        handle(new Event<>(p), (Object a, String b) -> {print("case2 " + a.getClass().getName(), 2);});
        handle(new Event<>(p), (Number a, Object b) -> {print("case3 " + a.getClass().getName(), 2);});
        handle(new Event<>(p), (Integer a, Object b) -> {print("case4 " + a.getClass().getName(), 2);});
        handle(new Event<>(p), (Integer a, String b) -> {print("case5 " + a.getClass().getName(), 2);});

        print("а дальше я перестал компилироваться", 2);
        /*
        handle(new Event<>(p2), (Integer a, String b) -> {});
        handle(new Event<>(p3), (a, b) -> {});
        */
    }
            
    public static void main(String[] args) {
        print("Exercise 01");
        quest1();
        quest2();
    }
}
