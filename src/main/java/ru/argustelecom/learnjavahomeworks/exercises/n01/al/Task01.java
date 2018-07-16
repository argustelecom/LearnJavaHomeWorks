package ru.argustelecom.learnjavahomeworks.exercises.n01.al;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.*;
import java.util.List;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.Arrays;

public class Task01 {

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
