package ru.argustelecom.learnjavahomeworks.exercises.n01.ak;

import ru.argustelecom.learnjavahomeworks.exercises.n01.model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author a.kovalev
 */
public class Main {

	public static void main(String[] args) {

		//1. Написать метод concatSorted
		System.out.println("1. Написать метод concatSorted");

		Pair<Integer, String> p1 = new Pair<>(2, "bb");
		Pair<Integer, String> p2 = new Pair<>(1, "aa");

		System.out.println(concatSorted(Arrays.asList(p1, p2)));
		System.out.println(concatSorted(Arrays.asList(p2, p1)));
		System.out.println(concatSorted(Arrays.asList(p1)));
		System.out.println(concatSorted(Arrays.asList()));
        //-------------------------------

		//2. Объявить метод handle
		System.out.println("2. Объявить метод handle");

		test();

	}

	private static void test() {
		Pair<Integer, String> p = new Pair<>(1, "bb");

		//  следующие вызовы должны "сходиться" без ошибок
		handle(new Event<>(p), (a, b) -> {System.out.println("1." + a.getClass().getName());});
		handle(new Event<>(p), (Object a, Object b) -> {System.out.println("2." + a.getClass().getName());});
		handle(new Event<>(p), (Object a, String b) -> {System.out.println("3." + a.getClass().getName());});
		handle(new Event<>(p), (Number a, Object b) -> {System.out.println("4." + a.getClass().getName());});
		handle(new Event<>(p), (Integer a, Object b) -> {System.out.println("5." + a.getClass().getName());});
		handle(new Event<>(p), (Integer a, String b) -> {System.out.println("6." + a.getClass().getName());});
/*
		Pair<Double, String> p2 = new Pair<>(1.0, "bb");
		handle(new Event<>(p2), (Integer a, String b) -> {System.out.print(a.getClass().getName());});   // здесь должна быть ошибка так как получатель не может обработать Double

		Pair<Boolean, String> p2 = new Pair<>(true, "bb");
		handle(new Event<>(p2), (a, b) -> {System.out.print(a.getClass().getName());});   // здесь должна быть ошибка так как первый параметр пары имеет нечисловой тип
*/
	}

	//1. Написать метод concatSorted,
	// принимающий список пар,
	// склеивающий все значения second (можно использовать toString)
	// в строку через запятую в порядке возрастания
	// соответствующих им значений first.
	//
	// Вся операция должна быть описана в виде одного выражения с использованием Streams API.
	public static String concatSorted(List<Pair<Integer, String>> input_list){
		StringBuilder res = new StringBuilder();

		/* 1
		input_list.sort(Comparator.comparing(Pair::getFirst));
		for (Pair item: input_list) {
			res.append(",");
			res.append(item.getSecond().toString());
		}
		if (!input_list.isEmpty()) {
			res.deleteCharAt(0);
		}
		return res.toString();
		*/
		/* 2
		input_list.stream().sorted(Comparator.comparing(Pair::getFirst)).forEachOrdered(item ->
																{res.append(res.length() > 0 ? "," : "").append(item.getSecond().toString());});
		return res.toString();
		*/
		/*3
		return input_list.stream().sorted(Comparator.comparing(Pair::getFirst))
					.collect(Collector.of(StringBuilder::new,
							              (stb, pair) -> {stb.append(stb.length() > 0 ? "," : "").append(pair.getSecond());},
							              (x, z) -> x, StringBuilder::toString));
		*/

		return String.join(",", input_list.stream().sorted(Comparator.comparing(Pair::getFirst))
				.map(Pair::getSecond).collect(Collectors.toList()));
	}

	//2. Объявить метод handle,
	// который принимает только события с парами,
	// у которых первое поле имеет численный тип.
	// Первый параметр метода - событие,
	// второй параметр - потребитель данных,
	//
	// java.util.function.BiConsumer,
	// который будет принимать компоненты пары.
	// В теле метода следует вызвать косьюмера с двумя параметрами,
	// извлечёнными из компонентов пары из события.
	//public <..... > void handle(Event<.....> event, BiConsumer<...> consumer) {
	//	consumer.accept(event.getData().getFirst(), event.getData().getSecond());

	public static <A extends Integer, B extends Object> void handle(Event<? extends Pair<A, B>> event,
			BiConsumer<? super A, ? super B> consumer) {
		consumer.accept(event.getData().getFirst(), event.getData().getSecond());
	}
}













































