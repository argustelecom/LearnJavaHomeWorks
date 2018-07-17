package ru.argustelecom.learnjavahomeworks.exercises.n01.vo;

import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Arrays;
import ru.argustelecom.learnjavahomeworks.exercises.n01.model.*;

public class HW1_T1 {
    /*Написать метод concatSorted, принимающий список пар, склеивающий все значения second (можно использовать toString)
    в строку через запятую в порядке возрастания соответствующих им значений first.
    Вся операция должна быть описана в виде одного выражения с использованием Streams API.
    */
    public static String concatSorted(List<Pair<Integer , String>> list) {
        return list.stream().sorted(Comparator.comparing(Pair::getFirst)).map(Pair::getSecond).collect(Collectors.joining(","));
    }

    public static void main(String[] args) {

        Pair<Integer, String> p1 = new Pair<>(2, "bb");
        Pair<Integer, String> p2 = new Pair<>(1, "aa");

        System.out.println(concatSorted(Arrays.asList(p1, p2)));
        System.out.println(concatSorted(Arrays.asList(p2, p1)));
        System.out.println(concatSorted(Arrays.asList(p1)));
        System.out.println(concatSorted(Arrays.asList()));
    }
}
