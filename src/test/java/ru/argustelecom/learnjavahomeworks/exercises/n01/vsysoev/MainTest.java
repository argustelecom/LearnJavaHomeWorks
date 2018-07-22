package ru.argustelecom.learnjavahomeworks.exercises.n01.vsysoev;

import org.junit.Test;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Event;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.Pair;

import static java.util.Arrays.asList;

public class MainTest {

    @Test
    public void testConcatSorted() {
        Pair<Integer, String> p1 = new Pair<>(2, "bb");
        Pair<Integer, String> p2 = new Pair<>(1, "aa");

        System.out.println(Main.concatSorted(asList(p1, p2)));
        System.out.println(Main.concatSorted(asList(p2, p1)));
        System.out.println(Main.concatSorted(asList(p1)));
        System.out.println(Main.concatSorted(asList()));
    }

    @Test
    public void testHandle() {
        Pair<Integer, String> p = new Pair<>(1, "bb");

        //  следующие вызовы должны "сходиться" без ошибок
        Main.handle(new Event<>(p), (a, b) -> {});
        Main.handle(new Event<>(p), (Object a, Object b) -> {});
        Main.handle(new Event<>(p), (Object a, String b) -> {});
        Main.handle(new Event<>(p), (Number a, Object b) -> {});
        Main.handle(new Event<>(p), (Integer a, Object b) -> {});
        Main.handle(new Event<>(p), (Integer a, String b) -> {});

        Pair<Double, String> p2 = new Pair<>(1.0, "bb");
        //Main.handle(new Event<>(p2), (Integer a, String b) -> {});   // здесь должна быть ошибка так как получатель не может обработать Double

        Pair<Boolean, String> p3 = new Pair<>(true, "bb");
        //Main.handle(new Event<>(p3), (a, b) -> {});   // здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип
    }
}