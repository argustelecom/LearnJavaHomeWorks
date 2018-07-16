package ru.argustelecom.learnjavahomeworks.exercises.n01.kk;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author k.koropovskiy
 */
public class Main {

	private static String concatSorted(List< Pair<Integer, String>> list){
		//1. посортировать по getFirst
		//3. вывести в виде строки getSecond

		//list.sort(Comparator.comparing(Pair::getFirst));
		//list.stream().sorted(Comparator.comparing(Pair::getFirst)).toArray().toString();
		return list.
				stream().
				sorted(Comparator.comparing(Pair::getFirst)).
				collect(Collector.of(ArrayList<String>::new,
						(s, p) -> { s.add(p.getSecond()); },
						(s1, s2) -> { s1.addAll(s2); return s1; },
						ArrayList<String>::toString)).replace("[","").replace("]","");
// вернет [aa, bb] <-- как избавиться от []
/*				collect(Collector.of(StringBuilder::new,
						(s, p) -> s.append(p.getSecond()).append(","),
						(s1, s2) -> s1.append(s2),
				StringBuilder::toString));
// вернет aa,bb, <-- как избавиться от последней запятой - неясно
*/
	}

	private static void challenge1(){

		Pair<Integer, String> p1 = new Pair<>(2, "bb");
		Pair<Integer, String> p2 = new Pair<>(1, "aa");

		System.out.println(concatSorted(Arrays.asList(p1, p2)));
		System.out.println(concatSorted(Arrays.asList(p2, p1)));
		System.out.println(concatSorted(Arrays.asList(p1)));
		System.out.println(concatSorted(Arrays.asList()));

	}

	public static void main(String[] args) {
		challenge1();
	}

}
